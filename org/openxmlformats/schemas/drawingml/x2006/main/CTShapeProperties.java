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

public interface CTShapeProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTShapeProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshapeproperties30e5type");
  
  CTTransform2D getXfrm();
  
  boolean isSetXfrm();
  
  void setXfrm(CTTransform2D paramCTTransform2D);
  
  CTTransform2D addNewXfrm();
  
  void unsetXfrm();
  
  CTCustomGeometry2D getCustGeom();
  
  boolean isSetCustGeom();
  
  void setCustGeom(CTCustomGeometry2D paramCTCustomGeometry2D);
  
  CTCustomGeometry2D addNewCustGeom();
  
  void unsetCustGeom();
  
  CTPresetGeometry2D getPrstGeom();
  
  boolean isSetPrstGeom();
  
  void setPrstGeom(CTPresetGeometry2D paramCTPresetGeometry2D);
  
  CTPresetGeometry2D addNewPrstGeom();
  
  void unsetPrstGeom();
  
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
  
  CTLineProperties getLn();
  
  boolean isSetLn();
  
  void setLn(CTLineProperties paramCTLineProperties);
  
  CTLineProperties addNewLn();
  
  void unsetLn();
  
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
  
  CTScene3D getScene3D();
  
  boolean isSetScene3D();
  
  void setScene3D(CTScene3D paramCTScene3D);
  
  CTScene3D addNewScene3D();
  
  void unsetScene3D();
  
  CTShape3D getSp3D();
  
  boolean isSetSp3D();
  
  void setSp3D(CTShape3D paramCTShape3D);
  
  CTShape3D addNewSp3D();
  
  void unsetSp3D();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  STBlackWhiteMode$Enum getBwMode();
  
  STBlackWhiteMode xgetBwMode();
  
  boolean isSetBwMode();
  
  void setBwMode(STBlackWhiteMode$Enum paramSTBlackWhiteMode$Enum);
  
  void xsetBwMode(STBlackWhiteMode paramSTBlackWhiteMode);
  
  void unsetBwMode();
  
  public static final class Factory {
    public static CTShapeProperties newInstance() {
      return (CTShapeProperties)POIXMLTypeLoader.newInstance(CTShapeProperties.type, null);
    }
    
    public static CTShapeProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTShapeProperties)POIXMLTypeLoader.newInstance(CTShapeProperties.type, param1XmlOptions);
    }
    
    public static CTShapeProperties parse(String param1String) throws XmlException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1String, CTShapeProperties.type, null);
    }
    
    public static CTShapeProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1String, CTShapeProperties.type, param1XmlOptions);
    }
    
    public static CTShapeProperties parse(File param1File) throws XmlException, IOException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1File, CTShapeProperties.type, null);
    }
    
    public static CTShapeProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1File, CTShapeProperties.type, param1XmlOptions);
    }
    
    public static CTShapeProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1URL, CTShapeProperties.type, null);
    }
    
    public static CTShapeProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1URL, CTShapeProperties.type, param1XmlOptions);
    }
    
    public static CTShapeProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1InputStream, CTShapeProperties.type, null);
    }
    
    public static CTShapeProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1InputStream, CTShapeProperties.type, param1XmlOptions);
    }
    
    public static CTShapeProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1Reader, CTShapeProperties.type, null);
    }
    
    public static CTShapeProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1Reader, CTShapeProperties.type, param1XmlOptions);
    }
    
    public static CTShapeProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShapeProperties.type, null);
    }
    
    public static CTShapeProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShapeProperties.type, param1XmlOptions);
    }
    
    public static CTShapeProperties parse(Node param1Node) throws XmlException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1Node, CTShapeProperties.type, null);
    }
    
    public static CTShapeProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1Node, CTShapeProperties.type, param1XmlOptions);
    }
    
    public static CTShapeProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTShapeProperties.type, null);
    }
    
    public static CTShapeProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTShapeProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTShapeProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShapeProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShapeProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTShapeProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */