package br.com.leandroid.data.network.funds.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class FundsEntity(
    @JsonProperty("full_name")
    var fullName: String?
)
