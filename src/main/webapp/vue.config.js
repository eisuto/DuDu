const path = require('path');

module.exports = {
    // 将前端项目打包生产到 springboot 静态资源目录中
    outputDir: path.resolve(__dirname, '../resources/static'),
    configureWebpack: require('./webpack.config.js'),
    // 开发服务器并配置代理
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8080',
                pathRewrite: { '^/api': '' }
            }
        },
        port: 3000 /*
          前端请求：http://localhost:3000/api/user',
          代理请求：http://localhost:8080/user',    pathRewrite 配置重写了路径
      */
    }
};
