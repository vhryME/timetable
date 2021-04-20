import basicStates from "./basicActionStates";
import basicActions from "./basicActions";

export default (base, state, action, shouldBeChangedOnSuccess = "data", shouldBeChangedOnFailed = "error") => {
  switch (action.type) {
    case base + basicActions.GET_ONE + basicStates.LOADING:
    case base + basicActions.GET_ALL + basicStates.LOADING:
    case base + basicActions.GET_FILTERED + basicStates.LOADING:
    case base + basicActions.DELETE + basicStates.LOADING:
    case base + basicActions.EDIT + basicStates.LOADING:
    case base + basicActions.NEW + basicStates.LOADING:
      return {
        ...state,
        [shouldBeChangedOnSuccess]: "",
        [shouldBeChangedOnFailed]: "",
        loading: true,
      }

    case base + basicActions.GET_ONE + basicStates.FAILED:
    case base + basicActions.GET_ALL + basicStates.FAILED:
    case base + basicActions.GET_FILTERED + basicStates.FAILED:
    case base + basicActions.DELETE + basicStates.FAILED:
    case base + basicActions.EDIT + basicStates.FAILED:
    case base + basicActions.NEW + basicStates.FAILED:
      return {
        ...state,
        [shouldBeChangedOnFailed]: action.payload.response.status,
        [shouldBeChangedOnSuccess]: "",
        loading: false,
      }

    case base + basicActions.GET_ONE + basicStates.SUCCESS:
    case base + basicActions.GET_ALL + basicStates.SUCCESS:
    case base + basicActions.GET_FILTERED + basicStates.SUCCESS:
    case base + basicActions.DELETE + basicStates.SUCCESS:
    case base + basicActions.EDIT + basicStates.SUCCESS:
    case base + basicActions.NEW + basicStates.SUCCESS:
      return {
        ...state,
        [shouldBeChangedOnFailed]: "",
        [shouldBeChangedOnSuccess]: action.payload,
        loading: false,
      }

    default:
      return state;

  }
}