package com.example.newapplication
import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.newapplication.databinding.FragmentFirstBinding
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

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

        var zommLevel = 17f
        //val hoboken = LatLng(40.745255, -74.034775)
        val babbioCenterLoc = LatLng( 40.742310,-74.027191)
        val babbioCenter = mMap.addMarker(MarkerOptions()
            .position(babbioCenterLoc)
            .title("Hoboken, NJ")
            .icon(BitmapDescriptorFactory.
            defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )
        babbioCenter

        // babbioCenter?.remove()

        /*
        val MutekiLoc = LatLng(40.743526, -74.028918)
        val Muteki = mMap.addMarker(MarkerOptions()
            .position(MutekiLoc)
            .title("Hoboken, NJ")
            .icon(BitmapDescriptorFactory.
            defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        )
        Muteki
        */
        setFragmentResultListener("requestKey1") { requestKey, bundle ->
            var result = bundle.getBoolean("bundleKey1")
            if (result == true){

                Toast.makeText(requireActivity(), "result.toString()", Toast.LENGTH_SHORT).show()
            }
        }
        //Toast.makeText(requireActivity(), j.toString(), Toast.LENGTH_SHORT).show()
        setFragmentResultListener("requestKey2") { requestKey, bundle ->
            val result2 = bundle.getBoolean("bundleKey2")
            if (result2 == true){
                Toast.makeText(requireActivity(), "result()", Toast.LENGTH_SHORT).show()
            }
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(babbioCenterLoc, zommLevel))
    }

}

//com.example.newapplication.R.layout.fragment_first
//com.example.newapplication.R.id.gmap