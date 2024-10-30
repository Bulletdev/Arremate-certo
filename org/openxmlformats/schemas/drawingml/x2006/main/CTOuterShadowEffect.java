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

public interface CTOuterShadowEffect extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTOuterShadowEffect.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctoutershadoweffect7b5dtype");
  
  CTScRgbColor getScrgbClr();
  
  boolean isSetScrgbClr();
  
  void setScrgbClr(CTScRgbColor paramCTScRgbColor);
  
  CTScRgbColor addNewScrgbClr();
  
  void unsetScrgbClr();
  
  CTSRgbColor getSrgbClr();
  
  boolean isSetSrgbClr();
  
  void setSrgbClr(CTSRgbColor paramCTSRgbColor);
  
  CTSRgbColor addNewSrgbClr();
  
  void unsetSrgbClr();
  
  CTHslColor getHslClr();
  
  boolean isSetHslClr();
  
  void setHslClr(CTHslColor paramCTHslColor);
  
  CTHslColor addNewHslClr();
  
  void unsetHslClr();
  
  CTSystemColor getSysClr();
  
  boolean isSetSysClr();
  
  void setSysClr(CTSystemColor paramCTSystemColor);
  
  CTSystemColor addNewSysClr();
  
  void unsetSysClr();
  
  CTSchemeColor getSchemeClr();
  
  boolean isSetSchemeClr();
  
  void setSchemeClr(CTSchemeColor paramCTSchemeColor);
  
  CTSchemeColor addNewSchemeClr();
  
  void unsetSchemeClr();
  
  CTPresetColor getPrstClr();
  
  boolean isSetPrstClr();
  
  void setPrstClr(CTPresetColor paramCTPresetColor);
  
  CTPresetColor addNewPrstClr();
  
  void unsetPrstClr();
  
  long getBlurRad();
  
  STPositiveCoordinate xgetBlurRad();
  
  boolean isSetBlurRad();
  
  void setBlurRad(long paramLong);
  
  void xsetBlurRad(STPositiveCoordinate paramSTPositiveCoordinate);
  
  void unsetBlurRad();
  
  long getDist();
  
  STPositiveCoordinate xgetDist();
  
  boolean isSetDist();
  
  void setDist(long paramLong);
  
  void xsetDist(STPositiveCoordinate paramSTPositiveCoordinate);
  
  void unsetDist();
  
  int getDir();
  
  STPositiveFixedAngle xgetDir();
  
  boolean isSetDir();
  
  void setDir(int paramInt);
  
  void xsetDir(STPositiveFixedAngle paramSTPositiveFixedAngle);
  
  void unsetDir();
  
  int getSx();
  
  STPercentage xgetSx();
  
  boolean isSetSx();
  
  void setSx(int paramInt);
  
  void xsetSx(STPercentage paramSTPercentage);
  
  void unsetSx();
  
  int getSy();
  
  STPercentage xgetSy();
  
  boolean isSetSy();
  
  void setSy(int paramInt);
  
  void xsetSy(STPercentage paramSTPercentage);
  
  void unsetSy();
  
  int getKx();
  
  STFixedAngle xgetKx();
  
  boolean isSetKx();
  
  void setKx(int paramInt);
  
  void xsetKx(STFixedAngle paramSTFixedAngle);
  
  void unsetKx();
  
  int getKy();
  
  STFixedAngle xgetKy();
  
  boolean isSetKy();
  
  void setKy(int paramInt);
  
  void xsetKy(STFixedAngle paramSTFixedAngle);
  
  void unsetKy();
  
  STRectAlignment$Enum getAlgn();
  
  STRectAlignment xgetAlgn();
  
  boolean isSetAlgn();
  
  void setAlgn(STRectAlignment$Enum paramSTRectAlignment$Enum);
  
  void xsetAlgn(STRectAlignment paramSTRectAlignment);
  
  void unsetAlgn();
  
  boolean getRotWithShape();
  
  XmlBoolean xgetRotWithShape();
  
  boolean isSetRotWithShape();
  
  void setRotWithShape(boolean paramBoolean);
  
  void xsetRotWithShape(XmlBoolean paramXmlBoolean);
  
  void unsetRotWithShape();
  
  public static final class Factory {
    public static CTOuterShadowEffect newInstance() {
      return (CTOuterShadowEffect)POIXMLTypeLoader.newInstance(CTOuterShadowEffect.type, null);
    }
    
    public static CTOuterShadowEffect newInstance(XmlOptions param1XmlOptions) {
      return (CTOuterShadowEffect)POIXMLTypeLoader.newInstance(CTOuterShadowEffect.type, param1XmlOptions);
    }
    
    public static CTOuterShadowEffect parse(String param1String) throws XmlException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1String, CTOuterShadowEffect.type, null);
    }
    
    public static CTOuterShadowEffect parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1String, CTOuterShadowEffect.type, param1XmlOptions);
    }
    
    public static CTOuterShadowEffect parse(File param1File) throws XmlException, IOException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1File, CTOuterShadowEffect.type, null);
    }
    
    public static CTOuterShadowEffect parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1File, CTOuterShadowEffect.type, param1XmlOptions);
    }
    
    public static CTOuterShadowEffect parse(URL param1URL) throws XmlException, IOException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1URL, CTOuterShadowEffect.type, null);
    }
    
    public static CTOuterShadowEffect parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1URL, CTOuterShadowEffect.type, param1XmlOptions);
    }
    
    public static CTOuterShadowEffect parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1InputStream, CTOuterShadowEffect.type, null);
    }
    
    public static CTOuterShadowEffect parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1InputStream, CTOuterShadowEffect.type, param1XmlOptions);
    }
    
    public static CTOuterShadowEffect parse(Reader param1Reader) throws XmlException, IOException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1Reader, CTOuterShadowEffect.type, null);
    }
    
    public static CTOuterShadowEffect parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1Reader, CTOuterShadowEffect.type, param1XmlOptions);
    }
    
    public static CTOuterShadowEffect parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOuterShadowEffect.type, null);
    }
    
    public static CTOuterShadowEffect parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOuterShadowEffect.type, param1XmlOptions);
    }
    
    public static CTOuterShadowEffect parse(Node param1Node) throws XmlException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1Node, CTOuterShadowEffect.type, null);
    }
    
    public static CTOuterShadowEffect parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1Node, CTOuterShadowEffect.type, param1XmlOptions);
    }
    
    public static CTOuterShadowEffect parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1XMLInputStream, CTOuterShadowEffect.type, null);
    }
    
    public static CTOuterShadowEffect parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTOuterShadowEffect)POIXMLTypeLoader.parse(param1XMLInputStream, CTOuterShadowEffect.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOuterShadowEffect.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOuterShadowEffect.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTOuterShadowEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */