package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.w3c.dom.Node;

public interface CTInline extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTInline.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctinline5726type");
  
  CTPositiveSize2D getExtent();
  
  void setExtent(CTPositiveSize2D paramCTPositiveSize2D);
  
  CTPositiveSize2D addNewExtent();
  
  CTEffectExtent getEffectExtent();
  
  boolean isSetEffectExtent();
  
  void setEffectExtent(CTEffectExtent paramCTEffectExtent);
  
  CTEffectExtent addNewEffectExtent();
  
  void unsetEffectExtent();
  
  CTNonVisualDrawingProps getDocPr();
  
  void setDocPr(CTNonVisualDrawingProps paramCTNonVisualDrawingProps);
  
  CTNonVisualDrawingProps addNewDocPr();
  
  CTNonVisualGraphicFrameProperties getCNvGraphicFramePr();
  
  boolean isSetCNvGraphicFramePr();
  
  void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties paramCTNonVisualGraphicFrameProperties);
  
  CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr();
  
  void unsetCNvGraphicFramePr();
  
  CTGraphicalObject getGraphic();
  
  void setGraphic(CTGraphicalObject paramCTGraphicalObject);
  
  CTGraphicalObject addNewGraphic();
  
  long getDistT();
  
  STWrapDistance xgetDistT();
  
  boolean isSetDistT();
  
  void setDistT(long paramLong);
  
  void xsetDistT(STWrapDistance paramSTWrapDistance);
  
  void unsetDistT();
  
  long getDistB();
  
  STWrapDistance xgetDistB();
  
  boolean isSetDistB();
  
  void setDistB(long paramLong);
  
  void xsetDistB(STWrapDistance paramSTWrapDistance);
  
  void unsetDistB();
  
  long getDistL();
  
  STWrapDistance xgetDistL();
  
  boolean isSetDistL();
  
  void setDistL(long paramLong);
  
  void xsetDistL(STWrapDistance paramSTWrapDistance);
  
  void unsetDistL();
  
  long getDistR();
  
  STWrapDistance xgetDistR();
  
  boolean isSetDistR();
  
  void setDistR(long paramLong);
  
  void xsetDistR(STWrapDistance paramSTWrapDistance);
  
  void unsetDistR();
  
  public static final class Factory {
    public static CTInline newInstance() {
      return (CTInline)POIXMLTypeLoader.newInstance(CTInline.type, null);
    }
    
    public static CTInline newInstance(XmlOptions param1XmlOptions) {
      return (CTInline)POIXMLTypeLoader.newInstance(CTInline.type, param1XmlOptions);
    }
    
    public static CTInline parse(String param1String) throws XmlException {
      return (CTInline)POIXMLTypeLoader.parse(param1String, CTInline.type, null);
    }
    
    public static CTInline parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTInline)POIXMLTypeLoader.parse(param1String, CTInline.type, param1XmlOptions);
    }
    
    public static CTInline parse(File param1File) throws XmlException, IOException {
      return (CTInline)POIXMLTypeLoader.parse(param1File, CTInline.type, null);
    }
    
    public static CTInline parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTInline)POIXMLTypeLoader.parse(param1File, CTInline.type, param1XmlOptions);
    }
    
    public static CTInline parse(URL param1URL) throws XmlException, IOException {
      return (CTInline)POIXMLTypeLoader.parse(param1URL, CTInline.type, null);
    }
    
    public static CTInline parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTInline)POIXMLTypeLoader.parse(param1URL, CTInline.type, param1XmlOptions);
    }
    
    public static CTInline parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTInline)POIXMLTypeLoader.parse(param1InputStream, CTInline.type, null);
    }
    
    public static CTInline parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTInline)POIXMLTypeLoader.parse(param1InputStream, CTInline.type, param1XmlOptions);
    }
    
    public static CTInline parse(Reader param1Reader) throws XmlException, IOException {
      return (CTInline)POIXMLTypeLoader.parse(param1Reader, CTInline.type, null);
    }
    
    public static CTInline parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTInline)POIXMLTypeLoader.parse(param1Reader, CTInline.type, param1XmlOptions);
    }
    
    public static CTInline parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTInline)POIXMLTypeLoader.parse(param1XMLStreamReader, CTInline.type, null);
    }
    
    public static CTInline parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTInline)POIXMLTypeLoader.parse(param1XMLStreamReader, CTInline.type, param1XmlOptions);
    }
    
    public static CTInline parse(Node param1Node) throws XmlException {
      return (CTInline)POIXMLTypeLoader.parse(param1Node, CTInline.type, null);
    }
    
    public static CTInline parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTInline)POIXMLTypeLoader.parse(param1Node, CTInline.type, param1XmlOptions);
    }
    
    public static CTInline parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTInline)POIXMLTypeLoader.parse(param1XMLInputStream, CTInline.type, null);
    }
    
    public static CTInline parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTInline)POIXMLTypeLoader.parse(param1XMLInputStream, CTInline.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTInline.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTInline.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\wordprocessingDrawing\CTInline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */