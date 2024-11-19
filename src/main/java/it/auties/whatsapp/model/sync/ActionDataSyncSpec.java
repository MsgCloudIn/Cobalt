package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.ActionDataSync;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ActionDataSyncSpec {
    public static byte[] encode(ActionDataSync protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.index());
        outputStream.writeBytes(2, it.auties.whatsapp.model.sync.ActionValueSyncSpec.encode(protoInputObject.value()));
        outputStream.writeBytes(3, protoInputObject.padding());
        outputStream.writeInt32(4, protoInputObject.version());
        return outputStream.toByteArray();
    }

    public static ActionDataSync decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ActionDataSync decode(ProtobufInputStream protoInputStream) {
        byte[] index = null;
        it.auties.whatsapp.model.sync.ActionValueSync value = null;
        byte[] padding = null;
        java.lang.Integer version = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> index = protoInputStream.readBytes();
                case 2 -> value = it.auties.whatsapp.model.sync.ActionValueSyncSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> padding = protoInputStream.readBytes();
                case 4 -> version = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.ActionDataSync(index, value, padding, version);
    }

    public static int sizeOf(ActionDataSync object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var index = object.index();
        if (index != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(index);
        }
        var value = object.value();
        if (value != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var valueSerializedSize = it.auties.whatsapp.model.sync.ActionValueSyncSpec.sizeOf(value);
            protoSize += ProtobufOutputStream.getVarIntSize(valueSerializedSize);
            protoSize += valueSerializedSize;
        }
        var padding = object.padding();
        if (padding != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(padding);
        }
        var version = object.version();
        if (version != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(version);
        }
        return protoSize;
    }

}
