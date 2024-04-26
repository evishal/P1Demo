import { useState } from "react"
import { PokemonInterface } from "../../interfaces/PokemonInterface"
import "./Catch.css"
import axios from "axios"

export const Catch: React.FC = () => {

    //A variable to store user input for finding a pokemon
    let userInput:number = 0

    //we need to store pokemon state to use when rendering the PokemonComponent
    const [pokemon, setPokemon] = useState<PokemonInterface>({
        name:"",
        image:""
    })

    //a function that stores the user input (Which we need for our GET request)
    const gatherInput = (input:any) => {
        userInput = input.target.value //set the userInput to what's in the input box
    }

    //a function that sends a GET to PokeAPI based on the user's input
    const getPokemon = async () => {

        //sending our request to pokeAPI using the userInput as the pokemon id to search for
        const response = await axios.get("https://pokeapi.co/api/v2/pokemon/" + userInput)

    }

    return(
        <div className="home-page">
            <div className="home-container">
                <h3>Search For a Pokemon!</h3>
                <input type="number" placeholder="Enter Pokemon ID" onChange={gatherInput}/>
                <button className="poke-button">Find Pokemon</button>

            </div>
        </div>
    )
}