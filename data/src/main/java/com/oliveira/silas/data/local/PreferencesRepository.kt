package com.oliveira.silas.data.local

import android.content.SharedPreferences
import com.oliveira.silas.domain.Preferences
import io.reactivex.Completable

class PreferencesRepository(val sharedPreferences: SharedPreferences) : Preferences {
    companion object {
        const val NUMBER_PAGES = "number_pages"
    }
    override fun getNumberPages(): Int {

        return Int.MAX_VALUE
    }

    override fun saveNumberPages(numberPages : Int): Completable {
        with(sharedPreferences.edit()) {
            putInt(NUMBER_PAGES, numberPages)
            apply()

            return Completable.complete()
        }
    }
}