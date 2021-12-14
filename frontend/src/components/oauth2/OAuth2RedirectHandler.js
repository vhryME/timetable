import React, { Component } from 'react';
import Constants from "../../helpers/constants";
import { Redirect } from 'react-router-dom'

class OAuth2RedirectHandler extends Component {
    getUrlParameter(name) {
        name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
        let regex = new RegExp('[\\?&]' + name + '=([^&#]*)');

        let results = regex.exec(this.props.location.search);
        return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
    };

    render() {
        const token = this.getUrlParameter('token');

        if(token) {
            localStorage.setItem(Constants.ACCESS_TOKEN, token);
            return <Redirect to={{pathname: "/timetable"}}/>;
        } else {
            return <Redirect to={{pathname: "/login"}}/>;
        }
    }
}

export default OAuth2RedirectHandler;