package com.example.nbanews.ui.club_stats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nbanews.R
import com.example.nbanews.databinding.FragmentClubDetailBinding
import com.google.android.material.tabs.TabLayoutMediator


class ClubFragmentDetail : Fragment() {

    private var _binding:FragmentClubDetailBinding?=null
    private val binding get() = _binding!!

    private val namesOfFragments = listOf(
        "Скоро",
        "Результаты"
    )

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

        val fragmentList = listOf(
            CompositionsFragment(),
            ClubStatsFragment()
        )

        val viewPagerAdapter = ViewPagerClubAdapter(
            fragmentList,
            childFragmentManager,
            lifecycle
        )
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(
            tabLayout,
            viewPager
        ) { tab, position ->
            tab.text = namesOfFragments[position]
        }.attach()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}