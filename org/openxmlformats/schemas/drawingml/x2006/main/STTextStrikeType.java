package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STTextStrikeType extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTextStrikeType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttextstriketype4744type");
  
  public static final Enum NO_STRIKE = Enum.forString("noStrike");
  
  public static final Enum SNG_STRIKE = Enum.forString("sngStrike");
  
  public static final Enum DBL_STRIKE = Enum.forString("dblStrike");
  
  public static final int INT_NO_STRIKE = 1;
  
  public static final int INT_SNG_STRIKE = 2;
  
  public static final int INT_DBL_STRIKE = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTextStrikeType newValue(Object param1Object) {
      return (STTextStrikeType)STTextStrikeType.type.newValue(param1Object);
    }
    
    public static STTextStrikeType newInstance() {
      return (STTextStrikeType)POIXMLTypeLoader.newInstance(STTextStrikeType.type, null);
    }
    
    public static STTextStrikeType newInstance(XmlOptions param1XmlOptions) {
      return (STTextStrikeType)POIXMLTypeLoader.newInstance(STTextStrikeType.type, param1XmlOptions);
    }
    
    public static STTextStrikeType parse(String param1String) throws XmlException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1String, STTextStrikeType.type, null);
    }
    
    public static STTextStrikeType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1String, STTextStrikeType.type, param1XmlOptions);
    }
    
    public static STTextStrikeType parse(File param1File) throws XmlException, IOException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1File, STTextStrikeType.type, null);
    }
    
    public static STTextStrikeType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1File, STTextStrikeType.type, param1XmlOptions);
    }
    
    public static STTextStrikeType parse(URL param1URL) throws XmlException, IOException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1URL, STTextStrikeType.type, null);
    }
    
    public static STTextStrikeType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1URL, STTextStrikeType.type, param1XmlOptions);
    }
    
    public static STTextStrikeType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1InputStream, STTextStrikeType.type, null);
    }
    
    public static STTextStrikeType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1InputStream, STTextStrikeType.type, param1XmlOptions);
    }
    
    public static STTextStrikeType parse(Reader param1Reader) throws XmlException, IOException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1Reader, STTextStrikeType.type, null);
    }
    
    public static STTextStrikeType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1Reader, STTextStrikeType.type, param1XmlOptions);
    }
    
    public static STTextStrikeType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextStrikeType.type, null);
    }
    
    public static STTextStrikeType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1XMLStreamReader, STTextStrikeType.type, param1XmlOptions);
    }
    
    public static STTextStrikeType parse(Node param1Node) throws XmlException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1Node, STTextStrikeType.type, null);
    }
    
    public static STTextStrikeType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1Node, STTextStrikeType.type, param1XmlOptions);
    }
    
    public static STTextStrikeType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextStrikeType.type, null);
    }
    
    public static STTextStrikeType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTextStrikeType)POIXMLTypeLoader.parse(param1XMLInputStream, STTextStrikeType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextStrikeType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTextStrikeType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_NO_STRIKE = 1;
    
    static final int INT_SNG_STRIKE = 2;
    
    static final int INT_DBL_STRIKE = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("noStrike", 1), new Enum("sngStrike", 2), new Enum("dblStrike", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STTextStrikeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */