package com.example.core.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.core.application.BaseApplication;

public class NewsViewModel extends BaseObservable {

    private String title;
    private String descriptionUrl;
    private String imageUrl;
    private String date;
    private String viewCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptionUrl() {
        return descriptionUrl;
    }

    public void setDescriptionUrl(String descriptionUrl) {
        this.descriptionUrl = descriptionUrl;
    }


    @BindingAdapter("image")
    public static void loadImage(ImageView view, String imageUrl) {
        if (imageUrl == null || imageUrl.isEmpty()) {
            imageUrl = "https://images.immedia.com.br//32/32623_2_L.jpg";
        }
        Log.d("Image", imageUrl);
        BaseApplication.getInstance().getImageLoader().loadImage(view.getContext(),
                view, imageUrl);

    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public void onClickRow(View view) {
        Toast.makeText(view.getContext(), "Clicked..", Toast.LENGTH_SHORT).show();
    }
}
