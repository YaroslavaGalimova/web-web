import React from 'react';

const Footer = ({usersCount, postsCount}) => {
    return (
        <footer>
            <a href="#">CODEFORCES</a> 2099 by Mike Mirzayanov 
            <div className='UsersCount'>Users: {usersCount}</div> 
            <div className='PostsCount'> Posts: {postsCount}</div>
        </footer>
    );
};

export default Footer;