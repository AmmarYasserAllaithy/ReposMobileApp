package app.ammar.rippletask.ui.main.adapter

import androidx.recyclerview.widget.DiffUtil
import app.ammar.rippletask.data.model.Repo


class DiffCallback : DiffUtil.ItemCallback<Repo>() {

    override fun areItemsTheSame(oldItem: Repo, newItem: Repo) =
        oldItem.fullName == newItem.fullName

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo) = oldItem == newItem

}
