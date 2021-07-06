#!/usr/bin/env python
#
# THIS FILE IS A PART OF SORT ALGORITHMS OF <Introduce to algorithm>
# Created by Chen Yuan<cschenyuan@gmail.com> at 08/2016
# All rights reserved
#

from common import *

def binary_search(A,p,r,key):
    low = p
    high = r
    while low <= high:
        mid = (low + high) >> 1
        if key == A[mid]:
            return mid + 1
        elif key < A[mid]:
            high = mid - 1
        else:
            low = mid + 1
    if low > high:
        return low
    return r + 1

def insertion_sort_with_binary(A,p,r):
    for j in xrange(p+1,r+1):
        key = A[j]
        i = j - 1
        k = binary_search(A,p,i,key)
        while i >= k:
            A[i+1] = A[i]
            i -= 1
        A[k] = key

def insertion_sort(A,p,r):
    for j in xrange(p+1,r+1):
        key = A[j]
        i = j-1
        while i >= p and key < A[i]:
            A[i+1] = A[i]
            i = i - 1
        A[i+1] = key

def sort(A):
    insertion_sort_with_binary(A,0,len(A)-1)
    #insertion_sort(A,0,len(A)-1)
