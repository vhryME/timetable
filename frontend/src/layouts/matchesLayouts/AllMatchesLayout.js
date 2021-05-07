import React from "react";

import {Spin} from "antd";

import {withRouter} from "react-router-dom";
import {UniversalTable} from "../../components/common/universalTable";
import filterSchema from "./filterConfig";

class AllMatchesLayout extends React.Component {
    columns = {
        typeOfMatch: {
            label: "Type of match",
        },
        date: {
            label: "Date",
            type: "date",
        },
        duration: {
            type: "time",
            label: "Duration"
        },
        region: {
            label: "Region"
        },
        maps: {
            label: "Maps"
        },
        winner: {
            type: "string",
            label: "Winner"
        }
    };

    actions = {
        onAdd: () => {
            this.props.history.push("/matches/new");
        },
        onEdit: (value) => {
            this.props.history.push("/matches/edit/" + value.id);
        },
        onDelete: (value) => {
            this.props.deleteMatch(value.id);
            this.props.getAllMatches();
            console.log(value, " deleted!");
        }
    };

    filterActions = {
        onSubmit: (value) => {
            this.props.getMatchesFiltered(value);
        },
        onClear: (ref) => {
            ref.resetFields();
            this.props.getAllMatches();
        },
    };

    filter = {
        schema: filterSchema,
        actions: this.filterActions,
        labelsSpan: 3,
        wrappersSpan: 3
    };

    componentDidMount() {
        this.props.getAllMatches();
    }

    render() {
        return (
            <Spin spinning={this.props.matches.all.loading}>
                <UniversalTable filter={this.filter} // todo: add filter to doc
                                actions={this.actions}
                                data={this.props.matches.all.data}
                                columns={this.columns}/>
            </Spin>
        );
    }
}

export default withRouter(AllMatchesLayout);
