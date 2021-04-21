package edu.uc.app.parkfinder.ui.main

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import edu.uc.app.parkfinder.R
import edu.uc.app.parkfinder.navigation.Navigator
import kotlinx.android.synthetic.main.result_fragment.*

class ResultFragment : Fragment(R.layout.result_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Navigator.currentFragment = "ResultFragment"

        buttonFinishView.setOnClickListener {
            Navigator.decideNav("SearchFragment", this.activity as Activity)
        }
    }

}