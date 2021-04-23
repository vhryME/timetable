import api from "../../helpers/api";
import actionFactory from "../../redux/actionFactory";
import basicEntities from "../../redux/basicEntities";
import basicActions from "../../redux/basicActions";

export function getAllHeroes() {
  const getAll = new Promise(resolve => {
    setTimeout(() => resolve(JSON.parse(localStorage.getItem("heroes"))), 1000);
  })
  return actionFactory({entity: basicEntities.HEROES, action: basicActions.GET_ALL, func: () => getAll, toPayload: true})
}

export function getHeroesFiltered(values) {
  const getFiltered = new Promise(resolve => {
    resolve(JSON.parse(localStorage.getItem("heroes")).filter((item) => {
        for (let key in values) {
          if (item[key] === undefined ||
            values[key] &&
            !item[key].toString().toLowerCase().includes(values[key].toString().toLowerCase())) {
            return false;
          }
        }
        return true;
      })
    );
  });
  return actionFactory({entity: basicEntities.HEROES, action: basicActions.GET_FILTERED, func: () => getFiltered, toPayload: true})
}

export function getOneHero(id) {
  const getOne = new Promise(resolve => {
    resolve(JSON.parse(localStorage.getItem("heroes")).filter((item) => item.id == id)[0]);
  })
  return actionFactory({entity: basicEntities.HERO, action: basicActions.GET_ONE, func: () => getOne, toPayload: true})
}

export function editHero(values, id) {
  const edit = new Promise(resolve => {
    let data = JSON.parse(localStorage.getItem("heroes")).map((item) => {
      if (item.id == id)
        return {...item, ...values};
      return item;
    })
    localStorage.setItem("heroes", JSON.stringify(data))
    resolve(true);
  })
  return actionFactory({entity: basicEntities.HERO, action: basicActions.EDIT, func: () => edit})
}

export function newHero(values) {
  const add = new Promise(resolve => {
    let data = JSON.parse(localStorage.getItem("heroes"));
    data.push(values);
    localStorage.setItem("heroes", JSON.stringify(data));
    resolve(true)
  })
  return actionFactory({entity: basicEntities.HERO, action: basicActions.NEW, func: () => add})
}

export function deleteHero(id) {
  const erase = new Promise(resolve => {
    localStorage.setItem("heroes", JSON.stringify(JSON.parse(localStorage.getItem("heroes")).filter(item => item.id != id)));
    resolve(true);
  })
  return actionFactory({entity: basicEntities.HERO, action: basicActions.DELETE, func: () => erase})
}
