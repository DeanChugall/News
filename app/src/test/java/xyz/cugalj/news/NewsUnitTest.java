package xyz.cugalj.news;

import org.junit.Test;

import xyz.cugalj.news.model.NewsApi;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NewsUnitTest {

    private MainActivity mainActivity;

    String exepted = "https://newsapi.org/v2/top-headlines?country=rs&apiKey=a26922e96e604e14970efcf9a0cffe83";

    private String urlBase = "https://newsapi.org/v2/";
    private String category = "top-headlines";  // later to change
    private String country = "rs";
    private  String API_KEY = "a26922e96e604e14970efcf9a0cffe83";

    @Test
    public void testtest() {

        NewsApi newsApi = mock(NewsApi.class);
        when(newsApi.constructAPI()).thenReturn(exepted);
        assertEquals(newsApi.constructAPI(), exepted);
    }
    /*@Test
    public void addition_isCorrect() {
        mainActivity = new MainActivity();
        String geteed = mainActivity.getFinalUri();
        assertEquals(exepted, geteed);
    }*/
}