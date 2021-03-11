package edu.uc.app.parkfinder.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.uc.app.parkfinder.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment(R.layout.home_fragment) {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnGo.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToMainFragment()
            findNavController().navigate(action)
        }
    }
}