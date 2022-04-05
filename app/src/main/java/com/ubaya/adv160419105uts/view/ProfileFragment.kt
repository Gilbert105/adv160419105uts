package com.ubaya.adv160419105uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.adv160419105uts.R
import com.ubaya.adv160419105uts.util.loadImage
import com.ubaya.adv160419105uts.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    private lateinit var profileModel : ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        profileModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        profileModel.fetch()
        observeProfileModel()
        buttonEditProfile.setOnClickListener{
            val action = ProfileFragmentDirections.actionItemProfileToProfileDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    private fun observeProfileModel() {
        profileModel.profileLiveData.observe(viewLifecycleOwner){
            //.text = it.nama_lengkap.toString()
            textNamaUser.text = it.nama_lengkap.toString()
            textEmailUser.text = it.email.toString()
            imageViewProfile.loadImage(it.photo_profile.toString())
            //textEmailUser.text =it.email
        }
    }

}