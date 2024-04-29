package com.revature.services;

import com.revature.DAOs.PokemonDAO;
import com.revature.DAOs.UserDAO;
import com.revature.models.DTOs.IncomingPokeDTO;
import com.revature.models.Pokemon;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    private PokemonDAO pokemonDAO;
    private UserDAO userDAO;

    @Autowired
    public PokemonService(PokemonDAO pokemonDAO, UserDAO userDAO) {
        this.pokemonDAO = pokemonDAO;
        this.userDAO = userDAO;
    }

    //add pokemon to DB
    public Pokemon addPokemon(IncomingPokeDTO pokeDTO){

        //There aren't actual meaningful checks we can do on this
        //Because we assume valid poke data is coming from the pokeAPI (not user input)

        //We could check for things like valid poke name and image, valid userID
        //or maybe we can only allow each user to have x amount of pokemon
            //OR only one of each type of pokemon

        //But for now, we'll just insert a Pokemon

        //we need to get the User by id, and set it with the setter
        Pokemon p = new Pokemon(pokeDTO.getName(), pokeDTO.getImage(), null);

        //Instantiate the appropriate user
        User u = userDAO.findById(pokeDTO.getUserId()).get();

        //Set the user in the Pokemon object
        p.setUser(u);

        //now we can save the pokemon!
        return pokemonDAO.save(p);
    }

}
