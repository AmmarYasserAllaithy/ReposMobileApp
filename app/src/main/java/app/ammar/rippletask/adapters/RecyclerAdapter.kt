package app.ammar.rippletask.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.ammar.rippletask.database.Repo
import app.ammar.rippletask.databinding.ItemBinding

class RecyclerAdapter(private val clickListener: ClickListener) :
    ListAdapter<Repo, RecyclerAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position), clickListener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)


    class ViewHolder private constructor(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Repo, clickListener: ClickListener) = with(binding) {
            repo = item
            this.clickListener = clickListener
            executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder = ViewHolder(
                ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }

    }

}


class DiffCallback : DiffUtil.ItemCallback<Repo>() {

    override fun areItemsTheSame(oldItem: Repo, newItem: Repo) = oldItem.ID == newItem.ID

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo) = oldItem == newItem

}


class ClickListener(val clickListener: (id: Int) -> Unit) {
    fun onClick(repo: Repo) = clickListener(repo.ID)
}
