package it.auties.whatsapp.controller;

import it.auties.whatsapp.controller.Store;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class StoreSpec {
    public static byte[] encode(Store protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var uuid = protoInputObject.uuid;
        if (uuid != null) {
            var uuid0 = it.auties.protobuf.builtin.ProtobufUUIDMixin.toValue(uuid);
            if (uuid0 != null) {
                outputStream.writeString(1, uuid0);
            }
        }
        var phoneNumber = protoInputObject.phoneNumber();
        if (phoneNumber != null) {
            var phoneNumber0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(phoneNumber);
            if (phoneNumber0 != null) {
                var phoneNumber1 = phoneNumber0.number();
                outputStream.writeUInt64(2, phoneNumber1);
            }
        }
        outputStream.writeInt32(3, it.auties.whatsapp.api.ClientTypeSpec.encode(protoInputObject.clientType));
        if (protoInputObject.alias != null) {
            for (var aliasEntry : protoInputObject.alias) { 
                outputStream.writeString(4, aliasEntry);
            }
        }
        var proxy = protoInputObject.proxy;
        if (proxy != null) {
            var proxy0 = it.auties.protobuf.builtin.ProtobufURIMixin.toValue(proxy);
            if (proxy0 != null) {
                outputStream.writeString(5, proxy0);
            }
        }
        outputStream.writeBool(7, protoInputObject.online);
        outputStream.writeBytes(8, it.auties.whatsapp.model.mobile.CountryLocaleSpec.encode(protoInputObject.locale));
        outputStream.writeString(9, protoInputObject.name);
        outputStream.writeString(40, protoInputObject.verifiedName);
        outputStream.writeString(10, protoInputObject.businessAddress);
        outputStream.writeDouble(11, protoInputObject.businessLongitude);
        outputStream.writeDouble(12, protoInputObject.businessLatitude);
        outputStream.writeString(13, protoInputObject.businessDescription);
        outputStream.writeString(14, protoInputObject.businessWebsite);
        outputStream.writeString(15, protoInputObject.businessEmail);
        outputStream.writeBytes(16, it.auties.whatsapp.model.business.BusinessCategorySpec.encode(protoInputObject.businessCategory));
        outputStream.writeString(17, protoInputObject.deviceHash);
        if (protoInputObject.linkedDevicesKeys != null) {
            for (var linkedDevicesKeysEntry : protoInputObject.linkedDevicesKeys.entrySet()) { 
                var linkedDevicesKeysOutputStream = new ProtobufOutputStream(sizeOfLinkedDevicesKeys(linkedDevicesKeysEntry));
                var linkedDevicesKeys = linkedDevicesKeysEntry.getKey();
                if (linkedDevicesKeys != null) {
                    var linkedDevicesKeys0 = linkedDevicesKeys.toString();
                    if (linkedDevicesKeys0 != null) {
                        linkedDevicesKeysOutputStream.writeString(1, linkedDevicesKeys0);
                    }
                }
                linkedDevicesKeysOutputStream.writeInt32(2, linkedDevicesKeysEntry.getValue());
                outputStream.writeBytes(18, linkedDevicesKeysOutputStream.toByteArray());
            }
        }
        var profilePicture = protoInputObject.profilePicture;
        if (profilePicture != null) {
            var profilePicture0 = it.auties.protobuf.builtin.ProtobufURIMixin.toValue(profilePicture);
            if (profilePicture0 != null) {
                outputStream.writeString(19, profilePicture0);
            }
        }
        outputStream.writeString(20, protoInputObject.about);
        var jid = protoInputObject.jid;
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                outputStream.writeString(21, jid0);
            }
        }
        var lid = protoInputObject.lid;
        if (lid != null) {
            var lid0 = lid.toString();
            if (lid0 != null) {
                outputStream.writeString(22, lid0);
            }
        }
        if (protoInputObject.properties != null) {
            for (var propertiesEntry : protoInputObject.properties.entrySet()) { 
                var propertiesOutputStream = new ProtobufOutputStream(sizeOfProperties(propertiesEntry));
                propertiesOutputStream.writeString(1, propertiesEntry.getKey());
                propertiesOutputStream.writeString(2, propertiesEntry.getValue());
                outputStream.writeBytes(23, propertiesOutputStream.toByteArray());
            }
        }
        if (protoInputObject.contacts != null) {
            for (var contactsEntry : protoInputObject.contacts.entrySet()) { 
                var contactsOutputStream = new ProtobufOutputStream(sizeOfContacts(contactsEntry));
                var contacts = contactsEntry.getKey();
                if (contacts != null) {
                    var contacts0 = contacts.toString();
                    if (contacts0 != null) {
                        contactsOutputStream.writeString(1, contacts0);
                    }
                }
                contactsOutputStream.writeBytes(2, it.auties.whatsapp.model.contact.ContactSpec.encode(contactsEntry.getValue()));
                outputStream.writeBytes(24, contactsOutputStream.toByteArray());
            }
        }
        if (protoInputObject.status != null) {
            for (var statusEntry : protoInputObject.status) { 
                outputStream.writeBytes(25, it.auties.whatsapp.model.info.ChatMessageInfoSpec.encode(statusEntry));
            }
        }
        if (protoInputObject.privacySettings != null) {
            for (var privacySettingsEntry : protoInputObject.privacySettings.entrySet()) { 
                var privacySettingsOutputStream = new ProtobufOutputStream(sizeOfPrivacySettings(privacySettingsEntry));
                privacySettingsOutputStream.writeString(1, privacySettingsEntry.getKey());
                privacySettingsOutputStream.writeBytes(2, it.auties.whatsapp.model.privacy.PrivacySettingEntrySpec.encode(privacySettingsEntry.getValue()));
                outputStream.writeBytes(26, privacySettingsOutputStream.toByteArray());
            }
        }
        if (protoInputObject.calls != null) {
            for (var callsEntry : protoInputObject.calls.entrySet()) { 
                var callsOutputStream = new ProtobufOutputStream(sizeOfCalls(callsEntry));
                callsOutputStream.writeString(1, callsEntry.getKey());
                callsOutputStream.writeBytes(2, it.auties.whatsapp.model.call.CallSpec.encode(callsEntry.getValue()));
                outputStream.writeBytes(27, callsOutputStream.toByteArray());
            }
        }
        outputStream.writeBool(28, protoInputObject.unarchiveChats);
        outputStream.writeBool(29, protoInputObject.twentyFourHourFormat);
        outputStream.writeUInt64(30, protoInputObject.initializationTimeStamp);
        outputStream.writeInt32(31, it.auties.whatsapp.model.chat.ChatEphemeralTimerSpec.encode(protoInputObject.newChatsEphemeralTimer));
        outputStream.writeInt32(32, it.auties.whatsapp.api.TextPreviewSettingSpec.encode(protoInputObject.textPreviewSetting));
        outputStream.writeBytes(33, it.auties.whatsapp.api.WebHistoryLengthSpec.encode(protoInputObject.historyLength));
        outputStream.writeBool(34, protoInputObject.autodetectListeners);
        outputStream.writeBool(36, protoInputObject.automaticPresenceUpdates);
        outputStream.writeBool(41, protoInputObject.automaticMessageReceipts);
        outputStream.writeInt32(37, it.auties.whatsapp.model.signal.auth.UserAgentReleaseChannelSpec.encode(protoInputObject.releaseChannel));
        outputStream.writeBytes(38, it.auties.whatsapp.model.companion.CompanionDeviceSpec.encode(protoInputObject.device));
        outputStream.writeBool(39, protoInputObject.checkPatchMacs);
        outputStream.writeInt32(42, it.auties.whatsapp.api.MediaProxySettingSpec.encode(protoInputObject.mediaProxySetting));
        return outputStream.toByteArray();
    }

    public static Store decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static Store decode(ProtobufInputStream protoInputStream) {
        java.util.UUID uuid = null;
        it.auties.whatsapp.model.mobile.PhoneNumber phoneNumber = null;
        it.auties.whatsapp.api.ClientType clientType = null;
        java.util.Collection<java.lang.String> alias = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newCollection();
        java.net.URI proxy = null;
        boolean online = false;
        it.auties.whatsapp.model.mobile.CountryLocale locale = null;
        java.lang.String name = null;
        java.lang.String verifiedName = null;
        java.lang.String businessAddress = null;
        java.lang.Double businessLongitude = null;
        java.lang.Double businessLatitude = null;
        java.lang.String businessDescription = null;
        java.lang.String businessWebsite = null;
        java.lang.String businessEmail = null;
        it.auties.whatsapp.model.business.BusinessCategory businessCategory = null;
        java.lang.String deviceHash = null;
        java.util.LinkedHashMap<it.auties.whatsapp.model.jid.Jid,java.lang.Integer> linkedDevicesKeys = new java.util.LinkedHashMap();
        java.net.URI profilePicture = null;
        java.lang.String about = null;
        it.auties.whatsapp.model.jid.Jid jid = null;
        it.auties.whatsapp.model.jid.Jid lid = null;
        java.util.concurrent.ConcurrentHashMap<java.lang.String,java.lang.String> properties = new java.util.concurrent.ConcurrentHashMap();
        java.util.concurrent.ConcurrentHashMap<it.auties.whatsapp.model.jid.Jid,it.auties.whatsapp.model.contact.Contact> contacts = new java.util.concurrent.ConcurrentHashMap();
        java.util.concurrent.ConcurrentHashMap.KeySetView<it.auties.whatsapp.model.info.ChatMessageInfo,java.lang.Boolean> status = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newKeySet();
        java.util.concurrent.ConcurrentHashMap<java.lang.String,it.auties.whatsapp.model.privacy.PrivacySettingEntry> privacySettings = new java.util.concurrent.ConcurrentHashMap();
        java.util.concurrent.ConcurrentHashMap<java.lang.String,it.auties.whatsapp.model.call.Call> calls = new java.util.concurrent.ConcurrentHashMap();
        boolean unarchiveChats = false;
        boolean twentyFourHourFormat = false;
        java.lang.Long initializationTimeStamp = null;
        it.auties.whatsapp.model.chat.ChatEphemeralTimer newChatsEphemeralTimer = null;
        it.auties.whatsapp.api.TextPreviewSetting textPreviewSetting = null;
        it.auties.whatsapp.api.WebHistoryLength historyLength = null;
        boolean autodetectListeners = false;
        boolean automaticPresenceUpdates = false;
        boolean automaticMessageReceipts = false;
        it.auties.whatsapp.model.signal.auth.UserAgent.ReleaseChannel releaseChannel = null;
        it.auties.whatsapp.model.companion.CompanionDevice device = null;
        boolean checkPatchMacs = false;
        it.auties.whatsapp.api.MediaProxySetting mediaProxySetting = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> uuid = it.auties.protobuf.builtin.ProtobufUUIDMixin.ofNullable(protoInputStream.readString());
                case 2 -> phoneNumber = it.auties.whatsapp.model.mobile.PhoneNumber.of(protoInputStream.readInt64());
                case 3 -> clientType = it.auties.whatsapp.api.ClientTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 4 -> alias.add(protoInputStream.readString());
                case 5 -> proxy = it.auties.protobuf.builtin.ProtobufURIMixin.ofNullable(protoInputStream.readString());
                case 7 -> online = protoInputStream.readBool();
                case 8 -> locale = it.auties.whatsapp.model.mobile.CountryLocaleSpec.decode(protoInputStream.lengthDelimitedStream());
                case 9 -> name = protoInputStream.readString();
                case 40 -> verifiedName = protoInputStream.readString();
                case 10 -> businessAddress = protoInputStream.readString();
                case 11 -> businessLongitude = protoInputStream.readDouble();
                case 12 -> businessLatitude = protoInputStream.readDouble();
                case 13 -> businessDescription = protoInputStream.readString();
                case 14 -> businessWebsite = protoInputStream.readString();
                case 15 -> businessEmail = protoInputStream.readString();
                case 16 -> businessCategory = it.auties.whatsapp.model.business.BusinessCategorySpec.decode(protoInputStream.lengthDelimitedStream());
                case 17 -> deviceHash = protoInputStream.readString();
                case 18 -> {
                    var linkedDevicesKeysInputStream = protoInputStream.lengthDelimitedStream();
                    it.auties.whatsapp.model.jid.Jid linkedDevicesKeysKey = null;
                    java.lang.Integer linkedDevicesKeysValue = null;
                    while (linkedDevicesKeysInputStream.readTag()) {
                        switch (linkedDevicesKeysInputStream.index()) {
                            case 1 -> linkedDevicesKeysKey = it.auties.whatsapp.model.jid.Jid.ofProtobuf(linkedDevicesKeysInputStream.readString());
                            case 2 -> linkedDevicesKeysValue = linkedDevicesKeysInputStream.readInt32();
                        }
                    }
                    linkedDevicesKeys.put(linkedDevicesKeysKey, linkedDevicesKeysValue);
                }
                case 19 -> profilePicture = it.auties.protobuf.builtin.ProtobufURIMixin.ofNullable(protoInputStream.readString());
                case 20 -> about = protoInputStream.readString();
                case 21 -> jid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 22 -> lid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 23 -> {
                    var propertiesInputStream = protoInputStream.lengthDelimitedStream();
                    java.lang.String propertiesKey = null;
                    java.lang.String propertiesValue = null;
                    while (propertiesInputStream.readTag()) {
                        switch (propertiesInputStream.index()) {
                            case 1 -> propertiesKey = propertiesInputStream.readString();
                            case 2 -> propertiesValue = propertiesInputStream.readString();
                        }
                    }
                    properties.put(propertiesKey, propertiesValue);
                }
                case 24 -> {
                    var contactsInputStream = protoInputStream.lengthDelimitedStream();
                    it.auties.whatsapp.model.jid.Jid contactsKey = null;
                    it.auties.whatsapp.model.contact.Contact contactsValue = null;
                    while (contactsInputStream.readTag()) {
                        switch (contactsInputStream.index()) {
                            case 1 -> contactsKey = it.auties.whatsapp.model.jid.Jid.ofProtobuf(contactsInputStream.readString());
                            case 2 -> contactsValue = it.auties.whatsapp.model.contact.ContactSpec.decode(contactsInputStream.lengthDelimitedStream());
                        }
                    }
                    contacts.put(contactsKey, contactsValue);
                }
                case 25 -> status.add(it.auties.whatsapp.model.info.ChatMessageInfoSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 26 -> {
                    var privacySettingsInputStream = protoInputStream.lengthDelimitedStream();
                    java.lang.String privacySettingsKey = null;
                    it.auties.whatsapp.model.privacy.PrivacySettingEntry privacySettingsValue = null;
                    while (privacySettingsInputStream.readTag()) {
                        switch (privacySettingsInputStream.index()) {
                            case 1 -> privacySettingsKey = privacySettingsInputStream.readString();
                            case 2 -> privacySettingsValue = it.auties.whatsapp.model.privacy.PrivacySettingEntrySpec.decode(privacySettingsInputStream.lengthDelimitedStream());
                        }
                    }
                    privacySettings.put(privacySettingsKey, privacySettingsValue);
                }
                case 27 -> {
                    var callsInputStream = protoInputStream.lengthDelimitedStream();
                    java.lang.String callsKey = null;
                    it.auties.whatsapp.model.call.Call callsValue = null;
                    while (callsInputStream.readTag()) {
                        switch (callsInputStream.index()) {
                            case 1 -> callsKey = callsInputStream.readString();
                            case 2 -> callsValue = it.auties.whatsapp.model.call.CallSpec.decode(callsInputStream.lengthDelimitedStream());
                        }
                    }
                    calls.put(callsKey, callsValue);
                }
                case 28 -> unarchiveChats = protoInputStream.readBool();
                case 29 -> twentyFourHourFormat = protoInputStream.readBool();
                case 30 -> initializationTimeStamp = protoInputStream.readInt64();
                case 31 -> newChatsEphemeralTimer = it.auties.whatsapp.model.chat.ChatEphemeralTimerSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 32 -> textPreviewSetting = it.auties.whatsapp.api.TextPreviewSettingSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 33 -> historyLength = it.auties.whatsapp.api.WebHistoryLengthSpec.decode(protoInputStream.lengthDelimitedStream());
                case 34 -> autodetectListeners = protoInputStream.readBool();
                case 36 -> automaticPresenceUpdates = protoInputStream.readBool();
                case 41 -> automaticMessageReceipts = protoInputStream.readBool();
                case 37 -> releaseChannel = it.auties.whatsapp.model.signal.auth.UserAgentReleaseChannelSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 38 -> device = it.auties.whatsapp.model.companion.CompanionDeviceSpec.decode(protoInputStream.lengthDelimitedStream());
                case 39 -> checkPatchMacs = protoInputStream.readBool();
                case 42 -> mediaProxySetting = it.auties.whatsapp.api.MediaProxySettingSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.controller.Store(uuid, phoneNumber, clientType, alias, proxy, online, locale, name, verifiedName, businessAddress, businessLongitude, businessLatitude, businessDescription, businessWebsite, businessEmail, businessCategory, deviceHash, linkedDevicesKeys, profilePicture, about, jid, lid, properties, contacts, status, privacySettings, calls, unarchiveChats, twentyFourHourFormat, initializationTimeStamp, newChatsEphemeralTimer, textPreviewSetting, historyLength, autodetectListeners, automaticPresenceUpdates, automaticMessageReceipts, releaseChannel, device, checkPatchMacs, mediaProxySetting);
    }

    public static int sizeOf(Store object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var uuid = object.uuid;
        if (uuid != null) {
            var uuid0 = it.auties.protobuf.builtin.ProtobufUUIDMixin.toValue(uuid);
            if (uuid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(uuid0);
            }
        }
        var phoneNumber = object.phoneNumber();
        if (phoneNumber != null) {
            var phoneNumber0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(phoneNumber);
            if (phoneNumber0 != null) {
                var phoneNumber1 = phoneNumber0.number();
                protoSize += ProtobufOutputStream.getFieldSize(2, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(phoneNumber1);
            }
        }
        var clientType = object.clientType;
        if (clientType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var clientTypeSerializedSize = it.auties.whatsapp.api.ClientTypeSpec.sizeOf(clientType);
            protoSize += clientTypeSerializedSize;
        }
        var aliasRepeatedField = object.alias;
        if (aliasRepeatedField != null) {
            for (var aliasEntry : aliasRepeatedField) { 
                if (aliasEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                    protoSize += ProtobufOutputStream.getStringSize(aliasEntry);
                }
            }
        }
        var proxy = object.proxy;
        if (proxy != null) {
            var proxy0 = it.auties.protobuf.builtin.ProtobufURIMixin.toValue(proxy);
            if (proxy0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                protoSize += ProtobufOutputStream.getStringSize(proxy0);
            }
        }
        var online = object.online;
        protoSize += ProtobufOutputStream.getFieldSize(7, 0);
        protoSize += 1;
        var locale = object.locale;
        if (locale != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 2);
            var localeSerializedSize = it.auties.whatsapp.model.mobile.CountryLocaleSpec.sizeOf(locale);
            protoSize += ProtobufOutputStream.getVarIntSize(localeSerializedSize);
            protoSize += localeSerializedSize;
        }
        var name = object.name;
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        var verifiedName = object.verifiedName;
        if (verifiedName != null) {
            protoSize += ProtobufOutputStream.getFieldSize(40, 2);
            protoSize += ProtobufOutputStream.getStringSize(verifiedName);
        }
        var businessAddress = object.businessAddress;
        if (businessAddress != null) {
            protoSize += ProtobufOutputStream.getFieldSize(10, 2);
            protoSize += ProtobufOutputStream.getStringSize(businessAddress);
        }
        var businessLongitude = object.businessLongitude;
        if (businessLongitude != null) {
            protoSize += ProtobufOutputStream.getFieldSize(11, 1);
            protoSize += 8;
        }
        var businessLatitude = object.businessLatitude;
        if (businessLatitude != null) {
            protoSize += ProtobufOutputStream.getFieldSize(12, 1);
            protoSize += 8;
        }
        var businessDescription = object.businessDescription;
        if (businessDescription != null) {
            protoSize += ProtobufOutputStream.getFieldSize(13, 2);
            protoSize += ProtobufOutputStream.getStringSize(businessDescription);
        }
        var businessWebsite = object.businessWebsite;
        if (businessWebsite != null) {
            protoSize += ProtobufOutputStream.getFieldSize(14, 2);
            protoSize += ProtobufOutputStream.getStringSize(businessWebsite);
        }
        var businessEmail = object.businessEmail;
        if (businessEmail != null) {
            protoSize += ProtobufOutputStream.getFieldSize(15, 2);
            protoSize += ProtobufOutputStream.getStringSize(businessEmail);
        }
        var businessCategory = object.businessCategory;
        if (businessCategory != null) {
            protoSize += ProtobufOutputStream.getFieldSize(16, 2);
            var businessCategorySerializedSize = it.auties.whatsapp.model.business.BusinessCategorySpec.sizeOf(businessCategory);
            protoSize += ProtobufOutputStream.getVarIntSize(businessCategorySerializedSize);
            protoSize += businessCategorySerializedSize;
        }
        var deviceHash = object.deviceHash;
        if (deviceHash != null) {
            protoSize += ProtobufOutputStream.getFieldSize(17, 2);
            protoSize += ProtobufOutputStream.getStringSize(deviceHash);
        }
        var linkedDevicesKeysMapField = object.linkedDevicesKeys;
        if (linkedDevicesKeysMapField != null) {
            for (var linkedDevicesKeysMapEntry : linkedDevicesKeysMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(18, 2);
                var linkedDevicesKeysMapEntrySize = sizeOfLinkedDevicesKeys(linkedDevicesKeysMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(linkedDevicesKeysMapEntrySize);
                protoSize += linkedDevicesKeysMapEntrySize;
            }
        }
        var profilePicture = object.profilePicture;
        if (profilePicture != null) {
            var profilePicture0 = it.auties.protobuf.builtin.ProtobufURIMixin.toValue(profilePicture);
            if (profilePicture0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(19, 2);
                protoSize += ProtobufOutputStream.getStringSize(profilePicture0);
            }
        }
        var about = object.about;
        if (about != null) {
            protoSize += ProtobufOutputStream.getFieldSize(20, 2);
            protoSize += ProtobufOutputStream.getStringSize(about);
        }
        var jid = object.jid;
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(21, 2);
                protoSize += ProtobufOutputStream.getStringSize(jid0);
            }
        }
        var lid = object.lid;
        if (lid != null) {
            var lid0 = lid.toString();
            if (lid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(22, 2);
                protoSize += ProtobufOutputStream.getStringSize(lid0);
            }
        }
        var propertiesMapField = object.properties;
        if (propertiesMapField != null) {
            for (var propertiesMapEntry : propertiesMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(23, 2);
                var propertiesMapEntrySize = sizeOfProperties(propertiesMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(propertiesMapEntrySize);
                protoSize += propertiesMapEntrySize;
            }
        }
        var contactsMapField = object.contacts;
        if (contactsMapField != null) {
            for (var contactsMapEntry : contactsMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(24, 2);
                var contactsMapEntrySize = sizeOfContacts(contactsMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(contactsMapEntrySize);
                protoSize += contactsMapEntrySize;
            }
        }
        var statusRepeatedField = object.status;
        if (statusRepeatedField != null) {
            for (var statusEntry : statusRepeatedField) { 
                if (statusEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(25, 2);
                    var statusEntrySerializedSize = it.auties.whatsapp.model.info.ChatMessageInfoSpec.sizeOf(statusEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(statusEntrySerializedSize);
                    protoSize += statusEntrySerializedSize;
                }
            }
        }
        var privacySettingsMapField = object.privacySettings;
        if (privacySettingsMapField != null) {
            for (var privacySettingsMapEntry : privacySettingsMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(26, 2);
                var privacySettingsMapEntrySize = sizeOfPrivacySettings(privacySettingsMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(privacySettingsMapEntrySize);
                protoSize += privacySettingsMapEntrySize;
            }
        }
        var callsMapField = object.calls;
        if (callsMapField != null) {
            for (var callsMapEntry : callsMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(27, 2);
                var callsMapEntrySize = sizeOfCalls(callsMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(callsMapEntrySize);
                protoSize += callsMapEntrySize;
            }
        }
        var unarchiveChats = object.unarchiveChats;
        protoSize += ProtobufOutputStream.getFieldSize(28, 0);
        protoSize += 1;
        var twentyFourHourFormat = object.twentyFourHourFormat;
        protoSize += ProtobufOutputStream.getFieldSize(29, 0);
        protoSize += 1;
        var initializationTimeStamp = object.initializationTimeStamp;
        if (initializationTimeStamp != null) {
            protoSize += ProtobufOutputStream.getFieldSize(30, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(initializationTimeStamp);
        }
        var newChatsEphemeralTimer = object.newChatsEphemeralTimer;
        if (newChatsEphemeralTimer != null) {
            protoSize += ProtobufOutputStream.getFieldSize(31, 2);
            var newChatsEphemeralTimerSerializedSize = it.auties.whatsapp.model.chat.ChatEphemeralTimerSpec.sizeOf(newChatsEphemeralTimer);
            protoSize += newChatsEphemeralTimerSerializedSize;
        }
        var textPreviewSetting = object.textPreviewSetting;
        if (textPreviewSetting != null) {
            protoSize += ProtobufOutputStream.getFieldSize(32, 2);
            var textPreviewSettingSerializedSize = it.auties.whatsapp.api.TextPreviewSettingSpec.sizeOf(textPreviewSetting);
            protoSize += textPreviewSettingSerializedSize;
        }
        var historyLength = object.historyLength;
        if (historyLength != null) {
            protoSize += ProtobufOutputStream.getFieldSize(33, 2);
            var historyLengthSerializedSize = it.auties.whatsapp.api.WebHistoryLengthSpec.sizeOf(historyLength);
            protoSize += ProtobufOutputStream.getVarIntSize(historyLengthSerializedSize);
            protoSize += historyLengthSerializedSize;
        }
        var autodetectListeners = object.autodetectListeners;
        protoSize += ProtobufOutputStream.getFieldSize(34, 0);
        protoSize += 1;
        var automaticPresenceUpdates = object.automaticPresenceUpdates;
        protoSize += ProtobufOutputStream.getFieldSize(36, 0);
        protoSize += 1;
        var automaticMessageReceipts = object.automaticMessageReceipts;
        protoSize += ProtobufOutputStream.getFieldSize(41, 0);
        protoSize += 1;
        var releaseChannel = object.releaseChannel;
        if (releaseChannel != null) {
            protoSize += ProtobufOutputStream.getFieldSize(37, 2);
            var releaseChannelSerializedSize = it.auties.whatsapp.model.signal.auth.UserAgentReleaseChannelSpec.sizeOf(releaseChannel);
            protoSize += releaseChannelSerializedSize;
        }
        var device = object.device;
        if (device != null) {
            protoSize += ProtobufOutputStream.getFieldSize(38, 2);
            var deviceSerializedSize = it.auties.whatsapp.model.companion.CompanionDeviceSpec.sizeOf(device);
            protoSize += ProtobufOutputStream.getVarIntSize(deviceSerializedSize);
            protoSize += deviceSerializedSize;
        }
        var checkPatchMacs = object.checkPatchMacs;
        protoSize += ProtobufOutputStream.getFieldSize(39, 0);
        protoSize += 1;
        var mediaProxySetting = object.mediaProxySetting;
        if (mediaProxySetting != null) {
            protoSize += ProtobufOutputStream.getFieldSize(42, 2);
            var mediaProxySettingSerializedSize = it.auties.whatsapp.api.MediaProxySettingSpec.sizeOf(mediaProxySetting);
            protoSize += mediaProxySettingSerializedSize;
        }
        return protoSize;
    }

    private static int sizeOfLinkedDevicesKeys(java.util.Map.Entry<it.auties.whatsapp.model.jid.Jid, java.lang.Integer> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        var objectMapKey0 = objectMapKey.toString();
        if (objectMapKey0 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(objectMapKey0);
        }
        var linkedDevicesKeysMapValue = object.getValue();
        if (linkedDevicesKeysMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(linkedDevicesKeysMapValue);
        }
        return protoSize;
    }

    private static int sizeOfProperties(java.util.Map.Entry<java.lang.String, java.lang.String> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        protoSize += ProtobufOutputStream.getFieldSize(1, 2);
        protoSize += ProtobufOutputStream.getStringSize(objectMapKey);
        var propertiesMapValue = object.getValue();
        if (propertiesMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(propertiesMapValue);
        }
        return protoSize;
    }

    private static int sizeOfContacts(java.util.Map.Entry<it.auties.whatsapp.model.jid.Jid, it.auties.whatsapp.model.contact.Contact> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        var objectMapKey0 = objectMapKey.toString();
        if (objectMapKey0 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(objectMapKey0);
        }
        var contactsMapValue = object.getValue();
        if (contactsMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var contactsMapValueSerializedSize = it.auties.whatsapp.model.contact.ContactSpec.sizeOf(contactsMapValue);
            protoSize += ProtobufOutputStream.getVarIntSize(contactsMapValueSerializedSize);
            protoSize += contactsMapValueSerializedSize;
        }
        return protoSize;
    }

    private static int sizeOfPrivacySettings(java.util.Map.Entry<java.lang.String, it.auties.whatsapp.model.privacy.PrivacySettingEntry> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        protoSize += ProtobufOutputStream.getFieldSize(1, 2);
        protoSize += ProtobufOutputStream.getStringSize(objectMapKey);
        var privacySettingsMapValue = object.getValue();
        if (privacySettingsMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var privacySettingsMapValueSerializedSize = it.auties.whatsapp.model.privacy.PrivacySettingEntrySpec.sizeOf(privacySettingsMapValue);
            protoSize += ProtobufOutputStream.getVarIntSize(privacySettingsMapValueSerializedSize);
            protoSize += privacySettingsMapValueSerializedSize;
        }
        return protoSize;
    }

    private static int sizeOfCalls(java.util.Map.Entry<java.lang.String, it.auties.whatsapp.model.call.Call> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        protoSize += ProtobufOutputStream.getFieldSize(1, 2);
        protoSize += ProtobufOutputStream.getStringSize(objectMapKey);
        var callsMapValue = object.getValue();
        if (callsMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var callsMapValueSerializedSize = it.auties.whatsapp.model.call.CallSpec.sizeOf(callsMapValue);
            protoSize += ProtobufOutputStream.getVarIntSize(callsMapValueSerializedSize);
            protoSize += callsMapValueSerializedSize;
        }
        return protoSize;
    }

}
