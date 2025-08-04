package softuni.exam.service;

import softuni.exam.entities.Car;

import java.io.IOException;

public interface CarService {

    boolean areImported();

    String readCarsFileContent() throws IOException;
	
	String importCars() throws IOException;

    String exportCars();

    Car getReferenceById(Long id);
}
