import React from "react";

class ServerAnswer extends React.Component {
  onErrorClickHandle = () => this.props.serverGetError();

  onNormalClickHandle = () => this.props.serverGetHelloWorld();

  render() {
    return (
      <div>
        Server Code: {this.props.responseCode} <br />
        Server Data: {this.props.responseData} <br />
        <button onClick={this.onErrorClickHandle}>
          Totally error request button
        </button>
        <button onClick={this.onNormalClickHandle}>
          Totally normal request button
        </button>
      </div>
    );
  }
}

export default ServerAnswer;
