export default {
  name: "heroesFilter",

  fields: {
    name: {
      type: "string",
      label: "Name",
    },

    role: {
      type: "string",
      label: "Role",
    },

    creationDate: {
      type: "string",
      label: "Creation date",
    },

    melee: {
      type: "checkbox",
      label: "Is melee?",
    },
  },
};
