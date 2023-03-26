package com.aold.core_db.settings

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aold.core.core.common.Mapper

/**
 * @author Kirilin Yury on 27.02.2023.
 */

@Entity(tableName = "settings")
data class SettingsModel(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "language")
    val language: String,
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "defualt_category")
    val defualtCategory: String
) {
    fun <O> map(mapper: Mapper<SettingsModel, O>) = mapper.map(this)
}