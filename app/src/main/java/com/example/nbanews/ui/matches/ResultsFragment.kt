package com.example.nbanews.ui.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.nbanews.databinding.FragmentResultsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!

    val viewModel: MatchesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        viewModel.loadResults()
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ResultsAdapter(requireContext())
        val rvResult = binding.recyclerViewResults
        viewModel.resultsDataState.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            rvResult.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.deleteAllResults()
        _binding = null
    }

}