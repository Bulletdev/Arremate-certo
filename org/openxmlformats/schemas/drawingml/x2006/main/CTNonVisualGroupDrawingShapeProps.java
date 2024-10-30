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

public interface CTNonVisualGroupDrawingShapeProps extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNonVisualGroupDrawingShapeProps.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnonvisualgroupdrawingshapeprops610ctype");
  
  CTGroupLocking getGrpSpLocks();
  
  boolean isSetGrpSpLocks();
  
  void setGrpSpLocks(CTGroupLocking paramCTGroupLocking);
  
  CTGroupLocking addNewGrpSpLocks();
  
  void unsetGrpSpLocks();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTNonVisualGroupDrawingShapeProps newInstance() {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.newInstance(CTNonVisualGroupDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualGroupDrawingShapeProps newInstance(XmlOptions param1XmlOptions) {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.newInstance(CTNonVisualGroupDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(String param1String) throws XmlException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1String, CTNonVisualGroupDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1String, CTNonVisualGroupDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(File param1File) throws XmlException, IOException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1File, CTNonVisualGroupDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1File, CTNonVisualGroupDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(URL param1URL) throws XmlException, IOException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1URL, CTNonVisualGroupDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1URL, CTNonVisualGroupDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1InputStream, CTNonVisualGroupDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1InputStream, CTNonVisualGroupDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1Reader, CTNonVisualGroupDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1Reader, CTNonVisualGroupDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNonVisualGroupDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNonVisualGroupDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(Node param1Node) throws XmlException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1Node, CTNonVisualGroupDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1Node, CTNonVisualGroupDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1XMLInputStream, CTNonVisualGroupDrawingShapeProps.type, null);
    }
    
    public static CTNonVisualGroupDrawingShapeProps parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNonVisualGroupDrawingShapeProps)POIXMLTypeLoader.parse(param1XMLInputStream, CTNonVisualGroupDrawingShapeProps.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNonVisualGroupDrawingShapeProps.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNonVisualGroupDrawingShapeProps.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTNonVisualGroupDrawingShapeProps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */