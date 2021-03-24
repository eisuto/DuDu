<template>
    <div @click="fn">
        {{ racData }}
        <RouterView />
    </div>
</template>

<script lang="ts">
import { defineComponent, reactive } from 'vue';

export default defineComponent(function App() {
    const racData: number[] = reactive([]);

    const fn = () => {
        racData.push(Math.random());
    };

    return { racData, fn };
});
</script>

<style lang="stylus"></style>
