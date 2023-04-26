package com.example.newapplication
import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newapplication.databinding.FragmentFirstBinding
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class FirstFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(com.example.newapplication.R.layout.fragment_first, container, false)
        val mapFragment = childFragmentManager.findFragmentById(com.example.newapplication.R.id.gmap) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return view
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
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