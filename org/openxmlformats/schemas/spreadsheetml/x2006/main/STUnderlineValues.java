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

public interface STUnderlineValues extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STUnderlineValues.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stunderlinevaluesb6ddtype");
  
  public static final Enum SINGLE = Enum.forString("single");
  
  public static final Enum DOUBLE = Enum.forString("double");
  
  public static final Enum SINGLE_ACCOUNTING = Enum.forString("singleAccounting");
  
  public static final Enum DOUBLE_ACCOUNTING = Enum.forString("doubleAccounting");
  
  public static final Enum NONE = Enum.forString("none");
  
  public static final int INT_SINGLE = 1;
  
  public static final int INT_DOUBLE = 2;
  
  public static final int INT_SINGLE_ACCOUNTING = 3;
  
  public static final int INT_DOUBLE_ACCOUNTING = 4;
  
  public static final int INT_NONE = 5;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STUnderlineValues newValue(Object param1Object) {
      return (STUnderlineValues)STUnderlineValues.type.newValue(param1Object);
    }
    
    public static STUnderlineValues newInstance() {
      return (STUnderlineValues)POIXMLTypeLoader.newInstance(STUnderlineValues.type, null);
    }
    
    public static STUnderlineValues newInstance(XmlOptions param1XmlOptions) {
      return (STUnderlineValues)POIXMLTypeLoader.newInstance(STUnderlineValues.type, param1XmlOptions);
    }
    
    public static STUnderlineValues parse(String param1String) throws XmlException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1String, STUnderlineValues.type, null);
    }
    
    public static STUnderlineValues parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1String, STUnderlineValues.type, param1XmlOptions);
    }
    
    public static STUnderlineValues parse(File param1File) throws XmlException, IOException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1File, STUnderlineValues.type, null);
    }
    
    public static STUnderlineValues parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1File, STUnderlineValues.type, param1XmlOptions);
    }
    
    public static STUnderlineValues parse(URL param1URL) throws XmlException, IOException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1URL, STUnderlineValues.type, null);
    }
    
    public static STUnderlineValues parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1URL, STUnderlineValues.type, param1XmlOptions);
    }
    
    public static STUnderlineValues parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1InputStream, STUnderlineValues.type, null);
    }
    
    public static STUnderlineValues parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1InputStream, STUnderlineValues.type, param1XmlOptions);
    }
    
    public static STUnderlineValues parse(Reader param1Reader) throws XmlException, IOException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1Reader, STUnderlineValues.type, null);
    }
    
    public static STUnderlineValues parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1Reader, STUnderlineValues.type, param1XmlOptions);
    }
    
    public static STUnderlineValues parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1XMLStreamReader, STUnderlineValues.type, null);
    }
    
    public static STUnderlineValues parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1XMLStreamReader, STUnderlineValues.type, param1XmlOptions);
    }
    
    public static STUnderlineValues parse(Node param1Node) throws XmlException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1Node, STUnderlineValues.type, null);
    }
    
    public static STUnderlineValues parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1Node, STUnderlineValues.type, param1XmlOptions);
    }
    
    public static STUnderlineValues parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1XMLInputStream, STUnderlineValues.type, null);
    }
    
    public static STUnderlineValues parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STUnderlineValues)POIXMLTypeLoader.parse(param1XMLInputStream, STUnderlineValues.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STUnderlineValues.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STUnderlineValues.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_SINGLE = 1;
    
    static final int INT_DOUBLE = 2;
    
    static final int INT_SINGLE_ACCOUNTING = 3;
    
    static final int INT_DOUBLE_ACCOUNTING = 4;
    
    static final int INT_NONE = 5;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("single", 1), new Enum("double", 2), new Enum("singleAccounting", 3), new Enum("doubleAccounting", 4), new Enum("none", 5) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STUnderlineValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */