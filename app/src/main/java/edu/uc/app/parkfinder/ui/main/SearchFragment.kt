package edu.uc.app.parkfinder.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.uc.app.parkfinder.R
import kotlinx.android.synthetic.main.search_fragment.*

class SearchFragment : Fragment(R.layout.search_fragment) {

    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.parks.observe(viewLifecycleOwner, Observer {
                parks -> searchParkACTV.setAdapter(ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, parks))
                searchParkACTV.threshold = 1
        })
        buttonSearch.setOnClickListener {
            val action = SearchFragmentDirections.actionSearchFragmentToSearchResultFragment()
            findNavController().navigate(action)
        }
    }

    companion object {
        fun newInstance() = SearchFragment()
    }

}