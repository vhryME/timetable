import {Validator} from "../../../../components/common/universalForm";
import {message} from "antd";
import moment from "moment";

export const schema = {
  name: "hero",

  fields: {
    name: {
      type: "string",
      label: "Name",
      rules: [Validator.required()],
    },

    roleId: {
      type: "dict",
      dictName: "role",
      label: "Role",
      rules: [Validator.required()],
    },

    isMelee: {
      type: "checkbox",
      label: "Is melee?",
      initial: false,
    },

    dateOfCreation: {
      type: "date",
      label: "Creation date",
      rules: [Validator.required()]
    },
  },
};

export const actions = (context) => {
  return {
    onSubmit: (values) => {
      let tableInvalid = false;
      if (context.state.talents.length === 0) {
        message.error("Talents required!");
        tableInvalid = true;
      }
      if (context.state.skills.length < 5) {
        message.error("Must be at least 5 skills!");
        tableInvalid = true;
      }
      if (!tableInvalid) {
        values.dateOfCreation = moment(values.dateOfCreation).format("YYYY-MM-DD");

        values.spells = context.state.skills;
        values.talents = context.state.talents;
        values.icon = context.state.newHeroIcon;

        if (context.props.match.params.id) {
          context.props.editHero(JSON.stringify(values), context.props.match.params.id);
        } else {
          context.props.newHero(JSON.stringify(values));
        }

        context.props.getAllHeroes();
        context.props.history.push("/heroes");
      }
      console.log(values);
    },
  }
}