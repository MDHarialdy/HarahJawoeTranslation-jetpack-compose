package com.saintek.mdh.harahjawoetranslation.data.injection

import android.content.Context
import com.saintek.mdh.harahjawoetranslation.data.database.AppDatabase
import com.saintek.mdh.harahjawoetranslation.data.preferences.AppPref
import com.saintek.mdh.harahjawoetranslation.data.repository.AppRepository
import kotlinx.coroutines.runBlocking

object DataInjection {
    fun provideRepository(context: Context): AppRepository = runBlocking{
        val appDatabase = AppDatabase.getDatabase(context)
        val appPref = AppPref.getInstance(context)
        AppRepository.getInstance(appDatabase.appDao(), appPref)
    }
}