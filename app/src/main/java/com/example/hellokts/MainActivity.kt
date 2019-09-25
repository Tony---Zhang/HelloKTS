package com.example.hellokts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial.Msg
import com.example.tutorial.SecondMsg

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val msg = Msg.newBuilder()
            .setFoo("foo")
            .setBlah(SecondMsg.newBuilder().setBlah(1).build())
            .build()

        println("msg: ${msg.foo}, blah: ${msg.blah.blah}")
    }
}
