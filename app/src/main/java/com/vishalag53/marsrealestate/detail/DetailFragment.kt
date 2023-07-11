package com.vishalag53.marsrealestate.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.vishalag53.marsrealestate.R
import com.vishalag53.marsrealestate.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        @Suppress("UNUSED_VARIABLE")
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val marsProperty = DetailFragmentArgs.fromBundle(requireArguments()).selectedProperty

        val viewModelFactory = DetailViewModelFactory(marsProperty,application)
        binding.viewModel = ViewModelProvider(this,viewModelFactory)[DetailViewModel::class.java]


        return binding.root
    }


}