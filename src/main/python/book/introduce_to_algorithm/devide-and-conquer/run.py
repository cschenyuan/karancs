#!/usr/bin/env python

import time
import os

def run(cmd):
    start = time.time()
    os.system(cmd)
    end = time.time()
    print "cost: %s (s)" % str(end - start)

print "----------------------"
run("./max_sa_rec < data_10")
run("./max_sa_prim < data_10")
run("./max_sa_liner < data_10")
print "----------------------\n"

run("./max_sa_rec < data_100")
run("./max_sa_prim < data_100")
run("./max_sa_liner < data_100")
print "----------------------\n"

run("./max_sa_rec < data_1000")
run("./max_sa_prim < data_1000")
run("./max_sa_liner < data_1000")
print "----------------------\n"

run("./max_sa_rec < data_10000")
run("./max_sa_prim < data_10000")
run("./max_sa_liner < data_10000")
print "----------------------\n"

run("./max_sa_rec < data_100000")
run("./max_sa_prim < data_100000")
run("./max_sa_liner < data_100000")
print "----------------------\n"
