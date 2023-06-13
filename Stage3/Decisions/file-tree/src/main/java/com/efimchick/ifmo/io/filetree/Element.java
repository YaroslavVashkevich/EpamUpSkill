package com.efimchick.ifmo.io.filetree;

import java.io.File;
import java.util.*;

public class Element {

    private File element;
    private List<Element> elements;

    public Element(File element){
        this.element = element;
        this.elements = new ArrayList<>();
    }

    public File getElement() {
        return element;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void addChildElement(File element){
        Element childElement = new Element(element);
        elements.add(childElement);
    }
}
