package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTExternalReferences extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTExternalReferences.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctexternalreferencesd77ctype");
  
  List<CTExternalReference> getExternalReferenceList();
  
  CTExternalReference[] getExternalReferenceArray();
  
  CTExternalReference getExternalReferenceArray(int paramInt);
  
  int sizeOfExternalReferenceArray();
  
  void setExternalReferenceArray(CTExternalReference[] paramArrayOfCTExternalReference);
  
  void setExternalReferenceArray(int paramInt, CTExternalReference paramCTExternalReference);
  
  CTExternalReference insertNewExternalReference(int paramInt);
  
  CTExternalReference addNewExternalReference();
  
  void removeExternalReference(int paramInt);
  
  public static final class Factory {
    public static CTExternalReferences newInstance() {
      return (CTExternalReferences)POIXMLTypeLoader.newInstance(CTExternalReferences.type, null);
    }
    
    public static CTExternalReferences newInstance(XmlOptions param1XmlOptions) {
      return (CTExternalReferences)POIXMLTypeLoader.newInstance(CTExternalReferences.type, param1XmlOptions);
    }
    
    public static CTExternalReferences parse(String param1String) throws XmlException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1String, CTExternalReferences.type, null);
    }
    
    public static CTExternalReferences parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1String, CTExternalReferences.type, param1XmlOptions);
    }
    
    public static CTExternalReferences parse(File param1File) throws XmlException, IOException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1File, CTExternalReferences.type, null);
    }
    
    public static CTExternalReferences parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1File, CTExternalReferences.type, param1XmlOptions);
    }
    
    public static CTExternalReferences parse(URL param1URL) throws XmlException, IOException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1URL, CTExternalReferences.type, null);
    }
    
    public static CTExternalReferences parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1URL, CTExternalReferences.type, param1XmlOptions);
    }
    
    public static CTExternalReferences parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1InputStream, CTExternalReferences.type, null);
    }
    
    public static CTExternalReferences parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1InputStream, CTExternalReferences.type, param1XmlOptions);
    }
    
    public static CTExternalReferences parse(Reader param1Reader) throws XmlException, IOException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1Reader, CTExternalReferences.type, null);
    }
    
    public static CTExternalReferences parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1Reader, CTExternalReferences.type, param1XmlOptions);
    }
    
    public static CTExternalReferences parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1XMLStreamReader, CTExternalReferences.type, null);
    }
    
    public static CTExternalReferences parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1XMLStreamReader, CTExternalReferences.type, param1XmlOptions);
    }
    
    public static CTExternalReferences parse(Node param1Node) throws XmlException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1Node, CTExternalReferences.type, null);
    }
    
    public static CTExternalReferences parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1Node, CTExternalReferences.type, param1XmlOptions);
    }
    
    public static CTExternalReferences parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1XMLInputStream, CTExternalReferences.type, null);
    }
    
    public static CTExternalReferences parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTExternalReferences)POIXMLTypeLoader.parse(param1XMLInputStream, CTExternalReferences.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTExternalReferences.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTExternalReferences.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTExternalReferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */