package com.ubaya.adv160419105uts.model

import com.google.gson.annotations.SerializedName

data class Kos(
    //SerializedName dipakai jika data pada json berbeda dengan nama field di Android studio
    var id_kos:Int?,
    var nama_kos:String?,
    var deskripsi:String?,
    var harga_kos:Int?,
    var review_kos:Review?,
    var fasilitas:String?,
    var peraturan:String?,
    var photo_kos:String?
)
data class Review(
    var kebersihan:Double?,
    var keamanan:Double?,
    var fasilitas_kamar:Double?,
    var kenyamanan:Double?,
    var harga:Double?,
    var fasilitas_umum:Double?
)
data class Profile(
    var id:String?,
    var photo_profile:String?,
    var nama_lengkap:String?,
    var password:String?,
    var email:String?,
    var alamat: String?
)