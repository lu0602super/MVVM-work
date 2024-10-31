<template>
  <div id="app">
    <table id="myTable">
      <thead>
        <tr>
          <th>姓名</th>
          <th>年龄</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(person, index) in sortedPeople" :key="person.name">
          <td>{{ person.name }}</td>
          <td>{{ person.age }}</td>
          <td><button @click="deletePerson(index)">删除</button></td>
        </tr>
      </tbody>
    </table>
    <input type="text" v-model="newName" placeholder="姓名" />
    <input type="number" v-model="newAge" placeholder="年龄" />
    <button @click="addPerson" class="add-button">添加数据</button>
  </div>
</template>
  
  <script>
  export default {
    data() {
      return {
        people: [],
        newName: '',
        newAge: ''
      };
    },
    computed: {
      sortedPeople() {
        return this.people.slice().sort((a, b) => a.age - b.age);
      }
    },
    methods: {
      addPerson() {
        if (this.newName && this.newAge) {
          this.people.push({ name: this.newName, age: parseInt(this.newAge) });
          this.newName = '';
          this.newAge = '';
        }
      },
      deletePerson(index) {
        this.people.splice(index, 1);
      }
    }
  };
  </script>
  
  <style scoped>
table {
  width: 50%;
  border: 1px solid #ddd;
}

th {
  background-color: #dfeefd;
  text-align: left;
  padding: 8px; 
  font-weight: normal;
  border-bottom: 1px solid #ddd;
}

td {
  text-align: left;
  border-bottom: 1px solid #ddd;
}


tr:nth-child(odd) {
  background-color: #eee;
}

tr:nth-child(even) {
  background-color: #fff;
}

.add-button {
  margin-top: 20px;
  margin-left: 5px;
}

input[type="text"], input[type="number"] {
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
  margin-right: 5px;
  width: 225px;
}

button {
  padding: 8px;
  background-color: #f2f2f2;
  border-radius: 4px;
  border: 1px solid #ddd;
  cursor: pointer;
  color: #000000;
}

button:hover {
  background-color: #ddd;
}
  </style>