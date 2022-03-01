package com.example.nbanews.ui.newsline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.nbanews.databinding.FragmentNewsLineDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsLineFragmentDetail : Fragment() {

    private var _binding: FragmentNewsLineDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NewsLineViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsLineDetailBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedDataState.observe(viewLifecycleOwner) {
            val adapter = CommentsAdapter()
            with(binding) {
                textViewPublicationHeader.text = it.header
                textViewPublicationBody.text = it.body
                textViewPublicationTags.text = it.tags
                adapter.list = it.comments
                recyclerViewComments.adapter = adapter
            }
        }
    }

}