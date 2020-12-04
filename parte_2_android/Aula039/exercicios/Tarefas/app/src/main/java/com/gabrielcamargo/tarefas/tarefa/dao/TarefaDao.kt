package com.gabrielcamargo.tarefas.tarefa.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gabrielcamargo.tarefas.tarefa.entity.TarefaEntity

@Dao
interface TarefaDao {
    @Insert
    suspend fun addTarefa(tarefa: TarefaEntity)

    @Query("SELECT COUNT(*) FROM Tarefa")
    suspend fun count(): Int
}