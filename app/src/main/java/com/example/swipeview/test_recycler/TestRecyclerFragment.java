package com.example.swipeview.test_recycler;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.swipeview.R;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2019/1/28
 * @Contact 605626708@qq.com
 */
public class TestRecyclerFragment extends Fragment {

    private static final String TAG = "TestRecyclerFragment";

    private int i;

    public static TestRecyclerFragment newInstance(int i) {
        TestRecyclerFragment testRecyclerFragment = new TestRecyclerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("int", i);
        testRecyclerFragment.setArguments(bundle);
        return testRecyclerFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i = getArguments().getInt("int");
        Log.e(TAG + i, "onCreate: ");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_fragment_else, container, false);
        Log.e(TAG + i, "onCreateView: ");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG + i, "onViewCreated: ");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e(TAG + i, "setUserVisibleHint: " + isVisibleToUser);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG + i, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG + i, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG + i, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG + i, "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG + i, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG + i, "onDestroy: ");
    }
}
