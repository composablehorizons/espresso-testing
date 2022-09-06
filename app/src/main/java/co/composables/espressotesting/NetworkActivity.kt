package co.composables.espressotesting

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NetworkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        val progressBar = findViewById<View>(R.id.progress)
        val resultView = findViewById<TextView>(R.id.result)

        findViewById<View>(R.id.fetch_data).setOnClickListener {
            lifecycleScope.launch {
                progressBar.visibility = View.VISIBLE

                NetworkingIdlingResource.idlingResource.increment()
                val fetchedData = fetchDataFromHttp()
                resultView.text = fetchedData
                NetworkingIdlingResource.idlingResource.decrement()

                progressBar.visibility = View.GONE
            }
        }
    }
}

suspend fun fetchDataFromHttp(): String {
    delay(1_000L)
    return "Balance: $100"
}
