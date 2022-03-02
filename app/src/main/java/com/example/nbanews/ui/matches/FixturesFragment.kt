package com.example.nbanews.ui.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.nbanews.databinding.FragmentFixturesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FixturesFragment : Fragment() {

    private var _binding: FragmentFixturesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MatchesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFixturesBinding.inflate(inflater, container, false)
        viewModel.loadFixtures()
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvFixtures = binding.recyclerViewFixtures
        val adapter = FixturesAdapter(requireContext())
        viewModel.fixturesDataState.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            rvFixtures.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.deleteAllFixtures()
        _binding = null
    }

}