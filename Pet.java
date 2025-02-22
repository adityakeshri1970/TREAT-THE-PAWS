public class Pet {
    private int petId;
    private String name;
    private String breed;
    private int age;
    private boolean isAdopted;

    public Pet(int petId, String name, String breed, int age, boolean isAdopted) {
        this.petId = petId;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.isAdopted = isAdopted;
    }

    public void displayPet() {
        System.out.println("Pet ID: " + petId + ", Name: " + name + ", Breed: " + breed + 
                           ", Age: " + age + ", Adopted: " + isAdopted);
    }
}
