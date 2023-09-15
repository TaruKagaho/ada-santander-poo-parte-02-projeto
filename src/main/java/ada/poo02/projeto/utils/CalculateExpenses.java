package ada.poo02.projeto.utils;

import java.time.Duration;
import java.time.LocalDateTime;

public class CalculateExpenses {
    private CalculateExpenses() {}

    private static long calculateRates(LocalDateTime startDate, LocalDateTime endDate) {
        long countDays = Duration.between(startDate, endDate).toDaysPart();
        long countHours = Duration.between(startDate, endDate).toHoursPart();
        long countMinutes = Duration.between(startDate, endDate).toMinutesPart();

        if (countHours > 0 || countMinutes > 0) {
            countDays++;
        }

        return countDays;
    }

    // TODO: talvez criar um enum para desconto
    private static double getDiscount(String registrationType, long rates) {
        /*switch (registrationType) {
            case "CPF":
                return 0.05;
            case  "CNPJ":
                return 0.10;
        }*/
        if ("CPF".equalsIgnoreCase(registrationType) && rates > 5) {
            return 0.05;
        } else if ("CNPJ".equalsIgnoreCase(registrationType) && rates > 3) {
            return 0.10;
        }

        return 0.0;
    }

    public static double calculateExpenses(
            LocalDateTime startDate,
            LocalDateTime endDate,
            double pricePerDay,
            String registrationType
    ) {
        long rates = calculateRates(startDate, endDate);
        double discount = getDiscount(registrationType, rates);

        return (pricePerDay * rates) - (pricePerDay * discount);
    }
}
