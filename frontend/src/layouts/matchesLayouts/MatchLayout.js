import React from "react";
import {withRouter} from "react-router-dom";

import {Button, Tabs, Form, message, Modal} from 'antd';
import {v4 as uuidv4} from 'uuid';

import "./matchStyles.css";

import schema from "./config/oneMatch/matchFormConfig";
import {schema as teamSchema} from "./config/oneMatch/teamsFormConfig";
import {
    statistic as statisticsSchema,
    statisticDemo as statisticsDemoSchema,
    actions as statisticsActions
} from "./config/oneMatch/statisticFormConfig";
import {columns as talentsColumns} from "./config/oneMatch/talentsTableConfig";
import {columns as teamsColumns, actions as teamActions} from "./config/oneMatch/teamsTableConfig";
import {schema as playerAddSchema, actions as playerAddActions} from "./config/oneMatch/playerAddFormConfig";

import {UniversalForm} from "../../components/common/universalForm";
import {UniversalTable} from "../../components/common/universalTable";
import TalentsTree from "../../components/talentsTree/TalentsTree";

const mockedTeam1 = [
    {player: "Player 1", hero: "Hero 1", key: uuidv4()},
    {player: "Player 2", hero: "Hero 2", key: uuidv4()},
    {player: "Player 3", hero: "Hero 3", key: uuidv4()},
    {player: "Player 4", hero: "Hero 4", key: uuidv4()},
]

const mockedTeam2 = [
    {player: "Player 1", hero: "Hero 1", key: uuidv4()},
    {player: "Player 2", hero: "Hero 2", key: uuidv4()},
    {player: "Player 3", hero: "Hero 3", key: uuidv4()},
    {player: "Player 4", hero: "Hero 4", key: uuidv4()},
]

class MatchLayout extends React.Component {
    state = {
        count: 1,

        typeOfMatch: null,
        region: null,
        winner: null,

        levelOfTeam1: null,
        levelOfTeam2: null,

        statisticsAdding: false,
        statisticsPlayerKey: null,
        statisticsTeamAdding: null,

        talentsAdding: false,
        teamTalentsAdding: null,
        playerTalentsAdding: null,

        team1playerAdding: false,
        team2playerAdding: false,

        experienceOfTeam1: null,
        experienceOfTeam2: null,

        team1: mockedTeam1,
        team2: mockedTeam2,

        currentPlayerInMatch: null
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
    };

    mainFormHandler = () => {
    };
    team1FormHandler = () => {
    };
    team2FormHandler = () => {
    };

    mainFormObserver = {
        submit: handler => this.mainFormHandler = handler
    };
    team1FormObserver = {
        submit: handler => this.team1FormHandler = handler
    };
    team2FormObserver = {
        submit: handler => this.team2FormHandler = handler
    };

    handleAdd = (param) => {
        this.setState({[param + "playerAdding"]: true})
    };

    checkIfTeamsInvalid = (team) => {
        let invalid = false;
        team.map(item => {invalid = !item.talents || !item.stats})
        if (invalid) {
            message.error("Please, check teams players talents and stats!")
        }
        return invalid;
    }

    submitHandler = () => {
        Promise.all([this.mainFormHandler(), this.team1FormHandler(), this.team2FormHandler()])
            .then(values => {
                let tableInvalid = false;
                if (this.state.team1.length !== 5 || this.state.team2.length !== 5) {
                    message.error("5 players in each team required!");
                    tableInvalid = true;
                } else {
                    tableInvalid = this.checkIfTeamsInvalid(this.state.team1) || this.checkIfTeamsInvalid(this.state.team2);
                }

                if (!tableInvalid) {
                    let match = {...this.state};

                    match.typeOfMatch = values[0].typeOfMatch;
                    match.region = values[0].region;
                    match.levelOfTeam1 = values[1].levelOfTeam;
                    match.levelOfTeam2 = values[2].levelOfTeam;
                    match.experienceOfTeam1 = values[1].experienceOfTeam;
                    match.experienceOfTeam2 = values[2].experienceOfTeam;
                    if (values[0].winner) {
                        match.winner = "Team 2"
                    } else {
                        match.winner = "Team 1"
                    }

                    console.log(match);
                    this.props.newMatch(match);

                    this.props.getAllMatches();
                    console.log(match, `match ${this.props.match.params.id} created!`);
                    this.props.history.push("/matches");
                }
            })
            .catch(err => console.log(err));
    };

    onTalentsAddingHandler = (values) => {
        this.setState(
            {
                [this.state.teamTalentsAdding]: this.state[this.state.teamTalentsAdding].map((item) => {
                    if (item.key === this.state.playerTalentsAdding) {
                        return {...item, talents: values}
                    }
                    return item
                }),
                talentsAdding: false
            })
    }

    componentDidMount() {
        if (this.props.match.params.id) {
            this.props.getOneMatch(this.props.match.params.id)
        }
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        const {current} = this.props.matches;
        if (prevProps.matches.current !== current) {
            this.setState({team1: current.data.team1, team2: current.data.team2});
        }
    }

    render() {
        return (
            <div className={"match--main-container"}>

                <Modal title={"Talents"}
                       destroyOnClose
                       footer={null}
                       bodyStyle={{width: "auto"}}
                       width={"fit-content"}
                       closable={!!this.props.readonly}
                       onCancel={() => this.setState({talentsAdding: false})}
                       visible={this.state.talentsAdding}>
                    <TalentsTree onSubmit={this.onTalentsAddingHandler}/>
                </Modal>

                <Modal title={"Statistics"}
                       destroyOnClose
                       footer={null}
                       bodyStyle={{width: "auto"}}
                       width={"fit-content"}
                       closable={!!this.props.readonly}
                       onCancel={() => this.setState({statisticsAdding: false})}
                       visible={this.state.statisticsAdding}>
                    <UniversalForm schema={statisticsSchema(this.state.statisticsPlayerKey)}
                                   cols={3}
                                   labelsSpan={12}
                                   wrappersSpan={12}
                                   actions={statisticsActions(this, this.state.statisticsPlayerKey)}/>
                </Modal>

                <Modal title={"Adding 1st team player"}
                       destroyOnClose
                       footer={null}
                       bodyStyle={{width: "auto"}}
                       width={"fit-content"}
                       closable={!!this.props.readonly}
                       onCancel={() => this.setState({team1playerAdding: false})}
                       visible={this.state.team1playerAdding}>
                    <UniversalForm schema={playerAddSchema}
                                   width={"300px"}
                                   readonly={this.props.readonly}
                                   labelsSpan={12}
                                   wrappersSpan={12}
                                   actions={playerAddActions(this, "team1")}/>
                </Modal>

                <Modal title={"Adding 2nd team player"}
                       destroyOnClose
                       footer={null}
                       bodyStyle={{width: "auto"}}
                       width={"fit-content"}
                       closable={!!this.props.readonly}
                       onCancel={() => this.setState({team2playerAdding: false})}
                       visible={this.state.team2playerAdding}>
                    <UniversalForm schema={playerAddSchema}
                                   width={"300px"}
                                   readonly={this.props.readonly}
                                   labelsSpan={12}
                                   wrappersSpan={12}
                                   actions={playerAddActions(this, "team2")}/>
                </Modal>

                <div className={"match--form-container"}>
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

                <div className={"match--tabs"}>
                    <Tabs defaultActiveKey="1">
                        <Tabs.TabPane tab={"Team 1"} key="1">
                            <UniversalForm schema={teamSchema("team1")}
                                           readonly={this.props.readonly}
                                           observer={this.team1FormObserver}
                                           id={this.team1FormId}
                                           labelsSpan={12}
                                           wrappersSpan={12}
                                           actions={this.teamFormActions}/>
                            <Button onClick={() => this.handleAdd("team1")} className={"match--add-button"}>
                                Add
                            </Button>
                            <UniversalTable key={"1"}
                                            actions={teamActions(this, "team1")}
                                            scroll={"65vh"}
                                            readonly={this.props.readonly}
                                            expandable={this.state.team1 && this.state.team1.length === 5 ? {
                                                columnWidth: "50px",
                                                expandedRowRender: (record) =>
                                                    <div style={{margin: 0}}>
                                                        <Tabs defaultActiveKey={record.key + "1"}>
                                                            <Tabs.TabPane tab="Talents" key={record.key + "1"}>
                                                                <Button onClick={() => this.setState(
                                                                    {
                                                                        talentsAdding: true,
                                                                        teamTalentsAdding: "team1",
                                                                        playerTalentsAdding: record.key
                                                                    })}
                                                                        className={"match--add-button"}>
                                                                    Edit
                                                                </Button>
                                                                <UniversalTable readonly
                                                                                columns={talentsColumns}
                                                                                data={record.talents
                                                                                    ? Object.values(record.talents)
                                                                                    : null}/>
                                                            </Tabs.TabPane>
                                                            <Tabs.TabPane tab="Statistic" key={record.key + "2"}>
                                                                <Button onClick={() => this.setState(
                                                                    {
                                                                        statisticsPlayerKey: record.key,
                                                                        statisticsAdding: true,
                                                                        statisticsTeamAdding: "team1"
                                                                    })}
                                                                        className={"match--add-button"}>
                                                                    Edit
                                                                </Button>
                                                                <UniversalForm schema={statisticsDemoSchema(record)}
                                                                               readonly
                                                                               data={record.stats}
                                                                               cols={3}
                                                                               labelsSpan={12}
                                                                               wrappersSpan={12}/>
                                                            </Tabs.TabPane>
                                                        </Tabs>
                                                    </div>,
                                            } : null}
                                            data={this.state.team1}
                                            columns={teamsColumns}/>
                        </Tabs.TabPane>
                        <Tabs.TabPane tab={"Team 2"} key="2">
                            <UniversalForm schema={teamSchema("team2")}
                                           readonly={this.props.readonly}
                                           observer={this.team2FormObserver}
                                           id={this.team2FormId}
                                           labelsSpan={12}
                                           wrappersSpan={12}
                                           actions={this.teamFormActions}/>
                            <Button onClick={() => this.handleAdd("team2")} className={"match--add-button"}>
                                Add
                            </Button>
                            <UniversalTable key={"2"}
                                            actions={teamActions(this, "team2")}
                                            scroll={"65vh"}
                                            readonly={this.props.readonly}
                                            expandable={this.state.team2 && this.state.team2.length === 5 ? {
                                                columnWidth: "50px",
                                                expandedRowRender: (record) =>
                                                    <div style={{margin: 0}} key={record}>
                                                        <Tabs defaultActiveKey={record.key + "1"}>
                                                            <Tabs.TabPane tab="Talents" key={record.key + "1"}>
                                                                <Button onClick={() => this.setState(
                                                                    {
                                                                        talentsAdding: true,
                                                                        teamTalentsAdding: "team2",
                                                                        playerTalentsAdding: record.key
                                                                    })}
                                                                        className={"match--add-button"}>
                                                                    Edit
                                                                </Button>
                                                                <UniversalTable readonly
                                                                                columns={talentsColumns}
                                                                                data={record.talents
                                                                                    ? Object.values(record.talents)
                                                                                    : null}/>
                                                            </Tabs.TabPane>
                                                            <Tabs.TabPane tab="Statistic" key={record.key + "2"}>
                                                                <Button onClick={() => this.setState(
                                                                    {
                                                                        statisticsPlayerKey: record.key,
                                                                        statisticsAdding: true,
                                                                        statisticsTeamAdding: "team2"
                                                                    })}
                                                                        className={"match--add-button"}>
                                                                    Edit
                                                                </Button>
                                                                <UniversalForm schema={statisticsDemoSchema(record)}
                                                                               readonly
                                                                               data={record.stats}
                                                                               cols={3}
                                                                               labelsSpan={12}
                                                                               wrappersSpan={12}/>
                                                            </Tabs.TabPane>
                                                        </Tabs>
                                                    </div>,
                                            } : null}
                                            data={this.state.team2}
                                            columns={teamsColumns}/>
                        </Tabs.TabPane>
                    </Tabs>
                </div>

                <div className={"match--footer-buttons"}>
                    {!this.props.readonly
                        ? <Button onClick={this.submitHandler} className={"match--button"} htmlType={"submit"}>
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
