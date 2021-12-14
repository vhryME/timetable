import React from "react";
import {List, Modal, Tag} from "antd";
import {UniversalForm, Validator} from "../../components/common/universalForm";
import axios from "../../helpers/axios";

export const lessonEditingSchema = (types, groups, groupsDisabled) => ({
    name: "Lesson",
    fields: {
        group: {
            label: "Group",
            type: "enum",
            options: groups,
            disabled: groupsDisabled
        },
        name: {
            label: "Name",
            type: "string",
            rules: [Validator.required()]
        },
        type: {
            label: "Type",
            type: "enum",
            rules: [Validator.required()],
            options: types
        },
        date: {
            label: "Date",
            type: "date",
        },
        startDateTime: {
            label: "Start time",
            type: "time"
        },
        endDateTime: {
            label: "End time",
            type: "time"
        }
    }
})

export const formLessonEditingModal = ({lesson, groups, group}) => {
    const modal = Modal.confirm();

    console.log(lesson, "clicked");

    axios.get("/timetables/api/dictionary/lessonType").then(response =>
        modal.update({
            title: lesson && lesson.id ? `Lesson editing` : `Lesson adding`,
            content: <UniversalForm schema={lessonEditingSchema(response.data, groups, lesson && lesson.id)}
                                    data={{...lesson, group}}
                                    labelsSpan={6}
                                    wrappersSpan={16}
                                    actions={{
                                        onSubmit: (values) => {
                                            console.log(values);
                                            modal.destroy()
                                        },
                                        onCancel: () => {
                                            console.log("editing cancelled");
                                            modal.destroy()
                                        }
                                    }}/>,
            cancelButtonProps: {hidden: true},
            okButtonProps: {hidden: true}
        })
    )
}

const tagsColorsDictionary = ["magenta", "volcano", "lime", "cyan", "geekblue", "purple"]

const tagsRender = (lessonType) => {
    return <Tag color={tagsColorsDictionary[lessonType.id] ?? "purple"}>{lessonType.value}</Tag>
}

const dayRender = (day, record) => {
    return <List
        dataSource={day}
        renderItem={(lesson) => <List.Item>
                <List.Item.Meta
                    title={<a onClick={() =>
                        formLessonEditingModal({
                            lesson: {
                                ...lesson,
                                type: lesson.type.id.toString()
                            },
                            group: record.group.name
                        })}>
                        {lesson.shortName}
                        {tagsRender(lesson.type)}</a>}
                    description={lesson.name}/>
            </List.Item>
        }
    />
}

export const columns = () => {
    return {
        group: {
            label: "Group",
            dataIndex: ["group", "name"]
        },
        monday: {
            label: "Monday",
            dataIndex: ["monday"],
            customRender: dayRender
        },
        tuesday: {
            label: "Tuesday",
            dataIndex: ["tuesday"],
            customRender: dayRender
        },
        wednesday: {
            label: "Wednesday",
            dataIndex: ["wednesday"],
            customRender: dayRender
        },
        thursday: {
            label: "Thursday",
            dataIndex: ["thursday"],
            customRender: dayRender
        },
        friday: {
            label: "Friday",
            dataIndex: ["friday"],
            customRender: dayRender
        },
        saturday: {
            label: "Saturday",
            dataIndex: ["saturday"],
            customRender: dayRender
        },
    };
};