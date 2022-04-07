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


class KosDetailViewModel(application: Application) : AndroidViewModel(application) {
    val kosDetailLiveData = MutableLiveData<Kos>()
    private  var queue: RequestQueue? = null
    val TAG = "volleyTag"
    fun fetch(idkos:String){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/Gilbert105/68858e6725ea0bb68393d61dfccfa549/raw/a3b6915eb39c4aeb2c072d38f8a7936d6a850d4f/kos"
        val stringRequest = StringRequest(
            Request.Method.GET,url,
            {
                val sType = object : TypeToken<ArrayList<Kos>>() {}.type
                //val result = Gson().fromJson<Profile>(it, sType)
                val result = Gson().fromJson<ArrayList<Kos>>(it,sType)
                for(item in result){
                    if(item.id_kos.toString() == idkos){
                        kosDetailLiveData.value = item
                    }
                }

                Log.d("showVolley",result.toString())
            },
            {
                Log.d("errorVolley",it.toString())
            }
        ).apply {
            tag = "TAG"
        }
        queue?.add(stringRequest)
    }
}