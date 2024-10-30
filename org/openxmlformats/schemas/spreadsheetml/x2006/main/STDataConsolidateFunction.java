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

public interface STDataConsolidateFunction extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STDataConsolidateFunction.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stdataconsolidatefunction1206type");
  
  public static final Enum AVERAGE = Enum.forString("average");
  
  public static final Enum COUNT = Enum.forString("count");
  
  public static final Enum COUNT_NUMS = Enum.forString("countNums");
  
  public static final Enum MAX = Enum.forString("max");
  
  public static final Enum MIN = Enum.forString("min");
  
  public static final Enum PRODUCT = Enum.forString("product");
  
  public static final Enum STD_DEV = Enum.forString("stdDev");
  
  public static final Enum STD_DEVP = Enum.forString("stdDevp");
  
  public static final Enum SUM = Enum.forString("sum");
  
  public static final Enum VAR = Enum.forString("var");
  
  public static final Enum VARP = Enum.forString("varp");
  
  public static final int INT_AVERAGE = 1;
  
  public static final int INT_COUNT = 2;
  
  public static final int INT_COUNT_NUMS = 3;
  
  public static final int INT_MAX = 4;
  
  public static final int INT_MIN = 5;
  
  public static final int INT_PRODUCT = 6;
  
  public static final int INT_STD_DEV = 7;
  
  public static final int INT_STD_DEVP = 8;
  
  public static final int INT_SUM = 9;
  
  public static final int INT_VAR = 10;
  
  public static final int INT_VARP = 11;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STDataConsolidateFunction newValue(Object param1Object) {
      return (STDataConsolidateFunction)STDataConsolidateFunction.type.newValue(param1Object);
    }
    
    public static STDataConsolidateFunction newInstance() {
      return (STDataConsolidateFunction)POIXMLTypeLoader.newInstance(STDataConsolidateFunction.type, null);
    }
    
    public static STDataConsolidateFunction newInstance(XmlOptions param1XmlOptions) {
      return (STDataConsolidateFunction)POIXMLTypeLoader.newInstance(STDataConsolidateFunction.type, param1XmlOptions);
    }
    
    public static STDataConsolidateFunction parse(String param1String) throws XmlException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1String, STDataConsolidateFunction.type, null);
    }
    
    public static STDataConsolidateFunction parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1String, STDataConsolidateFunction.type, param1XmlOptions);
    }
    
    public static STDataConsolidateFunction parse(File param1File) throws XmlException, IOException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1File, STDataConsolidateFunction.type, null);
    }
    
    public static STDataConsolidateFunction parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1File, STDataConsolidateFunction.type, param1XmlOptions);
    }
    
    public static STDataConsolidateFunction parse(URL param1URL) throws XmlException, IOException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1URL, STDataConsolidateFunction.type, null);
    }
    
    public static STDataConsolidateFunction parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1URL, STDataConsolidateFunction.type, param1XmlOptions);
    }
    
    public static STDataConsolidateFunction parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1InputStream, STDataConsolidateFunction.type, null);
    }
    
    public static STDataConsolidateFunction parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1InputStream, STDataConsolidateFunction.type, param1XmlOptions);
    }
    
    public static STDataConsolidateFunction parse(Reader param1Reader) throws XmlException, IOException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1Reader, STDataConsolidateFunction.type, null);
    }
    
    public static STDataConsolidateFunction parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1Reader, STDataConsolidateFunction.type, param1XmlOptions);
    }
    
    public static STDataConsolidateFunction parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1XMLStreamReader, STDataConsolidateFunction.type, null);
    }
    
    public static STDataConsolidateFunction parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1XMLStreamReader, STDataConsolidateFunction.type, param1XmlOptions);
    }
    
    public static STDataConsolidateFunction parse(Node param1Node) throws XmlException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1Node, STDataConsolidateFunction.type, null);
    }
    
    public static STDataConsolidateFunction parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1Node, STDataConsolidateFunction.type, param1XmlOptions);
    }
    
    public static STDataConsolidateFunction parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1XMLInputStream, STDataConsolidateFunction.type, null);
    }
    
    public static STDataConsolidateFunction parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STDataConsolidateFunction)POIXMLTypeLoader.parse(param1XMLInputStream, STDataConsolidateFunction.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDataConsolidateFunction.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STDataConsolidateFunction.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_AVERAGE = 1;
    
    static final int INT_COUNT = 2;
    
    static final int INT_COUNT_NUMS = 3;
    
    static final int INT_MAX = 4;
    
    static final int INT_MIN = 5;
    
    static final int INT_PRODUCT = 6;
    
    static final int INT_STD_DEV = 7;
    
    static final int INT_STD_DEVP = 8;
    
    static final int INT_SUM = 9;
    
    static final int INT_VAR = 10;
    
    static final int INT_VARP = 11;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("average", 1), new Enum("count", 2), new Enum("countNums", 3), new Enum("max", 4), new Enum("min", 5), new Enum("product", 6), new Enum("stdDev", 7), new Enum("stdDevp", 8), new Enum("sum", 9), new Enum("var", 10), 
          new Enum("varp", 11) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STDataConsolidateFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */