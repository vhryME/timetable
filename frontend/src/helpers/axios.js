import axios from "axios";

if (process.env.REACT_APP_ENV === "production") {
  axios.defaults.baseURL = "http://localhost:3002/";
} else {
  axios.defaults.baseURL = "http://localhost:3001/";
}

axios.interceptors.response.use(
  (response) => {
    return response;
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default axios;
