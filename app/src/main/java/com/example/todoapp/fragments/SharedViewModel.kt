package com.example.todoapp.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.todoapp.database.models.Priority

class SharedViewModel(application: Application) : AndroidViewModel(application) {
    fun verifyDataFromUser(title: String, description: String): Boolean {
        return title.isNotEmpty() && description.isNotEmpty()
    }

    fun parsePriority(priority: String): Priority {
        return when (priority) {
            "High Priority" -> {
                Priority.High
            }
            "Medium Priority" -> {
                Priority.Medium
            }
            "Low Priority" -> {
                Priority.Low
            }
            else -> Priority.Low
        }

    }

}