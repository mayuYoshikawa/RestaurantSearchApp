package com.example.restaurantsearchapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HotpepperViewModel : ViewModel() {

    private val _genre = MutableLiveData<String>()
    val genre: LiveData<String>
        get() = _genre

    private val _station = MutableLiveData<String>()
    val station: LiveData<String>
        get() = _station

    private val _coupon = MutableLiveData<Boolean>()
    val coupon: LiveData<Boolean>
        get() = _coupon

    private val _tabeho = MutableLiveData<Boolean>()
    val tabeho: LiveData<Boolean>
        get() = _tabeho

    private val _nomiho = MutableLiveData<Boolean>()
    val nomiho: LiveData<Boolean>
        get() = _nomiho


    init {
        _genre.value = ""
        _station.value = ""
        _coupon.value = false
        _tabeho.value = false
        _nomiho.value = false

    }

    fun setGenre(genre: String) {
        _genre.value = genre
    }

    fun setStation(station: String) {
        _station.value = station
    }

    fun setCoupon(coupon: Boolean) {
        _coupon.value = coupon
    }

    fun setTabeho(tabeho: Boolean) {
        _tabeho.value = tabeho
    }

    fun setNomiho(nomiho: Boolean) {
        _nomiho.value = nomiho
    }
}