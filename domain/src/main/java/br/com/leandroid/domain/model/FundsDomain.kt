package br.com.leandroid.domain.model

import android.os.Parcelable
import br.com.leandroid.data.network.funds.entity.FundsEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
class FundsDomain(
    var fullName: String?
) : Parcelable {

    companion object {
        fun convertToDomainList(
            fundsEntities: List<FundsEntity>?
        ): List<FundsDomain> {
            val fundsDomains = ArrayList<FundsDomain>()

            fundsEntities?.forEach {
                fundsDomains.add(
                    FundsDomain(fullName = it.fullName)
                )
            }
            return fundsDomains
        }
    }
}
