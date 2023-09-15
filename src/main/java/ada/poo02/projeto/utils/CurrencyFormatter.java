package ada.poo02.projeto.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
    private CurrencyFormatter() {}
    private static final NumberFormat brazilianFormat =
            NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    public static String formatCurrency(double price) {
        return brazilianFormat.format(price);
    }
}
