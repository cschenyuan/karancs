#!/usr/bin/env python
#
# THIS FILE IS A PART OF SORT ALGORITHMS OF <Introduce to algorithm>
# Created by Chen Yuan<cschenyuan@gmail.com> at 08/2016
# All rights reserved
#
import random
import time
import copy
import math
from sort_common import *

import insertion
import merge

sort_methods = {'insertion':insertion,'merge':merge}

class Test(object):

    def __init__(self,n=0,method='insertion',density=1):
        self.__dict__.update({ k:v for k,v in locals().items() if k != 'self'})

    def gen_data(self):
        max = self.n
        if self.density > 0 and self.density <= 1:
            max = int(math.floor( n/density ))
        elif self.density == 0:
            max = INT_MAX - 1
        return [ random.randrange(max) for i in xrange(self.n) ]

    def test(self,A):
        sort = sort_methods[self.method]
        start_time = time.time()
        sort.sort(A)
        end_time = time.time()
        return end_time - start_time

    def run(self):
        self.data = self.gen_data()
        cost = self.test(self.data)
        print "cost: %s (s)" % str(cost)

    def get_data(self):
        return self.data

def run_case(n=10):
    t1 = Test(n,'merge')
    data1 = t1.gen_data()
    data2 = copy.copy(data1)
    data3 = copy.copy(data1)
    start = time.time()
    insertion.insertion_sort(data1,0,len(data1)-1)
    end = time.time()
    print "cost: %s (s)" % str(end - start)

    start = time.time()
    insertion.insertion_sort_with_binary(data2,0,len(data2)-1)
    end = time.time()
    print "cost: %s (s)" % str(end - start)

    cost = t1.test(data3)
    print "cost: %s (s)" % str(cost)

    assert cmp(data1,data2) == 0 and cmp(data2,data3) == 0
