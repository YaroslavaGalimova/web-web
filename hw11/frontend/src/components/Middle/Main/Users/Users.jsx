import React from 'react';

const Users = ({users, login}) => {
    if (users === null || users.length === 0) {
        return <div>No users found. Wait...</div>;
    }

    if (!login) {
        return (<h> Access denied </h>)
    }

    return (
        <div className="users datatable">
            <div className="caption">User</div>
            <table>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Login</th>
                </tr>
                </thead>
                <tbody>
                    {
                        users.map((user, index) => (
                            <tr key={index}>
                                <td>{user.id}</td>
                                <td>{user.login}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
};

export default Users;