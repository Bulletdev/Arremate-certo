package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

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

public interface STEditAs extends XmlToken {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STEditAs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("steditasad40type");
  
  public static final Enum TWO_CELL = Enum.forString("twoCell");
  
  public static final Enum ONE_CELL = Enum.forString("oneCell");
  
  public static final Enum ABSOLUTE = Enum.forString("absolute");
  
  public static final int INT_TWO_CELL = 1;
  
  public static final int INT_ONE_CELL = 2;
  
  public static final int INT_ABSOLUTE = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STEditAs newValue(Object param1Object) {
      return (STEditAs)STEditAs.type.newValue(param1Object);
    }
    
    public static STEditAs newInstance() {
      return (STEditAs)POIXMLTypeLoader.newInstance(STEditAs.type, null);
    }
    
    public static STEditAs newInstance(XmlOptions param1XmlOptions) {
      return (STEditAs)POIXMLTypeLoader.newInstance(STEditAs.type, param1XmlOptions);
    }
    
    public static STEditAs parse(String param1String) throws XmlException {
      return (STEditAs)POIXMLTypeLoader.parse(param1String, STEditAs.type, null);
    }
    
    public static STEditAs parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STEditAs)POIXMLTypeLoader.parse(param1String, STEditAs.type, param1XmlOptions);
    }
    
    public static STEditAs parse(File param1File) throws XmlException, IOException {
      return (STEditAs)POIXMLTypeLoader.parse(param1File, STEditAs.type, null);
    }
    
    public static STEditAs parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STEditAs)POIXMLTypeLoader.parse(param1File, STEditAs.type, param1XmlOptions);
    }
    
    public static STEditAs parse(URL param1URL) throws XmlException, IOException {
      return (STEditAs)POIXMLTypeLoader.parse(param1URL, STEditAs.type, null);
    }
    
    public static STEditAs parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STEditAs)POIXMLTypeLoader.parse(param1URL, STEditAs.type, param1XmlOptions);
    }
    
    public static STEditAs parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STEditAs)POIXMLTypeLoader.parse(param1InputStream, STEditAs.type, null);
    }
    
    public static STEditAs parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STEditAs)POIXMLTypeLoader.parse(param1InputStream, STEditAs.type, param1XmlOptions);
    }
    
    public static STEditAs parse(Reader param1Reader) throws XmlException, IOException {
      return (STEditAs)POIXMLTypeLoader.parse(param1Reader, STEditAs.type, null);
    }
    
    public static STEditAs parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STEditAs)POIXMLTypeLoader.parse(param1Reader, STEditAs.type, param1XmlOptions);
    }
    
    public static STEditAs parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STEditAs)POIXMLTypeLoader.parse(param1XMLStreamReader, STEditAs.type, null);
    }
    
    public static STEditAs parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STEditAs)POIXMLTypeLoader.parse(param1XMLStreamReader, STEditAs.type, param1XmlOptions);
    }
    
    public static STEditAs parse(Node param1Node) throws XmlException {
      return (STEditAs)POIXMLTypeLoader.parse(param1Node, STEditAs.type, null);
    }
    
    public static STEditAs parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STEditAs)POIXMLTypeLoader.parse(param1Node, STEditAs.type, param1XmlOptions);
    }
    
    public static STEditAs parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STEditAs)POIXMLTypeLoader.parse(param1XMLInputStream, STEditAs.type, null);
    }
    
    public static STEditAs parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STEditAs)POIXMLTypeLoader.parse(param1XMLInputStream, STEditAs.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STEditAs.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STEditAs.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_TWO_CELL = 1;
    
    static final int INT_ONE_CELL = 2;
    
    static final int INT_ABSOLUTE = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("twoCell", 1), new Enum("oneCell", 2), new Enum("absolute", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\STEditAs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */