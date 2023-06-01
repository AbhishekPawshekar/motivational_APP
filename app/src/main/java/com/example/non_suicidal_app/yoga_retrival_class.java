package com.example.non_suicidal_app;

public class yoga_retrival_class {
    String category,description,name,tip,url;

    public yoga_retrival_class() {

    }

    public yoga_retrival_class(String category, String description, String name, String tip, String url) {
        this.category = category;
        this.description = description;
        this.name = name;
        this.tip = tip;
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
