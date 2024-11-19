package it.auties.whatsapp.model.button.interactive;

import it.auties.whatsapp.model.button.interactive.InteractiveNativeFlow;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class InteractiveNativeFlowSpec {
    public static byte[] encode(InteractiveNativeFlow protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.buttons() != null) {
            for (var buttonsEntry : protoInputObject.buttons()) { 
                outputStream.writeBytes(1, it.auties.whatsapp.model.button.interactive.InteractiveButtonSpec.encode(buttonsEntry));
            }
        }
        outputStream.writeString(2, protoInputObject.parameters());
        outputStream.writeInt32(3, protoInputObject.version());
        return outputStream.toByteArray();
    }

    public static InteractiveNativeFlow decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static InteractiveNativeFlow decode(ProtobufInputStream protoInputStream) {
        java.util.List<it.auties.whatsapp.model.button.interactive.InteractiveButton> buttons = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        java.lang.String parameters = null;
        int version = 0;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> buttons.add(it.auties.whatsapp.model.button.interactive.InteractiveButtonSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 2 -> parameters = protoInputStream.readString();
                case 3 -> version = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.interactive.InteractiveNativeFlow(buttons, parameters, version);
    }

    public static int sizeOf(InteractiveNativeFlow object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var buttonsRepeatedField = object.buttons();
        if (buttonsRepeatedField != null) {
            for (var buttonsEntry : buttonsRepeatedField) { 
                if (buttonsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    var buttonsEntrySerializedSize = it.auties.whatsapp.model.button.interactive.InteractiveButtonSpec.sizeOf(buttonsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(buttonsEntrySerializedSize);
                    protoSize += buttonsEntrySerializedSize;
                }
            }
        }
        var parameters = object.parameters();
        if (parameters != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(parameters);
        }
        var version = object.version();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(version);
        return protoSize;
    }

}
