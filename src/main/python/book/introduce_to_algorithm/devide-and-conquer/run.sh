#!/bin/bash

#gcc -o runner max_subarray.c

time ./max_sa_rec < data_10
time ./max_sa_prim < data_10

time ./max_sa_rec < data_100
time ./max_sa_prim < data_100

time ./max_sa_rec < data_1000
time ./max_sa_prim < data_1000

time ./max_sa_rec < data_10000
time ./max_sa_prim < data_10000

time ./max_sa_rec < data_100000
time ./max_sa_prim < data_100000


