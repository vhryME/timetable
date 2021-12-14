import {combineReducers} from "redux";
import reducerFactory from "../reducerFactory";
import entities from "../basicEntities";

const initialState = {
  data: "",
  error: "",
  loading: false,
};

const oneHeroReducer = (state = initialState, action) => reducerFactory(entities.HERO, state, action);
const allHeroesReducer = (state = initialState, action) => reducerFactory(entities.HEROES, state, action);

const oneMatchReducer = (state = initialState, action) => reducerFactory(entities.MATCH, state, action);
const allMatchesReducer = (state = initialState, action) => reducerFactory(entities.MATCHES, state, action);

const dictionaries = (state = initialState, action) => reducerFactory(entities.DICTIONARIES, state, action);
const timetable = (state = initialState, action) => reducerFactory(entities.CLASSES, state, action);
const faculties = (state = initialState, action) => reducerFactory(entities.FACULTIES, state, action);

export const rootReducer = combineReducers({
  heroes: combineReducers({
    current: oneHeroReducer,
    all: allHeroesReducer
  }),
  matches: combineReducers({
    current: oneMatchReducer,
    all: allMatchesReducer
  }),

  faculties,
  timetable,
  dictionaries,
});