import {Validator} from "../../../../components/common/universalForm";
import {v4 as uuidv4} from 'uuid';
import "../../heroStyles.css";
import React from "react";
import UniversalAvatar from "../../../../components/common/universalAvatar/UniversalAvatar";

export const schemaGen = (context) => {
  return {
    name: "talent",

    fields: {
      name: {
        type: "string",
        label: "Name",
        rules: [Validator.required()],
      },

      description: {
        type: "string",
        label: "Description",
      },

      levelOfAccess: {
        type: "number",
        label: "Required LVL",
        rules: [Validator.required(), Validator.lessThan(21), Validator.moreThan(0)],
      },

      type: {
        type: "enum",
        label: "Type",
        options: ["active", "passive"],
        rules: [Validator.required()],
      },

      spell: {
        dependsOnField: "type",
        dependsOnValue: "passive",
        label: "Ability",
        type: "enum",
        options: context.state.skills.reduce((acc, curr) => {
          return {
            ...acc,
            [curr.uuid]:
              <div className={"option-main"}>
                <div className={"option-text"}>
                  {curr.name}
                </div>
                <UniversalAvatar src={curr.icon} disabled size={24}/>
              </div>
          }
        }, {}),
        rules: [Validator.required()],
      },

      cost: {
        dependsOnField: "type",
        dependsOnValue: "active",
        label: "Cost",
        type: "number",
        rules: [Validator.required()],
      },

      timeOfRecovery: {
        dependsOnField: "type",
        dependsOnValue: "active",
        label: "Cooldown",
        type: "number",
        rules: [Validator.required()],
      },
    },
  }
};

export const actions = (context) => {
  return {
    onSubmit: (values) => {
      let {talents} = context.state;

      if (context.state.talentAdding) {
        values.icon = context.state.newTalentIcon;
        values.key = uuidv4();
        talents.push(values);
        context.setState({
          talentAdding: false,
          currentTalent: null,
          newTalentIcon: "",
          talents
        });
      } else if (context.state.talentEditing) {
        values.icon = context.state.newTalentIcon ?? context.state.currentTalent.icon;
        values.key = context.state.currentTalent.key;
        context.setState({
          talentEditing: false,
          currentTalent: null,
          newTalentIcon: "",
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
      context.setState({talentAdding: false, talentEditing: false, currentTalent: null, currentTalentIcon: "",});
    },
  };
};
