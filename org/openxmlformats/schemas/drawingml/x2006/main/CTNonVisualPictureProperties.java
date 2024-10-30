package org.openxmlformats.schemas.drawingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTNonVisualPictureProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNonVisualPictureProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnonvisualpicturepropertiesee3ftype");
  
  CTPictureLocking getPicLocks();
  
  boolean isSetPicLocks();
  
  void setPicLocks(CTPictureLocking paramCTPictureLocking);
  
  CTPictureLocking addNewPicLocks();
  
  void unsetPicLocks();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  boolean getPreferRelativeResize();
  
  XmlBoolean xgetPreferRelativeResize();
  
  boolean isSetPreferRelativeResize();
  
  void setPreferRelativeResize(boolean paramBoolean);
  
  void xsetPreferRelativeResize(XmlBoolean paramXmlBoolean);
  
  void unsetPreferRelativeResize();
  
  public static final class Factory {
    public static CTNonVisualPictureProperties newInstance() {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.newInstance(CTNonVisualPictureProperties.type, null);
    }
    
    public static CTNonVisualPictureProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.newInstance(CTNonVisualPictureProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualPictureProperties parse(String param1String) throws XmlException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1String, CTNonVisualPictureProperties.type, null);
    }
    
    public static CTNonVisualPictureProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1String, CTNonVisualPictureProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualPictureProperties parse(File param1File) throws XmlException, IOException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1File, CTNonVisualPictureProperties.type, null);
    }
    
    public static CTNonVisualPictureProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1File, CTNonVisualPictureProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualPictureProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1URL, CTNonVisualPictureProperties.type, null);
    }
    
    public static CTNonVisualPictureProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1URL, CTNonVisualPictureProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualPictureProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1InputStream, CTNonVisualPictureProperties.type, null);
    }
    
    public static CTNonVisualPictureProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1InputStream, CTNonVisualPictureProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualPictureProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1Reader, CTNonVisualPictureProperties.type, null);
    }
    
    public static CTNonVisualPictureProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1Reader, CTNonVisualPictureProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualPictureProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNonVisualPictureProperties.type, null);
    }
    
    public static CTNonVisualPictureProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNonVisualPictureProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualPictureProperties parse(Node param1Node) throws XmlException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1Node, CTNonVisualPictureProperties.type, null);
    }
    
    public static CTNonVisualPictureProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1Node, CTNonVisualPictureProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualPictureProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTNonVisualPictureProperties.type, null);
    }
    
    public static CTNonVisualPictureProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNonVisualPictureProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTNonVisualPictureProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNonVisualPictureProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNonVisualPictureProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTNonVisualPictureProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */