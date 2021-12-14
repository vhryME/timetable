import React from "react";

import {BrowserRouter as Router, Switch, Route} from "react-router-dom";

import "./styles.css";

import Menu from "../../components/menu/Menu";
import {Timetable} from "../timetableLayout";
import OAuth2RedirectHandler from "../../components/oauth2/OAuth2RedirectHandler";

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

              <Route exact path="/timetable" component={Timetable}/>
              {/*<Route path="/oauth2/redirect" component={OAuth2RedirectHandler}/>*/}

            </Switch>
          </div>
        </div>
      </Router>
    );
  }
}

export default MainLayout;
