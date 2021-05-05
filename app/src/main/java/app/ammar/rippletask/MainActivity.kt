package app.ammar.rippletask

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.ammar.rippletask.adapters.ClickListener
import app.ammar.rippletask.adapters.RecyclerAdapter
import app.ammar.rippletask.database.DataProvider
import app.ammar.rippletask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this

        val adapter = RecyclerAdapter(ClickListener { })
        adapter.submitList(DataProvider.list)
        binding.recycler.adapter = adapter

    }

    fun browseFor(url: String) = startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))

}