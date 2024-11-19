package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.MutationsSync;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class MutationsSyncSpec {
    public static byte[] encode(MutationsSync protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.mutations() != null) {
            for (var mutationsEntry : protoInputObject.mutations()) { 
                outputStream.writeBytes(1, it.auties.whatsapp.model.sync.MutationSyncSpec.encode(mutationsEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static MutationsSync decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static MutationsSync decode(ProtobufInputStream protoInputStream) {
        java.util.List<it.auties.whatsapp.model.sync.MutationSync> mutations = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> mutations.add(it.auties.whatsapp.model.sync.MutationSyncSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.MutationsSync(mutations);
    }

    public static int sizeOf(MutationsSync object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var mutationsRepeatedField = object.mutations();
        if (mutationsRepeatedField != null) {
            for (var mutationsEntry : mutationsRepeatedField) { 
                if (mutationsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    var mutationsEntrySerializedSize = it.auties.whatsapp.model.sync.MutationSyncSpec.sizeOf(mutationsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(mutationsEntrySerializedSize);
                    protoSize += mutationsEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
