package class_property;

public class JavaCoffee {

    private boolean isIced;

    public boolean isIced() {
        return isIced;
    }

    public void setIced(boolean iced) {
        isIced = iced;
    }

    public static class Main {
        public static void main(String[] args) {
            JavaCoffee javaCoffee = new JavaCoffee();
            javaCoffee.setIced(true);

            if (javaCoffee.isIced()) {
                System.out.println("아이스 아메리카노");
            }
        }
    }
}

