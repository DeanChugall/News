package xyz.cugalj.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import xyz.cugalj.news.controler.JsonObjectNewsApi;
import xyz.cugalj.news.controler.MyAdapter;
import xyz.cugalj.news.controler.VolleyResponseListener;
import xyz.cugalj.news.model.News;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private JsonObjectNewsApi jsonObjectNewsApi;
    private TextView txtNaslov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNaslov = findViewById(R.id.txtNaslov);
        Button btnStart = findViewById(R.id.button);
        mRecyclerView = findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        init(); // start initialisation

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data();
            }
        });
    }

    private void data() {

        jsonObjectNewsApi.getNewsData(this, new VolleyResponseListener() {

            @Override
            public void onResponse(Object response) {
                Log.e("onResponse ", response.toString());
                //TODO ne popunjava se kada se na klik dugmeta objavi nova vest
                txtNaslov.setText(jsonObjectNewsApi.getNewsDataArray().get(0).getTitle());

                mAdapter = new MyAdapter(jsonObjectNewsApi.getNewsDataArray());
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onError(String message) {
                Log.e("onError ", message);
            }
        });
    }

    private void init() {
        jsonObjectNewsApi = new JsonObjectNewsApi();
        data();
    }
}
