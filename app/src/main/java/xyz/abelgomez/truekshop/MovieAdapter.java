package xyz.abelgomez.truekshop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private final List<Movie> mMovieList;

    public MovieAdapter(List<Movie> movieList) {
        mMovieList = movieList;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.onBind(position);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));

    }

    @Override
    public int getItemCount() {
        assert mMovieList != null;
        return mMovieList.size();
    }

    public void addItems(List<Movie> movieList) {
        mMovieList.addAll(movieList);
    }

    public class ViewHolder extends MovieViewHolder {

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.posterImge)
        ImageView posterImageView;

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.titleTextView)
        TextView titleTextView;

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.infoTextView)
        TextView infoTextView;

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.ratingTextView)
        TextView ratingTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            posterImageView.setImageDrawable(null);
            titleTextView.setText("");
            infoTextView.setText("");
            ratingTextView.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final Movie mMovie = mMovieList.get(position);

            if (mMovie.getUrl() != null) {
                Glide.with(itemView.getContext())
                        .load(mMovie.getUrl())
                        .into(posterImageView);
            }

            if (mMovie.getTitle() != null) {
                titleTextView.setText(mMovie.getTitle());
            }

            if (mMovie.getInfo() != null) {
                infoTextView.setText(mMovie.getInfo());
            }

            if (mMovie.getRating() != null) {
                ratingTextView.setText(mMovie.getRating());
            }

            itemView.setOnClickListener(v -> {
                Intent intent=new Intent(itemView.getContext(), MovieDetail.class);
                intent.putExtra("id", mMovie.getId());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}