import {Validator} from "../../../../components/common/universalForm";

export const schema = (name) => {
  return {
    name: name,
    fields: {
      levelOfTeam: {
        type: "number",
        label: "Level of team",
        rules: [Validator.required(), Validator.moreThan(0, "Experience must be > 0")],
      },

      experienceOfTeam: {
        type: "number",
        label: "Experience of Team",
        rules: [Validator.required(), Validator.moreThan(0, "Experience must be > 0")],
      }
    },
  }
};
