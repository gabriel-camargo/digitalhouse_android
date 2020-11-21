package com.gabrielcamargo.chucknorrisapi.jokes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.gabrielcamargo.chucknorrisapi.R
import com.gabrielcamargo.chucknorrisapi.jokes.model.JokeModel
import com.gabrielcamargo.chucknorrisapi.jokes.repository.JokeRepository
import com.gabrielcamargo.chucknorrisapi.jokes.viewmodel.JokeViewModel
import com.squareup.picasso.Picasso

class JokeFragment : Fragment() {

    private lateinit var _myView: View
    private lateinit var _viewModel: JokeViewModel

    companion object {
        fun newInstance() = JokeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _myView =  inflater.inflate(R.layout.fragment_joke, container, false)
        return _myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _viewModel = ViewModelProvider(
            this,
            JokeViewModel.JokeViewModelFactory(JokeRepository())
        ).get(JokeViewModel::class.java)

        arguments?.getString(getString(R.string.category))?.let { category ->

            _viewModel.getJoke(category).observe(viewLifecycleOwner, { jokeModel->
                setInformation(jokeModel)
            })

        }
    }

    private fun setInformation(jokeModel: JokeModel) {
        val txt = _myView.findViewById<TextView>(R.id.txt_jokeFragment)
        val img: ImageView = _myView.findViewById<ImageView>(R.id.img_jokeFragment)

        txt.text = jokeModel.text

        Picasso.get().load(jokeModel.img).fit().centerCrop().into(img)
    }
}