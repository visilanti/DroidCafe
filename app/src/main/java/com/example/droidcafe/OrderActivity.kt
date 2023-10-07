package com.example.droidcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast

class OrderActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        spinner = findViewById(R.id.spinner)

        // Daftar kota yang akan ditampilkan dalam Spinner
        val cities = arrayOf("Jakarta", "Surabaya", "Bandung", "Yogyakarta", "Semarang")

        // Buat ArrayAdapter untuk Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)

        // Set layout dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set adapter untuk Spinner
        spinner.adapter = adapter

        // Listener untuk menangani item yang dipilih
        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
                val selectedCity = cities[position]
                // Handle pilihan kota yang dipilih di sini
                Toast.makeText(applicationContext, "Kota yang dipilih: $selectedCity", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                // Tidak ada yang dipilih
            }
        })
    }

    fun onRadioButtonClicked(view: View) {
// Is the button now checked?
        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            R.id.sameday -> if (checked) // Same day service
                displayToast(getString(R.string.same_day_messenger_service))
            R.id.nextday -> if (checked) // Next day delivery
                displayToast(getString(R.string.next_day_ground_delivery))
            R.id.pickup -> if (checked) // Pick up
                displayToast(getString(R.string.pick_up))
            else -> {}
        }
    }
    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext, message,
            Toast.LENGTH_SHORT
        ).show()
    }

}