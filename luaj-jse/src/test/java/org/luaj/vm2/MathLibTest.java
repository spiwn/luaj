package org.luaj.vm2;

import org.luaj.vm2.lib.jse.JsePlatform;

import junit.framework.TestCase;

public class MathLibTest extends TestCase {

    private LuaValue j2se;
    private boolean supportedOnJ2me;

       private static double[] trigArgs = new double[] {
                0,
                Math.PI/8,
                Math.PI*7/8,
                Math.PI*8/8,
                Math.PI*9/8,
                -Math.PI/8,
                -Math.PI*7/8,
                -Math.PI*8/8,
                -Math.PI*9/8
        };

    public MathLibTest() {
        j2se = JsePlatform.standardGlobals().get("math");
    }

    @Override
    protected void setUp() throws Exception {
        supportedOnJ2me = true;
    }

//    public void testMathDPow() {
//        assertEquals( 1, j2mepow(2, 0), 0 );
//        assertEquals( 2, j2mepow(2, 1), 0 );
//        assertEquals( 8, j2mepow(2, 3), 0 );
//        assertEquals( -8, j2mepow(-2, 3), 0 );
//        assertEquals( 1/8., j2mepow(2, -3), 0 );
//        assertEquals( -1/8., j2mepow(-2, -3), 0 );
//        assertEquals( 16, j2mepow(256,  .5), 0 );
//        assertEquals(  4, j2mepow(256, .25), 0 );
//        assertEquals( 64, j2mepow(256, .75), 0 );
//        assertEquals( 1./16, j2mepow(256, - .5), 0 );
//        assertEquals( 1./ 4, j2mepow(256, -.25), 0 );
//        assertEquals( 1./64, j2mepow(256, -.75), 0 );
//        assertEquals( Double.NaN, j2mepow(-256,  .5), 0 );
//        assertEquals(   1, j2mepow(.5, 0), 0 );
//        assertEquals(  .5, j2mepow(.5, 1), 0 );
//        assertEquals(.125, j2mepow(.5, 3), 0 );
//        assertEquals(   2, j2mepow(.5, -1), 0 );
//        assertEquals(   8, j2mepow(.5, -3), 0 );
//        assertEquals(1, j2mepow(0.0625, 0), 0 );
//        assertEquals(0.00048828125, j2mepow(0.0625, 2.75), 0 );
//    }
//
//    private double j2mepow(double x, double y) {
//        return j2me.get("pow").call(LuaValue.valueOf(x),LuaValue.valueOf(y)).todouble();
//    }

    public void testAbs() {
        double[] args = new double[] {23.45, -23.45};
        for (int i = 0; i < args.length; i++) {
            tryUnaryMathOp("abs", args[i], Math.abs(args[i]));
        }
    }

    public void testCos() {
        for (int i = 0; i < trigArgs.length; i++) {
            tryUnaryMathOp("cos", trigArgs[i], Math.cos(trigArgs[i]));
        }
    }

    public void testCosh() {
        supportedOnJ2me = false;
        for (int i = 0; i < trigArgs.length; i++) {
            tryUnaryMathOp("cosh", trigArgs[i], Math.cosh(trigArgs[i]));
        }
    }

    public void testDeg() {
        for (int i = 0; i < trigArgs.length; i++) {
            tryUnaryMathOp("deg", trigArgs[i], Math.toDegrees(trigArgs[i]));
        }
    }

    public void testExp() {
        //supportedOnJ2me = false;
        double args[] = new double[] {0, 0.1, .9, 1., 9, -.1, -.9, -1, -9};
        for (int i = 0; i < args.length; i++) {
            tryUnaryMathOp("exp", args[i], Math.exp(args[i]));
        }
    }

    public void testLog() {
        supportedOnJ2me = false;
        double args[] = new double[] {0.1, .9, 1., 9, -.1, -.9, -1, -9};
        for (int i = 0; i < args.length; i++) {
            tryUnaryMathOp("log", args[i], Math.log(args[i]));
        }
    }

    public void testRad() {
        double args[] = new double[] {0, 0.1, .9, 1., 9, 10, 100, -.1, -.9, -1, -9, -10, -100};
        for (int i = 0; i < args.length; i++) {
            tryUnaryMathOp("rad", args[i], Math.toRadians(args[i]));
        }
    }

    public void testSin() {
        for (int i = 0; i < trigArgs.length; i++) {
            tryUnaryMathOp("sin", trigArgs[i], Math.sin(trigArgs[i]));
        }
    }

    public void testSinh() {
        supportedOnJ2me = false;
        for (int i = 0; i < trigArgs.length; i++) {
            tryUnaryMathOp("sinh", trigArgs[i], Math.sinh(trigArgs[i]));
        }
    }

    public void testSqrt() {
        double args[] = new double[] {0, 0.1, .9, 1., 9, 10, 100};
        for (int i = 0; i < args.length; i++) {
            tryUnaryMathOp("sqrt", args[i], Math.sqrt(args[i]));
        }
    }
    public void testTan() {
        for (int i = 0; i < trigArgs.length; i++) {
            tryUnaryMathOp("tan", trigArgs[i], Math.tan(trigArgs[i]));
        }
    }

    public void testTanh() {
        supportedOnJ2me = false;
        for (int i = 0; i < trigArgs.length; i++) {
            tryUnaryMathOp("tanh", trigArgs[i], Math.tanh(trigArgs[i]));
        }
    }

    public void testAtan2() {
        supportedOnJ2me = false;

        // y>0, x>0
        tryAtan2( 0.1, 4.0 );
        tryAtan2( .9, 4.0 );
        tryAtan2( 1., 4.0 );
        tryAtan2( 9, 4.0 );
        tryAtan2( 10, 4.0 );
        tryAtan2( 100, 4.0 );

        // y>0, x<0
        tryAtan2( 0.1, -4.0 );
        tryAtan2( .9, -4.0 );
        tryAtan2( 1., -4.0 );
        tryAtan2( 9, -4.0 );
        tryAtan2( 10, -4.0 );
        tryAtan2( 100, -4.0 );

        // y<0, x>0
        tryAtan2( -0.1, 4.0 );
        tryAtan2( -.9, 4.0 );
        tryAtan2( -1., 4.0 );
        tryAtan2( -9, 4.0 );
        tryAtan2( -10, 4.0 );
        tryAtan2( -100, 4.0 );

        // y<0, x<0
        tryAtan2( -0.1, -4.0 );
        tryAtan2( -.9, -4.0 );
        tryAtan2( -1., -4.0 );
        tryAtan2( -9, -4.0 );
        tryAtan2( -10, -4.0 );
        tryAtan2( -100, -4.0 );

        // degenerate cases
        tryAtan2( 0, 1 );
        tryAtan2( 1, 0 );
        tryAtan2( -1, 0 );
        tryAtan2( 0, -1 );
        tryAtan2( 0, 0 );
    }

    public void tryAtan2(double a, double b) {
        tryMathOp("atan2", a, b, Math.atan2(a, b));
    }

    public void testFmod() {

        // y>0, x>0
        tryFloorMod( 0.1, 4.0 );
        tryFloorMod( .9, 4.0 );
        tryFloorMod( 1., 4.0 );
        tryFloorMod( 9, 4.0 );
        tryFloorMod( 10, 4.0 );
        tryFloorMod( 100, 4.0 );

        // y>0, x<0
        tryFloorMod( 0.1, -4.0 );
        tryFloorMod( .9, -4.0 );
        tryFloorMod( 1., -4.0 );
        tryFloorMod( 9, -4.0 );
        tryFloorMod( 10, -4.0 );
        tryFloorMod( 100, -4.0 );

        // y<0, x>0
        tryFloorMod( -0.1, 4.0 );
        tryFloorMod( -.9, 4.0 );
        tryFloorMod( -1., 4.0 );
        tryFloorMod( -9, 4.0 );
        tryFloorMod( -10, 4.0 );
        tryFloorMod( -100, 4.0 );

        // y<0, x<0
        tryFloorMod( -0.1, -4.0 );
        tryFloorMod( -.9, -4.0 );
        tryFloorMod( -1., -4.0 );
        tryFloorMod( -9, -4.0 );
        tryFloorMod( -10, -4.0 );
        tryFloorMod( -100, -4.0 );

        // degenerate cases
        tryFloorMod( 0, 1 );
        tryFloorMod( 1, 0 );
        tryFloorMod( -1, 0 );
        tryFloorMod( 0, -1 );
        tryFloorMod( 0, 0 );
    }

   public void tryFloorMod(double a, double b) {
        tryMathOp("fmod", a, b, a % b);
    }

    public void testPow() {

        // y>0, x>0
        tryPow( 0.1, 4.0 );
        tryPow( .9, 4.0 );
        tryPow( 1., 4.0 );
        tryPow( 9, 4.0 );
        tryPow( 10, 4.0 );
        tryPow( 100, 4.0 );

        // y>0, x<0
        tryPow( 0.1, -4.0 );
        tryPow( .9, -4.0 );
        tryPow( 1., -4.0 );
        tryPow( 9, -4.0 );
        tryPow( 10, -4.0 );
        tryPow( 100, -4.0 );

        // degenerate cases
        tryPow( 0, 1 );
        tryPow( 1, 0 );
        tryPow( -1, 0 );
        tryPow( 0, -1 );
        tryPow( 0, 0 );
    }

    public void tryPow(double a, double b) {
        tryMathOp("pow", a, b, Math.pow(a, b));
    }

    private void tryUnaryMathOp(String op, double x, double expected) {
        try {
            double actual = j2se.get(op).call( LuaValue.valueOf(x)).todouble();
            if ( supportedOnJ2me )
                assertEquals( expected, actual, 1.e-4 );
            else
                fail("j2me should throw exception for math."+op+" but returned "+actual);
        } catch ( LuaError lee ) {
            if ( supportedOnJ2me )
                throw lee;
        }
    }


    private void tryMathOp(String op, double a, double b, double expected) {
        try {
            double actual = j2se.get(op).call( LuaValue.valueOf(a), LuaValue.valueOf(b)).todouble();
            if ( supportedOnJ2me )
                assertEquals( expected, actual, 1.e-5 );
            else
                fail("j2me should throw exception for math."+op+" but returned "+actual);
        } catch ( LuaError lee ) {
            if ( supportedOnJ2me )
                throw lee;
        }
    }
}
