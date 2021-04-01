package edu.uc.app.parkfinder

import edu.uc.app.parkfinder.dto.Park
import edu.uc.app.parkfinder.ui.main.MainViewModel
import junit.framework.Assert.assertTrue
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ParkSearchTest {
    lateinit var mvm: MainViewModel

    @Before
    fun populateParks() {
        mvm = MainViewModel()
    }

    /**
     * This test checks if the DTO has been changed to an undesired state
     */
    @Test
    fun parkDTO_maintainsState() {
        val park = Park("950 Eden Park Dr, Cincinnati, OH 45202", "Eden")
        assertTrue(park.location.equals("950 Eden Park Dr, Cincinnati, OH 45202"))
        assertTrue(park.name.equals("Eden"))
    }

    /**
     * This test sees if the park DTO is receiving results
     */
    @Test
    fun parkDTO_isPopulated() {
        givenViewModelIsInitialized()
        whenJSONDataAreReadAndParsed()
        thenTheCollectionSizeShouldBeGreaterThanZero()
    }

    private fun givenViewModelIsInitialized() {

    }

    private fun whenJSONDataAreReadAndParsed() {
        mvm.fetchParks()
    }

    private fun thenTheCollectionSizeShouldBeGreaterThanZero() {
        var allParks = ArrayList<Park>()
        mvm.parks.observeForever{
            allParks = it
        }
        Thread.sleep(5000)
        Assert.assertNotNull(allParks)
        Assert.assertTrue(allParks.size > 0)
    }

    /**
     *  This test follows requirement 101 scenario 1.1 in the design doc
     *  Given a feed of park data is available
     *  When I search for “Eden”
     *  Then I should receive at least one result with these attributes:
     *  Park Name: Eden Park
     *  Location: 950 Eden Park Dr, Cincinnati, OH 45202
     */
    @Test
    fun parkDto_containsEdenAndLocation() {
        givenViewModelIsInitialized()
        whenJSONDataAreReadAndParsed()
        thenResultsShouldContainEden()
    }

    private fun thenResultsShouldContainEden() {
        var containsEden: Boolean = false
        mvm.parks.observeForever {
            it.forEach {
                if(it.name.equals("Eden") || it.location.equals("950 Eden Park Dr, Cincinnati, OH 45202")) {
                    containsEden = true
                }
            }
        }
    }


    //Exclude Burnet search because it is redundant to Eden search

    /**
     * This test follows requirement 101 scenario 1.3 in the design doc
     * Given a feed of park data is available
     * When I search for “WLIFUHskvuWHGULDS”
     * Then I should receive zero results (an empty list)
     */
    @Test
    fun searchNonValidPark() {
        givenViewModelIsInitialized()
        whenJSONDataAreReadAndParsed()
        thenResultsShouldBeEmpty()
    }

    private fun thenResultsShouldBeEmpty() {
        var nonValidState: Boolean = false
        mvm.parks.observeForever {
            if (it.size.equals(0)) {
                nonValidState = true
            }
        }
    }


}