package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.WebPayload;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class WebPayloadSpec {
    public static byte[] encode(WebPayload protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.usesParticipantInKey());
        outputStream.writeBool(2, protoInputObject.supportsStarredMessages());
        outputStream.writeBool(3, protoInputObject.supportsDocumentMessages());
        outputStream.writeBool(4, protoInputObject.supportsUrlMessages());
        outputStream.writeBool(5, protoInputObject.supportsMediaRetry());
        outputStream.writeBool(6, protoInputObject.supportsE2EImage());
        outputStream.writeBool(7, protoInputObject.supportsE2EVideo());
        outputStream.writeBool(8, protoInputObject.supportsE2EAudio());
        outputStream.writeBool(9, protoInputObject.supportsE2EDocument());
        outputStream.writeString(10, protoInputObject.documentTypes());
        outputStream.writeBytes(11, protoInputObject.features());
        return outputStream.toByteArray();
    }

    public static WebPayload decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static WebPayload decode(ProtobufInputStream protoInputStream) {
        boolean usesParticipantInKey = false;
        boolean supportsStarredMessages = false;
        boolean supportsDocumentMessages = false;
        boolean supportsUrlMessages = false;
        boolean supportsMediaRetry = false;
        boolean supportsE2EImage = false;
        boolean supportsE2EVideo = false;
        boolean supportsE2EAudio = false;
        boolean supportsE2EDocument = false;
        java.lang.String documentTypes = null;
        byte[] features = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> usesParticipantInKey = protoInputStream.readBool();
                case 2 -> supportsStarredMessages = protoInputStream.readBool();
                case 3 -> supportsDocumentMessages = protoInputStream.readBool();
                case 4 -> supportsUrlMessages = protoInputStream.readBool();
                case 5 -> supportsMediaRetry = protoInputStream.readBool();
                case 6 -> supportsE2EImage = protoInputStream.readBool();
                case 7 -> supportsE2EVideo = protoInputStream.readBool();
                case 8 -> supportsE2EAudio = protoInputStream.readBool();
                case 9 -> supportsE2EDocument = protoInputStream.readBool();
                case 10 -> documentTypes = protoInputStream.readString();
                case 11 -> features = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.WebPayload(usesParticipantInKey, supportsStarredMessages, supportsDocumentMessages, supportsUrlMessages, supportsMediaRetry, supportsE2EImage, supportsE2EVideo, supportsE2EAudio, supportsE2EDocument, documentTypes, features);
    }

    public static int sizeOf(WebPayload object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var usesParticipantInKey = object.usesParticipantInKey();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        var supportsStarredMessages = object.supportsStarredMessages();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += 1;
        var supportsDocumentMessages = object.supportsDocumentMessages();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += 1;
        var supportsUrlMessages = object.supportsUrlMessages();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += 1;
        var supportsMediaRetry = object.supportsMediaRetry();
        protoSize += ProtobufOutputStream.getFieldSize(5, 0);
        protoSize += 1;
        var supportsE2EImage = object.supportsE2EImage();
        protoSize += ProtobufOutputStream.getFieldSize(6, 0);
        protoSize += 1;
        var supportsE2EVideo = object.supportsE2EVideo();
        protoSize += ProtobufOutputStream.getFieldSize(7, 0);
        protoSize += 1;
        var supportsE2EAudio = object.supportsE2EAudio();
        protoSize += ProtobufOutputStream.getFieldSize(8, 0);
        protoSize += 1;
        var supportsE2EDocument = object.supportsE2EDocument();
        protoSize += ProtobufOutputStream.getFieldSize(9, 0);
        protoSize += 1;
        var documentTypes = object.documentTypes();
        if (documentTypes != null) {
            protoSize += ProtobufOutputStream.getFieldSize(10, 2);
            protoSize += ProtobufOutputStream.getStringSize(documentTypes);
        }
        var features = object.features();
        if (features != null) {
            protoSize += ProtobufOutputStream.getFieldSize(11, 2);
            protoSize += ProtobufOutputStream.getBytesSize(features);
        }
        return protoSize;
    }

}
