package com.ontech.OBS.user.voiture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

    @Entity
    @Table(name = "voiture")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Voiture {
        @Id
        @GeneratedValue

        private Integer id ;


        /*@ManyToOne
        @JoinColumn(name = "user_id")
         private User user;*/
        private String model ;
        private String couleur ;
        private String Carburant;
        private String matricule;
        private String num_chase;

        //public String getStatus() {return status;}
       /* @OneToMany(mappedBy = "voiture")
        private Collection<Reservation> reservations;*/

        public void setStatus(String status) {
            this.status = status;
        }

        private String status;
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getCouleur() {
            return couleur;
        }

        public void setCouleur(String couleur) {
            this.couleur = couleur;
        }

        public String getCarburant() {
            return Carburant;
        }

        public void setCarburant(String carburant) {
            Carburant = carburant;
        }

        public String getMatricule() {
            return matricule;
        }

        public void setMatricule(String matricule) {
            this.matricule = matricule;
        }

        public String getNum_chase() {
            return num_chase;
        }

        public void setNum_chase(String num_chase) {
            this.num_chase = num_chase;
        }
    }
