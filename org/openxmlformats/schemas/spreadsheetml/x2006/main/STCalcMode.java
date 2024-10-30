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

public interface STCalcMode extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCalcMode.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcalcmode5e71type");
  
  public static final Enum MANUAL = Enum.forString("manual");
  
  public static final Enum AUTO = Enum.forString("auto");
  
  public static final Enum AUTO_NO_TABLE = Enum.forString("autoNoTable");
  
  public static final int INT_MANUAL = 1;
  
  public static final int INT_AUTO = 2;
  
  public static final int INT_AUTO_NO_TABLE = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STCalcMode newValue(Object param1Object) {
      return (STCalcMode)STCalcMode.type.newValue(param1Object);
    }
    
    public static STCalcMode newInstance() {
      return (STCalcMode)POIXMLTypeLoader.newInstance(STCalcMode.type, null);
    }
    
    public static STCalcMode newInstance(XmlOptions param1XmlOptions) {
      return (STCalcMode)POIXMLTypeLoader.newInstance(STCalcMode.type, param1XmlOptions);
    }
    
    public static STCalcMode parse(String param1String) throws XmlException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1String, STCalcMode.type, null);
    }
    
    public static STCalcMode parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1String, STCalcMode.type, param1XmlOptions);
    }
    
    public static STCalcMode parse(File param1File) throws XmlException, IOException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1File, STCalcMode.type, null);
    }
    
    public static STCalcMode parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1File, STCalcMode.type, param1XmlOptions);
    }
    
    public static STCalcMode parse(URL param1URL) throws XmlException, IOException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1URL, STCalcMode.type, null);
    }
    
    public static STCalcMode parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1URL, STCalcMode.type, param1XmlOptions);
    }
    
    public static STCalcMode parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1InputStream, STCalcMode.type, null);
    }
    
    public static STCalcMode parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1InputStream, STCalcMode.type, param1XmlOptions);
    }
    
    public static STCalcMode parse(Reader param1Reader) throws XmlException, IOException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1Reader, STCalcMode.type, null);
    }
    
    public static STCalcMode parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1Reader, STCalcMode.type, param1XmlOptions);
    }
    
    public static STCalcMode parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1XMLStreamReader, STCalcMode.type, null);
    }
    
    public static STCalcMode parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1XMLStreamReader, STCalcMode.type, param1XmlOptions);
    }
    
    public static STCalcMode parse(Node param1Node) throws XmlException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1Node, STCalcMode.type, null);
    }
    
    public static STCalcMode parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1Node, STCalcMode.type, param1XmlOptions);
    }
    
    public static STCalcMode parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1XMLInputStream, STCalcMode.type, null);
    }
    
    public static STCalcMode parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCalcMode)POIXMLTypeLoader.parse(param1XMLInputStream, STCalcMode.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCalcMode.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCalcMode.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_MANUAL = 1;
    
    static final int INT_AUTO = 2;
    
    static final int INT_AUTO_NO_TABLE = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("manual", 1), new Enum("auto", 2), new Enum("autoNoTable", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STCalcMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */