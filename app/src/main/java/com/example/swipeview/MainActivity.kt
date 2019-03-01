package com.example.swipeview

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.swipeview.test_recycler.TestRcyclerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val valueAnimator = ValueAnimator()
        valueAnimator.setFloatValues(0F, 1F)
        valueAnimator.duration = 3000
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.addUpdateListener {
            tv.progress = it.animatedValue as Float
        }
        valueAnimator.start()

        tv.setOnClickListener {
            startActivity(Intent(it.context, TestRcyclerActivity::class.java))
        }
    }
}
