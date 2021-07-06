#!/usr/bin/env python

INT_MAX = 2 << 32 - 1

def swap(A,m,n):
    temp = A[m]
    A[m] = A[n]
    A[n] = temp

