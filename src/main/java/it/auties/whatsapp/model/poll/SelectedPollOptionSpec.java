package it.auties.whatsapp.model.poll;

import it.auties.whatsapp.model.poll.SelectedPollOption;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SelectedPollOptionSpec {
    public static byte[] encode(SelectedPollOption protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var jid = protoInputObject.jid();
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                outputStream.writeString(1, jid0);
            }
        }
        outputStream.writeString(2, protoInputObject.name());
        return outputStream.toByteArray();
    }

    public static SelectedPollOption decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SelectedPollOption decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid jid = null;
        java.lang.String name = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> jid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> name = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.poll.SelectedPollOption(jid, name);
    }

    public static int sizeOf(SelectedPollOption object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var jid = object.jid();
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(jid0);
            }
        }
        var name = object.name();
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        return protoSize;
    }

}
