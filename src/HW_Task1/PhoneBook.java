/*Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
Пусть дан список сотрудников:
        Иван Иванов
        Светлана Петрова
        Кристина Белова
        Анна Мусина
        Анна Крутова
        Иван Юрин
        Петр Лыков
        Павел Чернов
        Петр Чернышов
        Мария Федорова
        Марина Светлова
        Мария Савина
        Мария Рыкова
        Марина Лугова
        Анна Владимирова
        Иван Мечников
        Петр Петин
        Иван Ежов
Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.*/
package HW_Task1;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, String[]> phoneBook = new HashMap<>();
        phoneBook.put("Иван Иванов", new String[]{"+7(111)111-11-11", "+7(222)222-22-22"});
        phoneBook.put("Светлана Петрова", new String[]{"+7(333)333-33-33"});
        phoneBook.put("Кристина Белова", new String[]{"+7(444)444-44-44"});
        phoneBook.put("Анна Мусина", new String[]{"+7(555)555-55-55"});
        phoneBook.put("Анна Крутова", new String[]{"+7(666)666-66-66"});
        phoneBook.put("Иван Юрин", new String[]{"+7(777)777-77-77"});
        phoneBook.put("Петр Лыков", new String[]{"+7(888)888-88-88"});
        phoneBook.put("Павел Чернов", new String[]{"+7(999)999-99-99"});
        phoneBook.put("Петр Чернышов", new String[]{"+7(000)000-00-00"});
        phoneBook.put("Мария Федорова", new String[]{"+7(111)111-11-11"});
        phoneBook.put("Марина Светлова", new String[]{"+7(222)222-22-22"});
        phoneBook.put("Мария Савина", new String[]{"+7(333)333-33-33"});
        phoneBook.put("Мария Рыкова", new String[]{"+7(444)444-44-44"});
        phoneBook.put("Марина Лугова", new String[]{"+7(555)555-55-55"});
        phoneBook.put("Анна Владимирова", new String[]{"+7(666)666-66-66"});
        phoneBook.put("Иван Мечников", new String[]{"+7(777)777-77-77"});
        phoneBook.put("Петр Петин", new String[]{"+7(888)888-88-88"});
        phoneBook.put("Иван Ежов", new String[]{"+7(999)999-99-99"});

        Map<String, Long> nameCount = phoneBook.keySet().stream()
                .map(name -> name.split(" ")[0])
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));

        nameCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}

