package edu.uc.app.parkfinder.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.uc.app.parkfinder.R
import edu.uc.app.parkfinder.dto.Park
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var searchTextView : AutoCompleteTextView
    lateinit var resultTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.parks.observe(viewLifecycleOwner, Observer {
                parks -> searchPark.setAdapter(ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, parks))

        })

        searchTextView = getView()?.findViewById(R.id.searchPark) as AutoCompleteTextView
        resultTextView = getView()?.findViewById(R.id.nameTextView) as TextView
        searchPark.threshold = 1

        search_button.setOnClickListener {
            var  searchFor: String = searchTextView.text.toString()
            var indexInParksArray = getParkFromList(searchFor)

            var name = viewModel.parks.value?.get(index = indexInParksArray)?.name
            resultTextView.text = "Name Matched = " + viewModel.parks.value?.get(indexInParksArray)?.name?.trim().toString()

            val action = SearchResultDirections.actionMainFragmentToResultFragment()
            findNavController().navigate(action)

        }

    }
    private fun getParkFromList(searchFor: String) :Int{
        var searchText = searchTextView.text.trim()
        var nameTest = ""
        var index = 0
        var mismatch = true
        while(mismatch)
        {
            nameTest = viewModel.parks.value?.get(index = index)?.name?.trim().toString()

            if(nameTest?.trim().contains(searchText, ignoreCase = true))
            {
                mismatch = false
            }
            else
            {
                if(index < viewModel.parks.value?.size!! - 1)
                {
                    index++
                }
                else
                {
                    break
                }
            }
        }

        return index
    }

}