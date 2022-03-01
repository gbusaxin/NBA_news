package com.example.nbanews.ui.newsline

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.nbanews.R
import com.example.nbanews.databinding.FragmentNewsLineBinding
import com.example.nbanews.domain.Publication
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsLineFragment : Fragment() {

    private var _binding: FragmentNewsLineBinding? = null
    private val binding get() = _binding!!

    private lateinit var parentAdapter: NewsLineParentAdapter

    private val viewModel: NewsLineViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsLineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvNewsLine = binding.recyclerViewNewsLine

        val click: ((Publication) -> Unit) = {
            viewModel.selectData(it)
            findNavController().navigate(R.id.action_nav_news_line_to_newsLineFragmentDetail)
        }

        viewModel.dataState.observe(viewLifecycleOwner) {
            parentAdapter = NewsLineParentAdapter(click)
            parentAdapter.parentList = it
            rvNewsLine.adapter = parentAdapter
        }
    }
}