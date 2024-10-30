package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTOfficeArtExtensionList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTOfficeArtExtensionList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctofficeartextensionlista211type");
  
  List<CTOfficeArtExtension> getExtList();
  
  CTOfficeArtExtension[] getExtArray();
  
  CTOfficeArtExtension getExtArray(int paramInt);
  
  int sizeOfExtArray();
  
  void setExtArray(CTOfficeArtExtension[] paramArrayOfCTOfficeArtExtension);
  
  void setExtArray(int paramInt, CTOfficeArtExtension paramCTOfficeArtExtension);
  
  CTOfficeArtExtension insertNewExt(int paramInt);
  
  CTOfficeArtExtension addNewExt();
  
  void removeExt(int paramInt);
  
  public static final class Factory {
    public static CTOfficeArtExtensionList newInstance() {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.newInstance(CTOfficeArtExtensionList.type, null);
    }
    
    public static CTOfficeArtExtensionList newInstance(XmlOptions param1XmlOptions) {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.newInstance(CTOfficeArtExtensionList.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtensionList parse(String param1String) throws XmlException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1String, CTOfficeArtExtensionList.type, null);
    }
    
    public static CTOfficeArtExtensionList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1String, CTOfficeArtExtensionList.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtensionList parse(File param1File) throws XmlException, IOException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1File, CTOfficeArtExtensionList.type, null);
    }
    
    public static CTOfficeArtExtensionList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1File, CTOfficeArtExtensionList.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtensionList parse(URL param1URL) throws XmlException, IOException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1URL, CTOfficeArtExtensionList.type, null);
    }
    
    public static CTOfficeArtExtensionList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1URL, CTOfficeArtExtensionList.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtensionList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1InputStream, CTOfficeArtExtensionList.type, null);
    }
    
    public static CTOfficeArtExtensionList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1InputStream, CTOfficeArtExtensionList.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtensionList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1Reader, CTOfficeArtExtensionList.type, null);
    }
    
    public static CTOfficeArtExtensionList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1Reader, CTOfficeArtExtensionList.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtensionList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOfficeArtExtensionList.type, null);
    }
    
    public static CTOfficeArtExtensionList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOfficeArtExtensionList.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtensionList parse(Node param1Node) throws XmlException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1Node, CTOfficeArtExtensionList.type, null);
    }
    
    public static CTOfficeArtExtensionList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1Node, CTOfficeArtExtensionList.type, param1XmlOptions);
    }
    
    public static CTOfficeArtExtensionList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1XMLInputStream, CTOfficeArtExtensionList.type, null);
    }
    
    public static CTOfficeArtExtensionList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTOfficeArtExtensionList)POIXMLTypeLoader.parse(param1XMLInputStream, CTOfficeArtExtensionList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOfficeArtExtensionList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOfficeArtExtensionList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTOfficeArtExtensionList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */