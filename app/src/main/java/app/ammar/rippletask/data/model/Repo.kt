package app.ammar.rippletask.data.model

import com.google.gson.annotations.SerializedName


data class Repo(
    @SerializedName("full_name") val fullName: String,
    @SerializedName("description") val desc: String,
    @SerializedName("html_url") val url: String,
    @SerializedName("owner") val owner: Owner
)
