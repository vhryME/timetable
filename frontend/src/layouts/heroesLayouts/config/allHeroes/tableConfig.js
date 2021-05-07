import React from "react";
import UniversalAvatar from "../../../../components/common/universalAvatar/UniversalAvatar";

export const actions = (context) => {
  return {
    onAdd: () => {
      context.props.history.push("/heroes/new");
    },
    onEdit: (value) => {
      context.props.history.push("/heroes/edit/" + value.id);
    },
    onDelete: (value) => {
      context.props.deleteHero(value.id);
      context.props.getAllHeroes();
      console.log(value, " deleted!");
    }
  };
};

export const columns = (context) => {
  return {
    name: {
      label: "Name",
      customRender: (text, record) =>
        <div style={{display: "flex", flexDirection: "row", alignItems: "center"}}>
          <UniversalAvatar disabled src={record.icon} size={30} style={{marginRight: "5px"}}/>
          <a onClick={() => context.props.history.push("/heroes/view/" + record.id)}>{text}</a>
        </div>
    },
    roleId: {
      label: "Role",
      type: "dict",
      dictName: "role",
    },
    dateOfCreation: {
      label: "Creation date",
      type: "date",
    },
    isMelee: {
      label: "Is melee?",
      type: "boolean"
    },
  };
};