package com.audiobooks.podcasts.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.audiobooks.podcasts.model.Podcast
import com.audiobooks.podcasts.network.PodcastRepository
import kotlinx.coroutines.launch

class PodcastListViewModel : ViewModel() {
    private val repository = PodcastRepository()
     var podcastList:List<Podcast> by mutableStateOf(listOf())
    private var errorMessage: String by mutableStateOf("")


    fun getPodcastList() {
        viewModelScope.launch {
            try {
                val list = repository.getPodcasts()
                podcastList = if(list.isSuccess){
                    list.getOrNull()?.toList() ?: listOf()
                } else{
                    listOf()
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}
