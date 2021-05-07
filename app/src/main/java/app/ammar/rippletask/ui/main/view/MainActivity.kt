package app.ammar.rippletask.ui.main.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import app.ammar.rippletask.data.api.ApiHelper
import app.ammar.rippletask.data.api.RetrofitBuilder
import app.ammar.rippletask.databinding.ActivityMainBinding
import app.ammar.rippletask.ui.base.MainViewModelFactory
import app.ammar.rippletask.ui.main.adapter.Adapter
import app.ammar.rippletask.ui.main.adapter.ClickListener
import app.ammar.rippletask.ui.main.viewmodel.MainViewModel
import app.ammar.rippletask.utils.Status


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        initAdapter()
        initViewModel()

        binding.searchIB.setOnClickListener {
            binding.searchET.text.trim().toString().replace(" ", "+").let { searchAndObserve(it) }
        }
    }


    private fun initAdapter() {
        adapter = Adapter(
            ClickListener { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it))) })
        binding.recycler.adapter = adapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders
            .of(this, MainViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))
            .get(MainViewModel::class.java)
    }

    private fun searchAndObserve(name: String) {
        viewModel.get(name).observe(this, {
            with(binding) {
                when (it.status) {

                    Status.LOADING -> {
                        recycler.visibility = View.GONE
                        progress.visibility = View.VISIBLE
                    }

                    Status.SUCCESS -> {
                        recycler.visibility = View.VISIBLE
                        progress.visibility = View.GONE
                        it.data?.let {
                            adapter.submitList(it)
                            hideKeyboard()
                        }
                    }

                    Status.ERROR -> {
                        recycler.visibility = View.VISIBLE
                        progress.visibility = View.GONE
                        Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_LONG).show()
                    }

                }
            }
        })
    }

    private fun hideKeyboard() =
        (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.hideSoftInputFromWindow(binding.searchCLayout.windowToken, 0)

}
