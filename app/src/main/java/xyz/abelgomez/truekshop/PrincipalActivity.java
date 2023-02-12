package xyz.abelgomez.truekshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PrincipalActivity extends AppCompatActivity {


    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    MovieAdapter mMovieAdapter;

    LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ButterKnife.bind(this);
        setUp();
    }

    private void setUp() {
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mMovieAdapter = new MovieAdapter(new ArrayList<>());

        prepareDemoContent();
    }

    private void prepareDemoContent() {

        ArrayList<Movie> mMovies = new ArrayList<>();
        String[] id= getResources().getStringArray(R.array.id);
        String[] url = getResources().getStringArray(R.array.url);
        String[] title = getResources().getStringArray(R.array.title);
        String[] info = getResources().getStringArray(R.array.precios);
        String[] rating = getResources().getStringArray(R.array.rating);
        String[] description = getResources().getStringArray(R.array.precios);

        for (int i = 0; i < id.length; i++) {
            mMovies.add(new Movie(id[i],title[i], info[i], rating[i], description[i],url[i]));
        }
        mMovieAdapter.addItems(mMovies);
        mRecyclerView.setAdapter(mMovieAdapter);

    }
}