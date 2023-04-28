package com.example.newapplication
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import androidx.fragment.app.setFragmentResultListener
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.PointOfInterest


class FirstFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnPoiClickListener{
    private lateinit var mMap: GoogleMap
    var allergies = arrayOf("Peanuts","Shellfish","Soy","Eggs","Dairy","Fish")
    var selectedAllergies = BooleanArray(6) {false}

    // in the map below first number is subscript into the allergies array, second number is how many items with that allergen were found
    val carlos = mapOf(0 to 0, 1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 9 to 40)     //no allergens
    val falafel = mapOf(0 to 0, 1 to 0, 2 to 0, 3 to 3, 4 to 1, 5 to 0, 9 to 34)   //dairy
    val elysian = mapOf(0 to 0, 1 to 0, 2 to 1, 3 to 3, 4 to 2, 5 to 0, 9 to 23)    //soy, eggs, dairy
    var muteki = mapOf(0 to 0, 1 to 0, 2 to 3, 3 to 13, 4 to 0, 5 to 3, 9 to 43)    //soy, eggs, fish
    var karma = mapOf(0 to 0, 1 to 1, 2 to 0, 3 to 0, 4 to 0, 5 to 6, 9 to 57)      //fish
    var grimaldi = mapOf(0 to 0, 1 to 0, 2 to 0, 3 to 2, 4 to 0, 5 to 0, 9 to 48)   //eggs
    var ainsworth = mapOf(0 to 0, 1 to 0, 2 to 0, 3 to 2, 4 to 0, 5 to 0, 9 to 23)  //eggs
    var obagel = mapOf(0 to 0, 1 to 0, 2 to 0, 3 to 3, 4 to 0, 5 to 0, 9 to 40)     //eggs
    var tudinos = mapOf(0 to 0, 1 to 3, 2 to 0, 3 to 2, 4 to 0, 5 to 1, 9 to 65)    //shellfish, fish
    var cuban = mapOf(0 to 0, 1 to 0, 2 to 0, 3 to 14, 4 to 0, 5 to 0, 9 to 70)     //eggs
    val carlosC = "ChIJAAAAAAAAAAARYCdN4WDUFBk"
    val falafelC = "ChIJAAAAAAAAAAARQAaByauMUdk"
    val elysianC = "ChIJAAAAAAAAAAARVcIo2xixbvo"
    val mutekiC = "ChIJAAAAAAAAAAARPnVsSyzpXc0"
    val karmaC = "ChIJAAAAAAAAAAAR-7QOnarlh18"
    val grimaldiC = "ChIJAAAAAAAAAAARwOiK_9EGkvc"
    val ainsworthC = "ChIJAAAAAAAAAAARh-rmI9Wabu0"
    val obagelC = "ChIJAAAAAAAAAAARzlQYo2mznp4"
    val tudinosC = "ChIJAAAAAAAAAAARAloe97cJr4Y"
    val cubanC = "ChIJAAAAAAAAAAARlIH3JxyXCG0"

    //val restaurantAllergenMap = mapOf("ChIJAAAAAAAAAAARQAaByauMUdk" to falafel, "ChIJAAAAAAAAAAARYCdN4WDUFBk" to carlos, "ChIJAAAAAAAAAAARVcIo2xixbvo" to elysian, "ChIJAAAAAAAAAAARPnVsSyzpXc0" to muteki, "ChIJAAAAAAAAAAAR-7QOnarlh18" to karma, "ChIJAAAAAAAAAAARwOiK_9EGkvc" to grimaldi, "ChIJAAAAAAAAAAARh-rmI9Wabu0" to ainsworth
    val restaurantAllergenMap = mapOf(falafelC to falafel, carlosC to carlos, elysianC to elysian, mutekiC to muteki, karmaC to karma, grimaldiC to grimaldi, ainsworthC to ainsworth, obagelC to obagel, tudinosC to tudinos, cubanC to cuban )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(com.example.newapplication.R.layout.fragment_first, container, false)
        val mapFragment = childFragmentManager.findFragmentById(com.example.newapplication.R.id.gmap) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return view
    }

    override fun onPoiClick(poi: PointOfInterest) {
        var allergensChosen = ""
        for (i in selectedAllergies.indices) {
            if (selectedAllergies[i]) {
                //Toast.makeText(requireActivity(), allergies[i], Toast.LENGTH_SHORT).show()
                if (allergensChosen == "")
                    allergensChosen = allergies[i]
                else
                    allergensChosen = allergensChosen + ", " + allergies[i]
            }
        }

        if (allergensChosen != "") {
            Toast.makeText(requireActivity(), """Checking menu for: ${poi.name}""", Toast.LENGTH_SHORT).show()

            //add marker to chosen point
            val newMarker = LatLng(poi.latLng.latitude, poi.latLng.longitude)
            var bitmapDesc = BitmapDescriptorFactory.HUE_GREEN
            var alerItemCount: Int = 0
            var totalItemCount: Int = 0
            if (restaurantAllergenMap.containsKey(poi.placeId))
            {
                val allergItemList = restaurantAllergenMap.get(poi.placeId)
                for (i in selectedAllergies.indices) {
                    if (selectedAllergies[i]) {
                        if (allergItemList?.get(i) != null) {
                            alerItemCount += allergItemList.get(i)!!
                        }
                    }
                }
                if (allergItemList?.get(9) != null) {
                    totalItemCount += allergItemList.get(9)!!
                }
            }
            var snippetMessage: String
            if (alerItemCount > 0) {
                bitmapDesc = BitmapDescriptorFactory.HUE_RED
                snippetMessage = "Item with " + allergensChosen + ":" + alerItemCount + " out of " + totalItemCount
            }
            else if (restaurantAllergenMap.containsKey(poi.placeId) && alerItemCount == 0) {
                bitmapDesc = BitmapDescriptorFactory.HUE_GREEN
                snippetMessage = "No allergens found"
            }
            else {
                bitmapDesc = BitmapDescriptorFactory.HUE_ORANGE
                snippetMessage = "Not enough information"
            }
            mMap.addMarker(
                MarkerOptions().position(newMarker).title(poi.name)
                    .snippet(snippetMessage)
                    .icon(BitmapDescriptorFactory.defaultMarker(bitmapDesc))
            )
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnPoiClickListener(this)

        var zommLevel = 17f
        //val hoboken = LatLng(40.745255, -74.034775)
        val babbioCenterLoc = LatLng( 40.742310,-74.027191)
        val babbioCenter = mMap.addMarker(MarkerOptions()
            .position(babbioCenterLoc)
            .title("Hoboken, NJ")
            .icon(BitmapDescriptorFactory.
            defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
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
            selectedAllergies[0] = bundle.getBoolean("bundleKey1")
        }
            /*var result = bundle.getBoolean("bundleKey1")
            if (result == true){

                Toast.makeText(requireActivity(),  " peanuts were selected YH TESTING", Toast.LENGTH_SHORT).show()
                selectedAllergies[0] = true
            }
            else {

                Toast.makeText(requireActivity(), "peanuts were not selected", Toast.LENGTH_SHORT).show()
            }*/


        setFragmentResultListener("requestKey2") { requestKey, bundle ->
            selectedAllergies[1] = bundle.getBoolean("bundleKey2")
        }
        setFragmentResultListener("requestKey3") { requestKey, bundle ->
            selectedAllergies[2] = bundle.getBoolean("bundleKey3")
        }
        setFragmentResultListener("requestKey4") { requestKey, bundle ->
            selectedAllergies[3] = bundle.getBoolean("bundleKey4")
        }
        setFragmentResultListener("requestKey5") { requestKey, bundle ->
            selectedAllergies[4] = bundle.getBoolean("bundleKey5")
        }
        setFragmentResultListener("requestKey6") { requestKey, bundle ->
            selectedAllergies[5] = bundle.getBoolean("bundleKey6")
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(babbioCenterLoc, zommLevel))
    }
}
//com.example.newapplication.R.layout.fragment_first
//com.example.newapplication.R.id.gmap