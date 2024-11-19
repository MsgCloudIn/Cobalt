package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.AppStateFatalExceptionNotification;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class AppStateFatalExceptionNotificationSpec {
    public static byte[] encode(AppStateFatalExceptionNotification protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.collectionNames() != null) {
            for (var collectionNamesEntry : protoInputObject.collectionNames()) { 
                outputStream.writeString(1, collectionNamesEntry);
            }
        }
        outputStream.writeInt64(2, protoInputObject.timestamp());
        return outputStream.toByteArray();
    }

    public static AppStateFatalExceptionNotification decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static AppStateFatalExceptionNotification decode(ProtobufInputStream protoInputStream) {
        java.util.List<java.lang.String> collectionNames = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        java.lang.Long timestamp = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> collectionNames.add(protoInputStream.readString());
                case 2 -> timestamp = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.AppStateFatalExceptionNotification(collectionNames, timestamp);
    }

    public static int sizeOf(AppStateFatalExceptionNotification object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var collectionNamesRepeatedField = object.collectionNames();
        if (collectionNamesRepeatedField != null) {
            for (var collectionNamesEntry : collectionNamesRepeatedField) { 
                if (collectionNamesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    protoSize += ProtobufOutputStream.getStringSize(collectionNamesEntry);
                }
            }
        }
        var timestamp = object.timestamp();
        if (timestamp != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(timestamp);
        }
        return protoSize;
    }

}
