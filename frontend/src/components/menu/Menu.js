import React from "react";

import {Menu} from 'antd';
import {UsergroupAddOutlined, BookOutlined, TableOutlined} from '@ant-design/icons';
import {Link} from "react-router-dom";

class MenuComponent extends React.Component {
  state = {
    collapsed: true,
  };

  toggleCollapsed = () => {
    this.setState({ collapsed: !this.state.collapsed });
  };

  render() {
    return (
      <Menu
        onMouseEnter={this.toggleCollapsed}
        onMouseLeave={this.toggleCollapsed}
        mode="vertical"
        theme="dark"
        inlineCollapsed={this.state.collapsed}
        style={{height: "100vh", position: "fixed", fontSize: "30px"}}
      >
        <Menu.Item key="1" icon={<UsergroupAddOutlined style={{fontSize: "30px"}}/>}>
          <Link to="/heroes">Heroes</Link>
        </Menu.Item>
        <Menu.Item key="2" icon={<BookOutlined style={{fontSize: "30px"}}/>}>
          <Link to="/matches">Matches</Link>
        </Menu.Item>

        <Menu.Item key="timetable" icon={<TableOutlined style={{fontSize: "30px"}}/>}>
          <Link to="/timetable">Timetable</Link>
        </Menu.Item>
      </Menu>
    );
  }
}

export default MenuComponent;