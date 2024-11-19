package it.auties.whatsapp.model.signal.sender;

import it.auties.whatsapp.model.signal.sender.SenderKeyRecord;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SenderKeyRecordSpec {
    public static byte[] encode(SenderKeyRecord protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.states() != null) {
            for (var statesEntry : protoInputObject.states()) { 
                outputStream.writeBytes(1, it.auties.whatsapp.model.signal.sender.SenderKeyStateSpec.encode(statesEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static SenderKeyRecord decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SenderKeyRecord decode(ProtobufInputStream protoInputStream) {
        java.util.List<it.auties.whatsapp.model.signal.sender.SenderKeyState> states = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> states.add(it.auties.whatsapp.model.signal.sender.SenderKeyStateSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.sender.SenderKeyRecord(states);
    }

    public static int sizeOf(SenderKeyRecord object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var statesRepeatedField = object.states();
        if (statesRepeatedField != null) {
            for (var statesEntry : statesRepeatedField) { 
                if (statesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    var statesEntrySerializedSize = it.auties.whatsapp.model.signal.sender.SenderKeyStateSpec.sizeOf(statesEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(statesEntrySerializedSize);
                    protoSize += statesEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
