import React from "react";

import {Upload} from 'antd';
import {LoadingOutlined, PlusOutlined, UserOutlined} from '@ant-design/icons';

import isBase64 from "is-base64";

import PropTypes from "prop-types";

import "./styles.css";

class UniversalAvatar extends React.Component {
  state = {
    loading: false,
    imageUrl: isBase64(this.props.src, {allowMime: true, allowEmpty: false}) ? this.props.src : null,
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
    if (isBase64(this.props.src, {allowMime: true, allowEmpty: false}) && prevProps.src !== this.props.src) {
      this.setState({imageUrl: this.props.src});
    }
  }

  buildAvatar() {
    let uploadButton = this.state.loading ? <LoadingOutlined/> : <PlusOutlined/>;

    if (this.props.disabled && !isBase64(this.props.src, {allowMime: true, allowEmpty: false})) {
      uploadButton = <UserOutlined/>;
    }

    const {size} = this.props;

    return (
      <div style={{
        borderRadius: "50%",
        width: size,
        height: size,
        overflow: "hidden",
        border: this.state.imageUrl ? undefined : "1px solid",
        ...this.props.style
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

UniversalAvatar.propTypes = {
  onChange: PropTypes.func,
  src: PropTypes.string,
  disabled: PropTypes.bool,
  size: PropTypes.number,
}

UniversalAvatar.defaultProps = {
  onChange: () => {
  },
  src: null,
  disabled: false,
  size: 104,
}

export default UniversalAvatar;
