<template>
    <div class="sidebar">
        <input type="search" placeholder="Cerca nel blog..." v-model="searchQuery" @input="filterPosts">
        <button @click="mostraAggiungiPost">Aggiungi Post</button>
        <ul class="post-list">
            <li v-for="post in filteredPosts" :key="post.title">
                <a @click.prevent="selectPost(post)">{{ post.title }}</a>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    props: {
        posts: Array
    },
    data() {
        return {
            searchQuery: '',
            filteredPosts: []
        };
    },
    methods: {
        mostraAggiungiPost() {
            // Implementa la logica per aggiungere un nuovo post
        },
        filterPosts() {
            this.filteredPosts = this.posts.filter(post => {
                return post.title.toLowerCase().includes(this.searchQuery.toLowerCase());
            });
        },
        selectPost(post) {
            this.$emit('post-selected', post);
        }
    },
    watch: {
        searchQuery() {
            this.filterPosts();
        }
    },
    mounted() {
        this.filterPosts();
    }
};
</script>

<style scoped>
.sidebar {
    flex-basis: 200px;
    background-color: #fdde63dd;
    padding: 20px;
    border: 1px solid #ccc;
}

.post-list {
    list-style: none;
    margin: 0;
    padding: 0;
}

.post-list li {
    margin-bottom: 10px;
}

.post-list a {
    text-decoration: none;
    color: #333;
    cursor: pointer;
}
</style>