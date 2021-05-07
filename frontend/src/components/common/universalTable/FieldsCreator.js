import React from "react";
import {Input, Checkbox, Select, DatePicker, TimePicker} from "antd";
import {CheckOutlined, CloseOutlined} from "@ant-design/icons";
import moment from "moment";

import "./styles.css";

export default {
  string: () => (text) => {
    return (text);
  },

  longString: () => (text) => {
    return (text);
  },

  date: () => (text) => {
    return (
      <DatePicker
        defaultValue={moment(text)}
        disabled={true}
      />
    )
  },

  time: () => (text) => {
    return (
        <TimePicker
            defaultValue={moment(text)}
            disabled={true}
        />
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
