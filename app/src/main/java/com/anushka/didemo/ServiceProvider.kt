package com.anushka.didemo

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor() {
    init {
        Log.i("LinLi","Service Provider Constructed")
    }

    fun getServiceProvider(){
        Log.i("LinLi","Service provider connected")
    }
}