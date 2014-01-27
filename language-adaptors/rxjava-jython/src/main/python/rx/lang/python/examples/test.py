__author__ = 'David Snyder'

import rx.Observable
import rx.lang.jython.JythonActionWrapper as actWrap
import rx.lang.jython.JythonFunctionWrapper as funcWrap

# Consider this file a scratch pad.  There is still much work to be done on this.

# #Monkey Patch
# real_map = rx.Observable.map
# def map(self, func):
#     return real_map(self,funcwrap(func))
# rx.Observable.map = map


def oncompleted(x):
    print "Success! " + x


def onerror(x):
    print "An error occurred " + x


def example1():
    rx.Observable.from(["This", "Is", "Cool"])\
        .skip(1)\
        .take(2)\
        .map(funcWrap(lambda x: "Mapped("+x+")")).subscribe(actWrap(oncompleted), actWrap(onerror))


if __name__ == '__main__':
    example1()
