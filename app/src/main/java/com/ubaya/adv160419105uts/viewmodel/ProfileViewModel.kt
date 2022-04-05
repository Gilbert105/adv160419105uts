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
import com.ubaya.adv160419105uts.model.Profile

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    val profileLiveData = MutableLiveData<Profile>()
    private  var queue: RequestQueue? = null
    val TAG = "volleyTag"
    fun fetch(){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/Gilbert105/907cf82e24cfae3e68aee17c362aa4fa/raw/8660ec26ec718a6a3d4f3ce22d1e6bcbd01c7326/profile.json"
        val stringRequest = StringRequest(
            Request.Method.GET,url,
            {
                val sType = object : TypeToken<Profile>() {}.type
                //val result = Gson().fromJson<Profile>(it, sType)
                val result = Gson().fromJson<Profile>(it,sType)
                profileLiveData.value = result
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