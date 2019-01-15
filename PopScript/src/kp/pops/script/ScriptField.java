/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.pops.script;

import java.util.Objects;
import kp.pops.rawdata.SInt32;
import kp.pops.rawdata.UInt32;
import kp.pops.utils.Const.FieldType;

/**
 *
 * @author Asus
 */
public final class ScriptField
{
    private static final SInt32 INVALID_VALUE = SInt32.valueOf(3);
    public static final ScriptField INVALID = new ScriptField(FieldType.INVALID, INVALID_VALUE);
    
    private final FieldType type;
    private final SInt32 value;
    
    private ScriptField(FieldType type, SInt32 value)
    {
        this.type = Objects.requireNonNull(type);
        this.value = Objects.requireNonNull(value);
    }
    
    public static final ScriptField constant(SInt32 value) { return new ScriptField(FieldType.CONSTANT, value); }
    public static final ScriptField user(SInt32 value) { return new ScriptField(FieldType.USER, value); }
    public static final ScriptField internal(SInt32 value) { return new ScriptField(FieldType.INTERNAL, value); }
    
    public final FieldType getType() { return type; }
    public final boolean isConstant() { return type == FieldType.CONSTANT; }
    public final boolean isUser() { return type == FieldType.USER; }
    public final boolean isInternal() { return type == FieldType.INTERNAL; }
    public final boolean isInvalid() { return type == FieldType.INVALID; }
    
    public final SInt32 gerIndex() { return value; }
    public final SInt32 getValue() { return value; }
    
    public static final ScriptField read(byte[] b, int off)
    {
        var type = FieldType.decode(UInt32.read(b, off));
        if(type == FieldType.INVALID)
            return INVALID;
        var value = SInt32.read(b, off + 4);
        return new ScriptField(type, value);
    }
    
    public static final void write(byte[] b, int off, ScriptField field)
    {
        if(field == null)
            field = INVALID;
        UInt32.write(b, off, field.type.getCode());
        SInt32.write(b, off + 4, field.value);
    }
}
