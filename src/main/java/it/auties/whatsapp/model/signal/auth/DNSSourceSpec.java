package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.DNSSource;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class DNSSourceSpec {
    public static byte[] encode(DNSSource protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(15, it.auties.whatsapp.model.signal.auth.DNSSourceResolutionMethodSpec.encode(protoInputObject.dnsMethod()));
        outputStream.writeBool(16, protoInputObject.appCached());
        return outputStream.toByteArray();
    }

    public static DNSSource decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static DNSSource decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.signal.auth.DNSSource.ResolutionMethod dnsMethod = null;
        boolean appCached = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 15 -> dnsMethod = it.auties.whatsapp.model.signal.auth.DNSSourceResolutionMethodSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 16 -> appCached = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.DNSSource(dnsMethod, appCached);
    }

    public static int sizeOf(DNSSource object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var dnsMethod = object.dnsMethod();
        if (dnsMethod != null) {
            protoSize += ProtobufOutputStream.getFieldSize(15, 2);
            var dnsMethodSerializedSize = it.auties.whatsapp.model.signal.auth.DNSSourceResolutionMethodSpec.sizeOf(dnsMethod);
            protoSize += dnsMethodSerializedSize;
        }
        var appCached = object.appCached();
        protoSize += ProtobufOutputStream.getFieldSize(16, 0);
        protoSize += 1;
        return protoSize;
    }

}
