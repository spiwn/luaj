/*******************************************************************************
 * Copyright (c) 2009 Luaj.org. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 ******************************************************************************/
package org.luaj.vm2;

import org.luaj.vm2.WeakTableTest.WeakKeyTableTest;
import org.luaj.vm2.WeakTableTest.WeakKeyValueTableTest;
import org.luaj.vm2.WeakTableTest.WeakValueTableTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

    public static Test suite() {
        TestSuite suite = new TestSuite("All Tests for Luaj-vm2");

        // vm tests
        TestSuite vm = new TestSuite("VM Tests");
        vm.addTestSuite(TypeTest.class);
        vm.addTestSuite(UnaryBinaryOperatorsTest.class);
        vm.addTestSuite(MetatableTest.class);
        vm.addTestSuite(StringTest.class);
        vm.addTestSuite(VarargsTest.class);
        suite.addTest(vm);

        // table tests
        TestSuite table = new TestSuite("Table Tests");
        table.addTestSuite(TableTest.class);
        table.addTestSuite(TableHashTest.class);
        table.addTestSuite(WeakValueTableTest.class);
        table.addTestSuite(WeakKeyTableTest.class);
        table.addTestSuite(WeakKeyValueTableTest.class);
        suite.addTest(table);

        // I/O tests
        TestSuite io = new TestSuite("I/O Tests");
        io.addTestSuite(BufferedStreamTest.class);
        suite.addTest(io);

        return suite;
    }

}
