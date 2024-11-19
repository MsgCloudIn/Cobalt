package it.auties.whatsapp.model.poll;

import it.auties.whatsapp.model.poll.PollOption;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PollOptionSpec {
    public static byte[] encode(PollOption protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.name());
        return outputStream.toByteArray();
    }

    public static PollOption decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PollOption decode(ProtobufInputStream protoInputStream) {
        java.lang.String name = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> name = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.poll.PollOption(name);
    }

    public static int sizeOf(PollOption object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var name = object.name();
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        return protoSize;
    }

}
