package com.example.androidbasics

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.androidbasics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnApply.setOnClickListener {
//            val firstName = binding.etFirstName.text.toString()
//            val lastName = binding.etLastName.text.toString()
//            val age = binding.etAge.text.toString().toInt()
//            val country = binding.etCountry.text.toString()
//
//            val person = Person(firstName, lastName, age, country)
//            Log.d(
//                "MainActivity",
//                "$firstName $lastName, born on $age, from $country just applied for visa."
//            )
//            Intent(this, MainActivity2::class.java).also {
//                it.putExtra("EXTRA_PERSON", person)
//                startActivity(it)
//            }
//            requestPermissions()
            Intent(this, MainActivity2::class.java).also {
                startActivity(it)
            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun hasWritePermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationPermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun hasBackgroundPermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

    @RequiresApi(Build.VERSION_CODES.M)
    private fun requestPermissions() {
        var permissions = mutableListOf<String>()
        if (!hasWritePermission()) {
            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!hasLocationPermission()) {
            permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        @RequiresApi(Build.VERSION_CODES.Q)
        if (!hasBackgroundPermission()) {
            permissions.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }

        if (permissions.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissions.toTypedArray(), 0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("Permissions Request", "${permissions[i]} granted.")
                }
            }
        }

    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.app_bar_menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId) {
//            R.id.miAddContact -> Toast.makeText(this, "You clicked on Add Contact", Toast.LENGTH_SHORT).show()
//            R.id.miFavorites -> Toast.makeText(this, "You clicked on Favorites", Toast.LENGTH_SHORT).show()
//            R.id.miSettings -> Toast.makeText(this, "You clicked on Settings", Toast.LENGTH_SHORT).show()
//            R.id.miFeedback -> Toast.makeText(this, "You clicked on Feedback", Toast.LENGTH_SHORT).show()
//            R.id.miCloseApp -> finish()
//        }
//        return true
//    }
}
