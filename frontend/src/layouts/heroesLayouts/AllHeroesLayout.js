import React from "react";

import {Spin} from "antd";

import {withRouter} from "react-router-dom";
import {UniversalTable} from "../../components/common/universalTable";
import filterSchema from "./filterConfig";
import UniversalAvatar from "../../components/common/universalAvatar/UniversalAvatar";

class AllHeroesLayout extends React.Component {
  columns = {
    icon: {
      label: "Icon",
      customRender: (_, record) => {
        return <UniversalAvatar disabled src={record.icon} size={30}/>
      }
    },
    name: {
      label: "Name",
      customRender: (text, record) => {
        return <a onClick={() => this.props.history.push("/heroes/view/" + record.id)}>{text}</a>
      }
    },
    role: "Role",
    creationDate: {
      label: "Creation date",
      type: "date",
    },
    melee: {
      label: "Is melee?",
      type: "boolean"
    },
  }

  actions = {
    onAdd: () => {
      this.props.history.push("/heroes/new");
    },
    onEdit: (value) => {
      this.props.history.push("/heroes/edit/" + value.id);
    },
    onDelete: (value) => {
      this.props.deleteHero(value.id);
      this.props.getAllHeroes();
      console.log(value, " deleted!");
    }
  }

  filterActions = {
    onSubmit: (value) => {
      this.props.getHeroesFiltered(value);
    },
    onClear: (ref) => {
      ref.resetFields();
      this.props.getAllHeroes();
    },
  };

  filter = {
    schema: filterSchema,
    actions: this.filterActions,
    labelsSpan: 3,
    wrappersSpan: 3
  }

  componentDidMount() {
    this.props.getAllHeroes();
  }

  render() {
    return (
      <Spin spinning={this.props.heroes.all.loading}>
        <UniversalTable filter={this.filter} // todo: add filter to doc
                        actions={this.actions}
                        data={this.props.heroes.all.data}
                        columns={this.columns}/>
      </Spin>
    );
  }
}

export default withRouter(AllHeroesLayout);
