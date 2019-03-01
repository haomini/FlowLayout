package com.example.swipeview.test_recycler;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.example.swipeview.R;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2019/1/24
 * @Contact 605626708@qq.com
 */
public class TestRcyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_recycler_1);

        ViewPager viewPager = findViewById(R.id.vp);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return TestRecyclerFragment.newInstance(i);
            }

            @Override
            public int getCount() {
                return 7;
            }
        });
    }
}
