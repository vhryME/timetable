import {Validator} from "../../components/common/universalForm";

export default {
  name: "map",

  fields: {
    name: {
      type: "string",
      label: "Name",
      rules: [Validator.required()],
    },
  },
};
