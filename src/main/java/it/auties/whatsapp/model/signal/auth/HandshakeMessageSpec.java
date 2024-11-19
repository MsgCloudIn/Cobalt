package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.HandshakeMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HandshakeMessageSpec {
    public static byte[] encode(HandshakeMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(2, it.auties.whatsapp.model.signal.auth.ClientHelloSpec.encode(protoInputObject.clientHello()));
        outputStream.writeBytes(3, it.auties.whatsapp.model.signal.auth.ServerHelloSpec.encode(protoInputObject.serverHello()));
        outputStream.writeBytes(4, it.auties.whatsapp.model.signal.auth.ClientFinishSpec.encode(protoInputObject.clientFinish()));
        return outputStream.toByteArray();
    }

    public static HandshakeMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HandshakeMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.signal.auth.ClientHello clientHello = null;
        it.auties.whatsapp.model.signal.auth.ServerHello serverHello = null;
        it.auties.whatsapp.model.signal.auth.ClientFinish clientFinish = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 2 -> clientHello = it.auties.whatsapp.model.signal.auth.ClientHelloSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> serverHello = it.auties.whatsapp.model.signal.auth.ServerHelloSpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> clientFinish = it.auties.whatsapp.model.signal.auth.ClientFinishSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.HandshakeMessage(clientHello, serverHello, clientFinish);
    }

    public static int sizeOf(HandshakeMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var clientHello = object.clientHello();
        if (clientHello != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var clientHelloSerializedSize = it.auties.whatsapp.model.signal.auth.ClientHelloSpec.sizeOf(clientHello);
            protoSize += ProtobufOutputStream.getVarIntSize(clientHelloSerializedSize);
            protoSize += clientHelloSerializedSize;
        }
        var serverHello = object.serverHello();
        if (serverHello != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var serverHelloSerializedSize = it.auties.whatsapp.model.signal.auth.ServerHelloSpec.sizeOf(serverHello);
            protoSize += ProtobufOutputStream.getVarIntSize(serverHelloSerializedSize);
            protoSize += serverHelloSerializedSize;
        }
        var clientFinish = object.clientFinish();
        if (clientFinish != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            var clientFinishSerializedSize = it.auties.whatsapp.model.signal.auth.ClientFinishSpec.sizeOf(clientFinish);
            protoSize += ProtobufOutputStream.getVarIntSize(clientFinishSerializedSize);
            protoSize += clientFinishSerializedSize;
        }
        return protoSize;
    }

}
