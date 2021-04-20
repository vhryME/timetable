import states from "./basicActionStates";
import api from "../helpers/api";

export default (config) => {
  return async function (dispatch) {
    dispatch({type: config.entity + config.action + states["LOADING"]});

    if (config.func) {
      config.func().then((data) => {
        dispatch({
          type: config.entity + config.action + states["SUCCESS"],
          payload: config.toPayload ? data : undefined
        })
      }).catch((err) => {
        dispatch({type: config.entity + config.action + states["FAILED"], payload: err})
      })
    } else if (config.url) {
      api(config.url, config.method, config.values).then((data) => {
        dispatch({
          type: config.entity + config.action + states["SUCCESS"],
          payload: config.toPayload ? data : undefined
        })
      }).catch((err) => {
        dispatch({type: config.entity + config.action + states["FAILED"], payload: err})
      });
    } else {
      console.warn("CHECK ACTION CONFIG: ", config);
    }
  }
}