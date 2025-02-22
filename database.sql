CREATE DATABASE pet_shelter;
USE pet_shelter;

CREATE TABLE pets (
    pet_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    breed VARCHAR(100),
    age INT,
    is_adopted BOOLEAN DEFAULT FALSE
);

INSERT INTO pets (name, breed, age, is_adopted) VALUES 
('Buddy', 'Golden Retriever', 3, FALSE),
('Milo', 'Beagle', 2, TRUE),
('Luna', 'Persian Cat', 4, FALSE);
