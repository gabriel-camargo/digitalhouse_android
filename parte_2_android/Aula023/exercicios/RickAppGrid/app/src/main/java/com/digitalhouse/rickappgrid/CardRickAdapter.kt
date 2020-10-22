package com.digitalhouse.rickappgrid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickappgrid.api.Personagem
import com.squareup.picasso.Picasso

class CardRickAdapter(private val dataSet: List<Personagem>, private val clickListener: (Personagem) -> Unit):
    RecyclerView.Adapter<CardRickAdapter.MyViewHolder>() {

    //mapeia os elementos xml
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val imgView: ImageView = view.findViewById(R.id.imagem)
        private val txtName: TextView = view.findViewById(R.id.txtName)

        fun bind(personagem: Personagem) {
            Picasso.get()
                .load(personagem.imagemUrl)
                .into(imgView)

            txtName.text = personagem.nome
        }
    }

    //infla o xml (a linha)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardRickAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rick_item,parent,false)

        return MyViewHolder(view)
    }

    // chamado a cada item do dataset
    override fun onBindViewHolder(holder: CardRickAdapter.MyViewHolder, position: Int) {
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener{clickListener(dataSet[position])}
    }

    // qtd de itens do dataset
    override fun getItemCount()=dataSet.size
}