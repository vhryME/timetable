import React from "react";
import {List, Modal, Tag} from "antd";
import {UniversalForm, Validator} from "../../components/common/universalForm";
import {actions as skillActions, schema as skillSchema} from "../heroesLayouts/config/oneHero/skillFormConfig";
import {v4 as uuidv4} from "uuid";

export const actions = (context) => {
    return {
        onAdd: () => console.log("onAdd timetable"),
        onEdit: (value) => console.log("onEdit timetable"),
        onDelete: (value) => console.log("onDelete timetable")
    };
};

const lessonEditingSchema = {
    name: "Lesson",
    fields: {
        name: {
            label: "Name",
            type: "string",
            rules: [Validator.required()]
        },
        type: {
            label: "Type",
            type: "enum",
            rules: [Validator.required()]
        },
        place: {
            label: "Place",
            type: "string",
        }
    }
}

const formLessonEditingModal = (lesson) => {
    const modal = Modal.confirm();

    modal.update({
        title: `Lesson editing`,
        content: <UniversalForm schema={lessonEditingSchema}
                                data={lesson}
                                labelsSpan={6}
                                wrappersSpan={16}
                                actions={{
                                    onSubmit: (values) => { console.log(values); modal.destroy()},
                                    onCancel: () => { console.log("editing cancelled"); modal.destroy() }
                                }}/>,
        cancelButtonProps: {hidden: true},
        okButtonProps: {hidden: true}
    })
}

const tagsDictionary = {
    1: { color: "magenta", name: "lecture" },
    2: { color: "green", name: "practice" },
    3: { color: "cyan", name: "lab" }
}

const tagsRender = (lessonType) => {
    return <Tag color={tagsDictionary[lessonType].color}>{tagsDictionary[lessonType].name}</Tag>
}

const lessonRender = (lesson) => {
    return <List.Item>
        <List.Item.Meta
            title={<a onClick={() => formLessonEditingModal(lesson)}>{lesson.name} {tagsRender(lesson.type)}</a>}
            description={lesson.place}/>
    </List.Item>
}

const dayRender = (day) => {
    return <List
        dataSource={day}
        renderItem={lessonRender}
    />
}

export const columns = () => {
    return {
        group: {
            label: "Group"
        },
        monday: {
            label: "Monday",
            dataIndex: ["lessons", "monday"],
            customRender: (item) => dayRender(item)
        },
        tuesday: {
            label: "Tuesday",
            dataIndex: ["lessons", "tuesday"],
            customRender: (item) => dayRender(item)
        },
        wednesday: {
            label: "Wednesday",
            dataIndex: ["lessons", "wednesday"],
            customRender: (item) => dayRender(item)
        },
        thursday: {
            label: "Thursday",
            dataIndex: ["lessons", "thursday"],
            customRender: (item) => dayRender(item)
        },
        friday: {
            label: "Friday",
            dataIndex: ["lessons", "friday"],
            customRender: (item) => dayRender(item)
        },
        saturday: {
            label: "Saturday",
            dataIndex: ["lessons", "saturday"],
            customRender: (item) => dayRender(item)
        },
    };
};

export const schema = {
    name: "heroesFilter",
    fields: {
        group: { label: "Group", type: "enum" },
        faculty: { label: "Faculty", type: "enum" }
    }
};

export const filterActions = (context) => {
    return {
        onSubmit: (value) => console.log("filter submitted"),
        onClear: (ref) => {
            ref.resetFields();
            console.log("filter cleared");
        }
    }
}