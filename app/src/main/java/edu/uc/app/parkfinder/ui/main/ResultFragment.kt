package edu.uc.app.parkfinder.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import edu.uc.app.parkfinder.R
import edu.uc.app.parkfinder.navigation.Navigator

class ResultFragment : Fragment(R.layout.result_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Navigator.currentFragment = "ResultFragment"

    }

}