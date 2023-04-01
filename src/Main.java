import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        tree.addHuman(new Human("Andrey", "Ivanov", Sex.Male,
                LocalDate.of(1913, 12, 1),  LocalDate.of(1964, 12, 1)));
        tree.addHuman(new Human("Maria", "Ivanova", Sex.Female,
                LocalDate.of(1917,6, 2),LocalDate.of(1975,6, 23)));
        tree.addHuman(new Human("Ivan", "Ivanov", Sex.Male,
                LocalDate.of(1944, 3, 23), LocalDate.of(1996, 6, 2),
                tree.getByName("Maria", "Ivanova"), tree.getByName("Andrey", "Ivanov")));
        tree.addHuman(new Human("Ksenia", "Ivanova", Sex.Female,
                LocalDate.of(1949, 3, 23), LocalDate.of(2000, 7, 6),
                tree.getByName("Maria", "Ivanova"), tree.getByName("Andrey", "Ivanov")));

        System.out.println(tree);
    }
}