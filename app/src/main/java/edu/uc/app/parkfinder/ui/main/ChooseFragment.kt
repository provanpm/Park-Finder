package edu.uc.app.parkfinder.ui.main

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.Task
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ListResult
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import edu.uc.app.parkfinder.R
import edu.uc.app.parkfinder.navigation.Navigator
import kotlinx.android.synthetic.main.choose_fragment.*

class ChooseFragment : Fragment (R.layout.choose_fragment){

    private lateinit var viewModel: MainViewModel
    private var _imageRefs = ArrayList<StorageReference>()
    val storageRef = Firebase.storage.reference.child("parks")
    private val FOUR_MEGABYTE: Long = 1024 * 1024 * 4 // max file size

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        Navigator.currentFragment = "ChooseFragment"
        _imageRefs.clear()

        recyclerViewAllCovers.hasFixedSize()
        recyclerViewAllCovers.layoutManager = LinearLayoutManager(context)
        recyclerViewAllCovers.itemAnimator = DefaultItemAnimator()
        recyclerViewAllCovers.adapter = ParksAdapter(_imageRefs, R.layout.image_layout)

        val listAllTask: Task<ListResult> = storageRef.listAll()
        listAllTask.addOnCompleteListener { result ->
            val items: List<StorageReference> = result.result!!.items
            items.forEachIndexed { index, item ->
                _imageRefs.add(item)
            }
            recyclerViewAllCovers.adapter!!.notifyDataSetChanged()
        }
    }

    inner class ParksAdapter(val imageRefs: List<StorageReference>, val itemLayout: Int) : RecyclerView.Adapter<ChooseFragment.ParkViewHolder>() {
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
            holder.updateImage(imageRefs[position])
        }

        /**
         * Returns the total number of items in the data set held by the adapter.
         *
         * @return The total number of items in this adapter.
         */
        override fun getItemCount(): Int {
            return imageRefs.size
        }

    }

    inner class ParkViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private var textViewImageLoading : TextView = itemView.findViewById(R.id.textViewImageLoading)
        private var imageViewCover : ImageView = itemView.findViewById(R.id.imageViewCover)

        fun updateImage (newRef: StorageReference)
        {
            newRef.getBytes(FOUR_MEGABYTE).addOnSuccessListener {
                var bmp = BitmapFactory.decodeByteArray(it, 0, it.size);
                imageViewCover.setImageBitmap(bmp);
                textViewImageLoading.text = ""
            }
        }
    }

    companion object {
        fun newInstance() = ChooseFragment()
    }

}