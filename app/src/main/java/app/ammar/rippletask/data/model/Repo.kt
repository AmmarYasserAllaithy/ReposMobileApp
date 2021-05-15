package app.ammar.rippletask.data.model

import com.google.gson.annotations.SerializedName


data class Repo(
    @SerializedName("name") val name: String,
    @SerializedName("description") val desc: String?,
    @SerializedName("html_url") val url: String,
    @SerializedName("owner") val owner: Owner,
    @SerializedName("stargazers_count") val stars: Int,
    @SerializedName("language") val language: String?,
    @SerializedName("forks_count") val forks: Int,
    @SerializedName("open_issues_count") val issues: Int,
    @SerializedName("license") val license: License?
)
