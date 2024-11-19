package it.auties.whatsapp.model.button.template.highlyStructured;

import it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponent.CalendarType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class HighlyStructuredDateTimeComponentCalendarTypeSpec {
    public static Integer encode(CalendarType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<CalendarType> decode(int index) {
        return Arrays.stream(CalendarType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(CalendarType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
