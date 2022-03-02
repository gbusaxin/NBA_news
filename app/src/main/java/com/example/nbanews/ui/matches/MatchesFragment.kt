package com.example.nbanews.ui.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nbanews.databinding.FragmentMatchesBinding
import com.example.nbanews.ui.club_stats.ClubStatsFragment
import com.example.nbanews.ui.club_stats.CompositionsFragment
import com.example.nbanews.ui.club_stats.ViewPagerClubAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MatchesFragment : Fragment() {

    private var _binding: FragmentMatchesBinding? = null
    private val binding get() = _binding!!

    private val namesOfFragments = listOf(
        "Состав",
        "Статистика"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentList = listOf(
            FixturesFragment(),
            ResultsFragment()
        )

        val viewPagerAdapter = MatchesViewPager(
            fragmentList,
            childFragmentManager,
            lifecycle
        )
        val tabLayout = binding.tabLayoutMatches
        val viewPager = binding.viewPagerMatches
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(
            tabLayout,
            viewPager
        ) { tab, position ->
            tab.text = namesOfFragments[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}