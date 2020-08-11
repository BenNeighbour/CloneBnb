import * as React from 'react';
import { Route, Switch } from 'react-router-dom';
import './App.css';
import Login from './pages/Login';

interface Props { }

const Routes: React.FC<Props> = (props) => {
  return (
    <Route>
      <Switch>
        <Route>
          <Route component={Login} exact path="/login" />
        </Route>
      </Switch>
    </Route>
  );
}

export default Routes;
