package grazioso;

public class Monkey extends RescueAnimal {
    // Attributes specific to the Monkey class
    private String species, tailLength, height, bodyLength;

    // Constructors
    public Monkey(){}

    public Monkey(
    String name, String gender, String age, String weight, 
    String acquisitionDate, String acquisitionCountry,
    String trainingStatus, boolean reserved, String inServiceCountry, 
    String tailLength, String height, String bodyLength, String species) 
    {
        super();
        super.setName(name);
        super.setAnimalType("Monkey"); 
        super.setGender(gender);
        super.setAge(age);
        super.setWeight(weight);
        super.setAcquisitionDate(acquisitionDate);
        super.setAcquisitionLocation(acquisitionCountry);
        super.setTrainingStatus(trainingStatus);
        super.setReserved(reserved);
        super.setInServiceCountry(inServiceCountry);

        this.species = species;
        this.tailLength = tailLength;
        this.height = height;
        this.bodyLength = bodyLength;
    }

    // Accessors (Getters)
    public String getTailLength() {
        return tailLength;
    }

    public String getHeight() {
        return height;
    }

    public String getBodyLength() {
        return bodyLength;
    }

    public String getSpecies() {
        return species;
    }

    // Mutators (Setters)
    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
