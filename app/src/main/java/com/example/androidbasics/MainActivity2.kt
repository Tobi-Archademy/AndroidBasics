package com.example.androidbasics

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidbasics.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var todoList = mutableListOf(
            Todo("Pray", false),
            Todo("Workout and Core Exercise", false),
            Todo("Daily StandUp Call", false),
            Todo("Listen to Sports News", true),
            Todo("Have Brunch", false),
            Todo("Work on Sprint Tasks", false),
            Todo("Study/Learn new Android Courses", false),
            Todo("Take a Shower", true),
            Todo("Take a Stroll", false)
        )

        val adapter = TodoAdapter(todoList)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.btnTodo.setOnClickListener {
            // takes the added text from the editText
            val title = binding.etTodo.text.toString()
            // Add the text to the Todo data class
            val todo = Todo(title, false)
            //Add the newly added Todo data class to the todos list
            todoList.add(todo )

            // notifies the adapter that a new item has been added to the List
            adapter.notifyItemInserted(todoList.size - 1)
        }







//        val customList = listOf("First", "Second", "Third", "Fourth")
//        val adapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, customList)
//        binding.spMonths.adapter = adapter
//
//        binding.spMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                Toast.makeText(this@MainActivity2,
//                    "You selected ${parent?.getItemAtPosition(position)}",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//
//        }
//
////        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person
//
//        binding.btnBack.setOnClickListener {
//            Intent(this, SecondActivity::class.java).also {
//                startActivity(it)
//            }
//        }
    }
}