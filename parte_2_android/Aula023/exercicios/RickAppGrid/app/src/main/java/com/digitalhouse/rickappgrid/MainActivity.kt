package com.digitalhouse.rickappgrid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickappgrid.api.IRespostaDaApi
import com.digitalhouse.rickappgrid.api.Personagem
import com.digitalhouse.rickappgrid.api.RickApi
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = GridLayoutManager(this,2)
        val recyclerView = findViewById<RecyclerView>(R.id.cardList)

        var toast: Toast? = null

        RickApi.getData(this, object: IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
                val viewAdapter = CardRickAdapter(personagens) {
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)

                    intent.putExtra("nome", it.nome)
                    intent.putExtra("localizacao", it.localizacao.nome)
                    intent.putExtra("genero", it.genero)
                    intent.putExtra("imagemUrl", it.imagemUrl)
//
                    startActivity(intent)

//                    toast?.cancel()
//                    toast = Toast.makeText(this@MainActivity, it.nome, Toast.LENGTH_SHORT)
//                    toast?.show()
                }

                recyclerView.apply {
                    setHasFixedSize(true) //dizer que os elementos não são dinamicos

                    layoutManager = viewManager
                    adapter = viewAdapter
//                    addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                }
            }
        })

        val floatingButton: FloatingActionButton = findViewById<FloatingActionButton>(R.id.floating_action_button)
        floatingButton.setOnClickListener{
            finish();
            overridePendingTransition(0, 0);
            startActivity(intent);
            overridePendingTransition(0, 0);
        }


    }
}