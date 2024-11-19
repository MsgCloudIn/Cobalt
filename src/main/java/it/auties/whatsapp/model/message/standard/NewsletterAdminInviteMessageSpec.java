package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.NewsletterAdminInviteMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NewsletterAdminInviteMessageSpec {
    public static byte[] encode(NewsletterAdminInviteMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var newsletterJid = protoInputObject.newsletterJid();
        if (newsletterJid != null) {
            var newsletterJid0 = newsletterJid.toString();
            if (newsletterJid0 != null) {
                outputStream.writeString(1, newsletterJid0);
            }
        }
        outputStream.writeString(2, protoInputObject.newsletterName());
        outputStream.writeBytes(3, protoInputObject.jpegThumbnail());
        outputStream.writeString(4, protoInputObject.caption());
        outputStream.writeInt64(5, protoInputObject.inviteExpirationTimestampSeconds());
        return outputStream.toByteArray();
    }

    public static NewsletterAdminInviteMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static NewsletterAdminInviteMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid newsletterJid = null;
        java.lang.String newsletterName = null;
        byte[] jpegThumbnail = null;
        java.lang.String caption = null;
        long inviteExpirationTimestampSeconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> newsletterJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> newsletterName = protoInputStream.readString();
                case 3 -> jpegThumbnail = protoInputStream.readBytes();
                case 4 -> caption = protoInputStream.readString();
                case 5 -> inviteExpirationTimestampSeconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.NewsletterAdminInviteMessage(newsletterJid, newsletterName, jpegThumbnail, caption, inviteExpirationTimestampSeconds);
    }

    public static int sizeOf(NewsletterAdminInviteMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var newsletterJid = object.newsletterJid();
        if (newsletterJid != null) {
            var newsletterJid0 = newsletterJid.toString();
            if (newsletterJid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(newsletterJid0);
            }
        }
        var newsletterName = object.newsletterName();
        if (newsletterName != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(newsletterName);
        }
        var jpegThumbnail = object.jpegThumbnail();
        if (jpegThumbnail != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(jpegThumbnail);
        }
        var caption = object.caption();
        if (caption != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getStringSize(caption);
        }
        var inviteExpirationTimestampSeconds = object.inviteExpirationTimestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(5, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(inviteExpirationTimestampSeconds);
        return protoSize;
    }

}
