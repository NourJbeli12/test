package com.ontech.OBS.user.voiture;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDate;
    @Service
    public class CarService {

        private final VoitureRepositroy  voitureRepository;

        @Autowired
        public CarService(VoitureRepositroy  voitureRepository) {
            this.voitureRepository = voitureRepository;
        }

        public List<Voiture> getAllCars() {
            return voitureRepository.findAll();
        }

        public Voiture getCarById(Integer id) {
            return voitureRepository.findById(id).orElse(null);
        }

        public Voiture createCar(Voiture car) {
            return voitureRepository.save(car);
        }

        public Voiture updateCar(Integer id, Voiture updatedCar) {
            Voiture existingCar = voitureRepository.findById(id).orElse(null);
            if (existingCar != null) {
                // Update existing car properties
                existingCar.setModel(existingCar.getModel());
                existingCar.setMatricule(existingCar.getMatricule());
                existingCar.setCarburant(existingCar.getCarburant());
                existingCar.setCouleur(existingCar.getCouleur());
                existingCar.setNum_chase(existingCar.getNum_chase());

                // Update other properties as needed
                return voitureRepository.save(existingCar);
            }
            return null;
        }

        public boolean deleteCar(Integer id) {
            // Use the instance of VoitureRepository to call findById(ID) method
            Voiture existingCar = voitureRepository.findById(id).orElse(null);
            if (existingCar != null) {
                voitureRepository.delete(existingCar);
                return true;
            }
            return false;
        }

   /* public boolean reserveCar(Integer id) {
        // Retrieve the car by ID
        Optional<Voiture> carOptional = voitureRepository.findById(id);

        // Check if the car exists
        if (carOptional.isPresent()) {
            Voiture car = carOptional.get();
            // Perform the reservation logic here
            // For example, update the car status to reserved
            car.setStatus("Reserved");
            voitureRepository.save(car);
            return true;
        } else {
            // Car not found
            return false;
        }
    }

    public List<Voiture> getReservedVoitures() {
        // Retrieve all cars from the repository
        List<Voiture> allVoitures = voitureRepository.findAll();

        // Filter the list to only include reserved cars
        List<Voiture> reservedVoitures = allVoitures.stream()
                .filter(voiture -> "Reserved".equals(voiture.getStatus())) // Assuming status "Reserved" indicates a reserved car
                .collect(Collectors.toList());

        return reservedVoitures;
    }

    public boolean isCarAvailableOnDate(Integer id, String dateString) {
        // Parse the date string to LocalDate
        LocalDate date = LocalDate.parse(dateString);

        // Retrieve the car by ID
        Optional<Voiture> carOptional = voitureRepository.findById(id);

        // Check if the car exists
        if (carOptional.isPresent()) {
            Voiture car = carOptional.get();
            // Perform the logic to check if the car is available on the specified date
            // For example, check if the car is not reserved on the specified date
            // You need to implement your own logic here based on your application's requirements
            // This could involve querying a reservation database or checking a schedule
            return true; // Placeholder return statement
        } else {
            // Car not found
            return false;
        }
    }*/


    }

