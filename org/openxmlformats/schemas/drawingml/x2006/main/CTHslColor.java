package org.openxmlformats.schemas.drawingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTHslColor extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTHslColor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthslcolora63dtype");
  
  List<CTPositiveFixedPercentage> getTintList();
  
  CTPositiveFixedPercentage[] getTintArray();
  
  CTPositiveFixedPercentage getTintArray(int paramInt);
  
  int sizeOfTintArray();
  
  void setTintArray(CTPositiveFixedPercentage[] paramArrayOfCTPositiveFixedPercentage);
  
  void setTintArray(int paramInt, CTPositiveFixedPercentage paramCTPositiveFixedPercentage);
  
  CTPositiveFixedPercentage insertNewTint(int paramInt);
  
  CTPositiveFixedPercentage addNewTint();
  
  void removeTint(int paramInt);
  
  List<CTPositiveFixedPercentage> getShadeList();
  
  CTPositiveFixedPercentage[] getShadeArray();
  
  CTPositiveFixedPercentage getShadeArray(int paramInt);
  
  int sizeOfShadeArray();
  
  void setShadeArray(CTPositiveFixedPercentage[] paramArrayOfCTPositiveFixedPercentage);
  
  void setShadeArray(int paramInt, CTPositiveFixedPercentage paramCTPositiveFixedPercentage);
  
  CTPositiveFixedPercentage insertNewShade(int paramInt);
  
  CTPositiveFixedPercentage addNewShade();
  
  void removeShade(int paramInt);
  
  List<CTComplementTransform> getCompList();
  
  CTComplementTransform[] getCompArray();
  
  CTComplementTransform getCompArray(int paramInt);
  
  int sizeOfCompArray();
  
  void setCompArray(CTComplementTransform[] paramArrayOfCTComplementTransform);
  
  void setCompArray(int paramInt, CTComplementTransform paramCTComplementTransform);
  
  CTComplementTransform insertNewComp(int paramInt);
  
  CTComplementTransform addNewComp();
  
  void removeComp(int paramInt);
  
  List<CTInverseTransform> getInvList();
  
  CTInverseTransform[] getInvArray();
  
  CTInverseTransform getInvArray(int paramInt);
  
  int sizeOfInvArray();
  
  void setInvArray(CTInverseTransform[] paramArrayOfCTInverseTransform);
  
  void setInvArray(int paramInt, CTInverseTransform paramCTInverseTransform);
  
  CTInverseTransform insertNewInv(int paramInt);
  
  CTInverseTransform addNewInv();
  
  void removeInv(int paramInt);
  
  List<CTGrayscaleTransform> getGrayList();
  
  CTGrayscaleTransform[] getGrayArray();
  
  CTGrayscaleTransform getGrayArray(int paramInt);
  
  int sizeOfGrayArray();
  
  void setGrayArray(CTGrayscaleTransform[] paramArrayOfCTGrayscaleTransform);
  
  void setGrayArray(int paramInt, CTGrayscaleTransform paramCTGrayscaleTransform);
  
  CTGrayscaleTransform insertNewGray(int paramInt);
  
  CTGrayscaleTransform addNewGray();
  
  void removeGray(int paramInt);
  
  List<CTPositiveFixedPercentage> getAlphaList();
  
  CTPositiveFixedPercentage[] getAlphaArray();
  
  CTPositiveFixedPercentage getAlphaArray(int paramInt);
  
  int sizeOfAlphaArray();
  
  void setAlphaArray(CTPositiveFixedPercentage[] paramArrayOfCTPositiveFixedPercentage);
  
  void setAlphaArray(int paramInt, CTPositiveFixedPercentage paramCTPositiveFixedPercentage);
  
  CTPositiveFixedPercentage insertNewAlpha(int paramInt);
  
  CTPositiveFixedPercentage addNewAlpha();
  
  void removeAlpha(int paramInt);
  
  List<CTFixedPercentage> getAlphaOffList();
  
  CTFixedPercentage[] getAlphaOffArray();
  
  CTFixedPercentage getAlphaOffArray(int paramInt);
  
  int sizeOfAlphaOffArray();
  
  void setAlphaOffArray(CTFixedPercentage[] paramArrayOfCTFixedPercentage);
  
  void setAlphaOffArray(int paramInt, CTFixedPercentage paramCTFixedPercentage);
  
  CTFixedPercentage insertNewAlphaOff(int paramInt);
  
  CTFixedPercentage addNewAlphaOff();
  
  void removeAlphaOff(int paramInt);
  
  List<CTPositivePercentage> getAlphaModList();
  
  CTPositivePercentage[] getAlphaModArray();
  
  CTPositivePercentage getAlphaModArray(int paramInt);
  
  int sizeOfAlphaModArray();
  
  void setAlphaModArray(CTPositivePercentage[] paramArrayOfCTPositivePercentage);
  
  void setAlphaModArray(int paramInt, CTPositivePercentage paramCTPositivePercentage);
  
  CTPositivePercentage insertNewAlphaMod(int paramInt);
  
  CTPositivePercentage addNewAlphaMod();
  
  void removeAlphaMod(int paramInt);
  
  List<CTPositiveFixedAngle> getHueList();
  
  CTPositiveFixedAngle[] getHueArray();
  
  CTPositiveFixedAngle getHueArray(int paramInt);
  
  int sizeOfHueArray();
  
  void setHueArray(CTPositiveFixedAngle[] paramArrayOfCTPositiveFixedAngle);
  
  void setHueArray(int paramInt, CTPositiveFixedAngle paramCTPositiveFixedAngle);
  
  CTPositiveFixedAngle insertNewHue(int paramInt);
  
  CTPositiveFixedAngle addNewHue();
  
  void removeHue(int paramInt);
  
  List<CTAngle> getHueOffList();
  
  CTAngle[] getHueOffArray();
  
  CTAngle getHueOffArray(int paramInt);
  
  int sizeOfHueOffArray();
  
  void setHueOffArray(CTAngle[] paramArrayOfCTAngle);
  
  void setHueOffArray(int paramInt, CTAngle paramCTAngle);
  
  CTAngle insertNewHueOff(int paramInt);
  
  CTAngle addNewHueOff();
  
  void removeHueOff(int paramInt);
  
  List<CTPositivePercentage> getHueModList();
  
  CTPositivePercentage[] getHueModArray();
  
  CTPositivePercentage getHueModArray(int paramInt);
  
  int sizeOfHueModArray();
  
  void setHueModArray(CTPositivePercentage[] paramArrayOfCTPositivePercentage);
  
  void setHueModArray(int paramInt, CTPositivePercentage paramCTPositivePercentage);
  
  CTPositivePercentage insertNewHueMod(int paramInt);
  
  CTPositivePercentage addNewHueMod();
  
  void removeHueMod(int paramInt);
  
  List<CTPercentage> getSatList();
  
  CTPercentage[] getSatArray();
  
  CTPercentage getSatArray(int paramInt);
  
  int sizeOfSatArray();
  
  void setSatArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setSatArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewSat(int paramInt);
  
  CTPercentage addNewSat();
  
  void removeSat(int paramInt);
  
  List<CTPercentage> getSatOffList();
  
  CTPercentage[] getSatOffArray();
  
  CTPercentage getSatOffArray(int paramInt);
  
  int sizeOfSatOffArray();
  
  void setSatOffArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setSatOffArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewSatOff(int paramInt);
  
  CTPercentage addNewSatOff();
  
  void removeSatOff(int paramInt);
  
  List<CTPercentage> getSatModList();
  
  CTPercentage[] getSatModArray();
  
  CTPercentage getSatModArray(int paramInt);
  
  int sizeOfSatModArray();
  
  void setSatModArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setSatModArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewSatMod(int paramInt);
  
  CTPercentage addNewSatMod();
  
  void removeSatMod(int paramInt);
  
  List<CTPercentage> getLumList();
  
  CTPercentage[] getLumArray();
  
  CTPercentage getLumArray(int paramInt);
  
  int sizeOfLumArray();
  
  void setLumArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setLumArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewLum(int paramInt);
  
  CTPercentage addNewLum();
  
  void removeLum(int paramInt);
  
  List<CTPercentage> getLumOffList();
  
  CTPercentage[] getLumOffArray();
  
  CTPercentage getLumOffArray(int paramInt);
  
  int sizeOfLumOffArray();
  
  void setLumOffArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setLumOffArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewLumOff(int paramInt);
  
  CTPercentage addNewLumOff();
  
  void removeLumOff(int paramInt);
  
  List<CTPercentage> getLumModList();
  
  CTPercentage[] getLumModArray();
  
  CTPercentage getLumModArray(int paramInt);
  
  int sizeOfLumModArray();
  
  void setLumModArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setLumModArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewLumMod(int paramInt);
  
  CTPercentage addNewLumMod();
  
  void removeLumMod(int paramInt);
  
  List<CTPercentage> getRedList();
  
  CTPercentage[] getRedArray();
  
  CTPercentage getRedArray(int paramInt);
  
  int sizeOfRedArray();
  
  void setRedArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setRedArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewRed(int paramInt);
  
  CTPercentage addNewRed();
  
  void removeRed(int paramInt);
  
  List<CTPercentage> getRedOffList();
  
  CTPercentage[] getRedOffArray();
  
  CTPercentage getRedOffArray(int paramInt);
  
  int sizeOfRedOffArray();
  
  void setRedOffArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setRedOffArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewRedOff(int paramInt);
  
  CTPercentage addNewRedOff();
  
  void removeRedOff(int paramInt);
  
  List<CTPercentage> getRedModList();
  
  CTPercentage[] getRedModArray();
  
  CTPercentage getRedModArray(int paramInt);
  
  int sizeOfRedModArray();
  
  void setRedModArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setRedModArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewRedMod(int paramInt);
  
  CTPercentage addNewRedMod();
  
  void removeRedMod(int paramInt);
  
  List<CTPercentage> getGreenList();
  
  CTPercentage[] getGreenArray();
  
  CTPercentage getGreenArray(int paramInt);
  
  int sizeOfGreenArray();
  
  void setGreenArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setGreenArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewGreen(int paramInt);
  
  CTPercentage addNewGreen();
  
  void removeGreen(int paramInt);
  
  List<CTPercentage> getGreenOffList();
  
  CTPercentage[] getGreenOffArray();
  
  CTPercentage getGreenOffArray(int paramInt);
  
  int sizeOfGreenOffArray();
  
  void setGreenOffArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setGreenOffArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewGreenOff(int paramInt);
  
  CTPercentage addNewGreenOff();
  
  void removeGreenOff(int paramInt);
  
  List<CTPercentage> getGreenModList();
  
  CTPercentage[] getGreenModArray();
  
  CTPercentage getGreenModArray(int paramInt);
  
  int sizeOfGreenModArray();
  
  void setGreenModArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setGreenModArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewGreenMod(int paramInt);
  
  CTPercentage addNewGreenMod();
  
  void removeGreenMod(int paramInt);
  
  List<CTPercentage> getBlueList();
  
  CTPercentage[] getBlueArray();
  
  CTPercentage getBlueArray(int paramInt);
  
  int sizeOfBlueArray();
  
  void setBlueArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setBlueArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewBlue(int paramInt);
  
  CTPercentage addNewBlue();
  
  void removeBlue(int paramInt);
  
  List<CTPercentage> getBlueOffList();
  
  CTPercentage[] getBlueOffArray();
  
  CTPercentage getBlueOffArray(int paramInt);
  
  int sizeOfBlueOffArray();
  
  void setBlueOffArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setBlueOffArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewBlueOff(int paramInt);
  
  CTPercentage addNewBlueOff();
  
  void removeBlueOff(int paramInt);
  
  List<CTPercentage> getBlueModList();
  
  CTPercentage[] getBlueModArray();
  
  CTPercentage getBlueModArray(int paramInt);
  
  int sizeOfBlueModArray();
  
  void setBlueModArray(CTPercentage[] paramArrayOfCTPercentage);
  
  void setBlueModArray(int paramInt, CTPercentage paramCTPercentage);
  
  CTPercentage insertNewBlueMod(int paramInt);
  
  CTPercentage addNewBlueMod();
  
  void removeBlueMod(int paramInt);
  
  List<CTGammaTransform> getGammaList();
  
  CTGammaTransform[] getGammaArray();
  
  CTGammaTransform getGammaArray(int paramInt);
  
  int sizeOfGammaArray();
  
  void setGammaArray(CTGammaTransform[] paramArrayOfCTGammaTransform);
  
  void setGammaArray(int paramInt, CTGammaTransform paramCTGammaTransform);
  
  CTGammaTransform insertNewGamma(int paramInt);
  
  CTGammaTransform addNewGamma();
  
  void removeGamma(int paramInt);
  
  List<CTInverseGammaTransform> getInvGammaList();
  
  CTInverseGammaTransform[] getInvGammaArray();
  
  CTInverseGammaTransform getInvGammaArray(int paramInt);
  
  int sizeOfInvGammaArray();
  
  void setInvGammaArray(CTInverseGammaTransform[] paramArrayOfCTInverseGammaTransform);
  
  void setInvGammaArray(int paramInt, CTInverseGammaTransform paramCTInverseGammaTransform);
  
  CTInverseGammaTransform insertNewInvGamma(int paramInt);
  
  CTInverseGammaTransform addNewInvGamma();
  
  void removeInvGamma(int paramInt);
  
  int getHue2();
  
  STPositiveFixedAngle xgetHue2();
  
  void setHue2(int paramInt);
  
  void xsetHue2(STPositiveFixedAngle paramSTPositiveFixedAngle);
  
  int getSat2();
  
  STPercentage xgetSat2();
  
  void setSat2(int paramInt);
  
  void xsetSat2(STPercentage paramSTPercentage);
  
  int getLum2();
  
  STPercentage xgetLum2();
  
  void setLum2(int paramInt);
  
  void xsetLum2(STPercentage paramSTPercentage);
  
  public static final class Factory {
    public static CTHslColor newInstance() {
      return (CTHslColor)POIXMLTypeLoader.newInstance(CTHslColor.type, null);
    }
    
    public static CTHslColor newInstance(XmlOptions param1XmlOptions) {
      return (CTHslColor)POIXMLTypeLoader.newInstance(CTHslColor.type, param1XmlOptions);
    }
    
    public static CTHslColor parse(String param1String) throws XmlException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1String, CTHslColor.type, null);
    }
    
    public static CTHslColor parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1String, CTHslColor.type, param1XmlOptions);
    }
    
    public static CTHslColor parse(File param1File) throws XmlException, IOException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1File, CTHslColor.type, null);
    }
    
    public static CTHslColor parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1File, CTHslColor.type, param1XmlOptions);
    }
    
    public static CTHslColor parse(URL param1URL) throws XmlException, IOException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1URL, CTHslColor.type, null);
    }
    
    public static CTHslColor parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1URL, CTHslColor.type, param1XmlOptions);
    }
    
    public static CTHslColor parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1InputStream, CTHslColor.type, null);
    }
    
    public static CTHslColor parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1InputStream, CTHslColor.type, param1XmlOptions);
    }
    
    public static CTHslColor parse(Reader param1Reader) throws XmlException, IOException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1Reader, CTHslColor.type, null);
    }
    
    public static CTHslColor parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1Reader, CTHslColor.type, param1XmlOptions);
    }
    
    public static CTHslColor parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHslColor.type, null);
    }
    
    public static CTHslColor parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHslColor.type, param1XmlOptions);
    }
    
    public static CTHslColor parse(Node param1Node) throws XmlException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1Node, CTHslColor.type, null);
    }
    
    public static CTHslColor parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1Node, CTHslColor.type, param1XmlOptions);
    }
    
    public static CTHslColor parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1XMLInputStream, CTHslColor.type, null);
    }
    
    public static CTHslColor parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTHslColor)POIXMLTypeLoader.parse(param1XMLInputStream, CTHslColor.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHslColor.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHslColor.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTHslColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */