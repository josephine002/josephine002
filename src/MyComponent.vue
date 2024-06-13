<template>
    <div>{{ counter }}</div>
    <button @click="counter++">Add</button>
    <div>{{ myVar }}</div>
</template>

<script>
export default{
    props: {
        MyVar: String
    },
    data: function(){
        return{
            counter: 0
        }
    },
    methods: {
        test: function() {
            console.log(this.myVar)
            this.$emit('myEvent',100)
        }
    }
}
</script>