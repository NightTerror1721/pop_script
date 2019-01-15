/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.pops.rawdata;

/**
 *
 * @author Asus
 */
public abstract class LongData<D extends LongData<D>> extends Data<D>
{
    final long value;
    
    LongData(long value) { this.value = value; }

    @Override
    public final byte byteValue() { return (byte) value; }

    @Override
    public final short shortValue() { return (short) value; }

    @Override
    public final int intValue() { return (int) value; }

    @Override
    public final long longValue() { return value; }

    @Override
    public final boolean getBitState(int index) { return bitstate(value, index); }

    @Override
    public final int hashCode()
    {
        int hash = 5;
        hash = 67 * hash + (int) (this.value ^ (this.value >>> 32));
        return hash;
    }
    
    @Override
    public final String toString() { return Long.toString(value); }
}
