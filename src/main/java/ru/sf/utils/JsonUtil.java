package ru.sf.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.sf.models.Student;

import java.time.LocalDate;

public class JsonUtil {

    private JsonUtil() {}

    public static String studentToJson(Student student) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        return gson.toJson(gson);
    }
}
