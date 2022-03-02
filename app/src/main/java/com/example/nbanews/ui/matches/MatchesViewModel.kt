package com.example.nbanews.ui.matches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nbanews.domain.FutureMatch
import com.example.nbanews.domain.ResultMatch
import com.example.nbanews.repository.MatchesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(private val repository: MatchesRepository) : ViewModel() {

    val fixturesDataState:LiveData<List<FutureMatch>> = repository.getFixtures()

    val resultsDataState:LiveData<List<ResultMatch>> = repository.getResults()

    fun deleteAllFixtures(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllFixtures()
        }
    }

    fun deleteAllResults(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllResults()
        }
    }

    fun loadFixtures(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.loadFixtures()
        }
    }

    fun loadResults(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.loadResult()
        }
    }

}