/*
* THIS FILE IS A PART OF SORT ALGORITHMS OF <Introduce to algorithm>
* Created by Chen Yuan<cschenyuan@gmail.com> at 02/2017
*/

#include <stdlib.h>
#include <stdio.h>
#include "binary_search_tree.h"

tnode
create_node(t_elem e) {
    tnode node = (tnode)malloc(sizeof(struct tree));
    node->key = e;
    node->parent = NULL;
    node->lchild = NULL;
    node->rchild = NULL;
    return node;
}

void
insert_bst(ptree *t,t_elem e) {
    tnode node = create_node(e);
    if (!(*t && node))
        return;

    tnode n = *t;
    tnode p;
    while (n) {
        p = n;
        n = node->key > n->key ?
            n->rchild : n->lchild;
    }

    node->parent = p;
    if (!p)
        *t = node;
    else if (node->key > p->key)
        p->rchild = node;
    else p->lchild = node;
}

void print_key(const ptree t) {
    printf("%d ", t->key);
}

tnode
search_bst(const ptree t,t_elem e) {
    tnode n = t;
    while (n && e != n->key) {
        n = e > n->key ?
            n->rchild : n->lchild;
    }
    return n;
}

void traverse(const ptree t) {
    tnode n = t;
    if (n) {
        traverse(n->lchild);
        print_key(n);
        traverse(n->rchild);
    }
}

tnode
bst_minimum(const ptree t) {
    if (!t)
        return t;
    tnode n = t;
    while (n->lchild)
        n = n->lchild;
    return n;
}

tnode
bst_maximum(const ptree t) {
    if (!t)
        return t;
    tnode n = t;
    while (n->rchild)
        n = n->rchild;
    return n;
}

tnode
successor(const tnode t) {
    tnode n = t;
    if (n->rchild)
        return bst_minimum(n);
    tnode successor = n->parent;
    while (successor && successor->rchild == n) {
        n = successor;
        successor = n->parent;
    }
    return successor;
}

tnode
predecessor(const tnode t) {
    tnode n = t;
    if (n->lchild)
        return bst_maximum(n);
    tnode predecessor = n->parent;
    while (predecessor && predecessor->lchild == n) {
        n = predecessor;
        predecessor = n->parent;
    }
    return predecessor;
}

void
transplant(ptree *t,ptree oldt,ptree newt) {
    if (!oldt)
        return;
    if (!oldt->parent) /* check if oldt is the root node of this tree */
        (*t) = newt;
    else if (oldt->parent->lchild == oldt)
        oldt->parent->lchild = newt;
    else oldt->parent->rchild = newt;
    if (newt)
        newt->parent = oldt->parent;
}

void
delete_bst(ptree *t,t_elem e) {
    tnode d = search_bst(*t, e);
    if (!d) return;
    if (!d->lchild)
        transplant(t, d, d->rchild);
    else if (!d->rchild)
        transplant(t, d, d->lchild);
    else {
        tnode successor = bst_minimum(d->rchild);
        if (successor->parent != d) {
            transplant(t, successor, successor->rchild);
            successor->rchild = d->rchild;
            successor->rchild->parent = successor;
        }
        transplant(t, d, successor);
        successor->lchild = d->lchild;
        successor->lchild->parent = successor;
    }
    free(d);
}
