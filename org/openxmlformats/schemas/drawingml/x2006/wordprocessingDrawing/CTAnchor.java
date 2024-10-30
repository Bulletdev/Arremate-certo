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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.w3c.dom.Node;

public interface CTAnchor extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTAnchor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctanchorff8atype");
  
  CTPoint2D getSimplePos();
  
  void setSimplePos(CTPoint2D paramCTPoint2D);
  
  CTPoint2D addNewSimplePos();
  
  CTPosH getPositionH();
  
  void setPositionH(CTPosH paramCTPosH);
  
  CTPosH addNewPositionH();
  
  CTPosV getPositionV();
  
  void setPositionV(CTPosV paramCTPosV);
  
  CTPosV addNewPositionV();
  
  CTPositiveSize2D getExtent();
  
  void setExtent(CTPositiveSize2D paramCTPositiveSize2D);
  
  CTPositiveSize2D addNewExtent();
  
  CTEffectExtent getEffectExtent();
  
  boolean isSetEffectExtent();
  
  void setEffectExtent(CTEffectExtent paramCTEffectExtent);
  
  CTEffectExtent addNewEffectExtent();
  
  void unsetEffectExtent();
  
  CTWrapNone getWrapNone();
  
  boolean isSetWrapNone();
  
  void setWrapNone(CTWrapNone paramCTWrapNone);
  
  CTWrapNone addNewWrapNone();
  
  void unsetWrapNone();
  
  CTWrapSquare getWrapSquare();
  
  boolean isSetWrapSquare();
  
  void setWrapSquare(CTWrapSquare paramCTWrapSquare);
  
  CTWrapSquare addNewWrapSquare();
  
  void unsetWrapSquare();
  
  CTWrapTight getWrapTight();
  
  boolean isSetWrapTight();
  
  void setWrapTight(CTWrapTight paramCTWrapTight);
  
  CTWrapTight addNewWrapTight();
  
  void unsetWrapTight();
  
  CTWrapThrough getWrapThrough();
  
  boolean isSetWrapThrough();
  
  void setWrapThrough(CTWrapThrough paramCTWrapThrough);
  
  CTWrapThrough addNewWrapThrough();
  
  void unsetWrapThrough();
  
  CTWrapTopBottom getWrapTopAndBottom();
  
  boolean isSetWrapTopAndBottom();
  
  void setWrapTopAndBottom(CTWrapTopBottom paramCTWrapTopBottom);
  
  CTWrapTopBottom addNewWrapTopAndBottom();
  
  void unsetWrapTopAndBottom();
  
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
  
  boolean getSimplePos2();
  
  XmlBoolean xgetSimplePos2();
  
  boolean isSetSimplePos2();
  
  void setSimplePos2(boolean paramBoolean);
  
  void xsetSimplePos2(XmlBoolean paramXmlBoolean);
  
  void unsetSimplePos2();
  
  long getRelativeHeight();
  
  XmlUnsignedInt xgetRelativeHeight();
  
  void setRelativeHeight(long paramLong);
  
  void xsetRelativeHeight(XmlUnsignedInt paramXmlUnsignedInt);
  
  boolean getBehindDoc();
  
  XmlBoolean xgetBehindDoc();
  
  void setBehindDoc(boolean paramBoolean);
  
  void xsetBehindDoc(XmlBoolean paramXmlBoolean);
  
  boolean getLocked();
  
  XmlBoolean xgetLocked();
  
  void setLocked(boolean paramBoolean);
  
  void xsetLocked(XmlBoolean paramXmlBoolean);
  
  boolean getLayoutInCell();
  
  XmlBoolean xgetLayoutInCell();
  
  void setLayoutInCell(boolean paramBoolean);
  
  void xsetLayoutInCell(XmlBoolean paramXmlBoolean);
  
  boolean getHidden();
  
  XmlBoolean xgetHidden();
  
  boolean isSetHidden();
  
  void setHidden(boolean paramBoolean);
  
  void xsetHidden(XmlBoolean paramXmlBoolean);
  
  void unsetHidden();
  
  boolean getAllowOverlap();
  
  XmlBoolean xgetAllowOverlap();
  
  void setAllowOverlap(boolean paramBoolean);
  
  void xsetAllowOverlap(XmlBoolean paramXmlBoolean);
  
  public static final class Factory {
    public static CTAnchor newInstance() {
      return (CTAnchor)POIXMLTypeLoader.newInstance(CTAnchor.type, null);
    }
    
    public static CTAnchor newInstance(XmlOptions param1XmlOptions) {
      return (CTAnchor)POIXMLTypeLoader.newInstance(CTAnchor.type, param1XmlOptions);
    }
    
    public static CTAnchor parse(String param1String) throws XmlException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1String, CTAnchor.type, null);
    }
    
    public static CTAnchor parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1String, CTAnchor.type, param1XmlOptions);
    }
    
    public static CTAnchor parse(File param1File) throws XmlException, IOException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1File, CTAnchor.type, null);
    }
    
    public static CTAnchor parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1File, CTAnchor.type, param1XmlOptions);
    }
    
    public static CTAnchor parse(URL param1URL) throws XmlException, IOException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1URL, CTAnchor.type, null);
    }
    
    public static CTAnchor parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1URL, CTAnchor.type, param1XmlOptions);
    }
    
    public static CTAnchor parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1InputStream, CTAnchor.type, null);
    }
    
    public static CTAnchor parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1InputStream, CTAnchor.type, param1XmlOptions);
    }
    
    public static CTAnchor parse(Reader param1Reader) throws XmlException, IOException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1Reader, CTAnchor.type, null);
    }
    
    public static CTAnchor parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1Reader, CTAnchor.type, param1XmlOptions);
    }
    
    public static CTAnchor parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAnchor.type, null);
    }
    
    public static CTAnchor parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAnchor.type, param1XmlOptions);
    }
    
    public static CTAnchor parse(Node param1Node) throws XmlException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1Node, CTAnchor.type, null);
    }
    
    public static CTAnchor parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1Node, CTAnchor.type, param1XmlOptions);
    }
    
    public static CTAnchor parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1XMLInputStream, CTAnchor.type, null);
    }
    
    public static CTAnchor parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTAnchor)POIXMLTypeLoader.parse(param1XMLInputStream, CTAnchor.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAnchor.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAnchor.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\wordprocessingDrawing\CTAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */