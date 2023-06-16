package com.anushka.didemo

import android.util.Log
import javax.inject.Inject

class SmartPhone @Inject constructor(val battery: Battery, val simCard: SIMCard, val memoryCard: MemoryCard) {

    init {
        battery.getPower()
        simCard.getConnection()
        memoryCard.getSpaceAvailablity()
        Log.i("LinLi", "SmartPhone Constructed")
    }

    fun makeACallWithRecording() {
        Log.i("LinLi", "Calling.....")
    }
}

