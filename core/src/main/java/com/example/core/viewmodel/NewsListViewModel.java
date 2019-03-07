package com.example.core.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class NewsListViewModel {

    private List<NewsViewModel> models = new ArrayList<>();

    public List<NewsViewModel> getModels() {
        return models;
    }

    public void setModels(List<NewsViewModel> models) {
        this.models = models;
    }

    public void setModel(NewsViewModel model) {
        this.models.add(model);
    }
}
