package com.example.app91920

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.app91920.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirm.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("餐點確認")
                .setMessage("是否確認送出訂單?")
                .setPositiveButton("是") { dialog, _ ->
                    var tot = 0
                    var main = ""
                    var drinks = ""
                    var dessert1 = ""
                    var dessert2 = ""
                    when (binding.mainGroup.checkedRadioButtonId) {
                        R.id.rdbRice -> {
                            tot += 120
                            main = "蝦仁蛋炒飯 120元"
                        }

                        R.id.rdbNoodles -> {
                            tot += 230
                            main = "紅燒牛肉麵 230元"
                        }

                        R.id.rdbMilk -> {
                            tot += 280
                            main = "牛奶鍋 280元"
                        }
                    }
                    when (binding.drinksGroup.checkedRadioButtonId) {
                        R.id.rdbWhite -> {
                            tot += 70
                            drinks = "白玉歐蕾 70元"
                        }

                        R.id.rdbMarry -> {
                            tot += 230
                            drinks = "血腥瑪麗 230元"
                        }
                    }
                    if (binding.chbHorse.isChecked) {
                        tot += 45
                        dessert1 = "馬卡龍 45元"
                        if (binding.chbDuck.isChecked) {
                            tot += 65
                            dessert2 = " 達克瓦茲 65元"
                        }
                    }
                    else if (binding.chbDuck.isChecked) {
                        tot += 65
                        dessert1 = " 達克瓦茲 65元"
                    }

                    val intent = Intent().apply {
                        putExtra("tot", tot)
                        putExtra("main", main)
                        putExtra("drinks", drinks)
                        putExtra("dessert1", dessert1)
                        putExtra("dessert2", dessert2)
                    }
                        setResult(RESULT_OK, intent)
                        finish()
                }
                .setNegativeButton("還沒") { _, _ ->
                }
                .show()
        }
    }
}