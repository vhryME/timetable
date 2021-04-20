import React from "react";
import {Input, Checkbox, Select, DatePicker} from "antd";

const { Option } = Select;

export default {
  string: (readonly) => {
    return (
      <Input
        disabled={readonly}
        bordered={!readonly}
        style={readonly ? { color: "black" } : undefined}
      />
    );
  },

  date: (readonly) => {
    return (
      <DatePicker
        disabled={readonly}
        bordered={!readonly}
        style={readonly ? { color: "black" } : undefined}
      />
    )
  },

  password: () => {
    return <Input.Password />;
  },

  checkbox: (readonly) => {
    return <Checkbox disabled={readonly} style={readonly ? {marginLeft: "10px"} : undefined} checked={false}/>;
  },

  number: (readonly) => {
    return (
      <Input
        type="number"
        disabled={readonly}
        bordered={!readonly}
        style={readonly ? { color: "black" } : undefined}
      />
    );
  },

  enum: (readonly, options) => {
    return (
      <Select
        disabled={readonly}
        bordered={!readonly}
        style={readonly ? { color: "black" } : undefined}
      >
        {options.map((option) => {
          return (
            <Option key={option} value={option}>
              {option}
            </Option>
          );
        })}
      </Select>
    );
  },
};
