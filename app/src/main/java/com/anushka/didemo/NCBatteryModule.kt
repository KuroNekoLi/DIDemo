package com.anushka.didemo

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NCBatteryModule {
    @Binds
    abstract fun providesNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery
}

//已經變為抽象類別所以不用下面的寫法
//    @Provides
//    fun providesNCBattery(nickelCadmiumBattery: NickelCadmiumBattery) : Battery{
//        return nickelCadmiumBattery
//    }
//}