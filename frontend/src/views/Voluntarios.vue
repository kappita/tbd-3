<template>
    <div>
      <Navbar />
      <div class="voluntarios-main">
        <div class="voluntarios-content">
          <h1>Listado Completo de Voluntarios</h1>
          <div v-if="voluntarios.length">
            <ul>
              <li v-for="voluntario in voluntarios" :key="voluntario.id" class="voluntario-item">
                <div class="voluntario-info">
                  <p class="voluntario-nombre"><strong>Nombre:</strong> {{ voluntario.nombre }}</p>
                  <p class="voluntario-correo"><strong>Correo:</strong> {{ voluntario.email }}</p>
                </div>
              </li>
            </ul>
          </div>
          <div v-else>
            <p>No se encontraron voluntarios.</p>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import Navbar from '@/components/Navbar.vue';
  
  export default {
    components: {
      Navbar
    },
    data() {
      return {
        voluntarios: []
      };
    },
    created() {
      this.fetchVoluntarios();
    },
    methods: {
      fetchVoluntarios() {
        axios.get("http://localhost:8080/voluntarios/getAll")
          .then(response => {
            this.voluntarios = response.data;
          })
          .catch(error => {
            console.error("Hubo un error al obtener los voluntarios:", error);
          });
      }
    }
  };
  </script>
  
  <style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap');
  @import url('https://fonts.googleapis.com/css2?family=Lato:wght@300;400&display=swap');
  
  html, body {
    background-color: #f0f9ff !important;
    color: #101935;
    height: 100%;
    margin: 0;
    padding: 0;
  }
  
  .voluntarios-main {
    background-color: #f0f9ff;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 20px;
    min-height: calc(100vh - 80px);
    padding-top: 80px;
  }
  
  .voluntarios-content {
    background: white;
    padding: 30px;
    border-radius: 15px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 900px;
    text-align: center;
  }
  
  h1 {
    color: #101935;
    font-family: 'Roboto', sans-serif;
    text-align: center;
    margin-bottom: 20px;
    font-weight: bold;
  }
  
  ul {
    list-style-type: none;
    padding: 0;
  }
  
  .voluntario-item {
    background-color: #9ad4d6;
    color: #101935;
    padding: 15px 20px;
    border-radius: 15px;
    font-family: 'Lato', sans-serif;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    margin-bottom: 15px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }
  
  .voluntario-info {
    display: flex;
    flex-direction: column;
    gap: 5px;
  }
  
  .voluntario-nombre {
    font-size: 1.2rem;
    font-weight: bold;
  }
  
  .voluntario-correo {
    font-size: 1.3rem;
    color: #333;
    margin-top: 5px;
    font-weight: normal;
  }
  </style>
  