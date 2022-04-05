package com.ubaya.adv160419105uts.model

import com.google.gson.annotations.SerializedName

data class Kos(
    //SerializedName dipakai jika data pada json berbeda dengan nama field di Android studio
    var id_kos:Int?,
    @SerializedName("student_name")
    var nama_kos:String?,
    @SerializedName("birth_of_date")
    var deskripsi:String?,
    var harga_kos:Int?,
    var review_kos:Review?,
    @SerializedName("photo_url")
    var fasilitas:String?,
    var peraturan:String?,
    var photo_kos:String?
)
data class Review(
    var kebersihan:String?,
    var keamanan:String?,
    var fasilitas_kamar:String?,
    var kenyamanan:String?,
    var harga:String?,
    var fasilitas_umum:String?
)
data class Profile(
    var id:String?,
    var photo_profile:String?,
    var nama_lengkap:String?,
    var email:String?
)