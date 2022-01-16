package romanizat.esports.entity;

public enum Gender {
    Male("Male"),
    Female("Female"),
    Other("Other");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
