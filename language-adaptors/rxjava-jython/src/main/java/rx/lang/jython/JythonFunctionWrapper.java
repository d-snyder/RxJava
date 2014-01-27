/**
 * Copyright 2013 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rx.lang.jython;

import org.python.core.PyObject;
import org.python.core.PyFunction;
import org.python.core.Py;
import rx.util.functions.Func0;
import rx.util.functions.Func1;
import rx.util.functions.Func2;
import rx.util.functions.Func3;
import rx.util.functions.Func4;
import rx.util.functions.Func5;
import rx.util.functions.Func6;
import rx.util.functions.Func7;
import rx.util.functions.Func8;
import rx.util.functions.Func9;
import rx.util.functions.FuncN;
import rx.util.functions.Function;

/**
 * Concrete wrapper that accepts a {@link PyFunction} and produces any needed Rx {@link Function}.
 *
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 * @param <R>
 */
public class JythonFunctionWrapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements
        Func0<R>,
        Func1<T1, R>,
        Func2<T1, T2, R>,
        Func3<T1, T2, T3, R>,
        Func4<T1, T2, T3, T4, R>,
        Func5<T1, T2, T3, T4, T5, R>,
        Func6<T1, T2, T3, T4, T5, T6, R>,
        Func7<T1, T2, T3, T4, T5, T6, T7, R>,
        Func8<T1, T2, T3, T4, T5, T6, T7, T8, R>,
        Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>,
        FuncN<R> {

    private final PyFunction func;

    public JythonFunctionWrapper(PyFunction func) {
        this.func = func;
    }

    @Override
    public R call() {
        return (R) func.__call__();
    }

    @Override
    public R call(T1 t1) {
        return (R) func.__call__(Py.java2py(t1));
    }

    @Override
    public R call(T1 t1, T2 t2) {
        PyObject[] args = { Py.java2py(t1),
                            Py.java2py(t2) };
        return (R) func.__call__(args);
    }

    @Override
    public R call(T1 t1, T2 t2, T3 t3) {
        PyObject[] args = { Py.java2py(t1),
                            Py.java2py(t2),
                            Py.java2py(t3) };
        return (R) func.__call__(args);
    }

    @Override
    public R call(T1 t1, T2 t2, T3 t3, T4 t4) {
        PyObject[] args = { Py.java2py(t1),
                            Py.java2py(t2),
                            Py.java2py(t3),
                            Py.java2py(t4) };
        return (R) func.__call__(args);
    }

    @Override
    public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        PyObject[] args = { Py.java2py(t1),
                            Py.java2py(t2),
                            Py.java2py(t3),
                            Py.java2py(t4),
                            Py.java2py(t5) };
        return (R) func.__call__(args);
    }

    @Override
    public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        PyObject[] args = { Py.java2py(t1),
                            Py.java2py(t2),
                            Py.java2py(t3),
                            Py.java2py(t4),
                            Py.java2py(t5),
                            Py.java2py(t6) };
        return (R) func.__call__(args);
    }

    @Override
    public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        PyObject[] args = { Py.java2py(t1),
                            Py.java2py(t2),
                            Py.java2py(t3),
                            Py.java2py(t4),
                            Py.java2py(t5),
                            Py.java2py(t6),
                            Py.java2py(t7) };
        return (R) func.__call__(args);
    }

    @Override
    public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        PyObject[] args = { Py.java2py(t1),
                            Py.java2py(t2),
                            Py.java2py(t3),
                            Py.java2py(t4),
                            Py.java2py(t5),
                            Py.java2py(t6),
                            Py.java2py(t7),
                            Py.java2py(t8) };
        return (R) func.__call__(args);
    }

    @Override
    public R call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
        PyObject[] args = { Py.java2py(t1),
                            Py.java2py(t2),
                            Py.java2py(t3),
                            Py.java2py(t4),
                            Py.java2py(t5),
                            Py.java2py(t6),
                            Py.java2py(t7),
                            Py.java2py(t8),
                            Py.java2py(t9) };
        return (R) func.__call__(args);
    }

    @Override
    public R call(Object... args) {
        PyObject[] argArray = new PyObject[args.length];
        for (int i = 0; i < args.length; i++) {
            argArray[i] = Py.java2py(args[i]);
        }
        return (R) func.__call__(argArray);
    }
}
