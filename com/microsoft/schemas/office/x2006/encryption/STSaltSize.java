package com.microsoft.schemas.office.x2006.encryption;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STSaltSize extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STSaltSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("stsaltsizee7a3type");
  
  int getIntValue();
  
  void setIntValue(int paramInt);
  
  int intValue();
  
  void set(int paramInt);
  
  public static final class Factory {
    public static STSaltSize newValue(Object param1Object) {
      return (STSaltSize)STSaltSize.type.newValue(param1Object);
    }
    
    public static STSaltSize newInstance() {
      return (STSaltSize)POIXMLTypeLoader.newInstance(STSaltSize.type, null);
    }
    
    public static STSaltSize newInstance(XmlOptions param1XmlOptions) {
      return (STSaltSize)POIXMLTypeLoader.newInstance(STSaltSize.type, param1XmlOptions);
    }
    
    public static STSaltSize parse(String param1String) throws XmlException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1String, STSaltSize.type, null);
    }
    
    public static STSaltSize parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1String, STSaltSize.type, param1XmlOptions);
    }
    
    public static STSaltSize parse(File param1File) throws XmlException, IOException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1File, STSaltSize.type, null);
    }
    
    public static STSaltSize parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1File, STSaltSize.type, param1XmlOptions);
    }
    
    public static STSaltSize parse(URL param1URL) throws XmlException, IOException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1URL, STSaltSize.type, null);
    }
    
    public static STSaltSize parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1URL, STSaltSize.type, param1XmlOptions);
    }
    
    public static STSaltSize parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1InputStream, STSaltSize.type, null);
    }
    
    public static STSaltSize parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1InputStream, STSaltSize.type, param1XmlOptions);
    }
    
    public static STSaltSize parse(Reader param1Reader) throws XmlException, IOException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1Reader, STSaltSize.type, null);
    }
    
    public static STSaltSize parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1Reader, STSaltSize.type, param1XmlOptions);
    }
    
    public static STSaltSize parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1XMLStreamReader, STSaltSize.type, null);
    }
    
    public static STSaltSize parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1XMLStreamReader, STSaltSize.type, param1XmlOptions);
    }
    
    public static STSaltSize parse(Node param1Node) throws XmlException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1Node, STSaltSize.type, null);
    }
    
    public static STSaltSize parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1Node, STSaltSize.type, param1XmlOptions);
    }
    
    public static STSaltSize parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1XMLInputStream, STSaltSize.type, null);
    }
    
    public static STSaltSize parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STSaltSize)POIXMLTypeLoader.parse(param1XMLInputStream, STSaltSize.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSaltSize.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSaltSize.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\STSaltSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */