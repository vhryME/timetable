import actionFactory from "./redux/actionFactory";
import basicEntities from "./redux/basicEntities";
import basicActions from "./redux/basicActions";

export function getDictionaries() {
  return actionFactory({
    entity: basicEntities.DICTIONARIES,
    action: basicActions.GET_ALL,
    url: "/api/dictionary/",
    method: "GET",
    toPayload: true,
    postProc: res => res.data,
  });
}
