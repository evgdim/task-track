import * as React from 'react';
import { Link, Route } from 'react-router-dom';
import Home from '../home/Home';
import Tasks from '../tasks/Tasks';
import NewTask from '../new-task/NewTask';

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
            <Route path="/tasks" component={Tasks}></Route>
            <Route path="/new" component={NewTask}></Route>
        </div>
    );
}
