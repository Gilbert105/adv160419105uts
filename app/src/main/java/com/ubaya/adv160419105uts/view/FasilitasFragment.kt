package com.ubaya.adv160419105uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ubaya.adv160419105uts.R
import com.ubaya.adv160419105uts.viewmodel.KosDetailViewModel
import kotlinx.android.synthetic.main.fragment_fasilitas.*
import kotlinx.android.synthetic.main.fragment_peraturan.*


/**
 * A simple [Fragment] subclass.
 * Use the [FasilitasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FasilitasFragment : Fragment() {

    private lateinit var kosDetailModel : KosDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fasilitas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var id = ""
        arguments?.let{
            id = KosFragmentArgs.fromBundle(requireArguments()).idkos
        }
        kosDetailModel = ViewModelProvider(this).get(KosDetailViewModel::class.java)
        kosDetailModel.fetch(id)
        observeDetailModel()
    }

    private fun observeDetailModel() {
        kosDetailModel.kosDetailLiveData.observe(viewLifecycleOwner){
            textFasilitasKos.text = it.fasilitas
        }
    }

}