package edu.uc.app.parkfinder.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import edu.uc.app.parkfinder.R
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private var currentFragment: String = "HomeFragment";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.home_fragment, HomeFragment.newInstance())
                    .commitNow()
        }

        buttonMenuSearch.setOnClickListener {
            if (currentFragment == "HomeFragment")
            {
                val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
                findNavController(this, R.id.nav_host_fragment).navigate(action)
                currentFragment = "SearchFragment"
            }
            else if (currentFragment == "AddFragment")
            {
                val action = AddFragmentDirections.actionAddFragmentToSearchFragment()
                findNavController(this, R.id.nav_host_fragment).navigate(action)
                currentFragment = "SearchFragment"
            }
        }

        buttonMenuAdd.setOnClickListener {
            if (currentFragment == "HomeFragment")
            {
                val action = HomeFragmentDirections.actionHomeFragmentToAddFragment()
                findNavController(this, R.id.nav_host_fragment).navigate(action)
                currentFragment = "AddFragment"
            }
            else if (currentFragment == "SearchFragment")
            {
                val action = SearchFragmentDirections.actionSearchFragmentToAddFragment()
                findNavController(this, R.id.nav_host_fragment).navigate(action)
                currentFragment = "AddFragment"
            }
        }

        buttonMenuHome.setOnClickListener {
            if (currentFragment == "AddFragment")
            {
                val action = AddFragmentDirections.actionAddFragmentToHomeFragment()
                findNavController(this, R.id.nav_host_fragment).navigate(action)
                currentFragment = "HomeFragment"
            }
            else if (currentFragment == "SearchFragment")
            {
                val action = SearchFragmentDirections.actionSearchFragmentToHomeFragment()
                findNavController(this, R.id.nav_host_fragment).navigate(action)
                currentFragment = "HomeFragment"
            }
        }
    }
}