package app.ammar.rippletask.ui.main.adapter

import app.ammar.rippletask.data.model.Repo


class ClickListener(val clickListener: (url: String) -> Unit) {
    fun onClick(repo: Repo) = clickListener(repo.url)
}
