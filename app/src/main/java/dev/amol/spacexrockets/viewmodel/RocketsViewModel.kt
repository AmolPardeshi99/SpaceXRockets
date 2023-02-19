package dev.amol.spacexrockets.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amol.spacexrockets.model.network.SpacexRocketDto
import dev.amol.spacexrockets.repository.RocketsRepository
import dev.amol.spacexrockets.utils.Status
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RocketsViewModel @Inject constructor(private val rocketsRepository: RocketsRepository) :ViewModel() {


    private val _allRocketsData:MutableLiveData<List<SpacexRocketDto>> = MutableLiveData()
    val allRocketsData:LiveData<List<SpacexRocketDto>> = _allRocketsData

    private val _specificRocketData:MutableLiveData<SpacexRocketDto> = MutableLiveData()
    val specificRocketData:LiveData<SpacexRocketDto> = _specificRocketData

    var currentItemData:SpacexRocketDto? = null

    fun getAllRocketsData() = viewModelScope.launch {
        val result = rocketsRepository.getAllRocketsData()
        when(result.status){
            Status.SUCCESS->{
                    _allRocketsData.postValue(result.data)
            }
            Status.ERROR->{

            }
            else->{}
        }
    }

    fun getSpecificRocketData() = viewModelScope.launch {
        val result = currentItemData?.id?.let { rocketsRepository.getSpecificRocketData(it) }
        when(result?.status){
            Status.SUCCESS->{
                _specificRocketData.postValue(result.data)
            }
            Status.ERROR->{

            }
            else->{}
        }
    }

}