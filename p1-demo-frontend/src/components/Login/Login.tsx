import { useNavigate } from "react-router-dom"
import "./Login.css"

export const Login: React.FC = () => {

    //we need a useNavigate hook to allow us to navigate between components... no more manual URL changes!
    const navigate = useNavigate()

    //this function will (EVENTUALLY) gather username and password, and send a POST to our java server
    const login = async () => {

        //TODO: make this send an actual POST with the user inputs

        //use our useNavigate hook to switch views to the Catch Pokemon Component
        navigate("/catch")

    }


    return(
        <div className="login">
            <div className="text-container">
                <h1>Welcome to the Pokemon Exchange</h1>
                <h3>Sign in to Catch and View Pokemon!</h3>

                <div className="input-container">
                    <input type="text" placeholder="username" name="username"/>
                </div>

                <div className="input-container">
                    <input type="password" placeholder="password" name="password"/>
                </div>

                <button className="login-button" onClick={login}>Login</button>
                <button className="login-button" onClick={() => navigate("/register")}>Create Account</button>

            </div>
        </div>
    )

}