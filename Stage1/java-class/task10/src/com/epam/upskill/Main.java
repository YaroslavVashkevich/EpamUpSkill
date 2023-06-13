package com.epam.upskill;

//10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
// и метод  toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами.
// Задать критерии выбора данных и вывести эти данные на консоль.
//Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
//Найти и вывести:
//a) список рейсов для заданного пункта назначения;
//b) список рейсов для заданного дня недели;
//c) список рейсов для заданного дня недели, время вылета для которых больше заданного.

public class Main {
    public static void main(String[] args) {
        AirlineArray airlineArray = new AirlineArray(10);

        airlineArray.addAirLine(new Airline("Minsk", 234, "Airbus-А330", "12.25", "Friday"));
        airlineArray.addAirLine(new Airline("Berlin", 35, "Boeing-757", "23.45", "Thursday"));
        airlineArray.addAirLine(new Airline("Moscow", 98, "SSJ-100", "18.20", "Monday"));
        airlineArray.addAirLine(new Airline("Minsk", 131, "Airbus-А380", "08.30", "Monday"));
        airlineArray.addAirLine(new Airline("Paris", 65, "Boeing-747", "06.15", "Saturday"));
        airlineArray.addAirLine(new Airline("Warsaw", 187, "Ту-154", "19.10", "Wednesday"));
        airlineArray.addAirLine(new Airline("Moscow", 211, "Airbus-А330", "10.55", "Sunday"));
        airlineArray.addAirLine(new Airline("Kiev", 108, "Airbus-А380", "15.40", "Tuesday"));
        airlineArray.addAirLine(new Airline("Warsaw", 17, "Boeing-777", "21.10", "Friday"));
        airlineArray.addAirLine(new Airline("Moscow", 147, "Ту-154", "07.25", "Sunday"));
        airlineArray.condition();
    }
}
