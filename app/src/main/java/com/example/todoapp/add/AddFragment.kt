package com.example.todoapp.add

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.database.models.Priority
import com.example.todoapp.database.models.ToDoData
import com.example.todoapp.database.viewmodel.ToDoViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import androidx.fragment.app.viewModels as viewModels


class AddFragment : Fragment() {

    private val mToDoViewModel: ToDoViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menuAdd) {
            insertDataToDB()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDB() {
        val mTitle = addTitleEt.text.toString()
        val mPriority = addPrioritySpinner.selectedItem.toString()
        val mDescription = addDescriptionEt.text.toString()

        val validation = verifyDataFromUser(mTitle, mDescription)
        if (validation) {
            val newData = ToDoData(
                id = 0,
                title = mTitle,
                description = mDescription,
                priority = parsePriority(mPriority)
            )
            mToDoViewModel?.insertData(newData)
            Toast.makeText(
                requireContext(),
                "Successfully added!",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        } else {
            Toast.makeText(
                requireContext(),
                "please insert Title and description",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun verifyDataFromUser(title: String, description: String): Boolean {
        return title.isNotEmpty() && description.isNotEmpty()
    }

    private fun parsePriority(priority: String): Priority {
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
