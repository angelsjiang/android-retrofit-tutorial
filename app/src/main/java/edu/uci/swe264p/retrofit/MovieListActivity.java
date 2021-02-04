package edu.uci.swe264p.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MovieListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private List<TopRatedResponse> movies;

    static final String TAG = MainActivity.class.getSimpleName();
    static final String BASE_URL = "https://api.themoviedb.org/3/";
    static Retrofit retrofit = null;
    final static String API_KEY = "e96d6f7be02bb2c5f80b997b42c2522f";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        movies = connect();

        recyclerView = findViewById(R.id.rvMovieList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MovieListAdapter(movies));

    }

    private List<TopRatedResponse> connect() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        MovieApiService movieApiService = retrofit.create(MovieApiService.class);
        Call<Movie> call = movieApiService.getMovie(603, API_KEY);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                System.out.println("hola?");
                System.out.println("Response: " + response.body().getTitle());


//                int[] ids = {R.id.tvTitle, R.id.tvReleaseDate, R.id.ivMovie,
//                        R.id.tvVote, R.id.tvOverview};
//                String[] values = {
//                        response.body().getTitle(),
//                        response.body().getReleaseDate(),
//                        response.body().getPosterPath(),
//                        response.body().getVoteAverage().toString(),
//                        response.body().getOverview()
//                };
//
//                movies = ;
//
//                TextView tv;
//                for (int i=0; i < ids.length; i++) {
//                    System.out.println("ID: " + ids[i]);
//                    tv = findViewById(ids[i]);
//                    System.out.println("Values: " + values[i]);
//                    tv.setText(values[i]);
//                }
            }
            @Override
            public void onFailure(Call<Movie> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });

        return movies;
    }
}
