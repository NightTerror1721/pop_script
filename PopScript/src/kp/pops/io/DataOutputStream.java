/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.pops.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import kp.pops.rawdata.Raw;
import kp.pops.rawdata.SByte;
import kp.pops.rawdata.SInt16;
import kp.pops.rawdata.SInt32;
import kp.pops.rawdata.SInt64;
import kp.pops.rawdata.UByte;
import kp.pops.rawdata.UInt16;
import kp.pops.rawdata.UInt32;

/**
 *
 * @author Asus
 */
public class DataOutputStream extends FilterOutputStream
{
    public DataOutputStream(OutputStream out)
    {
        super(out);
    }
    public DataOutputStream(Path path) throws IOException { this(Files.newOutputStream(path)); }
    
    @Override
    public final void write(byte b[], int off, int len) throws IOException
    {
        if((off | len | (b.length - (len + off)) | (off + len)) < 0)
            throw new IndexOutOfBoundsException();
        out.write(b, off, len);
    }
    
    public void writeByte(byte value) throws IOException { IOUtils.writeSignedByte(out, value); }
    public void writeShort(short value) throws IOException { IOUtils.writeSignedInt16(out, value); }
    public void writeInt(int value) throws IOException { IOUtils.writeSignedInt32(out, value); }
    public void writeLong(long value) throws IOException { IOUtils.writeSignedInt64(out, value); }
    
    public void writeShortB(short value) throws IOException { IOUtils.writeSignedInt16B(out, value); }
    public void writeIntB(int value) throws IOException { IOUtils.writeSignedInt32B(out, value); }
    public void writeLongB(long value) throws IOException { IOUtils.writeSignedInt64B(out, value); }
    
    public void writeSignedByte(SByte value) throws IOException { SByte.write(out, value); }
    public void writeSignedInt16(SInt16 value) throws IOException { SInt16.write(out, value); }
    public void writeSignedInt32(SInt32 value) throws IOException { SInt32.write(out, value); }
    public void writeSignedInt64(SInt64 value) throws IOException { SInt64.write(out, value); }
    
    public void writeSignedInt16B(SInt16 value) throws IOException { SInt16.writeB(out, value); }
    public void writeSignedInt32B(SInt32 value) throws IOException { SInt32.writeB(out, value); }
    public void writeSignedInt64B(SInt64 value) throws IOException { SInt64.writeB(out, value); }
    
    public void writeUnsignedByte(UByte value) throws IOException { UByte.write(out, value); }
    public void writeUnsignedInt16(UInt16 value) throws IOException { UInt16.write(out, value); }
    public void writeUnsignedInt32(UInt32 value) throws IOException { UInt32.write(out, value); }
    
    public void writeUnsignedInt16B(UInt16 value) throws IOException { UInt16.write(out, value); }
    public void writeUnsignedInt32B(UInt32 value) throws IOException { UInt32.write(out, value); }
    
    public void writeRaw(Raw raw) throws IOException { raw.write(out); }
    public void writeRaw(Raw raw, int off, int len) throws IOException { raw.write(out, off, len); }
    
    public void writeEmpty(int bytes) throws IOException { write(new byte[bytes], 0, bytes); }
}
