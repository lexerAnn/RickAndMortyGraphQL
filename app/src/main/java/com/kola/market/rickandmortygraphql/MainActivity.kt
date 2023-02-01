package com.kola.market.rickandmortygraphql

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kola.market.rickandmortygraphql.adapter.CharacterAdapter
import com.kola.market.rickandmortygraphql.data.RichAndMortyResult
import com.kola.market.rickandmortygraphql.databinding.ActivityMainBinding
import com.kola.market.rickandmortygraphql.domain.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    private lateinit var characterAdapter: CharacterAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        characterAdapter = CharacterAdapter(){

        }


        homeViewModel.resultListCharacters.observe(this){
            when(it) {
                is RichAndMortyResult.Success -> {
                    it.data?.results?.let { it1 -> characterAdapter.submitList(it1) }
                }
                is RichAndMortyResult.Error -> {
                }
                else -> {
                }
            }
        }
        homeViewModel.resultCharacterDetails.observe(this){
            when(it) {
                is RichAndMortyResult.Success -> {
                    println(it.data)
                    toast(it.data.toString())
                }
                is RichAndMortyResult.Error -> {
                }
                else -> {
                }
            }
        }

//        homeViewModel.getCharacters(1)
        homeViewModel.getCharacterDetails("1")

        binding.rvCharacters.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvCharacters.adapter = characterAdapter

    }
}