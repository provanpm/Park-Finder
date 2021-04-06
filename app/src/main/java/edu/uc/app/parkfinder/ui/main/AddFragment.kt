package edu.uc.app.parkfinder.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import edu.uc.app.parkfinder.R
import edu.uc.app.parkfinder.dto.Park
import kotlinx.android.synthetic.main.add_fragment.*

class AddFragment : Fragment(R.layout.add_fragment) {

    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        buttonBackAdd.setOnClickListener {
            val action = AddFragmentDirections.actionAddFragmentToHomeFragment()
            findNavController().navigate(action)
        }

        buttonFinishAdd.setOnClickListener {
            savePark()
        }
    }

    private fun savePark() {
        var park = Park().apply {
            name = parkNameEditText.text.toString()
            address = parkAddressEditText.text.toString()
            description = parkDescriptionEditText.text.toString()
        }
        viewModel.save(park)
    }

    companion object {
        fun newInstance() = AddFragment()
    }

}