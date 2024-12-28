import React from 'react';
import cat from "../../../../assets/img/404.jpg";

const NotFound = () => {
    return (
        <div>
            <h1>404</h1>
            <p>Page not found</p>
            <img src={cat} alt="404"/>
        </div>
    );
};

export default NotFound;