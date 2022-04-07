package me.frankvanpaassen.customitems;

public class prices {

    public static boolean isupgradeable_lucky(int x, int y) {
        return x + y <= 3000;
    }

    public static boolean isupgradeable_demolish(int x, int y) {
        return x + y <= 300;
    }

    public static boolean isupgradeable_fortune(int x, int y) {
        return x + y <= 100000;
    }

    public static boolean isupgradeable_efficiency(int x, int y) {
        return x + y <= 100000;
    }

    public static boolean isupgradeable_fracture(int x, int y) {
        return x + y <= 300;
    }


    public static int luckyPrice(int x, int y) {
        int price = 0;
        int w = x + y;
        while (x <= w) {
            price += (100 + (x * x * x));
            x += 1;
        }
        return price;

    }

    public static int demolishPrice(int x, int y) {
        int price = 0;
        int w = x + y;
        while (x <= w) {
            price += (100 + (x * x * x));
            x += 1;
        }
        return price;

    }

    public static int fortunePrice(int x, int y) {
        int price = 0;
        int w = x + y;
        while (x <= w) {
            price += Math.sqrt((100 + (x * 0.5 * x * x)));
            x += 1;
        }
        return price;
    }

    public static int efficiencyPrice(int x, int y) {
        int price = 0;
        int w = x + y;
        while (x <= w) {
            price += Math.sqrt((100 + (x * 100)));
            x += 1;
        }
        return price;
    }

    public static int fracturePrice(int x, int y) {
        int price = 0;
        int w = x + y;
        while (x <= w) {
            price += Math.sqrt(x * x * 100);
            x += 1;
        }
        return price;
    }

}
