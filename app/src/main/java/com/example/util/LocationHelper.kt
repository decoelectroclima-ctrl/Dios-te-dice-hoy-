package com.example.util

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import androidx.core.content.ContextCompat

object LocationHelper {

  fun hasLocationPermission(context: Context): Boolean {
    val fineGranted = ContextCompat.checkSelfPermission(
      context,
      Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    val coarseGranted = ContextCompat.checkSelfPermission(
      context,
      Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    return fineGranted || coarseGranted
  }

  @SuppressLint("MissingPermission")
  fun getLastKnownLocation(context: Context): Pair<Double, Double>? {
    if (!hasLocationPermission(context)) return null

    return try {
      val locationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as? LocationManager ?: return null

      val gpsLocation = try {
        locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
      } catch (_: Throwable) {
        null
      }

      val networkLocation = try {
        locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
      } catch (_: Throwable) {
        null
      }

      val passiveLocation = try {
        locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)
      } catch (_: Throwable) {
        null
      }

      val bestLocation: Location? = listOfNotNull(gpsLocation, networkLocation, passiveLocation)
        .maxByOrNull { it.time }

      bestLocation?.let { Pair(it.latitude, it.longitude) }
    } catch (_: Throwable) {
      null
    }
  }

  @SuppressLint("MissingPermission")
  fun requestSingleLocationUpdate(
    context: Context,
    onLocationReceived: (Pair<Double, Double>) -> Unit
  ) {
    if (!hasLocationPermission(context)) return

    try {
      val locationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as? LocationManager ?: return

      // Use last known immediately if fresh enough
      val lastKnown = getLastKnownLocation(context)
      if (lastKnown != null) {
        onLocationReceived(lastKnown)
      }

      val provider = when {
        locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) -> LocationManager.NETWORK_PROVIDER
        locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) -> LocationManager.GPS_PROVIDER
        else -> null
      } ?: return

      val listener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
          try {
            onLocationReceived(Pair(location.latitude, location.longitude))
            locationManager.removeUpdates(this)
          } catch (_: Throwable) {}
        }
        @Deprecated("Deprecated in Java")
        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
      }

      locationManager.requestSingleUpdate(provider, listener, Looper.getMainLooper())
    } catch (_: Throwable) {}
  }
}
