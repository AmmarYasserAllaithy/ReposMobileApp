package app.ammar.rippletask.data.model

import com.google.gson.annotations.SerializedName


data class EntireResponse(
    @SerializedName("total_count") val total: Int,
    @SerializedName("incomplete_results") val incomplete: Boolean,
    @SerializedName("items") val repos: List<Repo>
)
