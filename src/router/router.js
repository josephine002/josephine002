import { createRouter, createWebHistory } from 'vue-router'
import Posts from '@/views/Posts.vue'
import AddPost from '@/views/AddPost.vue'
import EditPost from '@/views/EditPost.vue'

const routes = [
    {
        path: '/',
        name: 'Posts',
        component: Posts
    },
    {
        path: '/add-post',
        name: 'AddPost',
        component: AddPost
    },
    {
        path: '/edit-post/:id', 
        name: 'EditPost',
        component: EditPost
    }
]
const router = createRouter({
    history: createWebHistory(),
    routes
})