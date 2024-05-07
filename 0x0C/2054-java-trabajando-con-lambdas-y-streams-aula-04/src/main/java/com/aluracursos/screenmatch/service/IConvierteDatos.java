package com.aluracursos.screenmatch.service;
//CREADA EN EL VIDEO 1.4
public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
