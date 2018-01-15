package by.itAcademy.finalProject.Data.Parsers.JSON;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * This class helps to parse Date data from JSON file
 */
public class DateGsonConverter implements JsonDeserializer<Date>{
    private  final  String [] formats = new String[]{
            "yyyy-MM-dd"
    };
    @Override

    public Date deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        for(String format: formats){
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);

                return sdf.parse(jsonElement.getAsString());

            }catch (Exception e){
                System.out.println("Ошибка интерпритации фала");
            }
        }
        return null;
    }
}
