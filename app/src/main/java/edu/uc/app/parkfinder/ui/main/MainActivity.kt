package edu.uc.app.parkfinder.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uc.app.parkfinder.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.home_fragment, HomeFragment.newInstance())
                    .commitNow()
        }
    }
}