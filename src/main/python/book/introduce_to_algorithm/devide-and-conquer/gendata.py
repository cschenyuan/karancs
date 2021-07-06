#!/usr/bin/env python
# encoding : utf-8
#
# THIS FILE IS A PART OF SORT ALGORITHMS OF <Introduce to algorithm>
# Created by Chen Yuan<cschenyuan@gmail.com> at 08/2016
#

import argparse
import sys
import random
import math

parser = argparse.ArgumentParser()
parser.add_argument('-o','--out-file',help='output file')
parser.add_argument('-n','--bulk',type=int,help='data bulk')
parser.add_argument('-d','--density',type=float,help='elememnt density')
args = parser.parse_args()

def generate_elem(n,density):
    max = n
    if density > 0 and density <= 1:
        max = int(math.floor( n/density ))
    elif density == 0:
        max = INT_MAX - 1
    return random.randrange(-max,max)

if __name__ == '__main__':
    if args.bulk <= 0 and args.out_file == None:
        sys.exit(1)
    ofile = open(args.out_file, 'w')
    for i in xrange(0, args.bulk):
        ofile.write(str(generate_elem(args.bulk, args.density)) + '\n')
    ofile.flush()
    ofile.close()


