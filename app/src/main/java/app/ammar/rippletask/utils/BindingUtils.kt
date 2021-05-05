package app.ammar.rippletask.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import app.ammar.rippletask.database.Repo


@BindingAdapter("avatar")
fun ImageView.setAvatar(repo: Repo?) = repo?.let {
    if (repo.ownerAvatarRes != -1) setImageResource(repo.ownerAvatarRes)
}

@BindingAdapter("name")
fun TextView.setName(repo: Repo?) = repo?.let { text = repo.name }

@BindingAdapter("desc")
fun TextView.setDesc(repo: Repo?) = repo?.let { text = repo.desc }

