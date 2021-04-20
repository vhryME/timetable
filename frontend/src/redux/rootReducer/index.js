import {combineReducers} from "redux";
import reducerFactory from "../reducerFactory";
import entities from "../basicEntities";

const initialState = {
  data: "",
  error: "",
  loading: false,
};

const oneHeroReducer = (state = initialState, action) => reducerFactory(entities.HERO, state, action);
const allHeroesReducer = (state = initialState, action) => reducerFactory(entities.HEROES, state, action)

export const rootReducer = combineReducers({
  heroes: combineReducers({
    current: oneHeroReducer,
    all: allHeroesReducer
  })
});