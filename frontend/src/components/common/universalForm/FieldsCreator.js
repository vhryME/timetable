import React from "react";
import {Input, Checkbox, Select, DatePicker, TimePicker, Switch} from "antd";
import context from "react-redux/lib/components/Context";

const {Option} = Select;

export default {
  string: (context) => {
    const {readonly} = context.props;
    return (
      <Input
        disabled={readonly}
        bordered={!readonly}
        style={readonly ? {color: "black"} : undefined}
      />
    );
  },

  date: (context) => {
    const {readonly} = context.props;
    return (
      <DatePicker
        disabled={readonly}
        bordered={!readonly}
        style={readonly ? {color: "black"} : undefined}
      />
    )
  },

  time: (context) => {
    const {readonly} = context.props;
    return (
      <TimePicker
        disabled={readonly}
        bordered={!readonly}
        style={readonly ? {color: "black"} : undefined}
      />
    )
  },

  password: () => {
    return <Input.Password/>;
  },

  checkbox: (context) => {
    const {readonly} = context.props;
    return <Checkbox disabled={readonly} style={readonly ? {marginLeft: "10px"} : undefined} checked={false}/>;
  },

  switch: (context, {options}) => {
    const {readonly} = context.props;
    return <Switch
      unCheckedChildren={options[0]}
      checkedChildren={options[1]}/>
  },

  number: (context) => {
    const {readonly} = context.props;
    return (
      <Input
        type="number"
        disabled={readonly}
        bordered={!readonly}
        style={readonly ? {color: "black"} : undefined}
      />
    );
  },

  weekPicker: (context) => <DatePicker picker="week"/>,

  enum: (context, {options, onChange, disabled}) => {
    const {readonly} = context.props;

    return (
      <Select
        disabled={readonly || disabled || undefined}
        bordered={!readonly}
        onChange={onChange}
        style={readonly ? {color: "black"} : undefined}
      >
        {Array.isArray(options) && options.map((option) =>
          <Option key={option} value={option}>
            {option}
          </Option>
        )
        || typeof options === "object" && Object.keys(options).map((option) =>
          <Option key={option} value={option}>
            {options[option]}
          </Option>
        )
        }
      </Select>
    );
  },

  dict: (context, settings) => {
    const {readonly} = context.props;

    const dict = context.state.dictionaries[settings["dictName"]];

    if (dict) {
      return (
        <Select
          disabled={readonly}
          bordered={!readonly}
          style={readonly ? {color: "black"} : undefined}
        >
          {Object.keys(dict).map((id) => {
            return (
              <Option key={dict[id]} value={id}>
                {dict[id]}
              </Option>
            );
          })}
        </Select>
      );
    }
  }
}
;
