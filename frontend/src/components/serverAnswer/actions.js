import {
  SERVER_REQUEST,
  SERVER_REQUEST_SUCCESS,
  SERVER_REQUEST_FAILED,
} from "../../redux/actionsTypes/server";
import api from "../../helpers/api";

export function serverGetError() {
  return async function (dispatch) {
    dispatch({ type: SERVER_REQUEST });
    api("/errorApiPath", "GET")
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

export function serverGetPost() {
  return async function (dispatch) {
    dispatch({ type: SERVER_REQUEST });
    api("/posts", "GET")
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
