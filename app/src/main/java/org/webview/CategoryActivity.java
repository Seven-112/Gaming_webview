package org.webview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.webview.Model.Adapter;

public class CategoryActivity extends AppCompatActivity {

    private String webSiteUrl = "";

    RecyclerView recyclerView;

    private String[] urlList = {
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights",
        "https://play.google.com/store/apps/details?id=com.adjust.insights"
    };

    private Integer[] imgid = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o,
            R.drawable.p,
            R.drawable.q,
            R.drawable.r,
            R.drawable.s,
            R.drawable.t,
            R.drawable.u,
            R.drawable.v,
            R.drawable.w,
            R.drawable.x,
            R.drawable.y,
            R.drawable.z,
            R.drawable.z_a,
            R.drawable.z_b,
            R.drawable.z_c,
            R.drawable.z_d,
            R.drawable.z_e,
            R.drawable.z_f,
            R.drawable.z_g,
            R.drawable.z_h,
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView = findViewById(R.id.recycleView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        Adapter adapter = new Adapter(CategoryActivity.this, imgid);
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void OnItemClicked(int position, View v) {
                Log.v(":", String.valueOf(position));
                webSiteUrl = urlList[position];
                Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
                intent.putExtra("URL", webSiteUrl);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

    }
}
