package com.syw.adapter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.syw.adapter.databinding.ActivityMainBinding;
import com.syw.adapterlib.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MyAdapter adapter = new MyAdapter(R.layout.item_layout, BR.texts);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.setAdapter(adapter);
        final List<TestBean> testBeans = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            testBeans.add(new TestBean("i1:" + i, "i2:" + i));
        }
        adapter.setDatas(testBeans);

        adapter.setOnViewClickListener(new int[]{R.id.parent, R.id.text1, R.id.text2}, new MyAdapter.OnViewClickListener() {
            @Override
            public void onViewClick(View view, int position) {
                switch (view.getId()) {
                    case R.id.parent:
                        Toast.makeText(MainActivity.this, "parent:" + position, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.text1:
                        Toast.makeText(MainActivity.this, "text1:" + position, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.text2:
                        Toast.makeText(MainActivity.this, "text2:" + position, Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

    }
}
