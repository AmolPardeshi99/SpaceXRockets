package dev.amol.spacexrockets.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amol.spacexrockets.model.local.Rocket
import dev.amol.spacexrockets.model.network.SpacexRocketDto
import dev.amol.spacexrockets.repository.RocketsRepository
import dev.amol.spacexrockets.utils.Status
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RocketsViewModel @Inject constructor(private val rocketsRepository: RocketsRepository) :
    ViewModel() {

    private val _specificRocketData: MutableLiveData<SpacexRocketDto> = MutableLiveData()
    val specificRocketData: LiveData<SpacexRocketDto>
        get() = _specificRocketData

    var currentItemData: Rocket? = null

    val rockets: LiveData<List<Rocket>> = rocketsRepository.rockets

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    init {
        refreshRockets()
    }

    fun refreshRockets() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                rocketsRepository.getAllRocketsData()
                _isLoading.value = false
            } catch (e: Exception) {
                _isLoading.value = false
                _errorMessage.value = e.message
            }
        }
    }

    fun getSpecificRocketData() = viewModelScope.launch {
        val result = currentItemData?.id?.let { rocketsRepository.getSpecificRocketData(it) }
        when (result?.status) {
            Status.SUCCESS -> {
                _specificRocketData.postValue(result.data)
            }
            Status.ERROR -> {

            }
            else -> {}
        }
    }

}