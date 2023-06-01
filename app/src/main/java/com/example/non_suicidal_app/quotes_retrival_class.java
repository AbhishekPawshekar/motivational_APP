package com.example.non_suicidal_app;

public class quotes_retrival_class {
    String url,category;

    public quotes_retrival_class() {

    }

    public quotes_retrival_class(String url, String category) {
        this.url = url;
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
