package com.example.restaurantsearchapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.restaurantsearchapp.HotpepperViewModel
import com.example.restaurantsearchapp.R
import com.example.restaurantsearchapp.databinding.FragmentShowAllBinding

class ShowAllFragment : Fragment() {
    private lateinit var binding: FragmentShowAllBinding
    private val hotpepperViewModel: HotpepperViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentShowAllBinding = FragmentShowAllBinding.inflate(inflater, container, false)
        binding = fragmentShowAllBinding
        return fragmentShowAllBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val genre = hotpepperViewModel.genre.value
        val station = hotpepperViewModel.station.value
        var coupon = ""
        var nomiho = ""
        var tabeho = ""

        if(hotpepperViewModel.coupon.value == true){
            coupon = getString(R.string.mobile_coupon)
        }
        if (hotpepperViewModel.nomiho.value == true) {
            nomiho = getString(R.string.nomiho)
        }
        if (hotpepperViewModel.tabeho.value == true) {
            tabeho = getString(R.string.tabeho)
        }

        binding.genreText.text = genre
        binding.stationText.text = getString(R.string.station,station)
        binding.couponText.text = coupon
        binding.nomihoText.text = nomiho
        binding.tabehoText.text = tabeho
    }
}