package com.example.nbanews.ui.newsline

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nbanews.domain.NewsLine
import com.example.nbanews.domain.Publication
import com.example.nbanews.repository.NewsLineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsLineViewModel @Inject constructor(
    repository: NewsLineRepository
) : ViewModel() {

    val dataState:LiveData<List<NewsLine>> = repository.getNewsLine()


    private var _selectedDataState: MutableLiveData<Publication>? = MutableLiveData()
    val selectedDataState:LiveData<Publication> get() = _selectedDataState!!

    fun selectData(data:Publication){
        _selectedDataState?.value = data
    }

    init {
        viewModelScope.launch {
            repository.loadNewsLine()
        }
    }

}