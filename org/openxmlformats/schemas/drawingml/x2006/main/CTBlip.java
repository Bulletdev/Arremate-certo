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
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

public interface CTBlip extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBlip.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctblip034ctype");
  
  List<CTAlphaBiLevelEffect> getAlphaBiLevelList();
  
  CTAlphaBiLevelEffect[] getAlphaBiLevelArray();
  
  CTAlphaBiLevelEffect getAlphaBiLevelArray(int paramInt);
  
  int sizeOfAlphaBiLevelArray();
  
  void setAlphaBiLevelArray(CTAlphaBiLevelEffect[] paramArrayOfCTAlphaBiLevelEffect);
  
  void setAlphaBiLevelArray(int paramInt, CTAlphaBiLevelEffect paramCTAlphaBiLevelEffect);
  
  CTAlphaBiLevelEffect insertNewAlphaBiLevel(int paramInt);
  
  CTAlphaBiLevelEffect addNewAlphaBiLevel();
  
  void removeAlphaBiLevel(int paramInt);
  
  List<CTAlphaCeilingEffect> getAlphaCeilingList();
  
  CTAlphaCeilingEffect[] getAlphaCeilingArray();
  
  CTAlphaCeilingEffect getAlphaCeilingArray(int paramInt);
  
  int sizeOfAlphaCeilingArray();
  
  void setAlphaCeilingArray(CTAlphaCeilingEffect[] paramArrayOfCTAlphaCeilingEffect);
  
  void setAlphaCeilingArray(int paramInt, CTAlphaCeilingEffect paramCTAlphaCeilingEffect);
  
  CTAlphaCeilingEffect insertNewAlphaCeiling(int paramInt);
  
  CTAlphaCeilingEffect addNewAlphaCeiling();
  
  void removeAlphaCeiling(int paramInt);
  
  List<CTAlphaFloorEffect> getAlphaFloorList();
  
  CTAlphaFloorEffect[] getAlphaFloorArray();
  
  CTAlphaFloorEffect getAlphaFloorArray(int paramInt);
  
  int sizeOfAlphaFloorArray();
  
  void setAlphaFloorArray(CTAlphaFloorEffect[] paramArrayOfCTAlphaFloorEffect);
  
  void setAlphaFloorArray(int paramInt, CTAlphaFloorEffect paramCTAlphaFloorEffect);
  
  CTAlphaFloorEffect insertNewAlphaFloor(int paramInt);
  
  CTAlphaFloorEffect addNewAlphaFloor();
  
  void removeAlphaFloor(int paramInt);
  
  List<CTAlphaInverseEffect> getAlphaInvList();
  
  CTAlphaInverseEffect[] getAlphaInvArray();
  
  CTAlphaInverseEffect getAlphaInvArray(int paramInt);
  
  int sizeOfAlphaInvArray();
  
  void setAlphaInvArray(CTAlphaInverseEffect[] paramArrayOfCTAlphaInverseEffect);
  
  void setAlphaInvArray(int paramInt, CTAlphaInverseEffect paramCTAlphaInverseEffect);
  
  CTAlphaInverseEffect insertNewAlphaInv(int paramInt);
  
  CTAlphaInverseEffect addNewAlphaInv();
  
  void removeAlphaInv(int paramInt);
  
  List<CTAlphaModulateEffect> getAlphaModList();
  
  CTAlphaModulateEffect[] getAlphaModArray();
  
  CTAlphaModulateEffect getAlphaModArray(int paramInt);
  
  int sizeOfAlphaModArray();
  
  void setAlphaModArray(CTAlphaModulateEffect[] paramArrayOfCTAlphaModulateEffect);
  
  void setAlphaModArray(int paramInt, CTAlphaModulateEffect paramCTAlphaModulateEffect);
  
  CTAlphaModulateEffect insertNewAlphaMod(int paramInt);
  
  CTAlphaModulateEffect addNewAlphaMod();
  
  void removeAlphaMod(int paramInt);
  
  List<CTAlphaModulateFixedEffect> getAlphaModFixList();
  
  CTAlphaModulateFixedEffect[] getAlphaModFixArray();
  
  CTAlphaModulateFixedEffect getAlphaModFixArray(int paramInt);
  
  int sizeOfAlphaModFixArray();
  
  void setAlphaModFixArray(CTAlphaModulateFixedEffect[] paramArrayOfCTAlphaModulateFixedEffect);
  
  void setAlphaModFixArray(int paramInt, CTAlphaModulateFixedEffect paramCTAlphaModulateFixedEffect);
  
  CTAlphaModulateFixedEffect insertNewAlphaModFix(int paramInt);
  
  CTAlphaModulateFixedEffect addNewAlphaModFix();
  
  void removeAlphaModFix(int paramInt);
  
  List<CTAlphaReplaceEffect> getAlphaReplList();
  
  CTAlphaReplaceEffect[] getAlphaReplArray();
  
  CTAlphaReplaceEffect getAlphaReplArray(int paramInt);
  
  int sizeOfAlphaReplArray();
  
  void setAlphaReplArray(CTAlphaReplaceEffect[] paramArrayOfCTAlphaReplaceEffect);
  
  void setAlphaReplArray(int paramInt, CTAlphaReplaceEffect paramCTAlphaReplaceEffect);
  
  CTAlphaReplaceEffect insertNewAlphaRepl(int paramInt);
  
  CTAlphaReplaceEffect addNewAlphaRepl();
  
  void removeAlphaRepl(int paramInt);
  
  List<CTBiLevelEffect> getBiLevelList();
  
  CTBiLevelEffect[] getBiLevelArray();
  
  CTBiLevelEffect getBiLevelArray(int paramInt);
  
  int sizeOfBiLevelArray();
  
  void setBiLevelArray(CTBiLevelEffect[] paramArrayOfCTBiLevelEffect);
  
  void setBiLevelArray(int paramInt, CTBiLevelEffect paramCTBiLevelEffect);
  
  CTBiLevelEffect insertNewBiLevel(int paramInt);
  
  CTBiLevelEffect addNewBiLevel();
  
  void removeBiLevel(int paramInt);
  
  List<CTBlurEffect> getBlurList();
  
  CTBlurEffect[] getBlurArray();
  
  CTBlurEffect getBlurArray(int paramInt);
  
  int sizeOfBlurArray();
  
  void setBlurArray(CTBlurEffect[] paramArrayOfCTBlurEffect);
  
  void setBlurArray(int paramInt, CTBlurEffect paramCTBlurEffect);
  
  CTBlurEffect insertNewBlur(int paramInt);
  
  CTBlurEffect addNewBlur();
  
  void removeBlur(int paramInt);
  
  List<CTColorChangeEffect> getClrChangeList();
  
  CTColorChangeEffect[] getClrChangeArray();
  
  CTColorChangeEffect getClrChangeArray(int paramInt);
  
  int sizeOfClrChangeArray();
  
  void setClrChangeArray(CTColorChangeEffect[] paramArrayOfCTColorChangeEffect);
  
  void setClrChangeArray(int paramInt, CTColorChangeEffect paramCTColorChangeEffect);
  
  CTColorChangeEffect insertNewClrChange(int paramInt);
  
  CTColorChangeEffect addNewClrChange();
  
  void removeClrChange(int paramInt);
  
  List<CTColorReplaceEffect> getClrReplList();
  
  CTColorReplaceEffect[] getClrReplArray();
  
  CTColorReplaceEffect getClrReplArray(int paramInt);
  
  int sizeOfClrReplArray();
  
  void setClrReplArray(CTColorReplaceEffect[] paramArrayOfCTColorReplaceEffect);
  
  void setClrReplArray(int paramInt, CTColorReplaceEffect paramCTColorReplaceEffect);
  
  CTColorReplaceEffect insertNewClrRepl(int paramInt);
  
  CTColorReplaceEffect addNewClrRepl();
  
  void removeClrRepl(int paramInt);
  
  List<CTDuotoneEffect> getDuotoneList();
  
  CTDuotoneEffect[] getDuotoneArray();
  
  CTDuotoneEffect getDuotoneArray(int paramInt);
  
  int sizeOfDuotoneArray();
  
  void setDuotoneArray(CTDuotoneEffect[] paramArrayOfCTDuotoneEffect);
  
  void setDuotoneArray(int paramInt, CTDuotoneEffect paramCTDuotoneEffect);
  
  CTDuotoneEffect insertNewDuotone(int paramInt);
  
  CTDuotoneEffect addNewDuotone();
  
  void removeDuotone(int paramInt);
  
  List<CTFillOverlayEffect> getFillOverlayList();
  
  CTFillOverlayEffect[] getFillOverlayArray();
  
  CTFillOverlayEffect getFillOverlayArray(int paramInt);
  
  int sizeOfFillOverlayArray();
  
  void setFillOverlayArray(CTFillOverlayEffect[] paramArrayOfCTFillOverlayEffect);
  
  void setFillOverlayArray(int paramInt, CTFillOverlayEffect paramCTFillOverlayEffect);
  
  CTFillOverlayEffect insertNewFillOverlay(int paramInt);
  
  CTFillOverlayEffect addNewFillOverlay();
  
  void removeFillOverlay(int paramInt);
  
  List<CTGrayscaleEffect> getGraysclList();
  
  CTGrayscaleEffect[] getGraysclArray();
  
  CTGrayscaleEffect getGraysclArray(int paramInt);
  
  int sizeOfGraysclArray();
  
  void setGraysclArray(CTGrayscaleEffect[] paramArrayOfCTGrayscaleEffect);
  
  void setGraysclArray(int paramInt, CTGrayscaleEffect paramCTGrayscaleEffect);
  
  CTGrayscaleEffect insertNewGrayscl(int paramInt);
  
  CTGrayscaleEffect addNewGrayscl();
  
  void removeGrayscl(int paramInt);
  
  List<CTHSLEffect> getHslList();
  
  CTHSLEffect[] getHslArray();
  
  CTHSLEffect getHslArray(int paramInt);
  
  int sizeOfHslArray();
  
  void setHslArray(CTHSLEffect[] paramArrayOfCTHSLEffect);
  
  void setHslArray(int paramInt, CTHSLEffect paramCTHSLEffect);
  
  CTHSLEffect insertNewHsl(int paramInt);
  
  CTHSLEffect addNewHsl();
  
  void removeHsl(int paramInt);
  
  List<CTLuminanceEffect> getLumList();
  
  CTLuminanceEffect[] getLumArray();
  
  CTLuminanceEffect getLumArray(int paramInt);
  
  int sizeOfLumArray();
  
  void setLumArray(CTLuminanceEffect[] paramArrayOfCTLuminanceEffect);
  
  void setLumArray(int paramInt, CTLuminanceEffect paramCTLuminanceEffect);
  
  CTLuminanceEffect insertNewLum(int paramInt);
  
  CTLuminanceEffect addNewLum();
  
  void removeLum(int paramInt);
  
  List<CTTintEffect> getTintList();
  
  CTTintEffect[] getTintArray();
  
  CTTintEffect getTintArray(int paramInt);
  
  int sizeOfTintArray();
  
  void setTintArray(CTTintEffect[] paramArrayOfCTTintEffect);
  
  void setTintArray(int paramInt, CTTintEffect paramCTTintEffect);
  
  CTTintEffect insertNewTint(int paramInt);
  
  CTTintEffect addNewTint();
  
  void removeTint(int paramInt);
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  String getEmbed();
  
  STRelationshipId xgetEmbed();
  
  boolean isSetEmbed();
  
  void setEmbed(String paramString);
  
  void xsetEmbed(STRelationshipId paramSTRelationshipId);
  
  void unsetEmbed();
  
  String getLink();
  
  STRelationshipId xgetLink();
  
  boolean isSetLink();
  
  void setLink(String paramString);
  
  void xsetLink(STRelationshipId paramSTRelationshipId);
  
  void unsetLink();
  
  STBlipCompression$Enum getCstate();
  
  STBlipCompression xgetCstate();
  
  boolean isSetCstate();
  
  void setCstate(STBlipCompression$Enum paramSTBlipCompression$Enum);
  
  void xsetCstate(STBlipCompression paramSTBlipCompression);
  
  void unsetCstate();
  
  public static final class Factory {
    public static CTBlip newInstance() {
      return (CTBlip)POIXMLTypeLoader.newInstance(CTBlip.type, null);
    }
    
    public static CTBlip newInstance(XmlOptions param1XmlOptions) {
      return (CTBlip)POIXMLTypeLoader.newInstance(CTBlip.type, param1XmlOptions);
    }
    
    public static CTBlip parse(String param1String) throws XmlException {
      return (CTBlip)POIXMLTypeLoader.parse(param1String, CTBlip.type, null);
    }
    
    public static CTBlip parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBlip)POIXMLTypeLoader.parse(param1String, CTBlip.type, param1XmlOptions);
    }
    
    public static CTBlip parse(File param1File) throws XmlException, IOException {
      return (CTBlip)POIXMLTypeLoader.parse(param1File, CTBlip.type, null);
    }
    
    public static CTBlip parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBlip)POIXMLTypeLoader.parse(param1File, CTBlip.type, param1XmlOptions);
    }
    
    public static CTBlip parse(URL param1URL) throws XmlException, IOException {
      return (CTBlip)POIXMLTypeLoader.parse(param1URL, CTBlip.type, null);
    }
    
    public static CTBlip parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBlip)POIXMLTypeLoader.parse(param1URL, CTBlip.type, param1XmlOptions);
    }
    
    public static CTBlip parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBlip)POIXMLTypeLoader.parse(param1InputStream, CTBlip.type, null);
    }
    
    public static CTBlip parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBlip)POIXMLTypeLoader.parse(param1InputStream, CTBlip.type, param1XmlOptions);
    }
    
    public static CTBlip parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBlip)POIXMLTypeLoader.parse(param1Reader, CTBlip.type, null);
    }
    
    public static CTBlip parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBlip)POIXMLTypeLoader.parse(param1Reader, CTBlip.type, param1XmlOptions);
    }
    
    public static CTBlip parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBlip)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBlip.type, null);
    }
    
    public static CTBlip parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBlip)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBlip.type, param1XmlOptions);
    }
    
    public static CTBlip parse(Node param1Node) throws XmlException {
      return (CTBlip)POIXMLTypeLoader.parse(param1Node, CTBlip.type, null);
    }
    
    public static CTBlip parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBlip)POIXMLTypeLoader.parse(param1Node, CTBlip.type, param1XmlOptions);
    }
    
    public static CTBlip parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBlip)POIXMLTypeLoader.parse(param1XMLInputStream, CTBlip.type, null);
    }
    
    public static CTBlip parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBlip)POIXMLTypeLoader.parse(param1XMLInputStream, CTBlip.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBlip.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBlip.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTBlip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */