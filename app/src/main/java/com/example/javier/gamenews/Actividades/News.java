package com.example.javier.gamenews.Actividades;

public class News {
        private String imagenes;
        private String titulo;
        private String titulo2;
        private boolean favoritas;
        private int id;


        public News(String imagenes,String titulo, String titulo2, boolean favoritas, int id){
            this.imagenes = imagenes;
            this.titulo = titulo;
            this.titulo2 = titulo2;
            this.favoritas = favoritas;
            this.id = id;
        }
        //Setters y Getters
        public String getImagenes(){
            return imagenes;
        }

        public void setImagenes(String imagenes){
            this.imagenes = imagenes;
        }

        public String getTitulo(){
            return titulo;
        }

        public void setTitulo(String titulo){
            this.titulo = titulo;
        }

        public String getTitulo2(){
            return titulo2;
        }

        public void setTitulo2(String titulo2){
            this.titulo2 = titulo2;
        }

        public boolean isFavoritas(){
            return favoritas;
        }

        public void setFavoritas(){
            this.favoritas = favoritas;
        }

        public int getId(){
            return id;
        }

        public void setId(){
            this.id = id;
        }

    }
