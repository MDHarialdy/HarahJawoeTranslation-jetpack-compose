package com.saintek.mdh.harahjawoetranslation.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecordEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val historyId: Int,
    val imageByteArray: ByteArray,
    val result: String,
    val accuration: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RecordEntity

        if (id != other.id) return false
        if (!imageByteArray.contentEquals(other.imageByteArray)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + imageByteArray.contentHashCode()
        return result
    }
}