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

public interface STAxis extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STAxis.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("staxis45batype");
  
  public static final Enum AXIS_ROW = Enum.forString("axisRow");
  
  public static final Enum AXIS_COL = Enum.forString("axisCol");
  
  public static final Enum AXIS_PAGE = Enum.forString("axisPage");
  
  public static final Enum AXIS_VALUES = Enum.forString("axisValues");
  
  public static final int INT_AXIS_ROW = 1;
  
  public static final int INT_AXIS_COL = 2;
  
  public static final int INT_AXIS_PAGE = 3;
  
  public static final int INT_AXIS_VALUES = 4;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STAxis newValue(Object param1Object) {
      return (STAxis)STAxis.type.newValue(param1Object);
    }
    
    public static STAxis newInstance() {
      return (STAxis)POIXMLTypeLoader.newInstance(STAxis.type, null);
    }
    
    public static STAxis newInstance(XmlOptions param1XmlOptions) {
      return (STAxis)POIXMLTypeLoader.newInstance(STAxis.type, param1XmlOptions);
    }
    
    public static STAxis parse(String param1String) throws XmlException {
      return (STAxis)POIXMLTypeLoader.parse(param1String, STAxis.type, null);
    }
    
    public static STAxis parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STAxis)POIXMLTypeLoader.parse(param1String, STAxis.type, param1XmlOptions);
    }
    
    public static STAxis parse(File param1File) throws XmlException, IOException {
      return (STAxis)POIXMLTypeLoader.parse(param1File, STAxis.type, null);
    }
    
    public static STAxis parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAxis)POIXMLTypeLoader.parse(param1File, STAxis.type, param1XmlOptions);
    }
    
    public static STAxis parse(URL param1URL) throws XmlException, IOException {
      return (STAxis)POIXMLTypeLoader.parse(param1URL, STAxis.type, null);
    }
    
    public static STAxis parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAxis)POIXMLTypeLoader.parse(param1URL, STAxis.type, param1XmlOptions);
    }
    
    public static STAxis parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STAxis)POIXMLTypeLoader.parse(param1InputStream, STAxis.type, null);
    }
    
    public static STAxis parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAxis)POIXMLTypeLoader.parse(param1InputStream, STAxis.type, param1XmlOptions);
    }
    
    public static STAxis parse(Reader param1Reader) throws XmlException, IOException {
      return (STAxis)POIXMLTypeLoader.parse(param1Reader, STAxis.type, null);
    }
    
    public static STAxis parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STAxis)POIXMLTypeLoader.parse(param1Reader, STAxis.type, param1XmlOptions);
    }
    
    public static STAxis parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STAxis)POIXMLTypeLoader.parse(param1XMLStreamReader, STAxis.type, null);
    }
    
    public static STAxis parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STAxis)POIXMLTypeLoader.parse(param1XMLStreamReader, STAxis.type, param1XmlOptions);
    }
    
    public static STAxis parse(Node param1Node) throws XmlException {
      return (STAxis)POIXMLTypeLoader.parse(param1Node, STAxis.type, null);
    }
    
    public static STAxis parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STAxis)POIXMLTypeLoader.parse(param1Node, STAxis.type, param1XmlOptions);
    }
    
    public static STAxis parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STAxis)POIXMLTypeLoader.parse(param1XMLInputStream, STAxis.type, null);
    }
    
    public static STAxis parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STAxis)POIXMLTypeLoader.parse(param1XMLInputStream, STAxis.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STAxis.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STAxis.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_AXIS_ROW = 1;
    
    static final int INT_AXIS_COL = 2;
    
    static final int INT_AXIS_PAGE = 3;
    
    static final int INT_AXIS_VALUES = 4;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("axisRow", 1), new Enum("axisCol", 2), new Enum("axisPage", 3), new Enum("axisValues", 4) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STAxis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */