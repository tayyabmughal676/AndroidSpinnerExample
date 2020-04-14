package com.example.myappspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var mSpinner: Spinner;
    lateinit var mButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSpinner = findViewById(R.id.mySpinner)
        mButton = findViewById(R.id.button)

        mSpinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
                this,
                R.array.planets_array,
                android.R.layout.simple_spinner_item
        ).also {  adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            mSpinner.adapter = adapter
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(applicationContext, "No Item select", Toast.LENGTH_SHORT).show();
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val pos = parent?.getItemAtPosition(position) as Int
        Toast.makeText(applicationContext, "Clicked: ${pos}" , Toast.LENGTH_SHORT).show()
    }

}

