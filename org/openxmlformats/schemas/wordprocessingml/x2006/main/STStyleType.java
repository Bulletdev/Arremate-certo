package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface STStyleType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STStyleType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ststyletypec2b7type");
  
  public static final Enum PARAGRAPH = Enum.forString("paragraph");
  
  public static final Enum CHARACTER = Enum.forString("character");
  
  public static final Enum TABLE = Enum.forString("table");
  
  public static final Enum NUMBERING = Enum.forString("numbering");
  
  public static final int INT_PARAGRAPH = 1;
  
  public static final int INT_CHARACTER = 2;
  
  public static final int INT_TABLE = 3;
  
  public static final int INT_NUMBERING = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STStyleType newValue(Object param1Object) {
      return (STStyleType)STStyleType.type.newValue(param1Object);
    }
    
    public static STStyleType newInstance() {
      return (STStyleType)POIXMLTypeLoader.newInstance(STStyleType.type, null);
    }
    
    public static STStyleType newInstance(XmlOptions param1XmlOptions) {
      return (STStyleType)POIXMLTypeLoader.newInstance(STStyleType.type, param1XmlOptions);
    }
    
    public static STStyleType parse(String param1String) throws XmlException {
      return (STStyleType)POIXMLTypeLoader.parse(param1String, STStyleType.type, null);
    }
    
    public static STStyleType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STStyleType)POIXMLTypeLoader.parse(param1String, STStyleType.type, param1XmlOptions);
    }
    
    public static STStyleType parse(File param1File) throws XmlException, IOException {
      return (STStyleType)POIXMLTypeLoader.parse(param1File, STStyleType.type, null);
    }
    
    public static STStyleType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STStyleType)POIXMLTypeLoader.parse(param1File, STStyleType.type, param1XmlOptions);
    }
    
    public static STStyleType parse(URL param1URL) throws XmlException, IOException {
      return (STStyleType)POIXMLTypeLoader.parse(param1URL, STStyleType.type, null);
    }
    
    public static STStyleType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STStyleType)POIXMLTypeLoader.parse(param1URL, STStyleType.type, param1XmlOptions);
    }
    
    public static STStyleType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STStyleType)POIXMLTypeLoader.parse(param1InputStream, STStyleType.type, null);
    }
    
    public static STStyleType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STStyleType)POIXMLTypeLoader.parse(param1InputStream, STStyleType.type, param1XmlOptions);
    }
    
    public static STStyleType parse(Reader param1Reader) throws XmlException, IOException {
      return (STStyleType)POIXMLTypeLoader.parse(param1Reader, STStyleType.type, null);
    }
    
    public static STStyleType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STStyleType)POIXMLTypeLoader.parse(param1Reader, STStyleType.type, param1XmlOptions);
    }
    
    public static STStyleType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STStyleType)POIXMLTypeLoader.parse(param1XMLStreamReader, STStyleType.type, null);
    }
    
    public static STStyleType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STStyleType)POIXMLTypeLoader.parse(param1XMLStreamReader, STStyleType.type, param1XmlOptions);
    }
    
    public static STStyleType parse(Node param1Node) throws XmlException {
      return (STStyleType)POIXMLTypeLoader.parse(param1Node, STStyleType.type, null);
    }
    
    public static STStyleType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STStyleType)POIXMLTypeLoader.parse(param1Node, STStyleType.type, param1XmlOptions);
    }
    
    public static STStyleType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STStyleType)POIXMLTypeLoader.parse(param1XMLInputStream, STStyleType.type, null);
    }
    
    public static STStyleType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STStyleType)POIXMLTypeLoader.parse(param1XMLInputStream, STStyleType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STStyleType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STStyleType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_PARAGRAPH = 1;
    
    static final int INT_CHARACTER = 2;
    
    static final int INT_TABLE = 3;
    
    static final int INT_NUMBERING = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("paragraph", 1), new Enum("character", 2), new Enum("table", 3), new Enum("numbering", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STStyleType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */