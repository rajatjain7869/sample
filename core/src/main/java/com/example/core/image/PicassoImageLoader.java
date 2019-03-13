package com.example.core.image;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoImageLoader implements IImageLoader {

    @Override
    public void loadImage(Context ctx, ImageView imageView, String image) {
        Picasso.with(ctx).load(image).into(imageView);
    }
}
