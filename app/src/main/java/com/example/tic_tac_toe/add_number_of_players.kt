package com.example.tic_tac_toe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter.ViewBinder
import android.widget.Toast
import com.example.tic_tac_toe.databinding.ActivityAddNumberOfPlayersBinding

class add_number_of_players : AppCompatActivity() {
 lateinit var binding: ActivityAddNumberOfPlayersBinding
 companion object{
     const val key1 = "player1"
     const val key2 = "player2"
 }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddNumberOfPlayersBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.Start.setOnClickListener{
            val cross = binding.cross.text.toString()
            val circle = binding.circle.text.toString()
            if(cross.isEmpty() || circle.isEmpty()){
                Toast.makeText(this, "Enter the player names", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra(key1,cross)
                intent.putExtra(key2,circle)
                startActivity(intent)
            }
        }
    }
}