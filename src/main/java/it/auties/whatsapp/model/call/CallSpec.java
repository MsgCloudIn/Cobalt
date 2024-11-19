package it.auties.whatsapp.model.call;

import it.auties.whatsapp.model.call.Call;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class CallSpec {
    public static byte[] encode(Call protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var chat = protoInputObject.chat();
        if (chat != null) {
            var chat0 = chat.toString();
            if (chat0 != null) {
                outputStream.writeString(1, chat0);
            }
        }
        var caller = protoInputObject.caller();
        if (caller != null) {
            var caller0 = caller.toString();
            if (caller0 != null) {
                outputStream.writeString(2, caller0);
            }
        }
        outputStream.writeString(3, protoInputObject.id());
        outputStream.writeUInt64(4, protoInputObject.timestampSeconds());
        outputStream.writeBool(5, protoInputObject.video());
        outputStream.writeInt32(6, it.auties.whatsapp.model.call.CallStatusSpec.encode(protoInputObject.status()));
        outputStream.writeBool(7, protoInputObject.offline());
        return outputStream.toByteArray();
    }

    public static Call decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static Call decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid chat = null;
        it.auties.whatsapp.model.jid.Jid caller = null;
        java.lang.String id = null;
        long timestampSeconds = 0l;
        boolean video = false;
        it.auties.whatsapp.model.call.CallStatus status = null;
        boolean offline = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> chat = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> caller = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 3 -> id = protoInputStream.readString();
                case 4 -> timestampSeconds = protoInputStream.readInt64();
                case 5 -> video = protoInputStream.readBool();
                case 6 -> status = it.auties.whatsapp.model.call.CallStatusSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 7 -> offline = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.call.Call(chat, caller, id, timestampSeconds, video, status, offline);
    }

    public static int sizeOf(Call object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var chat = object.chat();
        if (chat != null) {
            var chat0 = chat.toString();
            if (chat0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(chat0);
            }
        }
        var caller = object.caller();
        if (caller != null) {
            var caller0 = caller.toString();
            if (caller0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getStringSize(caller0);
            }
        }
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var timestampSeconds = object.timestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(timestampSeconds);
        var video = object.video();
        protoSize += ProtobufOutputStream.getFieldSize(5, 0);
        protoSize += 1;
        var status = object.status();
        if (status != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            var statusSerializedSize = it.auties.whatsapp.model.call.CallStatusSpec.sizeOf(status);
            protoSize += statusSerializedSize;
        }
        var offline = object.offline();
        protoSize += ProtobufOutputStream.getFieldSize(7, 0);
        protoSize += 1;
        return protoSize;
    }

}
