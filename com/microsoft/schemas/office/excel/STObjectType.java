package com.microsoft.schemas.office.excel;

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

public interface STObjectType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STObjectType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stobjecttype97a7type");
  
  public static final Enum BUTTON = Enum.forString("Button");
  
  public static final Enum CHECKBOX = Enum.forString("Checkbox");
  
  public static final Enum DIALOG = Enum.forString("Dialog");
  
  public static final Enum DROP = Enum.forString("Drop");
  
  public static final Enum EDIT = Enum.forString("Edit");
  
  public static final Enum G_BOX = Enum.forString("GBox");
  
  public static final Enum LABEL = Enum.forString("Label");
  
  public static final Enum LINE_A = Enum.forString("LineA");
  
  public static final Enum LIST = Enum.forString("List");
  
  public static final Enum MOVIE = Enum.forString("Movie");
  
  public static final Enum NOTE = Enum.forString("Note");
  
  public static final Enum PICT = Enum.forString("Pict");
  
  public static final Enum RADIO = Enum.forString("Radio");
  
  public static final Enum RECT_A = Enum.forString("RectA");
  
  public static final Enum SCROLL = Enum.forString("Scroll");
  
  public static final Enum SPIN = Enum.forString("Spin");
  
  public static final Enum SHAPE = Enum.forString("Shape");
  
  public static final Enum GROUP = Enum.forString("Group");
  
  public static final Enum RECT = Enum.forString("Rect");
  
  public static final int INT_BUTTON = 1;
  
  public static final int INT_CHECKBOX = 2;
  
  public static final int INT_DIALOG = 3;
  
  public static final int INT_DROP = 4;
  
  public static final int INT_EDIT = 5;
  
  public static final int INT_G_BOX = 6;
  
  public static final int INT_LABEL = 7;
  
  public static final int INT_LINE_A = 8;
  
  public static final int INT_LIST = 9;
  
  public static final int INT_MOVIE = 10;
  
  public static final int INT_NOTE = 11;
  
  public static final int INT_PICT = 12;
  
  public static final int INT_RADIO = 13;
  
  public static final int INT_RECT_A = 14;
  
  public static final int INT_SCROLL = 15;
  
  public static final int INT_SPIN = 16;
  
  public static final int INT_SHAPE = 17;
  
  public static final int INT_GROUP = 18;
  
  public static final int INT_RECT = 19;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STObjectType newValue(Object param1Object) {
      return (STObjectType)STObjectType.type.newValue(param1Object);
    }
    
    public static STObjectType newInstance() {
      return (STObjectType)POIXMLTypeLoader.newInstance(STObjectType.type, null);
    }
    
    public static STObjectType newInstance(XmlOptions param1XmlOptions) {
      return (STObjectType)POIXMLTypeLoader.newInstance(STObjectType.type, param1XmlOptions);
    }
    
    public static STObjectType parse(String param1String) throws XmlException {
      return (STObjectType)POIXMLTypeLoader.parse(param1String, STObjectType.type, null);
    }
    
    public static STObjectType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STObjectType)POIXMLTypeLoader.parse(param1String, STObjectType.type, param1XmlOptions);
    }
    
    public static STObjectType parse(File param1File) throws XmlException, IOException {
      return (STObjectType)POIXMLTypeLoader.parse(param1File, STObjectType.type, null);
    }
    
    public static STObjectType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STObjectType)POIXMLTypeLoader.parse(param1File, STObjectType.type, param1XmlOptions);
    }
    
    public static STObjectType parse(URL param1URL) throws XmlException, IOException {
      return (STObjectType)POIXMLTypeLoader.parse(param1URL, STObjectType.type, null);
    }
    
    public static STObjectType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STObjectType)POIXMLTypeLoader.parse(param1URL, STObjectType.type, param1XmlOptions);
    }
    
    public static STObjectType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STObjectType)POIXMLTypeLoader.parse(param1InputStream, STObjectType.type, null);
    }
    
    public static STObjectType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STObjectType)POIXMLTypeLoader.parse(param1InputStream, STObjectType.type, param1XmlOptions);
    }
    
    public static STObjectType parse(Reader param1Reader) throws XmlException, IOException {
      return (STObjectType)POIXMLTypeLoader.parse(param1Reader, STObjectType.type, null);
    }
    
    public static STObjectType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STObjectType)POIXMLTypeLoader.parse(param1Reader, STObjectType.type, param1XmlOptions);
    }
    
    public static STObjectType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STObjectType)POIXMLTypeLoader.parse(param1XMLStreamReader, STObjectType.type, null);
    }
    
    public static STObjectType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STObjectType)POIXMLTypeLoader.parse(param1XMLStreamReader, STObjectType.type, param1XmlOptions);
    }
    
    public static STObjectType parse(Node param1Node) throws XmlException {
      return (STObjectType)POIXMLTypeLoader.parse(param1Node, STObjectType.type, null);
    }
    
    public static STObjectType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STObjectType)POIXMLTypeLoader.parse(param1Node, STObjectType.type, param1XmlOptions);
    }
    
    public static STObjectType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STObjectType)POIXMLTypeLoader.parse(param1XMLInputStream, STObjectType.type, null);
    }
    
    public static STObjectType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STObjectType)POIXMLTypeLoader.parse(param1XMLInputStream, STObjectType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STObjectType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STObjectType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_BUTTON = 1;
    
    static final int INT_CHECKBOX = 2;
    
    static final int INT_DIALOG = 3;
    
    static final int INT_DROP = 4;
    
    static final int INT_EDIT = 5;
    
    static final int INT_G_BOX = 6;
    
    static final int INT_LABEL = 7;
    
    static final int INT_LINE_A = 8;
    
    static final int INT_LIST = 9;
    
    static final int INT_MOVIE = 10;
    
    static final int INT_NOTE = 11;
    
    static final int INT_PICT = 12;
    
    static final int INT_RADIO = 13;
    
    static final int INT_RECT_A = 14;
    
    static final int INT_SCROLL = 15;
    
    static final int INT_SPIN = 16;
    
    static final int INT_SHAPE = 17;
    
    static final int INT_GROUP = 18;
    
    static final int INT_RECT = 19;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("Button", 1), new Enum("Checkbox", 2), new Enum("Dialog", 3), new Enum("Drop", 4), new Enum("Edit", 5), new Enum("GBox", 6), new Enum("Label", 7), new Enum("LineA", 8), new Enum("List", 9), new Enum("Movie", 10), 
          new Enum("Note", 11), new Enum("Pict", 12), new Enum("Radio", 13), new Enum("RectA", 14), new Enum("Scroll", 15), new Enum("Spin", 16), new Enum("Shape", 17), new Enum("Group", 18), new Enum("Rect", 19) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\excel\STObjectType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */