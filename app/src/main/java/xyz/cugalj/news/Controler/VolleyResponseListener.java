package xyz.cugalj.news.Controler;

public interface VolleyResponseListener {

    void onError(String message);

    void onResponse(Object response);
}
