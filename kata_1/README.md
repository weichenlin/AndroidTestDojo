## 01 封閉的模組

### 情境

這裡有兩個類別需要測試，一個是 Person，另一個是 Average。
Average 會接受一個 Person 陣列，以及一個 TextView 元件。
並在呼叫 notifyDataSetChanged() 時將平均值顯示在 TextView。

## 分析

### Person 類別

很單純的小傢伙，唯一的功能是取得 Pay 的數值。
根據我對 Pay 這個字的了解，一般不會允許負值。

所以需要測試兩個部份：

1. 建構式傳入的值可以由 getPay() 正確取得
2. 傳入的值若為負數應該會丟出例外

### Average 類別

有點奇怪的類別，但還算好理解。
在建構式中傳入 Person 陣列以及一個 TextView 物件，並在呼叫 notifyDataSetChanged() 時將平均值顯示在 TextView。
其實也就是單純的輸入/輸出行為。

可以將其主要功能簡化為：

* 輸入一個 Person 陣列
* 輸出 getPay() 的平均值

TextView 基本上只是個用來接收 Output 的物件，只需要確認最終的結果有丟給它就行了。可以用 Mock Object 來確認這點，並取得輸出值。

因此需要測試這些項目：

1. 僅接受 Person 陣列作為輸入
2. 關於陣列的邊界測試，由於這邊沒有數量上限，所以僅需測試空陣列，預期顯示為 0
3. 輸出正確的平均值
4. 平均值的精度為小數點後三位
5. 輸出有丟給 TextView

## 結果

嗯...六個測試內有四個失敗。分別是：

1. 傳入 Person 的值若為負數應該會丟出例外
2. Average 僅接受 Person 陣列作為輸入
3. Average 將空陣列的平均顯示為 0
4. 平均值的精度為小數點後三位

測試（只包含 Person 與 Average）的覆蓋率為 100%，這邊有[覆蓋率報告](TestReport/index.html)。

其中第二個失敗的測試比較特別一些，如果程式正確的話應該會造成無法編譯的情況。我把這個問題丟上 StackOverflow 去問，也沒有好的解法，
[連結在這裡](http://stackoverflow.com/questions/31375437/how-to-unit-test-code-that-should-cause-compile-error)。
