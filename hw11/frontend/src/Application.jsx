import './App.css';
import React, {useEffect, useState} from "react";
import Middle from "./components/Middle/Middle";
import Footer from "./components/Footer/Footer";
import Header from "./components/Header/Header";
import axios from "axios";

function Application({page, login, posts, setLogin}) {

    return (
        <div>
            <Header setLogin={setLogin} login={login}/>
            <Middle
                posts={posts}
                page={page}
            />
            <Footer/>
        </div>
    );
}

export default Application;
