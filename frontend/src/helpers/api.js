import axios from "./axios";
import Constants from "./constants";

const config = {
  headers: {
    "Content-Type": "application/json"
  }
}

const api = async (url, method, data) => {
  let formedConfig = config;
  if(localStorage.getItem(Constants.ACCESS_TOKEN)) {
    formedConfig.headers["Authorization"] = "Bearer " + localStorage.getItem(Constants.ACCESS_TOKEN);
  }

  switch (method) {
    case "GET":
      return axios.get(url);

    case "POST":
      return axios.post(url, data, formedConfig);

    case "PUT":
      return axios.put(url, data, formedConfig);

    case "DELETE":
      return axios.delete(url);

    case "PATCH":
      return axios.patch(url, data, formedConfig);

    case "OPTIONS":
      return axios.options(url);

    case "WITH_PARAMETERS":
      return axios.get(url, {params: data});

    default:
      return axios.get(url);
  }
};
export default api;
