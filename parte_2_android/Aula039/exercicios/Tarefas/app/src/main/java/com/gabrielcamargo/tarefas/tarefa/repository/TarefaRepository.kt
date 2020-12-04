package com.gabrielcamargo.tarefas.tarefa.repository

import com.gabrielcamargo.tarefas.tarefa.dao.TarefaDao
import com.gabrielcamargo.tarefas.tarefa.entity.TarefaEntity

class TarefaRepository(private val tarefaDao: TarefaDao) {

    suspend fun addTarefa(tarefa: TarefaEntity)= tarefaDao.addTarefa(tarefa)
    suspend fun count() = tarefaDao.count()

}
