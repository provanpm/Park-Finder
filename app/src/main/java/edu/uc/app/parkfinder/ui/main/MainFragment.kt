package edu.uc.app.parkfinder.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import edu.uc.app.parkfinder.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(R.layout.main_fragment) {

    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.parks.observe(viewLifecycleOwner, Observer {
                parks -> actPark.setAdapter(ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, parks))
        })

    }

    companion object {
        fun newInstance() = MainFragment()
    }
}