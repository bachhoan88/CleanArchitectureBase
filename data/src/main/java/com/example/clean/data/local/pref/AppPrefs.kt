package com.example.clean.data.local.pref

import android.content.Context
import androidx.core.content.edit

class AppPrefs constructor(
        context: Context
) : PrefHelper {
    companion object {
        private const val FIRST_RUN = "first_run";
    }

    var sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    override fun isFirstRun(): Boolean {
        val first = sharedPreferences.getBoolean(FIRST_RUN, true)
        if (first) {
            sharedPreferences.edit { putBoolean(FIRST_RUN, false) }
        }

        return first
    }

}