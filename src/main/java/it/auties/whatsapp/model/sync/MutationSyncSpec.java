package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.MutationSync;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class MutationSyncSpec {
    public static byte[] encode(MutationSync protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, it.auties.whatsapp.model.sync.RecordSyncOperationSpec.encode(protoInputObject.operation()));
        outputStream.writeBytes(2, it.auties.whatsapp.model.sync.RecordSyncSpec.encode(protoInputObject.record()));
        return outputStream.toByteArray();
    }

    public static MutationSync decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static MutationSync decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.sync.RecordSync.Operation operation = null;
        it.auties.whatsapp.model.sync.RecordSync record = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> operation = it.auties.whatsapp.model.sync.RecordSyncOperationSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 2 -> record = it.auties.whatsapp.model.sync.RecordSyncSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.MutationSync(operation, record);
    }

    public static int sizeOf(MutationSync object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var operation = object.operation();
        if (operation != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var operationSerializedSize = it.auties.whatsapp.model.sync.RecordSyncOperationSpec.sizeOf(operation);
            protoSize += operationSerializedSize;
        }
        var record = object.record();
        if (record != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var recordSerializedSize = it.auties.whatsapp.model.sync.RecordSyncSpec.sizeOf(record);
            protoSize += ProtobufOutputStream.getVarIntSize(recordSerializedSize);
            protoSize += recordSerializedSize;
        }
        return protoSize;
    }

}
