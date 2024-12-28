import './App.css';
import Enter from "./components/Middle/Main/Enter/Enter";
import Index from "./components/Middle/Main/Index/Index";
import React, {useEffect, useState} from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Application from "./Application";
import axios from "axios";
import Users from './components/Middle/Main/Users/Users';
import NotFound from './components/Middle/Main/NotFound/NotFound';
import Post from './components/Middle/Main/Post/Post';

function App() {

    const [login, setLogin] = useState(null)
    useEffect(() => {
        if (localStorage.getItem("jwt")){
            axios.get("/api/jwt", {
                params: {
                    jwt: localStorage.getItem("jwt")
                }
            }).then((response)=>{
                localStorage.setItem("login", response.data.login);
                setLogin(response.data.login)
            }).catch((error)=>{
                console.log(error)
            })
        }
    }, []);

    const [users, setUsers] = useState(null)
    // const array = useState(null)
    // const user = array[0]
    // const setUser = array[1]
    useEffect(() => {
        axios.get("/api/users").then((response)=>{
            setUsers(response.data)
        }).catch((error)=>{
            console.log(error)
        })
    }, [])

    const [posts, setPosts] = useState(null)

    useEffect(() => {
        axios.get("/api/posts").then((response)=>{
            setPosts(response.data)
        }).catch((error)=>{
            console.log(error)
        })
    }, []);

    return (
        <div className="App">
            <BrowserRouter>
                <Routes>
                    <Route
                        index={true}
                        element={<Application setLogin={setLogin} posts={posts} login={login} page={<Index posts={posts}/>}/>}
                    />
                    <Route
                        exact path={'/enter'}
                        element={<Application setLogin={setLogin} posts={posts} login={login} page={<Enter setLogin={setLogin}/>}/>}
                    />
                    <Route
                        exact path={'/users'}
                        element={<Application setLogin={setLogin} posts={posts} login={login} page={<Users users={users} login={login}/>}/>}
                    />
                    <Route
                        path={'/posts/:id'}
                        element={<Application setLogin={setLogin} posts={posts} login={login} page={<Post posts={posts}/>}/>}
                    />
                    <Route 
                        path={'*'} 
                        element={<Application setLogin={setLogin} posts={posts} login={login} page={<NotFound/>}/>} 
                    />
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
