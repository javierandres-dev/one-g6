// URL base de la API
const baseURL = 'http://localhost:8081';

export default function getDatos(endpoint) {
    return fetch(`${baseURL}${endpoint}`)
        .then(response => response.json())
        .catch(error => {
            console.error('Error al acceder al endpoint /series/phrases', error);
        });
}