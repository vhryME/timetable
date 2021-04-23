export default {
  required: (message) => ({
    validator: (_, value) =>
      value
        ? Promise.resolve()
        : Promise.reject(new Error(message ? message : "Required")),
    required: true,
  }),

  shorterThan: (pattern, message) => {
    return {
      max: pattern,
      message: message
        ? message
        : `Must be shorter than ${pattern + 1} symbols`,
    };
  },

  longerThan: (pattern, message) => {
    return {
      min: pattern,
      message: message ? message : `Must be longer than ${pattern - 1} symbols`,
    };
  },

  lessThan: (pattern, message) => ({
    validator: (_, value) =>
      value < pattern
        ? Promise.resolve()
        : Promise.reject(
            new Error(message ? message : `Must be less than ${pattern}`)
          ),
  }),

  moreThan: (pattern, message) => ({
    validator: (_, value) =>
      value > pattern
        ? Promise.resolve()
        : Promise.reject(
            new Error(message ? message : `Must be more than ${pattern}`)
          ),
  }),

  equal: (pattern, message) => ({
    validator: (_, value) =>
      value == pattern
        ? Promise.resolve()
        : Promise.reject(
            new Error(message ? message : `Must be equal ${pattern}`)
          ),
  }),

  notEqual: (pattern, message) => ({
    validator: (_, value) =>
      value != pattern
        ? Promise.resolve()
        : Promise.reject(
            new Error(message ? message : `Must be not equal ${pattern}`)
          ),
  }),

  regex: (pattern, message) => {
    return {
      pattern: new RegExp(pattern),
      message: message ? message : "Incorrect format",
    };
  },

  email: (message) => {
    return {
      type: "email",
      message: message ? message : "Incorrect format",
    };
  },

  phone: (message) => {
    return {
      pattern: new RegExp("^[+]{0,1}[1-9]{1,4}[(]{0,1}[0-9]{1,4}[)]{0,1}[0-9]{6,8}$"),
      message: message ? message : "Incorrect format",
    };
  },
};
