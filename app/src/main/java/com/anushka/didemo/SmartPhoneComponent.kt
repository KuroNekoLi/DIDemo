package com.anushka.didemo

import dagger.Component

@Component(modules = [MemoryCardModule::class,NCBatteryModule::class])
interface SmartPhoneComponent {

    //一個項目中可能有許多活動和片段，可能有許多依賴項。
    //如果你有10個像這樣的SmartPhone依賴項，
    // 你可能需要在組件接口中為所有這些依賴項寫入getter方法，
    //然後你將需要以這種方式從所有活動中調用它們。
    //如果你需要在運行時將值傳遞給這些依賴項，這將變得更加困難。
//    fun getSmartPhone() : SmartPhone

    fun inject(mainActivity: MainActivity)
}