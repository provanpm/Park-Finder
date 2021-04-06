package edu.uc.app.parkfinder.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import edu.uc.app.parkfinder.R
import kotlinx.android.synthetic.main.add_fragment.*

class AddFragment : Fragment(R.layout.add_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonBackAdd.setOnClickListener {
            val action = AddFragmentDirections.actionAddFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }

    companion object {
        fun newInstance() = AddFragment()
    }

}