package com.example.newapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private val fragmentManager = supportFragmentManager
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == R.id.action_one) {
            //Toast.makeText(this, "Item One Clicked", Toast.LENGTH_LONG).show()
            setContentView(R.layout.activity_main)
            return true
        }
        if (id == R.id.action_two) {
            //Toast.makeText(this, "Item Two Clicked", Toast.LENGTH_LONG).show()
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.frameLayout, SecondFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            return true
        }
        if (id == R.id.action_three) {
            //Toast.makeText(this, "Item Three Clicked", Toast.LENGTH_LONG).show()
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.frameLayout, FirstFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            return true
        }

        return super.onOptionsItemSelected(item)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}