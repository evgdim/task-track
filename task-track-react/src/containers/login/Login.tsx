import * as React from 'react';

export interface ILoginProps {
}

export function Login(props: ILoginProps) {
    return (
        <div>
            Username: <input type="text"></input>
            Password: <input type="text"></input>
            <button>Login</button>
        </div>
    );
}
