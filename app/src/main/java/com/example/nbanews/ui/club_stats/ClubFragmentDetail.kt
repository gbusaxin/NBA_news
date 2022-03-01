package com.example.nbanews.ui.club_stats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nbanews.R
import com.example.nbanews.databinding.FragmentClubDetailBinding


class ClubFragmentDetail : Fragment() {

    private var _binding:FragmentClubDetailBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClubDetailBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPagerAdapter = ViewPagerClubAdapter(childFragmentManager)
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        viewPagerAdapter.addFragment(CompositionsFragment(),"Состав")
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}