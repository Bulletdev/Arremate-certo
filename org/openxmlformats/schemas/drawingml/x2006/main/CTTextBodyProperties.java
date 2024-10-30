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

public interface CTTextBodyProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextBodyProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextbodyproperties87ddtype");
  
  CTPresetTextShape getPrstTxWarp();
  
  boolean isSetPrstTxWarp();
  
  void setPrstTxWarp(CTPresetTextShape paramCTPresetTextShape);
  
  CTPresetTextShape addNewPrstTxWarp();
  
  void unsetPrstTxWarp();
  
  CTTextNoAutofit getNoAutofit();
  
  boolean isSetNoAutofit();
  
  void setNoAutofit(CTTextNoAutofit paramCTTextNoAutofit);
  
  CTTextNoAutofit addNewNoAutofit();
  
  void unsetNoAutofit();
  
  CTTextNormalAutofit getNormAutofit();
  
  boolean isSetNormAutofit();
  
  void setNormAutofit(CTTextNormalAutofit paramCTTextNormalAutofit);
  
  CTTextNormalAutofit addNewNormAutofit();
  
  void unsetNormAutofit();
  
  CTTextShapeAutofit getSpAutoFit();
  
  boolean isSetSpAutoFit();
  
  void setSpAutoFit(CTTextShapeAutofit paramCTTextShapeAutofit);
  
  CTTextShapeAutofit addNewSpAutoFit();
  
  void unsetSpAutoFit();
  
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
  
  CTFlatText getFlatTx();
  
  boolean isSetFlatTx();
  
  void setFlatTx(CTFlatText paramCTFlatText);
  
  CTFlatText addNewFlatTx();
  
  void unsetFlatTx();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  int getRot();
  
  STAngle xgetRot();
  
  boolean isSetRot();
  
  void setRot(int paramInt);
  
  void xsetRot(STAngle paramSTAngle);
  
  void unsetRot();
  
  boolean getSpcFirstLastPara();
  
  XmlBoolean xgetSpcFirstLastPara();
  
  boolean isSetSpcFirstLastPara();
  
  void setSpcFirstLastPara(boolean paramBoolean);
  
  void xsetSpcFirstLastPara(XmlBoolean paramXmlBoolean);
  
  void unsetSpcFirstLastPara();
  
  STTextVertOverflowType.Enum getVertOverflow();
  
  STTextVertOverflowType xgetVertOverflow();
  
  boolean isSetVertOverflow();
  
  void setVertOverflow(STTextVertOverflowType.Enum paramEnum);
  
  void xsetVertOverflow(STTextVertOverflowType paramSTTextVertOverflowType);
  
  void unsetVertOverflow();
  
  STTextHorzOverflowType.Enum getHorzOverflow();
  
  STTextHorzOverflowType xgetHorzOverflow();
  
  boolean isSetHorzOverflow();
  
  void setHorzOverflow(STTextHorzOverflowType.Enum paramEnum);
  
  void xsetHorzOverflow(STTextHorzOverflowType paramSTTextHorzOverflowType);
  
  void unsetHorzOverflow();
  
  STTextVerticalType.Enum getVert();
  
  STTextVerticalType xgetVert();
  
  boolean isSetVert();
  
  void setVert(STTextVerticalType.Enum paramEnum);
  
  void xsetVert(STTextVerticalType paramSTTextVerticalType);
  
  void unsetVert();
  
  STTextWrappingType.Enum getWrap();
  
  STTextWrappingType xgetWrap();
  
  boolean isSetWrap();
  
  void setWrap(STTextWrappingType.Enum paramEnum);
  
  void xsetWrap(STTextWrappingType paramSTTextWrappingType);
  
  void unsetWrap();
  
  int getLIns();
  
  STCoordinate32 xgetLIns();
  
  boolean isSetLIns();
  
  void setLIns(int paramInt);
  
  void xsetLIns(STCoordinate32 paramSTCoordinate32);
  
  void unsetLIns();
  
  int getTIns();
  
  STCoordinate32 xgetTIns();
  
  boolean isSetTIns();
  
  void setTIns(int paramInt);
  
  void xsetTIns(STCoordinate32 paramSTCoordinate32);
  
  void unsetTIns();
  
  int getRIns();
  
  STCoordinate32 xgetRIns();
  
  boolean isSetRIns();
  
  void setRIns(int paramInt);
  
  void xsetRIns(STCoordinate32 paramSTCoordinate32);
  
  void unsetRIns();
  
  int getBIns();
  
  STCoordinate32 xgetBIns();
  
  boolean isSetBIns();
  
  void setBIns(int paramInt);
  
  void xsetBIns(STCoordinate32 paramSTCoordinate32);
  
  void unsetBIns();
  
  int getNumCol();
  
  STTextColumnCount xgetNumCol();
  
  boolean isSetNumCol();
  
  void setNumCol(int paramInt);
  
  void xsetNumCol(STTextColumnCount paramSTTextColumnCount);
  
  void unsetNumCol();
  
  int getSpcCol();
  
  STPositiveCoordinate32 xgetSpcCol();
  
  boolean isSetSpcCol();
  
  void setSpcCol(int paramInt);
  
  void xsetSpcCol(STPositiveCoordinate32 paramSTPositiveCoordinate32);
  
  void unsetSpcCol();
  
  boolean getRtlCol();
  
  XmlBoolean xgetRtlCol();
  
  boolean isSetRtlCol();
  
  void setRtlCol(boolean paramBoolean);
  
  void xsetRtlCol(XmlBoolean paramXmlBoolean);
  
  void unsetRtlCol();
  
  boolean getFromWordArt();
  
  XmlBoolean xgetFromWordArt();
  
  boolean isSetFromWordArt();
  
  void setFromWordArt(boolean paramBoolean);
  
  void xsetFromWordArt(XmlBoolean paramXmlBoolean);
  
  void unsetFromWordArt();
  
  STTextAnchoringType.Enum getAnchor();
  
  STTextAnchoringType xgetAnchor();
  
  boolean isSetAnchor();
  
  void setAnchor(STTextAnchoringType.Enum paramEnum);
  
  void xsetAnchor(STTextAnchoringType paramSTTextAnchoringType);
  
  void unsetAnchor();
  
  boolean getAnchorCtr();
  
  XmlBoolean xgetAnchorCtr();
  
  boolean isSetAnchorCtr();
  
  void setAnchorCtr(boolean paramBoolean);
  
  void xsetAnchorCtr(XmlBoolean paramXmlBoolean);
  
  void unsetAnchorCtr();
  
  boolean getForceAA();
  
  XmlBoolean xgetForceAA();
  
  boolean isSetForceAA();
  
  void setForceAA(boolean paramBoolean);
  
  void xsetForceAA(XmlBoolean paramXmlBoolean);
  
  void unsetForceAA();
  
  boolean getUpright();
  
  XmlBoolean xgetUpright();
  
  boolean isSetUpright();
  
  void setUpright(boolean paramBoolean);
  
  void xsetUpright(XmlBoolean paramXmlBoolean);
  
  void unsetUpright();
  
  boolean getCompatLnSpc();
  
  XmlBoolean xgetCompatLnSpc();
  
  boolean isSetCompatLnSpc();
  
  void setCompatLnSpc(boolean paramBoolean);
  
  void xsetCompatLnSpc(XmlBoolean paramXmlBoolean);
  
  void unsetCompatLnSpc();
  
  public static final class Factory {
    public static CTTextBodyProperties newInstance() {
      return (CTTextBodyProperties)POIXMLTypeLoader.newInstance(CTTextBodyProperties.type, null);
    }
    
    public static CTTextBodyProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTTextBodyProperties)POIXMLTypeLoader.newInstance(CTTextBodyProperties.type, param1XmlOptions);
    }
    
    public static CTTextBodyProperties parse(String param1String) throws XmlException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1String, CTTextBodyProperties.type, null);
    }
    
    public static CTTextBodyProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1String, CTTextBodyProperties.type, param1XmlOptions);
    }
    
    public static CTTextBodyProperties parse(File param1File) throws XmlException, IOException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1File, CTTextBodyProperties.type, null);
    }
    
    public static CTTextBodyProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1File, CTTextBodyProperties.type, param1XmlOptions);
    }
    
    public static CTTextBodyProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1URL, CTTextBodyProperties.type, null);
    }
    
    public static CTTextBodyProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1URL, CTTextBodyProperties.type, param1XmlOptions);
    }
    
    public static CTTextBodyProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1InputStream, CTTextBodyProperties.type, null);
    }
    
    public static CTTextBodyProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1InputStream, CTTextBodyProperties.type, param1XmlOptions);
    }
    
    public static CTTextBodyProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1Reader, CTTextBodyProperties.type, null);
    }
    
    public static CTTextBodyProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1Reader, CTTextBodyProperties.type, param1XmlOptions);
    }
    
    public static CTTextBodyProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextBodyProperties.type, null);
    }
    
    public static CTTextBodyProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextBodyProperties.type, param1XmlOptions);
    }
    
    public static CTTextBodyProperties parse(Node param1Node) throws XmlException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1Node, CTTextBodyProperties.type, null);
    }
    
    public static CTTextBodyProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1Node, CTTextBodyProperties.type, param1XmlOptions);
    }
    
    public static CTTextBodyProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextBodyProperties.type, null);
    }
    
    public static CTTextBodyProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextBodyProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextBodyProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextBodyProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextBodyProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextBodyProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */