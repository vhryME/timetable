import React from "react";

import {BrowserRouter as Router, Switch, Route, Link} from "react-router-dom";

import {HeroesTable, HeroForm} from "../heroesLayouts";

class MainLayout extends React.Component {
  render() {
    return (
      <Router>
        <nav>
          <ul>
            <li>
              <Link to="/heroes">All heroes</Link>
            </li>
          </ul>
        </nav>

        <Switch>
          <Route exact path="/heroes/edit/:id">
            <HeroForm/>
          </Route>

          <Route exact path="/heroes/view/:id">
            <HeroForm readonly/>
          </Route>

          <Route exact path="/heroes/new">
            <HeroForm/>
          </Route>

          <Route exact path="/heroes">
            <HeroesTable/>
          </Route>
        </Switch>
      </Router>
    );
  }
}

export default MainLayout;
