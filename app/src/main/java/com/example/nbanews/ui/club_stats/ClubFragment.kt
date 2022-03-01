package com.example.nbanews.ui.club_stats

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.nbanews.R
import com.example.nbanews.databinding.FragmentClubBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClubFragment : Fragment() {

    private var _binding: FragmentClubBinding? = null
    private val binding get() = _binding!!

    private val viewModel : ClubViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClubBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvClub = binding.recyclerViewClub
        val adapter = ClubAdapter()

        viewModel.clubDataState.observe(viewLifecycleOwner){
            Log.d("CHECK_CLUB",it.toString())
            adapter.submitList(it)
            rvClub.adapter = adapter
        }
        adapter.onClubClick = {
            viewModel.selectClubData(it)
            findNavController().navigate(R.id.action_nav_club_to_clubFragmentDetail)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}