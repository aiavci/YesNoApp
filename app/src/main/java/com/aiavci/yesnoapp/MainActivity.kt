package com.aiavci.yesnoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log
import com.github.kittinunf.fuel.Fuel
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Fuel.request(YesNoApi.YesNoFor()).responseObject(YesNoModel.Deserializer()) { _, _, result ->
            result.fold(success = { json ->
                Log.d("YesNoApi success", json.answer)

                Fuel.get(json.image).response { _, response, _ ->
                    gifView.apply {
                        setBytes(response.data)
                        startAnimation()
                    }

                    textView.text = json.answer
                }

            }, failure = { error ->
                Log.e("YesNoApi error", error.toString())
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onStop() {
        super.onStop()
        gifView.stopAnimation()
    }
}