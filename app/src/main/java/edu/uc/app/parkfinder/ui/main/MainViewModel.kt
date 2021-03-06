package edu.uc.app.parkfinder.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.uc.app.parkfinder.dto.Park
import edu.uc.app.parkfinder.service.ParkService

class MainViewModel : ViewModel() {
    var parks: MutableLiveData<ArrayList<Park>> = MutableLiveData<ArrayList<Park>>()
    var parkService: ParkService = ParkService()

    init {
        fetchParks()
    }

    private fun fetchParks() {
        parks = parkService.fetchParks()
    }
}