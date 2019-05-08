import * as React from 'react';
import { RouteProps, Route, Redirect } from 'react-router';
import { Auth } from './AuthenticationService';

export interface IPrivateRouteProps extends RouteProps {
    component: any
}

export function PrivateRoute (props: IPrivateRouteProps) {
    const { component: Component, ...rest } = props;
    
    return (
        <Route
            {...rest}
            render={(routeProps) =>
                Auth.isAuthenticated ? (
                    <Component {...routeProps} />
                ) : (
                        <Redirect
                            to={{
                                pathname: '/login',
                                state: { from: routeProps.location }
                            }}
                        />
                    )
            }
        />
    );
}
