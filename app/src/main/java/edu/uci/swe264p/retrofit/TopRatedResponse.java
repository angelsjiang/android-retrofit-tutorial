package edu.uci.swe264p.retrofit;

import com.google.gson.annotations.SerializedName;

public class TopRatedResponse {
    @SerializedName("title")
    private String mvTitle;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("vote_average")
    private Float voteAverage;
    @SerializedName("overview")
    private String mvOverview;
    @SerializedName("poster_path")
    private String posterPath;

    public TopRatedResponse(String mvTitle, String releaseDate, Float voteAverage, String mvOverview, String posterPath) {
        this.mvTitle = mvTitle;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.mvOverview = mvOverview;
        this.posterPath = posterPath;
    }

    public String getMvTitle() {
        return mvTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public String getOverview() {
        return mvOverview;
    }

    public String getPosterPath() {
        return posterPath;
    }

}
