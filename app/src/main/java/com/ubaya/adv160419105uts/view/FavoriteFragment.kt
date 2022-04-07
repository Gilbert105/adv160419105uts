package com.ubaya.adv160419105uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.adv160419105uts.R
import com.ubaya.adv160419105uts.model.Kos
import com.ubaya.adv160419105uts.viewmodel.KosDetailViewModel
import com.ubaya.adv160419105uts.viewmodel.KosViewModel
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_kos.*

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteFragment : Fragment() {
//    private lateinit var kosDetailModel1 : KosDetailViewModel
//    private lateinit var kosDetailModel2 : KosDetailViewModel
    private lateinit var kosModel : KosViewModel
    private val kosListAdapter = KosListAdapter(arrayListOf(),"favorite")
    //private var arr : ArrayList<Kos> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        kosDetailModel1 = ViewModelProvider(this).get(KosDetailViewModel::class.java)
//        kosDetailModel2 = ViewModelProvider(this).get(KosDetailViewModel::class.java)
        kosModel = ViewModelProvider(this).get(KosViewModel::class.java)
//        kosDetailModel1.fetch("1")
//        kosDetailModel2.fetch("2")
        observeDetailModel()
        kosModel.refresh()
        recViewFavorite.layoutManager = LinearLayoutManager(context)
        recViewFavorite.adapter = kosListAdapter
        refreshLayoutFavorite.setOnRefreshListener{
            recViewFavorite.visibility = View.GONE
            progressBarLoadFavorite.visibility = View.VISIBLE
            textErrorFavorite.visibility = View.GONE
            kosModel.refresh()
            refreshLayoutFavorite.isRefreshing = false
        }


    }

    private fun observeDetailModel() {
//        kosDetailModel1.kosDetailLiveData.observe(viewLifecycleOwner){
//            arr.add(it)
//        }
//        kosDetailModel2.kosDetailLiveData.observe(viewLifecycleOwner){
//            arr.add(it)
//        }
        kosModel.kosLiveData.observe(viewLifecycleOwner){
            var arr :ArrayList<Kos> = arrayListOf()
            arr.add(it[0])
            //arr.add(it[1])
            kosListAdapter.updateKosList(arr)
        }
        kosModel.kosLoadErrorLiveData.observe(viewLifecycleOwner){
            if(it == true){
                textErrorFavorite.visibility = View.VISIBLE
            }else{
                textErrorFavorite.visibility = View.GONE
            }
        }
        kosModel.loadingLiveData.observe(viewLifecycleOwner){
            if(it){
                recViewFavorite.visibility = View.GONE
                progressBarLoadFavorite.visibility = View.VISIBLE
            } else{
                recViewFavorite.visibility = View.VISIBLE
                progressBarLoadFavorite.visibility = View.GONE
            }
        }
    }

}