import {Validator} from "../../components/common/universalForm";

export default {
  name: "hero",

  fields: {
    name: {
      type: "string",
      label: "Name",
      rules: [Validator.required()],
    },

    role: {
      type: "enum",
      label: "Role",
      rules: [Validator.required()],
      options: ["Specialist", "Assassin", "Warrior", "Support", "Multiclass", "Unknown"]
    },

    melee: {
      type: "checkbox",
      label: "Is melee?",
    },

    creationDate: {
      type: "date",
      label: "Creation date",
      rules: [Validator.required()]
    },
  },
};
