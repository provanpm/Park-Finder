package edu.uc.app.parkfinder.ui.main

import android.util.Log
import android.content.ContentValues.TAG
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import edu.uc.app.parkfinder.dto.Park
import edu.uc.app.parkfinder.service.ParkService

class MainViewModel : ViewModel() {

    // uses Retrofit & uses GitHub JSON
    var parks: MutableLiveData<ArrayList<Park>> = MutableLiveData<ArrayList<Park>>()

    // uses Firebase & Firestore
    var allParks: MutableLiveData<ArrayList<Park>> = MutableLiveData<ArrayList<Park>>()

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

    /*
     * Hears any updates to Firestore
     */
    private fun listenToParks() {
        firestore.collection("parks").addSnapshotListener {
            snapshot, e ->
            if (e != null) {
                Log.w(TAG, "Listen Failed", e)
                return@addSnapshotListener
            }

            if (snapshot != null) {
                val allParksTemp = ArrayList<Park>()
                val documents = snapshot.documents
                documents.forEach {
                    it.toObject(Park::class.java)
                }
                allParks.value = allParksTemp
            }
        }
    }

    fun save(park: Park) {
        val document = firestore.collection("parks").document()
        park.parkID = document.id
        val set = document.set(park)
            set.addOnSuccessListener {
                Log.i("Firebase", "document saved")
            }
            set.addOnFailureListener {
                Log.e("Firebase", "save failed")
            }
    }
}