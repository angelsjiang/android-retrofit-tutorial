package edu.uci.swe264p.retrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private List<TopRatedResponse> data;

    MovieListAdapter(List<TopRatedResponse> data) { this.data = data; }

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
        List<TopRatedResponse> movies = data;
//        viewHolder.img.setImageResource(data.getPosterPath());
        viewHolder.tvTitle.setText(data.get(position).getMvTitle());
        viewHolder.tvReleaseDate.setText(data.get(position).getReleaseDate());
        viewHolder.tvVote.setText(data.get(position).getVoteAverage().toString());
        viewHolder.tvOverview.setText(data.get(position).getOverview());
    }

    @Override
    public int getItemCount() { return data.size(); }


}
