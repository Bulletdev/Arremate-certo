package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTSchema extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSchema.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctschema0e6atype");
  
  String getID();
  
  XmlString xgetID();
  
  void setID(String paramString);
  
  void xsetID(XmlString paramXmlString);
  
  String getSchemaRef();
  
  XmlString xgetSchemaRef();
  
  boolean isSetSchemaRef();
  
  void setSchemaRef(String paramString);
  
  void xsetSchemaRef(XmlString paramXmlString);
  
  void unsetSchemaRef();
  
  String getNamespace();
  
  XmlString xgetNamespace();
  
  boolean isSetNamespace();
  
  void setNamespace(String paramString);
  
  void xsetNamespace(XmlString paramXmlString);
  
  void unsetNamespace();
  
  public static final class Factory {
    public static CTSchema newInstance() {
      return (CTSchema)POIXMLTypeLoader.newInstance(CTSchema.type, null);
    }
    
    public static CTSchema newInstance(XmlOptions param1XmlOptions) {
      return (CTSchema)POIXMLTypeLoader.newInstance(CTSchema.type, param1XmlOptions);
    }
    
    public static CTSchema parse(String param1String) throws XmlException {
      return (CTSchema)POIXMLTypeLoader.parse(param1String, CTSchema.type, null);
    }
    
    public static CTSchema parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSchema)POIXMLTypeLoader.parse(param1String, CTSchema.type, param1XmlOptions);
    }
    
    public static CTSchema parse(File param1File) throws XmlException, IOException {
      return (CTSchema)POIXMLTypeLoader.parse(param1File, CTSchema.type, null);
    }
    
    public static CTSchema parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSchema)POIXMLTypeLoader.parse(param1File, CTSchema.type, param1XmlOptions);
    }
    
    public static CTSchema parse(URL param1URL) throws XmlException, IOException {
      return (CTSchema)POIXMLTypeLoader.parse(param1URL, CTSchema.type, null);
    }
    
    public static CTSchema parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSchema)POIXMLTypeLoader.parse(param1URL, CTSchema.type, param1XmlOptions);
    }
    
    public static CTSchema parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSchema)POIXMLTypeLoader.parse(param1InputStream, CTSchema.type, null);
    }
    
    public static CTSchema parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSchema)POIXMLTypeLoader.parse(param1InputStream, CTSchema.type, param1XmlOptions);
    }
    
    public static CTSchema parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSchema)POIXMLTypeLoader.parse(param1Reader, CTSchema.type, null);
    }
    
    public static CTSchema parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSchema)POIXMLTypeLoader.parse(param1Reader, CTSchema.type, param1XmlOptions);
    }
    
    public static CTSchema parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSchema)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSchema.type, null);
    }
    
    public static CTSchema parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSchema)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSchema.type, param1XmlOptions);
    }
    
    public static CTSchema parse(Node param1Node) throws XmlException {
      return (CTSchema)POIXMLTypeLoader.parse(param1Node, CTSchema.type, null);
    }
    
    public static CTSchema parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSchema)POIXMLTypeLoader.parse(param1Node, CTSchema.type, param1XmlOptions);
    }
    
    public static CTSchema parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSchema)POIXMLTypeLoader.parse(param1XMLInputStream, CTSchema.type, null);
    }
    
    public static CTSchema parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSchema)POIXMLTypeLoader.parse(param1XMLInputStream, CTSchema.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSchema.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSchema.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSchema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */