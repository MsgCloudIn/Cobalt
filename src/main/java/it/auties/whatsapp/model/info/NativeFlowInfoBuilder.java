package it.auties.whatsapp.model.info;

public class NativeFlowInfoBuilder {
    private java.lang.String name;
    private java.lang.String parameters;

    public NativeFlowInfoBuilder() {
        name = null;
        parameters = null;
    }

    public NativeFlowInfoBuilder name(java.lang.String name) {
        this.name = name;
        return this;
    }

    public NativeFlowInfoBuilder parameters(java.lang.String parameters) {
        this.parameters = parameters;
        return this;
    }

    public it.auties.whatsapp.model.info.NativeFlowInfo build() {
        return new it.auties.whatsapp.model.info.NativeFlowInfo(name, parameters);
    }

}
