package com.vhry.exception;

import lombok.AllArgsConstructor;

import static com.vhry.exception.ErrorCodeEnum.ModuleEnum.*;

@AllArgsConstructor
public enum ErrorCodeEnum {

    E1001(PERSISTENCE, "Entity: entity persist into DB was rejected, object = null"),
    E1002(PERSISTENCE, "Entity getting by ID: entityId from DB was rejected. Entity was not found in DB"),
    E1003(PERSISTENCE, "Entity deleting by ID: entityId from DB was rejected. Entity was not found in DB"),
    E1004(PERSISTENCE, "Entity(dictionary) getting by id: dictionaryId from DB was rejected. Entity was not found in DB"),
    E1005(PERSISTENCE, "Entity(by spec) getting: spec from DB was rejected. Entity was not found in DB"),

    E2001(AUTHORIZATION, "User was not found by username: usernameValue"),

    E3001(CORE, "Getting timetable by group was rejected: group by id: groupId was not found in DB"),
    E3002(CORE, "Getting timetable by student was rejected: student by id: student was not found in DB");

    ModuleEnum module;
    String description;

    public String getDescription() {
        return description;
    }

    enum ModuleEnum {
        CORE, PERSISTENCE, AUTHORIZATION
    }

}
