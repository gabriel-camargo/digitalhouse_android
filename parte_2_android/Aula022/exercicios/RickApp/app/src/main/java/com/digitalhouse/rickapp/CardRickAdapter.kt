package com.digitalhouse.rickapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.Personagem
import com.squareup.picasso.Picasso

class CardRickAdapter(private val dataSet: List<Personagem>):
    RecyclerView.Adapter<CardRickAdapter.MyViewHolder>() {

    //mapeia os elementos xml
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val imgView: ImageView = view.findViewById(R.id.imagem)
        private val txtNome: TextView = view.findViewById(R.id.txtNome)
        private val txtStatus: TextView = view.findViewById(R.id.txtStatus)
        private val txtEspecie: TextView = view.findViewById(R.id.txtEspecie)
        private val txtLocalizacao: TextView = view.findViewById(R.id.txtLocalizacao)

        fun bind(personagem: Personagem) {
            Picasso.get()
                .load(personagem.imagemUrl)
                .into(imgView)

            txtNome.text = personagem.nome
            txtStatus.text = personagem.status
            txtEspecie.text = personagem.especie
            txtLocalizacao.text = personagem.localizacao.nome
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
    }

    // qtd de itens do dataset
    override fun getItemCount()=dataSet.size
}