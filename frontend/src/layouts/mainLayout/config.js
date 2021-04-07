import { Validator } from "../../components/universalForm";

export default {
  name: "registration",

  fields: {
    firstName: {
      type: "string",
      label: "First name",
      initial: "John",
      rules: [Validator.required(), Validator.longerThan(7)],
    },

    lastName: {
      type: "string",
      label: "Last name",
      rules: [
        Validator.required("Last name is required"),
        Validator.shorterThan(10),
      ],
    },

    age: {
      type: "number",
      label: "Age",
      initial: "36",
      rules: [
        Validator.notEqual(18),
        Validator.moreThan(5),
        Validator.lessThan(99),
      ],
    },

    telephone: {
      type: "string",
      label: "Telephone",
      rules: [
        Validator.required(),
        Validator.regex(
          "^[+]{0,1}[1-9]{1,4}[(]{0,1}[0-9]{1,4}[)]{0,1}[0-9]{6,8}$",
          "Wrong format! Must be: +XXX(XX)XXXXXXX!"
        ),
        Validator.phone(),
      ], /// In this example "regex" and "phone" validators doing literally same thing.
    },

    email: {
      type: "string",
      label: "Email",
      rules: [Validator.email("Wrong format! Be careful!")],
    },

    checkbox: {
      type: "checkbox",
      label: "What?",
      initial: true,
      rules: [Validator.required("WHAT!")],
    },

    team: {
      type: "enum",
      label: "Team",
      options: ["Na'Vi", "Unicorns of Love", "Cloud9", "Ninjas in Pijamas"],
      rules: [Validator.required("Choose his team!")],
    },
  },
};
