package org.cf.smalivm.type;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.dexlib2.writer.builder.BuilderClassDef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Nullable;

public abstract class VirtualGeneric {

    private static final Logger log = LoggerFactory.getLogger(VirtualGeneric.class.getSimpleName());

    protected static ClassManager classManager;
    private final TypeReference typeReference;
    private final String internalName;
    private final String binaryName;
    private final String sourceName;

    VirtualGeneric(TypeReference typeReference, String internalName, String binaryName, String sourceName) {
        this.typeReference = typeReference;
        this.internalName = internalName;
        this.binaryName = binaryName;
        this.sourceName = sourceName;
    }

    static ClassManager getClassManager() {
        return classManager;
    }

    static void setClassManager(ClassManager classManager) {
        VirtualGeneric.classManager = classManager;
    }

    public abstract Set<? extends VirtualGeneric> getAncestors();

    public String getPackage() {
        return null;
    }

    public String getBinaryName() {
        return binaryName;
    }

    public
    @Nullable
    VirtualField getField(String fieldName) {
        return null;
    }

    public abstract Collection<VirtualField> getFields();

    public
    @Nullable
    VirtualMethod getMethod(String methodDescriptor) {
        return null;
    }

    public abstract Collection<VirtualMethod> getMethods();

    public String getName() {
        return internalName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public final TypeReference getTypeReference() {
        return typeReference;
    }

    public BuilderClassDef getClassDef() {
        return null;
    }

    public boolean isInnerClassOf(VirtualGeneric other) {
        return false;
    }

    public boolean isSamePackageOf(VirtualGeneric other) {
        return false;
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder(423, 15).append(getName()).hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        VirtualGeneric rhs = (VirtualGeneric) obj;

        return new EqualsBuilder().append(getName(), rhs.getName()).isEquals();
    }

    @Override
    public final String toString() {
        return getName();
    }

    public abstract boolean instanceOf(VirtualGeneric targetType);

    public abstract boolean isArray();

    public abstract boolean isPrimitive();

}
