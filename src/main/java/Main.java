import Model.Doctor;
import Model.DoctorServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DoctorServiceImpl doctorService = new DoctorServiceImpl();

        Doctor newDoctor = new Doctor(0, "John", "Doe", "Cardiology", "123-456-7890", "john.doe@example.com", 1);
        doctorService.addDoctor(newDoctor);
        System.out.println("Doctor agregado: " + newDoctor.getFirstName() + " " + newDoctor.getLastName());

        // Obtener y mostrar todos los doctores
        System.out.println("\nLista de doctores:");
        List<Doctor> doctors = doctorService.getAllDoctors();
        for (Doctor doctor : doctors) {
            System.out.println("ID: " + doctor.getDoctorId() + ", Name: " + doctor.getFirstName() + " " + doctor.getLastName() +
                    ", Specialization: " + doctor.getSpecialization() + ", Phone: " + doctor.getPhone() +
                    ", Email: " + doctor.getEmail() + ", Department ID: " + doctor.getDepartmentId());
        }

        // Actualizar un doctor
        if (!doctors.isEmpty()) {
            Doctor firstDoctor = doctors.get(0);
            firstDoctor.setPhone("987-654-3210");
            doctorService.updateDoctor(firstDoctor);
            System.out.println("\nDoctor actualizado: " + firstDoctor.getFirstName() + " " + firstDoctor.getLastName() +
                    ", nuevo teléfono: " + firstDoctor.getPhone());
        }

        // Eliminar un doctor (por ejemplo, el primer doctor en la lista)
        if (!doctors.isEmpty()) {
            int doctorIdToDelete = doctors.get(0).getDoctorId();
            doctorService.deleteDoctor(doctorIdToDelete);
            System.out.println("\nDoctor eliminado con ID: " + doctorIdToDelete);
        }

        // Muestra la lista actualizada de doctores
        System.out.println("\nLista de doctores después de la eliminación:");
        doctors = doctorService.getAllDoctors();
        for (Doctor doctor : doctors) {
            System.out.println("ID: " + doctor.getDoctorId() + ", Name: " + doctor.getFirstName() + " " + doctor.getLastName());
        }
    }
}