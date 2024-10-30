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

public interface STHorizontalAlignment extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STHorizontalAlignment.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sthorizontalalignmentf92etype");
  
  public static final Enum GENERAL = Enum.forString("general");
  
  public static final Enum LEFT = Enum.forString("left");
  
  public static final Enum CENTER = Enum.forString("center");
  
  public static final Enum RIGHT = Enum.forString("right");
  
  public static final Enum FILL = Enum.forString("fill");
  
  public static final Enum JUSTIFY = Enum.forString("justify");
  
  public static final Enum CENTER_CONTINUOUS = Enum.forString("centerContinuous");
  
  public static final Enum DISTRIBUTED = Enum.forString("distributed");
  
  public static final int INT_GENERAL = 1;
  
  public static final int INT_LEFT = 2;
  
  public static final int INT_CENTER = 3;
  
  public static final int INT_RIGHT = 4;
  
  public static final int INT_FILL = 5;
  
  public static final int INT_JUSTIFY = 6;
  
  public static final int INT_CENTER_CONTINUOUS = 7;
  
  public static final int INT_DISTRIBUTED = 8;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STHorizontalAlignment newValue(Object param1Object) {
      return (STHorizontalAlignment)STHorizontalAlignment.type.newValue(param1Object);
    }
    
    public static STHorizontalAlignment newInstance() {
      return (STHorizontalAlignment)POIXMLTypeLoader.newInstance(STHorizontalAlignment.type, null);
    }
    
    public static STHorizontalAlignment newInstance(XmlOptions param1XmlOptions) {
      return (STHorizontalAlignment)POIXMLTypeLoader.newInstance(STHorizontalAlignment.type, param1XmlOptions);
    }
    
    public static STHorizontalAlignment parse(String param1String) throws XmlException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1String, STHorizontalAlignment.type, null);
    }
    
    public static STHorizontalAlignment parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1String, STHorizontalAlignment.type, param1XmlOptions);
    }
    
    public static STHorizontalAlignment parse(File param1File) throws XmlException, IOException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1File, STHorizontalAlignment.type, null);
    }
    
    public static STHorizontalAlignment parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1File, STHorizontalAlignment.type, param1XmlOptions);
    }
    
    public static STHorizontalAlignment parse(URL param1URL) throws XmlException, IOException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1URL, STHorizontalAlignment.type, null);
    }
    
    public static STHorizontalAlignment parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1URL, STHorizontalAlignment.type, param1XmlOptions);
    }
    
    public static STHorizontalAlignment parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1InputStream, STHorizontalAlignment.type, null);
    }
    
    public static STHorizontalAlignment parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1InputStream, STHorizontalAlignment.type, param1XmlOptions);
    }
    
    public static STHorizontalAlignment parse(Reader param1Reader) throws XmlException, IOException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1Reader, STHorizontalAlignment.type, null);
    }
    
    public static STHorizontalAlignment parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1Reader, STHorizontalAlignment.type, param1XmlOptions);
    }
    
    public static STHorizontalAlignment parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1XMLStreamReader, STHorizontalAlignment.type, null);
    }
    
    public static STHorizontalAlignment parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1XMLStreamReader, STHorizontalAlignment.type, param1XmlOptions);
    }
    
    public static STHorizontalAlignment parse(Node param1Node) throws XmlException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1Node, STHorizontalAlignment.type, null);
    }
    
    public static STHorizontalAlignment parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1Node, STHorizontalAlignment.type, param1XmlOptions);
    }
    
    public static STHorizontalAlignment parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1XMLInputStream, STHorizontalAlignment.type, null);
    }
    
    public static STHorizontalAlignment parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STHorizontalAlignment)POIXMLTypeLoader.parse(param1XMLInputStream, STHorizontalAlignment.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHorizontalAlignment.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHorizontalAlignment.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_GENERAL = 1;
    
    static final int INT_LEFT = 2;
    
    static final int INT_CENTER = 3;
    
    static final int INT_RIGHT = 4;
    
    static final int INT_FILL = 5;
    
    static final int INT_JUSTIFY = 6;
    
    static final int INT_CENTER_CONTINUOUS = 7;
    
    static final int INT_DISTRIBUTED = 8;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("general", 1), new Enum("left", 2), new Enum("center", 3), new Enum("right", 4), new Enum("fill", 5), new Enum("justify", 6), new Enum("centerContinuous", 7), new Enum("distributed", 8) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STHorizontalAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */