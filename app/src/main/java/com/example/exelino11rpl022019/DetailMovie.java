package com.example.exelino11rpl022019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailMovie extends AppCompatActivity {
        Realm realm;
        RealmHelper realmHelper;
        ModelMovieRealm movieModel;

        Bundle extras;
        String title;
        String date;
        String deskripsi;
        String path;
        String id;

        TextView tvnamedetail;
        ImageView ivdetail;
        TextView tvdescdecri;
        Button btnbookmark;

        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_detail_movie);
                extras = getIntent().getExtras();
                tvnamedetail = findViewById(R.id.tvjuduld);
                tvdescdecri = findViewById(R.id.tvdescrip);
                ivdetail = findViewById(R.id.tvposter);
                btnbookmark = (Button) findViewById(R.id.btnbookmark);

                if (extras != null) {
                        title = extras.getString("judul");
                        id = extras.getString("id");
                        date = extras.getString("date");
                        deskripsi = extras.getString("deskripsi");
                        path = extras.getString("path");
                        tvnamedetail.setText(title);
                        tvdescdecri.setText(deskripsi);
                        Glide.with(DetailMovie.this)
                                .load(path)
                                .override(Target.SIZE_ORIGINAL)
                                .placeholder(R.mipmap.ic_launcher)
                                .into(ivdetail);
                        // and get whatever type user account id is
                }
                Realm.init(DetailMovie.this);
                RealmConfiguration configuration = new RealmConfiguration.Builder().build();
                realm = Realm.getInstance(configuration);


                btnbookmark.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                movieModel = new ModelMovieRealm();
                                movieModel.setDesc(deskripsi);
                                movieModel.setJudul(title);
                                movieModel.setPath(path);
                                movieModel.setReleaseDate(date);

                                realmHelper = new RealmHelper(realm);
                                realmHelper.save(movieModel);

                        }
                });
        }
}