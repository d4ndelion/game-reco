package com.dandelion.gamereco.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
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

@BindingAdapter("isVisible")
fun setVisibility(view: View, isVisible: Boolean) {
    view.isVisible = isVisible
}
