package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.RecordSync;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class RecordSyncSpec {
    public static byte[] encode(RecordSync protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.sync.IndexSyncSpec.encode(protoInputObject.index()));
        outputStream.writeBytes(2, it.auties.whatsapp.model.sync.ValueSyncSpec.encode(protoInputObject.value()));
        outputStream.writeBytes(3, it.auties.whatsapp.model.sync.KeyIdSpec.encode(protoInputObject.keyId()));
        return outputStream.toByteArray();
    }

    public static RecordSync decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static RecordSync decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.sync.IndexSync index = null;
        it.auties.whatsapp.model.sync.ValueSync value = null;
        it.auties.whatsapp.model.sync.KeyId keyId = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> index = it.auties.whatsapp.model.sync.IndexSyncSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> value = it.auties.whatsapp.model.sync.ValueSyncSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> keyId = it.auties.whatsapp.model.sync.KeyIdSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.RecordSync(index, value, keyId);
    }

    public static int sizeOf(RecordSync object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var index = object.index();
        if (index != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var indexSerializedSize = it.auties.whatsapp.model.sync.IndexSyncSpec.sizeOf(index);
            protoSize += ProtobufOutputStream.getVarIntSize(indexSerializedSize);
            protoSize += indexSerializedSize;
        }
        var value = object.value();
        if (value != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var valueSerializedSize = it.auties.whatsapp.model.sync.ValueSyncSpec.sizeOf(value);
            protoSize += ProtobufOutputStream.getVarIntSize(valueSerializedSize);
            protoSize += valueSerializedSize;
        }
        var keyId = object.keyId();
        if (keyId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var keyIdSerializedSize = it.auties.whatsapp.model.sync.KeyIdSpec.sizeOf(keyId);
            protoSize += ProtobufOutputStream.getVarIntSize(keyIdSerializedSize);
            protoSize += keyIdSerializedSize;
        }
        return protoSize;
    }

}
