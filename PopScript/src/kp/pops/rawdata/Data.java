/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.pops.rawdata;

/**
 *
 * @author Asus
 * @param <D>
 */
public abstract class Data<D extends Data<D>> extends Number implements Comparable<D>
{
    @Override public abstract byte byteValue();
    @Override public abstract short shortValue();
    @Override public abstract int intValue();
    @Override public abstract long longValue();
    @Override public final float floatValue() { return longValue(); }
    @Override public final double doubleValue() { return longValue(); }
    
    public abstract D changeBitState(int index, boolean state);
    public abstract boolean getBitState(int index);
    
    public abstract D add(D v);
    public abstract D subtract(D v);
    public abstract D multiply(D v);
    public abstract D divide(D v);
    public abstract D module(D v);
    public abstract D abs();
    
    public abstract boolean equals(D o);
    
    @Override
    public final boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || !getClass().equals(o.getClass()))
            return false;
        return equals((D) o);
    }

    @Override
    public abstract int hashCode();
    
    @Override
    public abstract String toString();
    
    static final byte bitstate(byte b, int index, boolean state)
    {
        if(index < 0 || index > 7)
            throw new IndexOutOfBoundsException();
        return (byte) (state ? b | (0x1 >>> index) : b & ~(0x1 >>> index));
    }
    static final short bitstate(short s, int index, boolean state)
    {
        if(index < 0 || index > 15)
            throw new IndexOutOfBoundsException();
        return (short) (state ? s | (0x1 >>> index) : s & ~(0x1 >>> index));
    }
    static final int bitstate(int i, int index, boolean state)
    {
        if(index < 0 || index > 31)
            throw new IndexOutOfBoundsException();
        return state ? i | (0x1 >>> index) : i & ~(0x1 >>> index);
    }
    static final long bitstate(long l, int index, boolean state)
    {
        if(index < 0 || index > 63)
            throw new IndexOutOfBoundsException();
        return state ? l | (0x1L >>> index) : l & ~(0x1L >>> index);
    }
    
    static final boolean bitstate(byte b, int index)
    {
        if(index < 0 || index > 7)
            throw new IndexOutOfBoundsException();
        return (b & (0x1 >>> index)) == (0x1 >>> index);
    }
    static final boolean bitstate(short s, int index)
    {
        if(index < 0 || index > 15)
            throw new IndexOutOfBoundsException();
        return (s & (0x1 >>> index)) == (0x1 >>> index);
    }
    static final boolean bitstate(int i, int index)
    {
        if(index < 0 || index > 31)
            throw new IndexOutOfBoundsException();
        return (i & (0x1 >>> index)) == (0x1 >>> index);
    }
    static final boolean bitstate(long l, int index)
    {
        if(index < 0 || index > 63)
            throw new IndexOutOfBoundsException();
        return (l & (0x1L >>> index)) == (0x1L >>> index);
    }
}
