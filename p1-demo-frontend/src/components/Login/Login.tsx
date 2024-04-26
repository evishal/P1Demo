import "./Login.css"

export const Login: React.FC = () => {




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

                <button className="login-button">Login</button>
                <button className="login-button">Create Account</button>

            </div>
        </div>
    )

}