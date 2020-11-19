package com.turma05.kotlinrickapp.listagem.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.turma05.kotlinrickapp.R
import com.turma05.kotlinrickapp.listagem.model.PersonagemModel
import com.turma05.kotlinrickapp.listagem.repository.PersonagemRepository
import com.turma05.kotlinrickapp.listagem.viewmodel.PersonagemViewModel

class ListaFragment : Fragment() {
    lateinit var _viewModel: PersonagemViewModel
    lateinit var _view: View

    private lateinit var _listaAdapter: ListaAdapter
    private lateinit var _recyclerView: RecyclerView

    private var _listaDePersonagens = mutableListOf<PersonagemModel>()

    private var _text: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view

        _recyclerView = view.findViewById<RecyclerView>(R.id.lista)
        val manager = LinearLayoutManager(view.context)

        _listaDePersonagens = mutableListOf<PersonagemModel>()
        _listaAdapter = ListaAdapter(_listaDePersonagens)

        _recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = _listaAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            PersonagemViewModel.PersonagemViewModelFactory(PersonagemRepository())
        ).get(PersonagemViewModel::class.java)

        _viewModel.obterLista().observe(viewLifecycleOwner, {
            exibirResultados(it)
        })

        showLoading(true)

        initSearch()
        setScrollView()
    }

    private fun exibirResultados(lista: List<PersonagemModel>?) {
        showLoading(false)

        lista?.isNotEmpty()?.let { notfound(it) }

//        _listaDePersonagens.clear()
        lista?.let { _listaDePersonagens.addAll(it) }

        _listaAdapter.notifyDataSetChanged()
    }

    private fun initSearch() {
        val searchView = _view.findViewById<SearchView>(R.id.searchView)

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()

                _text = query
                _viewModel.buscar(query).observe(viewLifecycleOwner, {
                    exibirResultados(it)
                })

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    exibirResultados(_viewModel.listaAntiga())
                }

                return true
            }
        })
    }

    fun showLoading(isLoading: Boolean) {
        val viewLoading = _view.findViewById<View>(R.id.loading)

        if (isLoading) {
            viewLoading.visibility = View.VISIBLE
        } else {
            viewLoading.visibility = View.GONE
        }
    }

    fun notfound(notfound: Boolean) {
        if (notfound) {
            _view.findViewById<View>(R.id.notfoundLayout).visibility = View.GONE
        } else {
            _view.findViewById<View>(R.id.notfoundLayout).visibility = View.VISIBLE
        }
    }

    private fun setScrollView() {
        _recyclerView.run {
            addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val target = recyclerView.layoutManager as LinearLayoutManager?
                    val totalItemCount = target!!.itemCount
                    val lastVisible = target.findLastVisibleItemPosition()
                    val lastItem = (lastVisible + 5) >= totalItemCount

                    if(totalItemCount > 0 && lastItem) {
                        _viewModel.proximaPagina(_text).observe(viewLifecycleOwner, {
                            exibirResultados(it)
                        })
                    }
                }
            })
        }
    }

}