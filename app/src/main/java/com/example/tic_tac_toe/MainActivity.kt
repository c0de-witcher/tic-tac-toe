package com.example.tic_tac_toe

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.tic_tac_toe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var combinationList = ArrayList<ArrayList<Int>>()
    var boxPostions = arrayOf(0,0,0,0,0,0,0,0,0)
    var playerturn = 1
    var totalSelectionBoxes = 1
    lateinit var binding: ActivityMainBinding
    lateinit var dialog: Dialog
    lateinit var dialog1: Dialog



    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dialog = Dialog(this)
        dialog.setContentView(R.layout.custon_dialog)
        dialog1 = Dialog(this)
        dialog1.setContentView(R.layout.draw_dialog_box)


        binding.player1.text = intent.getStringExtra(add_number_of_players.key1)
        binding.player2.text = intent.getStringExtra(add_number_of_players.key2)
        combinationList.add(arrayListOf(0,1,2))
        combinationList.add(arrayListOf(3,4,5))
        combinationList.add(arrayListOf(6,7,8))
        combinationList.add(arrayListOf(0,3,6))
        combinationList.add(arrayListOf(1,4,7))
        combinationList.add(arrayListOf(2,5,8))
        combinationList.add(arrayListOf(2,4,6))
        combinationList.add(arrayListOf(0,4,8))
        binding.player1layout.setBackgroundResource(R.drawable.blue_broder)

        binding.one.setOnClickListener {
            if (isBoxselectable(0)){
                performaction(binding.one,0)

            }
        }

        binding.two.setOnClickListener {
            if (isBoxselectable(1)){
                performaction(binding.two,1)

            }
        }
        binding.three.setOnClickListener {
            if (isBoxselectable(2)){
                performaction(binding.three,2)

            }
        }
        binding.four.setOnClickListener {
            if (isBoxselectable(3)){
                performaction(binding.four,3)

            }
        }

        binding.five.setOnClickListener {
            if (isBoxselectable(4)){
                performaction(binding.five,4)

            }
        }
        binding.six.setOnClickListener {
            if (isBoxselectable(5)){
                performaction(binding.six,5)

            }
        }
        binding.seven.setOnClickListener {
            if (isBoxselectable(6)){
                performaction(binding.seven,6)

            }
        }
        binding.eight.setOnClickListener {
            if (isBoxselectable(7)){
                performaction(binding.eight,7)

            }
        }
        binding.nine.setOnClickListener {
            if (isBoxselectable(8)){
                performaction(binding.nine,8)

            }
        }


    }

    fun performaction(imageView: ImageView,selectedbocpostion: Int){
        boxPostions[selectedbocpostion]= playerturn
        if(playerturn == 1){
            imageView.setImageResource(R.drawable.cross3)
            if(checkplayerwin()){
                dialogwork(binding.player1.text.toString()+" has won the match")
                dialog.setCancelable(false)
                dialog.show()
            }
            else if (totalSelectionBoxes==9){
                dialogwork1()
                dialog1.setCancelable(false)
                dialog1.show()

            }
            else{
                changeplayerturn(2)
                totalSelectionBoxes++
            }
        }
        else{
            imageView.setImageResource(R.drawable.circle3)
            if(checkplayerwin()){
                dialogwork(binding.player2.text.toString()+" has won the match")
                dialog.setCancelable(false)
                dialog.show()
            }
            else if (selectedbocpostion==9){
                dialogwork1()
                dialog1.setCancelable(false)
                dialog1.show()

            }
            else{
                changeplayerturn(1)
                totalSelectionBoxes++
            }

        }
    }
    fun changeplayerturn(currentplayerturn : Int){
        playerturn = currentplayerturn
        if(playerturn==1){
            binding.player1layout.setBackgroundResource(R.drawable.blue_broder)
            binding.player2layout.setBackgroundResource(R.drawable.levender)
        }
        else{
            binding.player2layout.setBackgroundResource(R.drawable.blue_broder)
            binding.player1layout.setBackgroundResource(R.drawable.levender)
        }

    }
    fun checkplayerwin():Boolean{
        var response : Boolean = false
        for(i in 0..<combinationList.size){
            var combination = combinationList.get(i)
            if (boxPostions[combination[0]]==playerturn && boxPostions[combination[1]]==playerturn && boxPostions[combination[2]]==playerturn){
                response = true
            }
        }
        return response

    }
    private fun isBoxselectable(boxpostion:Int):Boolean{
        var response:Boolean = false
        if(boxPostions[boxpostion]==0){
            response = true
        }
        return response
    }
    fun dialogwork (winner : String){
        var startagain = dialog.findViewById<AppCompatButton>(R.id.startagain)
        var winner_name = dialog.findViewById<TextView>(R.id.winnername)
        winner_name.text = winner.toString()
        startagain.setOnClickListener {
            restartmatch()
            dialog.dismiss()
        }
    }
    fun dialogwork1 (){
        var startagain = dialog1.findViewById<AppCompatButton>(R.id.startagain1)
        startagain.setOnClickListener {
            restartmatch()
            dialog1.dismiss()
        }
    }
    fun restartmatch(){
        boxPostions  = arrayOf(0,0,0,0,0,0,0,0,0)
        playerturn =1
        totalSelectionBoxes=1
        binding.one.setImageResource(R.drawable.rectangle)
        binding.two.setImageResource(R.drawable.rectangle)
        binding.three.setImageResource(R.drawable.rectangle)
        binding.four.setImageResource(R.drawable.rectangle)
        binding.five.setImageResource(R.drawable.rectangle)
        binding.six.setImageResource(R.drawable.rectangle)
        binding.seven.setImageResource(R.drawable.rectangle)
        binding.eight.setImageResource(R.drawable.rectangle)
        binding.nine.setImageResource(R.drawable.rectangle)


    }

}