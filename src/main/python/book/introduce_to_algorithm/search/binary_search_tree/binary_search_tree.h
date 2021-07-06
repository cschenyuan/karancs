/*
* THIS FILE IS A PART OF SORT ALGORITHMS OF <Introduce to algorithm>
* Created by Chen Yuan<cschenyuan@gmail.com> at 02/2017
*/

#include "tree.h"

tnode create_node(t_elem e);

void insert_bst(ptree *t,t_elem e);

void print_key(const ptree t);

tnode search_bst(const ptree t,t_elem e);

void traverse(const ptree p);

tnode bst_maximum(const ptree t);

tnode bst_minimum(const ptree t);

tnode successor(const tnode t);

tnode predecessor(const tnode t);

void transplant(ptree *t, ptree u, ptree v);

void delete_bst(ptree *t,t_elem e);
