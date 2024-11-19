package it.auties.whatsapp.model.button.interactive;

import it.auties.whatsapp.model.button.interactive.InteractiveLocationAnnotation;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class InteractiveLocationAnnotationSpec {
    public static byte[] encode(InteractiveLocationAnnotation protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.polygonVertices() != null) {
            for (var polygonVerticesEntry : protoInputObject.polygonVertices()) { 
                outputStream.writeBytes(1, it.auties.whatsapp.model.button.interactive.InteractivePointSpec.encode(polygonVerticesEntry));
            }
        }
        outputStream.writeBytes(2, it.auties.whatsapp.model.button.interactive.InteractiveLocationSpec.encode(protoInputObject.location()));
        return outputStream.toByteArray();
    }

    public static InteractiveLocationAnnotation decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static InteractiveLocationAnnotation decode(ProtobufInputStream protoInputStream) {
        java.util.List<it.auties.whatsapp.model.button.interactive.InteractivePoint> polygonVertices = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        it.auties.whatsapp.model.button.interactive.InteractiveLocation location = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> polygonVertices.add(it.auties.whatsapp.model.button.interactive.InteractivePointSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 2 -> location = it.auties.whatsapp.model.button.interactive.InteractiveLocationSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.interactive.InteractiveLocationAnnotation(polygonVertices, location);
    }

    public static int sizeOf(InteractiveLocationAnnotation object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var polygonVerticesRepeatedField = object.polygonVertices();
        if (polygonVerticesRepeatedField != null) {
            for (var polygonVerticesEntry : polygonVerticesRepeatedField) { 
                if (polygonVerticesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    var polygonVerticesEntrySerializedSize = it.auties.whatsapp.model.button.interactive.InteractivePointSpec.sizeOf(polygonVerticesEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(polygonVerticesEntrySerializedSize);
                    protoSize += polygonVerticesEntrySerializedSize;
                }
            }
        }
        var location = object.location();
        if (location != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var locationSerializedSize = it.auties.whatsapp.model.button.interactive.InteractiveLocationSpec.sizeOf(location);
            protoSize += ProtobufOutputStream.getVarIntSize(locationSerializedSize);
            protoSize += locationSerializedSize;
        }
        return protoSize;
    }

}
