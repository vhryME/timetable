import React from "react";
import ReactDOM from "react-dom";
import {Provider} from "react-redux";
import moment from 'moment';

import "./index.css";
import App from "./App";
import store from "./redux/store/store";
import {BrowserRouter} from "react-router-dom";

const heroes = [{
  id: 1,
  key: 1,
  skills: [],
  creationDate: moment('2015/01/01', 'YYYY/MM/DD'),
  icon: null,
  melee: true,
  name: "Billerens",
  role: "Assassin",
  talents: [],
}, {
  id: 2,
  key: 2,
  skills: [],
  creationDate: moment('2015/01/03', 'YYYY/MM/DD'),
  icon: null,
  melee: false,
  name: "Alucard",
  role: "Multiclass",
  talents: [],
}]

localStorage.setItem("heroes", JSON.stringify(heroes));

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
