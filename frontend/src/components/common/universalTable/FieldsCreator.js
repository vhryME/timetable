import React from "react";
import {Input, Checkbox, Select, DatePicker} from "antd";
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
};
