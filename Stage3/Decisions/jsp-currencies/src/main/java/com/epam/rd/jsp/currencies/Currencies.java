package com.epam.rd.jsp.currencies;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Currencies implements Serializable {
    private final Map<String, BigDecimal>   curs = new TreeMap<>();

    public void addCurrency(String currency, BigDecimal weight) {
        curs.put(currency, weight);
    }

    public Collection<String> getCurrencies() {
        return curs.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, BigDecimal> getExchangeRates(String referenceCurrency) {
        return curs.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(toMap(Map.Entry::getKey,
                        getExchangedCurrencyRounded(referenceCurrency)
                                .andThen(bigDecimal -> bigDecimal.setScale(5, RoundingMode.HALF_UP)),
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    private Function<Map.Entry<String, BigDecimal>, BigDecimal> getExchangedCurrencyRounded(String referenceCurrency) {
        return entry -> curs
                .get(referenceCurrency)
                .divide(curs.get(entry.getKey()), 10, RoundingMode.HALF_UP);
    }

    public BigDecimal convert(BigDecimal amount, String sourceCurrency, String targetCurrency) {
        return amount.multiply(converting(sourceCurrency, targetCurrency)).setScale(5, RoundingMode.HALF_UP);
    }

    public BigDecimal converting(String sourceCurrency, String targetCurrency) {
        return curs.entrySet().stream()
                .collect(toMap(Map.Entry::getKey, getExchangedCurrencyRounded(sourceCurrency)))
                .get(targetCurrency);
    }
}
