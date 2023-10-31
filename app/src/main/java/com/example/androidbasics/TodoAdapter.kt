package com.example.androidbasics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbasics.databinding.ItemTodoBinding

class TodoAdapter(
    private var todos: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        with(holder) {
            with(todos[position]) {
                binding.tvTitle.text = this.title
                binding.cbDone.isChecked = this.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}