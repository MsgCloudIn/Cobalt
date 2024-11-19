package it.auties.whatsapp.model.signal.auth;

public class CompanionRegistrationDataBuilder {
    private byte[] eRegid;
    private byte[] eKeytype;
    private byte[] eIdent;
    private byte[] eSkeyId;
    private byte[] eSkeyVal;
    private byte[] eSkeySig;
    private byte[] buildHash;
    private byte[] companionProps;

    public CompanionRegistrationDataBuilder() {
        eRegid = null;
        eKeytype = null;
        eIdent = null;
        eSkeyId = null;
        eSkeyVal = null;
        eSkeySig = null;
        buildHash = null;
        companionProps = null;
    }

    public CompanionRegistrationDataBuilder eRegid(byte[] eRegid) {
        this.eRegid = eRegid;
        return this;
    }

    public CompanionRegistrationDataBuilder eKeytype(byte[] eKeytype) {
        this.eKeytype = eKeytype;
        return this;
    }

    public CompanionRegistrationDataBuilder eIdent(byte[] eIdent) {
        this.eIdent = eIdent;
        return this;
    }

    public CompanionRegistrationDataBuilder eSkeyId(byte[] eSkeyId) {
        this.eSkeyId = eSkeyId;
        return this;
    }

    public CompanionRegistrationDataBuilder eSkeyVal(byte[] eSkeyVal) {
        this.eSkeyVal = eSkeyVal;
        return this;
    }

    public CompanionRegistrationDataBuilder eSkeySig(byte[] eSkeySig) {
        this.eSkeySig = eSkeySig;
        return this;
    }

    public CompanionRegistrationDataBuilder buildHash(byte[] buildHash) {
        this.buildHash = buildHash;
        return this;
    }

    public CompanionRegistrationDataBuilder companionProps(byte[] companionProps) {
        this.companionProps = companionProps;
        return this;
    }

    public it.auties.whatsapp.model.signal.auth.CompanionRegistrationData build() {
        return new it.auties.whatsapp.model.signal.auth.CompanionRegistrationData(eRegid, eKeytype, eIdent, eSkeyId, eSkeyVal, eSkeySig, buildHash, companionProps);
    }

}
