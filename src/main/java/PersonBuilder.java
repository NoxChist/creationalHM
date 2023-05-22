import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected OptionalInt age;
    protected String address;

    protected PersonBuilder() {
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age > -1) {
            this.age = OptionalInt.of(age);
        } else throw new IllegalArgumentException("Age cannot be a negative number");
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name != null && surname != null) {
            return new Person(name, surname, age.orElse(-1), address);
        }
        throw new IllegalStateException("Can't create a person without NAME or SURNAME!");
    }
}
