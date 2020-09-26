package com.example.exelino11rpl022019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
public class DetailMovie extends AppCompatActivity {

        Bundle extras;
        String title;
        String date;
        String deskripsi;
        String path;
        String id;

        TextView tvnamedetail;
        ImageView ivdetail;
        TextView tvdescdetail;
        Button btnbookmark;

        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_detail_movie);
                extras = getIntent().getExtras();
                tvnamedetail = (TextView) findViewById(R.id.tvnamedetail);
                tvdescdetail = (TextView) findViewById(R.id.tvdescdetail);
                ivdetail = (ImageView) findViewById(R.id.ivdetail);
                btnbookmark = (Button) findViewById(R.id.btnbookmark);

                if (extras != null) {
                        title = extras.getString("judul");
                        id = extras.getString("id");
                        date = extras.getString("date");
                        deskripsi = extras.getString("deskripsi");
                        path = extras.getString("path");
                        tvnamedetail.setText(title);
                        tvdescdetail.setText(deskripsi);
                        Glide.with(DetailMovie.this)
                                .load(path)
                                .override(Target.SIZE_ORIGINAL)
                                .placeholder(R.mipmap.ic_launcher)
                                .into(ivdetail);
                        // and get whatever type user account id is
                }
        }
}



