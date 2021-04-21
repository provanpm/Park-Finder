package edu.uc.app.parkfinder.ui.main

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import edu.uc.app.parkfinder.R
import kotlinx.android.synthetic.main.camera_fragment.*
import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class CameraFragment : Fragment (R.layout.camera_fragment){
    private val SAVE_IMAGE_REQUEST_CODE = 1999
    private val CAMERA_REQUEST_CODE: Int = 1998
    private val CAMERA_PERMISSION_REQUEST_CODE = 1997
    private lateinit var currentPicturePath : String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        takePhotoBtn.setOnClickListener {
            prepTakePhoto()
        }
    }

    private fun prepTakePhoto() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            takePhoto()
        }
        else {
            val permissionRequest = arrayOf(Manifest.permission.CAMERA)
            requestPermissions(permissionRequest, CAMERA_PERMISSION_REQUEST_CODE)

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            when(requestCode) {
                CAMERA_PERMISSION_REQUEST_CODE -> {
                    if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        takePhoto()
                    }
                    else
                    {
                        Toast.makeText(context, "Unable to take photo without permission", Toast.LENGTH_LONG)
                    }
                }
            }
        }

    private fun takePhoto() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{
            takePictureIntent -> takePictureIntent.resolveActivity(requireContext().packageManager)?.also{
            if(takePictureIntent == null) {
                Toast.makeText(context, "Unable to save Photo", Toast.LENGTH_LONG).show()
            }
            else {
                val photoFile:File = createImageFile()
                photoFile?.also{
                    val photoURI = FileProvider.getUriForFile(requireActivity().applicationContext, "com.parkFinder.android.fileprovider", it )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, SAVE_IMAGE_REQUEST_CODE)
                }
            }
            //    startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE) Keep This for Debugging
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK) {
            if(requestCode == CAMERA_REQUEST_CODE) {
                val imageBitmap = data!!.extras!!.get("data") as Bitmap
                imgPark.setImageBitmap(imageBitmap)
            }
            else if (requestCode == SAVE_IMAGE_REQUEST_CODE) {
                Toast.makeText(context, "Image Saved", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun createImageFile(): File {
        val timestamp:String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir:File? = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("ParkFinder${timestamp}", ".jpg", storageDir).apply {
            currentPicturePath = absolutePath
        }
    }
}