package com.revature.controllers;

import com.revature.models.DTOs.IncomingPokeDTO;
import com.revature.models.Pokemon;
import com.revature.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin(origins = "http://localhost:3000")
public class PokeController {

    private PokemonService pokemonService;

    @Autowired
    public PokeController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    //post mapping for inserting new pokemon
    @PostMapping("/{userId}")
    public ResponseEntity<String> addPokemon(@RequestBody IncomingPokeDTO pokeDTO, @PathVariable int){

        //TODO: once login is done, just send userId with the pokemon from the frontEnd

        //attach the userId to the DTO
        pokeDTO.setUserId(userId);

        //TODO: try/catch once we decide to do some error handling
        Pokemon p = pokemonService.addPokemon(pokeDTO);

        return ResponseEntity.status(201).body(
                p.getUser().getUsername() + " caught " + p.getName());

    }

}
