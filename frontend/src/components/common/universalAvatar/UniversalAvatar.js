import React from "react";

import {Upload} from 'antd';
import {LoadingOutlined, PlusOutlined} from '@ant-design/icons';

import "./styles.css";

class UniversalAvatar extends React.Component {
  state = {
    loading: false,
    imageUrl: this.props.src,
  };

  handleChange = info => {
    this.getBase64(info.file.originFileObj, imageUrl => {
        if (this.props.onChange) {
          this.props.onChange(imageUrl)
        }
        this.setState({
          imageUrl,
          loading: false,
        })
      },
    );
  };

  getBase64(img, callback) {
    const reader = new FileReader();
    this.setState({loading: true});
    reader.addEventListener('load', () => callback(reader.result));
    reader.readAsDataURL(img);
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    if (prevProps.src !== this.props.src) {
      this.setState({imageUrl: this.props.src});
    }
  }

  buildAvatar() {
    const uploadButton = this.state.loading ? <LoadingOutlined/> : <PlusOutlined/>;

    const {size} = this.props;

    return (
      <div style={{
        borderRadius: "50%",
        width: size ? size : 104,
        height: size ? size : 104,
        overflow: "hidden",
        border: this.state.imageUrl ? undefined : "1px solid"
      }}>
        <Upload
          name="avatar"
          listType="picture-card"
          showUploadList={false}
          style={{width: "100%", height: "100%"}}
          action="/"
          disabled={this.props.disabled}
          onChange={this.handleChange}
        >
          {this.state.imageUrl ? <img src={this.state.imageUrl} alt="avatar" style={{width: "100%"}}/> : uploadButton}
        </Upload>
      </div>
    )
  }

  render() {
    return this.buildAvatar();
  }
}

export default UniversalAvatar;
