package com.example.nbanews.ui.club_stats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.nbanews.databinding.FragmentClubStatsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClubStatsFragment : Fragment() {

    private var _binding: FragmentClubStatsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ClubViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClubStatsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvStats = binding.recyclerViewClubStats
        val adapter = StatsAdapter()
        viewModel.selectedClubData.observe(viewLifecycleOwner) {
            adapter.submitList(it.totals)
            rvStats.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}