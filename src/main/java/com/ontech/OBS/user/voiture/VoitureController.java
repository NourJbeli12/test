package com.ontech.OBS.user.voiture;



        import lombok.RequiredArgsConstructor;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.security.access.prepost.PreAuthorize;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/voiture")
public class VoitureController {
    @Autowired
    private CarService carService;

    @PostMapping
    @PreAuthorize("hasAuthority('car:create')")
    public ResponseEntity<Voiture> createCar(@RequestBody Voiture car) {
        Voiture voiture = convertToEntity(car);

        // Call CarService to create the car
        Voiture createdCar = carService.createCar(voiture);

        // Check if the car was successfully created
        if (createdCar != null) {
            return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Helper method to convert CarDto to voiture entity
    private Voiture convertToEntity(Voiture car) {
        Voiture voiture = new Voiture();
        voiture.setModel(car.getModel());
        voiture.setMatricule(car.getMatricule());
        voiture.setCarburant(car.getCarburant());
        voiture.setCouleur(car.getCouleur());
        voiture.setNum_chase(car.getNum_chase());

        // Set other properties as needed
        return voiture;
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('voiture:read')")
    public ResponseEntity<Voiture> getCar(@PathVariable Integer id) {
        // Call CarService to retrieve the car by ID
        Voiture car = carService.getCarById(id);

        // Check if the car exists
        if (car != null) {
            return new ResponseEntity<>(car, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /*
        @PutMapping("/{id}")
        @PreAuthorize("hasAuthority('voiture:update')")
        public ResponseEntity<voiture> updateCar(@PathVariable Long id, @RequestBody CarDto carDto) {
            // Implementation to update a car
        }

    /*


     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('voiture:update')")
    public ResponseEntity<Voiture> updateCar(@PathVariable Integer id, @RequestBody Voiture carDto) {
        // Convert CarDto to voiture entity
        Voiture updatedCarEntities = convertToEntity(carDto);

        // Call CarService to update the car
        Voiture updatedCar = carService.updateCar(id, updatedCarEntities);

        // Check if the car was successfully updated
        if (updatedCar != null) {
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Helper method to convert CarDto to voiture entity
    private Voiture convertToEntities(Voiture carDto) {
        Voiture car = new Voiture();
        car.setModel(carDto.getModel());
        car.setMatricule(carDto.getMatricule());
        car.setCarburant(carDto.getCarburant());
        car.setCouleur(carDto.getCouleur());
        car.setNum_chase(carDto.getNum_chase());

        // Set other properties as needed
        return car;
    }
/*
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('voiture:delete')")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        // Implementation to delete a car
    }



 */
}