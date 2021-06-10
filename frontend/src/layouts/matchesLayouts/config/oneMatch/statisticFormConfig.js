import {Validator} from "../../../../components/common/universalForm";

export const statistic = () => {
    return {
        name: "statistic",

        fields: {
            level: {
                type: "number",
                label: "Level",
                rules: [Validator.required(), Validator.moreThan(0, "Must be more than 0")],
            },
            kills: {
                type: "number",
                label: "Kills",
                rules: [Validator.required(), Validator.moreThan(0, "Must be more than 0")],
            },
            assists: {
                type: "number",
                label: "Assist",
                rules: [Validator.required(), Validator.moreThan(0, "Must be more than 0")],
            },
            killStreaks: {
                type: "number",
                label: "Kill streaks",
                rules: [Validator.required(), Validator.moreThan(0, "Must be more than 0")],
            },
            deaths: {
                type: "number",
                label: "Deaths",
                rules: [Validator.required(), Validator.moreThan(0, "Must be more than 0")],
            },
            damageToEnemies: {
                type: "number",
                label: "Damage to enemies",
                rules: [Validator.required(), Validator.moreThan(0, "Must be more than 0")],
            },
            damageToNPC: {
                type: "number",
                label: "Damage to NPC",
                rules: [Validator.required(), Validator.moreThan(0, "Must be more than 0")],
            },
            healToTeammate: {
                type: "number",
                label: "Heal to teammate",
                rules: [Validator.required(), Validator.moreThan(0, "Must be more than 0")],
            },
            heaToYourself: {
                type: "number",
                label: "Heal top yourself",
                rules: [Validator.required(), Validator.moreThan(0, "Must be more than 0")],
            },
            damageToYourself: {
                type: "number",
                label: "Damage to yourself",
                rules: [Validator.required(), Validator.moreThan(0, "Must be more than 0")],
            },
            experience: {
                type: "number",
                label: "Experience",
                rules: [Validator.required(), Validator.moreThan(0, "Must be more than 0")],
            },
            timeInRevive: {
                type: "number",
                label: "Time in revive",
                rules: [Validator.required(), Validator.moreThan(0, "Must be more than 0")],
            },
            takeCamps: {
                type: "number",
                label: "Take camps",
                rules: [Validator.required(), Validator.moreThan(0, "Must be more than 0")],
            }
        }
    }
};


export const statisticDemo = () => {
    return {
        name: "statistic",

        fields: {
            level: {
                type: "string",
                label: "Level",
                initial: "unknown",
            },
            kills: {
                type: "string",
                label: "Kills",
                initial: "unknown",
            },
            assists: {
                type: "string",
                label: "Assist",
                initial: "unknown",
            },
            killStreaks: {
                type: "string",
                label: "Kill streaks",
                initial: "unknown",
            },
            deaths: {
                type: "string",
                label: "Deaths",
                initial: "unknown",
            },
            damageToEnemies: {
                type: "string",
                label: "Damage to enemies",
                initial: "unknown",
            },
            damageToNPC: {
                type: "string",
                label: "Damage to NPC",
                initial: "unknown",
            },
            healToTeammate: {
                type: "string",
                label: "Heal to teammate",
                initial: "unknown",
            },
            heaToYourself: {
                type: "string",
                label: "Heal top yourself",
                initial: "unknown",
            },
            damageToYourself: {
                type: "string",
                label: "Damage to yourself",
                initial: "unknown",
            },
            experience: {
                type: "string",
                label: "Experience",
                initial: "unknown",
            },
            timeInRevive: {
                type: "string",
                label: "Time in revive",
                initial: "unknown",
            },
            takeCamps: {
                type: "string",
                label: "Take camps",
                initial: "unknown",
            },
        }
    }
};

export const actions = (context, playerKey) => {
    return {
        onSubmit: (values) => {
            let team = context.state[context.state.statisticsTeamAdding];
            let newTeam = team.map((item) => {
                if (item.key === playerKey) {
                    return {...item, stats: {...values}}
                }
                return item;
            })
            context.setState({
                statisticsAdding: false,
                [context.state.statisticsTeamAdding]: newTeam
            });
        }
    }
}
