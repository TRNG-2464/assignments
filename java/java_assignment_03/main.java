class BadTickException extends Exception {
    String message;
    public BadTickException(String message) {
        this.message = message;
    }
}

class BadColorException extends Exception {
    String message;
    public BadColorException(String message) {
        this.message = message;
    }
}

public class main {

    static String getNextColor(String color) {
        switch (color) {
            case "Green": return "Yellow";
            case "Yellow": return "Red";
            case "Red": return "Green";
        }
        return color;
    }


    static void colorTick(String startColor, int ticks) {
        if (ticks < 0) {
            System.out.println("Invalid input: tick count cannot be negative.");
            return;
        }


        String color = startColor;

        switch (color) {
            case "Green": case "Yellow": case "Red": break;

            default:
            System.out.println("Invalid input: '" + color + "' is not a recognized light color.");
            return;
        }


        for (int i = 0; i < ticks; i++) {
            color = getNextColor(color);
        }

        System.out.println(color);
    }

    static String[] cycleLog(String startColor, int ticks) {
        String[] cycle = new String[ticks];

        String color = startColor;

        for (int i = 0; i < ticks; i++) {
            color = getNextColor(color);
            cycle[i] = color;
        }
        return cycle;
    }


    static void colorDuration(String startColor, int ticks) {
        String color = startColor;

        if (ticks < 0) {
            System.out.println("Invalid input: tick count cannot be negative.");
            return;
        }

        int greenTicks = 3;
        int yellowTicks = 1;
        int redTicks = 2;

        switch (color) {
            case "Green": case "Yellow": case "Red": break;

            default:
            System.out.println("Invalid input: '" + color + "' is not a recognized light color.");
            return;
        }

        outer:
        while (ticks > 0) {
            switch (color) {
            case "Green":
                if (greenTicks < ticks) {
                    ticks -= greenTicks;
                    color = "Yellow";
                } else {
                    break outer;
                }
                break;
            case "Yellow":
                if (yellowTicks < ticks) {
                    ticks -= yellowTicks;
                    color = "Red";
                } else {
                    break outer;
                }
                break;
            case "Red":
                if (redTicks < ticks) {
                    ticks -= redTicks;
                    color = "Green";
                } else {
                    break outer;
                }
                break;
            }
        }

        System.out.println(color);
    }

    static void exceptionColor(String startColor, int ticks) throws BadTickException, BadColorException {
        if (ticks < 0) {
            throw new BadTickException("Invalid input: Tick count cannot be negative");
        }


        String color = startColor;

        switch (color) {
            case "Green": case "Yellow": case "Red": break;

            default:
                throw new BadColorException("Invalid input: '" + color + "' is not a recognized light color.");
        }


        for (int i = 0; i < ticks; i++) {
            color = getNextColor(color);
        }

        System.out.println(color);
    }

    public static void main(String[] args) {
        // colorTick("Red", 5);
        // String[] colors = cycleLog("Green", 4);
        // for (String color : colors) {
        //     System.out.println(color);
        // }
        // colorDuration("Red", 4);


        try {
            exceptionColor("Purple", -1);
        } catch (BadTickException e) {
            System.out.println(e.message);
            e.printStackTrace();
        } catch (BadColorException e) {
            System.out.println(e.message);
            e.printStackTrace();
        }
    }
}
