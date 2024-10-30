package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.w3c.dom.Node;

public interface CTGraphicalObjectFrameNonVisual extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGraphicalObjectFrameNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgraphicalobjectframenonvisual257dtype");
  
  CTNonVisualDrawingProps getCNvPr();
  
  void setCNvPr(CTNonVisualDrawingProps paramCTNonVisualDrawingProps);
  
  CTNonVisualDrawingProps addNewCNvPr();
  
  CTNonVisualGraphicFrameProperties getCNvGraphicFramePr();
  
  void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties paramCTNonVisualGraphicFrameProperties);
  
  CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr();
  
  CTApplicationNonVisualDrawingProps getNvPr();
  
  void setNvPr(CTApplicationNonVisualDrawingProps paramCTApplicationNonVisualDrawingProps);
  
  CTApplicationNonVisualDrawingProps addNewNvPr();
  
  public static final class Factory {
    public static CTGraphicalObjectFrameNonVisual newInstance() {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.newInstance(CTGraphicalObjectFrameNonVisual.type, null);
    }
    
    public static CTGraphicalObjectFrameNonVisual newInstance(XmlOptions param1XmlOptions) {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.newInstance(CTGraphicalObjectFrameNonVisual.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(String param1String) throws XmlException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1String, CTGraphicalObjectFrameNonVisual.type, null);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1String, CTGraphicalObjectFrameNonVisual.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(File param1File) throws XmlException, IOException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1File, CTGraphicalObjectFrameNonVisual.type, null);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1File, CTGraphicalObjectFrameNonVisual.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(URL param1URL) throws XmlException, IOException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1URL, CTGraphicalObjectFrameNonVisual.type, null);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1URL, CTGraphicalObjectFrameNonVisual.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1InputStream, CTGraphicalObjectFrameNonVisual.type, null);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1InputStream, CTGraphicalObjectFrameNonVisual.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1Reader, CTGraphicalObjectFrameNonVisual.type, null);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1Reader, CTGraphicalObjectFrameNonVisual.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGraphicalObjectFrameNonVisual.type, null);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGraphicalObjectFrameNonVisual.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(Node param1Node) throws XmlException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1Node, CTGraphicalObjectFrameNonVisual.type, null);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1Node, CTGraphicalObjectFrameNonVisual.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1XMLInputStream, CTGraphicalObjectFrameNonVisual.type, null);
    }
    
    public static CTGraphicalObjectFrameNonVisual parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGraphicalObjectFrameNonVisual)POIXMLTypeLoader.parse(param1XMLInputStream, CTGraphicalObjectFrameNonVisual.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGraphicalObjectFrameNonVisual.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGraphicalObjectFrameNonVisual.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTGraphicalObjectFrameNonVisual.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */