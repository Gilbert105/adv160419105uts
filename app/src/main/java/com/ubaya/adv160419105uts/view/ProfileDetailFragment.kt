package com.ubaya.adv160419105uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ubaya.adv160419105uts.R
import com.ubaya.adv160419105uts.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile_detail.*


/**
 * A simple [Fragment] subclass.
 * Use the [ProfileDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileDetailFragment : Fragment() {
    private lateinit var profileModel : ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        profileModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        profileModel.fetch()
        observeProfileModel()
    }

    private fun observeProfileModel() {
        profileModel.profileLiveData.observe(viewLifecycleOwner){
            editNama.setText(it.nama_lengkap)
            editAlamat.setText(it.alamat)
            editPassword.setText(it.password)
            editEmail.setText(it.email)
        }
    }


}