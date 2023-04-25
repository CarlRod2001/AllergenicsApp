package com.example.newapplication

import android.R
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.example.newapplication.databinding.FragmentFirstBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment


class FirstFragment : Fragment(), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    private lateinit var binding: FragmentFirstBinding
    private val LOCATION_PERMISSION_REQUEST = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return inflater.inflate(R.layout.fragment_first, container, false)
    }
    private fun getLocationAccess() {
        if (ContextCompat.checkSelfPermission(requireActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            map.isMyLocationEnabled = true
        }
        else
        {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),LOCATION_PERMISSION_REQUEST)
        }
    }

    override fun onRequestPermissionsResult(requestCode:Int, permissions:Array<String>, grantResults:IntArray) {
        if (requestCode == LOCATION_PERMISSION_REQUEST) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                map.isMyLocationEnabled = true
            }
            else {
                Toast.makeText(requireActivity(), "User has not granted location permission", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
    override fun onMapReady(gmap: GoogleMap) {
        map = gmap
        getLocationAccess()
    }


}