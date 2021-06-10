import React from "react";
import {Input, Checkbox, Select, DatePicker, TimePicker, Tooltip} from "antd";
import {CheckOutlined, CloseOutlined} from "@ant-design/icons";
import moment from "moment";

import "./styles.css";

export default {
    string: () => (text) => {
        return (text);
    },

    longString: () => (text) => {
        return <Tooltip align={{points: ['bl', 'tl']}} title={text}>
            {text}
            <div style={{float: 'left', maxWidth: '100%'}}/>
        </Tooltip>;
    },

    date: () => (text) => {
        return (
            <DatePicker defaultValue={moment(text)} disabled/>
        )
    },

    time: () => (text) => {
        return (
            <TimePicker defaultValue={moment(text)} disabled/>
        )
    },

    boolean: () => (text) => {
        switch (String(text)) {
            case "true":
                return <CheckOutlined/>

            case "false":
                return <CloseOutlined/>

            default:
                return;
        }
    },

    number: () => (text) => {
        return (text);
    },

    dict: (context, config) => (text) => {
        if (context.state.dictionaries) {
            return (context.state.dictionaries[config.dictName][text]);
        }
    }
};
