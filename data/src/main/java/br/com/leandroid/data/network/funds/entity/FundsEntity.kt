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
    var fullName: String?,
    @JsonProperty("simple_name")
    var simpleName: String?,
    @JsonProperty("description_seo")
    var descriptionSeo: String?,
    @JsonProperty("operability")
    var operability: Operability?,
    @JsonProperty("specification")
    var specification: Specification?
)

data class Operability(
    @JsonProperty("retrieval_quotation_days_str")
    var quotationDays: String?,
    @JsonProperty("minimum_initial_application_amount")
    var minimumApplication: String?
)

data class Specification(
    @JsonProperty("fund_main_strategy_name")
    var strategy: String?,
    @JsonProperty("fund_type")
    var fundType: String?
)


