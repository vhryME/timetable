import UniversalAvatar from "../../../../components/common/universalAvatar/UniversalAvatar";
import React from "react";

export const actions = (context) => {
  return {
    onAdd: () => {
      context.setState({skillAdding: true});
    },

    onEdit: (values) => {
      context.setState({skillEditing: true, currentSkill: values})
    },

    onDelete: (value) => {
      context.setState({skills: context.state.skills.filter(skill => skill !== value)})
    }
  };
};

export const columns = (context) => {
  return {
    name: {
      label: "Name",
      customRender: context.props.readonly
        ? (text, record) =>
          <div style={{display: "flex", flexDirection:"row", alignItems: "center"}}>
            <UniversalAvatar disabled src={record.icon} size={30} style={{marginRight: "5px"}}/>
            <a onClick={() => context.setState({currentSkill: record, skillEditing: true})}>
              {text}
            </a>
          </div>
        : (text, record) =>
          <div style={{display: "flex", flexDirection:"row", alignItems: "center"}}>
            <UniversalAvatar disabled src={record.icon} size={30} style={{marginRight: "5px"}}/>
            {text}
          </div>,
    },
    description: {
      type: "longString",
      label: "Description",
    },
    cooldown: "Cooldown",
    manaCost: "Cost",
  };
};