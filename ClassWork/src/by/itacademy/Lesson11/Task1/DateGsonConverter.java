package by.itacademy.Lesson11.Task1;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateGsonConverter implements JsonDeserializer<Date>{
    private  final  String [] formats = new String[]{
        "yyyy-MM-dd HH:mm",
        "yyyy-MM-dd"
    };
    @Override
    public Date deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        for(String format: formats){
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
                sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                return sdf.parse(jsonElement.getAsString());

            }catch (Exception e){
            }
        }
        return null;
    }
}
