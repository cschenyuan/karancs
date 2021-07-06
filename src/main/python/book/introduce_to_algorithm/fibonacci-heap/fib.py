#!/usr/bin/python


def fib_1(n):
    if n == 0 or n == 1 or n < 0 or type(n) is not int:
        return n
    return fib_1(n-1) + fib_1(n-2)
