/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.pops.script;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kp.pops.io.DataInputStream;
import kp.pops.io.DataOutputStream;
import kp.pops.rawdata.Raw;
import kp.pops.rawdata.SByte;
import kp.pops.rawdata.UInt16;
import kp.pops.utils.Const;

/**
 *
 * @author Asus
 */
public class Script
{
    private final Raw codes = new Raw(Const.MAX_CODES * 2);
    private final ScriptField[] fields = new ScriptField[Const.MAX_FIELDS];
    
    public final UInt16 getCode(int index)
    {
        if(index < 0 || index >= Const.MAX_CODES)
            throw new IndexOutOfBoundsException();
        return codes.unsignedInt16(index * 2);
    }
    
    public final void setCode(int index, UInt16 code)
    {
        if(index < 0 || index >= Const.MAX_CODES)
            throw new IndexOutOfBoundsException();
        codes.unsignedInt16(index, code);
    }
    
    public final void setVersion()
    {
        codes.signedByte(0, SByte.valueOf(12));
        codes.signedByte(1, SByte.ZERO);
    }
    public final int getVersion() { return codes.signedByte(0).intValue(); }
    
    public final ScriptField getField(int index)
    {
        if(index < 0 || index >= Const.MAX_FIELDS)
            throw new IndexOutOfBoundsException();
        var field = fields[index];
        return field == null ? ScriptField.INVALID : field;
    }
    
    public final void setField(int index, ScriptField field)
    {
        if(index < 0 || index >= Const.MAX_FIELDS)
            throw new IndexOutOfBoundsException();
        fields[index] = field == null ? ScriptField.INVALID : field;
    }
    
    
    public final void write(OutputStream out) throws IOException
    {
        if(out instanceof DataOutputStream)
            write((DataOutputStream) out);
        else write(new DataOutputStream(out));
    }
    public final void write(DataOutputStream out) throws IOException
    {
        out.writeRaw(codes);
        
        var buff = new byte[Const.MAX_FIELDS * 8];
        for(var i = 0; i < fields.length; i++)
            ScriptField.write(buff, i * 8, fields[i]);
        out.write(buff);
    }
    
    public final void read(InputStream in) throws IOException
    {
        if(in instanceof DataInputStream)
            read((DataInputStream) in);
        else read(new DataInputStream(in));
    }
    public final void read(DataInputStream in) throws IOException
    {
        in.readRaw(codes);
        
        var buff = in.readFully(Const.MAX_FIELDS * 8);
        for(var i = 0; i < fields.length; i++)
            fields[i] = ScriptField.read(buff, 0);
    }
}
