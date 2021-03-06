package edu.uc.app.parkfinder.navigation

import android.app.Activity
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import edu.uc.app.parkfinder.R
import edu.uc.app.parkfinder.ui.main.*


object Navigator {

    var currentFragment: String = "HomeFragment"
    var action: NavDirections? = null

    /*
     * This is dirty, I know that. There is probably a better way to pull
     * this sort of thing off but I wasn't aware. Sorry!
     */
    fun decideNav(intendedFragment: String, mainActivity: Activity) {

        if (currentFragment == "HomeFragment") {
            if (intendedFragment == "AddFragment") {
                action = HomeFragmentDirections.actionHomeFragmentToAddFragment()
            }
            else if (intendedFragment == "SearchFragment") {
                action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
            }
        }

        else if (currentFragment == "AddFragment") {
            if (intendedFragment == "HomeFragment") {
                action = AddFragmentDirections.actionAddFragmentToHomeFragment()
            }
            else if (intendedFragment == "SearchFragment") {
                action = AddFragmentDirections.actionAddFragmentToSearchFragment()
            }
            else if (intendedFragment == "CameraFragment") {
                action = AddFragmentDirections.actionAddFragmentToCameraFragment()
            }
            else if (intendedFragment == "ChooseFragment") {
                action = AddFragmentDirections.actionAddFragmentToChooseFragment()
            }
        }

        else if (currentFragment == "SearchFragment") {
            if (intendedFragment == "HomeFragment") {
                action = SearchFragmentDirections.actionSearchFragmentToHomeFragment()
            }
            else if (intendedFragment == "AddFragment") {
                action = SearchFragmentDirections.actionSearchFragmentToAddFragment()
            }
            else if (intendedFragment == "ResultFragment") {
                action = SearchFragmentDirections.actionSearchFragmentToResultFragment()
            }
        }

        else if (currentFragment == "ResultFragment") {
            if (intendedFragment == "HomeFragment") {
                action = ResultFragmentDirections.actionResultFragmentToHomeFragment()
            }
            else if (intendedFragment == "AddFragment") {
                action = ResultFragmentDirections.actionResultFragmentToAddFragment()
            }
            else if (intendedFragment == "SearchFragment") {
                action = ResultFragmentDirections.actionResultFragmentToSearchFragment()
            }
        }

        else if (currentFragment == "CameraFragment") {
            if (intendedFragment == "AddFragment") {
                action = CameraFragmentDirections.actionCameraFragmentToAddFragment()
            }
            else if (intendedFragment == "HomeFragment") {
                action = CameraFragmentDirections.actionCameraFragmentToHomeFragment()
            }
            else if (intendedFragment == "SearchFragment") {
                action = CameraFragmentDirections.actionCameraFragmentToSearchFragment()
            }
        }

        else if (currentFragment == "ChooseFragment") {
            if (intendedFragment == "AddFragment") {
                action = ChooseFragmentDirections.actionChooseFragmentToAddFragment()
            }
            else if (intendedFragment == "HomeFragment") {
                action = ChooseFragmentDirections.actionChooseFragmentToHomeFragment()
            }
            else if (intendedFragment == "SearchFragment") {
                action = ChooseFragmentDirections.actionChooseFragmentToSearchFragment()
            }
        }

        if (action != null) {
            currentFragment = intendedFragment
            findNavController(mainActivity, R.id.nav_host_fragment).navigate(action as NavDirections)
        }
        action = null;
    }

}