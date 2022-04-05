package com.ubaya.adv160419105uts.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.ubaya.adv160419105uts.R
import java.lang.Exception


fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {

}
fun ImageView.loadImage(url: String?) {
    Picasso.get()
        .load(url)
        .resize(400,400)
        .centerCrop()
        .into(this, object : Callback {
            override fun onSuccess() {

            }

            override fun onError(e: Exception?) {
            }

        })
}
