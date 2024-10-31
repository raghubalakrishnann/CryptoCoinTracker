package com.raghu.cryptotracker.crypto.presentation.models

import androidx.annotation.DrawableRes
import com.raghu.cryptotracker.crypto.domain.Coin
import com.raghu.cryptotracker.core.presentation.util.getDrawableIdForCoin
import java.text.NumberFormat
import java.util.Locale

data class CoinUi ( val id:String,
    val rank:Int,
    val name:String,
    val symbol:String,
    val marketCapUSD:DisplayableNumber,
    val priceUSD:DisplayableNumber,
    val changePercent24Hr:DisplayableNumber,
    @DrawableRes val iconRes:Int )


data class DisplayableNumber(
        val value:Double,
        val formatted:String
)

fun Coin.toCoinUi() : CoinUi{
    return CoinUi(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        priceUSD = priceUSD.toDisplayableNumber(),
        marketCapUSD = marketCapUSD.toDisplayableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplayableNumber() : DisplayableNumber{
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply{
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    return DisplayableNumber(
                        value= this,
                        formatted = formatter.format(this))


}