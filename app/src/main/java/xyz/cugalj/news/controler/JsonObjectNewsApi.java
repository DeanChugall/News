package xyz.cugalj.news.controler;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import xyz.cugalj.news.model.News;
import xyz.cugalj.news.model.NewsApi;

public class JsonObjectNewsApi {

    public ArrayList<News> getNewsDataArray() {
        return newsDataArray;
    }

    private ArrayList<News> newsDataArray;

    private String urlBase = "https://newsapi.org/v2/";
    private String category = "top-headlines";
    private String country = "rs";
    private String apiKey = "a26922e96e604e14970efcf9a0cffe83";

    private String finaApiUrl = new NewsApi(urlBase, category, country, apiKey).constructAPI();

    public void getNewsData(Context context, final VolleyResponseListener listener) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (finaApiUrl, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        newsDataArray = new ArrayList<>();
                        try {

                            JSONArray newsArticle = response.getJSONArray("articles");

                            for (int i = 0; i < newsArticle.length(); i++) {

                                JSONObject newArticleObject = newsArticle.getJSONObject(i);

                                JSONObject newsSourceObject = newArticleObject.getJSONObject("source");
                                String name = newsSourceObject.getString("name");

                                String author = newArticleObject.getString("author");

                                if (author == "null") {
                                    author = "Nepoznat Autor";
                                }

                                String title = newArticleObject.getString("title");
                                String description = newArticleObject.getString("description");
                                String url = newArticleObject.getString("url");
                                String urlToImage = newArticleObject.getString("urlToImage");
                                String publishedAt = newArticleObject.getString("publishedAt");

                                News newsObject = new News(name, author, title, description, url, urlToImage, publishedAt);

                                newsDataArray.add(newsObject);

                        /*Log.e("AUTOR JSON ",
                                "AUTOR:    " + newsObject.getAuthor() + "\n" +
                                        "NASLOV:    " + newsObject.getTitle() + "\n" +
                                        "OPIS:    " + newsObject.getDescription() + "\n" +
                                        "URL:    " + newsObject.getUrl() + "\n" +
                                        "IMAGE URL:   " + newsObject.getUrlToImage() + "\n" +
                                        "OBJAVLJENO:    " + newsObject.getPublishedAt());*/
                            }

                        } catch (JSONException e) {
                            Log.e("ERROR", e.getLocalizedMessage());
                        }
                        listener.onResponse(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error.toString());
                    }
                });

        NewsJsonSingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}


