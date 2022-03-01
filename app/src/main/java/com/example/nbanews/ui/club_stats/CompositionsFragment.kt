package com.example.nbanews.ui.club_stats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.nbanews.R
import com.example.nbanews.databinding.FragmentCompositionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompositionsFragment : Fragment() {

    private var _binding: FragmentCompositionsBinding? = null
    private val binding get() = _binding!!

    private val viewModel:ClubViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompositionsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvCompositions = binding.recyclerViewCompositions
        val adapter = CompositionsAdapter()
        viewModel.selectedClubData.observe(viewLifecycleOwner){
            adapter.submitList(it.composition)
            rvCompositions.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}