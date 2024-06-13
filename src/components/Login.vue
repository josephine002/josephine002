<template>
    <div class="login-container">
        <h2>Login</h2>
        <form @submit.prevent="login">
            <div>
                <label for="username">Username:</label>
                <input type="text" v-model="username" required>
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" v-model="password" required>
            </div>
            <button type="submit">Login</button>
            <p v-if="error">{{ error }}</p>
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            username: '',
            password: '',
            error: ''
        };
    },
    methods: {
        login() {
            const users = [
                { username: 'user1', password: 'password1' },
                { username: 'user2', password: 'password2' }
            ];
            const user = users.find(u => u.username === this.username && u.password === this.password);
            if (user) {
                this.$emit('login-success', user);
            } else {
                this.error = 'Username or password is incorrect';
            }
        }
    }
};
</script>

<style scoped>
.login-container {
    max-width: 300px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

form div {
    margin-bottom: 10px;
}

button {
    display: block;
    width: 100%;
}
</style>