package com.dandelion.gamereco.utils.errors

import androidx.lifecycle.MutableLiveData

class ErrorLiveData : MutableLiveData<Int>() {

    fun sendError(errors: ERRORS) {
        postValue(errors.stringId)
    }
}
