import React from 'react';
import {useNavigate} from "react-router-dom";

const EnterOrRegister = ({login, setLogin}) => {

    const router = useNavigate()

    return (
        <div className="enter-or-register-box">
            {login
                ?
                <>
                    {login}
                    <a href="#" onClick={(event) => {
                        setLogin(null)
                        localStorage.removeItem("jwt")
                        localStorage.removeItem("login")
                        event.preventDefault()
                    }}>
                        Logout
                    </a>
                </>
                :
                <>
                    <a href="#" onClick={(event) => {
                        router("/enter")
                        event.preventDefault()
                    }}>Enter</a>
                    <a href="#">Register</a>
                </>
            }
        </div>
    );
};

export default EnterOrRegister;