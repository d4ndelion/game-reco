package com.dandelion.gamereco.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun setImageSource(view: ImageView, sourceUrl: String?) {
    if (sourceUrl == null) return
    Glide
        .with(view.context)
        .load(sourceUrl)
        .into(view)
}
