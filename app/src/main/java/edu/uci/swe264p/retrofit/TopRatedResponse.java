package edu.uci.swe264p.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopRatedResponse {

    @SerializedName("results")
    public List<Movie> topRateMovies;

    public TopRatedResponse(List<Movie> topRateMovies) {
        this.topRateMovies = topRateMovies;
    }

}
