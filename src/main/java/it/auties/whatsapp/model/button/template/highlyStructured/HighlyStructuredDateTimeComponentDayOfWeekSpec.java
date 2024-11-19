package it.auties.whatsapp.model.button.template.highlyStructured;

import it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponent.DayOfWeek;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class HighlyStructuredDateTimeComponentDayOfWeekSpec {
    public static Integer encode(DayOfWeek protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<DayOfWeek> decode(int index) {
        return Arrays.stream(DayOfWeek.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(DayOfWeek object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
