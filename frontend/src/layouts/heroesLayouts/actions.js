import actionFactory from "../../redux/actionFactory";
import basicEntities from "../../redux/basicEntities";
import basicActions from "../../redux/basicActions";

export function getAllHeroes() {
  return actionFactory({
    entity: basicEntities.HEROES,
    action: basicActions.GET_ALL,
    url: "/api/hero",
    postProc: res => res.data,
  })
}

export function getHeroesFiltered(values) {
  return actionFactory({
    entity: basicEntities.HEROES,
    action: basicActions.GET_FILTERED,
    url: "/api/hero/search",
    method: "POST",
    values: values,
    postProc: res => res.data.content,
  })
}

export function getOneHero(id) {
  return actionFactory({
    entity: basicEntities.HERO,
    action: basicActions.GET_ONE,
    url: `/api/hero/${id}`,
    postProc: res => res.data,
  })
}

export function editHero(values, id) {
  return actionFactory({
    entity: basicEntities.HERO,
    action: basicActions.EDIT,
    url: `/api/hero/${id}`,
    method: "PUT",
    values: values,
    toPayload: false
  })
}

export function newHero(values) {
  return actionFactory({
    entity: basicEntities.HERO,
    action: basicActions.NEW,
    url: "/api/hero",
    method: "POST",
    values: values,
    toPayload: false
  })
}

export function deleteHero(id) {
  return actionFactory({
    entity: basicEntities.HERO,
    action: basicActions.DELETE,
    url: `/api/hero/${id}`,
    method: "DELETE",
    toPayload: false
  })
}
