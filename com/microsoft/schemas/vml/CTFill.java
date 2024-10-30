package com.microsoft.schemas.vml;

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

public interface CTFill extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFill.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfillb241type");
  
  com.microsoft.schemas.office.office.CTFill getFill();
  
  boolean isSetFill();
  
  void setFill(com.microsoft.schemas.office.office.CTFill paramCTFill);
  
  com.microsoft.schemas.office.office.CTFill addNewFill();
  
  void unsetFill();
  
  String getId();
  
  XmlString xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlString paramXmlString);
  
  void unsetId();
  
  STFillType$Enum getType();
  
  STFillType xgetType();
  
  boolean isSetType();
  
  void setType(STFillType$Enum paramSTFillType$Enum);
  
  void xsetType(STFillType paramSTFillType);
  
  void unsetType();
  
  STTrueFalse.Enum getOn();
  
  STTrueFalse xgetOn();
  
  boolean isSetOn();
  
  void setOn(STTrueFalse.Enum paramEnum);
  
  void xsetOn(STTrueFalse paramSTTrueFalse);
  
  void unsetOn();
  
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
  
  String getColor2();
  
  STColorType xgetColor2();
  
  boolean isSetColor2();
  
  void setColor2(String paramString);
  
  void xsetColor2(STColorType paramSTColorType);
  
  void unsetColor2();
  
  String getSrc();
  
  XmlString xgetSrc();
  
  boolean isSetSrc();
  
  void setSrc(String paramString);
  
  void xsetSrc(XmlString paramXmlString);
  
  void unsetSrc();
  
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
  
  String getSize();
  
  XmlString xgetSize();
  
  boolean isSetSize();
  
  void setSize(String paramString);
  
  void xsetSize(XmlString paramXmlString);
  
  void unsetSize();
  
  String getOrigin();
  
  XmlString xgetOrigin();
  
  boolean isSetOrigin();
  
  void setOrigin(String paramString);
  
  void xsetOrigin(XmlString paramXmlString);
  
  void unsetOrigin();
  
  String getPosition();
  
  XmlString xgetPosition();
  
  boolean isSetPosition();
  
  void setPosition(String paramString);
  
  void xsetPosition(XmlString paramXmlString);
  
  void unsetPosition();
  
  STImageAspect$Enum getAspect();
  
  STImageAspect xgetAspect();
  
  boolean isSetAspect();
  
  void setAspect(STImageAspect$Enum paramSTImageAspect$Enum);
  
  void xsetAspect(STImageAspect paramSTImageAspect);
  
  void unsetAspect();
  
  String getColors();
  
  XmlString xgetColors();
  
  boolean isSetColors();
  
  void setColors(String paramString);
  
  void xsetColors(XmlString paramXmlString);
  
  void unsetColors();
  
  BigDecimal getAngle();
  
  XmlDecimal xgetAngle();
  
  boolean isSetAngle();
  
  void setAngle(BigDecimal paramBigDecimal);
  
  void xsetAngle(XmlDecimal paramXmlDecimal);
  
  void unsetAngle();
  
  STTrueFalse.Enum getAlignshape();
  
  STTrueFalse xgetAlignshape();
  
  boolean isSetAlignshape();
  
  void setAlignshape(STTrueFalse.Enum paramEnum);
  
  void xsetAlignshape(STTrueFalse paramSTTrueFalse);
  
  void unsetAlignshape();
  
  String getFocus();
  
  XmlString xgetFocus();
  
  boolean isSetFocus();
  
  void setFocus(String paramString);
  
  void xsetFocus(XmlString paramXmlString);
  
  void unsetFocus();
  
  String getFocussize();
  
  XmlString xgetFocussize();
  
  boolean isSetFocussize();
  
  void setFocussize(String paramString);
  
  void xsetFocussize(XmlString paramXmlString);
  
  void unsetFocussize();
  
  String getFocusposition();
  
  XmlString xgetFocusposition();
  
  boolean isSetFocusposition();
  
  void setFocusposition(String paramString);
  
  void xsetFocusposition(XmlString paramXmlString);
  
  void unsetFocusposition();
  
  STFillMethod$Enum getMethod();
  
  STFillMethod xgetMethod();
  
  boolean isSetMethod();
  
  void setMethod(STFillMethod$Enum paramSTFillMethod$Enum);
  
  void xsetMethod(STFillMethod paramSTFillMethod);
  
  void unsetMethod();
  
  STTrueFalse.Enum getDetectmouseclick();
  
  STTrueFalse xgetDetectmouseclick();
  
  boolean isSetDetectmouseclick();
  
  void setDetectmouseclick(STTrueFalse.Enum paramEnum);
  
  void xsetDetectmouseclick(STTrueFalse paramSTTrueFalse);
  
  void unsetDetectmouseclick();
  
  String getTitle();
  
  XmlString xgetTitle();
  
  boolean isSetTitle();
  
  void setTitle(String paramString);
  
  void xsetTitle(XmlString paramXmlString);
  
  void unsetTitle();
  
  String getOpacity2();
  
  XmlString xgetOpacity2();
  
  boolean isSetOpacity2();
  
  void setOpacity2(String paramString);
  
  void xsetOpacity2(XmlString paramXmlString);
  
  void unsetOpacity2();
  
  STTrueFalse.Enum getRecolor();
  
  STTrueFalse xgetRecolor();
  
  boolean isSetRecolor();
  
  void setRecolor(STTrueFalse.Enum paramEnum);
  
  void xsetRecolor(STTrueFalse paramSTTrueFalse);
  
  void unsetRecolor();
  
  STTrueFalse.Enum getRotate();
  
  STTrueFalse xgetRotate();
  
  boolean isSetRotate();
  
  void setRotate(STTrueFalse.Enum paramEnum);
  
  void xsetRotate(STTrueFalse paramSTTrueFalse);
  
  void unsetRotate();
  
  String getId2();
  
  STRelationshipId xgetId2();
  
  boolean isSetId2();
  
  void setId2(String paramString);
  
  void xsetId2(STRelationshipId paramSTRelationshipId);
  
  void unsetId2();
  
  String getRelid();
  
  STRelationshipId xgetRelid();
  
  boolean isSetRelid();
  
  void setRelid(String paramString);
  
  void xsetRelid(STRelationshipId paramSTRelationshipId);
  
  void unsetRelid();
  
  public static final class Factory {
    public static CTFill newInstance() {
      return (CTFill)POIXMLTypeLoader.newInstance(CTFill.type, null);
    }
    
    public static CTFill newInstance(XmlOptions param1XmlOptions) {
      return (CTFill)POIXMLTypeLoader.newInstance(CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(String param1String) throws XmlException {
      return (CTFill)POIXMLTypeLoader.parse(param1String, CTFill.type, null);
    }
    
    public static CTFill parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFill)POIXMLTypeLoader.parse(param1String, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(File param1File) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1File, CTFill.type, null);
    }
    
    public static CTFill parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1File, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(URL param1URL) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1URL, CTFill.type, null);
    }
    
    public static CTFill parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1URL, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1InputStream, CTFill.type, null);
    }
    
    public static CTFill parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1InputStream, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1Reader, CTFill.type, null);
    }
    
    public static CTFill parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFill)POIXMLTypeLoader.parse(param1Reader, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFill)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFill.type, null);
    }
    
    public static CTFill parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFill)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(Node param1Node) throws XmlException {
      return (CTFill)POIXMLTypeLoader.parse(param1Node, CTFill.type, null);
    }
    
    public static CTFill parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFill)POIXMLTypeLoader.parse(param1Node, CTFill.type, param1XmlOptions);
    }
    
    public static CTFill parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFill)POIXMLTypeLoader.parse(param1XMLInputStream, CTFill.type, null);
    }
    
    public static CTFill parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFill)POIXMLTypeLoader.parse(param1XMLInputStream, CTFill.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFill.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFill.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\CTFill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */