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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTNonVisualGraphicFrameProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNonVisualGraphicFrameProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnonvisualgraphicframeproperties43b6type");
  
  CTGraphicalObjectFrameLocking getGraphicFrameLocks();
  
  boolean isSetGraphicFrameLocks();
  
  void setGraphicFrameLocks(CTGraphicalObjectFrameLocking paramCTGraphicalObjectFrameLocking);
  
  CTGraphicalObjectFrameLocking addNewGraphicFrameLocks();
  
  void unsetGraphicFrameLocks();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTNonVisualGraphicFrameProperties newInstance() {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.newInstance(CTNonVisualGraphicFrameProperties.type, null);
    }
    
    public static CTNonVisualGraphicFrameProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.newInstance(CTNonVisualGraphicFrameProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(String param1String) throws XmlException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1String, CTNonVisualGraphicFrameProperties.type, null);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1String, CTNonVisualGraphicFrameProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(File param1File) throws XmlException, IOException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1File, CTNonVisualGraphicFrameProperties.type, null);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1File, CTNonVisualGraphicFrameProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1URL, CTNonVisualGraphicFrameProperties.type, null);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1URL, CTNonVisualGraphicFrameProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1InputStream, CTNonVisualGraphicFrameProperties.type, null);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1InputStream, CTNonVisualGraphicFrameProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1Reader, CTNonVisualGraphicFrameProperties.type, null);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1Reader, CTNonVisualGraphicFrameProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNonVisualGraphicFrameProperties.type, null);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNonVisualGraphicFrameProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(Node param1Node) throws XmlException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1Node, CTNonVisualGraphicFrameProperties.type, null);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1Node, CTNonVisualGraphicFrameProperties.type, param1XmlOptions);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTNonVisualGraphicFrameProperties.type, null);
    }
    
    public static CTNonVisualGraphicFrameProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNonVisualGraphicFrameProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTNonVisualGraphicFrameProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNonVisualGraphicFrameProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNonVisualGraphicFrameProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTNonVisualGraphicFrameProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */