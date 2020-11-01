package com.example.todoapp.database.repository

import androidx.lifecycle.LiveData
import com.example.todoapp.database.ToDoDao
import com.example.todoapp.database.models.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {
    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData) {
        toDoDao.insertData(toDoData)
    }
}