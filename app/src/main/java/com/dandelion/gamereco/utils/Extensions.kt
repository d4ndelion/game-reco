package com.dandelion.gamereco.utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <DATA> Fragment.observe(liveData: LiveData<DATA>, action: (DATA) -> Unit) {
    liveData.observe(viewLifecycleOwner, Observer(action))
}

fun View.doOnClick(action: () -> Unit) {
    setOnClickListener {
        action.invoke()
    }
}
