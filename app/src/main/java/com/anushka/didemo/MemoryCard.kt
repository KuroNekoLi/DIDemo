package com.anushka.didemo

import android.util.Log
import javax.inject.Inject

class MemoryCard  {
    init {
        Log.i("LinLi","Memory Card Constructed")
    }

    fun getSpaceAvailablity(){
        Log.i("LinLi","Memory space available")
    }
}