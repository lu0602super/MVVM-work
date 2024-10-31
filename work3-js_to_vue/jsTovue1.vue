<template>
    <div id="app">
      <h1>{{ title }}</h1>
      <button @click="toggleTitle">改变标题</button>
      <div id="currentTime" v-if="showTime">{{ currentTime }}</div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'App',
    data() {
      return {
        title: '初始标题',
        currentTime: '',
        isTitleChanged: false,
        showTime: false // 控制是否显示时间
      };
    },
    methods: {
      toggleTitle() {
        this.isTitleChanged = !this.isTitleChanged; // 切换标题改变状态
        if (this.isTitleChanged) {
          this.title = '欢迎来到我的网站';
          this.showTime = true; // 显示时间
        } else {
          this.title = '初始标题';
          this.showTime = false; // 隐藏时间
        }
        this.updateCurrentTime();
      },
      updateCurrentTime() {
        if (this.showTime) {
          // 获取当前日期和时间
          const now = new Date();
          // 格式化日期和时间
          const year = now.getFullYear();
          const month = now.getMonth() + 1; // getMonth() 返回的月份从0开始
          const day = now.getDate();
          const hours = now.getHours();
          const minutes = now.getMinutes();
          const seconds = now.getSeconds();
  
          // 将单个数字前补零
          const padZero = (num) => num < 10 ? '0' + num : num;
  
          // 组合成字符串
          this.currentTime = `${year}/${padZero(month)}/${padZero(day)} ${padZero(hours)}:${padZero(minutes)}:${padZero(seconds)}`;
        } else {
          this.currentTime = ''; // 当不显示时间时，清空时间字符串
        }
      }
    },
    mounted() {
      this.updateCurrentTime();
    }
  };
  </script>
  
  <style scoped>
  #currentTime {
    margin-top: 20px;
  }
  </style>