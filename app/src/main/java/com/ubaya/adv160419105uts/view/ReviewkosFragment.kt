package com.ubaya.adv160419105uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.adv160419105uts.R



/**
 * A simple [Fragment] subclass.
 * Use the [ReviewkosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReviewkosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reviewkos, container, false)
    }

}