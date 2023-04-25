package com.example.newapplication
import android.graphics.text.TextRunShaper
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import java.security.KeyStore.TrustedCertificateEntry



class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chk1 = view?.findViewById<CheckBox>(R.id.checkBox1)
        val chk2 = view?.findViewById<CheckBox>(R.id.checkBox2)
        val chk3 = view?.findViewById<CheckBox>(R.id.checkBox3)
        val chk4 = view?.findViewById<CheckBox>(R.id.checkBox4)
        val chk5 = view?.findViewById<CheckBox>(R.id.checkBox5)
        val chk6 = view?.findViewById<CheckBox>(R.id.checkBox6)
        val btn = view?.findViewById<Button>(R.id.buttonSub)

        btn?.setOnClickListener {
            if(chk1?.isChecked  == true){
                Toast.makeText(requireActivity(), "Peanuts", Toast.LENGTH_SHORT).show()
            }
            if(chk2?.isChecked  == true){
                Toast.makeText(requireActivity(), "Shellfish", Toast.LENGTH_SHORT).show()
            }
            if(chk3?.isChecked  == true){
                Toast.makeText(requireActivity(), "Soy", Toast.LENGTH_SHORT).show()
            }
            if(chk4?.isChecked  == true){
                Toast.makeText(requireActivity(), "Eggs", Toast.LENGTH_SHORT).show()
            }
            if(chk5?.isChecked  == true){
                Toast.makeText(requireActivity(), "Dairy", Toast.LENGTH_SHORT).show()
            }
            if(chk6?.isChecked  == true){
                Toast.makeText(requireActivity(), "Fish", Toast.LENGTH_SHORT).show()
            }
        }
    }
}