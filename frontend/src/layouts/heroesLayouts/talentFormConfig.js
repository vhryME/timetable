import {Validator} from "../../components/common/universalForm";

export default {
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

    requiredLvl: {
      type: "number",
      label: "Required LVL",
      rules: [Validator.required(), Validator.lessThan(21), Validator.moreThan(0)],
    },

    type: {
      type: "enum",
      label: "Type",
      options: ["Active", "Passive"]
    },

    ability: {
      dependsOnField: "type",
      dependsOnValue: "Passive",
      label: "Ability",
      type: "string",
    },

    cost: {
      dependsOnField: "type",
      dependsOnValue: "Active",
      label: "Cost",
      type: "number",
    },

    cooldown: {
      dependsOnField: "type",
      dependsOnValue: "Active",
      label: "Cooldown",
      type: "number",
    },
  },
};
