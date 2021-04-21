package edu.uc.app.parkfinder.ui.main

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import edu.uc.app.parkfinder.R
import edu.uc.app.parkfinder.dto.Park
import edu.uc.app.parkfinder.navigation.Navigator
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment(R.layout.home_fragment) {

    private lateinit var viewModel: MainViewModel
    private var _parks = ArrayList<Park>()
    val storageRef = Firebase.storage.reference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        Navigator.currentFragment = "HomeFragment"

        recyclerViewAllPhotos.hasFixedSize()
        recyclerViewAllPhotos.layoutManager = LinearLayoutManager(context)
        recyclerViewAllPhotos.itemAnimator = DefaultItemAnimator()
        recyclerViewAllPhotos.adapter = ParksAdapter(_parks, R.layout.row_layout)

        viewModel.parks.observe(viewLifecycleOwner, Observer {
                parks ->
            _parks.removeAll(_parks)
            _parks.addAll(parks)
            recyclerViewAllPhotos.adapter!!.notifyDataSetChanged()
        })
    }

    inner class ParksAdapter(val parks: List<Park>, val itemLayout: Int) : RecyclerView.Adapter<HomeFragment.ParkViewHolder>() {
        /**
         * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
         * an item.
         *
         *
         * This new ViewHolder should be constructed with a new View that can represent the items
         * of the given type. You can either create a new View manually or inflate it from an XML
         * layout file.
         *
         *
         * The new ViewHolder will be used to display items of the adapter using
         * [.onBindViewHolder]. Since it will be re-used to display
         * different items in the data set, it is a good idea to cache references to sub views of
         * the View to avoid unnecessary [View.findViewById] calls.
         *
         * @param parent The ViewGroup into which the new View will be added after it is bound to
         * an adapter position.
         * @param viewType The view type of the new View.
         *
         * @return A new ViewHolder that holds a View of the given view type.
         * @see .getItemViewType
         * @see .onBindViewHolder
         */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
            return ParkViewHolder(view)
        }

        /**
         * Called by RecyclerView to display the data at the specified position. This method should
         * update the contents of the [ViewHolder.itemView] to reflect the item at the given
         * position.
         *
         *
         * Note that unlike [android.widget.ListView], RecyclerView will not call this method
         * again if the position of the item changes in the data set unless the item itself is
         * invalidated or the new position cannot be determined. For this reason, you should only
         * use the `position` parameter while acquiring the related data item inside
         * this method and should not keep a copy of it. If you need the position of an item later
         * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
         * have the updated adapter position.
         *
         * Override [.onBindViewHolder] instead if Adapter can
         * handle efficient partial bind.
         *
         * @param holder The ViewHolder which should be updated to represent the contents of the
         * item at the given position in the data set.
         * @param position The position of the item within the adapter's data set.
         */
        override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
            val park = parks[position]
            holder.updatePark(park)
        }

        /**
         * Returns the total number of items in the data set held by the adapter.
         *
         * @return The total number of items in this adapter.
         */
        override fun getItemCount(): Int {
            return parks.size
        }

    }

    inner class ParkViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private var textViewCoverLoading : TextView = itemView.findViewById(R.id.textViewCoverLoading)
        private var imageViewRowCover : ImageView = itemView.findViewById(R.id.imageViewCover)
        private var textViewRowParkName : TextView = itemView.findViewById(R.id.textViewRowParkName)
        private var textViewRowParkAddress : TextView = itemView.findViewById(R.id.textViewRowParkAddress)

        fun updatePark (park : Park)
        {
            textViewRowParkName.text = park.name
            textViewRowParkAddress.text = park.address

            var imgRef = storageRef.child("parks/" + park.parkID + ".jpeg")
            val FOUR_MEGABYTE: Long = 1024 * 1024 * 4
            imgRef.getBytes(FOUR_MEGABYTE).addOnSuccessListener {
                val bmp = BitmapFactory.decodeByteArray(it, 0, it.size);
                imageViewRowCover.setImageBitmap(bmp);
                textViewCoverLoading.text = ""
            }
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}