package xyz.cugalj.news.controler;

public interface VolleyResponseListener {

    void onError(String message);

    void onResponse(Object response);
}
