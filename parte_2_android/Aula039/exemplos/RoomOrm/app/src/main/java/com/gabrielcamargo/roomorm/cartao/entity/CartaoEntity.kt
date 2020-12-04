package com.gabrielcamargo.roomorm.cartao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cartao")
data class CartaoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo
    var numero: Int,
    @ColumnInfo
    var titular :String,
    @ColumnInfo
    var cvv: String,
    @ColumnInfo
    var validade: String,
    @ColumnInfo
    var bandeira: String
)
