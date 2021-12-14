import React from "react";
import {Spin} from "antd";
import {withRouter} from "react-router-dom";
import {UniversalTable} from "../../components/common/universalTable";
import {columns, formLessonEditingModal} from "./config";
import moment from "moment";
import {getClassesByDate, getClassesByFacultyByDate, getClassesByGroupByDate} from "./actions";

class TimetableLayout extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            loading: true,
            selectedFaculty: null
        }
    }

    filterActions = () => ({
        onSubmit: (values) => {
            let {date, faculty, group} = values;
            date = moment(date ? date : Date.now()).format("DD.MM.YYYY")
            if (group) return this.props.getClassesByGroupByDate({date, group});
            if (faculty) return this.props.getClassesByFacultyByDate({date, faculty});
            return this.props.getClassesByDate({date});
        },
        onClear: (ref) => {
            ref.resetFields();
            console.log("filter cleared");
        }
    })

    generateSchema = () => {
        const {data: faculties} = this.props.faculties;

        let groupsValues = {};
        let facultiesValues = {};

        faculties && faculties.reduce((acc, curr) => facultiesValues[curr.id] = curr.name)
        this.state.selectedFaculty && faculties
            .find(item => item.id == this.state.selectedFaculty)
            .specialities
            .reduce((acc, curr) =>
                curr.groups[0] && curr.groups.map(item => groupsValues[item.id] = item.name), [])

        return {
            name: "heroesFilter",
            fields: {
                faculty: {
                    label: "Faculty",
                    type: "enum",
                    options: facultiesValues,
                    onChange: (value) => this.setState({selectedFaculty: value})
                },
                group: {
                    label: "Group",
                    type: "enum",
                    options: groupsValues
                },
                date: {label: "Week", type: "weekPicker"}
            }
        }
    };

    generateFilter = () => ({
        schema: this.generateSchema(),
        actions: this.filterActions(),
        labelsSpan: 3,
        wrappersSpan: 3
    })

    componentDidMount() {
        this.props.getAllFaculties();
        this.props.getClassesByDate({date: moment(Date.now()).format("DD.MM.YYYY")});
        this.setState({loading: true})
    }

    componentDidUpdate(prevProps, prevState, s) {
        prevProps != this.props && this.setState({loading: this.props.timetable.loading})
    }

    render() {
        let groups = {};

        this.props.faculties.data[0]
        && this.props.faculties.data.map(item =>
            item.specialities.reduce((acc, curr) =>
                curr.groups[0] && curr.groups.map(item => groups[item.id] = item.name), [])
        );

        return (
            <Spin spinning={this.state.loading}>
                <UniversalTable
                    filter={this.generateFilter()}
                    columns={columns()}
                    actions={{onAdd: () => formLessonEditingModal({groups})}}
                    data={this.props.timetable.data}/>
            </Spin>
        );
    }
}

export default withRouter(TimetableLayout);
