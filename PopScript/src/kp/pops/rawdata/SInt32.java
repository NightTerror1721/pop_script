/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.pops.rawdata;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kp.pops.io.IOUtils;
import kp.pops.utils.Ops;

/**
 *
 * @author Asus
 */
public final class SInt32 extends IntData<SInt32>
{
    public static final SInt32 MINUSONE = new SInt32(-1);
    public static final SInt32 ZERO = new SInt32(0);
    public static final SInt32 ONE = new SInt32(1);
    
    public static final SInt32 MAX = new SInt32(0x7fffffff);
    public static final SInt32 MIN = new SInt32(0x80000000);
    
    public SInt32(int value) { super(value); }

    @Override
    public SInt32 changeBitState(int index, boolean state) { return new SInt32(bitstate(value, index, state)); }
    
    @Override public SInt32 add(SInt32 v) { return new SInt32(value + v.value); }
    @Override public SInt32 subtract(SInt32 v) { return new SInt32(value - v.value); }
    @Override public SInt32 multiply(SInt32 v) { return new SInt32(value * v.value); }
    @Override public SInt32 divide(SInt32 v) { return new SInt32(value / v.value); }
    @Override public SInt32 module(SInt32 v) { return new SInt32(value % v.value); }
    @Override public SInt32 abs() { return new SInt32(Ops.abs(value)); }

    @Override
    public boolean equals(SInt32 o) { return value == o.value; }

    @Override
    public int compareTo(SInt32 o) { return Integer.compare(value, o.value); }
    
    public static final SInt32 valueOf(byte value) { return new SInt32(value); }
    public static final SInt32 valueOf(short value) { return new SInt32(value); }
    public static final SInt32 valueOf(int value) { return new SInt32(value); }
    public static final SInt32 valueOf(long value) { return new SInt32((int) value); }
    
    public static final SInt32 valueOf(Data data) { return new SInt32(data.intValue()); }
    public static final SInt32 valueOf(Number number) { return new SInt32(number.intValue()); }
    
    public static final void write(byte[] buffer, int offset, SInt32 value) { IOUtils.writeSignedInt32(buffer, offset, value.value); }
    public static final SInt32 read(byte[] buffer, int offset) { return new SInt32(IOUtils.readSignedInt32(buffer, offset)); }
    
    public static final void writeB(byte[] buffer, int offset, SInt32 value) { IOUtils.writeSignedInt32B(buffer, offset, value.value); }
    public static final SInt32 readB(byte[] buffer, int offset) { return new SInt32(IOUtils.readSignedInt32B(buffer, offset)); }
    
    public static final void write(OutputStream os, SInt32 value) throws IOException { IOUtils.writeSignedInt32(os, value.value); }
    public static final SInt32 read(InputStream is) throws IOException { return new SInt32(IOUtils.readSignedInt32(is)); }
    
    public static final void writeB(OutputStream os, SInt32 value) throws IOException { IOUtils.writeSignedInt32B(os, value.value); }
    public static final SInt32 readB(InputStream is) throws IOException { return new SInt32(IOUtils.readSignedInt32B(is)); }
}
