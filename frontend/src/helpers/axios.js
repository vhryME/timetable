import axios from "axios";

// axios.defaults.baseURL = 'http://localhost:9090/timetables';
axios.interceptors.response.use(
    (response) => {
        return response;
    },
    (error) => {
        return Promise.reject(error);
    }
);

export default axios;
