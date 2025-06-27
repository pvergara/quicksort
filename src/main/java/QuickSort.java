import java.util.Arrays;
import java.util.List;

class QuickSortCollection<T extends Comparable<T>> {

    private final BinaryCollection<T> binaryCollection;

    public QuickSortCollection() {
        this.binaryCollection = new BinaryCollection<>();
    }

    public List<T> sort() {
        return this.binaryCollection.goThroughElementsInOrder();
    }

    @SafeVarargs
    public final QuickSortCollection<T> addElements(T... elements) throws BinaryCollectionNullPointerException {
        this.binaryCollection.addAll(Arrays.stream(elements).toList());
        return this;
    }
}
