import { combineReducers } from "redux";
import serverReducer from "./server";

export const rootReducer = combineReducers({
  server: serverReducer
});