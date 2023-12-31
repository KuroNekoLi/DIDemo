大家好，歡迎回來。在某些情況下，我們可能會將介面作為依賴，而不是類別。

為了向大家展示如何使用介面，我要把這個電池類別改成一個介面。

介面沒有建構子，所以讓我們把這個刪掉。

然後我們需要把這個函數設為抽象的。

現在在這個SmartPhone的建構子中，我們有一個Battery參數，但現在

Battery已經是一個介面了。

如果我們現在運行這個應用

它將不能運行。因為在這一點上，我們無法構造一個電池。

我們需要創建一個類別

去實現這個電池介面，並通過模塊提供依賴。

所以讓我們創建一個新的Kotlin類別。將其命名為

鎳鎘電池

它應該實現電池介面。

然後實現getPower函數。

讓我們加入一個日誌。

在這裡，我將使用與smartphone類別相同的標籤。

我們應該用@Inject註解來註解這個類別的建構子。

如果我們現在嘗試運行這個專案，Android studio將會顯示一個錯誤訊息。

在這裡，我們有一個鎳鎘電池的依賴。因為它已經實現了電池介面，我們知道

這是一個電池。

但是dagger還不知道。Dagger並不會

這樣為依賴類別做類別轉換。

我們必須創建一個模塊，並將這個鎳鎘電池依賴作為電池依賴提供。

所以，讓我們為模塊創建一個新的Kotlin類別。

將其命名為NCBatteryModule。

用@Module

註解來註解這個。

現在讓我們創建一個提供者函數

名為providesNCBattery。

返回類型應該是Battery。

我們可以直接構造一個新的鎳鎘電池實例並以此方式返回它。但這是

不必要的。

因為我們已經用@Inject註解註解了鎳鎘電池的建構子，dagger可以

構建那個依賴。

所以我們可以在這裡直接使用那個依賴，

我們不必再次構造它。

我們也應該將這個提供者函數用提供者註解註解

現在。

此函數將返回一個類型轉換為電池實例的鎳鎘電池實例。Dagger會識別

這。

返回的依賴是根據提供者函數的返回類型來識別的。

因此，Dagger將認出這個依賴是一個電池。

現在讓我們回到

SmartPhoneComponent介面。

在這裡，我們需要將我們新創建的模塊添加到模塊列表中。

所以，這就是我們如何使用介面類型作為依賴。讓我們運行應用程序，看看它是如何運作的。

讓我們準備好logcat，看看結果。然後運行應用程序。

你可以看到這個新的日誌結果。"來自鎳鎘電池的電力" 其實我們可以讓這段代碼更加

簡練。在我們的應用中，我們已經將鎳鎘電池類別的建構子

用inject註解註解。

因此，我們不需要為這個提供者函數提供一個主體。所以我們可以將這個模塊定義為一個

抽象模塊。然後將這個函數設為抽象的。並且刪除函數體。

在dagger中

抽象函數不能用@Provides註解註解。但是dagger提供了一個選項去

用

@Binds註解註解它們。讓我們

也改變函數的名稱。

現在，我將再次運行應用，看看這個新變更如何影響。

好的，應用運行得和以前一樣好。

所以，在這節課中，你學到了如何使用介面類型。

這非常簡單，

你需要做的就是創建一個實現該介面的類別，然後創建一個模塊來

提供該類別的一個實例。

這就是這節課的內容。

在下一節課。

我們來談談，另一種將依賴注入到主活動的方式。非常感謝你的聆聽。

很快再見，我們將帶來下一節課。

大家好，歡迎回來。我們先刪除這部分的註釋代碼。

在我們的示例項目中，為了獲取SmartPhone依賴項，我們從MainActivity調用了smartPhoneComponent接口的getSmartPhone函數，

但這並非最佳和最有效的方式。

一個項目中可能有許多活動和片段，可能有許多依賴項。想一想，

如果你有10個像這樣的SmartPhone依賴項，你可能需要在組件接口中為所有這些依賴項寫入getter方法，

然後你將需要以這種方式從所有活動中調用它們。

如果你需要在運行時將值傳遞給這些依賴項，這將變得更加困難。Dagger庫

並不期望我們像這樣為依賴項寫入getter方法。我們可以通過字段注入將它們輕鬆地注入到活動或片段中。

讓我向你展示如何做，去SmartPhoneComponent。我們不必像這樣寫getter方法。

實際上，我們可以注入所有屬於依賴圖的依賴項。

現在，我正在為MainActivity創建一個抽象的inject函數。函數的參數是MainActivity。

這裡，我用inject作為函數名稱。

你可以使用你喜歡的任何名稱。但作為慣例，我們通常使用inject作為注入器

函數的名稱。

我們要在此函數中使用這個主活動。

所以我添加了一個主活動的實例作為參數。

如果你需要在3個活動和一個片段中使用這個組件，你可能需要在這裡寫

其他3個注入函數，並將這些活動和片段作為參數。

現在讓我們回到MainActivity。我們可以在這裡調用inject函數，將活動作為

參數。

讓我們用@Inject註釋

這個智能手機實例變量。然後，我們可以調用智能手機的

makeACallWithRecording()函數。

讓我們運行應用程序，看看這是如何運作的。

我們可以看到，應用程序的運行情況與以前一樣。

但是有
什么区别呢？我们为什么要做这样的变更？

如果我们调用像getSmartPhone这样的函数，我们只能获取到那个SmartPhone依赖项。

如果我们想要获取另一个依赖项，

我们就必须在组件接口中创建另一个函数，并在这里调用它。

但是，现在我们不需要为每一个依赖项都创建一个特定的函数。

相反，我们可以通过字段注入将这些依赖项带入MainActivity。举个例子，

假设我们需要获取一个内存卡实例作为依赖项。

我们需要做的就是声明一个实例变量并用@Inject注解标注它，

dagger就会提供内存卡依赖项。

这种方式非常简单也非常有效。

在dagger的支持下，

我们可以使用字段注入获取我们想要的所有依赖项。

这就是本课的内容。

在下一课中，我将展示如何动态地为依赖项提供

值。非常感谢你的倾听。

下一节课见。