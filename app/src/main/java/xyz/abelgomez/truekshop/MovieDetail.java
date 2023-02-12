package xyz.abelgomez.truekshop;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetail extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.titleTextView)
    TextView mTitleTextView;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.ratingTextView)
    TextView mRatingTextView;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.posterImge)
    ImageView mPosterImage;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.descriptionTextView)
    TextView mDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ButterKnife.bind(this);
        String mId= Objects.requireNonNull(getIntent().getExtras()).getString("id");

        int id=Integer.parseInt(Objects.requireNonNull(mId));

        String[] image = getResources().getStringArray(R.array.url);
        String[] title = getResources().getStringArray(R.array.title);
        String[] rating = getResources().getStringArray(R.array.rating);
        String[] description = getResources().getStringArray(R.array.description);


        mTitleTextView.setText(title[id]);
        mRatingTextView.setText(rating[id]);
        mDescriptionTextView.setText(description[id]);

        Glide.with(this.getApplicationContext())
                .load(image[id])
                .into(mPosterImage);
    }
}
