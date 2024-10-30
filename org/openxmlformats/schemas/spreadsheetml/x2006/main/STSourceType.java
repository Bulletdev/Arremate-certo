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

public interface STSourceType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STSourceType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stsourcetype074etype");
  
  public static final Enum WORKSHEET = Enum.forString("worksheet");
  
  public static final Enum EXTERNAL = Enum.forString("external");
  
  public static final Enum CONSOLIDATION = Enum.forString("consolidation");
  
  public static final Enum SCENARIO = Enum.forString("scenario");
  
  public static final int INT_WORKSHEET = 1;
  
  public static final int INT_EXTERNAL = 2;
  
  public static final int INT_CONSOLIDATION = 3;
  
  public static final int INT_SCENARIO = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STSourceType newValue(Object param1Object) {
      return (STSourceType)STSourceType.type.newValue(param1Object);
    }
    
    public static STSourceType newInstance() {
      return (STSourceType)POIXMLTypeLoader.newInstance(STSourceType.type, null);
    }
    
    public static STSourceType newInstance(XmlOptions param1XmlOptions) {
      return (STSourceType)POIXMLTypeLoader.newInstance(STSourceType.type, param1XmlOptions);
    }
    
    public static STSourceType parse(String param1String) throws XmlException {
      return (STSourceType)POIXMLTypeLoader.parse(param1String, STSourceType.type, null);
    }
    
    public static STSourceType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STSourceType)POIXMLTypeLoader.parse(param1String, STSourceType.type, param1XmlOptions);
    }
    
    public static STSourceType parse(File param1File) throws XmlException, IOException {
      return (STSourceType)POIXMLTypeLoader.parse(param1File, STSourceType.type, null);
    }
    
    public static STSourceType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSourceType)POIXMLTypeLoader.parse(param1File, STSourceType.type, param1XmlOptions);
    }
    
    public static STSourceType parse(URL param1URL) throws XmlException, IOException {
      return (STSourceType)POIXMLTypeLoader.parse(param1URL, STSourceType.type, null);
    }
    
    public static STSourceType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSourceType)POIXMLTypeLoader.parse(param1URL, STSourceType.type, param1XmlOptions);
    }
    
    public static STSourceType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STSourceType)POIXMLTypeLoader.parse(param1InputStream, STSourceType.type, null);
    }
    
    public static STSourceType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSourceType)POIXMLTypeLoader.parse(param1InputStream, STSourceType.type, param1XmlOptions);
    }
    
    public static STSourceType parse(Reader param1Reader) throws XmlException, IOException {
      return (STSourceType)POIXMLTypeLoader.parse(param1Reader, STSourceType.type, null);
    }
    
    public static STSourceType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSourceType)POIXMLTypeLoader.parse(param1Reader, STSourceType.type, param1XmlOptions);
    }
    
    public static STSourceType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STSourceType)POIXMLTypeLoader.parse(param1XMLStreamReader, STSourceType.type, null);
    }
    
    public static STSourceType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STSourceType)POIXMLTypeLoader.parse(param1XMLStreamReader, STSourceType.type, param1XmlOptions);
    }
    
    public static STSourceType parse(Node param1Node) throws XmlException {
      return (STSourceType)POIXMLTypeLoader.parse(param1Node, STSourceType.type, null);
    }
    
    public static STSourceType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STSourceType)POIXMLTypeLoader.parse(param1Node, STSourceType.type, param1XmlOptions);
    }
    
    public static STSourceType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STSourceType)POIXMLTypeLoader.parse(param1XMLInputStream, STSourceType.type, null);
    }
    
    public static STSourceType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STSourceType)POIXMLTypeLoader.parse(param1XMLInputStream, STSourceType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSourceType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSourceType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_WORKSHEET = 1;
    
    static final int INT_EXTERNAL = 2;
    
    static final int INT_CONSOLIDATION = 3;
    
    static final int INT_SCENARIO = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("worksheet", 1), new Enum("external", 2), new Enum("consolidation", 3), new Enum("scenario", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STSourceType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */