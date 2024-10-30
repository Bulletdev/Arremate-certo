package com.microsoft.schemas.office.x2006.digsig;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface SignatureInfoV1Document extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(SignatureInfoV1Document.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("signatureinfov14a6bdoctype");
  
  CTSignatureInfoV1 getSignatureInfoV1();
  
  void setSignatureInfoV1(CTSignatureInfoV1 paramCTSignatureInfoV1);
  
  CTSignatureInfoV1 addNewSignatureInfoV1();
  
  public static final class Factory {
    public static SignatureInfoV1Document newInstance() {
      return (SignatureInfoV1Document)POIXMLTypeLoader.newInstance(SignatureInfoV1Document.type, null);
    }
    
    public static SignatureInfoV1Document newInstance(XmlOptions param1XmlOptions) {
      return (SignatureInfoV1Document)POIXMLTypeLoader.newInstance(SignatureInfoV1Document.type, param1XmlOptions);
    }
    
    public static SignatureInfoV1Document parse(String param1String) throws XmlException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1String, SignatureInfoV1Document.type, null);
    }
    
    public static SignatureInfoV1Document parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1String, SignatureInfoV1Document.type, param1XmlOptions);
    }
    
    public static SignatureInfoV1Document parse(File param1File) throws XmlException, IOException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1File, SignatureInfoV1Document.type, null);
    }
    
    public static SignatureInfoV1Document parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1File, SignatureInfoV1Document.type, param1XmlOptions);
    }
    
    public static SignatureInfoV1Document parse(URL param1URL) throws XmlException, IOException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1URL, SignatureInfoV1Document.type, null);
    }
    
    public static SignatureInfoV1Document parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1URL, SignatureInfoV1Document.type, param1XmlOptions);
    }
    
    public static SignatureInfoV1Document parse(InputStream param1InputStream) throws XmlException, IOException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1InputStream, SignatureInfoV1Document.type, null);
    }
    
    public static SignatureInfoV1Document parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1InputStream, SignatureInfoV1Document.type, param1XmlOptions);
    }
    
    public static SignatureInfoV1Document parse(Reader param1Reader) throws XmlException, IOException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1Reader, SignatureInfoV1Document.type, null);
    }
    
    public static SignatureInfoV1Document parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1Reader, SignatureInfoV1Document.type, param1XmlOptions);
    }
    
    public static SignatureInfoV1Document parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1XMLStreamReader, SignatureInfoV1Document.type, null);
    }
    
    public static SignatureInfoV1Document parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1XMLStreamReader, SignatureInfoV1Document.type, param1XmlOptions);
    }
    
    public static SignatureInfoV1Document parse(Node param1Node) throws XmlException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1Node, SignatureInfoV1Document.type, null);
    }
    
    public static SignatureInfoV1Document parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1Node, SignatureInfoV1Document.type, param1XmlOptions);
    }
    
    public static SignatureInfoV1Document parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1XMLInputStream, SignatureInfoV1Document.type, null);
    }
    
    public static SignatureInfoV1Document parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (SignatureInfoV1Document)POIXMLTypeLoader.parse(param1XMLInputStream, SignatureInfoV1Document.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SignatureInfoV1Document.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SignatureInfoV1Document.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\digsig\SignatureInfoV1Document.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */