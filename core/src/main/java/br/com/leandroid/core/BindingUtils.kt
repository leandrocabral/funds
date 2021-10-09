package br.com.leandroid.core

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("imageLoad")
fun imageLoad(view: ImageView, url: String) {
    view.load(url)
}

fun ImageView.load(url: String?) {
    Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.DATA)
        .into(this)
}