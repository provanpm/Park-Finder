package edu.uc.app.parkfinder.ui.main

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import edu.uc.app.parkfinder.R
import edu.uc.app.parkfinder.navigation.Navigator
import kotlinx.android.synthetic.main.main_activity.*
import java.util.jar.Manifest

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