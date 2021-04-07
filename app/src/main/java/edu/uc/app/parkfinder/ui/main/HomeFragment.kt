package edu.uc.app.parkfinder.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import edu.uc.app.parkfinder.R

class HomeFragment : Fragment(R.layout.home_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}