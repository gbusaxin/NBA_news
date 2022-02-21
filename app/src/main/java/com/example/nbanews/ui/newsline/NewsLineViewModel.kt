package com.example.nbanews.ui.newsline

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nbanews.domain.NewsLine
import com.example.nbanews.repository.NewsLineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsLineViewModel @Inject constructor(
    repository: NewsLineRepository
): ViewModel() {

    private val _dataState: LiveData<List<NewsLine>> = repository.getNewsLine()
    val dataState: LiveData<List<NewsLine>>
        get() = _dataState

    init {
        viewModelScope.launch {
            repository.loadNewsLine()
        }
    }

}