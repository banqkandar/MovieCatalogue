package com.example.iskandar.movieui.ui;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.iskandar.movieui.R;
import com.example.iskandar.movieui.adapters.MovieAdapter;
import com.example.iskandar.movieui.models.Movie;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] dataJudul, dataDeskripsi, dataGenre, dataDurasi, dataRating;
    private TypedArray dataGambar;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_movie);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveWithObject = new Intent(HomeActivity.this, MovieDetailActivity.class);

                moveWithObject.putExtra(MovieDetailActivity.EXTRA_MOVIE, (Movie) adapterView.getItemAtPosition(i));
                startActivity(moveWithObject);
            }
        });
    }

    @Override
    public void onClick(View v) {
        //
    }

    private void addItem() {

        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i < dataJudul.length; i++) {
            Movie movie = new Movie();
            movie.setGambar(dataGambar.getResourceId(i, -1));
            movie.setJudul(dataJudul[i]);
            movie.setDeskripsi(dataDeskripsi[i]);
            movie.setGenre(dataGenre[i]);
            movie.setDurasi(dataDurasi[i]);
            movie.setRating(dataRating[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
        dataDurasi = getResources().getStringArray(R.array.data_duration);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataRating = getResources().getStringArray(R.array.data_rating);
        dataGambar = getResources().obtainTypedArray(R.array.data_gambar);
    }


}
