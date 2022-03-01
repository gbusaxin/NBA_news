package com.example.nbanews.ui.club_stats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nbanews.domain.Club
import com.example.nbanews.repository.ClubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClubViewModel @Inject constructor(
    repository: ClubRepository
) : ViewModel() {


    val clubDataState: LiveData<List<Club>> = repository.getClubs()

    val selectedClubData = MutableLiveData<Club>()

    fun selectClubData(club: Club) {
        selectedClubData.value = club
    }

    init {
        viewModelScope.launch {
            repository.loadClubs()
        }
    }

}