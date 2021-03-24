<template>
    <div class="text-center">
        <form class="form-signin">
            <img
                class="mb-4"
                src="../assets/bootstrap-solid.svg"
                alt=""
                width="72"
                height="72"
            />
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input
                autocomplete="username"
                type="email"
                id="inputEmail"
                class="form-control"
                placeholder="Email address"
                required=""
                autofocus=""
            />
            <label for="inputPassword" class="sr-only">Password</label>
            <input
                autocomplete="current-password"
                type="password"
                id="inputPassword"
                class="form-control"
                placeholder="Password"
                required=""
            />
            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me" /> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">
                Sign in
            </button>
            <button type="button" @click="login">快速登录</button>
            <p class="mt-5 mb-3 text-muted">© 2017-2019</p>
        </form>
    </div>
</template>

<script>
import axios from 'axios';
import { defineComponent } from 'vue';

export default defineComponent({
    name: 'Login',
    methods: {
        login() {
            axios
                .post(
                    '/doLogin',
                    'username=hello&password=world&remember-me=true'
                )
                .then(
                    res => {
                        console.log(res);
                        this.$router.back();
                    },
                    rej => {
                        console.log(rej);
                    }
                );
        }
    }
});
</script>
