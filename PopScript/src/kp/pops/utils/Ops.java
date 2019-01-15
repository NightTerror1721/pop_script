/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.pops.utils;

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
public interface Ops
{
    double E = Math.E;
    double PI = Math.PI;
    double DEGREES_TO_RADIANS = 0.017453292519943295;
    double RADIANS_TO_DEGREES = 57.29577951308232;
    
    static double sin(double a) { return StrictMath.sin(a); }
    static double cos(double a) { return StrictMath.cos(a); }
    static double tan(double a) { return StrictMath.tan(a); }
    
    static double asin(double a) { return StrictMath.asin(a); }
    static double acos(double a) { return StrictMath.acos(a); }
    static double atan(double a) { return StrictMath.atan(a); }
    
    static double toRadians(double angdeg) { return angdeg * DEGREES_TO_RADIANS; }
    static double toDegrees(double angrad) { return angrad * RADIANS_TO_DEGREES; }
    
    static double exp(double a) { return StrictMath.exp(a); }
    
    static double log(double a) { return StrictMath.log(a); }
    static double log10(double a) { return StrictMath.log10(a); }
    
    static double sqrt(double a) { return StrictMath.sqrt(a); }
    
    static double cbrt(double a) { return StrictMath.cbrt(a); }
    
    static double IEEEremainder(double f1, double f2) { return StrictMath.IEEEremainder(f1, f2); }
    
    static double ceil(double a) { return StrictMath.ceil(a); }
    
    static double floor(double a) { return StrictMath.floor(a); }
    
    static double rint(double a) { return StrictMath.rint(a); }
    
    static double atan2(double y, double x) { return StrictMath.atan2(y, x); }
    
    static double pow(double a, double b) { return StrictMath.pow(a, b); }
    
    static double round(float a) { return Math.round(a); }
    static double round(double a) { return Math.round(a); }
    
    static double random() { return Math.random(); }
    
    static int addExact(int x, int y) { return Math.addExact(x, y); }
    static long addExact(long x, long y) { return Math.addExact(x, y); }
    
    static int subtractExact(int x, int y) { return Math.subtractExact(x, y); }
    static long subtractExact(long x, long y) { return Math.subtractExact(x, y); }
    
    static int multiplyExact(int x, int y) { return Math.multiplyExact(x, y); }
    static long multiplyExact(long x, int y) { return Math.multiplyExact(x, y); }
    static long multiplyExact(long x, long y) { return Math.multiplyExact(x, y); }
    
    static int incrementExact(int a) { return Math.incrementExact(a); }
    static long incrementExact(long a) { return Math.incrementExact(a); }
    
    static int decrementExact(int a) { return Math.decrementExact(a); }
    static long decrementExact(long a) { return Math.decrementExact(a); }
    
    static int negateExact(int a) { return Math.negateExact(a); }
    static long negateExact(long a) { return Math.negateExact(a); }
    
    static int toIntExact(long value) { return Math.toIntExact(value); }
    
    static long multiplyFull(int x, int y) { return Math.multiplyFull(x, y); }
    
    static long multiplyHigh(long x, long y) { return Math.multiplyHigh(x, y); }
    
    static int floorDiv(int x, int y) { return Math.floorDiv(x, y); }
    static long floorDiv(long x, int y) { return Math.floorDiv(x, y); }
    static long floorDiv(long x, long y) { return Math.floorDiv(x, y); }
    
    static int floorMod(int x, int y) { return Math.floorMod(x, y); }
    static long floorMod(long x, int y) { return Math.floorMod(x, y); }
    static long floorMod(long x, long y) { return Math.floorMod(x, y); }
    
    static int abs(int a) { return a < 0 ? -a : a; }
    static long abs(long a) { return a < 0 ? -a : a; }
    static float abs(float a) { return a <= 0f ? 0f - a : a; }
    static double abs(double a) { return a <= 0d ? 0d - a : a; }
    
    static int max(int a, int b) { return a >= b ? a : b; }
    static long max(long a, long b) { return a >= b ? a : b; }
    static float max(float a, float b) { return Math.max(a, b); }
    static double max(double a, double b) { return Math.max(a, b); }
    static SByte max(SByte a, SByte b) { return SByte.valueOf(max(a.intValue(), b.intValue())); }
    static UByte max(UByte a, UByte b) { return UByte.valueOf(max(a.intValue(), b.intValue())); }
    static SInt16 max(SInt16 a, SInt16 b) { return SInt16.valueOf(max(a.intValue(), b.intValue())); }
    static UInt16 max(UInt16 a, UInt16 b) { return UInt16.valueOf(max(a.intValue(), b.intValue())); }
    static SInt32 max(SInt32 a, SInt32 b) { return SInt32.valueOf(max(a.intValue(), b.intValue())); }
    static UInt32 max(UInt32 a, UInt32 b) { return UInt32.valueOf(max(a.longValue(), b.longValue())); }
    static SInt64 max(SInt64 a, SInt64 b) { return SInt64.valueOf(max(a.longValue(), b.longValue())); }
    
    static int min(int a, int b) { return a <= b ? a : b; }
    static long min(long a, long b) { return a <= b ? a : b; }
    static float min(float a, float b) { return Math.min(a, b); }
    static double min(double a, double b) { return Math.min(a, b); }
    static SByte min(SByte a, SByte b) { return SByte.valueOf(min(a.intValue(), b.intValue())); }
    static UByte min(UByte a, UByte b) { return UByte.valueOf(min(a.intValue(), b.intValue())); }
    static SInt16 min(SInt16 a, SInt16 b) { return SInt16.valueOf(min(a.intValue(), b.intValue())); }
    static UInt16 min(UInt16 a, UInt16 b) { return UInt16.valueOf(min(a.intValue(), b.intValue())); }
    static SInt32 min(SInt32 a, SInt32 b) { return SInt32.valueOf(min(a.intValue(), b.intValue())); }
    static UInt32 min(UInt32 a, UInt32 b) { return UInt32.valueOf(min(a.longValue(), b.longValue())); }
    static SInt64 min(SInt64 a, SInt64 b) { return SInt64.valueOf(min(a.longValue(), b.longValue())); }
    
    static float fma(float a, float b, float c) { return Math.fma(a, b, c); }
    static double fma(double a, double b, double c) { return Math.fma(a, b, c); }
    
    static float ulp(float f) { return Math.ulp(f); }
    static double ulp(double d) { return Math.ulp(d); }
    
    static float signum(float f) { return f == 0f || Float.isNaN(f) ? f : Math.copySign(1f, f); }
    static double signum(double d) { return d == 0f || Double.isNaN(d) ? d : Math.copySign(1f, d); }
    
    static double sinh(double x) { return StrictMath.sinh(x); }
    static double cosh(double x) { return StrictMath.cosh(x); }
    static double tanh(double x) { return StrictMath.tanh(x); }
    
    static double hypot(double x, double y) { return StrictMath.hypot(x, y); }
    
    static double expm1(double x) { return StrictMath.expm1(x); }
    
    static double log1p(double x) { return StrictMath.log1p(x); }
    
    static float copySign(float magnitude, float sign) { return Math.copySign(magnitude, sign); }
    static double copySign(double magnitude, double sign) { return Math.copySign(magnitude, sign); }
    
    static int getExponent(float f) { return Math.getExponent(f); }
    static int getExponent(double d) { return Math.getExponent(d); }
    
    static float nextAfter(float start, float direction) { return Math.nextAfter(start, direction); }
    static double nextAfter(double start, double direction) { return Math.nextAfter(start, direction); }
    
    static float nextUp(float f) { return Math.nextUp(f); }
    static double nextUp(double d) { return Math.nextUp(d); }
    
    static float nextDown(float f) { return Math.nextDown(f); }
    static double nextDown(double d) { return Math.nextDown(d); }
    
    static float scalb(float d, int scaleFactor) { return Math.scalb(d, scaleFactor); }
    static double scalb(double d, int scaleFactor) { return Math.scalb(d, scaleFactor); }
    
    static int range(int min, int max, int value) { return min(min(min, max), max(max(min, max), value)); }
    static long range(long min, long max, long value) { return min(min(min, max), max(max(min, max), value)); }
    static float range(float min, float max, float value) { return min(min(min, max), max(max(min, max), value)); }
    static double range(double min, double max, double value) { return min(min(min, max), max(max(min, max), value)); }
    static SByte range(SByte min, SByte max, SByte value) { return min(min(min, max), max(max(min, max), value)); }
    static UByte range(UByte min, UByte max, UByte value) { return min(min(min, max), max(max(min, max), value)); }
    static SInt16 range(SInt16 min, SInt16 max, SInt16 value) { return min(min(min, max), max(max(min, max), value)); }
    static UInt16 range(UInt16 min, UInt16 max, UInt16 value) { return min(min(min, max), max(max(min, max), value)); }
    static SInt32 range(SInt32 min, SInt32 max, SInt32 value) { return min(min(min, max), max(max(min, max), value)); }
    static UInt32 range(UInt32 min, UInt32 max, UInt32 value) { return min(min(min, max), max(max(min, max), value)); }
    static SInt64 range(SInt64 min, SInt64 max, SInt64 value) { return min(min(min, max), max(max(min, max), value)); }

    
    
}
