import React from "react";
import {withRouter} from "react-router-dom";

import {Tabs, Modal, Button} from 'antd';

import "./heroStyles.css";

import {schema as mainSchema, actions as mainActions} from "./config/oneHero/heroFormConfig";
import {schemaGen as talentSchema, actions as talentActions} from "./config/oneHero/talentFormConfig";
import {schema as skillSchema, actions as skillActions} from "./config/oneHero/skillFormConfig";
import {actions as talentsTableActions, columns as talentsColumns} from "./config/oneHero/talentsTableConfig";
import {actions as skillsTableActions, columns as skillsColumns} from "./config/oneHero/skillsTableConfig";

import {UniversalForm} from "../../components/common/universalForm";
import {UniversalTable} from "../../components/common/universalTable";
import UniversalAvatar from "../../components/common/universalAvatar/UniversalAvatar";

import {LeftOutlined, SaveOutlined} from "@ant-design/icons";

class HeroLayout extends React.Component {
  state = {
    skillAdding: false,
    skillEditing: false,

    talentAdding: false,
    talentEditing: false,

    currentTalent: null,
    currentSkill: null,

    talents: [],
    skills: [],

    newTalentIcon: "",
    newSkillIcon: "",
    newHeroIcon: "",
  };

  mainFormId = "heroFormId";

  componentDidMount() {
    if (this.props.match.params.id) {
      this.props.getOneHero(this.props.match.params.id)
    }
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    const {current} = this.props.heroes;

    if (prevProps.heroes.current !== current && current.loading !== true) {
      this.setState({skills: current.data.spells, talents: current.data.talents, newHeroIcon: current.data.icon});
    }
  }

  render() {
    return (
      <div className={"main-container"}>

        <Modal title={"Skill"}
               destroyOnClose
               footer={null}
               closable={!!this.props.readonly}
               onCancel={() => this.setState({skillEditing: false})}
               visible={this.state.skillAdding || this.state.skillEditing}>
          <div className={"form-container"}>
            <div className={"icon-upload"}>
              <UniversalAvatar onChange={(value) => this.setState({newSkillIcon: value})}
                               disabled={this.props.readonly}
                               src={this.state.currentSkill ? this.state.currentSkill.icon : undefined}
                               size={104}/>
            </div>
            <div className={"form"}>
              <UniversalForm schema={skillSchema}
                             readonly={this.props.readonly}
                             data={this.state.currentSkill ? this.state.currentSkill : undefined}
                             labelsSpan={12}
                             wrappersSpan={12}
                             actions={skillActions(this)}/>
            </div>
          </div>
        </Modal>

        <Modal title={"Talent"}
               destroyOnClose
               footer={null}
               closable={!!this.props.readonly}
               onCancel={() => this.setState({talentEditing: false})}
               visible={this.state.talentAdding || this.state.talentEditing}>
          <div className={"form-container"}>
            <div className={"icon-upload"}>
              <UniversalAvatar onChange={(value) => this.setState({newTalentIcon: value})}
                               disabled={this.props.readonly}
                               src={this.state.currentTalent ? this.state.currentTalent.icon : undefined}
                               size={104}/>
            </div>
            <div className={"form"}>
              <UniversalForm schema={talentSchema(this)}
                             readonly={this.props.readonly}
                             data={this.state.currentTalent ? this.state.currentTalent : undefined}
                             labelsSpan={12}
                             wrappersSpan={12}
                             actions={talentActions(this)}/>
            </div>
          </div>
        </Modal>

        <div className={"form-container"}>
          <div className={"icon-upload"}>
            <UniversalAvatar onChange={(value) => this.setState({newHeroIcon: value})}
                             disabled={this.props.readonly}
                             src={this.state.newHeroIcon}
                             size={104}/>
          </div>
          <div className={"form"}>
            {this.props.match.params.id
              ? <UniversalForm schema={mainSchema}
                               data={this.props.heroes.current.data}
                               readonly={this.props.readonly}
                               id={this.mainFormId}
                               labelsSpan={12}
                               wrappersSpan={12}
                               actions={mainActions(this)}/>
              : <UniversalForm schema={mainSchema}
                               id={this.mainFormId}
                               labelsSpan={12}
                               wrappersSpan={12}
                               actions={mainActions(this)}/>}
          </div>
        </div>

        <div className={"tabs"}>
          <Tabs defaultActiveKey="1">
            <Tabs.TabPane tab="Skills" key="1">
              <UniversalTable key={1}
                              readonly={this.props.readonly}
                              actions={skillsTableActions(this)}
                              data={this.state.skills}
                              columns={skillsColumns(this)}/>
            </Tabs.TabPane>
            <Tabs.TabPane tab="Talents" key="2">
              <UniversalTable key={2}
                              readonly={this.props.readonly}
                              actions={talentsTableActions(this)}
                              data={this.state.talents}
                              columns={talentsColumns(this)}/>
            </Tabs.TabPane>
          </Tabs>
        </div>

        {!this.props.readonly
          ? <div className={"footer-buttons"}>
            <Button shape={"circle"} className={"button"} onClick={() => this.props.history.push("/heroes")}>
              <LeftOutlined/>
            </Button>
            <Button shape={"circle"} type={"primary"} form={this.mainFormId} className={"button"} htmlType={"submit"}>
              <SaveOutlined/>
            </Button>
          </div>
          : undefined
        }

      </div>
    )
  }
}

export default withRouter(HeroLayout);
