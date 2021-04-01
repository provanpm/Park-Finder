package edu.uc.app.parkfinder.dao

import edu.uc.app.parkfinder.dto.Park
import retrofit2.Call
import retrofit2.http.GET

interface IParkDAO {

    @GET("/learn-chef/national-parks-java/master/national-parks.json")
    fun getAllParks(): Call<ArrayList<Park>>


}