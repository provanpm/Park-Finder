package edu.uc.app.parkfinder.dao

import edu.uc.app.parkfinder.dto.Park
import retrofit2.Call
import retrofit2.http.GET

interface IParkDAO {

    @GET("/core/country-list/data_json/data/8c458f2d15d9f2119654b29ede6e45b8/data_json.json")
    fun getAllParks(): Call<ArrayList<Park>>
}