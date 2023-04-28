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
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener


class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var entriesTop = arrayOf<CharSequence>()
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
                Toast.makeText(requireActivity(), "Lactose", Toast.LENGTH_SHORT).show()
            }
            if(chk6?.isChecked  == true){
                Toast.makeText(requireActivity(), "Fish", Toast.LENGTH_SHORT).show()
            }
            setFragmentResult("requestKey1", bundleOf("bundleKey1" to chk1?.isChecked))
            setFragmentResult("requestKey2", bundleOf("bundleKey2" to chk2?.isChecked))
            setFragmentResult("requestKey3", bundleOf("bundleKey3" to chk3?.isChecked))
            setFragmentResult("requestKey4", bundleOf("bundleKey4" to chk4?.isChecked))
            setFragmentResult("requestKey5", bundleOf("bundleKey5" to chk5?.isChecked))
            setFragmentResult("requestKey6", bundleOf("bundleKey6" to chk6?.isChecked))
        }
    }
}