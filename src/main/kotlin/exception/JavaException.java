package exception;

public class JavaException {
    public static void main(String[] args) {

        // 1. Checked Exception
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // 예외 처리
        }
    }
}
