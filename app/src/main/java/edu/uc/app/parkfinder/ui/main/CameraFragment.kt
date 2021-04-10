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
import android.provider.MediaStore
import android.widget.Toast

class CameraFragment : Fragment (R.layout.camera_fragment){
    private val CAMERA_REQUEST_CODE: Int = 1998
    val CAMERA_PERMISSION_REQUEST_CODE = 1997

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        takePhotoBtn.setOnClickListener {
            prepTakePhoto()
        }
    }

    private fun prepTakePhoto() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
        {
            takePhoto()
        }
        else
        {
            val permissionRequest = arrayOf(Manifest.permission.CAMERA)
            requestPermissions(permissionRequest, CAMERA_PERMISSION_REQUEST_CODE)

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            when(requestCode)
            {
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
                startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            if(requestCode == CAMERA_REQUEST_CODE)
            {
                val imageBitmap = data!!.extras!!.get("data") as Bitmap
                imgPark.setImageBitmap(imageBitmap)
            }
        }
    }
}