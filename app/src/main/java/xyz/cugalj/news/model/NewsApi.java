package xyz.cugalj.news.model;

public class NewsApi {


    // https://newsapi.org/v2/top-headlines?country=rs&apiKey=a26922e96e604e14970efcf9a0cffe83

    // API KEY
    private String urlBase;
    private String category;
    private String country;
    private String ApiKey;

    public NewsApi(String urlBase, String category, String country, String apiKey) {
        this.urlBase = urlBase;
        this.category = category;
        this.country = country;
        this.ApiKey = apiKey;
    }

    public String getUrlBase() {
        return urlBase;
    }

    public void setUrlBase(String urlBase) {
        this.urlBase = urlBase;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getApiKey() {
        return ApiKey;
    }

    public void setApiKey(String apiKey) {
        ApiKey = apiKey;
    }

    public String constructAPI() {

        return urlBase + category + "?country=" + country + "&apiKey=" + ApiKey;
    }
}
