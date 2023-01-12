package com.example.restaurantsearchapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.restaurantsearchapp.HotpepperViewModel
import com.example.restaurantsearchapp.R
import com.example.restaurantsearchapp.databinding.FragmentTopBinding


class TopFragment : Fragment() {
    private var _binding: FragmentTopBinding? = null
    private val binding: FragmentTopBinding
        get() = _binding!!
    private val hotpepperViewModel: HotpepperViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentTopBinding.inflate(inflater, container, false)
        _binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var couponCheck = false
        var tabehoCheck = false
        var nomihoCheck = false

        binding.couponCheckbox.setOnClickListener {
            couponCheck = binding.couponCheckbox.isChecked
            hotpepperViewModel.setCoupon(couponCheck)
        }
        binding.tabehoCheckbox.setOnClickListener {
            tabehoCheck = binding.tabehoCheckbox.isChecked
            hotpepperViewModel.setTabeho(tabehoCheck)
        }
        binding.nomihoCheckbox.setOnClickListener {
            nomihoCheck = binding.nomihoCheckbox.isChecked
            hotpepperViewModel.setNomiho(nomihoCheck)
        }

        binding.genreSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinner = parent as? Spinner
                val item = spinner?.selectedItem as? String

                item?.let {
                    if (it.isNotEmpty()) {
                        hotpepperViewModel.setGenre(item)
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        // 検索ボタンタップ時
        binding.searchButton.setOnClickListener {

            val station = binding.stationSearchEdit.text.toString()

            if (station == "") {
                dialogStation()
            } else {
                hotpepperViewModel.setStation(station)
                findNavController().navigate(R.id.action_topFragment_to_showAllFragment)
            }
        }
    }

    // 駅名が未入力時にダイアログ
    private fun dialogStation() {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.caution)
            .setMessage(R.string.caution_station_name)
            .setPositiveButton(R.string.ok) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}