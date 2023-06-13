package com.efimchick.ifmo.io.filetree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileTreeImpl implements FileTree {

    @Override
    public Optional<String> tree(Path path) {
        if (path == null || !Files.exists(path)) {
            return Optional.empty();
        } else {
            if ((Files.isRegularFile(path))) {
                try {
                    return Optional.of(path.getFileName() + " " + Files.size(path) + " bytes");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return Optional.of(buildDirectoryTree(createDirectoryTree(path.toFile())));
    }

    public Element createDirectoryTree(File element) {
        Element rootElement = new Element(element);
        File[] files = element.listFiles();
        sort(files);
        for (File file : files) {
            if (file.isDirectory()) {
                appendDir(file, rootElement);
            } else {
                appendFile(file, rootElement);
            }
        }
        return rootElement;
    }

    public void sort(File[] files) {
        Arrays.sort(files, (o1, o2) -> {
            if (o1.isDirectory() && o2.isDirectory()) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            } else return Boolean.compare(o1.isFile(), o2.isFile()) == 0
                    ? o1.getName().compareToIgnoreCase(o2.getName())
                    : Boolean.compare(o1.isFile(), o2.isFile());
        });
    }

    public void appendDir(File element, Element rootElement) {
        rootElement.addChildElement(element);
        File[] files = element.listFiles();
        sort(files);
        for (File file : files) {
            if (file.isDirectory()) {
                appendDir(file, rootElement.getElements().get(rootElement.getElements().size() - 1));
            } else {
                appendFile(file, rootElement.getElements().get(rootElement.getElements().size() - 1));
            }
        }
    }

    public void appendFile(File file, Element rootElement) {
        rootElement.addChildElement(file);
    }

    public String buildDirectoryTree(Element element) {
        List<StringBuilder> lines = buildDirectoryTreeLines(element);
        StringBuilder sb = new StringBuilder();
        for (StringBuilder line : lines) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    public Long sizeDir(File dir) {
        long size = 0;
        try {
            size = Files.walk(dir.toPath())
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .mapToLong(File::length).sum();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }

    public List<StringBuilder> buildDirectoryTreeLines(Element element) {
        List<StringBuilder> result = new ArrayList<>();
        result.add(new StringBuilder().append(element.getElement().getName() + " " + sizeDir(element.getElement()) + " bytes"));
        Iterator<Element> iterator = element.getElements().iterator();
        while (iterator.hasNext()) {
            List<StringBuilder> next = buildDirectoryTreeLines(iterator.next());
            if (iterator.hasNext()) {
                addElement(result, next);
            } else {
                addLastElement(result, next);
            }
        }
        return result;
    }

    public void addElement(List<StringBuilder> result, List<StringBuilder> next) {
        Iterator<StringBuilder> iterator = next.iterator();
        result.add(iterator.next().insert(0, "├─ "));
        while (iterator.hasNext()) {
            result.add(iterator.next().insert(0, "│  "));
        }
    }

    public void addLastElement(List<StringBuilder> result, List<StringBuilder> next) {
        Iterator<StringBuilder> iterator = next.iterator();
        result.add(iterator.next().insert(0, "└─ "));
        while (iterator.hasNext()) {
            result.add(iterator.next().insert(0, "   "));
        }
    }
}

