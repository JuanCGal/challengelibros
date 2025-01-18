package com.galvis.challengelibros.model;

public enum Idioma {
    INGLES("en", "inglés"),
    ESPANIOL("es", "español"),
    FRANCES("fr" , "francés"),
    LATINO("la", "latino");

    private String idiomaGutendex;
    private String idiomaEspaniol;

    Idioma(String idiomaGutendex, String idiomaEspaniol){
        this.idiomaGutendex = idiomaGutendex;
        this.idiomaEspaniol = idiomaEspaniol;
    }

    //Creamos un método para convertir los datos de tipo String a una propiedad de nuestra clase
    // Categoria
    public static Idioma fromGutendex(String text){
        for (Idioma idioma : Idioma.values()){
            if(idioma.idiomaGutendex.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Idioma no encontrado: " + text);
    }

    public static Idioma fromEspaniol(String text){
        for (Idioma idioma : Idioma.values()){
            if(idioma.idiomaEspaniol.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Idioma no encontrado: " + text);
    }
}
