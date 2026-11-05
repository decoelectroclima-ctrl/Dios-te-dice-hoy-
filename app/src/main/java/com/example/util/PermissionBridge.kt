package com.example.util

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

object PermissionBridge {
  const val REQUEST_CODE = 4242 // siempre dentro de 16 bits
  private var pending: ((Map<String, Boolean>) -> Unit)? = null

  fun request(activity: Activity, permissions: Array<String>, callback: (Map<String, Boolean>) -> Unit) {
    pending = callback
    ActivityCompat.requestPermissions(activity, permissions, REQUEST_CODE)
  }

  fun onResult(permissions: Array<out String>, grantResults: IntArray) {
    val result = permissions.indices.associate { i ->
      permissions[i] to (grantResults[i] == PackageManager.PERMISSION_GRANTED)
    }
    pending?.invoke(result)
    pending = null
  }
}
