package com.syw.adapter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import com.syw.adapter.databinding.ActivityMainBinding;
import com.syw.adapterlib.adapter.MyAdapter;
import com.syw.adapter.BR;

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
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });

        adapter.setOnViewClickListener(R.id.text1, new MyAdapter.OnViewClickListener() {
            @Override
            public void onViewClick(View view, int position) {
                Toast.makeText(MainActivity.this, "view:" + testBeans.get(position).getText1(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
