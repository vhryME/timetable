import { connect } from "react-redux";
import TimetableLayout from "./TimetableLayout";
import {
    getAllClassesForNextWeek,
    getAllClassesForCurrentWeek,
    getAllFaculties,
    getClassesByDate,
    getClassesByFacultyByDate, getClassesByGroupByDate
} from "./actions";

const mapStateToProps = ({timetable, faculties}) => ({timetable, faculties})

const mapDispatchToProps = {
    getClassesByDate,
    getClassesByFacultyByDate,
    getClassesByGroupByDate,
    getAllFaculties
};

export const Timetable = connect(mapStateToProps, mapDispatchToProps)(TimetableLayout);