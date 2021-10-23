package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editTextTextPersonName:EditText
        val tv_text: TextView
        var tv_name:TextView
        var tv_winner:TextView
        var tv_mmora:TextView
        var tv_cmora:TextView
        val btn_scissor: RadioButton
        var btn_stone:RadioButton
        var btn_paper:RadioButton
        val btn_mora: Button

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName)
        tv_text = findViewById(R.id.tv_text)
        tv_name = findViewById(R.id.tv_name)
        tv_winner = findViewById(R.id.tv_winner)
        tv_mmora = findViewById(R.id.tv_mmora)
        tv_cmora = findViewById(R.id.tv_cmora)
        btn_scissor = findViewById(R.id.btn_scissor)
        btn_stone = findViewById(R.id.btn_stone)
        btn_paper = findViewById(R.id.btn_paper)
        btn_mora = findViewById(R.id.btn_mora)


        btn_mora.setOnClickListener {
          //判斷Edittext的字數是否小於一，若成立則無法進行猜拳
            if(editTextTextPersonName.length()<1) {
                tv_text.text = "請輸入玩家姓名"
                return@setOnClickListener
            }

            //取出EditText文字作為姓名並用變數儲存
            val playerName=editTextTextPersonName.text
            //亂數產生介於0~1之間不含1的小數，將其乘以3變成0~2後，取整數作為電腦的出拳
            val comMora =(Math.random()*3).toInt()
            //將玩家出拳結果對應成字串並用變數儲存
            val playerMoraText=when {
                btn_scissor.isChecked -> "剪刀"
                btn_stone.isChecked -> "石頭"
                else -> "布"
            }
            //將電腦出拳結果對應成字串並用變數儲存
            val comMoraText= when(comMora) {
            0 -> "剪刀"
            1 -> "石頭"
            else -> "布"
            }
            //顯示玩家姓名與雙方出拳結果
            tv_name.text="名字\n$playerName"
            tv_mmora.text="我方出拳\n$playerMoraText"
            tv_cmora.text = "電腦出拳\n$comMoraText"
            //用三個判斷是決定勝負並顯示猜拳結果
            when {
                btn_scissor.isChecked&&comMora == 2 ||
                        btn_stone.isChecked && comMora == 0 ||
                        btn_paper.isChecked && comMora == 1-> {
                    tv_winner.text = "勝利者\n$playerName"
                    tv_text.text = "恭喜你獲勝了！！！"
                }
                btn_scissor.isChecked && comMora == 1 ||
                        btn_stone.isChecked && comMora == 2 ||
                        btn_paper.isChecked && comMora == 0 -> {
                    tv_winner.text = "勝利者\n電腦"
                    tv_text.text = "可惜，電腦獲勝了！"
                }
                else -> {
                    tv_winner.text = "勝利者\n平手"
                    tv_text.text = "平局，請再試一次！"

                }
            }
        }
    }
}




