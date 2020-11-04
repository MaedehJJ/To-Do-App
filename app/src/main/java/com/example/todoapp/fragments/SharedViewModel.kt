package com.example.todoapp.fragments

import android.app.Application
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import com.example.todoapp.R
import com.example.todoapp.database.models.Priority

class SharedViewModel(application: Application) : AndroidViewModel(application) {
    val listener: AdapterView.OnItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when (position) {
                0 -> {
                    (parent?.getChildAt(0) as TextView).setTextColor(
                        ContextCompat.getColor(
                            application,
                            R.color.red
                        )
                    )
                }
                1 -> {
                    (parent?.getChildAt(1) as TextView).setTextColor(
                        ContextCompat.getColor(
                            application,
                            R.color.yellow
                        )
                    )
                }
                2 -> {
                    (parent?.getChildAt(0) as TextView).setTextColor(
                        ContextCompat.getColor(
                            application,
                            R.color.green
                        )
                    )
                }
            }
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

    }

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