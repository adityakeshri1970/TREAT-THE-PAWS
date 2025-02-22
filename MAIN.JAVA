import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PetDAO petDAO = new PetDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Treat The Paws - Pet Management System ===");
            System.out.println("1. Add Pet");
            System.out.println("2. View All Pets");
            System.out.println("3. Update Adoption Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter pet name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter pet breed: ");
                    String breed = scanner.nextLine();
                    System.out.print("Enter pet age: ");
                    int age = scanner.nextInt();
                    System.out.print("Is the pet adopted? (true/false): ");
                    boolean isAdopted = scanner.nextBoolean();
                    petDAO.addPet(name, breed, age, isAdopted);
                    break;

                case 2:
                    List<Pet> pets = petDAO.getAllPets();
                    if (pets.isEmpty()) {
                        System.out.println("No pets found.");
                    } else {
                        for (Pet pet : pets) {
                            pet.displayPet();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter pet ID to update adoption status: ");
                    int petId = scanner.nextInt();
                    System.out.print("Is the pet adopted? (true/false): ");
                    boolean adoptionStatus = scanner.nextBoolean();
                    petDAO.updateAdoptionStatus(petId, adoptionStatus);
                    break;

                case 4:
                    System.out.println("Exiting... Thank you for using Treat The Paws!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
