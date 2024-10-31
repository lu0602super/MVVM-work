<template>
  <div>
    <h1>动态列表管理</h1>
    <ul id="myList">
      <li v-for="(item, index) in items" :key="index">
        <div class="item-text">{{ item.text }}</div>
        <button class="edit-button" @click="editItem(index)">编辑</button>
        <button class="delete-button" @click="deleteItem(index)">删除</button>
      </li>
    </ul>
    <div class="input-content">
      <input type="text" v-model="newItem" placeholder="新项">
      <button @click="addItem">添加项</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items: [],
      newItem: ''
    };
  },
  methods: {
    addItem() {
      if (this.newItem.trim()) {
        this.items.push({ text: this.newItem });
        this.newItem = '';
      }
    },
    deleteItem(index) {
      this.items.splice(index, 1);
    },
    editItem(index) {
      const originalText = this.items[index].text;
      const newText = prompt('编辑内容:', originalText);
      if (newText !== null && newText.trim() !== '') {
        this.items[index].text = newText;
      }
    }
  }
};
</script>

<style scoped>
body {
  font-family: Arial, sans-serif;
  background-color: #f4f4f4;
  margin: 0;
  padding: 20px;
}
h1 {
  text-align: center;
  color: #333;
}
ul {
  list-style-type: none;
  padding: 0;
  max-width: 600px;
  margin: 20px auto;
  background: white;
  border-radius: 5px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}
li {
  padding: 15px;
  border-bottom: 1px solid #ddd;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
li:last-child {
  border-bottom: none;
}
.item-text {
  flex-grow: 1; 
}
.edit-button {
  margin-right: 200px;
}
.delete-button {
  margin-left: auto; 
}
button {
  background-color: #007BFF;
  color: white;
  border: none;
  border-radius: 5px;
  padding: 8px 12px;
  cursor: pointer;
  transition: background-color 0.3s;
}
button:hover {
  background-color: #0056b3;
}
input[type="text"] {
  padding: 10px;
  width: 500px;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin-right: 10px;
}
.input-content {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}
</style>