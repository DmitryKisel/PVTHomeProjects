package by.itacademy.Lesson13;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Task1 {
    public static void main(String[] args) {
        Test test = new Test();

        Class classTest = test.getClass();
        System.out.println(classTest.getSimpleName());
        int mod = classTest.getModifiers();

        if(Modifier.isAbstract(mod)){
                System.out.println("Abstract");
        }
        else {
                System.out.println("Not abstract");
        }

        if(Modifier.isPublic(mod)){
            System.out.println("Public");
        }
        else {
            System.out.println("Not public");
        }

        Field[] fields = classTest.getFields();
        for(Field field : fields){
            System.out.println("field name = " + field.getName());
        }

        Field[] fields2 = classTest.getDeclaredFields(); // показывает и публичные и прайвит переменные
        for(Field field : fields2){
            System.out.println("field name = " + field.getName());
            try {
                field.setAccessible(true);
                field.set(test, 55);
                System.out.println((int) field.get(test));
            }catch (Exception e){}
        }

        System.out.println();

        Method[] methods = classTest.getDeclaredMethods(); // показывает и публичные и прайвит переменные
        for(Method  method : methods){
            System.out.println("method name = " + method.getName());
        }

    }
}
