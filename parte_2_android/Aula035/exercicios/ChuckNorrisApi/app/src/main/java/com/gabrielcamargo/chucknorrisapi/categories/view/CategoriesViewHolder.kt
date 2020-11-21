package com.gabrielcamargo.chucknorrisapi.categories.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.chucknorrisapi.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val txtCategory: TextView = view.findViewById(R.id.txtCategory_itemCategory)

    fun bind(txt: String) {
        txtCategory.text = txt.capitalize()
    }
}
