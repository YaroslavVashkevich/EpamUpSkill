package com.epam.upskill;

//3. Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль столицу,
// количество областей, площадь, областные центры.

public class Main {
    public static void main(String[] args) {
        State state = new State("Беларусь", new Region("Гомельская", 40372, new District("Гомельский", new City("Гомель"))),
                new Region("Брестская ", 32786, new District("Брестский", new City("Брест"))),
                new Region("Могилевская", 29068, new District("Могилевский", new City("Могилев"))),
                new Region("Гродненская", 25127, new District("Годненский", new City("Гродно"))),
                new Region("Минская", 40202, new District("Минский", new City("Минск", true))),
                new Region("Витебская", 40051, new District("Витебский", new City("Витебск"))));

        state.printCapital();
        state.printNumberRegion();
        state.printStateArea();
        state.printRegionalCenter();

    }

}
