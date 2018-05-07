package xyz.cugalj.news.controler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import xyz.cugalj.news.R;
import xyz.cugalj.news.model.News;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private JsonObjectNewsApi jsonObjectNewsApi = new JsonObjectNewsApi();
    private ArrayList<News> arrayNews;


    public MyAdapter(ArrayList<News> news) {
        this.arrayNews = news;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return jsonObjectNewsApi.getNewsDataArray().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView.findViewById(R.id.txtNaslov);
        }
    }

}
