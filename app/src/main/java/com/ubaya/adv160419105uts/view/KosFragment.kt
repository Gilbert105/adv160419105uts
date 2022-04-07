package com.ubaya.adv160419105uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.adv160419105uts.R
import com.ubaya.adv160419105uts.model.Kos
import com.ubaya.adv160419105uts.util.loadImage
import com.ubaya.adv160419105uts.viewmodel.KosDetailViewModel
import com.ubaya.adv160419105uts.viewmodel.KosViewModel
import kotlinx.android.synthetic.main.fragment_kos.*


/**
 * A simple [Fragment] subclass.
 * Use the [KosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KosFragment : Fragment() {
    private lateinit var kosDetailModel : KosDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kos, container, false)
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
           imageViewGambarKosMenu.loadImage(it.photo_kos)
            textNamaKosMenu.text = it.nama_kos
            var helper = it
            buttonFasilitas.setOnClickListener{
                val action = KosFragmentDirections.actionKosFragmentToFasilitasFragment2(helper.id_kos.toString())
                Navigation.findNavController(it).navigate(action)
            }
            buttonPeraturan.setOnClickListener{
                val action = KosFragmentDirections.actionKosFragmentToPeraturanFragment(helper.id_kos.toString())
                Navigation.findNavController(it).navigate(action)
            }
            buttonReview.setOnClickListener{
                val action = KosFragmentDirections.actionKosFragmentToReviewkosFragment(helper.id_kos.toString())
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}