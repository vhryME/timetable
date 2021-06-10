import React from "react";
import UniversalAvatar from "../../../../components/common/universalAvatar/UniversalAvatar";

export const actions = (context) => {
  return {
    onAdd: () => {
      context.setState({talentAdding: true});
    },

    onEdit: (values) => {
      context.setState({talentEditing: true, currentTalent: values})
    },

    onDelete: (value) => {
      context.setState({talents: context.state.talents.filter(talent => talent !== value)})
    }
  };
}

export const columns = (context) => {
  return {
    name: {
      label: "Name",
      customRender: context.props.readonly
        ? (text, record) =>
          <div style={{display: "flex", flexDirection:"row", alignItems: "center"}}>
            <UniversalAvatar disabled src={record.icon} size={30} style={{marginRight: "5px"}}/>
            <a onClick={() => context.setState({currentTalent: record, talentEditing: true})}>
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
    levelOfAccess: "Required LVL",
    type: "Type",
  };
}