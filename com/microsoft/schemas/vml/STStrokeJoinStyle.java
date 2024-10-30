package com.microsoft.schemas.vml;

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

public interface STStrokeJoinStyle extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STStrokeJoinStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ststrokejoinstyle3c13type");
  
  public static final Enum ROUND = Enum.forString("round");
  
  public static final Enum BEVEL = Enum.forString("bevel");
  
  public static final Enum MITER = Enum.forString("miter");
  
  public static final int INT_ROUND = 1;
  
  public static final int INT_BEVEL = 2;
  
  public static final int INT_MITER = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STStrokeJoinStyle newValue(Object param1Object) {
      return (STStrokeJoinStyle)STStrokeJoinStyle.type.newValue(param1Object);
    }
    
    public static STStrokeJoinStyle newInstance() {
      return (STStrokeJoinStyle)POIXMLTypeLoader.newInstance(STStrokeJoinStyle.type, null);
    }
    
    public static STStrokeJoinStyle newInstance(XmlOptions param1XmlOptions) {
      return (STStrokeJoinStyle)POIXMLTypeLoader.newInstance(STStrokeJoinStyle.type, param1XmlOptions);
    }
    
    public static STStrokeJoinStyle parse(String param1String) throws XmlException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1String, STStrokeJoinStyle.type, null);
    }
    
    public static STStrokeJoinStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1String, STStrokeJoinStyle.type, param1XmlOptions);
    }
    
    public static STStrokeJoinStyle parse(File param1File) throws XmlException, IOException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1File, STStrokeJoinStyle.type, null);
    }
    
    public static STStrokeJoinStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1File, STStrokeJoinStyle.type, param1XmlOptions);
    }
    
    public static STStrokeJoinStyle parse(URL param1URL) throws XmlException, IOException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1URL, STStrokeJoinStyle.type, null);
    }
    
    public static STStrokeJoinStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1URL, STStrokeJoinStyle.type, param1XmlOptions);
    }
    
    public static STStrokeJoinStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1InputStream, STStrokeJoinStyle.type, null);
    }
    
    public static STStrokeJoinStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1InputStream, STStrokeJoinStyle.type, param1XmlOptions);
    }
    
    public static STStrokeJoinStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1Reader, STStrokeJoinStyle.type, null);
    }
    
    public static STStrokeJoinStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1Reader, STStrokeJoinStyle.type, param1XmlOptions);
    }
    
    public static STStrokeJoinStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, STStrokeJoinStyle.type, null);
    }
    
    public static STStrokeJoinStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, STStrokeJoinStyle.type, param1XmlOptions);
    }
    
    public static STStrokeJoinStyle parse(Node param1Node) throws XmlException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1Node, STStrokeJoinStyle.type, null);
    }
    
    public static STStrokeJoinStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1Node, STStrokeJoinStyle.type, param1XmlOptions);
    }
    
    public static STStrokeJoinStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1XMLInputStream, STStrokeJoinStyle.type, null);
    }
    
    public static STStrokeJoinStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STStrokeJoinStyle)POIXMLTypeLoader.parse(param1XMLInputStream, STStrokeJoinStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STStrokeJoinStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STStrokeJoinStyle.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_ROUND = 1;
    
    static final int INT_BEVEL = 2;
    
    static final int INT_MITER = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("round", 1), new Enum("bevel", 2), new Enum("miter", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\STStrokeJoinStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */