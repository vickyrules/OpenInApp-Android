package com.mine.openinapp_android.ui.screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mine.openinapp_android.data.repository.RemoteDataRepository
import com.mine.openinapp_android.network.model.ApiResponse
import com.mine.openinapp_android.ui.utils.FormattedMonthString
import com.patrykandpatrick.vico.core.entry.ChartEntry
import com.patrykandpatrick.vico.core.entry.ChartEntryModel
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.FloatEntry
import com.patrykandpatrick.vico.core.entry.composed.ComposedChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.composed.plus
import com.patrykandpatrick.vico.core.entry.entriesOf
import com.patrykandpatrick.vico.core.entry.entryOf
import com.patrykandpatrick.vico.core.util.RandomEntriesGenerator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

sealed interface HomeUiState {
    data class Success(val data: ApiResponse) : HomeUiState
    data class Error(val message: String) : HomeUiState
    data class Loading(val isLoading: Boolean) : HomeUiState
}

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val remoteDataRepository: RemoteDataRepository
) : ViewModel() {
    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading(false))
        private set





    internal val customStepChartEntryModelProducer: ChartEntryModelProducer =
        ChartEntryModelProducer()

    init {
        getData()
    }


    private companion object {
        const val GENERATOR_X_RANGE_TOP = 96
        const val GENERATOR_Y_RANGE_BOTTOM = 0
        const val GENERATOR_Y_RANGE_TOP = 0

    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getData() {
        viewModelScope.launch {
            homeUiState = HomeUiState.Loading(true)
            homeUiState = try {


                val response = remoteDataRepository.getData()
                makeGraphChart(response)
                HomeUiState.Success(response)
            } catch (e: IOException) {
                HomeUiState.Error(e.toString())
            } catch (e: HttpException) {
                HomeUiState.Error(e.toString())
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun makeGraphChart(response: ApiResponse){

        val entries = mutableListOf<FloatEntry>()
//        val FakeData = mutableMapOf<String,Int>(
//            Pair("2023-04-30)",5),
//            Pair("2023-02-23)",15),
//            Pair("2023-01-30)",23),
//            Pair("2023-03-30)",135),
//            Pair("2023-02-30)",500),
//            Pair("2023-01-30)",342),
//            Pair("2023-10-30)",50),
//            Pair("2023-04-30)",543),
//            Pair("2023-04-30)",9),
//            Pair("2023-03-30)",150),
//            Pair("2023-03-30)",546),
//            Pair("2023-03-30)",176),
//            Pair("2023-03-30)",13),
//            Pair("2023-03-30)",383),
//            Pair("2023-03-30)",125),
//        )
        response.data.overall_url_chart.forEach { monthString, value ->
            entries.add( FloatEntry(FormattedMonthString(monthString).toFloat(), value.toFloat()) )
        }

        Log.d("entries", entries.toString()+entries.size+response.data.overall_url_chart.size)
        customStepChartEntryModelProducer.setEntries(entries)
    }
}



