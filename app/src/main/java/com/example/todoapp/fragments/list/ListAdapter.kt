package com.example.todoapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.database.models.Priority
import com.example.todoapp.database.models.ToDoData
import kotlinx.android.synthetic.main.row_list.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    var dataList = ArrayList<ToDoData>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.titleTxt.text = dataList[position].title
        holder.itemView.descriptionTxt.text = dataList[position].description

        when (dataList[position].priority) {
            Priority.High -> {
                holder.itemView.priorityIndicator.setCardBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.red
                    )

                )
            }
            Priority.Medium -> holder.itemView.priorityIndicator.setCardBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.yellow
                )
            )
            Priority.Low -> holder.itemView.priorityIndicator.setCardBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.green
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(toDoData: List<ToDoData>) {
        this.dataList = toDoData as ArrayList
        this.notifyDataSetChanged()
    }

}


