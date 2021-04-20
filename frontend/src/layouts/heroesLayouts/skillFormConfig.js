import {Validator} from "../../components/common/universalForm";

export default {
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

    cost: {
      type: "number",
      label: "Cost",
    },
  },
};
