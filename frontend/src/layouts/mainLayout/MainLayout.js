import React from "react";

import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

import ServerAnswer from "../../components/serverAnswer";
import { UniversalForm } from "../../components/universalForm";

import { UniversalTable } from "../../components/universalTable";

import schema from "./config";

const actions = {
  onSubmit: (value) => {
    console.log(value);
  },
  onClear: (ref) => {
    ref.resetFields();
    console.log("onClear");
  },
  onAdd: (ref) => {
    ref.setFieldsValue({ firstName: "Johnny" });
    console.log("onAdd");
  },
  onError: (e) => {
    console.log("onError: ", e);
  },
};

const data = {
  firstName: "Ilya",
  lastName: "Degtyarik",
  age: "20",
  checkbox: true,
  telephone: "375298323063",
  email: "degtyarik.ilya@yandex.ru",
};

const tableData = [
  {
    key: "1",
    firstName: "Ilya",
    lastName: "Degtyarik",
    age: "20",
    checkbox: true,
    telephone: "375298323063",
    email: "degtyarik.ilya@yandex.ru",
    team: "Ninjas in Pijamas",
  },
  {
    key: "2",
    firstName: "Vasya",
    lastName: "Pupkin",
    age: "36",
    checkbox: true,
    telephone: "88005553535",
    email: "prosche.pozvonit@chemzanim.at",
    team: "Na'Vi",
  },
  {
    key: "3",
    firstName: "Vladimir",
    lastName: "Puptin",
    age: "28",
    checkbox: false,
    telephone: "88005553536",
    email: "prosche.pozvonit@chemzanimatbelaru.si",
    team: "Na'Vi",
  },
];

const tableColumns = {
  firstName: {
    label: "First name",
    sorter: (a, b) => a.firstName.length - b.firstName.length,
  },
  lastName: "Last name",
  age: { label: "Age", sorter: (a, b) => a.age - b.age },
  telephone: "Mobile number",
  email: "Email",
  team: "Team",
};

const tableActions = {
  onDelete: (value) => {
    console.log("Row deleted: ", value);
  },
  onAdd: (value) => {
    console.log("New row added: ", value);
  },
  onEdit: (value) => {
    console.log("Row edited to: ", value);
  },
};

class MainLayout extends React.Component {
  render() {
    return (
      <Router>
        <nav>
          <ul>
            <li>
              <Link to="/server-test">Server test</Link>
            </li>
            <li>
              <Link to="/uform-readonly">UForm readonly</Link>
            </li>
            <li>
              <Link to="/uform-edit">UForm edit</Link>
            </li>
            <li>
              <Link to="/uform">UForm default</Link>
            </li>
            <li>
              <Link to="/utable">UTable</Link>
            </li>
          </ul>
        </nav>

        <Switch>
          <Route path="/server-test">
            <ServerAnswer />
          </Route>

          <Route path="/uform-readonly">
            <UniversalForm
              key={"uform-readonly"}
              schema={schema}
              readonly
              data={data}
              actions={actions}
            />
          </Route>

          <Route path="/uform-edit">
            <UniversalForm
              key={"uform-edit"}
              schema={schema}
              data={data}
              actions={actions}
            />
          </Route>

          <Route path="/uform">
            <UniversalForm key={"uform"} schema={schema} actions={actions} />
          </Route>

          <Route path="/utable">
            <UniversalTable
              key={"utable"}
              schema={schema}
              data={tableData}
              actions={tableActions}
              columns={tableColumns}
            />
          </Route>
        </Switch>
      </Router>
    );
  }
}

export default MainLayout;
