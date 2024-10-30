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

public interface STBlockSize extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STBlockSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("stblocksize2e10type");
  
  int getIntValue();
  
  void setIntValue(int paramInt);
  
  int intValue();
  
  void set(int paramInt);
  
  public static final class Factory {
    public static STBlockSize newValue(Object param1Object) {
      return (STBlockSize)STBlockSize.type.newValue(param1Object);
    }
    
    public static STBlockSize newInstance() {
      return (STBlockSize)POIXMLTypeLoader.newInstance(STBlockSize.type, null);
    }
    
    public static STBlockSize newInstance(XmlOptions param1XmlOptions) {
      return (STBlockSize)POIXMLTypeLoader.newInstance(STBlockSize.type, param1XmlOptions);
    }
    
    public static STBlockSize parse(String param1String) throws XmlException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1String, STBlockSize.type, null);
    }
    
    public static STBlockSize parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1String, STBlockSize.type, param1XmlOptions);
    }
    
    public static STBlockSize parse(File param1File) throws XmlException, IOException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1File, STBlockSize.type, null);
    }
    
    public static STBlockSize parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1File, STBlockSize.type, param1XmlOptions);
    }
    
    public static STBlockSize parse(URL param1URL) throws XmlException, IOException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1URL, STBlockSize.type, null);
    }
    
    public static STBlockSize parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1URL, STBlockSize.type, param1XmlOptions);
    }
    
    public static STBlockSize parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1InputStream, STBlockSize.type, null);
    }
    
    public static STBlockSize parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1InputStream, STBlockSize.type, param1XmlOptions);
    }
    
    public static STBlockSize parse(Reader param1Reader) throws XmlException, IOException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1Reader, STBlockSize.type, null);
    }
    
    public static STBlockSize parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1Reader, STBlockSize.type, param1XmlOptions);
    }
    
    public static STBlockSize parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1XMLStreamReader, STBlockSize.type, null);
    }
    
    public static STBlockSize parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1XMLStreamReader, STBlockSize.type, param1XmlOptions);
    }
    
    public static STBlockSize parse(Node param1Node) throws XmlException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1Node, STBlockSize.type, null);
    }
    
    public static STBlockSize parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1Node, STBlockSize.type, param1XmlOptions);
    }
    
    public static STBlockSize parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1XMLInputStream, STBlockSize.type, null);
    }
    
    public static STBlockSize parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STBlockSize)POIXMLTypeLoader.parse(param1XMLInputStream, STBlockSize.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STBlockSize.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STBlockSize.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\STBlockSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */