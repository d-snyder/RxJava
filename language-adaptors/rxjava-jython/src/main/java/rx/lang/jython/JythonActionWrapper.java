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

import rx.util.functions.*;

/**
 * Concrete wrapper that accepts a {@link PyFunction} and produces any needed Rx {@link Action}.
 *
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 */
public class JythonActionWrapper<T1, T2, T3, T4> implements Action, Action0, Action1<T1>,
        Action2<T1, T2>, Action3<T1, T2, T3>, Action4<T1, T2, T3, T4> {

    PyFunction func = null;

    public JythonActionWrapper(PyFunction func) {
        this.func = func;
    }

    @Override
    public void call() {
        func.__call__();
    }

    @Override
    public void call(T1 t1) {
        func.__call__(Py.java2py(t1));
    }

    @Override
    public void call(T1 t1, T2 t2) {
        PyObject[] args = { Py.java2py(t1),
                            Py.java2py(t2)};
        func.__call__(args);
    }

    @Override
    public void call(T1 t1, T2 t2, T3 t3) {
        PyObject[] args = { Py.java2py(t1),
                            Py.java2py(t2),
                            Py.java2py(t3)};
        func.__call__(args);
    }

    @Override
    public void call(T1 t1, T2 t2, T3 t3, T4 t4) {
        PyObject[] args = { Py.java2py(t1),
                            Py.java2py(t2),
                            Py.java2py(t3),
                            Py.java2py(t4)};
        func.__call__(args);
    }
}
