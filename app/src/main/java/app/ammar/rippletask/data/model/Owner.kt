package app.ammar.rippletask.data.model

import com.google.gson.annotations.SerializedName


data class Owner(
    @SerializedName("login") val name: String,
    @SerializedName("avatar_url") val avatarUrl: String
)
