import React, {useRef, useState} from 'react';

const Register = ({setPage, createUser, users}) => {

    const loginInputRef = useRef(null)
    const nameInputRef = useRef(null)
    const [error, setError] = useState('')

    const handleSubmit = (event) => {
        event.preventDefault()
        const login = loginInputRef.current.value
        const name = nameInputRef.current.value
        if (name.length < 1 || name.length > 32) {
            setError('Name should be between 1 and 32 characters long')
            return
        }
        if (login.length < 3 || login.length > 16) {
            setError('Login should be between 3 and 16 characters long')
            return
        }
        if (!login.match(/^[a-z]+$/)) {
            setError('Login should contain only lowercase letters')
            return
        }
        if (users.find((user) => user.login === login))  {
            setError('Login should be unique')
            return
        }
        createUser({
            login: login,
            name: name
        })
        setPage('enter')
    }

    return (
        <div className="register form-box">
            <div className="header">Register</div>
            <div className="body">
                <form method="" action="" onSubmit={handleSubmit}>
                    <input type="hidden" name="action" value="register"/>
                    <div className="field">
                        <div className="name">
                            <label htmlFor="login">Login</label>
                        </div>
                        <div className="value">
                            <input
                                autoFocus
                                name="login"
                                ref={loginInputRef}
                                onChange={() => setError(null)}
                            />
                        </div>
                    </div>
                    <div className="field">
                        <div className="name">
                            <label htmlFor="name">Name</label>
                        </div>
                        <div className="value">
                            <input
                                name="name"
                                type="text"
                                ref={nameInputRef}
                                onChange={() => setError(null)}
                            />
                        </div>
                    </div>
                    {error
                        ? <div className={'error'}>{error}</div>
                        : null
                    }
                    <div className="button-field">
                        <input type="submit" value="Register"/>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default Register;