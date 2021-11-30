package com.vhry.exception;

import lombok.AllArgsConstructor;

import static com.vhry.exception.ErrorCodeEnum.ContextEnum.*;
import static com.vhry.exception.ErrorCodeEnum.ModuleEnum.*;

@AllArgsConstructor
public enum ErrorCodeEnum {

    E1001(PERSISTENCE, COMMON, "Entity: entity persist into DB was rejected, object = null"),
    E1002(PERSISTENCE, COMMON, "Entity getting by ID: entityId from DB was rejected. Entity was not found in DB"),
    E1003(PERSISTENCE, COMMON, "Entity deleting by ID: entityId from DB was rejected. Entity was not found in DB"),
    E1004(PERSISTENCE, COMMON, "Entity(dictionary) getting by id: dictionaryId from DB was rejected. Entity was not found in DB"),
    E1005(PERSISTENCE, COMMON, "Entity(by spec) getting: spec from DB was rejected. Entity was not found in DB"),

    E2001(API, AUTHORIZATION, "User was not found by username: usernameValue"),

    E3001(CORE, TIMETABLE, "Getting timetable by faculty was rejected: group by id: groupId was not found in DB"),
    E3002(CORE, TIMETABLE, "Getting timetable by group was rejected: student by id: studentId was not found in DB"),
    E3003(CORE, TIMETABLE, "Getting timetable by student was rejected: faculty by id: facultyId was not found in DB"),
    E3004(CORE, TIMETABLE, "Getting timetable by date/dates (from-to) was rejected: date is incorrect");

    ModuleEnum module;
    ContextEnum context;
    String description;

    public String getDescription() {
        return description;
    }

    enum ModuleEnum {
        CORE, PERSISTENCE, API
    }

    enum ContextEnum {
        COMMON, AUTHORIZATION, TIMETABLE
    }

}
