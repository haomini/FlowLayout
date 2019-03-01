package com.example.swipeview.test_anim

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.swipeview.R
import com.zhy.adapter.recyclerview.CommonAdapter
import com.zhy.adapter.recyclerview.base.ViewHolder
import kotlinx.android.synthetic.main.sv_test_anim.*

/**
 *
 * @author zhouhao
 * @since 2019/02/20
 */
class TestAnimActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sv_test_anim)

        recycler.adapter = object : CommonAdapter<String>(
            this@TestAnimActivity,
            android.R.layout.simple_dropdown_item_1line,
            listOf("1", "2", "3", "4", "5", "5", "1", "2", "3", "4", "5", "5", "1", "2", "3", "4", "5", "5")
        ) {
            override fun convert(holder: ViewHolder?, t: String?, position: Int) {
                holder?.setText(android.R.id.text1, t)
            }
        }

        recycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@TestAnimActivity)
        val snapHelper = androidx.recyclerview.widget.LinearSnapHelper()
        snapHelper.attachToRecyclerView(recycler)

        btn_anim.setOnClickListener {
            recycler.animate().rotation(45F).start()
        }
    }
}