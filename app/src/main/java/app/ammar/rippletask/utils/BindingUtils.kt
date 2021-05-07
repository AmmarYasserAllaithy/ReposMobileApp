package app.ammar.rippletask.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import app.ammar.rippletask.R
import app.ammar.rippletask.data.model.Repo
import com.bumptech.glide.Glide


@BindingAdapter("avatar")
fun ImageView.setAvatar(repo: Repo?) = repo?.let {

    setImageResource(R.drawable.ic_octicons_mark_github)

    Glide.with(context)
        .load(repo.owner.avatarUrl)
        .circleCrop()
        .into(this)

}

@BindingAdapter("full_name")
fun TextView.setName(repo: Repo?) = repo?.let { text = repo.fullName }

@BindingAdapter("desc")
fun TextView.setDesc(repo: Repo?) = repo?.let { text = repo.desc }
