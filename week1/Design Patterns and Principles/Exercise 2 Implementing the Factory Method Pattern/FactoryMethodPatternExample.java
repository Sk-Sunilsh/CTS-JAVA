interface Document {
    void open();
}

class WordDoc implements Document {
    public void open() {
        System.out.println("📄 Word Document opened.");
    }
}

class PdfDoc implements Document {
    public void open() {
        System.out.println("📕 PDF Document opened.");
    }
}

class ExcelDoc implements Document {
    public void open() {
        System.out.println("📊 Excel Document opened.");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDoc();
    }
}

class PdfDocFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDoc();
    }
}

class ExcelDocFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDoc();
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory[] factories = {
            new WordDocFactory(),
            new PdfDocFactory(),
            new ExcelDocFactory()
        };

        for (DocumentFactory factory : factories) {
            Document doc = factory.createDocument();
            doc.open();
        }
    }
}
