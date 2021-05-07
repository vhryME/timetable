import React from "react";

import {Spin} from "antd";

import {withRouter} from "react-router-dom";

import {UniversalTable} from "../../components/common/universalTable";
import {schema as filterSchema, actions as filterActions} from "./config/allHeroes/filterConfig";
import {actions, columns} from "./config/allHeroes/tableConfig";

class AllHeroesLayout extends React.Component {
  filter = {
    schema: filterSchema,
    actions: filterActions(this),
    labelsSpan: 3,
    wrappersSpan: 3
  }

  componentDidMount() {
    this.props.getAllHeroes();
  }

  dataPreparing() {
    if (this.props.heroes.all.data) {
      return this.props.heroes.all.data.map(item => {return {...item, key: item.id}});
    }
  }

  render() {
    return (
      <Spin spinning={this.props.heroes.all.loading}>
        <UniversalTable filter={this.filter} // todo: add filter to doc
                        actions={actions(this)}
                        data={this.dataPreparing()}
                        columns={columns(this)}/>
      </Spin>
    );
  }
}

export default withRouter(AllHeroesLayout);
