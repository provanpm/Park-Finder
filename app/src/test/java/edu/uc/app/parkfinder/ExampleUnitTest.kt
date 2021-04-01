package edu.uc.app.parkfinder
import edu.uc.app.parkfinder.dto.Park
import org.junit.Test
import org.junit.Assert.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun parkDTO_maintainsPark(){
        var park = Park("ACAD","Acadia National Park")
        assertTrue(park.name.equals("Acadia National Park"))
        assertTrue(park.code.equals("ACAD"))
    }


}