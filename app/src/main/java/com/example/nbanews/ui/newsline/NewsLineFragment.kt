package com.example.nbanews.ui.newsline

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.nbanews.databinding.FragmentNewsLineBinding
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
        parentAdapter = NewsLineParentAdapter()
        viewModel.dataState.observe(viewLifecycleOwner) {
            parentAdapter.parentList = it
            rvNewsLine.adapter = parentAdapter
        }
        parentAdapter.onPublicationClickListener = {
            Toast.makeText(requireContext(),it.header,Toast.LENGTH_SHORT).show()
        }
    }
}