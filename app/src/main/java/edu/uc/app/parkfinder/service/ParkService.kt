package edu.uc.app.parkfinder.service

import android.util.Log
import androidx.lifecycle.MutableLiveData
import edu.uc.app.parkfinder.RetrofitClientInstance
import edu.uc.app.parkfinder.dao.IParkDAO
import edu.uc.app.parkfinder.dto.Park
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ParkService {

    internal fun fetchParks() : MutableLiveData<ArrayList<Park>> {
        var parks = MutableLiveData<ArrayList<Park>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(IParkDAO::class.java)
        val call = service?.getAllParks()

        call?.enqueue(object: Callback<ArrayList<Park>> {
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<ArrayList<Park>>, t: Throwable) {
                // TODO: fill this in
                Log.e( "ArrayList Park", "Error Occurred!", t);
            }

            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<ArrayList<Park>>, response: Response<ArrayList<Park>>
            ) {
                parks.value = response.body()
            }
        })

        return parks
    }
}