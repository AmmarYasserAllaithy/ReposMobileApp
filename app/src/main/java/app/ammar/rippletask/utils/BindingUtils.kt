package app.ammar.rippletask.utils

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import app.ammar.rippletask.R
import app.ammar.rippletask.data.model.Repo
import com.bumptech.glide.Glide


/**
 * Owner data
 */
@BindingAdapter("owner_avatar")
fun ImageView.setOwnerAvatar(repo: Repo?) = repo?.let {
    Glide.with(context)
        .load(repo.owner.avatarUrl)
        .circleCrop()
        .into(this)
}

@BindingAdapter("owner_name")
fun TextView.setOwnerName(repo: Repo?) = repo?.let {
    text = context.getString(R.string.owner_name, repo.owner.name)
}


/**
 * Repository data
 */
@BindingAdapter("name")
fun TextView.setName(repo: Repo?) = repo?.let { text = repo.name }

@BindingAdapter("language")
fun TextView.setLanguage(repo: Repo?) = repo?.let { setTextOrGone(repo.language) }

@BindingAdapter("license")
fun TextView.setLicense(repo: Repo?) = repo?.let {
    when (repo.license) {
        null -> visibility = GONE
        else -> {
            visibility = VISIBLE
            text = repo.license.name
        }
    }
}

@BindingAdapter("desc")
fun TextView.setDesc(repo: Repo?) = repo?.let { setTextOrGone(repo.desc) }

@BindingAdapter("stars")
fun TextView.setStars(repo: Repo?) = repo?.let { text = "${repo.stars}" }

@BindingAdapter("forks")
fun TextView.setForks(repo: Repo?) = repo?.let { text = "${repo.forks}" }

@BindingAdapter("issues")
fun TextView.setIssues(repo: Repo?) = repo?.let { text = "${repo.issues}" }


/**
 * Utils
 */
private fun TextView.setTextOrGone(data: String?) = when (data) {
    null -> visibility = GONE
    else -> {
        visibility = VISIBLE
        text = data
    }
}
