package by.itAcademy.finalProject.Data.Parsers.JSON;

import by.itAcademy.finalProject.Data.Parsers.FileParsing;
import by.itAcademy.finalProject.Domain.Entity.Root;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class JsonParsing implements FileParsing {

    /**
     * This method is implemented form FileParsing interface and runs parsing JSON-file
     * @param fileName
     * @return
     * @throws IOException
     */
    @Override
    public Root parseFile(String fileName) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Date.class, new DateGsonConverter());
        Gson gsonConv = builder.create();
        Root root = gsonConv.fromJson(reader, Root.class);
        return root;
    }
}
