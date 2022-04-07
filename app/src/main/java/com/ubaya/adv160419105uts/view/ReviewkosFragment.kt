package com.ubaya.adv160419105uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.adv160419105uts.R
import com.ubaya.adv160419105uts.util.loadImage
import com.ubaya.adv160419105uts.viewmodel.KosDetailViewModel
import kotlinx.android.synthetic.main.fragment_kos.*
import kotlinx.android.synthetic.main.fragment_reviewkos.*


/**
 * A simple [Fragment] subclass.
 * Use the [ReviewkosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReviewkosFragment : Fragment() {
    private lateinit var kosDetailModel : KosDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reviewkos, container, false)
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
            generateStar(it.review_kos?.kebersihan.toString().toDouble(),imageViewKebersihan1,
                imageViewKebersihan2,imageViewKebersihan3,imageViewKebersihan4,imageViewKebersihan5)
            textKebersihan.text = it.review_kos?.kebersihan.toString()
            generateStar(it.review_kos?.keamanan.toString().toDouble(),imageViewKeamanan1,
                imageViewKeamanan2,imageViewKeamanan3,imageViewKeamanan4,imageViewKeamanan5)
            textKeamanan.text = it.review_kos?.keamanan.toString()
            generateStar(it.review_kos?.fasilitas_kamar.toString().toDouble(),imageViewFasilitasK1,
                imageViewFasilitasK2,imageViewFasilitasK3,imageViewFasilitasK4,imageViewFasilitasK5)
            textFasilitasKamar.text = it.review_kos?.fasilitas_kamar.toString()
            generateStar(it.review_kos?.kenyamanan.toString().toDouble(),imageViewKenyamanan1,
                imageViewKenyamanan2,imageViewKenyamanan3,imageViewKenyamanan4,imageViewKenyamaan5)
            textKenyamanan.text = it.review_kos?.kenyamanan.toString()
            generateStar(it.review_kos?.harga.toString().toDouble(),imageViewHarga1,
                imageViewHarga2,imageViewHarga3,imageViewHarga4,imageViewHarga5)
            textHarga.text = it.review_kos?.harga.toString()
            generateStar(it.review_kos?.fasilitas_umum.toString().toDouble(),imageViewFasilitasU1,
                imageViewFasilitasU2,imageViewFasilitasU3,imageViewFasilitasU4,imageViewFasilitasU5)
            textFasilitasUmum.text = it.review_kos?.fasilitas_umum.toString()
        }
    }
    fun generateStar(
        star: Double,
        imageViewStar1:ImageView,
        imageViewStar2:ImageView,
        imageViewStar3:ImageView,
        imageViewStar4:ImageView,
        imageViewStar5:ImageView
    ){
        if(star == 5.0){
            imageViewStar1.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar2.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar3.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar4.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar5.setBackgroundResource(R.drawable.ic_baseline_star_24)
        } else if (star > 4.0) {
            imageViewStar1.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar2.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar3.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar4.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar5.setBackgroundResource(R.drawable.ic_baseline_star_half_24)
        } else if (star == 4.0) {
            imageViewStar1.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar2.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar3.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar4.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar5.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
        } else if (star > 3.0) {
            imageViewStar1.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar2.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar3.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar4.setBackgroundResource(R.drawable.ic_baseline_star_half_24)
            imageViewStar5.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
        } else if (star == 3.0) {
            imageViewStar1.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar2.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar3.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar5.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar5.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
        } else if (star > 2.0) {
            imageViewStar1.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar2.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar3.setBackgroundResource(R.drawable.ic_baseline_star_half_24)
            imageViewStar4.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar5.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
        } else if (star == 2.0) {
            imageViewStar1.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar2.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar3.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar4.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar5.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
        } else if (star > 1.0) {
            imageViewStar1.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar2.setBackgroundResource(R.drawable.ic_baseline_star_half_24)
            imageViewStar3.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar4.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar5.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
        } else if (star == 1.0) {
            imageViewStar1.setBackgroundResource(R.drawable.ic_baseline_star_24)
            imageViewStar2.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar3.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar4.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar5.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
        } else if (star > 0.0) {
            imageViewStar1.setBackgroundResource(R.drawable.ic_baseline_star_half_24)
            imageViewStar2.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar3.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar4.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar5.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
        } else if (star == 0.0) {
            imageViewStar1.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar2.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar3.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar4.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            imageViewStar5.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
        }
    }


}