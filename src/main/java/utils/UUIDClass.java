package utils;

import java.util.UUID;

import com.fasterxml.uuid.Generators;


public class UUIDClass {

    static String uuid;

    public static String getUUID(String str){
        generateUUID(str);
       return uuid;
    }

    private static void generateUUID(String string){

        UUID uuid1 = Generators.timeBasedGenerator().generate();
        uuid = uuid1.toString();
        String str[] = uuid.split("-");
        uuid = String.join("", str);
        string += uuid;
        uuid = string;
    }

}
