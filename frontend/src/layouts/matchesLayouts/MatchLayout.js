import React from "react";
import {withRouter} from "react-router-dom";

import {Button, Tabs, Form, message} from 'antd';

import "./matchStyles.css";

import schema from "./matchFormConfig";
import {team1 as team1Schema, team2 as team2Schema} from "./teamsFormConfig";

import {UniversalForm} from "../../components/common/universalForm";
import {UniversalTable} from "../../components/common/universalTable";


class MatchLayout extends React.Component {
  state = {
    count: 1,

    team1: [],
    team2: [],

    isTeam2winner: null
  };

  teamsColumns = {
    player: "Player",
    hero: "Hero"
  };

  mainFormId = "matchFromId";
  team1FormId = "team1FormId";
  team2FormId = "team2FormId";

  mainFormActions = {
    onSubmit: () => {
    }
  };

  teamFormActions = {
    onSubmit: () => {
    }
  }

  EditableRow = ({index, ...props}) => {
    const EditableContext = React.createContext(null);
    const [form] = Form.useForm();
    return (
      <Form form={form} component={false}>
        <EditableContext.Provider value={form}>
          <tr {...props} />
        </EditableContext.Provider>
      </Form>
    );
  };

  handleAdd = (param) => {
    if (this.state[param].length.valueOf() === 5) {
      return;
    }
    const {count} = this.state;
    const newData = {
      key: count,
      player: `Player ${count}`,
      hero: `Hero ${count}`,
    };
    this.setState({
      [param]: [...this.state[param], newData],
      count: count + 1,
    });
  };

  mainFormHandler = () => {
  };
  team1FormHandler = () => {
  };
  team2FormHandler = () => {
  };

  mainFormObserver = {
    submit: handler => this.mainFormHandler = handler
  }

  team1FormObserver = {
    submit: handler => this.team1FormHandler = handler
  }

  team2FormObserver = {
    submit: handler => this.team2FormHandler = handler
  }

  submitHandler = () => {
    Promise.all([this.mainFormHandler(), this.team1FormHandler(), this.team2FormHandler()])
      .then(values => {
        console.log(values[0]);
        console.log(values[1]);
        console.log(values[2]);
      })
      .catch(err => console.log(err));
  }

  componentDidMount() {
    if (this.props.match.params.id) {
      this.props.getOneMatch(this.props.match.params.id)
    }
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    const {current} = this.props.matches;
    if (prevProps.matches.current !== current) {
      this.setState({teams: current.data.team1, team2: current.data.team2});
    }
  }

  render() {
    const components = {
      body: {
        row: this.EditableRow,
      },
    };

    return (
      <div className={"main-container"}>

        <div className={"form-container"}>
          <div className={"form"}>
            {this.props.match.params.id
              ? <UniversalForm schema={schema}
                               data={this.props.matches.current.data}
                               readonly={this.props.readonly}
                               observer={this.mainFormObserver}
                               id={this.mainFormId}
                               labelsSpan={12}
                               wrappersSpan={12}
                               actions={this.mainFormActions}/>
              : <UniversalForm schema={schema}
                               observer={this.mainFormObserver}
                               id={this.mainFormId}
                               labelsSpan={12}
                               wrappersSpan={12}
                               actions={this.mainFormActions}/>}
          </div>
        </div>

        <div className={"tabs"}>
          <Tabs defaultActiveKey="1">
            <Tabs.TabPane tab="Team 1" key="2">
              <UniversalForm schema={team1Schema}
                             readonly={this.props.readonly}
                             observer={this.team1FormObserver}
                             id={this.team1FormId}
                             labelsSpan={12}
                             wrappersSpan={12}
                             actions={this.teamFormActions}/>
              <Button onClick={() => this.handleAdd("team1")} className={"button"}
                      htmlType={"add"}>
                Add
              </Button>
              <UniversalTable key={5}
                              readonly={this.props.readonly}
                              expandable={{
                                expandedRowRender: record => <p style={{margin: 0}}>{"Expandable"}</p>,
                                rowExpandable: record => record.name !== 'Not Expandable',
                              }}
                              rowClassName={() => 'editable-row'}
                              components={components}
                              data={this.state.team1}
                              columns={this.teamsColumns}/>
            </Tabs.TabPane>

            <Tabs.TabPane tab="Team 2" key="3">
              <UniversalForm schema={team2Schema}
                             readonly={this.props.readonly}
                             observer={this.team2FormObserver}
                             id={this.team2FormId}
                             labelsSpan={12}
                             wrappersSpan={12}
                             actions={this.teamFormActions}/>
              <Button onClick={() => this.handleAdd("team2")} className={"button"}
                      htmlType={"add"}>
                Add
              </Button>
              <UniversalTable key={5}
                              readonly={this.props.readonly}
                              expandable={{
                                expandedRowRender: record => <p style={{margin: 0}}>{"Expandable"}</p>,
                                rowExpandable: record => record.name !== 'Not Expandable',
                              }}
                              rowClassName={() => 'editable-row'}
                              data={this.state.team2}
                              columns={this.teamsColumns}/>
            </Tabs.TabPane>
          </Tabs>
        </div>

        <div className={"footer-buttons"}>
          {!this.props.readonly
            ? <Button onClick={this.submitHandler} className={"button"} htmlType={"submit"}>
              Save
            </Button>
            : undefined
          }
        </div>

      </div>
    )
  }
}

export default withRouter(MatchLayout);
