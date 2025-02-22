import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    public void addPet(String name, String breed, int age, boolean isAdopted) {
        String query = "INSERT INTO pets (name, breed, age, is_adopted) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, breed);
            pstmt.setInt(3, age);
            pstmt.setBoolean(4, isAdopted);
            pstmt.executeUpdate();
            System.out.println("Pet added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        String query = "SELECT * FROM pets";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                pets.add(new Pet(rs.getInt("pet_id"), rs.getString("name"), 
                                 rs.getString("breed"), rs.getInt("age"), rs.getBoolean("is_adopted")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    public void updateAdoptionStatus(int petId, boolean isAdopted) {
        String query = "UPDATE pets SET is_adopted = ? WHERE pet_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBoolean(1, isAdopted);
            pstmt.setInt(2, petId);
            pstmt.executeUpdate();
            System.out.println("Adoption status updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
