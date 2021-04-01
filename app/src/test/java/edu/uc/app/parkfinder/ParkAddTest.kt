package edu.uc.app.parkfinder

import android.view.View
import edu.uc.app.parkfinder.ui.main.MainViewModel
import kotlinx.android.synthetic.main.home_fragment.view.*
import org.junit.Before
import org.junit.Test

class ParkAddTest {

    lateinit var mvm: MainViewModel
    lateinit var ma: MainActivity
    lateinit var checkedView: ArrayList<View>

    @Before
    fun init() {
        mvm = MainViewModel()
        ma = MainActivity()

    }

    @Before
    fun viewToFilter() {
        checkedView = ma.addFieldView
    }

    /**
     * This test follows requirement 100 scenario 1.1
     * Given a user is adding a new park
     * When they click add park
     * Then it should be verefied they have included name and location
     *
     */
    @Test
    fun userInputFilter() {
        givenViewModelIsInitialized()
        checkUserInput(checkedView)

    }

    private fun givenViewModelIsInitialized() {

    }

    private fun checkUserInput(checkedView: ArrayList<View>) {
        var isChecked: Boolean = true

        checkedView.forEach {
            if(it.textView.text == "") {
                isChecked = false
            }
        }
    }


}