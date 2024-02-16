import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        double value = 0.012;
        double sum = value + value + value;
        System.out.println("sum = " + sum);

        //TIP BigDecimal is used to handle precision problems.

        BigDecimal bigDecimalSum = new BigDecimal(String.valueOf(value));
        bigDecimalSum = bigDecimalSum.add(BigDecimal.valueOf(value)).add(BigDecimal.valueOf(value));
        System.out.println("bigDecimalSum = " + bigDecimalSum);

    }
}
