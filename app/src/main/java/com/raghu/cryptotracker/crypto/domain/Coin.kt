package com.raghu.cryptotracker.crypto.domain

data class Coin(
                val id:String,
                val rank:Int,
                val name:String,
                val symbol:String,
                val marketCapUSD:Double,
                val priceUSD:Double,
                val changePercent24Hr:Double
    )
