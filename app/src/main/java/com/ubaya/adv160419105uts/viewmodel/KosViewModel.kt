package com.ubaya.adv160419105uts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.adv160419105uts.model.Kos

class KosViewModel(application: Application) : AndroidViewModel(application) {
    val kosLiveData = MutableLiveData<ArrayList<Kos>>()
    val kosLoadErrorLiveData = MutableLiveData<Boolean>()
    val loadingLiveData = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private  var queue: RequestQueue? = null
    fun refresh(){
        kosLoadErrorLiveData.value = false
        loadingLiveData.value = true
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/Gilbert105/68858e6725ea0bb68393d61dfccfa549/raw/a3b6915eb39c4aeb2c072d38f8a7936d6a850d4f/kos"
        val stringRequest = StringRequest(
            Request.Method.GET,url,
            {
                val sType = object: TypeToken<ArrayList<Kos>>() {}.type
                val result = Gson().fromJson<ArrayList<Kos>>(it,sType)
                kosLiveData.value = result
                loadingLiveData.value =false
                Log.d("showVolley",result.toString())
            },
            {
                loadingLiveData.value =false
                kosLoadErrorLiveData.value = true
                Log.d("errorVolley",it.toString())
            }
        ).apply {
            tag = "TAG"
        }
        queue?.add(stringRequest)
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

}