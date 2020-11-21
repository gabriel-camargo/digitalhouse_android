package com.gabrielcamargo.chucknorrisapi.categories.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
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
    private lateinit var _navController: NavController

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

        _navController = Navigation.findNavController(_myView)

        _viewModel = ViewModelProvider(
            this,
            CategoriesViewModel.CategoriesViewModelFactory(CategoriesRepository())
        ).get(CategoriesViewModel::class.java)

        _viewModel.getCategories().observe(viewLifecycleOwner, {
            createList(it)
        })
    }

    private fun createList(categories: List<String>) {
        val viewManager = LinearLayoutManager(_myView.context)
        val viewAdapter = CategoriesAdapter(categories) {
            val bundle = bundleOf(getString(R.string.category) to it)
            _navController.navigate(R.id.jokeFragment, bundle)
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