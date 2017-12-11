package com.epam.alexander_krivonozhkin.java.lesson2.serialization;

import com.epam.alexander_krivonozhkin.java.lesson2.classes.Car;
import com.google.gson.*;

import java.lang.reflect.Type;

public class CarAdapter implements JsonSerializer<Car>, JsonDeserializer<Car> {

    @Override
    public JsonElement serialize(Car car, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(car.getClass().getSimpleName()));
        result.add("properties", jsonSerializationContext.serialize(car, car.getClass()));

        return result;
    }

    @Override
    public Car deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String objectType = jsonObject.get("type").getAsString();
        JsonElement properties = jsonObject.get("properties");

        try {
            return jsonDeserializationContext.deserialize(
                    properties,
                    Class.forName("com.epam.alexander_krivonozhkin.java.lesson2.classes." + objectType)
            );
        } catch (ClassNotFoundException ex) {
            throw new JsonParseException("Unknown element type: " + objectType, ex);
        }
    }

}
