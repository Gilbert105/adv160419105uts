package com.ubaya.adv160419105uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.adv160419105uts.R
import com.ubaya.adv160419105uts.viewmodel.KosViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.kos_list_item.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var viewModel : KosViewModel
    private val kosListAdapter = KosListAdapter(arrayListOf(),"home")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(KosViewModel::class.java)
        viewModel.refresh()

        recViewHome.layoutManager = LinearLayoutManager(context)
        recViewHome.adapter = kosListAdapter

        observeViewModel()

        refreshLayout.setOnRefreshListener{
            recViewHome.visibility = View.GONE
            progressBarHome.visibility = View.VISIBLE
            textErrorHome.visibility = View.GONE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }
    }

    private fun observeViewModel() {

        viewModel.kosLiveData.observe(viewLifecycleOwner){
            kosListAdapter.updateKosList(it)
        }
        viewModel.kosLoadErrorLiveData.observe(viewLifecycleOwner){
            if(it == true){
                textErrorHome.visibility = View.VISIBLE
            }else{
                textErrorHome.visibility = View.GONE
            }
        }
        viewModel.loadingLiveData.observe(viewLifecycleOwner){
            if(it){
                recViewHome.visibility = View.GONE
                progressBarHome.visibility = View.VISIBLE
            } else{
                recViewHome.visibility = View.VISIBLE
                progressBarHome.visibility = View.GONE
            }
        }
    }
}