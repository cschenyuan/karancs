#!/usr/bin/env python
#
# THIS FILE IS A PART OF EXERCISES OF <Introduce to algorithm>
# Created by Chen Yuan<cschenyuan@gmail.com> at 07/2016
# All rights reserved
#

def xor(a,b):
    if a != b: return 1
    return 0

def _or(a,b):
    if a == 1 or b == 1: return 1
    return 0

"""
S[i] = A[i] xor B[i] xor C[i]
C[i+1] = A[i]B[i] + B[i]C[i] + C[i]A[i]
"""
def binary_add(A,B):
    A.reverse()
    B.reverse()
    C = [ 0 for i in range(len(A)+1) ]
    for i in range(0,len(A)):
        S =  xor(xor(A[i],B[i]), C[i])
        C[i+1] = _or(A[i]*B[i], xor(A[i],B[i])*C[i])
        C[i] = S
    C.reverse()
    print C
