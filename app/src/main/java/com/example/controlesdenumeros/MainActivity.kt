package com.example.controlesdenumeros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        var info : TextView = findViewById(R.id.info)
        var name : TextView = findViewById(R.id.name)
        var age : Spinner = findViewById(R.id.ages_spinner);
        info.text = name.text.toString() + " Tiene entre " +  age.selectedItem + " y es " + parent.getItemAtPosition(pos).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner: Spinner = findViewById(R.id.ages_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.ages,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val spinner2: Spinner = findViewById(R.id.genre_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.genre,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = adapter
        }
        spinner2.onItemSelectedListener = this
        var info : TextView = findViewById(R.id.info)
        info.text = ""
    }
}