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

public interface CTTableProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttableproperties3512type");
  
  CTNoFillProperties getNoFill();
  
  boolean isSetNoFill();
  
  void setNoFill(CTNoFillProperties paramCTNoFillProperties);
  
  CTNoFillProperties addNewNoFill();
  
  void unsetNoFill();
  
  CTSolidColorFillProperties getSolidFill();
  
  boolean isSetSolidFill();
  
  void setSolidFill(CTSolidColorFillProperties paramCTSolidColorFillProperties);
  
  CTSolidColorFillProperties addNewSolidFill();
  
  void unsetSolidFill();
  
  CTGradientFillProperties getGradFill();
  
  boolean isSetGradFill();
  
  void setGradFill(CTGradientFillProperties paramCTGradientFillProperties);
  
  CTGradientFillProperties addNewGradFill();
  
  void unsetGradFill();
  
  CTBlipFillProperties getBlipFill();
  
  boolean isSetBlipFill();
  
  void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties);
  
  CTBlipFillProperties addNewBlipFill();
  
  void unsetBlipFill();
  
  CTPatternFillProperties getPattFill();
  
  boolean isSetPattFill();
  
  void setPattFill(CTPatternFillProperties paramCTPatternFillProperties);
  
  CTPatternFillProperties addNewPattFill();
  
  void unsetPattFill();
  
  CTGroupFillProperties getGrpFill();
  
  boolean isSetGrpFill();
  
  void setGrpFill(CTGroupFillProperties paramCTGroupFillProperties);
  
  CTGroupFillProperties addNewGrpFill();
  
  void unsetGrpFill();
  
  CTEffectList getEffectLst();
  
  boolean isSetEffectLst();
  
  void setEffectLst(CTEffectList paramCTEffectList);
  
  CTEffectList addNewEffectLst();
  
  void unsetEffectLst();
  
  CTEffectContainer getEffectDag();
  
  boolean isSetEffectDag();
  
  void setEffectDag(CTEffectContainer paramCTEffectContainer);
  
  CTEffectContainer addNewEffectDag();
  
  void unsetEffectDag();
  
  CTTableStyle getTableStyle();
  
  boolean isSetTableStyle();
  
  void setTableStyle(CTTableStyle paramCTTableStyle);
  
  CTTableStyle addNewTableStyle();
  
  void unsetTableStyle();
  
  String getTableStyleId();
  
  STGuid xgetTableStyleId();
  
  boolean isSetTableStyleId();
  
  void setTableStyleId(String paramString);
  
  void xsetTableStyleId(STGuid paramSTGuid);
  
  void unsetTableStyleId();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  boolean getRtl();
  
  XmlBoolean xgetRtl();
  
  boolean isSetRtl();
  
  void setRtl(boolean paramBoolean);
  
  void xsetRtl(XmlBoolean paramXmlBoolean);
  
  void unsetRtl();
  
  boolean getFirstRow();
  
  XmlBoolean xgetFirstRow();
  
  boolean isSetFirstRow();
  
  void setFirstRow(boolean paramBoolean);
  
  void xsetFirstRow(XmlBoolean paramXmlBoolean);
  
  void unsetFirstRow();
  
  boolean getFirstCol();
  
  XmlBoolean xgetFirstCol();
  
  boolean isSetFirstCol();
  
  void setFirstCol(boolean paramBoolean);
  
  void xsetFirstCol(XmlBoolean paramXmlBoolean);
  
  void unsetFirstCol();
  
  boolean getLastRow();
  
  XmlBoolean xgetLastRow();
  
  boolean isSetLastRow();
  
  void setLastRow(boolean paramBoolean);
  
  void xsetLastRow(XmlBoolean paramXmlBoolean);
  
  void unsetLastRow();
  
  boolean getLastCol();
  
  XmlBoolean xgetLastCol();
  
  boolean isSetLastCol();
  
  void setLastCol(boolean paramBoolean);
  
  void xsetLastCol(XmlBoolean paramXmlBoolean);
  
  void unsetLastCol();
  
  boolean getBandRow();
  
  XmlBoolean xgetBandRow();
  
  boolean isSetBandRow();
  
  void setBandRow(boolean paramBoolean);
  
  void xsetBandRow(XmlBoolean paramXmlBoolean);
  
  void unsetBandRow();
  
  boolean getBandCol();
  
  XmlBoolean xgetBandCol();
  
  boolean isSetBandCol();
  
  void setBandCol(boolean paramBoolean);
  
  void xsetBandCol(XmlBoolean paramXmlBoolean);
  
  void unsetBandCol();
  
  public static final class Factory {
    public static CTTableProperties newInstance() {
      return (CTTableProperties)POIXMLTypeLoader.newInstance(CTTableProperties.type, null);
    }
    
    public static CTTableProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTTableProperties)POIXMLTypeLoader.newInstance(CTTableProperties.type, param1XmlOptions);
    }
    
    public static CTTableProperties parse(String param1String) throws XmlException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1String, CTTableProperties.type, null);
    }
    
    public static CTTableProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1String, CTTableProperties.type, param1XmlOptions);
    }
    
    public static CTTableProperties parse(File param1File) throws XmlException, IOException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1File, CTTableProperties.type, null);
    }
    
    public static CTTableProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1File, CTTableProperties.type, param1XmlOptions);
    }
    
    public static CTTableProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1URL, CTTableProperties.type, null);
    }
    
    public static CTTableProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1URL, CTTableProperties.type, param1XmlOptions);
    }
    
    public static CTTableProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1InputStream, CTTableProperties.type, null);
    }
    
    public static CTTableProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1InputStream, CTTableProperties.type, param1XmlOptions);
    }
    
    public static CTTableProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1Reader, CTTableProperties.type, null);
    }
    
    public static CTTableProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1Reader, CTTableProperties.type, param1XmlOptions);
    }
    
    public static CTTableProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableProperties.type, null);
    }
    
    public static CTTableProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableProperties.type, param1XmlOptions);
    }
    
    public static CTTableProperties parse(Node param1Node) throws XmlException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1Node, CTTableProperties.type, null);
    }
    
    public static CTTableProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1Node, CTTableProperties.type, param1XmlOptions);
    }
    
    public static CTTableProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableProperties.type, null);
    }
    
    public static CTTableProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTableProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */