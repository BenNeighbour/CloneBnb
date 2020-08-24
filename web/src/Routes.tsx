import * as React from 'react';
import { Route, Switch } from 'react-router-dom';
import './App.css';
import Login from './pages/Login/Login';
import Home from './pages/Home/Home';
import Search from './pages/Search/Search';
import Listing from './pages/Listing/Listing';

interface Props { }

const Routes: React.FC<Props> = (props) => {
  return (
    <Route>
      <Switch>
        <Route>
          <Route component={Login} exact path="/login" />
          <Route component={Home} exact path="/home" />
          <Route component={Search} exact path="/search" />
          <Route component={Listing} exact path="/listing/:listingId" />
        </Route>
      </Switch>
    </Route>
  );
}

export default Routes;
