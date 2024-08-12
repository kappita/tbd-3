<template>
  <div>
    <Navbar />
    <div class="habilidades-main">
      <div class="habilidades-content">
        <h1>Gestión de Habilidades</h1>
        <p class="descripcion">Listado de habilidades disponibles en la plataforma.</p>

        <div class="habilidades">
          <h2>Habilidades Existentes:</h2>
          <div class="habilidad-container">
            <div v-for="habilidad in habilidades" :key="habilidad._id" class="habilidad">
              <h3>{{ habilidad.nombre }}</h3>
              <p>{{ habilidad.descripcion }}</p>
            </div>
          </div>
        </div>

        <div class="btn-flotante-container">
          <button @click="mostrarModal = true" class="btn-flotante">
            <span class="tooltip-text">Agregar nueva habilidad</span>
            +
          </button>
        </div>

        <div v-if="mostrarModal" class="modal-overlay" @click.self="cerrarModal">
          <div class="modal">
            <h2>Agregar Nueva Habilidad</h2>
            <form @submit.prevent="agregarHabilidad">
              <div class="form-group">
                <input type="text" v-model="nuevaHabilidad.nombre" placeholder="Nombre de la habilidad" required />
              </div>
              <div class="form-group">
                <textarea v-model="nuevaHabilidad.descripcion" placeholder="Descripción de la habilidad" required></textarea>
              </div>
              <button type="submit" class="btn-agregar">Guardar Habilidad</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from '@/components/Navbar.vue';
import { ref } from 'vue';
import { obtenerHabilidades } from './apiService';
import axios from 'axios';

export default {
  components: {
    Navbar
  },
  setup() {
    const habilidades = ref([]);
    const nuevaHabilidad = ref({
      nombre: '',
      descripcion: ''
    });
    const mostrarModal = ref(false);

    const fetchHabilidades = () => {
      obtenerHabilidades()
        .then(response => {
          habilidades.value = response.data;
        })
        .catch(error => {
          console.error('Error fetching habilidades:', error);
        });
    };

    const agregarHabilidad = () => {
      axios.post('http://localhost:8080/habilidades', nuevaHabilidad.value)
        .then(() => {
          fetchHabilidades();
          nuevaHabilidad.value.nombre = '';
          nuevaHabilidad.value.descripcion = '';
          mostrarModal.value = false;
        })
        .catch(error => {
          console.error('Error agregando habilidad:', error);
        });
    };

    const cerrarModal = () => {
      mostrarModal.value = false;
    };

    fetchHabilidades();

    return {
      habilidades,
      nuevaHabilidad,
      mostrarModal,
      agregarHabilidad,
      cerrarModal
    };
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

.habilidades-main {
  background-color: #f0f9ff;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
  min-height: calc(100vh - 80px);
  padding-top: 80px;
}

.habilidades-content {
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
  margin-bottom: 10px;
  font-weight: bold;
}

p.descripcion {
  color: #555;
  font-family: 'Lato', sans-serif;
  text-align: center;
  margin-bottom: 30px;
  font-size: 1.2rem;
}

h2 {
  color: #101935;
  font-family: 'Roboto', sans-serif;
  text-align: center;
  margin-bottom: 20px;
  font-weight: bold;
}

h3 {
  color: #101935;
  font-family: 'Roboto', sans-serif;
  font-size: 1.5rem;
  margin-bottom: 10px;
  font-weight: bold;
}

.habilidades {
  margin-top: 30px;
}

.habilidad-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 10px;
}

.habilidad {
  background-color: #9ad4d6;
  color: #101935;
  padding: 15px 20px;
  border-radius: 15px;
  font-family: 'Lato', sans-serif;
  font-size: 1rem;
  font-weight: bold;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 400px;
  text-align: left;
}

.habilidad p {
  margin: 5px 0 0;
  font-family: 'Lato', sans-serif;
  color: #333;
  opacity: 1;
  font-size: 1rem;
}

.btn-flotante-container {
  position: fixed;
  bottom: 20px;
  left: 50%;
  transform: translateX(-50%);
}

.btn-flotante {
  background-color: #9ad4d6;
  color: white;
  border: none;
  border-radius: 50%;
  width: 60px;
  height: 60px;
  font-size: 2rem;
  cursor: pointer;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  transition: background-color 0.3s, transform 0.2s;
  position: relative;
}

.btn-flotante:hover {
  background-color: #564787;
  transform: translateY(-2px);
}

.btn-flotante .tooltip-text {
  visibility: hidden;
  width: 160px;
  background-color: #101935;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 5px 0;
  position: absolute;
  z-index: 1;
  bottom: 75px;
  left: 50%;
  transform: translateX(-50%);
  opacity: 0;
  transition: opacity 0.3s;
}

.btn-flotante:hover .tooltip-text {
  visibility: visible;
  opacity: 1;
}

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal {
  background: white;
  padding: 30px;
  border-radius: 15px;
  width: 90%;
  max-width: 500px;
  text-align: center;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.modal h2 {
  margin-bottom: 20px;
  color: #101935;
  font-family: 'Roboto', sans-serif;
  font-size: 1rem¿;
}

.form-group {
  margin-bottom: 20px; 
}

input[type="text"], textarea {
  width: 100%;
  padding: 12px;
  border-radius: 8px;
  border: 1px solid #cccccc;
  font-size: 1rem;
  font-family: 'Lato', sans-serif;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  margin-top: 8px;
}

textarea {
  height: 100px;
  resize: none;
}

input[type="text"]::placeholder, textarea::placeholder {
  color: #999;
}

.btn-agregar {
  background-color: #9ad4d6;
  color: #101935;
  padding: 15px 25px;
  border-radius: 12px;
  font-size: 1.2rem;
  text-decoration: none;
  cursor: pointer;
  display: inline-block;
  border: none;
  transition: background-color 0.3s, transform 0.2s;
  margin-top: 10px;
}

.btn-agregar:hover {
  background-color: #564787;
  color: #f2fdff;
  transform: translateY(-2px);
}

</style>
