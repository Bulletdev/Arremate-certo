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

public interface STXmlDataType extends XmlString {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STXmlDataType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("stxmldatatyped64atype");
  
  public static final Enum STRING = Enum.forString("string");
  
  public static final Enum NORMALIZED_STRING = Enum.forString("normalizedString");
  
  public static final Enum TOKEN = Enum.forString("token");
  
  public static final Enum BYTE = Enum.forString("byte");
  
  public static final Enum UNSIGNED_BYTE = Enum.forString("unsignedByte");
  
  public static final Enum BASE_64_BINARY = Enum.forString("base64Binary");
  
  public static final Enum HEX_BINARY = Enum.forString("hexBinary");
  
  public static final Enum INTEGER = Enum.forString("integer");
  
  public static final Enum POSITIVE_INTEGER = Enum.forString("positiveInteger");
  
  public static final Enum NEGATIVE_INTEGER = Enum.forString("negativeInteger");
  
  public static final Enum NON_POSITIVE_INTEGER = Enum.forString("nonPositiveInteger");
  
  public static final Enum NON_NEGATIVE_INTEGER = Enum.forString("nonNegativeInteger");
  
  public static final Enum INT = Enum.forString("int");
  
  public static final Enum UNSIGNED_INT = Enum.forString("unsignedInt");
  
  public static final Enum LONG = Enum.forString("long");
  
  public static final Enum UNSIGNED_LONG = Enum.forString("unsignedLong");
  
  public static final Enum SHORT = Enum.forString("short");
  
  public static final Enum UNSIGNED_SHORT = Enum.forString("unsignedShort");
  
  public static final Enum DECIMAL = Enum.forString("decimal");
  
  public static final Enum FLOAT = Enum.forString("float");
  
  public static final Enum DOUBLE = Enum.forString("double");
  
  public static final Enum BOOLEAN = Enum.forString("boolean");
  
  public static final Enum TIME = Enum.forString("time");
  
  public static final Enum DATE_TIME = Enum.forString("dateTime");
  
  public static final Enum DURATION = Enum.forString("duration");
  
  public static final Enum DATE = Enum.forString("date");
  
  public static final Enum G_MONTH = Enum.forString("gMonth");
  
  public static final Enum G_YEAR = Enum.forString("gYear");
  
  public static final Enum G_YEAR_MONTH = Enum.forString("gYearMonth");
  
  public static final Enum G_DAY = Enum.forString("gDay");
  
  public static final Enum G_MONTH_DAY = Enum.forString("gMonthDay");
  
  public static final Enum NAME = Enum.forString("Name");
  
  public static final Enum Q_NAME = Enum.forString("QName");
  
  public static final Enum NC_NAME = Enum.forString("NCName");
  
  public static final Enum ANY_URI = Enum.forString("anyURI");
  
  public static final Enum LANGUAGE = Enum.forString("language");
  
  public static final Enum ID = Enum.forString("ID");
  
  public static final Enum IDREF = Enum.forString("IDREF");
  
  public static final Enum IDREFS = Enum.forString("IDREFS");
  
  public static final Enum ENTITY = Enum.forString("ENTITY");
  
  public static final Enum ENTITIES = Enum.forString("ENTITIES");
  
  public static final Enum NOTATION = Enum.forString("NOTATION");
  
  public static final Enum NMTOKEN = Enum.forString("NMTOKEN");
  
  public static final Enum NMTOKENS = Enum.forString("NMTOKENS");
  
  public static final Enum ANY_TYPE = Enum.forString("anyType");
  
  public static final int INT_STRING = 1;
  
  public static final int INT_NORMALIZED_STRING = 2;
  
  public static final int INT_TOKEN = 3;
  
  public static final int INT_BYTE = 4;
  
  public static final int INT_UNSIGNED_BYTE = 5;
  
  public static final int INT_BASE_64_BINARY = 6;
  
  public static final int INT_HEX_BINARY = 7;
  
  public static final int INT_INTEGER = 8;
  
  public static final int INT_POSITIVE_INTEGER = 9;
  
  public static final int INT_NEGATIVE_INTEGER = 10;
  
  public static final int INT_NON_POSITIVE_INTEGER = 11;
  
  public static final int INT_NON_NEGATIVE_INTEGER = 12;
  
  public static final int INT_INT = 13;
  
  public static final int INT_UNSIGNED_INT = 14;
  
  public static final int INT_LONG = 15;
  
  public static final int INT_UNSIGNED_LONG = 16;
  
  public static final int INT_SHORT = 17;
  
  public static final int INT_UNSIGNED_SHORT = 18;
  
  public static final int INT_DECIMAL = 19;
  
  public static final int INT_FLOAT = 20;
  
  public static final int INT_DOUBLE = 21;
  
  public static final int INT_BOOLEAN = 22;
  
  public static final int INT_TIME = 23;
  
  public static final int INT_DATE_TIME = 24;
  
  public static final int INT_DURATION = 25;
  
  public static final int INT_DATE = 26;
  
  public static final int INT_G_MONTH = 27;
  
  public static final int INT_G_YEAR = 28;
  
  public static final int INT_G_YEAR_MONTH = 29;
  
  public static final int INT_G_DAY = 30;
  
  public static final int INT_G_MONTH_DAY = 31;
  
  public static final int INT_NAME = 32;
  
  public static final int INT_Q_NAME = 33;
  
  public static final int INT_NC_NAME = 34;
  
  public static final int INT_ANY_URI = 35;
  
  public static final int INT_LANGUAGE = 36;
  
  public static final int INT_ID = 37;
  
  public static final int INT_IDREF = 38;
  
  public static final int INT_IDREFS = 39;
  
  public static final int INT_ENTITY = 40;
  
  public static final int INT_ENTITIES = 41;
  
  public static final int INT_NOTATION = 42;
  
  public static final int INT_NMTOKEN = 43;
  
  public static final int INT_NMTOKENS = 44;
  
  public static final int INT_ANY_TYPE = 45;
  
  StringEnumAbstractBase enumValue();
  
  void set(StringEnumAbstractBase paramStringEnumAbstractBase);
  
  public static final class Factory {
    public static STXmlDataType newValue(Object param1Object) {
      return (STXmlDataType)STXmlDataType.type.newValue(param1Object);
    }
    
    public static STXmlDataType newInstance() {
      return (STXmlDataType)POIXMLTypeLoader.newInstance(STXmlDataType.type, null);
    }
    
    public static STXmlDataType newInstance(XmlOptions param1XmlOptions) {
      return (STXmlDataType)POIXMLTypeLoader.newInstance(STXmlDataType.type, param1XmlOptions);
    }
    
    public static STXmlDataType parse(String param1String) throws XmlException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1String, STXmlDataType.type, null);
    }
    
    public static STXmlDataType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1String, STXmlDataType.type, param1XmlOptions);
    }
    
    public static STXmlDataType parse(File param1File) throws XmlException, IOException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1File, STXmlDataType.type, null);
    }
    
    public static STXmlDataType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1File, STXmlDataType.type, param1XmlOptions);
    }
    
    public static STXmlDataType parse(URL param1URL) throws XmlException, IOException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1URL, STXmlDataType.type, null);
    }
    
    public static STXmlDataType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1URL, STXmlDataType.type, param1XmlOptions);
    }
    
    public static STXmlDataType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1InputStream, STXmlDataType.type, null);
    }
    
    public static STXmlDataType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1InputStream, STXmlDataType.type, param1XmlOptions);
    }
    
    public static STXmlDataType parse(Reader param1Reader) throws XmlException, IOException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1Reader, STXmlDataType.type, null);
    }
    
    public static STXmlDataType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1Reader, STXmlDataType.type, param1XmlOptions);
    }
    
    public static STXmlDataType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1XMLStreamReader, STXmlDataType.type, null);
    }
    
    public static STXmlDataType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1XMLStreamReader, STXmlDataType.type, param1XmlOptions);
    }
    
    public static STXmlDataType parse(Node param1Node) throws XmlException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1Node, STXmlDataType.type, null);
    }
    
    public static STXmlDataType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1Node, STXmlDataType.type, param1XmlOptions);
    }
    
    public static STXmlDataType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1XMLInputStream, STXmlDataType.type, null);
    }
    
    public static STXmlDataType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STXmlDataType)POIXMLTypeLoader.parse(param1XMLInputStream, STXmlDataType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STXmlDataType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STXmlDataType.type, param1XmlOptions);
    }
  }
  
  public static final class Enum extends StringEnumAbstractBase {
    static final int INT_STRING = 1;
    
    static final int INT_NORMALIZED_STRING = 2;
    
    static final int INT_TOKEN = 3;
    
    static final int INT_BYTE = 4;
    
    static final int INT_UNSIGNED_BYTE = 5;
    
    static final int INT_BASE_64_BINARY = 6;
    
    static final int INT_HEX_BINARY = 7;
    
    static final int INT_INTEGER = 8;
    
    static final int INT_POSITIVE_INTEGER = 9;
    
    static final int INT_NEGATIVE_INTEGER = 10;
    
    static final int INT_NON_POSITIVE_INTEGER = 11;
    
    static final int INT_NON_NEGATIVE_INTEGER = 12;
    
    static final int INT_INT = 13;
    
    static final int INT_UNSIGNED_INT = 14;
    
    static final int INT_LONG = 15;
    
    static final int INT_UNSIGNED_LONG = 16;
    
    static final int INT_SHORT = 17;
    
    static final int INT_UNSIGNED_SHORT = 18;
    
    static final int INT_DECIMAL = 19;
    
    static final int INT_FLOAT = 20;
    
    static final int INT_DOUBLE = 21;
    
    static final int INT_BOOLEAN = 22;
    
    static final int INT_TIME = 23;
    
    static final int INT_DATE_TIME = 24;
    
    static final int INT_DURATION = 25;
    
    static final int INT_DATE = 26;
    
    static final int INT_G_MONTH = 27;
    
    static final int INT_G_YEAR = 28;
    
    static final int INT_G_YEAR_MONTH = 29;
    
    static final int INT_G_DAY = 30;
    
    static final int INT_G_MONTH_DAY = 31;
    
    static final int INT_NAME = 32;
    
    static final int INT_Q_NAME = 33;
    
    static final int INT_NC_NAME = 34;
    
    static final int INT_ANY_URI = 35;
    
    static final int INT_LANGUAGE = 36;
    
    static final int INT_ID = 37;
    
    static final int INT_IDREF = 38;
    
    static final int INT_IDREFS = 39;
    
    static final int INT_ENTITY = 40;
    
    static final int INT_ENTITIES = 41;
    
    static final int INT_NOTATION = 42;
    
    static final int INT_NMTOKEN = 43;
    
    static final int INT_NMTOKENS = 44;
    
    static final int INT_ANY_TYPE = 45;
    
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table((StringEnumAbstractBase[])new Enum[] { 
          new Enum("string", 1), new Enum("normalizedString", 2), new Enum("token", 3), new Enum("byte", 4), new Enum("unsignedByte", 5), new Enum("base64Binary", 6), new Enum("hexBinary", 7), new Enum("integer", 8), new Enum("positiveInteger", 9), new Enum("negativeInteger", 10), 
          new Enum("nonPositiveInteger", 11), new Enum("nonNegativeInteger", 12), new Enum("int", 13), new Enum("unsignedInt", 14), new Enum("long", 15), new Enum("unsignedLong", 16), new Enum("short", 17), new Enum("unsignedShort", 18), new Enum("decimal", 19), new Enum("float", 20), 
          new Enum("double", 21), new Enum("boolean", 22), new Enum("time", 23), new Enum("dateTime", 24), new Enum("duration", 25), new Enum("date", 26), new Enum("gMonth", 27), new Enum("gYear", 28), new Enum("gYearMonth", 29), new Enum("gDay", 30), 
          new Enum("gMonthDay", 31), new Enum("Name", 32), new Enum("QName", 33), new Enum("NCName", 34), new Enum("anyURI", 35), new Enum("language", 36), new Enum("ID", 37), new Enum("IDREF", 38), new Enum("IDREFS", 39), new Enum("ENTITY", 40), 
          new Enum("ENTITIES", 41), new Enum("NOTATION", 42), new Enum("NMTOKEN", 43), new Enum("NMTOKENS", 44), new Enum("anyType", 45) });
    
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\STXmlDataType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */