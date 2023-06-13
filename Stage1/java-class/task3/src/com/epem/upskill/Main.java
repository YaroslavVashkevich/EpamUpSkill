package com.epem.upskill;

//3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы,
// успеваемость (массив из пяти элементов). Создайте массив из десяти элементов такого типа.
// Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.

public class Main {
    public static void main(String[] args) {
        Student[] people = new Student[10];
        people[0] = new Student("Рыбаков Аверкий Лукьянович", "1", new int[]{3, 8, 7, 2, 9});
        people[1] = new Student("Орлов Юстиниан Михайлович", "3", new int[]{6, 8, 5, 10, 9});
        people[2] = new Student("Трофимова Крис Платоновна", "2", new int[]{7, 9, 3, 4, 5});
        people[3] = new Student("Копылова Ядвига Аристарховна", "1", new int[]{9, 9, 10, 9, 9});
        people[4] = new Student("Сидоров Устин Лаврентьевич", "2", new int[]{8, 7, 6, 9, 7});
        people[5] = new Student("Кузьмина Златослава Федотовна", "3", new int[]{5, 8, 7, 9,});
        people[6] = new Student("Панфилов Филипп Глебович", "3", new int[]{5, 6, 7, 9, 8});
        people[7] = new Student("Зыков Глеб Владленович", "2", new int[]{10, 9, 9, 10, 10});
        people[8] = new Student("Доронина Карина Прокловна", "1", new int[]{9, 6, 7, 8, 7});
        people[9] = new Student("Жукова Генриетта Германновна", "1", new int[]{6, 8, 10, 7, 9});
        print(people);
    }

    public static void print(Student[] people) {
        for (Student human : people) {
            int count = 0;
            for (int grades : human.getGrades()) {
                if (grades == 9 || grades == 10) {
                    count++;
                }
            }
            if (count == 5) {
                System.out.println(human.getName() + " group № " + human.getGroup() + " has only 9 and 10.");
            }
        }
    }
}
