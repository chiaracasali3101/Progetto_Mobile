package com.unibo.android.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.unibo.android.ui.R

private const val ARG_ID_PRODUCT = "id_product"

class HomeFragment : Fragment() {

    private var idProduct: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { arguments ->
            idProduct = arguments.getString(ARG_ID_PRODUCT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla semplicemente il layout senza cercare adapter o viewmodel che non esistono
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(idProduct: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ID_PRODUCT, idProduct)
                }
            }
    }
}