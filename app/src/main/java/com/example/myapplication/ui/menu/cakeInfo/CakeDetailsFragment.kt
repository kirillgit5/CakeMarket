package com.example.myapplication.ui.menu.cakeInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myapplication.databinding.FragmentCakeFullInfoBinding

class CakeDetailsFragment: Fragment() {
    private lateinit var binding: FragmentCakeFullInfoBinding
    private val cakeDetailViewModel: CakeDetailsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCakeFullInfoBinding.inflate(inflater, container, false)
        binding.apply {
            viewModel = cakeDetailViewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getLong("ARG_CAKE_ID")
        id?.let{
            cakeDetailViewModel.loadData(it)
        }
    }
}