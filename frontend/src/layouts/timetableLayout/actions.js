import actionFactory from "../../redux/actionFactory";
import basicEntities from "../../redux/basicEntities";
import basicActions from "../../redux/basicActions";

export function getClassesByDate(data) {
    console.log(data, "getClassesByDate")
    return actionFactory({
        entity: basicEntities.CLASSES,
        action: basicActions.GET_ALL,
        url: "/timetables/api/timetable/byDate?date=" + data.date,
        postProc: res => res.data,
    })
}

export function getClassesByFacultyByDate(data) {
    console.log(data, "getClassesByFacultyByDate")
    return actionFactory({
        entity: basicEntities.CLASSES,
        action: basicActions.GET_ALL,
        url: `/timetables/api/timetable/byFaculty/byDate/${data.faculty}?date=${data.date}`,
        postProc: res => res.data,
    })
}

export function getClassesByGroupByDate(data) {
    console.log(data, "getClassesByGroupByDate")
    return actionFactory({
        entity: basicEntities.CLASSES,
        action: basicActions.GET_ALL,
        url: `/timetables/api/timetable/byFaculty/byDate/${data.group}?date=${data.date}`,
        postProc: res => res.data,
    })
}

export function getAllFaculties() {
    return actionFactory({
        entity: basicEntities.FACULTIES,
        action: basicActions.GET_ALL,
        url: "timetables/api/faculty/all",
        postProc: res => res.data,
    })
}


