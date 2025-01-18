package com.galvis.challengelibros.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
