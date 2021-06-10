import {Validator} from "../../../../components/common/universalForm";
import {message} from "antd";
import { v4 as uuidv4 } from 'uuid';

export const schema = {
    name: "playerInMatch",

    fields: {
        player: {
            type: "enum",
            label: "Player",
            rules: [Validator.required()],
            options: ["Player 1", "Player 2", "Player 3", "Player 4", "Player 5",
                "Player 6", "Player 7", "Player 8", "Player 9", "Player 10"]
        },

        hero: {
            type: "enum",
            label: "Hero",
            rules: [Validator.required()],
            options: ["Hero 1", "Hero 2", "Hero 3", "Hero 4", "Hero 5",
                "Hero 6", "Hero 7", "Hero 8", "Hero 9", "Hero 10"]
        }
    },
};

export const actions = (context, param) => {
    return {
        onSubmit: (values) => {
            if (context.state[param].length >= 5) {
                context.setState({
                    [param + "playerAdding"]: false
                });
                message.error("Can't be more than 5 players in one team!");
                return;
            }
            context.setState({
                [param]: [...context.state[param], {...values, key: uuidv4()}],
                [param + "playerAdding"]: false,
            });
        },

        onCancel: () => {
            context.setState({[param + "playerAdding"]: false});
        },
    }
}
