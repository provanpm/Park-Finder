package edu.uc.app.parkfinder.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uc.app.parkfinder.R
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    var currentFragment: String = "HomeFragment";
    var intendedFragment: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.home_fragment, HomeFragment.newInstance())
                    .commitNow()
        }

        buttonMenuSearch.setOnClickListener {
            NavActivity.decideNav("SearchFragment", this)
        }

        buttonMenuAdd.setOnClickListener {
            NavActivity.decideNav("AddFragment", this)
        }

        buttonMenuHome.setOnClickListener {
            NavActivity.decideNav("HomeFragment", this)
        }
    }

}