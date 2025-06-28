package org.ecos.logic.quicksort.example.data;

import java.util.Objects;

public class Element implements Comparable<Element> {
    private final String name;
    private final String surname;
    private final int age;

    public Element(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public int compareTo(Element other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;
        return age == element.age && Objects.equals(name, element.name) && Objects.equals(surname, element.surname);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(surname);
        result = 31 * result + age;
        return result;
    }
}
