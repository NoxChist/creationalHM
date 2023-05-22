import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname) {
        this(name, surname, -1, null);
    }

    public Person(String name, String surname, int age) {
        this(name, surname, age, null);
    }

    public Person(String name, String surname, int age, String address) {
        if (name != null && surname != null) {
            this.name = name;
            this.surname = surname;
        } else {
            throw new NullPointerException();
        }
        if (age > -1) {
            this.age = OptionalInt.of(age);
        } else {
            this.age = OptionalInt.empty();
        }
        this.address = address;
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return (address != null) ? true : false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of((age.getAsInt()) + 1);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAge(0).setAddress(address);
    }

    @Override
    public String toString() {
        StringBuilder pers = new StringBuilder();
        pers.append(String.format("Name: %s %s\n", surname, name));
        if (age.isPresent()) {
            pers.append((String.format("Age: %d\n", age.getAsInt())));
        }
        if (address != null) {
            pers.append("Address: " + address);
        }
        return pers.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
