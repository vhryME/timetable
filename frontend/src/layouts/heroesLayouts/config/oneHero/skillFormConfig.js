import {Validator} from "../../../../components/common/universalForm";
import { v4 as uuidv4 } from 'uuid';

export const schema = {
  name: "skill",

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

    cooldown: {
      type: "number",
      label: "Cooldown",
    },

    manaCost: {
      type: "number",
      label: "Mana cost",
    },
  },
};

export const actions = (context) => {
  return {
    onSubmit: (values) => {
      let {skills} = context.state;

      if (context.state.skillAdding) {
        values.icon = context.state.newSkillIcon;
        values.key = uuidv4();
        values.uuid = uuidv4();
        skills.push(values);
        context.setState({
          skillAdding: false,
          currentSkill: null,
          newSkillIcon: "",
          skills
        });
      } else if (context.state.skillEditing) {
        values.icon = context.state.newSkillIcon ?? context.state.currentSkill.icon;
        values.key = context.state.currentSkill.key;
        values.uuid = context.state.currentSkill.uuid;
        context.setState({
          skillEditing: false,
          currentSkill: null,
          newSkillIcon: "",
          skills: skills.map(item => {
            if (item.key === values.key) {
              return {...item, ...values}
            }
            return item;
          })
        });
      }
      console.log(values);
    },

    onCancel: () => {
      context.setState({skillAdding: false, skillEditing: false, currentSkill: null, currentSkillIcon: "",});
    },
  };
}