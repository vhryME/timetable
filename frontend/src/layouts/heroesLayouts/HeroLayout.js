import React from "react";
import {withRouter} from "react-router-dom";

import {Tabs, Modal, Button, message} from 'antd';

import "./heroStyles.css";

import hash from "object-hash";

import schema from "./heroFormConfig";
import talentSchema from "./talentFormConfig";
import skillSchema from "./skillFormConfig";

import {UniversalForm} from "../../components/common/universalForm";
import {UniversalTable} from "../../components/common/universalTable";
import UniversalAvatar from "../../components/common/universalAvatar/UniversalAvatar";

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

    newTalentIcon: null,
    newSkillIcon: null,
    newHeroIcon: null,
  };

  mainFormId = "heroFormId";

  mainFormActions = {
    onSubmit: (values) => {
      let tableInvalid = false;
      if (this.state.talents.length === 0) {
        message.error("Talents required!");
        tableInvalid = true;
      }
      if (this.state.skills.length < 5) {
        message.error("Must be at least 5 skills!");
        tableInvalid = true;
      }
      if (!tableInvalid) {
        values.skills = this.state.skills;
        values.talents = this.state.talents;
        values.icon = this.state.newHeroIcon;
        values.id = this.props.match.params.id ? this.props.match.params.id : hash(values);
        if (this.props.match.params.id) {
          this.props.editHero(values, values.id);
        } else {
          this.props.newHero(values);
        }
        this.props.getAllHeroes();
        console.log(values, ` hero ${this.props.match.params.id ? "edited" : "created"}!`);
        this.props.history.push("/heroes");
      }
    },
    onError: (e) => {
      console.log("onError: ", e);
    },
  };

  skillFormActions = {
    onSubmit: (values) => {
      let {skills} = this.state;
      if (this.state.skillAdding) {
        values.icon = this.state.newSkillIcon;
        values.key = hash(values);
        skills.push(values);
        this.setState({
          skillAdding: false,
          currentSkill: null,
          newSkillIcon: null,
          skills
        });
      } else if (this.state.skillEditing) {
        values.icon = this.state.newSkillIcon ? this.state.newSkillIcon : this.state.currentSkill.icon;
        values.key = this.state.currentSkill.key;
        this.setState({
          skillEditing: false,
          currentSkill: null,
          newSkillIcon: null,
          skills: skills.map(item => {
            if (item.key === values.key) {
              return {...item, ...values}
            }
            return item;
          })
        });
      }
    },

    onCancel: () => {
      this.setState({skillAdding: false, skillEditing: false, currentSkill: null, currentSkillIcon: null,});
    },

    onError: (e) => {
      console.log("onError: ", e);
    },
  };

  talentFormActions = {
    onSubmit: (values) => {
      let {talents} = this.state;
      if (this.state.talentAdding) {
        values.icon = this.state.newTalentIcon;
        values.key = hash(values);
        talents.push(values);
        this.setState({
          talentAdding: false,
          currentTalent: null,
          newTalentIcon: null,
          talents
        });
      } else if (this.state.talentEditing) {
        values.icon = this.state.newTalentIcon ? this.state.newTalentIcon : this.state.currentTalent.icon;
        values.key = this.state.currentTalent.key;
        this.setState({
          talentEditing: false,
          currentTalent: null,
          newTalentIcon: null,
          talents: talents.map(item => {
            if (item.key === values.key) {
              return {...item, ...values}
            }
            return item;
          })
        });
      }
    },

    onCancel: () => {
      this.setState({talentAdding: false, talentEditing: false, currentTalent: null, currentTalentIcon: null,});
    },

    onError: (e) => {
      console.log("onError: ", e);
    },
  };

  skillsTableActions = {
    onAdd: () => {
      this.setState({skillAdding: true});
    },
    onEdit: (values) => {
      this.setState({skillEditing: true, currentSkill: values})
    },
    onDelete: (value) => {
      this.setState({skills: this.state.skills.filter(skill => skill !== value)})
    }
  };

  talentsTableActions = {
    onAdd: () => {
      this.setState({talentAdding: true});
    },
    onEdit: (values) => {
      this.setState({talentEditing: true, currentTalent: values})
    },
    onDelete: (value) => {
      this.setState({talents: this.state.talents.filter(talent => talent !== value)})
    }
  };

  skillsColumns = {
    icon: {
      label: "Icon",
      customRender: (_, record) => <UniversalAvatar disabled src={record.icon} size={30}/>,
    },
    name: {
      label: "Name",
      customRender: this.props.readonly
        ? (text, record) => <a onClick={() => this.setState({currentSkill: record, skillEditing: true})}>{text}</a>
        : undefined,
    },
    description: "Description",
    cooldown: "Cooldown",
    cost: "Cost"
  };

  talentsColumns = {
    icon: {
      label: "Icon",
      customRender: (_, record) => <UniversalAvatar disabled src={record.icon} size={30}/>,
    },
    name: {
      label: "Name",
      customRender: this.props.readonly
        ? (text, record) => <a onClick={() => this.setState({currentTalent: record, talentEditing: true})}>{text}</a>
        : undefined,
    },
    description: "Description",
    requiredLvl: "Required LVL",
    type: "Type",
    cooldown: "Cooldown",
    cost: "Cost",
    ability: "Ability",
  };

  componentDidMount() {
    if (this.props.match.params.id) {
      this.props.getOneHero(this.props.match.params.id)
    }
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    const {current} = this.props.heroes;
    if (prevProps.heroes.current !== current) {
      this.setState({skills: current.data.skills, talents: current.data.talents, newHeroIcon: current.data.icon});
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
                             actions={this.skillFormActions}/>
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
              <UniversalForm schema={talentSchema}
                             readonly={this.props.readonly}
                             data={this.state.currentTalent ? this.state.currentTalent : undefined}
                             labelsSpan={12}
                             wrappersSpan={12}
                             actions={this.talentFormActions}/>
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
              ? <UniversalForm schema={schema}
                               data={this.props.heroes.current.data}
                               readonly={this.props.readonly}
                               id={this.mainFormId}
                               labelsSpan={12}
                               wrappersSpan={12}
                               actions={this.mainFormActions}/>
              : <UniversalForm schema={schema}
                               id={this.mainFormId}
                               labelsSpan={12}
                               wrappersSpan={12}
                               actions={this.mainFormActions}/>}
          </div>
        </div>

        <div className={"tabs"}>
          <Tabs defaultActiveKey="1">
            <Tabs.TabPane tab="Skills" key="1">
              <UniversalTable key={1}
                              readonly={this.props.readonly}
                              actions={this.skillsTableActions}
                              data={this.state.skills}
                              columns={this.skillsColumns}/>
            </Tabs.TabPane>
            <Tabs.TabPane tab="Talents" key="2">
              <UniversalTable key={2}
                              readonly={this.props.readonly}
                              actions={this.talentsTableActions}
                              data={this.state.talents}
                              columns={this.talentsColumns}/>
            </Tabs.TabPane>
          </Tabs>
        </div>

        <div className={"footer-buttons"}>
          {!this.props.readonly
            ? <Button form={this.mainFormId} className={"button"} htmlType={"submit"}>
                Save
              </Button>
            : undefined
          }
          <Button className={"button"} onClick={() => this.props.history.push("/heroes")}>
            Cancel
          </Button>
        </div>

      </div>
    )
  }
}

export default withRouter(HeroLayout);
