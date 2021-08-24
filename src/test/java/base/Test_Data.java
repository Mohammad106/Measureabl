package base;

import com.github.javafaker.Faker;

public class Test_Data {
    public static Faker randata = new Faker();
    public static String fn = randata.name().firstName();
    public static String ln = randata.name().lastName();
    public static String email = randata.internet().safeEmailAddress();
    public static String company=randata.name().title();



}
