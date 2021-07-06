#!/usr/bin/env python
#
# THIS FILE IS A PART OF SORT ALGORITHMS OF <Introduce to algorithm>
# Created by Chen Yuan<cschenyuan@gmail.com> at 08/2016
# All rights reserved
#
from sort_common import *
import insertion

__INSTERTION_THRESHOLD = 7

def merge(A,p,q,r):
    L_Sub = A[p:q+1]
    R_Sub = A[q+1:r+1]
    #print L_Sub,R_Sub
    L_Sub.append(INT_MAX)
    R_Sub.append(INT_MAX)
    i,j = 0,0
    for k in xrange(p,r+1):
        if L_Sub[i] <= R_Sub[j]:
            A[k] = L_Sub[i]
            i += 1
        else:
            A[k] = R_Sub[j]
            j += 1

def merge_sort(A,p,r):
    if p < r:
        if (r-p+1) <= __INSTERTION_THRESHOLD:
            insertion.insertion_sort(A,p,r)
        else:
            q = (r + p) >> 1
            merge_sort(A,p,q)
            merge_sort(A,q+1,r)
            merge(A,p,q,r)

def sort(A):
    merge_sort(A,0,len(A)-1)

