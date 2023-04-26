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
import androidx.fragment.app.Fragment
import com.example.newapplication.databinding.FragmentFirstBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions

class FirstFragment : Fragment(), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    private lateinit var binding: FragmentFirstBinding
    private val LOCATION_PERMISSION_REQUEST = 1


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = childFragmentManager
            .findFragmentById(com.example.newapplication.R.id.gmap) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return inflater.inflate(com.example.newapplication.R.layout.fragment_first, container, false)
    }

    private fun getLocationAccess() {
        if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            map.isMyLocationEnabled = true
        }
        else {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),LOCATION_PERMISSION_REQUEST)
        }
    }

    override fun onRequestPermissionsResult(requestCode:Int, permissions:Array<String>, grantResults:IntArray)
    {
        if (requestCode == LOCATION_PERMISSION_REQUEST)
        {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED))
            {
                map.isMyLocationEnabled = true
            }
            else {
                Toast.makeText(requireContext(), "User has not granted location permission", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        //Toast.makeText(this, "test dialog3", Toast.LENGTH_LONG).show()
        //Toast.makeText(getApplicationContext(), " Hello World", Toast.LENGTH_SHORT).show();
        getLocationAccess()

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        // Add a marker in Hoboken and move the camera

        /*var zommLevel = 15f
         val hoboken = LatLng(40.745255, -74.034775)
         map.addMarker(
             MarkerOptions().position(hoboken).title("Hoboken, NJ")
                 .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
         )
         map.moveCamera(CameraUpdateFactory.newLatLngZoom(hoboken, zommLevel))
         */
    }

}
//com.example.newapplication.R.layout.fragment_first
//com.example.newapplication.R.id.gmap

/*
private lateinit var map: GoogleMap
    private lateinit var binding: FragmentFirstBinding
    private val LOCATION_PERMISSION_REQUEST = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return (binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        //replaced supportFragmentManager with childFragmentManager


        /*
        val mapFragment = childFragmentManager
            .findFragmentById(com.example.newapplication.R.id.gmap) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return inflater.inflate(com.example.newapplication.R.layout.fragment_first, container, false)
        */

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        //Toast.makeText(this, "test dialog3", Toast.LENGTH_LONG).show()
        //Toast.makeText(getApplicationContext(), " Hello World", Toast.LENGTH_SHORT).show();
        getLocationAccess()

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        // Add a marker in Hoboken and move the camera

        /*var zommLevel = 15f
         val hoboken = LatLng(40.745255, -74.034775)
         map.addMarker(
             MarkerOptions().position(hoboken).title("Hoboken, NJ")
                 .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
         )
         map.moveCamera(CameraUpdateFactory.newLatLngZoom(hoboken, zommLevel))
         */
    }

*/