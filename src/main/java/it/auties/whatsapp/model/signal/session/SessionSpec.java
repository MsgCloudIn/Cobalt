package it.auties.whatsapp.model.signal.session;

import it.auties.whatsapp.model.signal.session.Session;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SessionSpec {
    public static byte[] encode(Session protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.states() != null) {
            for (var statesEntry : protoInputObject.states()) { 
                outputStream.writeBytes(1, it.auties.whatsapp.model.signal.session.SessionStateSpec.encode(statesEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static Session decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static Session decode(ProtobufInputStream protoInputStream) {
        java.util.concurrent.ConcurrentHashMap.KeySetView<it.auties.whatsapp.model.signal.session.SessionState,java.lang.Boolean> states = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newKeySet();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> states.add(it.auties.whatsapp.model.signal.session.SessionStateSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.session.Session(states);
    }

    public static int sizeOf(Session object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var statesRepeatedField = object.states();
        if (statesRepeatedField != null) {
            for (var statesEntry : statesRepeatedField) { 
                if (statesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    var statesEntrySerializedSize = it.auties.whatsapp.model.signal.session.SessionStateSpec.sizeOf(statesEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(statesEntrySerializedSize);
                    protoSize += statesEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
