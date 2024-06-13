<template>
  <div id="app">
    <router-link to="/new-post">Aggiungi un nuovo post</router-link>
    <Login v-if="!isAuthenticated" @login-success="handleLoginSuccess" />
    <div v-else>
      <Sidebar :posts="posts" @post-selected="showPostDetail" />
      <main>
        <div v-if="selectedPost" class="post-detail">
          <h3>{{ selectedPost.title }}</h3>
          <p>{{ selectedPost.content }}</p>
          <img :src="selectedPost.featuredImage" alt="Post Image">
        </div>
        <div v-else>
          <p>Seleziona un post dalla sidebar per visualizzarlo.</p>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
import Login from './components/Login.vue';
import Sidebar from './components/SideBar.vue';

export default {
  components: {
    Login,
    Sidebar
  },
  data() {
    return {
      isAuthenticated: true,
      posts: [
        {
          title: "Esplorando il Paradiso Terrestre di Bali",
          content: "Bali, l'isola degli dei...",
          featuredImage: "/Bali.jpg.jpg"
        },
        {
          title: "Esplorando le Meraviglie Naturali della Norvegia",
          content: "La Norvegia, con le sue maestose montagne...",
          featuredImage: "/Norvegia.jpg"
        }
      ],
      selectedPost: null
    };
  },
  methods: {
    handleLoginSuccess(user) {
      this.isAuthenticated = true;
      console.log(`User ${user.username} logged in`);
    },
    showPostDetail(post) {
      this.selectedPost = post;
    }
  }
};
</script>

<style scoped>
.app-container {
  display: flex;
}

.post-detail img {
  max-width: 100%;
  height: auto;
  width: 700px;
  display: block;
  margin: 0 auto;
}
</style>