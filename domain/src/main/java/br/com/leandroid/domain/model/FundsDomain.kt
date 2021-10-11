package br.com.leandroid.domain.model

import android.os.Parcelable
import br.com.leandroid.data.network.funds.entity.FundsEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
class FundsDomain(
    var fullName: String?,
    var name: String,
    var description: String?,
    var quotationDays: String?,
    var minimumApplication: String?,
    var strategy: String?,
    var type: String?
) : Parcelable {

    companion object {
        fun convertToDomainList(
            fundsEntities: List<FundsEntity>?
        ): List<FundsDomain> {
            val fundsDomains = ArrayList<FundsDomain>()

            fundsEntities?.forEach {
                fundsDomains.add(
                    FundsDomain(
                        fullName = it.fullName ?: "",
                        name = it.simpleName ?: "",
                        description = it.descriptionSeo ?: "",
                        quotationDays = it.operability?.quotationDays ?: "",
                        minimumApplication = it.operability?.minimumApplication ?: "",
                        strategy = it.specification?.strategy ?: "",
                        type = it.specification?.fundType ?: ""
                    )
                )
            }
            return fundsDomains
        }
    }
}
