const { merge } = require("webpack-merge");
const common = require("./webpack.common.js");

module.exports = merge(common, {
  mode: "development",
  devtool: "inline-source-map",
  devServer: {
    port: 3000,
    contentBase: "./public",
    historyApiFallback: true,
    proxy: {
      "/api": {
        target: "http://localhost:9090",
        secure: false,
        changeOrigin: true,
        pathRewrite: { "^/api": "" },
      },
    },
  },
});
