import React from "react";
import { Button } from "antd";
import { PlusOutlined } from "@ant-design/icons";

export default {
  onAdd: (context) => {
    return (
      <Button
        key={"addButton"}
        type="primary"
        style={{ marginRight: 8 }}
        onClick={() => context.setState({ adding: true })}
      >
        <PlusOutlined />
      </Button>
    );
  },
  onDelete: (context, record, handler) => {
    return (
      <a
        key={"clearButton"}
        style={{ marginRight: 8, color: "red" }}
        onClick={() => {
          handler(record);
          context.setState({
            data: context.state.data.filter((item) => item !== record),
          });
        }}
      >
        Delete
      </a>
    );
  },
  onEdit: (context, record) => {
    return (
      <a
        key={"editButton"}
        style={{ marginRight: 8 }}
        onClick={() => context.setState({ editing: true, editingData: record })}
      >
        Edit
      </a>
    );
  },
};
