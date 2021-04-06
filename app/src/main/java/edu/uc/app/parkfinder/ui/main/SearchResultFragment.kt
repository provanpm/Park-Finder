package edu.uc.app.parkfinder.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import edu.uc.app.parkfinder.R

class SearchResultFragment : Fragment(R.layout.search_result_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        fun newInstance() = SearchResultFragment()
    }

}