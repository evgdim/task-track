import React, { Component } from 'react';
import './App.css';
import { Route, Switch } from 'react-router';
import Home from './containers/home/Home';
import Tasks from './containers/tasks/Tasks';
import { Link } from 'react-router-dom';

class App extends Component {
  render() {
    return (
      <div>
        <Link to="/">Home</Link>
        <Link to="/tasks">Tasks</Link>
        <Switch>
          <Route path="/" exact component={Home}></Route>
          <Route path="/tasks" component={Tasks}></Route>
        </Switch>
      </div>
    );
  }
}

export default App;
