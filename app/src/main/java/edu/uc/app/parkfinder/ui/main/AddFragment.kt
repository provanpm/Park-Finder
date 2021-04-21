package edu.uc.app.parkfinder.ui.main

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import edu.uc.app.parkfinder.navigation.Navigator
import edu.uc.app.parkfinder.R
import edu.uc.app.parkfinder.dto.Park
import kotlinx.android.synthetic.main.add_fragment.*

class AddFragment : Fragment(R.layout.add_fragment) {

    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        Navigator.currentFragment = "AddFragment"

        buttonFinishAdd.setOnClickListener {
            savePark()
        }

        buttonAddParkImage.setOnClickListener{
            Navigator.decideNav("CameraFragment", this.activity as Activity)
        }

        buttonChooseParkImage.setOnClickListener{
            Navigator.decideNav("ChooseFragment", this.activity as Activity)
        }
    }

    private fun savePark() {
        var park = Park().apply {
            name = editTextParkName.text.toString()
            address = editTextParkAddress.text.toString()
            description = editTextParkDesc.text.toString()
        }
        viewModel.save(park)
        Navigator.decideNav("HomeFragment", this.activity as Activity)
    }

}