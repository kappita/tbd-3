import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Registro from '@/views/Registro.vue'
import Emergencias from '@/views/Emergencias.vue'
import Postulacion from '@/views/Postulacion.vue'
import Login from '@/views/Login.vue'
import Habilidades from '@/views/Habilidades.vue'
import VoluntariosCercanos from '@/views/VoluntariosCercanos.vue'
import DashboardAdmin from '@/views/Dashboard-admin.vue'
import HabilidadesAdmin from '@/views/Habilidades-admin.vue'
import Voluntarios from '@/views/Voluntarios.vue'
import Dashboard from '@/views/Dashboard.vue';




const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/inscribete',
      name: 'inscribete',
      component: () => import('../views/Inscribete.vue')
    },
    {
      path: '/registro',
      name: 'registro',
      component: Registro
    },
    {
      path: '/emergencias',
      name: 'emergencias',
      component: Emergencias
    },
    {
      path: '/postulaciones',
      name: 'postulaciones',
      component: Postulacion
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/habilidades',
      name: 'Habilidades',
      component: Habilidades
    },
    {
      path: '/cercanos',
      name: 'Voluntarios cercanos',
      component: VoluntariosCercanos
    },
    {
      path: '/dashboard',
      name: 'dashboard',
      component: Dashboard
    },
    {
      path: '/dashboard-admin',
      name: 'dashboard-admin',
      component: DashboardAdmin
    },
    {
      path: '/habilidades-admin',
      name: 'habilidades-admin',
      component: HabilidadesAdmin
    },
    {
      path: '/voluntarios',
      name: 'voluntarios',
      component: Voluntarios
    },
  ]
})

export default router
