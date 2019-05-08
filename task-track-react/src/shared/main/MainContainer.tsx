import * as React from 'react';
import { Link, Route } from 'react-router-dom';
import Home from '../../containers/home/Home';
import Tasks from '../../containers/tasks/Tasks';
import NewTask from '../../containers/new-task/NewTask';
import { PrivateRoute } from '../authentication/PrivateRoute';

export interface IMainProps {
}

export function Main(props: IMainProps) {
    return (
        <div>
            <nav className="uk-navbar-container uk-margin" uk-navbar="mode: click">
                <div className="uk-navbar-center">
                    <ul className="uk-navbar-nav">
                        <li className="uk-active"><Link to="/">Home</Link></li>
                        <li><Link to="/tasks">Tasks</Link></li>
                        <li><Link to="/new">New</Link></li>
                    </ul>
                </div>
            </nav>

            <Route path="/" exact component={Home}></Route>
            <PrivateRoute path="/tasks" component={Tasks}></PrivateRoute>
            <PrivateRoute path="/new" component={NewTask}></PrivateRoute>
        </div>
    );
}
