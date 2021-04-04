package edu.uc.app.parkfinder.ui.main

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import edu.uc.app.parkfinder.R

class SearchResultDirections private constructor() {
    companion object {
      fun actionMainFragmentToResultFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_main_fragment_to_searchResultFragment3)
  }
}
