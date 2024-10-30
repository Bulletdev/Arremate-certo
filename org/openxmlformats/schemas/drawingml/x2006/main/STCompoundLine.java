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

public interface STCompoundLine extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STCompoundLine.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stcompoundline712atype");
  
  public static final Enum SNG = Enum.forString("sng");
  
  public static final Enum DBL = Enum.forString("dbl");
  
  public static final Enum THICK_THIN = Enum.forString("thickThin");
  
  public static final Enum THIN_THICK = Enum.forString("thinThick");
  
  public static final Enum TRI = Enum.forString("tri");
  
  public static final int INT_SNG = 1;
  
  public static final int INT_DBL = 2;
  
  public static final int INT_THICK_THIN = 3;
  
  public static final int INT_THIN_THICK = 4;
  
  public static final int INT_TRI = 5;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STCompoundLine newValue(Object param1Object) {
      return (STCompoundLine)STCompoundLine.type.newValue(param1Object);
    }
    
    public static STCompoundLine newInstance() {
      return (STCompoundLine)POIXMLTypeLoader.newInstance(STCompoundLine.type, null);
    }
    
    public static STCompoundLine newInstance(XmlOptions param1XmlOptions) {
      return (STCompoundLine)POIXMLTypeLoader.newInstance(STCompoundLine.type, param1XmlOptions);
    }
    
    public static STCompoundLine parse(String param1String) throws XmlException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1String, STCompoundLine.type, null);
    }
    
    public static STCompoundLine parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1String, STCompoundLine.type, param1XmlOptions);
    }
    
    public static STCompoundLine parse(File param1File) throws XmlException, IOException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1File, STCompoundLine.type, null);
    }
    
    public static STCompoundLine parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1File, STCompoundLine.type, param1XmlOptions);
    }
    
    public static STCompoundLine parse(URL param1URL) throws XmlException, IOException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1URL, STCompoundLine.type, null);
    }
    
    public static STCompoundLine parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1URL, STCompoundLine.type, param1XmlOptions);
    }
    
    public static STCompoundLine parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1InputStream, STCompoundLine.type, null);
    }
    
    public static STCompoundLine parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1InputStream, STCompoundLine.type, param1XmlOptions);
    }
    
    public static STCompoundLine parse(Reader param1Reader) throws XmlException, IOException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1Reader, STCompoundLine.type, null);
    }
    
    public static STCompoundLine parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1Reader, STCompoundLine.type, param1XmlOptions);
    }
    
    public static STCompoundLine parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1XMLStreamReader, STCompoundLine.type, null);
    }
    
    public static STCompoundLine parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1XMLStreamReader, STCompoundLine.type, param1XmlOptions);
    }
    
    public static STCompoundLine parse(Node param1Node) throws XmlException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1Node, STCompoundLine.type, null);
    }
    
    public static STCompoundLine parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1Node, STCompoundLine.type, param1XmlOptions);
    }
    
    public static STCompoundLine parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1XMLInputStream, STCompoundLine.type, null);
    }
    
    public static STCompoundLine parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STCompoundLine)POIXMLTypeLoader.parse(param1XMLInputStream, STCompoundLine.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCompoundLine.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STCompoundLine.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_SNG = 1;
    
    static final int INT_DBL = 2;
    
    static final int INT_THICK_THIN = 3;
    
    static final int INT_THIN_THICK = 4;
    
    static final int INT_TRI = 5;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("sng", 1), new Enum("dbl", 2), new Enum("thickThin", 3), new Enum("thinThick", 4), new Enum("tri", 5) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\STCompoundLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */