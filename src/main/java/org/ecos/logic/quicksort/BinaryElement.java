package org.ecos.logic.quicksort;

import org.ecos.logic.quicksort.exceptions.BinaryCollectionNullPointerException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class BinaryElement<T extends Comparable<T>> {
    T element;
    BinaryElement<T> left;
    BinaryElement<T> right;


    public void addAll(List<T> list) throws BinaryCollectionNullPointerException {
        for (T element : list) {
            this.add(element);
        }
    }

    private void add(T element) throws BinaryCollectionNullPointerException {
        if (element == null) {
            throw new BinaryCollectionNullPointerException();
        }
        if (this.element == null) {
            this.element = element;
        } else if (this.element.compareTo(element) > 0) {
            if (this.left == null) {
                this.left = new BinaryElement<>();
            }
            this.left.add(element);
        } else {
            if (this.right == null) {
                this.right = new BinaryElement<>();
            }
            this.right.add(element);
        }
    }

    private void goThroughElementsDependingOnOrderBasedBy(
            Function<BinaryElement<T>, Boolean> firstElementCondition,
            Function<BinaryElement<T>, List<T>> goToKLastNode,
            Function<BinaryElement<T>, List<T>> goToRestNodes
    ) {
        if (firstElementCondition.apply(this)) {
            goToKLastNode.apply(this);
        } else {
            goToRestNodes.apply(this);
        }
    }

    private List<T> commonGoThroughBehaviour(BinaryElement<T> orderA, BinaryElement<T> orderB) {
        AtomicReference<List<T>> finalResult = new AtomicReference<>(new ArrayList<>());
        goThroughElementsDependingOnOrderBasedBy(
                element -> (orderA == null),
                (element) -> {
                    finalResult.get().add(element.element);
                    if (orderB != null) {
                        finalResult.get().addAll(orderB.goThroughElementsInOrder());
                    }
                    return finalResult.get();

                },
                (element) -> {
                    finalResult.set(new ArrayList<>(orderA.goThroughElementsInOrder()));
                    finalResult.get().add(this.element);
                    if (orderB != null) {
                        finalResult.get().addAll(orderB.goThroughElementsInOrder());
                    }

                    return finalResult.get();
                });
        return finalResult.get();
    }

    public List<T> goThroughElementsInOrder() {
        return commonGoThroughBehaviour(this.left, this.right);
    }

    public List<T> goThroughElementsInReverseOrder() {
        return commonGoThroughBehaviour(this.right, this.left);
    }

}
