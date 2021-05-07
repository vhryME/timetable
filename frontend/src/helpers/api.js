import axios from "./axios";

const config = {
  headers: {
    "Content-Type": "application/json"
  }
}

const api = async (url, method = "GET", data) => {
  switch (method) {
    case "GET":
      return axios.get(url);

    case "POST":
      return axios.post(url, data, config);

    case "PUT":
      return axios.put(url, data, config);

    case "DELETE":
      return axios.delete(url);

    case "PATCH":
      return axios.patch(url, data, config);

    case "OPTIONS":
      return axios.options(url);

    default:
      return axios.get(url, {params: data});
  }
};
export default api;
