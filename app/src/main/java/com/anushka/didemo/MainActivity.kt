package com.anushka.didemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.namespace.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
@Inject
 lateinit var smartPhone : SmartPhone
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //為什麼我們不使用這種寫法呢？因為我們這樣只能得到SmartPhone的依賴
//        如果我们想要获取另一个依赖项， 我们就必须在组件接口中创建另一个函数，并在这里调用它。
//        但是，现在我们不需要为每一个依赖项都创建一个特定的函数。相反，我们可以通过字段注入将这些依赖项带入MainActivity。
//        DaggerSmartPhoneComponent.create()
//            .getSmartPhone()
//            .makeACallWithRecording()

        //當依賴中沒有帶參數可以用這種用法
//        DaggerSmartPhoneComponent.create()
//            .inject(this)
//        smartPhone.makeACallWithRecording()

        //例如將記憶卡的size設為1000需要這樣
        DaggerSmartPhoneComponent.builder()
            .memoryCardModule(MemoryCardModule(1000))
            .build()
            .inject(this)
        //不使用這個injection方法
//        val smartPhone = SmartPhone(
//            Battery(),
//            SIMCard(ServiceProvider()),
//            MemoryCard()
//        )
//            .makeACallWithRecording()

        Log.i("LinLi", "onCreate: ")

    }
}
