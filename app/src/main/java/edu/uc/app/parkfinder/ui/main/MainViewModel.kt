package edu.uc.app.parkfinder.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import edu.uc.app.parkfinder.dto.Park
import edu.uc.app.parkfinder.service.ParkService

class MainViewModel : ViewModel() {
    var parks: MutableLiveData<ArrayList<Park>> = MutableLiveData<ArrayList<Park>>()
    private var parkService: ParkService = ParkService()
    private lateinit var firestore : FirebaseFirestore

    init {
        fetchParks()
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun fetchParks() {
        parks = parkService.fetchParks()
    }

    fun save(park: Park) {
        firestore.collection("parks")
            .document()
            .set(park)
            .addOnSuccessListener {
                Log.i("Firebase", "document saved")
            }
            .addOnFailureListener {
                Log.e("Firebase", "save failed")
            }
    }
}