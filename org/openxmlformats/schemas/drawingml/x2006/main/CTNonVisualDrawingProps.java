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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTNonVisualDrawingProps extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNonVisualDrawingProps.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnonvisualdrawingprops8fb0type");
  
  CTHyperlink getHlinkClick();
  
  boolean isSetHlinkClick();
  
  void setHlinkClick(CTHyperlink paramCTHyperlink);
  
  CTHyperlink addNewHlinkClick();
  
  void unsetHlinkClick();
  
  CTHyperlink getHlinkHover();
  
  boolean isSetHlinkHover();
  
  void setHlinkHover(CTHyperlink paramCTHyperlink);
  
  CTHyperlink addNewHlinkHover();
  
  void unsetHlinkHover();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getId();
  
  STDrawingElementId xgetId();
  
  void setId(long paramLong);
  
  void xsetId(STDrawingElementId paramSTDrawingElementId);
  
  String getName();
  
  XmlString xgetName();
  
  void setName(String paramString);
  
  void xsetName(XmlString paramXmlString);
  
  String getDescr();
  
  XmlString xgetDescr();
  
  boolean isSetDescr();
  
  void setDescr(String paramString);
  
  void xsetDescr(XmlString paramXmlString);
  
  void unsetDescr();
  
  boolean getHidden();
  
  XmlBoolean xgetHidden();
  
  boolean isSetHidden();
  
  void setHidden(boolean paramBoolean);
  
  void xsetHidden(XmlBoolean paramXmlBoolean);
  
  void unsetHidden();
  
  public static final class Factory {
    public static CTNonVisualDrawingProps newInstance() {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.newInstance(CTNonVisualDrawingProps.type, null);
    }
    
    public static CTNonVisualDrawingProps newInstance(XmlOptions param1XmlOptions) {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.newInstance(CTNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingProps parse(String param1String) throws XmlException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1String, CTNonVisualDrawingProps.type, null);
    }
    
    public static CTNonVisualDrawingProps parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1String, CTNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingProps parse(File param1File) throws XmlException, IOException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1File, CTNonVisualDrawingProps.type, null);
    }
    
    public static CTNonVisualDrawingProps parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1File, CTNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingProps parse(URL param1URL) throws XmlException, IOException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1URL, CTNonVisualDrawingProps.type, null);
    }
    
    public static CTNonVisualDrawingProps parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1URL, CTNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingProps parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1InputStream, CTNonVisualDrawingProps.type, null);
    }
    
    public static CTNonVisualDrawingProps parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1InputStream, CTNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingProps parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1Reader, CTNonVisualDrawingProps.type, null);
    }
    
    public static CTNonVisualDrawingProps parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1Reader, CTNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingProps parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNonVisualDrawingProps.type, null);
    }
    
    public static CTNonVisualDrawingProps parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingProps parse(Node param1Node) throws XmlException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1Node, CTNonVisualDrawingProps.type, null);
    }
    
    public static CTNonVisualDrawingProps parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1Node, CTNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualDrawingProps parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1XMLInputStream, CTNonVisualDrawingProps.type, null);
    }
    
    public static CTNonVisualDrawingProps parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNonVisualDrawingProps)POIXMLTypeLoader.parse(param1XMLInputStream, CTNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNonVisualDrawingProps.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNonVisualDrawingProps.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTNonVisualDrawingProps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */