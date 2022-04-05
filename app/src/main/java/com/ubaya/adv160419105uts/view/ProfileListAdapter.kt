package com.ubaya.adv160419105uts.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.adv160419105uts.model.Profile

class ProfileListAdapter (val profileList:ArrayList<Profile>) : RecyclerView.Adapter<ProfileListAdapter.ProfileViewHolder>(){
    class ProfileViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount()  = profileList.size
}