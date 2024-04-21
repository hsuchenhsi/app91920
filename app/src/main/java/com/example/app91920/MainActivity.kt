//11056009 宋繼平  11056019 陳宜佳  11056020 許宸熙

package com.example.app91920

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.app91920.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val data = result.data
                    if (data != null) {
                        binding.txtMain.text = data.getStringExtra("main")
                        binding.txtDrinks.text = data.getStringExtra("drinks")
                        binding.txtDessert.text = data.getStringExtra("dessert1")
                        binding.txtDessert2.text = data.getStringExtra("dessert2")
                        binding.txtTotal.text = data.getIntExtra("tot", 0).toString()

                    }
                }
            }
        binding.btnOrder.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            launcher.launch(intent)
        }
    }
}