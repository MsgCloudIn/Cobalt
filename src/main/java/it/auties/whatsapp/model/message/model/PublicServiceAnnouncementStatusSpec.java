package it.auties.whatsapp.model.message.model;

import it.auties.whatsapp.model.message.model.PublicServiceAnnouncementStatus;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PublicServiceAnnouncementStatusSpec {
    public static byte[] encode(PublicServiceAnnouncementStatus protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(44, protoInputObject.campaignId());
        outputStream.writeUInt64(45, protoInputObject.campaignExpirationTimestampSeconds());
        return outputStream.toByteArray();
    }

    public static PublicServiceAnnouncementStatus decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PublicServiceAnnouncementStatus decode(ProtobufInputStream protoInputStream) {
        java.lang.String campaignId = null;
        long campaignExpirationTimestampSeconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 44 -> campaignId = protoInputStream.readString();
                case 45 -> campaignExpirationTimestampSeconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.model.PublicServiceAnnouncementStatus(campaignId, campaignExpirationTimestampSeconds);
    }

    public static int sizeOf(PublicServiceAnnouncementStatus object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var campaignId = object.campaignId();
        if (campaignId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(44, 2);
            protoSize += ProtobufOutputStream.getStringSize(campaignId);
        }
        var campaignExpirationTimestampSeconds = object.campaignExpirationTimestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(45, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(campaignExpirationTimestampSeconds);
        return protoSize;
    }

}
