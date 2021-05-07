import {Validator} from "../../components/common/universalForm";

export const team1 = {
  name: "team1",

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
};

export const team2 = {
  name: "team2",

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
};
