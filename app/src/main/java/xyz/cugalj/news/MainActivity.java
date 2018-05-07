package xyz.cugalj.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import xyz.cugalj.news.controler.JsonObjectNewsApi;
import xyz.cugalj.news.controler.VolleyResponseListener;
import xyz.cugalj.news.model.News;

public class MainActivity extends AppCompatActivity {

    private JsonObjectNewsApi jsonObjectNewsApi;
    TextView txtNaslov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonObjectNewsApi = new JsonObjectNewsApi();

        TextView txtNaslov = findViewById(R.id.txtNaslov);
        Button btnStart = findViewById(R.id.button);
        data();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data();
                //Log.e("VELICINA LISTE: ", Integer.toString(jsonObjectRequest.getNESTO().size()));

                for (News n : jsonObjectNewsApi.getNewsDataArray()) {
                    Log.e("TITLE: ", n.getTitle() + "  ||  TIME: " + n.getPublishedAt());
                }

            }
        });
    }

    private void data() {
        jsonObjectNewsApi.getNewsData(this, new VolleyResponseListener() {

            @Override
            public void onResponse(Object response) {
                Log.e("onResponse ", response.toString());
                //Log.e("SIZE ", Integer.toString(jsonObjectNewsApi.getNewsDataArray().size()));
            }

            @Override
            public void onError(String message) {
                Log.e("onError ", message);
            }
        });
    }
}
