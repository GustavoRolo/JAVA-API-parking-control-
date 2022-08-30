package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {
    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public Object save(ParkingSpotModel parkingSpotModel) {

        return parkingSpotRepository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment,block);
    }

    public List<ParkingSpotModel> findAll() {
        return  parkingSpotRepository.findAll();
    }

    public Optional<ParkingSpotModel> finByid(UUID id) {
        return parkingSpotRepository.findById(id);
    }
    @Transactional

    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }

    //Service é um intermediario entre o controller e o repositories. O controlle chama o service para efetuar alguma mundança ou consulta no banco de dados e o service
    // (possui as dependencias de repository) chama o repository que realzia a alteração

}
