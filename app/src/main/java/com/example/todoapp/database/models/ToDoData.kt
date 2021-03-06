package com.example.todoapp.database.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todoapp.database.models.Priority
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "todo_table")
data class ToDoData(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "Title") var title: String,
    @ColumnInfo(name = "Priority") var priority: Priority,
    @ColumnInfo(name = "Description") var description: String
): Parcelable