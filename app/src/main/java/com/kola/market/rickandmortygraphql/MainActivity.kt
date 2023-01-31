package com.kola.market.rickandmortygraphql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.kola.market.rickandmortygraphql.data.RichAndMortyResult
import com.kola.market.rickandmortygraphql.domain.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeViewModel.resultListCharacters.observe(this){
            when(it) {
                is RichAndMortyResult.Success -> {
                    toast(it.data.toString())
                }
                is RichAndMortyResult.Error -> {
                    toast("error")
                }
                else -> {
                    toast("nothing")
                }
            }
        }
        homeViewModel.getCharacters()

    }
}