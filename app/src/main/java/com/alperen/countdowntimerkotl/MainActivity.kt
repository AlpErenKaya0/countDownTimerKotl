package com.alperen.countdowntimerkotl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.alperen.countdowntimerkotl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Buton tıklama olayını burada belirleyin
        binding.button.setOnClickListener {
            onClickedButton()
        }
    }

    private fun onClickedButton() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage("Are you sure?")
        alertDialogBuilder.setPositiveButton("Yes") { _, _ ->
            object : CountDownTimer(10000, 1000) {
                override fun onTick(p0: Long) {
                    binding.textView.text = "Left: ${p0 / 1000}"
                }

                override fun onFinish() {
                    binding.textView.visibility = View.VISIBLE
                    binding.textView.text = "Left: 0"
                    binding.textView3.visibility = View.VISIBLE
                }
            }.start()
            binding.textView.visibility = View.VISIBLE
        }
        alertDialogBuilder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}