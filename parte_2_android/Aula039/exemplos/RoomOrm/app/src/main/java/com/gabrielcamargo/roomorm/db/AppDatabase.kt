package com.gabrielcamargo.roomorm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gabrielcamargo.roomorm.cartao.entity.CartaoEntity

@Database(
    entities = [
        CartaoEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
}