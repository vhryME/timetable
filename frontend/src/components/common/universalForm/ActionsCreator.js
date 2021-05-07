import React from "react";
import {Button} from "antd";
import {PlusOutlined} from "@ant-design/icons";

export default {
  onError: () => {},
  onSubmit: () => {
    return (
      <Button
        key={"submitButton"}
        type="primary"
        style={{marginRight: 8}}
        htmlType="submit"
      >
        Submit
      </Button>
    );
  },
  onCancel: (ref, handler) => {
    return (
      <Button
        key={"cancelButton"}
        style={{marginRight: 8}}
        onClick={() => handler(ref.current)}
      >
        Cancel
      </Button>)
  },
  onAdd: (ref, handler) => {
    return (
      <Button
        key={"addButton"}
        type="primary"
        style={{marginRight: 8}}
        onClick={() => handler(ref.current)}
      >
        <PlusOutlined/>
      </Button>
    );
  },
  onClear: (ref, handler) => {
    return (
      <Button
        key={"clearButton"}
        style={{marginRight: 8}}
        onClick={() => handler(ref.current)}
      >
        Clear
      </Button>
    );
  },
};
