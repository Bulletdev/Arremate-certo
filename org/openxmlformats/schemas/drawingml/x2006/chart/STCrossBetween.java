package org.openxmlformats.schemas.drawingml.x2006.chart;

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

public interface STCrossBetween extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCrossBetween.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcrossbetweenf504type");
  
  public static final Enum BETWEEN = Enum.forString("between");
  
  public static final Enum MID_CAT = Enum.forString("midCat");
  
  public static final int INT_BETWEEN = 1;
  
  public static final int INT_MID_CAT = 2;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STCrossBetween newValue(Object param1Object) {
      return (STCrossBetween)STCrossBetween.type.newValue(param1Object);
    }
    
    public static STCrossBetween newInstance() {
      return (STCrossBetween)POIXMLTypeLoader.newInstance(STCrossBetween.type, null);
    }
    
    public static STCrossBetween newInstance(XmlOptions param1XmlOptions) {
      return (STCrossBetween)POIXMLTypeLoader.newInstance(STCrossBetween.type, param1XmlOptions);
    }
    
    public static STCrossBetween parse(String param1String) throws XmlException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1String, STCrossBetween.type, null);
    }
    
    public static STCrossBetween parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1String, STCrossBetween.type, param1XmlOptions);
    }
    
    public static STCrossBetween parse(File param1File) throws XmlException, IOException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1File, STCrossBetween.type, null);
    }
    
    public static STCrossBetween parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1File, STCrossBetween.type, param1XmlOptions);
    }
    
    public static STCrossBetween parse(URL param1URL) throws XmlException, IOException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1URL, STCrossBetween.type, null);
    }
    
    public static STCrossBetween parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1URL, STCrossBetween.type, param1XmlOptions);
    }
    
    public static STCrossBetween parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1InputStream, STCrossBetween.type, null);
    }
    
    public static STCrossBetween parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1InputStream, STCrossBetween.type, param1XmlOptions);
    }
    
    public static STCrossBetween parse(Reader param1Reader) throws XmlException, IOException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1Reader, STCrossBetween.type, null);
    }
    
    public static STCrossBetween parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1Reader, STCrossBetween.type, param1XmlOptions);
    }
    
    public static STCrossBetween parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1XMLStreamReader, STCrossBetween.type, null);
    }
    
    public static STCrossBetween parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1XMLStreamReader, STCrossBetween.type, param1XmlOptions);
    }
    
    public static STCrossBetween parse(Node param1Node) throws XmlException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1Node, STCrossBetween.type, null);
    }
    
    public static STCrossBetween parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1Node, STCrossBetween.type, param1XmlOptions);
    }
    
    public static STCrossBetween parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1XMLInputStream, STCrossBetween.type, null);
    }
    
    public static STCrossBetween parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCrossBetween)POIXMLTypeLoader.parse(param1XMLInputStream, STCrossBetween.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCrossBetween.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCrossBetween.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_BETWEEN = 1;
    
    static final int INT_MID_CAT = 2;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("between", 1), new Enum("midCat", 2) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\STCrossBetween.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */