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

public interface STDataValidationErrorStyle extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STDataValidationErrorStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stdatavalidationerrorstyleca85type");
  
  public static final Enum STOP = Enum.forString("stop");
  
  public static final Enum WARNING = Enum.forString("warning");
  
  public static final Enum INFORMATION = Enum.forString("information");
  
  public static final int INT_STOP = 1;
  
  public static final int INT_WARNING = 2;
  
  public static final int INT_INFORMATION = 3;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STDataValidationErrorStyle newValue(Object param1Object) {
      return (STDataValidationErrorStyle)STDataValidationErrorStyle.type.newValue(param1Object);
    }
    
    public static STDataValidationErrorStyle newInstance() {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.newInstance(STDataValidationErrorStyle.type, null);
    }
    
    public static STDataValidationErrorStyle newInstance(XmlOptions param1XmlOptions) {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.newInstance(STDataValidationErrorStyle.type, param1XmlOptions);
    }
    
    public static STDataValidationErrorStyle parse(String param1String) throws XmlException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1String, STDataValidationErrorStyle.type, null);
    }
    
    public static STDataValidationErrorStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1String, STDataValidationErrorStyle.type, param1XmlOptions);
    }
    
    public static STDataValidationErrorStyle parse(File param1File) throws XmlException, IOException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1File, STDataValidationErrorStyle.type, null);
    }
    
    public static STDataValidationErrorStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1File, STDataValidationErrorStyle.type, param1XmlOptions);
    }
    
    public static STDataValidationErrorStyle parse(URL param1URL) throws XmlException, IOException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1URL, STDataValidationErrorStyle.type, null);
    }
    
    public static STDataValidationErrorStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1URL, STDataValidationErrorStyle.type, param1XmlOptions);
    }
    
    public static STDataValidationErrorStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1InputStream, STDataValidationErrorStyle.type, null);
    }
    
    public static STDataValidationErrorStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1InputStream, STDataValidationErrorStyle.type, param1XmlOptions);
    }
    
    public static STDataValidationErrorStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1Reader, STDataValidationErrorStyle.type, null);
    }
    
    public static STDataValidationErrorStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1Reader, STDataValidationErrorStyle.type, param1XmlOptions);
    }
    
    public static STDataValidationErrorStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, STDataValidationErrorStyle.type, null);
    }
    
    public static STDataValidationErrorStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, STDataValidationErrorStyle.type, param1XmlOptions);
    }
    
    public static STDataValidationErrorStyle parse(Node param1Node) throws XmlException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1Node, STDataValidationErrorStyle.type, null);
    }
    
    public static STDataValidationErrorStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1Node, STDataValidationErrorStyle.type, param1XmlOptions);
    }
    
    public static STDataValidationErrorStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1XMLInputStream, STDataValidationErrorStyle.type, null);
    }
    
    public static STDataValidationErrorStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STDataValidationErrorStyle)POIXMLTypeLoader.parse(param1XMLInputStream, STDataValidationErrorStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDataValidationErrorStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDataValidationErrorStyle.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_STOP = 1;
    
    static final int INT_WARNING = 2;
    
    static final int INT_INFORMATION = 3;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("stop", 1), new Enum("warning", 2), new Enum("information", 3) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STDataValidationErrorStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */