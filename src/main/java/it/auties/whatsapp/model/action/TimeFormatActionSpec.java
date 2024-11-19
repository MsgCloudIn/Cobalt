package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.TimeFormatAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class TimeFormatActionSpec {
    public static byte[] encode(TimeFormatAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.twentyFourHourFormatEnabled());
        return outputStream.toByteArray();
    }

    public static TimeFormatAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static TimeFormatAction decode(ProtobufInputStream protoInputStream) {
        boolean twentyFourHourFormatEnabled = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> twentyFourHourFormatEnabled = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.TimeFormatAction(twentyFourHourFormatEnabled);
    }

    public static int sizeOf(TimeFormatAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var twentyFourHourFormatEnabled = object.twentyFourHourFormatEnabled();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        return protoSize;
    }

}
