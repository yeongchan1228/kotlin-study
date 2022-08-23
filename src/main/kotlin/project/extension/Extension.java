package project.extension;

public class Extension {
    public static void main(String[] args) {
        System.out.println(MyExtensionKt.first("test"));
        System.out.println(MyExtensionKt.addFirst("test", '!'));
    }
}
