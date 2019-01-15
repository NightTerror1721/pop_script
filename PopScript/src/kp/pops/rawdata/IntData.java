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
public abstract class IntData<D extends IntData<D>> extends Data<D>
{
    final int value;
    
    IntData(int value) { this.value = value; }

    @Override
    public final byte byteValue() { return (byte) value; }

    @Override
    public final short shortValue() { return (short) value; }

    @Override
    public final int intValue() { return value; }

    @Override
    public final long longValue() { return value; }

    @Override
    public final boolean getBitState(int index) { return bitstate(value, index); }

    @Override
    public final int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + this.value;
        return hash;
    }
    
    @Override
    public final String toString() { return Integer.toString(value); }
}
