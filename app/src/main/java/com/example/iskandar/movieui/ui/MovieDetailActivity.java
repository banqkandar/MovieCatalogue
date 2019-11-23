package com.example.iskandar.movieui.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iskandar.movieui.R;
import com.example.iskandar.movieui.models.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    String Judul, Rating, Deskripsi, Genre, Durasi;
    int Gambar;

    public static final String EXTRA_MOVIE = "information";

    private TextView tv_judul, tv_deskripsi, tv_rating, tv_genre, tv_durasi;
    private ImageView MovieImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        MovieImg = findViewById(R.id.img_poster);
        tv_judul = findViewById(R.id.txt_title);
        tv_rating = findViewById(R.id.txt_user_score);
        tv_genre = findViewById(R.id.txt_genres);
        tv_durasi = findViewById(R.id.txt_runtime);
        tv_deskripsi = findViewById(R.id.txt_overview);

//        ArrayList<Movie> movie = this.getIntent().getParcelableArrayListExtra(EXTRA_MOVIE);
        Movie movie = this.getIntent().getParcelableExtra(EXTRA_MOVIE);
        Gambar = movie.getGambar();
        MovieImg.setImageResource(Gambar);

        Judul = movie.getJudul();
        tv_judul.setText(Judul);

        Rating = movie.getRating();
        tv_rating.setText(Rating);

        Genre = movie.getGenre();
        tv_genre.setText(Genre);

        Durasi = movie.getDurasi();
        tv_durasi.setText(Durasi);

        Deskripsi = movie.getDeskripsi();
        tv_deskripsi.setText(Deskripsi);
    }
}
