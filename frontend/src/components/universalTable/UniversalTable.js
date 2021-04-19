import React from "react";
import { Table, Button, Drawer, Space, Input } from "antd";
import { SearchOutlined } from "@ant-design/icons";
import Highlighter from "react-highlight-words";

import hash from "object-hash";

import { UniversalForm } from "../universalForm";
import ActionsCreator from "./ActionsCreator";

class UniversalTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      data: this.props.data,
      editing: false,
      editingData: "",
      adding: false,
      addingData: "",
      searchText: "",
      searchedColumn: "",
    };
    this.columns = this.props.columns;
  }

  getColumnSearchProps = (dataIndex) => ({
    filterDropdown: ({
      setSelectedKeys,
      selectedKeys,
      confirm,
      clearFilters,
    }) => (
      <div style={{ padding: 8 }}>
        <Input
          ref={(node) => {
            this.searchInput = node;
          }}
          placeholder={`Search ${dataIndex}`}
          value={selectedKeys[0]}
          onChange={(e) =>
            setSelectedKeys(e.target.value ? [e.target.value] : [])
          }
          onPressEnter={() =>
            this.handleSearch(selectedKeys, confirm, dataIndex)
          }
          style={{ width: 188, marginBottom: 8, display: "block" }}
        />
        <Space>
          <Button
            type="primary"
            onClick={() => this.handleSearch(selectedKeys, confirm, dataIndex)}
            icon={<SearchOutlined />}
            size="small"
            style={{ width: 90 }}
          >
            Search
          </Button>
          <Button
            onClick={() => this.handleReset(clearFilters)}
            size="small"
            style={{ width: 90 }}
          >
            Reset
          </Button>
          <Button
            type="link"
            size="small"
            onClick={() => {
              confirm({ closeDropdown: false });
              this.setState({
                searchText: selectedKeys[0],
                searchedColumn: dataIndex,
              });
            }}
          >
            Filter
          </Button>
        </Space>
      </div>
    ),
    filterIcon: (filtered) => (
      <SearchOutlined style={{ color: filtered ? "#1890ff" : undefined }} />
    ),
    onFilter: (value, record) =>
      record[dataIndex]
        ? record[dataIndex]
            .toString()
            .toLowerCase()
            .includes(value.toLowerCase())
        : "",
    onFilterDropdownVisibleChange: (visible) => {
      if (visible) {
        setTimeout(() => this.searchInput.select(), 100);
      }
    },
    render: (text) =>
      this.state.searchedColumn === dataIndex ? (
        <Highlighter
          highlightStyle={{ backgroundColor: "#ffc069", padding: 0 }}
          searchWords={[this.state.searchText]}
          autoEscape
          textToHighlight={text ? text.toString() : ""}
        />
      ) : (
        text
      ),
  });

  getFields = () => {
    let columnsArr = Object.keys(this.columns).map((column) => {
      return {
        title: this.columns[column].label || this.columns[column],
        dataIndex: column,
        key: column,
        sorter: this.columns[column].sorter
          ? this.columns[column].sorter
          : false,
        ...this.getColumnSearchProps(column),
      };
    });

    if (this.props.actions) {
      columnsArr.push({
        title: "Actions",
        dataIndex: "actions",
        render: (_, record) =>
          this.props.data && this.props.data.length >= 1 ? (
            <div>
              {this.props.actions.onDelete
                ? ActionsCreator.onDelete(
                    this,
                    record,
                    this.props.actions.onDelete
                  )
                : null}
              {this.props.actions.onEdit
                ? ActionsCreator.onEdit(this, record)
                : null}
            </div>
          ) : null,
      });
    }

    return columnsArr;
  };

  handleSearch = (selectedKeys, confirm, dataIndex) => {
    confirm();
    this.setState({
      searchText: selectedKeys[0],
      searchedColumn: dataIndex,
    });
  };

  handleReset = (clearFilters) => {
    clearFilters();
    this.setState({ searchText: "" });
  };

  buildTable() {
    return (
      <>
        <Table
          columns={this.getFields()}
          dataSource={this.state.data}
          footer={() => {
            return this.props.actions.onAdd ? ActionsCreator.onAdd(this) : null;
          }}
          pagination={false}
        />
        <Drawer
          title="Editing"
          width={720}
          visible={this.state.editing}
          onClose={() => this.setState({ editing: false, editingData: "" })}
        >
          <UniversalForm
            key={hash(this.state.editingData)}
            schema={this.props.schema}
            data={this.state.editingData}
            layout={"vertical"}
            actions={{
              onSubmit: (values) => {
                this.props.actions.onEdit(values);
                this.setState({
                  editing: false,
                  editingData: "",
                  data: this.state.data.map((row) => {
                    if (row.key === this.state.editingData.key)
                      return { key: this.state.editingData.key, ...values };
                    return row;
                  }),
                });
              },
            }}
          />
        </Drawer>
        <Drawer
          title="Adding"
          width={720}
          visible={this.state.adding}
          onClose={() => this.setState({ adding: false })}
        >
          <UniversalForm
            schema={this.props.schema}
            layout={"vertical"}
            actions={{
              onSubmit: (values) => {
                this.props.actions.onAdd(values);
                this.setState({
                  adding: false,
                  addingData: "",
                  data: this.state.data
                    ? [...this.state.data, { ...values, key: hash(values) }]
                    : [{ ...values, key: hash(values) }],
                });
              },
            }}
          />
        </Drawer>
      </>
    );
  }

  render() {
    const Table = this.buildTable();
    return Table;
  }
}

export default UniversalTable;
