import React from "react";
import {Spin} from "antd";
import {withRouter} from "react-router-dom";
import {UniversalTable} from "../../components/common/universalTable";
import {columns, schema, actions, filterActions} from "./config";

const data = [{
    group: "ВМСиС",
    lessons: {
        monday: [ { name: "Lesson 1 M", type: 1, place: "CAB 1" },
            { name: "Lesson 2 M", type: 1, place: "CAB 1" }],
        tuesday: [ { name: "Lesson 1 T", type: 2, place: "CAB 1235" },
            { name: "Lesson 2 T", type: 1, place: "CAB 5321" }],
        wednesday: [ { name: "Lesson 1 W", type: 3, place: "CAB 623" },
            { name: "Lesson 2 W", type: 2, place: "CAB 734" }],
        thursday: [ { name: "Lesson 1 TH", type: 1, place: "CAB 23" },
            { name: "Lesson 2 TH", type: 2, place: "CAB 32" }],
        friday: [ { name: "Lesson 1 F", type: 1, place: "CAB 626" },
            { name: "Lesson 2 F", type: 3, place: "CAB 43" }],
        saturday: [ { name: "Lesson 1 S", type: 3, place: "CAB 53" },
            { name: "Lesson 2 S", type: 1, place: "CAB 263" }]
    }
}];

class TimetableLayout extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            loading: true
        }
    }

    filter = {
        schema: schema,
        actions: filterActions(this),
        labelsSpan: 3,
        wrappersSpan: 3
    }

    componentDidMount() {
        ///MOCK LOADING
        setTimeout(() => this.setState({loading: false}), 300);
    }

    render() {
        return (
            <Spin spinning={this.state.loading}>
                <UniversalTable
                    filter={this.filter}
                    columns={columns()}
                    data={data}/>
            </Spin>
        );
    }
}

export default withRouter(TimetableLayout);
