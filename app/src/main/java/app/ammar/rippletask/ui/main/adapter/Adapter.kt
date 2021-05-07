package app.ammar.rippletask.ui.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import app.ammar.rippletask.data.model.Repo


class Adapter(private val clickListener: ClickListener) :
    ListAdapter<Repo, ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position), clickListener)

}
