import React from "react";

import {Button, Tabs, Form, message, Radio, Card} from 'antd';
import UniversalAvatar from "../common/universalAvatar/UniversalAvatar";

import "./styles.css";

const mockedTalents = [
    {
        id: 1,
        icon: "1",
        levelOfAccess: 1,
        name: "Talent 1-1",
        type: "passive"
    },
    {
        id: 2,
        icon: "1",
        levelOfAccess: 1,
        name: "Talent 1-2",
        type: "active"
    },
    {
        id: 3,
        icon: "1",
        levelOfAccess: 1,
        name: "Talent 1-3",
        type: "passive"
    },
    {
        id: 4,
        icon: "1",
        levelOfAccess: 4,
        name: "Talent 4-1",
        type: "active"
    },
    {
        id: 5,
        icon: "1",
        levelOfAccess: 4,
        name: "Talent 4-2",
        type: "passive"
    },
    {
        id: 6,
        icon: "1",
        levelOfAccess: 4,
        name: "Talent 4-3",
        type: "active"
    },
    {
        id: 7,
        icon: "1",
        levelOfAccess: 7,
        name: "Talent 7-1",
        type: "passive"
    },
    {
        id: 8,
        icon: "1",
        levelOfAccess: 7,
        name: "Talent 7-2",
        type: "active"
    },
    {
        id: 9,
        icon: "1",
        levelOfAccess: 7,
        name: "Talent 7-3",
        type: "passive"
    },
    {
        id: 10,
        icon: "1",
        levelOfAccess: 10,
        name: "Talent 10-1",
        type: "active"
    },
    {
        id: 11,
        icon: "1",
        levelOfAccess: 10,
        name: "Talent 10-2",
        type: "passive"
    },
    {
        id: 12,
        icon: "1",
        levelOfAccess: 13,
        name: "Talent 13-1",
        type: "active"
    },
    {
        id: 13,
        icon: "1",
        levelOfAccess: 13,
        name: "Talent 13-2",
        type: "passive"
    },
    {
        id: 14,
        icon: "1",
        levelOfAccess: 13,
        name: "Talent 13-3",
        type: "active"
    },
    {
        id: 15,
        icon: "1",
        levelOfAccess: 16,
        name: "Talent 16-1",
        type: "passive"
    },
    {
        id: 16,
        icon: "1",
        levelOfAccess: 16,
        name: "Talent 16-2",
        type: "active"
    },
    {
        id: 17,
        icon: "1",
        levelOfAccess: 16,
        name: "Talent 16-3",
        type: "passive"
    },
    {
        id: 18,
        icon: "1",
        levelOfAccess: 20,
        name: "Talent 20-1",
        type: "active"
    },
    {
        id: 19,
        icon: "1",
        levelOfAccess: 20,
        name: "Talent 20-2",
        type: "passive"
    },
    {
        id: 20,
        icon: "1",
        levelOfAccess: 20,
        name: "Talent 20-3",
        type: "active"
    },
    {
        id: 21,
        icon: "1",
        levelOfAccess: 20,
        name: "Talent 20-4",
        type: "passive"
    },
]

class TalentsTree extends React.Component {
    state = {
        unlockedLevel: 1,
    }

    radioStyle = {
        display: "flex",
        height: "auto",
        borderRadius: "20px",
        marginBottom: "10px"
    };

    talentsParsing() {
        return mockedTalents.reduce((groups, item) => ({
            ...groups,
            [item.levelOfAccess]: [...(groups[item.levelOfAccess] || []), item]
        }), {});
    }

    formItemsBuilder() {
        let groupedTalents = this.talentsParsing();
        let levels = Object.keys(groupedTalents);
        return levels.map((level, index) => {
            return (
                <Card hoverable bordered={false} title={`Level ${level}`} style={{margin: "5px"}}>
                    <Form.Item name={level} noStyle>
                        <Radio.Group
                            onChange={() => this.setState({
                                unlockedLevel:
                                    Number(levels[index + 1] || levels[levels.length - 1]) > this.state.unlockedLevel
                                        ? Number(levels[index + 1] || levels[levels.length - 1])
                                        : this.state.unlockedLevel
                            })}
                            disabled={this.state.unlockedLevel < level}
                            buttonStyle="solid">
                            {groupedTalents[level].map(talent =>
                                <Radio.Button shape={"round"} value={talent} style={this.radioStyle}>
                                    <div style={{display: "flex", flexDirection: "column", alignItems: "center"}}>
                                        {talent.name}
                                        <UniversalAvatar size={70} disabled/>
                                        {talent.type}
                                    </div>
                                </Radio.Button>
                            )}
                        </Radio.Group>
                    </Form.Item>
                </Card>)
        })
    }

    render() {
        return (
            <Form onFinish={this.props.onSubmit}>
                <div style={{
                    display: "flex",
                    alignContent: "center",
                    alignItems: "flex-start",
                    justifyContent: "center"
                }}>
                    {this.formItemsBuilder()}
                </div>
                <Form.Item>
                    <Button type="primary" htmlType="submit">
                        Submit
                    </Button>
                </Form.Item>
            </Form>
        );
    }
}

export default TalentsTree;
