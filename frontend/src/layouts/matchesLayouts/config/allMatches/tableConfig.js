import React from "react";

export const actions = (context) => {
  return {
    onAdd: () => {
      context.props.history.push("/matches/new");
    },
    onEdit: (value) => {
      context.props.history.push("/matches/edit/" + value.id);
    },
    onDelete: (value) => {
      context.props.deleteMatch(value.id);
      context.props.getAllMatches();
      console.log(value, " deleted!");
    }
  };
};

export const columns = {
  typeOfMatch: {
    label: "Type of match",
  },
  date: {
    label: "Date",
    type: "date",
  },
  duration: {
    type: "time",
    label: "Duration"
  },
  region: {
    label: "Region"
  },
  maps: {
    label: "Maps"
  },
  winner: {
    type: "string",
    label: "Winner"
  }
};