package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface CTSdtPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSdtPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsdtpre24dtype");
  
  List<CTRPr> getRPrList();
  
  CTRPr[] getRPrArray();
  
  CTRPr getRPrArray(int paramInt);
  
  int sizeOfRPrArray();
  
  void setRPrArray(CTRPr[] paramArrayOfCTRPr);
  
  void setRPrArray(int paramInt, CTRPr paramCTRPr);
  
  CTRPr insertNewRPr(int paramInt);
  
  CTRPr addNewRPr();
  
  void removeRPr(int paramInt);
  
  List<CTString> getAliasList();
  
  CTString[] getAliasArray();
  
  CTString getAliasArray(int paramInt);
  
  int sizeOfAliasArray();
  
  void setAliasArray(CTString[] paramArrayOfCTString);
  
  void setAliasArray(int paramInt, CTString paramCTString);
  
  CTString insertNewAlias(int paramInt);
  
  CTString addNewAlias();
  
  void removeAlias(int paramInt);
  
  List<CTLock> getLockList();
  
  CTLock[] getLockArray();
  
  CTLock getLockArray(int paramInt);
  
  int sizeOfLockArray();
  
  void setLockArray(CTLock[] paramArrayOfCTLock);
  
  void setLockArray(int paramInt, CTLock paramCTLock);
  
  CTLock insertNewLock(int paramInt);
  
  CTLock addNewLock();
  
  void removeLock(int paramInt);
  
  List<CTPlaceholder> getPlaceholderList();
  
  CTPlaceholder[] getPlaceholderArray();
  
  CTPlaceholder getPlaceholderArray(int paramInt);
  
  int sizeOfPlaceholderArray();
  
  void setPlaceholderArray(CTPlaceholder[] paramArrayOfCTPlaceholder);
  
  void setPlaceholderArray(int paramInt, CTPlaceholder paramCTPlaceholder);
  
  CTPlaceholder insertNewPlaceholder(int paramInt);
  
  CTPlaceholder addNewPlaceholder();
  
  void removePlaceholder(int paramInt);
  
  List<CTOnOff> getShowingPlcHdrList();
  
  CTOnOff[] getShowingPlcHdrArray();
  
  CTOnOff getShowingPlcHdrArray(int paramInt);
  
  int sizeOfShowingPlcHdrArray();
  
  void setShowingPlcHdrArray(CTOnOff[] paramArrayOfCTOnOff);
  
  void setShowingPlcHdrArray(int paramInt, CTOnOff paramCTOnOff);
  
  CTOnOff insertNewShowingPlcHdr(int paramInt);
  
  CTOnOff addNewShowingPlcHdr();
  
  void removeShowingPlcHdr(int paramInt);
  
  List<CTDataBinding> getDataBindingList();
  
  CTDataBinding[] getDataBindingArray();
  
  CTDataBinding getDataBindingArray(int paramInt);
  
  int sizeOfDataBindingArray();
  
  void setDataBindingArray(CTDataBinding[] paramArrayOfCTDataBinding);
  
  void setDataBindingArray(int paramInt, CTDataBinding paramCTDataBinding);
  
  CTDataBinding insertNewDataBinding(int paramInt);
  
  CTDataBinding addNewDataBinding();
  
  void removeDataBinding(int paramInt);
  
  List<CTOnOff> getTemporaryList();
  
  CTOnOff[] getTemporaryArray();
  
  CTOnOff getTemporaryArray(int paramInt);
  
  int sizeOfTemporaryArray();
  
  void setTemporaryArray(CTOnOff[] paramArrayOfCTOnOff);
  
  void setTemporaryArray(int paramInt, CTOnOff paramCTOnOff);
  
  CTOnOff insertNewTemporary(int paramInt);
  
  CTOnOff addNewTemporary();
  
  void removeTemporary(int paramInt);
  
  List<CTDecimalNumber> getIdList();
  
  CTDecimalNumber[] getIdArray();
  
  CTDecimalNumber getIdArray(int paramInt);
  
  int sizeOfIdArray();
  
  void setIdArray(CTDecimalNumber[] paramArrayOfCTDecimalNumber);
  
  void setIdArray(int paramInt, CTDecimalNumber paramCTDecimalNumber);
  
  CTDecimalNumber insertNewId(int paramInt);
  
  CTDecimalNumber addNewId();
  
  void removeId(int paramInt);
  
  List<CTString> getTagList();
  
  CTString[] getTagArray();
  
  CTString getTagArray(int paramInt);
  
  int sizeOfTagArray();
  
  void setTagArray(CTString[] paramArrayOfCTString);
  
  void setTagArray(int paramInt, CTString paramCTString);
  
  CTString insertNewTag(int paramInt);
  
  CTString addNewTag();
  
  void removeTag(int paramInt);
  
  List<CTEmpty> getEquationList();
  
  CTEmpty[] getEquationArray();
  
  CTEmpty getEquationArray(int paramInt);
  
  int sizeOfEquationArray();
  
  void setEquationArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setEquationArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewEquation(int paramInt);
  
  CTEmpty addNewEquation();
  
  void removeEquation(int paramInt);
  
  List<CTSdtComboBox> getComboBoxList();
  
  CTSdtComboBox[] getComboBoxArray();
  
  CTSdtComboBox getComboBoxArray(int paramInt);
  
  int sizeOfComboBoxArray();
  
  void setComboBoxArray(CTSdtComboBox[] paramArrayOfCTSdtComboBox);
  
  void setComboBoxArray(int paramInt, CTSdtComboBox paramCTSdtComboBox);
  
  CTSdtComboBox insertNewComboBox(int paramInt);
  
  CTSdtComboBox addNewComboBox();
  
  void removeComboBox(int paramInt);
  
  List<CTSdtDate> getDateList();
  
  CTSdtDate[] getDateArray();
  
  CTSdtDate getDateArray(int paramInt);
  
  int sizeOfDateArray();
  
  void setDateArray(CTSdtDate[] paramArrayOfCTSdtDate);
  
  void setDateArray(int paramInt, CTSdtDate paramCTSdtDate);
  
  CTSdtDate insertNewDate(int paramInt);
  
  CTSdtDate addNewDate();
  
  void removeDate(int paramInt);
  
  List<CTSdtDocPart> getDocPartObjList();
  
  CTSdtDocPart[] getDocPartObjArray();
  
  CTSdtDocPart getDocPartObjArray(int paramInt);
  
  int sizeOfDocPartObjArray();
  
  void setDocPartObjArray(CTSdtDocPart[] paramArrayOfCTSdtDocPart);
  
  void setDocPartObjArray(int paramInt, CTSdtDocPart paramCTSdtDocPart);
  
  CTSdtDocPart insertNewDocPartObj(int paramInt);
  
  CTSdtDocPart addNewDocPartObj();
  
  void removeDocPartObj(int paramInt);
  
  List<CTSdtDocPart> getDocPartListList();
  
  CTSdtDocPart[] getDocPartListArray();
  
  CTSdtDocPart getDocPartListArray(int paramInt);
  
  int sizeOfDocPartListArray();
  
  void setDocPartListArray(CTSdtDocPart[] paramArrayOfCTSdtDocPart);
  
  void setDocPartListArray(int paramInt, CTSdtDocPart paramCTSdtDocPart);
  
  CTSdtDocPart insertNewDocPartList(int paramInt);
  
  CTSdtDocPart addNewDocPartList();
  
  void removeDocPartList(int paramInt);
  
  List<CTSdtDropDownList> getDropDownListList();
  
  CTSdtDropDownList[] getDropDownListArray();
  
  CTSdtDropDownList getDropDownListArray(int paramInt);
  
  int sizeOfDropDownListArray();
  
  void setDropDownListArray(CTSdtDropDownList[] paramArrayOfCTSdtDropDownList);
  
  void setDropDownListArray(int paramInt, CTSdtDropDownList paramCTSdtDropDownList);
  
  CTSdtDropDownList insertNewDropDownList(int paramInt);
  
  CTSdtDropDownList addNewDropDownList();
  
  void removeDropDownList(int paramInt);
  
  List<CTEmpty> getPictureList();
  
  CTEmpty[] getPictureArray();
  
  CTEmpty getPictureArray(int paramInt);
  
  int sizeOfPictureArray();
  
  void setPictureArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setPictureArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewPicture(int paramInt);
  
  CTEmpty addNewPicture();
  
  void removePicture(int paramInt);
  
  List<CTEmpty> getRichTextList();
  
  CTEmpty[] getRichTextArray();
  
  CTEmpty getRichTextArray(int paramInt);
  
  int sizeOfRichTextArray();
  
  void setRichTextArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setRichTextArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewRichText(int paramInt);
  
  CTEmpty addNewRichText();
  
  void removeRichText(int paramInt);
  
  List<CTSdtText> getTextList();
  
  CTSdtText[] getTextArray();
  
  CTSdtText getTextArray(int paramInt);
  
  int sizeOfTextArray();
  
  void setTextArray(CTSdtText[] paramArrayOfCTSdtText);
  
  void setTextArray(int paramInt, CTSdtText paramCTSdtText);
  
  CTSdtText insertNewText(int paramInt);
  
  CTSdtText addNewText();
  
  void removeText(int paramInt);
  
  List<CTEmpty> getCitationList();
  
  CTEmpty[] getCitationArray();
  
  CTEmpty getCitationArray(int paramInt);
  
  int sizeOfCitationArray();
  
  void setCitationArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setCitationArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewCitation(int paramInt);
  
  CTEmpty addNewCitation();
  
  void removeCitation(int paramInt);
  
  List<CTEmpty> getGroupList();
  
  CTEmpty[] getGroupArray();
  
  CTEmpty getGroupArray(int paramInt);
  
  int sizeOfGroupArray();
  
  void setGroupArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setGroupArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewGroup(int paramInt);
  
  CTEmpty addNewGroup();
  
  void removeGroup(int paramInt);
  
  List<CTEmpty> getBibliographyList();
  
  CTEmpty[] getBibliographyArray();
  
  CTEmpty getBibliographyArray(int paramInt);
  
  int sizeOfBibliographyArray();
  
  void setBibliographyArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setBibliographyArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewBibliography(int paramInt);
  
  CTEmpty addNewBibliography();
  
  void removeBibliography(int paramInt);
  
  public static final class Factory {
    public static CTSdtPr newInstance() {
      return (CTSdtPr)POIXMLTypeLoader.newInstance(CTSdtPr.type, null);
    }
    
    public static CTSdtPr newInstance(XmlOptions param1XmlOptions) {
      return (CTSdtPr)POIXMLTypeLoader.newInstance(CTSdtPr.type, param1XmlOptions);
    }
    
    public static CTSdtPr parse(String param1String) throws XmlException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1String, CTSdtPr.type, null);
    }
    
    public static CTSdtPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1String, CTSdtPr.type, param1XmlOptions);
    }
    
    public static CTSdtPr parse(File param1File) throws XmlException, IOException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1File, CTSdtPr.type, null);
    }
    
    public static CTSdtPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1File, CTSdtPr.type, param1XmlOptions);
    }
    
    public static CTSdtPr parse(URL param1URL) throws XmlException, IOException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1URL, CTSdtPr.type, null);
    }
    
    public static CTSdtPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1URL, CTSdtPr.type, param1XmlOptions);
    }
    
    public static CTSdtPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1InputStream, CTSdtPr.type, null);
    }
    
    public static CTSdtPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1InputStream, CTSdtPr.type, param1XmlOptions);
    }
    
    public static CTSdtPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1Reader, CTSdtPr.type, null);
    }
    
    public static CTSdtPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1Reader, CTSdtPr.type, param1XmlOptions);
    }
    
    public static CTSdtPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSdtPr.type, null);
    }
    
    public static CTSdtPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSdtPr.type, param1XmlOptions);
    }
    
    public static CTSdtPr parse(Node param1Node) throws XmlException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1Node, CTSdtPr.type, null);
    }
    
    public static CTSdtPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1Node, CTSdtPr.type, param1XmlOptions);
    }
    
    public static CTSdtPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSdtPr.type, null);
    }
    
    public static CTSdtPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSdtPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSdtPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSdtPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSdtPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTSdtPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */