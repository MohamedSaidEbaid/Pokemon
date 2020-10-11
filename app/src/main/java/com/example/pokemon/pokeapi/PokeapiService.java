package com.example.pokemon.pokeapi;

import com.example.pokemon.models.PokemonRequest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeapiService {
    @GET("pokemon")
    Call<PokemonRequest> getPokemonList();
}