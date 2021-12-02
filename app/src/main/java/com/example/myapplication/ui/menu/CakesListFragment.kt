package com.example.myapplication.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.FragmentCakeListBinding

class CakesListFragment: Fragment() {
    private lateinit var binding: FragmentCakeListBinding
    private val cakeAdapter = CakeAdapter()
    private val cakesListViewModel: CakesListViewModel by activityViewModels {
        CakesListViewModel.Factory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCakeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cakeList.apply {
            adapter = cakeAdapter
            layoutManager = GridLayoutManager(context,2)
        }

        cakesListViewModel.getCakes().observe(viewLifecycleOwner) {
            cakeAdapter.reload(it)
        }
    }
}