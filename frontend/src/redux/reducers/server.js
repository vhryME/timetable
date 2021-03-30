import {
  SERVER_REQUEST_LOADING,
  SERVER_REQUEST_FAILED,
  SERVER_REQUEST_SUCCESS,
} from "../actionsTypes/server";

const initialState = {
  responseCode: "",
  responseData: "",
  loading: false,
  error: false,
};

export default function serverReducer(state = initialState, action) {
  const newState = { ...state };
  switch (action.type) {
    case SERVER_REQUEST_LOADING:
      newState.responseCode = "";
      newState.responseData = "";
      newState.loading = true;
      newState.error = false;
      return newState;

    case SERVER_REQUEST_FAILED:
      console.log(action.payload);
      newState.responseCode = action.payload.response.status;
      newState.responseData = action.payload.message;
      newState.loading = false;
      newState.error = true;
      return newState;

    case SERVER_REQUEST_SUCCESS:
      console.log(action.payload);
      newState.responseCode = action.payload.status;
      newState.responseData = JSON.stringify(action.payload.data);
      newState.loading = false;
      newState.error = false;
      return newState;

    default:
      return state;
  }
}
