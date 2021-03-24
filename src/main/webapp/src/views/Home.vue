<template>
    <div class="home">
        <div>{{ text }}</div>
    </div>
</template>

<script>
import { defineComponent, ref } from 'vue';

export default defineComponent(function Home() {
    const text = ref('Hello World!');

    return {
        text
    };
});
</script>
