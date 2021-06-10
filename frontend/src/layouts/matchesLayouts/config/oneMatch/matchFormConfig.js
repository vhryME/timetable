import {Validator} from "../../../../components/common/universalForm";

export default {
    name: "match",

    fields: {
        typeOfMatch: {
            type: "enum",
            label: "Type of Match",
            rules: [Validator.required()],
            options: ["QuickMatch", "UnrankedDraft", "HeroLeague", "TeamLeague", "Brawl", "Unknown"]
        },

        date: {
            type: "date",
            label: "Date",
            rules: [Validator.required()],
        },

        duration: {
            type: "time",
            label: "Duration",
            rules: [Validator.required()],
        },

        region: {
            type: "enum",
            label: "Region",
            rules: [Validator.required()],
            options: ["NA", "EU", "KR", "CN", "Unknown"]
        },

        winner: {
            type: "switch",
            label: "Winner",
            options: ["Team 1", "Team 2"]
        },
    },
};
