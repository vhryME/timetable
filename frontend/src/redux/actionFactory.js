import states from "./basicActionStates";
import api from "../helpers/api";

const ActionFactory = (config) => {
  const {entity, action, func, url, method, values, toPayload = true, postProc = data => data} = config;
  return async function (dispatch) {
    dispatch({type: entity + action + states["LOADING"]});

    function builder(asyncFunc) {
      asyncFunc().then((data) => {
        let payload = postProc(data);

        dispatch({
          type: entity + action + states["SUCCESS"],
          payload: toPayload ? payload : undefined
        })
      }).catch((err) => {
        dispatch({
          type: entity + action + states["FAILED"],
          payload: err
        })
      })
    }

    if (func) {
      builder(func)
    } else if (url) {
      builder(() => api(url, method, values))
    } else {
      console.warn("CHECK ACTION CONFIG: ", config);
    }
  }
}

export default ActionFactory;