package co.composables.espressotesting

import android.content.Context
import android.util.AttributeSet

class CounterView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyle) {
    fun resetCounter() {
        text = "0"
    }
}
