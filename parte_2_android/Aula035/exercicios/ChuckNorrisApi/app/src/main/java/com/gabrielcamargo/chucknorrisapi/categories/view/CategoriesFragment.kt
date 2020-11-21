package com.gabrielcamargo.chucknorrisapi.categories.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gabrielcamargo.chucknorrisapi.categories.viewmodel.CategoriesViewModel
import com.gabrielcamargo.chucknorrisapi.R
import com.gabrielcamargo.chucknorrisapi.categories.repository.CategoriesRepository

class CategoriesFragment : Fragment() {

    companion object {
        fun newInstance() = CategoriesFragment()
    }

    private lateinit var _viewModel: CategoriesViewModel
    private lateinit var _myView: View
    private lateinit var _recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _myView = inflater.inflate(R.layout.categories_fragment, container, false)
        return _myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _recyclerView = _myView.findViewById<RecyclerView>(R.id.recyclerView_categoriesFragment)

        _viewModel = ViewModelProvider(
            this,
            CategoriesViewModel.CategoriesViewModelFactory(CategoriesRepository(view.context))
        ).get(CategoriesViewModel::class.java)

        _viewModel.getCategories().observe(viewLifecycleOwner, {
            createList(it)
        })
    }

    private fun createList(categories: List<String>) {
        val viewManager = LinearLayoutManager(_myView.context)
        val viewAdapter = CategoriesAdapter(categories) {
            Toast.makeText(_myView.context, it, Toast.LENGTH_SHORT).show()
        }

        _recyclerView.addItemDecoration(
            DividerItemDecoration(
                _recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )

        _recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

}