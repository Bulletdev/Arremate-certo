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

public interface STDataValidationOperator extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STDataValidationOperator.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stdatavalidationoperatore0e0type");
  
  public static final Enum BETWEEN = Enum.forString("between");
  
  public static final Enum NOT_BETWEEN = Enum.forString("notBetween");
  
  public static final Enum EQUAL = Enum.forString("equal");
  
  public static final Enum NOT_EQUAL = Enum.forString("notEqual");
  
  public static final Enum LESS_THAN = Enum.forString("lessThan");
  
  public static final Enum LESS_THAN_OR_EQUAL = Enum.forString("lessThanOrEqual");
  
  public static final Enum GREATER_THAN = Enum.forString("greaterThan");
  
  public static final Enum GREATER_THAN_OR_EQUAL = Enum.forString("greaterThanOrEqual");
  
  public static final int INT_BETWEEN = 1;
  
  public static final int INT_NOT_BETWEEN = 2;
  
  public static final int INT_EQUAL = 3;
  
  public static final int INT_NOT_EQUAL = 4;
  
  public static final int INT_LESS_THAN = 5;
  
  public static final int INT_LESS_THAN_OR_EQUAL = 6;
  
  public static final int INT_GREATER_THAN = 7;
  
  public static final int INT_GREATER_THAN_OR_EQUAL = 8;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STDataValidationOperator newValue(Object param1Object) {
      return (STDataValidationOperator)STDataValidationOperator.type.newValue(param1Object);
    }
    
    public static STDataValidationOperator newInstance() {
      return (STDataValidationOperator)POIXMLTypeLoader.newInstance(STDataValidationOperator.type, null);
    }
    
    public static STDataValidationOperator newInstance(XmlOptions param1XmlOptions) {
      return (STDataValidationOperator)POIXMLTypeLoader.newInstance(STDataValidationOperator.type, param1XmlOptions);
    }
    
    public static STDataValidationOperator parse(String param1String) throws XmlException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1String, STDataValidationOperator.type, null);
    }
    
    public static STDataValidationOperator parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1String, STDataValidationOperator.type, param1XmlOptions);
    }
    
    public static STDataValidationOperator parse(File param1File) throws XmlException, IOException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1File, STDataValidationOperator.type, null);
    }
    
    public static STDataValidationOperator parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1File, STDataValidationOperator.type, param1XmlOptions);
    }
    
    public static STDataValidationOperator parse(URL param1URL) throws XmlException, IOException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1URL, STDataValidationOperator.type, null);
    }
    
    public static STDataValidationOperator parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1URL, STDataValidationOperator.type, param1XmlOptions);
    }
    
    public static STDataValidationOperator parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1InputStream, STDataValidationOperator.type, null);
    }
    
    public static STDataValidationOperator parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1InputStream, STDataValidationOperator.type, param1XmlOptions);
    }
    
    public static STDataValidationOperator parse(Reader param1Reader) throws XmlException, IOException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1Reader, STDataValidationOperator.type, null);
    }
    
    public static STDataValidationOperator parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1Reader, STDataValidationOperator.type, param1XmlOptions);
    }
    
    public static STDataValidationOperator parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1XMLStreamReader, STDataValidationOperator.type, null);
    }
    
    public static STDataValidationOperator parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1XMLStreamReader, STDataValidationOperator.type, param1XmlOptions);
    }
    
    public static STDataValidationOperator parse(Node param1Node) throws XmlException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1Node, STDataValidationOperator.type, null);
    }
    
    public static STDataValidationOperator parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1Node, STDataValidationOperator.type, param1XmlOptions);
    }
    
    public static STDataValidationOperator parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1XMLInputStream, STDataValidationOperator.type, null);
    }
    
    public static STDataValidationOperator parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STDataValidationOperator)POIXMLTypeLoader.parse(param1XMLInputStream, STDataValidationOperator.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDataValidationOperator.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDataValidationOperator.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_BETWEEN = 1;
    
    static final int INT_NOT_BETWEEN = 2;
    
    static final int INT_EQUAL = 3;
    
    static final int INT_NOT_EQUAL = 4;
    
    static final int INT_LESS_THAN = 5;
    
    static final int INT_LESS_THAN_OR_EQUAL = 6;
    
    static final int INT_GREATER_THAN = 7;
    
    static final int INT_GREATER_THAN_OR_EQUAL = 8;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("between", 1), new Enum("notBetween", 2), new Enum("equal", 3), new Enum("notEqual", 4), new Enum("lessThan", 5), new Enum("lessThanOrEqual", 6), new Enum("greaterThan", 7), new Enum("greaterThanOrEqual", 8) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STDataValidationOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */