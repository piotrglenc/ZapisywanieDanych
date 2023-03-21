package com.example.zapisywaniedanych

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zapisywaniedanych.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("myPrefFile", MODE_PRIVATE)
        val editor = sharedPref.edit()

        val wczytaneImie = sharedPref.getString("IMIE", null)
        val wczytaneNazwisko = sharedPref.getString("NAZWISKO", null)
        val wczytanyWiek = sharedPref.getInt("WIEK", -1)

        if (wczytaneImie != null && wczytaneNazwisko != null && wczytanyWiek != -1) {
            binding.imie.setText(wczytaneImie)
            binding.nazwisko.setText(wczytaneNazwisko)
            binding.wiek.setText(wczytanyWiek.toString())
            binding.btnZapisz.text = "Aktualizuj dane"
        }

        binding.btnZapisz.setOnClickListener {
            val imie = binding.imie.text.toString()
            val nazwisko = binding.nazwisko.text.toString()
            val wiek = binding.wiek.text.toString().toInt()

            editor.putString("IMIE", imie)
            editor.putString("NAZWISKO", nazwisko)
            editor.putInt("WIEK", wiek)
            editor.apply()
        }
    }
}