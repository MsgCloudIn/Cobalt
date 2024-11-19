package it.auties.whatsapp.model.button.template.highlyStructured;

import it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponent;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HighlyStructuredDateTimeComponentSpec {
    public static byte[] encode(HighlyStructuredDateTimeComponent protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponentDayOfWeekSpec.encode(protoInputObject.dayOfWeek()));
        outputStream.writeUInt32(2, protoInputObject.year());
        outputStream.writeUInt32(3, protoInputObject.month());
        outputStream.writeUInt32(4, protoInputObject.dayOfMonth());
        outputStream.writeUInt32(5, protoInputObject.hour());
        outputStream.writeUInt32(6, protoInputObject.minute());
        outputStream.writeInt32(7, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponentCalendarTypeSpec.encode(protoInputObject.calendar()));
        return outputStream.toByteArray();
    }

    public static HighlyStructuredDateTimeComponent decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HighlyStructuredDateTimeComponent decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponent.DayOfWeek dayOfWeek = null;
        int year = 0;
        int month = 0;
        int dayOfMonth = 0;
        int hour = 0;
        int minute = 0;
        it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponent.CalendarType calendar = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> dayOfWeek = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponentDayOfWeekSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 2 -> year = protoInputStream.readInt32();
                case 3 -> month = protoInputStream.readInt32();
                case 4 -> dayOfMonth = protoInputStream.readInt32();
                case 5 -> hour = protoInputStream.readInt32();
                case 6 -> minute = protoInputStream.readInt32();
                case 7 -> calendar = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponentCalendarTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponent(dayOfWeek, year, month, dayOfMonth, hour, minute, calendar);
    }

    public static int sizeOf(HighlyStructuredDateTimeComponent object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var dayOfWeek = object.dayOfWeek();
        if (dayOfWeek != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var dayOfWeekSerializedSize = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponentDayOfWeekSpec.sizeOf(dayOfWeek);
            protoSize += dayOfWeekSerializedSize;
        }
        var year = object.year();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(year);
        var month = object.month();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(month);
        var dayOfMonth = object.dayOfMonth();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(dayOfMonth);
        var hour = object.hour();
        protoSize += ProtobufOutputStream.getFieldSize(5, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(hour);
        var minute = object.minute();
        protoSize += ProtobufOutputStream.getFieldSize(6, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(minute);
        var calendar = object.calendar();
        if (calendar != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 2);
            var calendarSerializedSize = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponentCalendarTypeSpec.sizeOf(calendar);
            protoSize += calendarSerializedSize;
        }
        return protoSize;
    }

}
