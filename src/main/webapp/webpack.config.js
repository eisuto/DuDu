const path = require('path');

module.exports = {
    devtool: 'source-map',
    resolve: {
        alias: {
            '@utils': path.resolve(__dirname, 'src/utils'),
            '@views': path.resolve(__dirname, 'src/views'),
            '@assets': path.resolve(__dirname, 'src/assets'),
            '@components': path.resolve(__dirname, 'src/components')
        }
    }
};
