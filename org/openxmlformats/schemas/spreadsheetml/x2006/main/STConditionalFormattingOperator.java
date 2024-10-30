package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STConditionalFormattingOperator extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STConditionalFormattingOperator.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stconditionalformattingoperatora99etype");
  
  public static final Enum LESS_THAN = Enum.forString("lessThan");
  
  public static final Enum LESS_THAN_OR_EQUAL = Enum.forString("lessThanOrEqual");
  
  public static final Enum EQUAL = Enum.forString("equal");
  
  public static final Enum NOT_EQUAL = Enum.forString("notEqual");
  
  public static final Enum GREATER_THAN_OR_EQUAL = Enum.forString("greaterThanOrEqual");
  
  public static final Enum GREATER_THAN = Enum.forString("greaterThan");
  
  public static final Enum BETWEEN = Enum.forString("between");
  
  public static final Enum NOT_BETWEEN = Enum.forString("notBetween");
  
  public static final Enum CONTAINS_TEXT = Enum.forString("containsText");
  
  public static final Enum NOT_CONTAINS = Enum.forString("notContains");
  
  public static final Enum BEGINS_WITH = Enum.forString("beginsWith");
  
  public static final Enum ENDS_WITH = Enum.forString("endsWith");
  
  public static final int INT_LESS_THAN = 1;
  
  public static final int INT_LESS_THAN_OR_EQUAL = 2;
  
  public static final int INT_EQUAL = 3;
  
  public static final int INT_NOT_EQUAL = 4;
  
  public static final int INT_GREATER_THAN_OR_EQUAL = 5;
  
  public static final int INT_GREATER_THAN = 6;
  
  public static final int INT_BETWEEN = 7;
  
  public static final int INT_NOT_BETWEEN = 8;
  
  public static final int INT_CONTAINS_TEXT = 9;
  
  public static final int INT_NOT_CONTAINS = 10;
  
  public static final int INT_BEGINS_WITH = 11;
  
  public static final int INT_ENDS_WITH = 12;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STConditionalFormattingOperator newValue(Object param1Object) {
      return (STConditionalFormattingOperator)STConditionalFormattingOperator.type.newValue(param1Object);
    }
    
    public static STConditionalFormattingOperator newInstance() {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.newInstance(STConditionalFormattingOperator.type, null);
    }
    
    public static STConditionalFormattingOperator newInstance(XmlOptions param1XmlOptions) {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.newInstance(STConditionalFormattingOperator.type, param1XmlOptions);
    }
    
    public static STConditionalFormattingOperator parse(String param1String) throws XmlException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1String, STConditionalFormattingOperator.type, null);
    }
    
    public static STConditionalFormattingOperator parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1String, STConditionalFormattingOperator.type, param1XmlOptions);
    }
    
    public static STConditionalFormattingOperator parse(File param1File) throws XmlException, IOException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1File, STConditionalFormattingOperator.type, null);
    }
    
    public static STConditionalFormattingOperator parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1File, STConditionalFormattingOperator.type, param1XmlOptions);
    }
    
    public static STConditionalFormattingOperator parse(URL param1URL) throws XmlException, IOException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1URL, STConditionalFormattingOperator.type, null);
    }
    
    public static STConditionalFormattingOperator parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1URL, STConditionalFormattingOperator.type, param1XmlOptions);
    }
    
    public static STConditionalFormattingOperator parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1InputStream, STConditionalFormattingOperator.type, null);
    }
    
    public static STConditionalFormattingOperator parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1InputStream, STConditionalFormattingOperator.type, param1XmlOptions);
    }
    
    public static STConditionalFormattingOperator parse(Reader param1Reader) throws XmlException, IOException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1Reader, STConditionalFormattingOperator.type, null);
    }
    
    public static STConditionalFormattingOperator parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1Reader, STConditionalFormattingOperator.type, param1XmlOptions);
    }
    
    public static STConditionalFormattingOperator parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1XMLStreamReader, STConditionalFormattingOperator.type, null);
    }
    
    public static STConditionalFormattingOperator parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1XMLStreamReader, STConditionalFormattingOperator.type, param1XmlOptions);
    }
    
    public static STConditionalFormattingOperator parse(Node param1Node) throws XmlException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1Node, STConditionalFormattingOperator.type, null);
    }
    
    public static STConditionalFormattingOperator parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1Node, STConditionalFormattingOperator.type, param1XmlOptions);
    }
    
    public static STConditionalFormattingOperator parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1XMLInputStream, STConditionalFormattingOperator.type, null);
    }
    
    public static STConditionalFormattingOperator parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STConditionalFormattingOperator)POIXMLTypeLoader.parse(param1XMLInputStream, STConditionalFormattingOperator.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STConditionalFormattingOperator.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STConditionalFormattingOperator.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_LESS_THAN = 1;
    
    static final int INT_LESS_THAN_OR_EQUAL = 2;
    
    static final int INT_EQUAL = 3;
    
    static final int INT_NOT_EQUAL = 4;
    
    static final int INT_GREATER_THAN_OR_EQUAL = 5;
    
    static final int INT_GREATER_THAN = 6;
    
    static final int INT_BETWEEN = 7;
    
    static final int INT_NOT_BETWEEN = 8;
    
    static final int INT_CONTAINS_TEXT = 9;
    
    static final int INT_NOT_CONTAINS = 10;
    
    static final int INT_BEGINS_WITH = 11;
    
    static final int INT_ENDS_WITH = 12;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("lessThan", 1), new Enum("lessThanOrEqual", 2), new Enum("equal", 3), new Enum("notEqual", 4), new Enum("greaterThanOrEqual", 5), new Enum("greaterThan", 6), new Enum("between", 7), new Enum("notBetween", 8), new Enum("containsText", 9), new Enum("notContains", 10), 
          new Enum("beginsWith", 11), new Enum("endsWith", 12) });
    
    private static final long serialVersionUID = 1L;
    
    public static Enum forString(String param1String) {
      return (Enum)table.forString(param1String);
    }
    
    public static Enum forInt(int param1Int) {
      return (Enum)table.forInt(param1Int);
    }
    
    private Enum(String param1String, int param1Int) {
      super(param1String, param1Int);
    }
    
    private Object readResolve() {
      return forInt(intValue());
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STConditionalFormattingOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */