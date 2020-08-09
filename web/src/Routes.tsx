import * as React from 'react';
import { Route, Switch } from 'react-router-dom';
import './App.css';
import Home from './pages/Home';

interface Props { }

const Routes: React.FC<Props> = (props) => {
  return (
    <Route>
      <Switch>
        <Route>
          <Route component={Home} exact path="/" />
        </Route>
      </Switch>
    </Route>
  );
}

export default Routes;
