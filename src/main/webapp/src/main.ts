import 'bootstrap/dist/css/bootstrap.min.css';

import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import axios from 'axios';

axios.defaults.baseURL = '/api';

document.body.append(
    createApp(App)
        .use(store)
        .use(router)
        .mount(document.createElement('div')).$el
);
