import React from "react";

import {BrowserRouter as Router, Switch, Route} from "react-router-dom";

import "./styles.css";

import {HeroesTable, HeroForm} from "../heroesLayouts";
import Menu from "../../components/menu/Menu";
import {MatchesTable, MatchForm} from "../matchesLayouts";
import TimetableLayout from "../timetableLayout/TimetableLayout";

class MainLayout extends React.Component {
  render() {
    return (
      <Router>
        <div className="container">
          <div className="menu">
            <Menu/>
          </div>
          <div className="content" style={{}}>
            <Switch className="content">
              <Route exact path="/heroes/edit/:id">
                <HeroForm/>
              </Route>

              <Route exact path="/heroes/edit/:id">
                <HeroForm/>
              </Route>
              <Route exact path="/matches/edit/:id">
                <MatchForm/>
              </Route>

              <Route exact path="/heroes/view/:id">
                <HeroForm readonly/>
              </Route>
              <Route exact path="/matches/view/:id">
                <MatchForm readonly/>
              </Route>

              <Route exact path="/heroes/new">
                <HeroForm/>
              </Route>
              <Route exact path="/matches/new">
                <MatchForm/>
              </Route>


              <Route exact path="/heroes">
                <HeroesTable/>
              </Route>
              <Route exact path="/matches">
                <MatchesTable/>
              </Route>

              <Route exact path="/timetable">
                <TimetableLayout/>
              </Route>

            </Switch>
          </div>
        </div>
      </Router>
    );
  }
}

export default MainLayout;
