package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface STTheme extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STTheme.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sttheme58b9type");
  
  public static final Enum MAJOR_EAST_ASIA = Enum.forString("majorEastAsia");
  
  public static final Enum MAJOR_BIDI = Enum.forString("majorBidi");
  
  public static final Enum MAJOR_ASCII = Enum.forString("majorAscii");
  
  public static final Enum MAJOR_H_ANSI = Enum.forString("majorHAnsi");
  
  public static final Enum MINOR_EAST_ASIA = Enum.forString("minorEastAsia");
  
  public static final Enum MINOR_BIDI = Enum.forString("minorBidi");
  
  public static final Enum MINOR_ASCII = Enum.forString("minorAscii");
  
  public static final Enum MINOR_H_ANSI = Enum.forString("minorHAnsi");
  
  public static final int INT_MAJOR_EAST_ASIA = 1;
  
  public static final int INT_MAJOR_BIDI = 2;
  
  public static final int INT_MAJOR_ASCII = 3;
  
  public static final int INT_MAJOR_H_ANSI = 4;
  
  public static final int INT_MINOR_EAST_ASIA = 5;
  
  public static final int INT_MINOR_BIDI = 6;
  
  public static final int INT_MINOR_ASCII = 7;
  
  public static final int INT_MINOR_H_ANSI = 8;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STTheme newValue(Object param1Object) {
      return (STTheme)STTheme.type.newValue(param1Object);
    }
    
    public static STTheme newInstance() {
      return (STTheme)POIXMLTypeLoader.newInstance(STTheme.type, null);
    }
    
    public static STTheme newInstance(XmlOptions param1XmlOptions) {
      return (STTheme)POIXMLTypeLoader.newInstance(STTheme.type, param1XmlOptions);
    }
    
    public static STTheme parse(String param1String) throws XmlException {
      return (STTheme)POIXMLTypeLoader.parse(param1String, STTheme.type, null);
    }
    
    public static STTheme parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STTheme)POIXMLTypeLoader.parse(param1String, STTheme.type, param1XmlOptions);
    }
    
    public static STTheme parse(File param1File) throws XmlException, IOException {
      return (STTheme)POIXMLTypeLoader.parse(param1File, STTheme.type, null);
    }
    
    public static STTheme parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTheme)POIXMLTypeLoader.parse(param1File, STTheme.type, param1XmlOptions);
    }
    
    public static STTheme parse(URL param1URL) throws XmlException, IOException {
      return (STTheme)POIXMLTypeLoader.parse(param1URL, STTheme.type, null);
    }
    
    public static STTheme parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTheme)POIXMLTypeLoader.parse(param1URL, STTheme.type, param1XmlOptions);
    }
    
    public static STTheme parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STTheme)POIXMLTypeLoader.parse(param1InputStream, STTheme.type, null);
    }
    
    public static STTheme parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTheme)POIXMLTypeLoader.parse(param1InputStream, STTheme.type, param1XmlOptions);
    }
    
    public static STTheme parse(Reader param1Reader) throws XmlException, IOException {
      return (STTheme)POIXMLTypeLoader.parse(param1Reader, STTheme.type, null);
    }
    
    public static STTheme parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STTheme)POIXMLTypeLoader.parse(param1Reader, STTheme.type, param1XmlOptions);
    }
    
    public static STTheme parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STTheme)POIXMLTypeLoader.parse(param1XMLStreamReader, STTheme.type, null);
    }
    
    public static STTheme parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STTheme)POIXMLTypeLoader.parse(param1XMLStreamReader, STTheme.type, param1XmlOptions);
    }
    
    public static STTheme parse(Node param1Node) throws XmlException {
      return (STTheme)POIXMLTypeLoader.parse(param1Node, STTheme.type, null);
    }
    
    public static STTheme parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STTheme)POIXMLTypeLoader.parse(param1Node, STTheme.type, param1XmlOptions);
    }
    
    public static STTheme parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STTheme)POIXMLTypeLoader.parse(param1XMLInputStream, STTheme.type, null);
    }
    
    public static STTheme parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STTheme)POIXMLTypeLoader.parse(param1XMLInputStream, STTheme.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTheme.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STTheme.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_MAJOR_EAST_ASIA = 1;
    
    static final int INT_MAJOR_BIDI = 2;
    
    static final int INT_MAJOR_ASCII = 3;
    
    static final int INT_MAJOR_H_ANSI = 4;
    
    static final int INT_MINOR_EAST_ASIA = 5;
    
    static final int INT_MINOR_BIDI = 6;
    
    static final int INT_MINOR_ASCII = 7;
    
    static final int INT_MINOR_H_ANSI = 8;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { new Enum("majorEastAsia", 1), new Enum("majorBidi", 2), new Enum("majorAscii", 3), new Enum("majorHAnsi", 4), new Enum("minorEastAsia", 5), new Enum("minorBidi", 6), new Enum("minorAscii", 7), new Enum("minorHAnsi", 8) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\STTheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */