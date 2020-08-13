import * as React from 'react';
import { Route, Switch } from 'react-router-dom';
import './App.css';
import Login from './pages/Login/Login';
import Home from './pages/Home/Home';

interface Props { }

const Routes: React.FC<Props> = (props) => {
  return (
    <Route>
      <Switch>
        <Route>
          <Route component={Login} exact path="/login" />
          <Route component={Home} exact path="/home" />
        </Route>
      </Switch>
    </Route>
  );
}

export default Routes;
