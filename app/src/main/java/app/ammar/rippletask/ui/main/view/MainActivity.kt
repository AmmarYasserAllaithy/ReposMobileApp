package app.ammar.rippletask.ui.main.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import app.ammar.rippletask.databinding.ActivityMainBinding
import app.ammar.rippletask.ui.main.adapter.Adapter
import app.ammar.rippletask.ui.main.adapter.ClickListener
import app.ammar.rippletask.ui.main.viewmodel.MainViewModel
import app.ammar.rippletask.utils.Status
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: Adapter
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        initAdapter()
        initObserver()

        // TODO: 09-May-21 - ADD REGEX VALIDATION
        binding.searchIB.setOnClickListener {
            with(binding.searchET.text.trim().toString()) {

                if (isNotBlank()) viewModel.search(this)
                else Toast.makeText(applicationContext, "Invalid name", Toast.LENGTH_SHORT).show()

            }
        }
    }


    private fun initAdapter() {
        adapter = Adapter(
            ClickListener { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it))) })
        binding.recycler.adapter = adapter
    }

    private fun initObserver() {
        viewModel.repos.observe(this, {
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

                        Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                    }

                }
            }
        })
    }

    private fun hideKeyboard() {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.hideSoftInputFromWindow(binding.searchCLayout.windowToken, 0)

        binding.searchET.clearFocus()
    }
}
