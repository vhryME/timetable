export default {
  name: "heroesFilter",

  fields: {
    typeOfMatch: {
      type: "string",
      label: "Type of Match",
    },

    date: {
      type: "date",
      label: "Date",
    },

    duration: {
      type: "time",
      label: "Duration",
    },

    region: {
      type: "string",
      label: "Region",
    },

    maps: {
      type: "string",
      label: "Maps"
    }
  },
};
