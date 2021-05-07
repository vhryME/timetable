import React from "react";
import ReactDOM from "react-dom";
import {Provider} from "react-redux";
import moment from 'moment';
import {BrowserRouter} from "react-router-dom";

import {getDictionaries} from "./actions";

import "./index.css";
import App from "./App";

import store from "./redux/store/store";

store.dispatch(getDictionaries());

const matches = [{
  id: 1,
  key: 1,
  typeOfMatch: "Hero League",
  date: moment('2020-03-01', 'YYYY-MM-DD'),
  duration: 3000000.0,
  maps: ["BraxisOutpost", "CursedHollow"],
  region: "NA",
  team1: {
    playerInMatch1: {
      player: "Player 1",
      hero: "Hero 1"
    },
    playerInMatch2: {
      player: "Player 2",
      hero: "Hero 2"
    },
    playerInMatch3: {
      player: "Player 3",
      hero: "Hero 3"
    },
    playerInMatch4: {
      player: "Player 4",
      hero: "Hero 4"
    },
    playerInMatch5: {
      player: "Player 5",
      hero: "Hero 5"
    },
  },
  team2: {
    playerInMatch1: {
      player: "Player 1",
      hero: "Hero 1"
    },
    playerInMatch2: {
      player: "Player 2",
      hero: "Hero 2"
    },
    playerInMatch3: {
      player: "Player 3",
      hero: "Hero 3"
    },
    playerInMatch4: {
      player: "Player 4",
      hero: "Hero 4"
    },
    playerInMatch5: {
      player: "Player 5",
      hero: "Hero 5"
    },
  },
  winner: "Team 1"
}, {
  id: 2,
  key: 2,
  typeOfMatch: "Brawl",
  date: moment('2010-09-06', 'YYYY-MM-DD'),
  duration: 12345678.9,
  maps: ["AlteracPass", "SkyTemple"],
  region: "EU",
  team1: {
    playerInMatch1: {
      player: "Player 1",
      hero: "Hero 1"
    },
    playerInMatch2: {
      player: "Player 2",
      hero: "Hero 2"
    },
    playerInMatch3: {
      player: "Player 3",
      hero: "Hero 3"
    },
    playerInMatch4: {
      player: "Player 4",
      hero: "Hero 4"
    },
    playerInMatch5: {
      player: "Player 5",
      hero: "Hero 5"
    },
  },
  team2: {
    playerInMatch1: {
      player: "Player 1",
      hero: "Hero 1"
    },
    playerInMatch2: {
      player: "Player 2",
      hero: "Hero 2"
    },
    playerInMatch3: {
      player: "Player 3",
      hero: "Hero 3"
    },
    playerInMatch4: {
      player: "Player 4",
      hero: "Hero 4"
    },
    playerInMatch5: {
      player: "Player 5",
      hero: "Hero 5"
    },
  },
  winner: "Team 2"
}];

localStorage.setItem("matches", JSON.stringify(matches));


ReactDOM.render(
  <React.StrictMode>
    <Provider store={store}>
      <BrowserRouter>
        <App/>
      </BrowserRouter>
    </Provider>
  </React.StrictMode>,
  document.getElementById("root")
);
