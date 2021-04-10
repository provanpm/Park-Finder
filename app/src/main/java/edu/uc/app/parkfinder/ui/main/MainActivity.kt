package edu.uc.app.parkfinder.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uc.app.parkfinder.R
import edu.uc.app.parkfinder.navigation.Navigator
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.home_fragment, HomeFragment.newInstance())
                    .commitNow()
        }

        buttonMenuSearch.setOnClickListener {
            Navigator.decideNav("SearchFragment", this)
        }

        buttonMenuAdd.setOnClickListener {
            Navigator.decideNav("AddFragment", this)
        }

        buttonMenuHome.setOnClickListener {
            Navigator.decideNav("HomeFragment", this)
        }
    }

}