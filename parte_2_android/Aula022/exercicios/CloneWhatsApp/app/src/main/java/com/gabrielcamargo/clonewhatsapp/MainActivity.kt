package com.gabrielcamargo.clonewhatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.conversationList)
        val viewAdapter = ChatAdapter(arrayListOf(
            ChatItem("Pessoa 1", "11:00", "Opa, conversa 1"),
            ChatItem("sla bixo", "12:00", "Opa, conversa 2"),
            ChatItem("Cebolinha", "21:00", "Opa, conversa 5"),
            ChatItem("William Bonner", "00:02", "Opa, conversa 4"),
            ChatItem("Pessoa 1", "11:00", "Opa, conversa 1"),
            ChatItem("sla bixo", "12:00", "Opa, conversa 2"),
            ChatItem("Cebolinha", "21:00", "Opa, conversa 5"),
            ChatItem("William Bonner", "00:02", "Opa, conversa 4"),
            ChatItem("Pessoa 1", "11:00", "Opa, conversa 1"),
            ChatItem("sla bixo", "12:00", "Opa, conversa 2"),
            ChatItem("Cebolinha", "21:00", "Opa, conversa 5"),
            ChatItem("William Bonner", "00:02", "Opa, conversa 4"),
            ChatItem("Pessoa 1", "11:00", "Opa, conversa 1"),
            ChatItem("sla bixo", "12:00", "Opa, conversa 2"),
            ChatItem("Cebolinha", "21:00", "Opa, conversa 5"),
            ChatItem("William Bonner", "00:02", "Opa, conversa 4"),
        ))

        recyclerView.apply {
            setHasFixedSize(true) //dizer que os elementos não são dinamicos

            layoutManager = viewManager
            adapter = viewAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}