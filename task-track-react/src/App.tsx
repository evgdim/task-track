import React, { Component } from 'react';
import { Route, Switch } from 'react-router';
import { BrowserRouter } from 'react-router-dom';

import './App.css';

import { Login } from './containers/login/Login';
import { Main } from './shared/main/MainContainer';

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <Switch>
          <Route path="/(login)" exact component={Login}></Route>
          <Route component={Main}></Route>
        </Switch>
      </BrowserRouter>
    );
  }
}

export default App;
