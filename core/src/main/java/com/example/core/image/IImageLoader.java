package com.example.core.image;

import android.content.Context;
import android.widget.ImageView;

public interface IImageLoader {

    public void loadImage(Context ctx, ImageView imageView, String image);
}
