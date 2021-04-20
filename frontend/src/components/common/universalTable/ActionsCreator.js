import React from "react";
import {Button, Popconfirm} from "antd";
import {PlusOutlined, EditOutlined, DeleteOutlined} from "@ant-design/icons";

export default {
  onAdd: (context) => {
    return (
      <Button
        key={"addButton"}
        style={{margin: 8}}
        onClick={() => {
          context.props.actions.onAdd();
        }}
      >
        Add
      </Button>
    );
  },
  onDelete: (context, record) => {
    return (
      <Popconfirm key={"clearButtonPop"}
                  title="Sure to delete?"
                  onConfirm={() => {
                    context.props.actions.onDelete(record);
                  }}>
        <a key={"clearButton"} style={{marginRight: 8, color: "red"}}>
          <DeleteOutlined style={{fontSize: "16px"}}/>
        </a>
      </Popconfirm>
    );
  },
  onEdit: (context, record) => {
    return (
      <a
        key={"editButton"}
        style={{marginRight: 8}}
        onClick={() => {
          context.props.actions.onEdit(record);
        }}
      >
        <EditOutlined style={{fontSize: "16px"}}/>
      </a>
    );
  },
};
