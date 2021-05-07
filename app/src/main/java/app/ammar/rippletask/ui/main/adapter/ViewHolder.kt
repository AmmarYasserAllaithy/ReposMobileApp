package app.ammar.rippletask.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.ammar.rippletask.data.model.Repo
import app.ammar.rippletask.databinding.ItemBinding


class ViewHolder private constructor(private val binding: ItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup) =
            ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    fun bind(item: Repo, clickListener: ClickListener) = with(binding) {
        repo = item
        this.clickListener = clickListener
        executePendingBindings()
    }

}
