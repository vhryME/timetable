import {
    SERVER_REQUEST_LOADING,
    SERVER_REQUEST_SUCCESS,
    SERVER_REQUEST_FAILED,
} from "../../redux/actionsTypes/server";
import api from "../../helpers/api";

export function serverGetError() {
    return async function (dispatch) {
        dispatch({ type: SERVER_REQUEST_LOADING });
        api("/api/notExistingPath", "GET")
            .then((data) => {
                dispatch({
                    type: SERVER_REQUEST_SUCCESS,
                    payload: data,
                });
            })
            .catch((err) => {
                dispatch({ type: SERVER_REQUEST_FAILED, payload: err });
            });
    };
}

export function serverGetHelloWorld() {
    return async function (dispatch) {
        dispatch({ type: SERVER_REQUEST_LOADING });
        api("/api/test/greeting", "GET")
            .then((data) => {
                dispatch({
                    type: SERVER_REQUEST_SUCCESS,
                    payload: data,
                });
            })
            .catch((err) => {
                dispatch({ type: SERVER_REQUEST_FAILED, payload: err });
            });
    };
}
