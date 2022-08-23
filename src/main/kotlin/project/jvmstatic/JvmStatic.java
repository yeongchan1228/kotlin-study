package project.jvmstatic;

public class JvmStatic {
    public static void main(String[] args) {
        System.out.println(HiObject.INSTANCE.hi());
        System.out.println(HelloClass.Companion.hello());

        System.out.println(HiObject.hi());
        System.out.println(HelloClass.hello());
    }
}
