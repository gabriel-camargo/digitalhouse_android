package com.gabrielcamargo.chucknorrisapi.categories.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.chucknorrisapi.R

class CategoriesAdapter(
    private val dataSet: List<String>,
    private val clickListener: (String) -> Unit
) : RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)

        return CategoriesViewHolder(view)    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener{clickListener(dataSet[position])}
    }

    override fun getItemCount() = dataSet.size
}
