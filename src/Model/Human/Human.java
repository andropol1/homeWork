package Model.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Human implements Serializable {
    private String firstName;
    private String lastName;
    private Sex sex;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String firstName, String lastName, Sex sex, LocalDate birthDate, LocalDate deathDate, Human mother,
                 Human father) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String firstName, String lastName, Sex sex, LocalDate birthDate, LocalDate deathDate) {
        this(firstName, lastName, sex, birthDate, deathDate, null, null);
    }

    public Human(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate) {
        this(firstName, lastName, null, birthDate, deathDate, null, null);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public String getAge() {
        return "продолжительность жизни: " + Period.between(birthDate, deathDate).getYears() + " years";
    }

    public void addChild(Human human) {
        if (!children.contains(human)) {
            children.add(human);
        }
    }

    public String getMotherInfo() {
        String str = "мать: ";
        if (mother != null) {
            str += mother.getFirstName() + " " + mother.getLastName();
        } else {
            str += "unknown";
        }
        return str;
    }

    public String getFatherInfo() {
        String str = "отец: ";
        if (father != null) {
            str += father.getFirstName() + " " + father.getLastName();
        } else {
            str += "unknown";
        }
        return str;
    }

    public String getChildrenInfo() {
        String str = "дети: ";
        if (children.size() != 0) {
            for (Human child : children) {
                str += child.getFirstName() + " " + child.getLastName() + ", ";
            }
        } else {
            str += "unknown";
        }
        return str.replaceAll(", $", "");
    }

    @Override
    public String toString() {
        return "Имя: " + firstName + " " + lastName + ", пол: " + sex + ", дата рождения: " + birthDate +
                ", дата смерти: " + deathDate + ", " + getAge() + ", " + getMotherInfo() + ", " + getFatherInfo() +
                ", " + getChildrenInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(firstName, human.firstName) && Objects.equals(lastName, human.lastName) &&
                sex == human.sex && Objects.equals(birthDate, human.birthDate) &&
                Objects.equals(deathDate, human.deathDate) && Objects.equals(mother, human.mother) &&
                Objects.equals(father, human.father) && Objects.equals(children, human.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, sex);
    }
}