package com.mine.openinapp_android.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mine.openinapp_android.data.repository.RemoteDataRepository
import com.mine.openinapp_android.network.model.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

sealed interface HomeUiState {
    data class Success(val data: ApiResponse) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val remoteDataRepository: RemoteDataRepository
) : ViewModel() {
    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getData()
    }
    fun getData() {

        viewModelScope.launch {
            homeUiState = HomeUiState.Loading
            homeUiState = try {
                HomeUiState.Success(remoteDataRepository.getData())
            } catch (e: IOException) {
                HomeUiState.Error
            } catch (e: HttpException) {
                HomeUiState.Error
            }
        }

    }
}