package com.devspacecinenow.detail.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.devspacecinenow.common.MovieDto
import com.devspacecinenow.common.RetrofitClient
import com.devspacecinenow.detail.DetailService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel (
    private val detailService: DetailService): ViewModel() {

    private val _uiGetMovie = MutableStateFlow<MovieDto?>(null)
    val uiGetMovies: StateFlow<MovieDto?> = _uiGetMovie

    fun fetchGetMovie(movieId: String) {
        if (_uiGetMovie.value == null) {
            viewModelScope.launch(Dispatchers.IO) {
                val response = detailService.getMovieById(movieId)
                if (response.isSuccessful) {
                    _uiGetMovie.value = response.body()!!
                } else {
                    Log.d("MovieDetailViewModel", "Request Error :: ${response.errorBody()}")
                }


            }

        }
    }
fun cleanMovieId(){
    viewModelScope.launch{
        delay(1000)
        _uiGetMovie.value = null
    }
}

        companion object {
            val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    modelClass: Class<T>,
                    extras: CreationExtras
                ): T {
                    val detailService =
                        RetrofitClient.retrofitInstance.create(DetailService::class.java)
                    return MovieDetailViewModel(
                        detailService
                    ) as T
                }

            }
        }
    }



