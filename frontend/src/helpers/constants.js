const URLs = {
    API_BASE_URL: "http://localhost:9090",
    REDIRECT_URI: "http://localhost:3000/oauth2/redirect",
}

let Constants = {
    GOOGLE_AUTH_URL: URLs.API_BASE_URL + "/google?redirect_uri=" + URLs.REDIRECT_URI,
    ACCESS_TOKEN: "ACCESS_TOKEN"
};

export default Constants;