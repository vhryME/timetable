import axios from "./axios";

const api = async (url, method = "GET", data) => {
  switch (method) {
    case "GET":
      return axios.get(url);

    case "POST":
      return axios.post(url, data);

    case "PUT":
      return axios.put(url, data);

    case "DELETE":
      return axios.delete(url);

    case "PATCH":
      return axios.patch(url, data);

    case "OPTIONS":
      return axios.options(url);

    default:
      return axios.get(url);
  }
};
export default api;
