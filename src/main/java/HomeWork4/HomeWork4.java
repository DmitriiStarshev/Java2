package HomeWork4;

import java.util.HashMap;
import java.util.Map;

public class HomeWork4 {
    public static void main(String[] args) {
        auto();
        staff();
    }

    private static void auto() {
        Map<String, Integer> carStore = new HashMap<>();
        String[] words = {
                "BMW", "Audi", "KIA",
                "Nissan", "Mitsubishi", "Lada",
                "Hyundai", "Renault", "Toyota",
                "KIA", "Nissan", "BMW",
                "Mercedes-Benz", "Volkswagen", "Hammer",
                "Audi", "Volvo", "Cadillac", "Ford"
        };

        for (int i = 0; i < words.length; i++) {
            if (carStore.containsKey(words[i]))
                carStore.put(words[i], carStore.get(words[i]) + 1);
            else
                carStore.put(words[i], 1);
        }
        System.out.println(carStore);
    }

    private static void staff() {
        Staff staff = new Staff();
        staff.add("Smirnov", "+7(925)891-17-01");
        staff.add("Starshev", "+7(925)892-18-02");
        staff.add("Petrov", "+7(925)893-19-03");
        staff.add("Smirnov", "+7(925)891-17-01");
        staff.add("Ivanov", "+7(925)890-10-00");
        staff.add("Petrov", "+7(925)555-55-55");
        staff.add("Kozlov", "+7(925)666-66-66");
        staff.add("Ivanov", "+7(925)898-20-21");

        System.out.println(staff.get("Smirnov"));
        System.out.println(staff.get("Ivanov"));
        System.out.println(staff.get("Starshev"));

    }
}
