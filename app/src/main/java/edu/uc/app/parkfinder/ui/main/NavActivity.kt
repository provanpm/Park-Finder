package edu.uc.app.parkfinder.ui.main

import android.app.Activity
import androidx.navigation.Navigation.findNavController
import edu.uc.app.parkfinder.R


object NavActivity{

    var currentFragment: String = "HomeFragment";

    /*
     * This is dirty, I know that. There is probably a better way to pull
     * this sort of thing off but I wasn't aware. Sorry!
     */
    fun decideNav(intendedFragment: String, mainActivity: Activity) {
        if (currentFragment == "HomeFragment")
        {
            if (intendedFragment == "AddFragment")
            {
                val action = HomeFragmentDirections.actionHomeFragmentToAddFragment()
                findNavController(mainActivity, R.id.nav_host_fragment).navigate(action)
                currentFragment = "AddFragment"
            }
            if (intendedFragment == "SearchFragment")
            {
                val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
                findNavController(mainActivity, R.id.nav_host_fragment).navigate(action)
                currentFragment = "SearchFragment"
            }
        }
        if (currentFragment == "AddFragment")
        {
            if (intendedFragment == "HomeFragment")
            {
                val action = AddFragmentDirections.actionAddFragmentToHomeFragment()
                findNavController(mainActivity, R.id.nav_host_fragment).navigate(action)
                currentFragment = "HomeFragment"
            }
            if (intendedFragment == "SearchFragment")
            {
                val action = AddFragmentDirections.actionAddFragmentToSearchFragment()
                findNavController(mainActivity, R.id.nav_host_fragment).navigate(action)
                currentFragment = "SearchFragment"
            }
        }
        if (currentFragment == "SearchFragment")
        {
            if (intendedFragment == "HomeFragment")
            {
                val action = SearchFragmentDirections.actionSearchFragmentToHomeFragment()
                findNavController(mainActivity, R.id.nav_host_fragment).navigate(action)
                currentFragment = "HomeFragment"
            }
            if (intendedFragment == "AddFragment")
            {
                val action = SearchFragmentDirections.actionSearchFragmentToAddFragment()
                findNavController(mainActivity, R.id.nav_host_fragment).navigate(action)
                currentFragment = "AddFragment"
            }
        }
    }

}