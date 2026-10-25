package com.example.data

import android.content.Context
import android.content.SharedPreferences
import com.example.model.ConfessionItem
import com.example.model.HandOfGodEntry
import org.json.JSONArray
import org.json.JSONObject

class UserPreferences(context: Context) {

  private val prefs: SharedPreferences =
    context.getSharedPreferences("dios_te_dice_prefs", Context.MODE_PRIVATE)

  companion object {
    private const val KEY_FAVORITE_VERSES = "fav_verses"
    private const val KEY_FAVORITE_PRAYERS = "fav_prayers"
    private const val KEY_NOTIF_ENABLED = "notif_enabled"
    private const val KEY_NOTIF_HOUR = "notif_hour"
    private const val KEY_NOTIF_MINUTE = "notif_minute"
    private const val KEY_LAST_FREE_WILL_VERSE = "last_free_will_verse"
    private const val KEY_PETITIONS = "user_petitions"

    // Night review ("La Mano de Dios")
    private const val KEY_NIGHT_NOTIF_ENABLED = "night_notif_enabled"
    private const val KEY_NIGHT_NOTIF_HOUR = "night_notif_hour"
    private const val KEY_NIGHT_NOTIF_MINUTE = "night_notif_minute"

    // Confession & Hand of God entries
    private const val KEY_CONFESSION_ITEMS = "confession_items_json"
    private const val KEY_HAND_OF_GOD_ENTRIES = "hand_of_god_entries_json"

    // Theme Mode
    const val THEME_SYSTEM = "system"
    const val THEME_LIGHT = "light"
    const val THEME_DARK = "dark"
    private const val KEY_THEME_MODE = "theme_mode"

    // Security & App Lock (PIN & Biometric)
    private const val KEY_APP_LOCK_ENABLED = "app_lock_enabled"
    private const val KEY_PIN_HASH = "pin_hash"
    private const val KEY_PIN_SALT = "pin_salt"
    private const val KEY_BIOMETRIC_ENABLED = "biometric_enabled"
    private const val KEY_FONT_SIZE = "font_size"
    private const val KEY_BIBLE_VERSION = "bible_version"
    private const val KEY_INSTALLED_VERSIONS = "installed_versions"
  }

  // --- Bible Version ---
  fun getBibleVersion(): String {
    return prefs.getString(KEY_BIBLE_VERSION, "DHHED") ?: "DHHED"
  }

  fun setBibleVersion(version: String) {
    prefs.edit().putString(KEY_BIBLE_VERSION, version).apply()
  }

  fun getInstalledVersions(): Set<String> {
    return prefs.getStringSet(KEY_INSTALLED_VERSIONS, setOf("DHHED")) ?: setOf("DHHED")
  }

  fun addInstalledVersion(version: String) {
    val current = getInstalledVersions().toMutableSet()
    current.add(version)
    prefs.edit().putStringSet(KEY_INSTALLED_VERSIONS, current).apply()
  }

  // --- App Lock & Security ---
  fun isAppLockEnabled(): Boolean {
    return prefs.getBoolean(KEY_APP_LOCK_ENABLED, false) && hasPinSet()
  }

  fun setAppLockEnabled(enabled: Boolean) {
    prefs.edit().putBoolean(KEY_APP_LOCK_ENABLED, enabled).apply()
  }

  fun hasPinSet(): Boolean {
    return prefs.getString(KEY_PIN_HASH, null) != null
  }

  private fun hashPinWithSalt(pin: String, salt: String): String {
    val md = java.security.MessageDigest.getInstance("SHA-256")
    val bytes = md.digest("$salt:$pin".toByteArray(Charsets.UTF_8))
    return bytes.joinToString("") { "%02x".format(it) }
  }

  fun setPin(pin: String) {
    val salt = java.util.UUID.randomUUID().toString()
    val hashed = hashPinWithSalt(pin, salt)
    prefs.edit()
      .putString(KEY_PIN_SALT, salt)
      .putString(KEY_PIN_HASH, hashed)
      .putBoolean(KEY_APP_LOCK_ENABLED, true)
      .apply()
  }

  fun verifyPin(pin: String): Boolean {
    val salt = prefs.getString(KEY_PIN_SALT, null) ?: return false
    val storedHash = prefs.getString(KEY_PIN_HASH, null) ?: return false
    return hashPinWithSalt(pin, salt) == storedHash
  }

  fun removePin() {
    prefs.edit()
      .remove(KEY_PIN_HASH)
      .remove(KEY_PIN_SALT)
      .putBoolean(KEY_APP_LOCK_ENABLED, false)
      .apply()
  }

  fun isBiometricEnabled(): Boolean {
    return prefs.getBoolean(KEY_BIOMETRIC_ENABLED, true)
  }

  fun setBiometricEnabled(enabled: Boolean) {
    prefs.edit().putBoolean(KEY_BIOMETRIC_ENABLED, enabled).apply()
  }

  fun getFontSize(): Float {
    return prefs.getFloat(KEY_FONT_SIZE, 16f)
  }

  fun setFontSize(size: Float) {
    prefs.edit().putFloat(KEY_FONT_SIZE, size).apply()
  }

  // --- Theme Mode ---
  fun getThemeMode(): String {
    return prefs.getString(KEY_THEME_MODE, THEME_SYSTEM) ?: THEME_SYSTEM
  }

  fun setThemeMode(mode: String) {
    prefs.edit().putString(KEY_THEME_MODE, mode).apply()
  }

  // --- Favorite Verses ---
  fun getFavoriteVerses(): Set<String> {
    return prefs.getStringSet(KEY_FAVORITE_VERSES, emptySet()) ?: emptySet()
  }

  fun toggleFavoriteVerse(verseId: String): Boolean {
    val current = getFavoriteVerses().toMutableSet()
    val isNowFavorite = if (current.contains(verseId)) {
      current.remove(verseId)
      false
    } else {
      current.add(verseId)
      true
    }
    prefs.edit().putStringSet(KEY_FAVORITE_VERSES, current).apply()
    return isNowFavorite
  }

  fun isVerseFavorite(verseId: String): Boolean {
    return getFavoriteVerses().contains(verseId)
  }

  // --- Favorite Prayers ---
  fun getFavoritePrayers(): Set<String> {
    return prefs.getStringSet(KEY_FAVORITE_PRAYERS, emptySet()) ?: emptySet()
  }

  fun toggleFavoritePrayer(prayerId: String): Boolean {
    val current = getFavoritePrayers().toMutableSet()
    val isNowFavorite = if (current.contains(prayerId)) {
      current.remove(prayerId)
      false
    } else {
      current.add(prayerId)
      true
    }
    prefs.edit().putStringSet(KEY_FAVORITE_PRAYERS, current).apply()
    return isNowFavorite
  }

  fun isPrayerFavorite(prayerId: String): Boolean {
    return getFavoritePrayers().contains(prayerId)
  }

  // --- Morning "Dios Te Dice Hoy" Notification ---
  fun isNotificationEnabled(): Boolean {
    return prefs.getBoolean(KEY_NOTIF_ENABLED, true)
  }

  fun setNotificationEnabled(enabled: Boolean) {
    prefs.edit().putBoolean(KEY_NOTIF_ENABLED, enabled).apply()
  }

  fun getNotificationHour(): Int {
    return prefs.getInt(KEY_NOTIF_HOUR, 8) // 8:00 AM default
  }

  fun getNotificationMinute(): Int {
    return prefs.getInt(KEY_NOTIF_MINUTE, 0)
  }

  fun setNotificationTime(hour: Int, minute: Int) {
    prefs.edit()
      .putInt(KEY_NOTIF_HOUR, hour)
      .putInt(KEY_NOTIF_MINUTE, minute)
      .apply()
  }

  // --- Night "La Mano de Dios" Notification ---
  fun isNightNotificationEnabled(): Boolean {
    return prefs.getBoolean(KEY_NIGHT_NOTIF_ENABLED, true)
  }

  fun setNightNotificationEnabled(enabled: Boolean) {
    prefs.edit().putBoolean(KEY_NIGHT_NOTIF_ENABLED, enabled).apply()
  }

  fun getNightNotificationHour(): Int {
    return prefs.getInt(KEY_NIGHT_NOTIF_HOUR, 21) // 9:30 PM default
  }

  fun getNightNotificationMinute(): Int {
    return prefs.getInt(KEY_NIGHT_NOTIF_MINUTE, 30)
  }

  fun setNightNotificationTime(hour: Int, minute: Int) {
    prefs.edit()
      .putInt(KEY_NIGHT_NOTIF_HOUR, hour)
      .putInt(KEY_NIGHT_NOTIF_MINUTE, minute)
      .apply()
  }

  // --- Last Free Will Verse ---
  fun getLastFreeWillVerseId(): String? {
    return prefs.getString(KEY_LAST_FREE_WILL_VERSE, null)
  }

  fun setLastFreeWillVerseId(verseId: String) {
    prefs.edit().putString(KEY_LAST_FREE_WILL_VERSE, verseId).apply()
  }

  // --- Petitions ---
  fun getPetitions(): List<String> {
    val set = prefs.getStringSet(KEY_PETITIONS, emptySet()) ?: emptySet()
    return set.toList()
  }

  fun addPetition(petition: String) {
    val trimmed = petition.trim()
    if (trimmed.isEmpty()) return
    val current = getPetitions().toMutableSet()
    current.add(trimmed)
    prefs.edit().putStringSet(KEY_PETITIONS, current).apply()
  }

  fun removePetition(petition: String) {
    val current = getPetitions().toMutableSet()
    current.remove(petition)
    prefs.edit().putStringSet(KEY_PETITIONS, current).apply()
  }

  // --- Confession Items (Diario de Confesión) ---
  fun getConfessionItems(): List<ConfessionItem> {
    val jsonStr = prefs.getString(KEY_CONFESSION_ITEMS, null) ?: return emptyList()
    return try {
      val array = JSONArray(jsonStr)
      val list = mutableListOf<ConfessionItem>()
      for (i in 0 until array.length()) {
        val obj = array.getJSONObject(i)
        list.add(
          ConfessionItem(
            id = obj.getString("id"),
            text = obj.getString("text"),
            category = obj.optString("category", "Falta"),
            isConfessed = obj.optBoolean("isConfessed", false),
            dateAdded = obj.optString("dateAdded", "")
          )
        )
      }
      list
    } catch (_: Exception) {
      emptyList()
    }
  }

  fun saveConfessionItems(items: List<ConfessionItem>) {
    val array = JSONArray()
    for (item in items) {
      val obj = JSONObject().apply {
        put("id", item.id)
        put("text", item.text)
        put("category", item.category)
        put("isConfessed", item.isConfessed)
        put("dateAdded", item.dateAdded)
      }
      array.put(obj)
    }
    prefs.edit().putString(KEY_CONFESSION_ITEMS, array.toString()).apply()
  }

  fun addConfessionItem(item: ConfessionItem) {
    val current = getConfessionItems().toMutableList()
    current.add(0, item)
    saveConfessionItems(current)
  }

  fun toggleConfessionItem(id: String) {
    val current = getConfessionItems().map {
      if (it.id == id) it.copy(isConfessed = !it.isConfessed) else it
    }
    saveConfessionItems(current)
  }

  fun removeConfessionItem(id: String) {
    val current = getConfessionItems().filter { it.id != id }
    saveConfessionItems(current)
  }

  fun clearAbsolvedConfessions() {
    val current = getConfessionItems().filter { !it.isConfessed }
    saveConfessionItems(current)
  }

  // --- Hand of God (La Mano de Dios) Entries ---
  fun getHandOfGodEntries(): List<HandOfGodEntry> {
    val jsonStr = prefs.getString(KEY_HAND_OF_GOD_ENTRIES, null) ?: return emptyList()
    return try {
      val array = JSONArray(jsonStr)
      val list = mutableListOf<HandOfGodEntry>()
      for (i in 0 until array.length()) {
        val obj = array.getJSONObject(i)
        list.add(
          HandOfGodEntry(
            id = obj.getString("id"),
            date = obj.getString("date"),
            text = obj.getString("text"),
            category = obj.optString("category", "Providencia")
          )
        )
      }
      list
    } catch (_: Exception) {
      emptyList()
    }
  }

  fun saveHandOfGodEntries(entries: List<HandOfGodEntry>) {
    val array = JSONArray()
    for (entry in entries) {
      val obj = JSONObject().apply {
        put("id", entry.id)
        put("date", entry.date)
        put("text", entry.text)
        put("category", entry.category)
      }
      array.put(obj)
    }
    prefs.edit().putString(KEY_HAND_OF_GOD_ENTRIES, array.toString()).apply()
  }

  fun addHandOfGodEntry(entry: HandOfGodEntry) {
    val current = getHandOfGodEntries().toMutableList()
    current.add(0, entry)
    saveHandOfGodEntries(current)
  }

  fun removeHandOfGodEntry(id: String) {
    val current = getHandOfGodEntries().filter { it.id != id }
    saveHandOfGodEntries(current)
  }
}
