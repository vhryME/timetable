import React from "react";
import {withRouter} from "react-router-dom";
import {Table, Collapse} from "antd";
import {SearchOutlined} from "@ant-design/icons";

import ActionsCreator from "./ActionsCreator";
import FieldsCreator from "./FieldsCreator";
import {UniversalForm} from "../universalForm";
import PropTypes from "prop-types";

class UniversalTable extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      dictionaries: this.props.dictionaries.data,
    }
  }

  getFields = () => {
    let columnsArr = Object.keys(this.props.columns).map((column) => {
      const colInfo = this.props.columns[column];
      return {
        title: colInfo.label || colInfo,
        dataIndex: colInfo.dataIndex ? colInfo.dataIndex : column,
        key: column,
        ellipsis: colInfo.type === "longString",
        sorter: colInfo.sorter
          ? colInfo.sorter
          : false,
        render: colInfo.customRender
          ? colInfo.customRender
          : colInfo.type
            ? FieldsCreator[colInfo.type](this, colInfo)
            : FieldsCreator["string"](),
      };
    });

    if (this.props.actions && !this.props.readonly) {
      this.props.actions["onDelete"] || this.props.actions["onEdit"] && columnsArr.push({
        title: "Actions",
        dataIndex: "actions",
        width: "90px",
        render: (_, record) =>
          this.props.data && this.props.data.length >= 1 ? (
            <div>
              {this.props.actions.onDelete
                ? ActionsCreator.onDelete(this, record)
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

  componentDidUpdate(prevProps, prevState, snapshot) {
    if (prevProps.dictionaries !== this.props.dictionaries) {
      this.setState({dictionaries: this.props.dictionaries.data});
    }
  }

  render() {
    return (
      <div>
        {this.props.filter ?
          <Collapse>
            <Collapse.Panel key={"filter"} header={<div><SearchOutlined/> Filter </div>}> {/*todo: add description of filter to doc*/}
              <UniversalForm schema={this.props.filter.schema}
                             cols={this.props.filter.cols}
                             labelsSpan={this.props.filter.labelsSpan ? this.props.filter.labelsSpan : 12}
                             wrappersSpan={this.props.filter.wrappersSpan ? this.props.filter.wrappersSpan : 12}
                             layout={this.props.filter.layout}
                             actions={this.props.filter.actions}/>
            </Collapse.Panel>
          </Collapse> : null
        }
        {this.props.actions && this.props.actions.onAdd && !this.props.readonly ? ActionsCreator.onAdd(this) : null}
        <Table
          bordered={true}
          key={this.props.data}
          columns={this.getFields()}
          dataSource={this.props.data}
          scroll={{y: this.props.scroll}}
          rowClassName={this.props.rowClassName}
          components={this.props.components}
          expandable={this.props.expandable}
          pagination={false}
        />
      </div>
    );
  }
}

UniversalTable.propTypes = {
  readonly: PropTypes.bool,
  actions: PropTypes.objectOf(PropTypes.func),
  data: PropTypes.array,
  columns: PropTypes.object.isRequired,
  expandable: PropTypes.object,
  scroll: PropTypes.oneOfType([PropTypes.number, PropTypes.string]),
}

UniversalTable.defaultProps = {
  readonly: false,
  // actions: {},
  data: [],
}

export default withRouter(UniversalTable);
