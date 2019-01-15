/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.pops.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
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
public class DataInputStream extends FilterInputStream
{
    public DataInputStream(InputStream in) { super(in); }
    public DataInputStream(Path path) throws IOException { this(Files.newInputStream(path)); }
    
    public byte readByte() throws IOException { return IOUtils.readSignedByte(in); }
    public short readShort() throws IOException { return IOUtils.readSignedInt16(in); }
    public int readInt() throws IOException { return IOUtils.readSignedInt32(in); }
    public long readLong() throws IOException { return IOUtils.readSignedInt64(in); }
    
    public short readShortB() throws IOException { return IOUtils.readSignedInt16B(in); }
    public int readIntB() throws IOException { return IOUtils.readSignedInt32B(in); }
    public long readLongB() throws IOException { return IOUtils.readSignedInt64B(in); }
    
    public SByte readSignedByte() throws IOException { return SByte.read(in); }
    public SInt16 readSignedInt16() throws IOException { return SInt16.read(in); }
    public SInt32 readSignedInt32() throws IOException { return SInt32.read(in); }
    public SInt64 readSignedInt64() throws IOException { return SInt64.read(in); }
    
    public SInt16 readSignedInt16B() throws IOException { return SInt16.readB(in); }
    public SInt32 readSignedInt32B() throws IOException { return SInt32.readB(in); }
    public SInt64 readSignedInt64B() throws IOException { return SInt64.readB(in); }
    
    public UByte readUnsignedByte() throws IOException { return UByte.read(in); }
    public UInt16 readUnsignedInt16() throws IOException { return UInt16.read(in); }
    public UInt32 readUnsignedInt32() throws IOException { return UInt32.read(in); }
    
    public UInt16 readUnsignedInt16B() throws IOException { return UInt16.readB(in); }
    public UInt32 readUnsignedInt32B() throws IOException { return UInt32.readB(in); }
    
    public Raw readRaw(Raw raw) throws IOException { raw.read(in); return raw; }
    public Raw readRaw(Raw raw, int off, int len) throws IOException { raw.read(in, off, len); return raw; }
    
    public Raw readRaw(int len) throws IOException { return readRaw(new Raw(len)); }
    
    public void skipFully(int n) throws IOException { IOUtils.skipFully(in, n); }
    
    public void readFully(byte[] b, int off, int len) throws IOException { IOUtils.readFully(in, b, off, len); }
    public void readFully(byte[] b) throws IOException { IOUtils.readFully(in, b); }
    public byte[] readFully(int blen) throws IOException { return IOUtils.readFully(in, blen); }
    
}
