<template>
    <div>
      <Navbar />
      <div class="dashboard-main">
        <div class="dashboard-header">
          <h1>Panel de Administración</h1>
          <p>Administra los voluntarios y sus habilidades.</p>
        </div>
        <div class="dashboard-content">
          <div class="card" @click="navigateTo('voluntarios')">
            <font-awesome-icon icon="fa-solid fa-users" size="3x" class="icon" />
            <h2>Voluntarios</h2>
            <p>Ver y gestionar todos los voluntarios registrados.</p>
          </div>
          <div class="card" @click="navigateTo('habilidades-admin')">
            <font-awesome-icon icon="fa-solid fa-wrench" size="3x" class="icon" />
            <h2>Habilidades</h2>
            <p>Ver, agregar y gestionar las habilidades disponibles.</p>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import Navbar from '@/components/Navbar.vue';
  import { useRouter } from 'vue-router';
  
  export default {
    components: {
      Navbar
    },
    setup() {
      const router = useRouter();
      const navigateTo = (route) => {
        router.push(`/${route}`);
      };
  
      return { navigateTo };
    }
  };
  </script>
  
  <style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap');
  @import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400&display=swap');
  
  body, html {
    margin: 0;
    padding: 0;
    height: 100%;
  }
  
  .dashboard-main {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: 20px;
    background-color: #f9f9f9;
    min-height: 100vh;
  }
  
  .dashboard-header {
    text-align: center;
    margin-bottom: 20px;
  }
  
  h1, h2 {
    color: #101935;
    font-family: 'Roboto', sans-serif;
    font-size: 2.5rem;
    font-weight: bold;
  }
  
  p {
    color: #555;
    font-family: 'Lato', sans-serif;
    font-size: 1.2rem;
  }
  
  .dashboard-content {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    justify-content: center;
  }
  
  .card {
    background: white;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    width: 300px;
    text-align: center;
    cursor: pointer;
    transition: transform 0.3s, box-shadow 0.3s;
    padding: 20px;
  }
  
  .card:hover {
    transform: translateY(-10px);
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
  }
  
  .card h2 {
    color: #101935;
    font-family: 'Roboto', sans-serif;
    font-size: 1.5rem;
    margin: 10px 0;
  }
  
  .card p {
    color: #555;
    font-family: 'Lato', sans-serif;
    padding: 0 10px 20px;
  }
  
  .icon {
    margin-bottom: 15px;
    color: #9ad4d6;
  }
  </style>
  