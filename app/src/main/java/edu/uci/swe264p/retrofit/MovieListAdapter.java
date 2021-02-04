package edu.uci.swe264p.retrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private TopRatedResponse data;

    MovieListAdapter(TopRatedResponse data) { this.data = data; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvTitle;
        TextView tvReleaseDate;
        TextView tvVote;
        TextView tvOverview;


        ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ivMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
            tvVote = itemView.findViewById(R.id.tvVote);
            tvOverview = itemView.findViewById(R.id.tvOverview);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        TopRatedResponse movies = data;
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(viewHolder.img);

//        viewHolder.img.setImageResource("https://image.tmdb.org/t/p/w500", data.topRateMovies.get(position).getPosterPath());
        viewHolder.tvTitle.setText(data.topRateMovies.get(position).getTitle());
        viewHolder.tvReleaseDate.setText(data.topRateMovies.get(position).getReleaseDate());
        viewHolder.tvVote.setText(data.topRateMovies.get(position).getVoteAverage().toString());
        viewHolder.tvOverview.setText(data.topRateMovies.get(position).getOverview());
    }

    @Override
    public int getItemCount() { return data.topRateMovies.size(); }


}
