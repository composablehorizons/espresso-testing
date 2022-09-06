package co.composables.espressotesting

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.settings).setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
        val counterView = findViewById<TextView>(R.id.counter)
        findViewById<View>(R.id.add).setOnClickListener {
            val count = counterView.text.toString().toInt() + 1
            counterView.text = count.toString()
        }
        findViewById<View>(R.id.subtract).setOnClickListener {
            val count = counterView.text.toString().toInt() - 1
            counterView.text = count.toString()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val textAdapter = TextAdapter()
        recyclerView.adapter = textAdapter
        textAdapter.publish((1..1000).map { it.toString() })
    }
}
