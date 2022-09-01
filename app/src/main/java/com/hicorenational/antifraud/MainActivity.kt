package com.hicorenational.antifraud

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainScope().launch(Dispatchers.IO) {
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.apply {
                setMessage("很抱歉，${getString(R.string.app_name)}已停止运行")
                setPositiveButton("关闭应用") { _, _ -> this@MainActivity.finish() }
                setCancelable(false)
            }
            delay(3000)
            withContext(Dispatchers.Main) {
                builder.show()
            }
        }
    }
}