package com.aiavci.yesnoapp

import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.util.FuelRouting

sealed class YesNoApi : FuelRouting {
    override val basePath: String = "https://yesno.wtf"

    class YesNoFor: YesNoApi()

    override val body: String? = null

    override val headers: Map<String, String>? = null

    override val method: Method
        get() {
            when(this) {
                is YesNoFor -> return Method.GET
            }
        }

    override val params: List<Pair<String, Any?>>? = null

    override val path: String
        get() {
            return when(this) {
                is YesNoFor -> "/api"
            }
        }
}