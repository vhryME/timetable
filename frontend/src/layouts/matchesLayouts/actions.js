import api from "../../helpers/api";
import actionFactory from "../../redux/actionFactory";
import basicEntities from "../../redux/basicEntities";
import basicActions from "../../redux/basicActions";

export function getAllMatches() {
    const getAll = new Promise(resolve => {
        setTimeout(() => resolve(JSON.parse(localStorage.getItem("matches"))), 1000);
    })
    return actionFactory({entity: basicEntities.MATCHES, action: basicActions.GET_ALL, func: () => getAll, toPayload: true})
}

export function getMatchesFiltered(values) {
    const getFiltered = new Promise(resolve => {
        resolve(JSON.parse(localStorage.getItem("matches")).filter((item) => {
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
    return actionFactory({entity: basicEntities.MATCHES, action: basicActions.GET_FILTERED, func: () => getFiltered, toPayload: true})
}

export function getOneMatch(id) {
    const getOne = new Promise(resolve => {
        resolve(JSON.parse(localStorage.getItem("matches")).filter((item) => item.id == id)[0]);
    })
    return actionFactory({entity: basicEntities.MATCH, action: basicActions.GET_ONE, func: () => getOne, toPayload: true})
}

export function editMatch(values, id) {
    const edit = new Promise(resolve => {
        let data = JSON.parse(localStorage.getItem("matches")).map((item) => {
            if (item.id == id)
                return {...item, ...values};
            return item;
        })
        localStorage.setItem("matches", JSON.stringify(data))
        resolve(true);
    })
    return actionFactory({entity: basicEntities.MATCH, action: basicActions.EDIT, func: () => edit})
}

export function newMatch(values) {
    const add = new Promise(resolve => {
        let data = JSON.parse(localStorage.getItem("matches"));
        data.push(values);
        localStorage.setItem("matches", JSON.stringify(data));
        resolve(true)
    })
    return actionFactory({entity: basicEntities.MATCH, action: basicActions.NEW, func: () => add})
}

export function deleteMatch(id) {
    const erase = new Promise(resolve => {
        localStorage.setItem("matches", JSON.stringify(JSON.parse(localStorage.getItem("matches")).filter(item => item.id != id)));
        resolve(true);
    })
    return actionFactory({entity: basicEntities.MATCH, action: basicActions.DELETE, func: () => erase})
}
