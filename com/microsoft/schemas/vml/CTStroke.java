package com.microsoft.schemas.vml;

import com.microsoft.schemas.office.office.CTStrokeChild;
import com.microsoft.schemas.office.office.STRelationshipId;
import com.microsoft.schemas.office.office.STTrueFalse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

public interface CTStroke extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTStroke.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstrokee2f6type");
  
  CTStrokeChild getLeft();
  
  boolean isSetLeft();
  
  void setLeft(CTStrokeChild paramCTStrokeChild);
  
  CTStrokeChild addNewLeft();
  
  void unsetLeft();
  
  CTStrokeChild getTop();
  
  boolean isSetTop();
  
  void setTop(CTStrokeChild paramCTStrokeChild);
  
  CTStrokeChild addNewTop();
  
  void unsetTop();
  
  CTStrokeChild getRight();
  
  boolean isSetRight();
  
  void setRight(CTStrokeChild paramCTStrokeChild);
  
  CTStrokeChild addNewRight();
  
  void unsetRight();
  
  CTStrokeChild getBottom();
  
  boolean isSetBottom();
  
  void setBottom(CTStrokeChild paramCTStrokeChild);
  
  CTStrokeChild addNewBottom();
  
  void unsetBottom();
  
  CTStrokeChild getColumn();
  
  boolean isSetColumn();
  
  void setColumn(CTStrokeChild paramCTStrokeChild);
  
  CTStrokeChild addNewColumn();
  
  void unsetColumn();
  
  String getId();
  
  XmlString xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlString paramXmlString);
  
  void unsetId();
  
  STTrueFalse.Enum getOn();
  
  STTrueFalse xgetOn();
  
  boolean isSetOn();
  
  void setOn(STTrueFalse.Enum paramEnum);
  
  void xsetOn(STTrueFalse paramSTTrueFalse);
  
  void unsetOn();
  
  String getWeight();
  
  XmlString xgetWeight();
  
  boolean isSetWeight();
  
  void setWeight(String paramString);
  
  void xsetWeight(XmlString paramXmlString);
  
  void unsetWeight();
  
  String getColor();
  
  STColorType xgetColor();
  
  boolean isSetColor();
  
  void setColor(String paramString);
  
  void xsetColor(STColorType paramSTColorType);
  
  void unsetColor();
  
  String getOpacity();
  
  XmlString xgetOpacity();
  
  boolean isSetOpacity();
  
  void setOpacity(String paramString);
  
  void xsetOpacity(XmlString paramXmlString);
  
  void unsetOpacity();
  
  STStrokeLineStyle$Enum getLinestyle();
  
  STStrokeLineStyle xgetLinestyle();
  
  boolean isSetLinestyle();
  
  void setLinestyle(STStrokeLineStyle$Enum paramSTStrokeLineStyle$Enum);
  
  void xsetLinestyle(STStrokeLineStyle paramSTStrokeLineStyle);
  
  void unsetLinestyle();
  
  BigDecimal getMiterlimit();
  
  XmlDecimal xgetMiterlimit();
  
  boolean isSetMiterlimit();
  
  void setMiterlimit(BigDecimal paramBigDecimal);
  
  void xsetMiterlimit(XmlDecimal paramXmlDecimal);
  
  void unsetMiterlimit();
  
  STStrokeJoinStyle.Enum getJoinstyle();
  
  STStrokeJoinStyle xgetJoinstyle();
  
  boolean isSetJoinstyle();
  
  void setJoinstyle(STStrokeJoinStyle.Enum paramEnum);
  
  void xsetJoinstyle(STStrokeJoinStyle paramSTStrokeJoinStyle);
  
  void unsetJoinstyle();
  
  STStrokeEndCap$Enum getEndcap();
  
  STStrokeEndCap xgetEndcap();
  
  boolean isSetEndcap();
  
  void setEndcap(STStrokeEndCap$Enum paramSTStrokeEndCap$Enum);
  
  void xsetEndcap(STStrokeEndCap paramSTStrokeEndCap);
  
  void unsetEndcap();
  
  String getDashstyle();
  
  XmlString xgetDashstyle();
  
  boolean isSetDashstyle();
  
  void setDashstyle(String paramString);
  
  void xsetDashstyle(XmlString paramXmlString);
  
  void unsetDashstyle();
  
  STFillType$Enum getFilltype();
  
  STFillType xgetFilltype();
  
  boolean isSetFilltype();
  
  void setFilltype(STFillType$Enum paramSTFillType$Enum);
  
  void xsetFilltype(STFillType paramSTFillType);
  
  void unsetFilltype();
  
  String getSrc();
  
  XmlString xgetSrc();
  
  boolean isSetSrc();
  
  void setSrc(String paramString);
  
  void xsetSrc(XmlString paramXmlString);
  
  void unsetSrc();
  
  STImageAspect$Enum getImageaspect();
  
  STImageAspect xgetImageaspect();
  
  boolean isSetImageaspect();
  
  void setImageaspect(STImageAspect$Enum paramSTImageAspect$Enum);
  
  void xsetImageaspect(STImageAspect paramSTImageAspect);
  
  void unsetImageaspect();
  
  String getImagesize();
  
  XmlString xgetImagesize();
  
  boolean isSetImagesize();
  
  void setImagesize(String paramString);
  
  void xsetImagesize(XmlString paramXmlString);
  
  void unsetImagesize();
  
  STTrueFalse.Enum getImagealignshape();
  
  STTrueFalse xgetImagealignshape();
  
  boolean isSetImagealignshape();
  
  void setImagealignshape(STTrueFalse.Enum paramEnum);
  
  void xsetImagealignshape(STTrueFalse paramSTTrueFalse);
  
  void unsetImagealignshape();
  
  String getColor2();
  
  STColorType xgetColor2();
  
  boolean isSetColor2();
  
  void setColor2(String paramString);
  
  void xsetColor2(STColorType paramSTColorType);
  
  void unsetColor2();
  
  STStrokeArrowType$Enum getStartarrow();
  
  STStrokeArrowType xgetStartarrow();
  
  boolean isSetStartarrow();
  
  void setStartarrow(STStrokeArrowType$Enum paramSTStrokeArrowType$Enum);
  
  void xsetStartarrow(STStrokeArrowType paramSTStrokeArrowType);
  
  void unsetStartarrow();
  
  STStrokeArrowWidth$Enum getStartarrowwidth();
  
  STStrokeArrowWidth xgetStartarrowwidth();
  
  boolean isSetStartarrowwidth();
  
  void setStartarrowwidth(STStrokeArrowWidth$Enum paramSTStrokeArrowWidth$Enum);
  
  void xsetStartarrowwidth(STStrokeArrowWidth paramSTStrokeArrowWidth);
  
  void unsetStartarrowwidth();
  
  STStrokeArrowLength$Enum getStartarrowlength();
  
  STStrokeArrowLength xgetStartarrowlength();
  
  boolean isSetStartarrowlength();
  
  void setStartarrowlength(STStrokeArrowLength$Enum paramSTStrokeArrowLength$Enum);
  
  void xsetStartarrowlength(STStrokeArrowLength paramSTStrokeArrowLength);
  
  void unsetStartarrowlength();
  
  STStrokeArrowType$Enum getEndarrow();
  
  STStrokeArrowType xgetEndarrow();
  
  boolean isSetEndarrow();
  
  void setEndarrow(STStrokeArrowType$Enum paramSTStrokeArrowType$Enum);
  
  void xsetEndarrow(STStrokeArrowType paramSTStrokeArrowType);
  
  void unsetEndarrow();
  
  STStrokeArrowWidth$Enum getEndarrowwidth();
  
  STStrokeArrowWidth xgetEndarrowwidth();
  
  boolean isSetEndarrowwidth();
  
  void setEndarrowwidth(STStrokeArrowWidth$Enum paramSTStrokeArrowWidth$Enum);
  
  void xsetEndarrowwidth(STStrokeArrowWidth paramSTStrokeArrowWidth);
  
  void unsetEndarrowwidth();
  
  STStrokeArrowLength$Enum getEndarrowlength();
  
  STStrokeArrowLength xgetEndarrowlength();
  
  boolean isSetEndarrowlength();
  
  void setEndarrowlength(STStrokeArrowLength$Enum paramSTStrokeArrowLength$Enum);
  
  void xsetEndarrowlength(STStrokeArrowLength paramSTStrokeArrowLength);
  
  void unsetEndarrowlength();
  
  String getHref();
  
  XmlString xgetHref();
  
  boolean isSetHref();
  
  void setHref(String paramString);
  
  void xsetHref(XmlString paramXmlString);
  
  void unsetHref();
  
  String getAlthref();
  
  XmlString xgetAlthref();
  
  boolean isSetAlthref();
  
  void setAlthref(String paramString);
  
  void xsetAlthref(XmlString paramXmlString);
  
  void unsetAlthref();
  
  String getTitle();
  
  XmlString xgetTitle();
  
  boolean isSetTitle();
  
  void setTitle(String paramString);
  
  void xsetTitle(XmlString paramXmlString);
  
  void unsetTitle();
  
  STTrueFalse.Enum getForcedash();
  
  STTrueFalse xgetForcedash();
  
  boolean isSetForcedash();
  
  void setForcedash(STTrueFalse.Enum paramEnum);
  
  void xsetForcedash(STTrueFalse paramSTTrueFalse);
  
  void unsetForcedash();
  
  String getId2();
  
  STRelationshipId xgetId2();
  
  boolean isSetId2();
  
  void setId2(String paramString);
  
  void xsetId2(STRelationshipId paramSTRelationshipId);
  
  void unsetId2();
  
  STTrueFalse.Enum getInsetpen();
  
  STTrueFalse xgetInsetpen();
  
  boolean isSetInsetpen();
  
  void setInsetpen(STTrueFalse.Enum paramEnum);
  
  void xsetInsetpen(STTrueFalse paramSTTrueFalse);
  
  void unsetInsetpen();
  
  String getRelid();
  
  STRelationshipId xgetRelid();
  
  boolean isSetRelid();
  
  void setRelid(String paramString);
  
  void xsetRelid(STRelationshipId paramSTRelationshipId);
  
  void unsetRelid();
  
  public static final class Factory {
    public static CTStroke newInstance() {
      return (CTStroke)POIXMLTypeLoader.newInstance(CTStroke.type, null);
    }
    
    public static CTStroke newInstance(XmlOptions param1XmlOptions) {
      return (CTStroke)POIXMLTypeLoader.newInstance(CTStroke.type, param1XmlOptions);
    }
    
    public static CTStroke parse(String param1String) throws XmlException {
      return (CTStroke)POIXMLTypeLoader.parse(param1String, CTStroke.type, null);
    }
    
    public static CTStroke parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStroke)POIXMLTypeLoader.parse(param1String, CTStroke.type, param1XmlOptions);
    }
    
    public static CTStroke parse(File param1File) throws XmlException, IOException {
      return (CTStroke)POIXMLTypeLoader.parse(param1File, CTStroke.type, null);
    }
    
    public static CTStroke parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStroke)POIXMLTypeLoader.parse(param1File, CTStroke.type, param1XmlOptions);
    }
    
    public static CTStroke parse(URL param1URL) throws XmlException, IOException {
      return (CTStroke)POIXMLTypeLoader.parse(param1URL, CTStroke.type, null);
    }
    
    public static CTStroke parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStroke)POIXMLTypeLoader.parse(param1URL, CTStroke.type, param1XmlOptions);
    }
    
    public static CTStroke parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTStroke)POIXMLTypeLoader.parse(param1InputStream, CTStroke.type, null);
    }
    
    public static CTStroke parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStroke)POIXMLTypeLoader.parse(param1InputStream, CTStroke.type, param1XmlOptions);
    }
    
    public static CTStroke parse(Reader param1Reader) throws XmlException, IOException {
      return (CTStroke)POIXMLTypeLoader.parse(param1Reader, CTStroke.type, null);
    }
    
    public static CTStroke parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStroke)POIXMLTypeLoader.parse(param1Reader, CTStroke.type, param1XmlOptions);
    }
    
    public static CTStroke parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTStroke)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStroke.type, null);
    }
    
    public static CTStroke parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStroke)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStroke.type, param1XmlOptions);
    }
    
    public static CTStroke parse(Node param1Node) throws XmlException {
      return (CTStroke)POIXMLTypeLoader.parse(param1Node, CTStroke.type, null);
    }
    
    public static CTStroke parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStroke)POIXMLTypeLoader.parse(param1Node, CTStroke.type, param1XmlOptions);
    }
    
    public static CTStroke parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTStroke)POIXMLTypeLoader.parse(param1XMLInputStream, CTStroke.type, null);
    }
    
    public static CTStroke parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTStroke)POIXMLTypeLoader.parse(param1XMLInputStream, CTStroke.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStroke.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStroke.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\CTStroke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */