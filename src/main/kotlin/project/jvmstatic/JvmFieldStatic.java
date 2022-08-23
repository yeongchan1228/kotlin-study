package project.jvmstatic;

public class JvmFieldStatic {

    public static void main(String[] args) {
        System.out.println(JvmFieldClass.CODE);
//        System.out.println(JvmFieldClass.Companion.getId());
        System.out.println(JvmFieldClass.id);

        System.out.println(JvmFieldObject.USERNAME);
//        System.out.println(JvmFieldObject.INSTANCE.getName());
        System.out.println(JvmFieldObject.name);
    }
}
