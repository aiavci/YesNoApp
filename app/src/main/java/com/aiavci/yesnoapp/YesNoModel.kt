package com.aiavci.yesnoapp

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

class YesNoModel(val answer: String = "",
                 val image: String = "") {

    class Deserializer : ResponseDeserializable<YesNoModel> {
        override fun deserialize(content: String) = Gson().fromJson(content, YesNoModel::class.java)
    }
}