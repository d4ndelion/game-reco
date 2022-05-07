package com.dandelion.gamereco.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
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

fun Context.showToast(@StringRes stringId: Int) {
    Toast.makeText(this, stringId, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(@StringRes stringId: Int) {
    requireContext().showToast(stringId)
}
