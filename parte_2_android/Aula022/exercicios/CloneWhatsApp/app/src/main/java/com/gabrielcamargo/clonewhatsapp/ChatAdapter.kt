package com.gabrielcamargo.clonewhatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val dataSet: List<ChatItem>):
    RecyclerView.Adapter<ChatAdapter.MyViewHolder>() {

    //mapeia os elementos xml
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val txtName: TextView = view.findViewById(R.id.txtName)
        private val txtHorario: TextView = view.findViewById(R.id.txtHorario)
        private val txtChat: TextView = view.findViewById(R.id.txtChat)

        fun bind(chatItem: ChatItem) {
            txtName.text = chatItem.nome
            txtHorario.text = chatItem.horario
            txtChat.text = chatItem.chat
        }
    }

    //infla o xml (a linha)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item,parent,false)

        return MyViewHolder(view)
    }

    // chamado a cada item do dataset
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    // qtd de itens do dataset
    override fun getItemCount()=dataSet.size
}