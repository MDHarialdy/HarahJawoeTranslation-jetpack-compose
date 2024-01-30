package com.saintek.mdh.harahjawoetranslation.data.repository

import com.saintek.mdh.harahjawoetranslation.data.database.AppDao
import com.saintek.mdh.harahjawoetranslation.data.database.HistoryEntity
import com.saintek.mdh.harahjawoetranslation.data.preferences.AppPref

class AppRepository private constructor(
    private val appDao: AppDao,
    private val appPref: AppPref

){

    suspend fun insertHistory(history: HistoryEntity) = appDao.insertHistory(history)

    fun getHistory(imageId: Int) = appDao.getHistory(imageId)

    fun checkIsFirstTimeLaunch(): Boolean {
        return appPref.isFirstTimeLaunch
    }

    fun setFirstTimeLaunchToFalse() {
        appPref.isFirstTimeLaunch = false
    }

    companion object {
        @Volatile
        private var INSTANCE: AppRepository? = null

        fun getInstance(
            appDao: AppDao,
            appPref: AppPref
        ): AppRepository =
            INSTANCE ?: synchronized(this){
                INSTANCE?: AppRepository(appDao, appPref)
            }.also { INSTANCE = it}
    }
}