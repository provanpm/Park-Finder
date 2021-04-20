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
    var staticParks: MutableLiveData<ArrayList<Park>> = MutableLiveData<ArrayList<Park>>()

    // uses Firebase & Firestore
    private var _parks = MutableLiveData<List<Park>>()

    private var parkService: ParkService = ParkService()
    private lateinit var firestore : FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
        listenToParks()
        fetchParks()
        fetchStaticParks()
    }

    internal fun fetchStaticParks() {
        staticParks = parkService.fetchParks()
    }

    internal fun fetchParks() {
        var parksCollection = firestore.collection("parks")
        parksCollection.addSnapshotListener {querySnapshot, firebaseFirestoreException ->
            var innerParks = querySnapshot?.toObjects(Park::class.java)
            _parks.postValue(innerParks!!)
        }
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
                val parksTemp = ArrayList<Park>()
                val documents = snapshot.documents
                documents.forEach {
                    val park = it.toObject(Park::class.java)
                    if (park != null)
                    {
                        parksTemp.add(park!!)
                    }
                }
                parks.value = parksTemp
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

    internal var parks : MutableLiveData<List<Park>>
        get() {return _parks}
        set(value) {_parks = value}

}