package org.ecos.logic.quicksort;

import org.ecos.logic.quicksort.exceptions.BinaryCollectionNullPointerException;

import java.util.ArrayList;
import java.util.List;

// ... existing code ...
public class BinaryElement<T extends Comparable<T>> {
    private T value;
    private BinaryElement<T> left;
    private BinaryElement<T> right;

    public BinaryElement() {
    }

    private BinaryElement(T value) {
        this.value = value;
    }

    public void addAll(List<T> list) throws BinaryCollectionNullPointerException {
        for (T element : list) {
            this.add(element);
        }
    }

    private void add(T element) throws BinaryCollectionNullPointerException {
        if (element == null) {
            throw new BinaryCollectionNullPointerException();
        }
        if (this.value == null) {
            this.value = element;
            return;
        }

        if (this.value.compareTo(element) > 0) {
            if (this.left == null) {
                this.left = new BinaryElement<>(element);
            } else {
                this.left.add(element);
            }
        } else {
            if (this.right == null) {
                this.right = new BinaryElement<>(element);
            } else {
                this.right.add(element);
            }
        }
    }

    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        traverse(this, result, false);
        return result;
    }

    public List<T> reverseOrderTraversal() {
        List<T> result = new ArrayList<>();
        traverse(this, result, true);
        return result;
    }

    private void traverse(BinaryElement<T> node, List<T> result, boolean reverse) {
        if (node == null || node.value == null) return;

        BinaryElement<T> first = reverse ? node.right : node.left;
        BinaryElement<T> second = reverse ? node.left : node.right;

        traverse(first, result, reverse);
        result.add(node.value);
        traverse(second, result, reverse);
    }
}
