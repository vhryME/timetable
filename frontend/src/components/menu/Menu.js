import React from "react";

import {Menu} from 'antd';
import {UsergroupAddOutlined, BookOutlined, TableOutlined, UserOutlined} from '@ant-design/icons';
import {Link} from "react-router-dom";
import Constants from "../../helpers/constants";

class MenuComponent extends React.Component {
    state = {
        collapsed: true,
    };

    toggleCollapsed = () => {
        this.setState({collapsed: !this.state.collapsed});
    };

    render() {
        return (
            <Menu
                onMouseEnter={this.toggleCollapsed}
                onMouseLeave={this.toggleCollapsed}
                mode="vertical"
                theme="dark"
                inlineCollapsed={this.state.collapsed}
                style={{height: "100vh", position: "fixed", fontSize: "30px"}}>

                {/*{!localStorage.getItem(Constants.ACCESS_TOKEN) &&*/}
                {/*    <Menu.Item key="login" icon={<UserOutlined style={{fontSize: "30px"}}/>}>*/}
                {/*        <a href={Constants.GOOGLE_AUTH_URL}>Login</a>*/}
                {/*    </Menu.Item>}*/}

                {/*{localStorage.getItem(Constants.ACCESS_TOKEN) &&*/}
                {/*    <Menu.Item key="timetable" icon={<TableOutlined style={{fontSize: "30px"}}/>}>*/}
                {/*      <Link to="/timetable">Timetable</Link>*/}
                {/*  </Menu.Item>}*/}

                <Menu.Item key="timetable" icon={<TableOutlined style={{fontSize: "30px"}}/>}>
                      <Link to="/timetable">Timetable</Link>
                </Menu.Item>

            </Menu>
        );
    }
}

export default MenuComponent;