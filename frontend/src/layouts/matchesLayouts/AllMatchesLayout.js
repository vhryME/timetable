import React from "react";

import {Spin} from "antd";

import {withRouter} from "react-router-dom";
import {UniversalTable} from "../../components/common/universalTable";

import {columns, actions as tableActions} from "./config/allMatches/tableConfig";

class AllMatchesLayout extends React.Component {
    componentDidMount() {
        this.props.getAllMatches();
    }

    render() {
        return (
            <Spin spinning={this.props.matches.all.loading}>
                <UniversalTable actions={tableActions(this)}
                                data={this.props.matches.all.data}
                                columns={columns}/>
            </Spin>
        );
    }
}

export default withRouter(AllMatchesLayout);
