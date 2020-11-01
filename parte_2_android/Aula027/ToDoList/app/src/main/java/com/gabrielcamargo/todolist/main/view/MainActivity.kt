package com.gabrielcamargo.todolist.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gabrielcamargo.todolist.R

class MainActivity : AppCompatActivity() {

    private val toDoListFragment = ToDoListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frmLayout_main, toDoListFragment)
            .commit()
    }
}