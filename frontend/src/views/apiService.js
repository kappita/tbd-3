import axios from 'axios';
import { userJwt } from '@/store/store';

const API_URL = 'http://localhost:8080';

export const obtenerHabilidades = () => {
  return axios.get(`${API_URL}/habilidades`, {
    headers: {
      Authorization: "Basic " + userJwt.value
    }
  });
};
