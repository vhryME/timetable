import React from "react";
import UniversalAvatar from "../../../../components/common/universalAvatar/UniversalAvatar";

export const columns = {
    player: {
        label: "Player",
        customRender: (_, record) => <div style={{display: "flex", flexDirection: "row", alignItems: "center"}}>
            <UniversalAvatar disabled src={record.icon} size={30} style={{marginRight: "5px"}}/>
            {record.player}
        </div>,
    },
    hero: {
        label: "Hero",
        customRender: (_, record) => <div style={{display: "flex", flexDirection: "row", alignItems: "center"}}>
            <UniversalAvatar disabled src={record.icon} size={30} style={{marginRight: "5px"}}/>
            {record.hero}
        </div>,
    }
};

export const actions = (context, param)  => {
    return {
        onDelete: (value) => {
            context.setState({[param]: context.state[param].filter(playerInMatch => playerInMatch !== value)})
        }
    }
};