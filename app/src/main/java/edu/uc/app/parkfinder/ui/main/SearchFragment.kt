package edu.uc.app.parkfinder.ui.main

import android.app.Activity
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.uc.app.parkfinder.R
import edu.uc.app.parkfinder.navigation.Navigator
import kotlinx.android.synthetic.main.search_fragment.*

class SearchFragment : Fragment(R.layout.search_fragment) {

    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        Navigator.currentFragment = "SearchFragment"

        viewModel.staticParks.observe(viewLifecycleOwner, Observer {
                parks -> autocompleteParkSearch.setAdapter(ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, parks))
                autocompleteParkSearch.threshold = 1
        })

        buttonParkSearch.setOnClickListener {
            Navigator.decideNav("ResultFragment", this.activity as Activity)
        }
    }

}