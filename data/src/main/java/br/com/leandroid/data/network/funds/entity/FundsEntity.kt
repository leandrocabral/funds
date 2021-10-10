package br.com.leandroid.data.network.funds.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
data class FundsEntity(
    @PrimaryKey val id: Int?,
    @JsonProperty("full_name")
    var fullName: String?
)
