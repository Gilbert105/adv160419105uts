package com.ubaya.adv160419105uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.adv160419105uts.R
import com.ubaya.adv160419105uts.model.Kos
import com.ubaya.adv160419105uts.util.loadImage
import kotlinx.android.synthetic.main.kos_list_item.view.*

class KosListAdapter(val kosList:ArrayList<Kos>, var currentFragment : String) : RecyclerView.Adapter<KosListAdapter.KosViewHolder>() {
    class KosViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.kos_list_item,parent,false)
        return KosViewHolder(view)
    }

    override fun onBindViewHolder(holder: KosViewHolder, position: Int) {
        val kos = kosList[position]
        with(holder.view){
            textNamaKos.text = kos.nama_kos.toString()
            textHargaKos.text = kos.harga_kos.toString()
            imageViewGambarKosItem.loadImage(kos.photo_kos,progressBarKosGambar)
            if(currentFragment == "home" ){
                buttonDetailKos.setOnClickListener {
                    val action = HomeFragmentDirections.actionItemHomeToKosFragment(kos.id_kos.toString())
                    Navigation.findNavController(it).navigate(action)
                }
            }
            else if ( currentFragment == "favorite"){
                buttonDetailKos.setOnClickListener {
                    val action = FavoriteFragmentDirections.actionItemFavoriteToKosFragment(kos.id_kos.toString())
                    Navigation.findNavController(it).navigate(action)
                }
            }


        }
    }

    override fun getItemCount() =kosList.size

    fun updateKosList(newKosList : ArrayList<Kos>){
        kosList.clear()
        kosList.addAll(newKosList)
        notifyDataSetChanged()
    }
}