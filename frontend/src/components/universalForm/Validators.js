import rulesMap from "./RulesMap";

export const required = (message) => {
  return rulesMap.required(message);
};

export const longerThan = (value, message) => {
  return rulesMap.longerThan(value, message);
};

export const shorterThan = (value, message) => {
  return rulesMap.shorterThan(value, message);
};

export const lessThan = (value, message) => {
  return rulesMap.lessThan(value, message);
};

export const moreThan = (value, message) => {
  return rulesMap.moreThan(value, message);
};

export const equal = (value, message) => {
  return rulesMap.equal(value, message);
};

export const notEqual = (value, message) => {
  return rulesMap.notEqual(value, message);
};

export const regex = (value, message) => {
  return rulesMap.regex(value, message);
};

export const email = (value, message) => {
  return rulesMap.email(value, message);
};

export const phone = (value, message) => {
  return rulesMap.phone(value, message);
};
