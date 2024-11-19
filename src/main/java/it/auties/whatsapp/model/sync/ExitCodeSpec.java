package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.ExitCode;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ExitCodeSpec {
    public static byte[] encode(ExitCode protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeUInt64(1, protoInputObject.code());
        outputStream.writeString(2, protoInputObject.text());
        return outputStream.toByteArray();
    }

    public static ExitCode decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ExitCode decode(ProtobufInputStream protoInputStream) {
        long code = 0l;
        java.lang.String text = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> code = protoInputStream.readInt64();
                case 2 -> text = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.ExitCode(code, text);
    }

    public static int sizeOf(ExitCode object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var code = object.code();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(code);
        var text = object.text();
        if (text != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(text);
        }
        return protoSize;
    }

}
