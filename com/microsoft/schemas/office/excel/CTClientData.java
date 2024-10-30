package com.microsoft.schemas.office.excel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTClientData extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTClientData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctclientdata433btype");
  
  List<STTrueFalseBlank.Enum> getMoveWithCellsList();
  
  STTrueFalseBlank.Enum[] getMoveWithCellsArray();
  
  STTrueFalseBlank.Enum getMoveWithCellsArray(int paramInt);
  
  List<STTrueFalseBlank> xgetMoveWithCellsList();
  
  STTrueFalseBlank[] xgetMoveWithCellsArray();
  
  STTrueFalseBlank xgetMoveWithCellsArray(int paramInt);
  
  int sizeOfMoveWithCellsArray();
  
  void setMoveWithCellsArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setMoveWithCellsArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetMoveWithCellsArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetMoveWithCellsArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertMoveWithCells(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addMoveWithCells(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewMoveWithCells(int paramInt);
  
  STTrueFalseBlank addNewMoveWithCells();
  
  void removeMoveWithCells(int paramInt);
  
  List<STTrueFalseBlank.Enum> getSizeWithCellsList();
  
  STTrueFalseBlank.Enum[] getSizeWithCellsArray();
  
  STTrueFalseBlank.Enum getSizeWithCellsArray(int paramInt);
  
  List<STTrueFalseBlank> xgetSizeWithCellsList();
  
  STTrueFalseBlank[] xgetSizeWithCellsArray();
  
  STTrueFalseBlank xgetSizeWithCellsArray(int paramInt);
  
  int sizeOfSizeWithCellsArray();
  
  void setSizeWithCellsArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setSizeWithCellsArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetSizeWithCellsArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetSizeWithCellsArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertSizeWithCells(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addSizeWithCells(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewSizeWithCells(int paramInt);
  
  STTrueFalseBlank addNewSizeWithCells();
  
  void removeSizeWithCells(int paramInt);
  
  List<String> getAnchorList();
  
  String[] getAnchorArray();
  
  String getAnchorArray(int paramInt);
  
  List<XmlString> xgetAnchorList();
  
  XmlString[] xgetAnchorArray();
  
  XmlString xgetAnchorArray(int paramInt);
  
  int sizeOfAnchorArray();
  
  void setAnchorArray(String[] paramArrayOfString);
  
  void setAnchorArray(int paramInt, String paramString);
  
  void xsetAnchorArray(XmlString[] paramArrayOfXmlString);
  
  void xsetAnchorArray(int paramInt, XmlString paramXmlString);
  
  void insertAnchor(int paramInt, String paramString);
  
  void addAnchor(String paramString);
  
  XmlString insertNewAnchor(int paramInt);
  
  XmlString addNewAnchor();
  
  void removeAnchor(int paramInt);
  
  List<STTrueFalseBlank.Enum> getLockedList();
  
  STTrueFalseBlank.Enum[] getLockedArray();
  
  STTrueFalseBlank.Enum getLockedArray(int paramInt);
  
  List<STTrueFalseBlank> xgetLockedList();
  
  STTrueFalseBlank[] xgetLockedArray();
  
  STTrueFalseBlank xgetLockedArray(int paramInt);
  
  int sizeOfLockedArray();
  
  void setLockedArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setLockedArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetLockedArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetLockedArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertLocked(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addLocked(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewLocked(int paramInt);
  
  STTrueFalseBlank addNewLocked();
  
  void removeLocked(int paramInt);
  
  List<STTrueFalseBlank.Enum> getDefaultSizeList();
  
  STTrueFalseBlank.Enum[] getDefaultSizeArray();
  
  STTrueFalseBlank.Enum getDefaultSizeArray(int paramInt);
  
  List<STTrueFalseBlank> xgetDefaultSizeList();
  
  STTrueFalseBlank[] xgetDefaultSizeArray();
  
  STTrueFalseBlank xgetDefaultSizeArray(int paramInt);
  
  int sizeOfDefaultSizeArray();
  
  void setDefaultSizeArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setDefaultSizeArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetDefaultSizeArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetDefaultSizeArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertDefaultSize(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addDefaultSize(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewDefaultSize(int paramInt);
  
  STTrueFalseBlank addNewDefaultSize();
  
  void removeDefaultSize(int paramInt);
  
  List<STTrueFalseBlank.Enum> getPrintObjectList();
  
  STTrueFalseBlank.Enum[] getPrintObjectArray();
  
  STTrueFalseBlank.Enum getPrintObjectArray(int paramInt);
  
  List<STTrueFalseBlank> xgetPrintObjectList();
  
  STTrueFalseBlank[] xgetPrintObjectArray();
  
  STTrueFalseBlank xgetPrintObjectArray(int paramInt);
  
  int sizeOfPrintObjectArray();
  
  void setPrintObjectArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setPrintObjectArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetPrintObjectArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetPrintObjectArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertPrintObject(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addPrintObject(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewPrintObject(int paramInt);
  
  STTrueFalseBlank addNewPrintObject();
  
  void removePrintObject(int paramInt);
  
  List<STTrueFalseBlank.Enum> getDisabledList();
  
  STTrueFalseBlank.Enum[] getDisabledArray();
  
  STTrueFalseBlank.Enum getDisabledArray(int paramInt);
  
  List<STTrueFalseBlank> xgetDisabledList();
  
  STTrueFalseBlank[] xgetDisabledArray();
  
  STTrueFalseBlank xgetDisabledArray(int paramInt);
  
  int sizeOfDisabledArray();
  
  void setDisabledArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setDisabledArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetDisabledArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetDisabledArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertDisabled(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addDisabled(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewDisabled(int paramInt);
  
  STTrueFalseBlank addNewDisabled();
  
  void removeDisabled(int paramInt);
  
  List<STTrueFalseBlank.Enum> getAutoFillList();
  
  STTrueFalseBlank.Enum[] getAutoFillArray();
  
  STTrueFalseBlank.Enum getAutoFillArray(int paramInt);
  
  List<STTrueFalseBlank> xgetAutoFillList();
  
  STTrueFalseBlank[] xgetAutoFillArray();
  
  STTrueFalseBlank xgetAutoFillArray(int paramInt);
  
  int sizeOfAutoFillArray();
  
  void setAutoFillArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setAutoFillArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetAutoFillArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetAutoFillArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertAutoFill(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addAutoFill(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewAutoFill(int paramInt);
  
  STTrueFalseBlank addNewAutoFill();
  
  void removeAutoFill(int paramInt);
  
  List<STTrueFalseBlank.Enum> getAutoLineList();
  
  STTrueFalseBlank.Enum[] getAutoLineArray();
  
  STTrueFalseBlank.Enum getAutoLineArray(int paramInt);
  
  List<STTrueFalseBlank> xgetAutoLineList();
  
  STTrueFalseBlank[] xgetAutoLineArray();
  
  STTrueFalseBlank xgetAutoLineArray(int paramInt);
  
  int sizeOfAutoLineArray();
  
  void setAutoLineArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setAutoLineArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetAutoLineArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetAutoLineArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertAutoLine(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addAutoLine(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewAutoLine(int paramInt);
  
  STTrueFalseBlank addNewAutoLine();
  
  void removeAutoLine(int paramInt);
  
  List<STTrueFalseBlank.Enum> getAutoPictList();
  
  STTrueFalseBlank.Enum[] getAutoPictArray();
  
  STTrueFalseBlank.Enum getAutoPictArray(int paramInt);
  
  List<STTrueFalseBlank> xgetAutoPictList();
  
  STTrueFalseBlank[] xgetAutoPictArray();
  
  STTrueFalseBlank xgetAutoPictArray(int paramInt);
  
  int sizeOfAutoPictArray();
  
  void setAutoPictArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setAutoPictArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetAutoPictArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetAutoPictArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertAutoPict(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addAutoPict(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewAutoPict(int paramInt);
  
  STTrueFalseBlank addNewAutoPict();
  
  void removeAutoPict(int paramInt);
  
  List<String> getFmlaMacroList();
  
  String[] getFmlaMacroArray();
  
  String getFmlaMacroArray(int paramInt);
  
  List<XmlString> xgetFmlaMacroList();
  
  XmlString[] xgetFmlaMacroArray();
  
  XmlString xgetFmlaMacroArray(int paramInt);
  
  int sizeOfFmlaMacroArray();
  
  void setFmlaMacroArray(String[] paramArrayOfString);
  
  void setFmlaMacroArray(int paramInt, String paramString);
  
  void xsetFmlaMacroArray(XmlString[] paramArrayOfXmlString);
  
  void xsetFmlaMacroArray(int paramInt, XmlString paramXmlString);
  
  void insertFmlaMacro(int paramInt, String paramString);
  
  void addFmlaMacro(String paramString);
  
  XmlString insertNewFmlaMacro(int paramInt);
  
  XmlString addNewFmlaMacro();
  
  void removeFmlaMacro(int paramInt);
  
  List<String> getTextHAlignList();
  
  String[] getTextHAlignArray();
  
  String getTextHAlignArray(int paramInt);
  
  List<XmlString> xgetTextHAlignList();
  
  XmlString[] xgetTextHAlignArray();
  
  XmlString xgetTextHAlignArray(int paramInt);
  
  int sizeOfTextHAlignArray();
  
  void setTextHAlignArray(String[] paramArrayOfString);
  
  void setTextHAlignArray(int paramInt, String paramString);
  
  void xsetTextHAlignArray(XmlString[] paramArrayOfXmlString);
  
  void xsetTextHAlignArray(int paramInt, XmlString paramXmlString);
  
  void insertTextHAlign(int paramInt, String paramString);
  
  void addTextHAlign(String paramString);
  
  XmlString insertNewTextHAlign(int paramInt);
  
  XmlString addNewTextHAlign();
  
  void removeTextHAlign(int paramInt);
  
  List<String> getTextVAlignList();
  
  String[] getTextVAlignArray();
  
  String getTextVAlignArray(int paramInt);
  
  List<XmlString> xgetTextVAlignList();
  
  XmlString[] xgetTextVAlignArray();
  
  XmlString xgetTextVAlignArray(int paramInt);
  
  int sizeOfTextVAlignArray();
  
  void setTextVAlignArray(String[] paramArrayOfString);
  
  void setTextVAlignArray(int paramInt, String paramString);
  
  void xsetTextVAlignArray(XmlString[] paramArrayOfXmlString);
  
  void xsetTextVAlignArray(int paramInt, XmlString paramXmlString);
  
  void insertTextVAlign(int paramInt, String paramString);
  
  void addTextVAlign(String paramString);
  
  XmlString insertNewTextVAlign(int paramInt);
  
  XmlString addNewTextVAlign();
  
  void removeTextVAlign(int paramInt);
  
  List<STTrueFalseBlank.Enum> getLockTextList();
  
  STTrueFalseBlank.Enum[] getLockTextArray();
  
  STTrueFalseBlank.Enum getLockTextArray(int paramInt);
  
  List<STTrueFalseBlank> xgetLockTextList();
  
  STTrueFalseBlank[] xgetLockTextArray();
  
  STTrueFalseBlank xgetLockTextArray(int paramInt);
  
  int sizeOfLockTextArray();
  
  void setLockTextArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setLockTextArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetLockTextArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetLockTextArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertLockText(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addLockText(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewLockText(int paramInt);
  
  STTrueFalseBlank addNewLockText();
  
  void removeLockText(int paramInt);
  
  List<STTrueFalseBlank.Enum> getJustLastXList();
  
  STTrueFalseBlank.Enum[] getJustLastXArray();
  
  STTrueFalseBlank.Enum getJustLastXArray(int paramInt);
  
  List<STTrueFalseBlank> xgetJustLastXList();
  
  STTrueFalseBlank[] xgetJustLastXArray();
  
  STTrueFalseBlank xgetJustLastXArray(int paramInt);
  
  int sizeOfJustLastXArray();
  
  void setJustLastXArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setJustLastXArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetJustLastXArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetJustLastXArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertJustLastX(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addJustLastX(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewJustLastX(int paramInt);
  
  STTrueFalseBlank addNewJustLastX();
  
  void removeJustLastX(int paramInt);
  
  List<STTrueFalseBlank.Enum> getSecretEditList();
  
  STTrueFalseBlank.Enum[] getSecretEditArray();
  
  STTrueFalseBlank.Enum getSecretEditArray(int paramInt);
  
  List<STTrueFalseBlank> xgetSecretEditList();
  
  STTrueFalseBlank[] xgetSecretEditArray();
  
  STTrueFalseBlank xgetSecretEditArray(int paramInt);
  
  int sizeOfSecretEditArray();
  
  void setSecretEditArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setSecretEditArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetSecretEditArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetSecretEditArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertSecretEdit(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addSecretEdit(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewSecretEdit(int paramInt);
  
  STTrueFalseBlank addNewSecretEdit();
  
  void removeSecretEdit(int paramInt);
  
  List<STTrueFalseBlank.Enum> getDefaultList();
  
  STTrueFalseBlank.Enum[] getDefaultArray();
  
  STTrueFalseBlank.Enum getDefaultArray(int paramInt);
  
  List<STTrueFalseBlank> xgetDefaultList();
  
  STTrueFalseBlank[] xgetDefaultArray();
  
  STTrueFalseBlank xgetDefaultArray(int paramInt);
  
  int sizeOfDefaultArray();
  
  void setDefaultArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setDefaultArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetDefaultArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetDefaultArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertDefault(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addDefault(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewDefault(int paramInt);
  
  STTrueFalseBlank addNewDefault();
  
  void removeDefault(int paramInt);
  
  List<STTrueFalseBlank.Enum> getHelpList();
  
  STTrueFalseBlank.Enum[] getHelpArray();
  
  STTrueFalseBlank.Enum getHelpArray(int paramInt);
  
  List<STTrueFalseBlank> xgetHelpList();
  
  STTrueFalseBlank[] xgetHelpArray();
  
  STTrueFalseBlank xgetHelpArray(int paramInt);
  
  int sizeOfHelpArray();
  
  void setHelpArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setHelpArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetHelpArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetHelpArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertHelp(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addHelp(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewHelp(int paramInt);
  
  STTrueFalseBlank addNewHelp();
  
  void removeHelp(int paramInt);
  
  List<STTrueFalseBlank.Enum> getCancelList();
  
  STTrueFalseBlank.Enum[] getCancelArray();
  
  STTrueFalseBlank.Enum getCancelArray(int paramInt);
  
  List<STTrueFalseBlank> xgetCancelList();
  
  STTrueFalseBlank[] xgetCancelArray();
  
  STTrueFalseBlank xgetCancelArray(int paramInt);
  
  int sizeOfCancelArray();
  
  void setCancelArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setCancelArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetCancelArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetCancelArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertCancel(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addCancel(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewCancel(int paramInt);
  
  STTrueFalseBlank addNewCancel();
  
  void removeCancel(int paramInt);
  
  List<STTrueFalseBlank.Enum> getDismissList();
  
  STTrueFalseBlank.Enum[] getDismissArray();
  
  STTrueFalseBlank.Enum getDismissArray(int paramInt);
  
  List<STTrueFalseBlank> xgetDismissList();
  
  STTrueFalseBlank[] xgetDismissArray();
  
  STTrueFalseBlank xgetDismissArray(int paramInt);
  
  int sizeOfDismissArray();
  
  void setDismissArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setDismissArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetDismissArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetDismissArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertDismiss(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addDismiss(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewDismiss(int paramInt);
  
  STTrueFalseBlank addNewDismiss();
  
  void removeDismiss(int paramInt);
  
  List<BigInteger> getAccelList();
  
  BigInteger[] getAccelArray();
  
  BigInteger getAccelArray(int paramInt);
  
  List<XmlInteger> xgetAccelList();
  
  XmlInteger[] xgetAccelArray();
  
  XmlInteger xgetAccelArray(int paramInt);
  
  int sizeOfAccelArray();
  
  void setAccelArray(BigInteger[] paramArrayOfBigInteger);
  
  void setAccelArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetAccelArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetAccelArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertAccel(int paramInt, BigInteger paramBigInteger);
  
  void addAccel(BigInteger paramBigInteger);
  
  XmlInteger insertNewAccel(int paramInt);
  
  XmlInteger addNewAccel();
  
  void removeAccel(int paramInt);
  
  List<BigInteger> getAccel2List();
  
  BigInteger[] getAccel2Array();
  
  BigInteger getAccel2Array(int paramInt);
  
  List<XmlInteger> xgetAccel2List();
  
  XmlInteger[] xgetAccel2Array();
  
  XmlInteger xgetAccel2Array(int paramInt);
  
  int sizeOfAccel2Array();
  
  void setAccel2Array(BigInteger[] paramArrayOfBigInteger);
  
  void setAccel2Array(int paramInt, BigInteger paramBigInteger);
  
  void xsetAccel2Array(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetAccel2Array(int paramInt, XmlInteger paramXmlInteger);
  
  void insertAccel2(int paramInt, BigInteger paramBigInteger);
  
  void addAccel2(BigInteger paramBigInteger);
  
  XmlInteger insertNewAccel2(int paramInt);
  
  XmlInteger addNewAccel2();
  
  void removeAccel2(int paramInt);
  
  List<BigInteger> getRowList();
  
  BigInteger[] getRowArray();
  
  BigInteger getRowArray(int paramInt);
  
  List<XmlInteger> xgetRowList();
  
  XmlInteger[] xgetRowArray();
  
  XmlInteger xgetRowArray(int paramInt);
  
  int sizeOfRowArray();
  
  void setRowArray(BigInteger[] paramArrayOfBigInteger);
  
  void setRowArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetRowArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetRowArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertRow(int paramInt, BigInteger paramBigInteger);
  
  void addRow(BigInteger paramBigInteger);
  
  XmlInteger insertNewRow(int paramInt);
  
  XmlInteger addNewRow();
  
  void removeRow(int paramInt);
  
  List<BigInteger> getColumnList();
  
  BigInteger[] getColumnArray();
  
  BigInteger getColumnArray(int paramInt);
  
  List<XmlInteger> xgetColumnList();
  
  XmlInteger[] xgetColumnArray();
  
  XmlInteger xgetColumnArray(int paramInt);
  
  int sizeOfColumnArray();
  
  void setColumnArray(BigInteger[] paramArrayOfBigInteger);
  
  void setColumnArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetColumnArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetColumnArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertColumn(int paramInt, BigInteger paramBigInteger);
  
  void addColumn(BigInteger paramBigInteger);
  
  XmlInteger insertNewColumn(int paramInt);
  
  XmlInteger addNewColumn();
  
  void removeColumn(int paramInt);
  
  List<STTrueFalseBlank.Enum> getVisibleList();
  
  STTrueFalseBlank.Enum[] getVisibleArray();
  
  STTrueFalseBlank.Enum getVisibleArray(int paramInt);
  
  List<STTrueFalseBlank> xgetVisibleList();
  
  STTrueFalseBlank[] xgetVisibleArray();
  
  STTrueFalseBlank xgetVisibleArray(int paramInt);
  
  int sizeOfVisibleArray();
  
  void setVisibleArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setVisibleArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetVisibleArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetVisibleArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertVisible(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addVisible(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewVisible(int paramInt);
  
  STTrueFalseBlank addNewVisible();
  
  void removeVisible(int paramInt);
  
  List<STTrueFalseBlank.Enum> getRowHiddenList();
  
  STTrueFalseBlank.Enum[] getRowHiddenArray();
  
  STTrueFalseBlank.Enum getRowHiddenArray(int paramInt);
  
  List<STTrueFalseBlank> xgetRowHiddenList();
  
  STTrueFalseBlank[] xgetRowHiddenArray();
  
  STTrueFalseBlank xgetRowHiddenArray(int paramInt);
  
  int sizeOfRowHiddenArray();
  
  void setRowHiddenArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setRowHiddenArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetRowHiddenArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetRowHiddenArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertRowHidden(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addRowHidden(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewRowHidden(int paramInt);
  
  STTrueFalseBlank addNewRowHidden();
  
  void removeRowHidden(int paramInt);
  
  List<STTrueFalseBlank.Enum> getColHiddenList();
  
  STTrueFalseBlank.Enum[] getColHiddenArray();
  
  STTrueFalseBlank.Enum getColHiddenArray(int paramInt);
  
  List<STTrueFalseBlank> xgetColHiddenList();
  
  STTrueFalseBlank[] xgetColHiddenArray();
  
  STTrueFalseBlank xgetColHiddenArray(int paramInt);
  
  int sizeOfColHiddenArray();
  
  void setColHiddenArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setColHiddenArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetColHiddenArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetColHiddenArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertColHidden(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addColHidden(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewColHidden(int paramInt);
  
  STTrueFalseBlank addNewColHidden();
  
  void removeColHidden(int paramInt);
  
  List<BigInteger> getVTEditList();
  
  BigInteger[] getVTEditArray();
  
  BigInteger getVTEditArray(int paramInt);
  
  List<XmlInteger> xgetVTEditList();
  
  XmlInteger[] xgetVTEditArray();
  
  XmlInteger xgetVTEditArray(int paramInt);
  
  int sizeOfVTEditArray();
  
  void setVTEditArray(BigInteger[] paramArrayOfBigInteger);
  
  void setVTEditArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetVTEditArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetVTEditArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertVTEdit(int paramInt, BigInteger paramBigInteger);
  
  void addVTEdit(BigInteger paramBigInteger);
  
  XmlInteger insertNewVTEdit(int paramInt);
  
  XmlInteger addNewVTEdit();
  
  void removeVTEdit(int paramInt);
  
  List<STTrueFalseBlank.Enum> getMultiLineList();
  
  STTrueFalseBlank.Enum[] getMultiLineArray();
  
  STTrueFalseBlank.Enum getMultiLineArray(int paramInt);
  
  List<STTrueFalseBlank> xgetMultiLineList();
  
  STTrueFalseBlank[] xgetMultiLineArray();
  
  STTrueFalseBlank xgetMultiLineArray(int paramInt);
  
  int sizeOfMultiLineArray();
  
  void setMultiLineArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setMultiLineArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetMultiLineArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetMultiLineArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertMultiLine(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addMultiLine(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewMultiLine(int paramInt);
  
  STTrueFalseBlank addNewMultiLine();
  
  void removeMultiLine(int paramInt);
  
  List<STTrueFalseBlank.Enum> getVScrollList();
  
  STTrueFalseBlank.Enum[] getVScrollArray();
  
  STTrueFalseBlank.Enum getVScrollArray(int paramInt);
  
  List<STTrueFalseBlank> xgetVScrollList();
  
  STTrueFalseBlank[] xgetVScrollArray();
  
  STTrueFalseBlank xgetVScrollArray(int paramInt);
  
  int sizeOfVScrollArray();
  
  void setVScrollArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setVScrollArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetVScrollArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetVScrollArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertVScroll(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addVScroll(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewVScroll(int paramInt);
  
  STTrueFalseBlank addNewVScroll();
  
  void removeVScroll(int paramInt);
  
  List<STTrueFalseBlank.Enum> getValidIdsList();
  
  STTrueFalseBlank.Enum[] getValidIdsArray();
  
  STTrueFalseBlank.Enum getValidIdsArray(int paramInt);
  
  List<STTrueFalseBlank> xgetValidIdsList();
  
  STTrueFalseBlank[] xgetValidIdsArray();
  
  STTrueFalseBlank xgetValidIdsArray(int paramInt);
  
  int sizeOfValidIdsArray();
  
  void setValidIdsArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setValidIdsArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetValidIdsArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetValidIdsArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertValidIds(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addValidIds(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewValidIds(int paramInt);
  
  STTrueFalseBlank addNewValidIds();
  
  void removeValidIds(int paramInt);
  
  List<String> getFmlaRangeList();
  
  String[] getFmlaRangeArray();
  
  String getFmlaRangeArray(int paramInt);
  
  List<XmlString> xgetFmlaRangeList();
  
  XmlString[] xgetFmlaRangeArray();
  
  XmlString xgetFmlaRangeArray(int paramInt);
  
  int sizeOfFmlaRangeArray();
  
  void setFmlaRangeArray(String[] paramArrayOfString);
  
  void setFmlaRangeArray(int paramInt, String paramString);
  
  void xsetFmlaRangeArray(XmlString[] paramArrayOfXmlString);
  
  void xsetFmlaRangeArray(int paramInt, XmlString paramXmlString);
  
  void insertFmlaRange(int paramInt, String paramString);
  
  void addFmlaRange(String paramString);
  
  XmlString insertNewFmlaRange(int paramInt);
  
  XmlString addNewFmlaRange();
  
  void removeFmlaRange(int paramInt);
  
  List<BigInteger> getWidthMinList();
  
  BigInteger[] getWidthMinArray();
  
  BigInteger getWidthMinArray(int paramInt);
  
  List<XmlInteger> xgetWidthMinList();
  
  XmlInteger[] xgetWidthMinArray();
  
  XmlInteger xgetWidthMinArray(int paramInt);
  
  int sizeOfWidthMinArray();
  
  void setWidthMinArray(BigInteger[] paramArrayOfBigInteger);
  
  void setWidthMinArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetWidthMinArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetWidthMinArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertWidthMin(int paramInt, BigInteger paramBigInteger);
  
  void addWidthMin(BigInteger paramBigInteger);
  
  XmlInteger insertNewWidthMin(int paramInt);
  
  XmlInteger addNewWidthMin();
  
  void removeWidthMin(int paramInt);
  
  List<BigInteger> getSelList();
  
  BigInteger[] getSelArray();
  
  BigInteger getSelArray(int paramInt);
  
  List<XmlInteger> xgetSelList();
  
  XmlInteger[] xgetSelArray();
  
  XmlInteger xgetSelArray(int paramInt);
  
  int sizeOfSelArray();
  
  void setSelArray(BigInteger[] paramArrayOfBigInteger);
  
  void setSelArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetSelArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetSelArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertSel(int paramInt, BigInteger paramBigInteger);
  
  void addSel(BigInteger paramBigInteger);
  
  XmlInteger insertNewSel(int paramInt);
  
  XmlInteger addNewSel();
  
  void removeSel(int paramInt);
  
  List<STTrueFalseBlank.Enum> getNoThreeD2List();
  
  STTrueFalseBlank.Enum[] getNoThreeD2Array();
  
  STTrueFalseBlank.Enum getNoThreeD2Array(int paramInt);
  
  List<STTrueFalseBlank> xgetNoThreeD2List();
  
  STTrueFalseBlank[] xgetNoThreeD2Array();
  
  STTrueFalseBlank xgetNoThreeD2Array(int paramInt);
  
  int sizeOfNoThreeD2Array();
  
  void setNoThreeD2Array(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setNoThreeD2Array(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetNoThreeD2Array(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetNoThreeD2Array(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertNoThreeD2(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addNoThreeD2(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewNoThreeD2(int paramInt);
  
  STTrueFalseBlank addNewNoThreeD2();
  
  void removeNoThreeD2(int paramInt);
  
  List<String> getSelTypeList();
  
  String[] getSelTypeArray();
  
  String getSelTypeArray(int paramInt);
  
  List<XmlString> xgetSelTypeList();
  
  XmlString[] xgetSelTypeArray();
  
  XmlString xgetSelTypeArray(int paramInt);
  
  int sizeOfSelTypeArray();
  
  void setSelTypeArray(String[] paramArrayOfString);
  
  void setSelTypeArray(int paramInt, String paramString);
  
  void xsetSelTypeArray(XmlString[] paramArrayOfXmlString);
  
  void xsetSelTypeArray(int paramInt, XmlString paramXmlString);
  
  void insertSelType(int paramInt, String paramString);
  
  void addSelType(String paramString);
  
  XmlString insertNewSelType(int paramInt);
  
  XmlString addNewSelType();
  
  void removeSelType(int paramInt);
  
  List<String> getMultiSelList();
  
  String[] getMultiSelArray();
  
  String getMultiSelArray(int paramInt);
  
  List<XmlString> xgetMultiSelList();
  
  XmlString[] xgetMultiSelArray();
  
  XmlString xgetMultiSelArray(int paramInt);
  
  int sizeOfMultiSelArray();
  
  void setMultiSelArray(String[] paramArrayOfString);
  
  void setMultiSelArray(int paramInt, String paramString);
  
  void xsetMultiSelArray(XmlString[] paramArrayOfXmlString);
  
  void xsetMultiSelArray(int paramInt, XmlString paramXmlString);
  
  void insertMultiSel(int paramInt, String paramString);
  
  void addMultiSel(String paramString);
  
  XmlString insertNewMultiSel(int paramInt);
  
  XmlString addNewMultiSel();
  
  void removeMultiSel(int paramInt);
  
  List<String> getLCTList();
  
  String[] getLCTArray();
  
  String getLCTArray(int paramInt);
  
  List<XmlString> xgetLCTList();
  
  XmlString[] xgetLCTArray();
  
  XmlString xgetLCTArray(int paramInt);
  
  int sizeOfLCTArray();
  
  void setLCTArray(String[] paramArrayOfString);
  
  void setLCTArray(int paramInt, String paramString);
  
  void xsetLCTArray(XmlString[] paramArrayOfXmlString);
  
  void xsetLCTArray(int paramInt, XmlString paramXmlString);
  
  void insertLCT(int paramInt, String paramString);
  
  void addLCT(String paramString);
  
  XmlString insertNewLCT(int paramInt);
  
  XmlString addNewLCT();
  
  void removeLCT(int paramInt);
  
  List<String> getListItemList();
  
  String[] getListItemArray();
  
  String getListItemArray(int paramInt);
  
  List<XmlString> xgetListItemList();
  
  XmlString[] xgetListItemArray();
  
  XmlString xgetListItemArray(int paramInt);
  
  int sizeOfListItemArray();
  
  void setListItemArray(String[] paramArrayOfString);
  
  void setListItemArray(int paramInt, String paramString);
  
  void xsetListItemArray(XmlString[] paramArrayOfXmlString);
  
  void xsetListItemArray(int paramInt, XmlString paramXmlString);
  
  void insertListItem(int paramInt, String paramString);
  
  void addListItem(String paramString);
  
  XmlString insertNewListItem(int paramInt);
  
  XmlString addNewListItem();
  
  void removeListItem(int paramInt);
  
  List<String> getDropStyleList();
  
  String[] getDropStyleArray();
  
  String getDropStyleArray(int paramInt);
  
  List<XmlString> xgetDropStyleList();
  
  XmlString[] xgetDropStyleArray();
  
  XmlString xgetDropStyleArray(int paramInt);
  
  int sizeOfDropStyleArray();
  
  void setDropStyleArray(String[] paramArrayOfString);
  
  void setDropStyleArray(int paramInt, String paramString);
  
  void xsetDropStyleArray(XmlString[] paramArrayOfXmlString);
  
  void xsetDropStyleArray(int paramInt, XmlString paramXmlString);
  
  void insertDropStyle(int paramInt, String paramString);
  
  void addDropStyle(String paramString);
  
  XmlString insertNewDropStyle(int paramInt);
  
  XmlString addNewDropStyle();
  
  void removeDropStyle(int paramInt);
  
  List<STTrueFalseBlank.Enum> getColoredList();
  
  STTrueFalseBlank.Enum[] getColoredArray();
  
  STTrueFalseBlank.Enum getColoredArray(int paramInt);
  
  List<STTrueFalseBlank> xgetColoredList();
  
  STTrueFalseBlank[] xgetColoredArray();
  
  STTrueFalseBlank xgetColoredArray(int paramInt);
  
  int sizeOfColoredArray();
  
  void setColoredArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setColoredArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetColoredArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetColoredArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertColored(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addColored(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewColored(int paramInt);
  
  STTrueFalseBlank addNewColored();
  
  void removeColored(int paramInt);
  
  List<BigInteger> getDropLinesList();
  
  BigInteger[] getDropLinesArray();
  
  BigInteger getDropLinesArray(int paramInt);
  
  List<XmlInteger> xgetDropLinesList();
  
  XmlInteger[] xgetDropLinesArray();
  
  XmlInteger xgetDropLinesArray(int paramInt);
  
  int sizeOfDropLinesArray();
  
  void setDropLinesArray(BigInteger[] paramArrayOfBigInteger);
  
  void setDropLinesArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetDropLinesArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetDropLinesArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertDropLines(int paramInt, BigInteger paramBigInteger);
  
  void addDropLines(BigInteger paramBigInteger);
  
  XmlInteger insertNewDropLines(int paramInt);
  
  XmlInteger addNewDropLines();
  
  void removeDropLines(int paramInt);
  
  List<BigInteger> getCheckedList();
  
  BigInteger[] getCheckedArray();
  
  BigInteger getCheckedArray(int paramInt);
  
  List<XmlInteger> xgetCheckedList();
  
  XmlInteger[] xgetCheckedArray();
  
  XmlInteger xgetCheckedArray(int paramInt);
  
  int sizeOfCheckedArray();
  
  void setCheckedArray(BigInteger[] paramArrayOfBigInteger);
  
  void setCheckedArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetCheckedArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetCheckedArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertChecked(int paramInt, BigInteger paramBigInteger);
  
  void addChecked(BigInteger paramBigInteger);
  
  XmlInteger insertNewChecked(int paramInt);
  
  XmlInteger addNewChecked();
  
  void removeChecked(int paramInt);
  
  List<String> getFmlaLinkList();
  
  String[] getFmlaLinkArray();
  
  String getFmlaLinkArray(int paramInt);
  
  List<XmlString> xgetFmlaLinkList();
  
  XmlString[] xgetFmlaLinkArray();
  
  XmlString xgetFmlaLinkArray(int paramInt);
  
  int sizeOfFmlaLinkArray();
  
  void setFmlaLinkArray(String[] paramArrayOfString);
  
  void setFmlaLinkArray(int paramInt, String paramString);
  
  void xsetFmlaLinkArray(XmlString[] paramArrayOfXmlString);
  
  void xsetFmlaLinkArray(int paramInt, XmlString paramXmlString);
  
  void insertFmlaLink(int paramInt, String paramString);
  
  void addFmlaLink(String paramString);
  
  XmlString insertNewFmlaLink(int paramInt);
  
  XmlString addNewFmlaLink();
  
  void removeFmlaLink(int paramInt);
  
  List<String> getFmlaPictList();
  
  String[] getFmlaPictArray();
  
  String getFmlaPictArray(int paramInt);
  
  List<XmlString> xgetFmlaPictList();
  
  XmlString[] xgetFmlaPictArray();
  
  XmlString xgetFmlaPictArray(int paramInt);
  
  int sizeOfFmlaPictArray();
  
  void setFmlaPictArray(String[] paramArrayOfString);
  
  void setFmlaPictArray(int paramInt, String paramString);
  
  void xsetFmlaPictArray(XmlString[] paramArrayOfXmlString);
  
  void xsetFmlaPictArray(int paramInt, XmlString paramXmlString);
  
  void insertFmlaPict(int paramInt, String paramString);
  
  void addFmlaPict(String paramString);
  
  XmlString insertNewFmlaPict(int paramInt);
  
  XmlString addNewFmlaPict();
  
  void removeFmlaPict(int paramInt);
  
  List<STTrueFalseBlank.Enum> getNoThreeDList();
  
  STTrueFalseBlank.Enum[] getNoThreeDArray();
  
  STTrueFalseBlank.Enum getNoThreeDArray(int paramInt);
  
  List<STTrueFalseBlank> xgetNoThreeDList();
  
  STTrueFalseBlank[] xgetNoThreeDArray();
  
  STTrueFalseBlank xgetNoThreeDArray(int paramInt);
  
  int sizeOfNoThreeDArray();
  
  void setNoThreeDArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setNoThreeDArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetNoThreeDArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetNoThreeDArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertNoThreeD(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addNoThreeD(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewNoThreeD(int paramInt);
  
  STTrueFalseBlank addNewNoThreeD();
  
  void removeNoThreeD(int paramInt);
  
  List<STTrueFalseBlank.Enum> getFirstButtonList();
  
  STTrueFalseBlank.Enum[] getFirstButtonArray();
  
  STTrueFalseBlank.Enum getFirstButtonArray(int paramInt);
  
  List<STTrueFalseBlank> xgetFirstButtonList();
  
  STTrueFalseBlank[] xgetFirstButtonArray();
  
  STTrueFalseBlank xgetFirstButtonArray(int paramInt);
  
  int sizeOfFirstButtonArray();
  
  void setFirstButtonArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setFirstButtonArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetFirstButtonArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetFirstButtonArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertFirstButton(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addFirstButton(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewFirstButton(int paramInt);
  
  STTrueFalseBlank addNewFirstButton();
  
  void removeFirstButton(int paramInt);
  
  List<String> getFmlaGroupList();
  
  String[] getFmlaGroupArray();
  
  String getFmlaGroupArray(int paramInt);
  
  List<XmlString> xgetFmlaGroupList();
  
  XmlString[] xgetFmlaGroupArray();
  
  XmlString xgetFmlaGroupArray(int paramInt);
  
  int sizeOfFmlaGroupArray();
  
  void setFmlaGroupArray(String[] paramArrayOfString);
  
  void setFmlaGroupArray(int paramInt, String paramString);
  
  void xsetFmlaGroupArray(XmlString[] paramArrayOfXmlString);
  
  void xsetFmlaGroupArray(int paramInt, XmlString paramXmlString);
  
  void insertFmlaGroup(int paramInt, String paramString);
  
  void addFmlaGroup(String paramString);
  
  XmlString insertNewFmlaGroup(int paramInt);
  
  XmlString addNewFmlaGroup();
  
  void removeFmlaGroup(int paramInt);
  
  List<BigInteger> getValList();
  
  BigInteger[] getValArray();
  
  BigInteger getValArray(int paramInt);
  
  List<XmlInteger> xgetValList();
  
  XmlInteger[] xgetValArray();
  
  XmlInteger xgetValArray(int paramInt);
  
  int sizeOfValArray();
  
  void setValArray(BigInteger[] paramArrayOfBigInteger);
  
  void setValArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetValArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetValArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertVal(int paramInt, BigInteger paramBigInteger);
  
  void addVal(BigInteger paramBigInteger);
  
  XmlInteger insertNewVal(int paramInt);
  
  XmlInteger addNewVal();
  
  void removeVal(int paramInt);
  
  List<BigInteger> getMinList();
  
  BigInteger[] getMinArray();
  
  BigInteger getMinArray(int paramInt);
  
  List<XmlInteger> xgetMinList();
  
  XmlInteger[] xgetMinArray();
  
  XmlInteger xgetMinArray(int paramInt);
  
  int sizeOfMinArray();
  
  void setMinArray(BigInteger[] paramArrayOfBigInteger);
  
  void setMinArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetMinArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetMinArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertMin(int paramInt, BigInteger paramBigInteger);
  
  void addMin(BigInteger paramBigInteger);
  
  XmlInteger insertNewMin(int paramInt);
  
  XmlInteger addNewMin();
  
  void removeMin(int paramInt);
  
  List<BigInteger> getMaxList();
  
  BigInteger[] getMaxArray();
  
  BigInteger getMaxArray(int paramInt);
  
  List<XmlInteger> xgetMaxList();
  
  XmlInteger[] xgetMaxArray();
  
  XmlInteger xgetMaxArray(int paramInt);
  
  int sizeOfMaxArray();
  
  void setMaxArray(BigInteger[] paramArrayOfBigInteger);
  
  void setMaxArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetMaxArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetMaxArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertMax(int paramInt, BigInteger paramBigInteger);
  
  void addMax(BigInteger paramBigInteger);
  
  XmlInteger insertNewMax(int paramInt);
  
  XmlInteger addNewMax();
  
  void removeMax(int paramInt);
  
  List<BigInteger> getIncList();
  
  BigInteger[] getIncArray();
  
  BigInteger getIncArray(int paramInt);
  
  List<XmlInteger> xgetIncList();
  
  XmlInteger[] xgetIncArray();
  
  XmlInteger xgetIncArray(int paramInt);
  
  int sizeOfIncArray();
  
  void setIncArray(BigInteger[] paramArrayOfBigInteger);
  
  void setIncArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetIncArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetIncArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertInc(int paramInt, BigInteger paramBigInteger);
  
  void addInc(BigInteger paramBigInteger);
  
  XmlInteger insertNewInc(int paramInt);
  
  XmlInteger addNewInc();
  
  void removeInc(int paramInt);
  
  List<BigInteger> getPageList();
  
  BigInteger[] getPageArray();
  
  BigInteger getPageArray(int paramInt);
  
  List<XmlInteger> xgetPageList();
  
  XmlInteger[] xgetPageArray();
  
  XmlInteger xgetPageArray(int paramInt);
  
  int sizeOfPageArray();
  
  void setPageArray(BigInteger[] paramArrayOfBigInteger);
  
  void setPageArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetPageArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetPageArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertPage(int paramInt, BigInteger paramBigInteger);
  
  void addPage(BigInteger paramBigInteger);
  
  XmlInteger insertNewPage(int paramInt);
  
  XmlInteger addNewPage();
  
  void removePage(int paramInt);
  
  List<STTrueFalseBlank.Enum> getHorizList();
  
  STTrueFalseBlank.Enum[] getHorizArray();
  
  STTrueFalseBlank.Enum getHorizArray(int paramInt);
  
  List<STTrueFalseBlank> xgetHorizList();
  
  STTrueFalseBlank[] xgetHorizArray();
  
  STTrueFalseBlank xgetHorizArray(int paramInt);
  
  int sizeOfHorizArray();
  
  void setHorizArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setHorizArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetHorizArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetHorizArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertHoriz(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addHoriz(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewHoriz(int paramInt);
  
  STTrueFalseBlank addNewHoriz();
  
  void removeHoriz(int paramInt);
  
  List<BigInteger> getDxList();
  
  BigInteger[] getDxArray();
  
  BigInteger getDxArray(int paramInt);
  
  List<XmlInteger> xgetDxList();
  
  XmlInteger[] xgetDxArray();
  
  XmlInteger xgetDxArray(int paramInt);
  
  int sizeOfDxArray();
  
  void setDxArray(BigInteger[] paramArrayOfBigInteger);
  
  void setDxArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetDxArray(XmlInteger[] paramArrayOfXmlInteger);
  
  void xsetDxArray(int paramInt, XmlInteger paramXmlInteger);
  
  void insertDx(int paramInt, BigInteger paramBigInteger);
  
  void addDx(BigInteger paramBigInteger);
  
  XmlInteger insertNewDx(int paramInt);
  
  XmlInteger addNewDx();
  
  void removeDx(int paramInt);
  
  List<STTrueFalseBlank.Enum> getMapOCXList();
  
  STTrueFalseBlank.Enum[] getMapOCXArray();
  
  STTrueFalseBlank.Enum getMapOCXArray(int paramInt);
  
  List<STTrueFalseBlank> xgetMapOCXList();
  
  STTrueFalseBlank[] xgetMapOCXArray();
  
  STTrueFalseBlank xgetMapOCXArray(int paramInt);
  
  int sizeOfMapOCXArray();
  
  void setMapOCXArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setMapOCXArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetMapOCXArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetMapOCXArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertMapOCX(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addMapOCX(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewMapOCX(int paramInt);
  
  STTrueFalseBlank addNewMapOCX();
  
  void removeMapOCX(int paramInt);
  
  List<STCF$Enum> getCFList();
  
  STCF$Enum[] getCFArray();
  
  STCF$Enum getCFArray(int paramInt);
  
  List<STCF> xgetCFList();
  
  STCF[] xgetCFArray();
  
  STCF xgetCFArray(int paramInt);
  
  int sizeOfCFArray();
  
  void setCFArray(STCF$Enum[] paramArrayOfSTCF$Enum);
  
  void setCFArray(int paramInt, STCF$Enum paramSTCF$Enum);
  
  void xsetCFArray(STCF[] paramArrayOfSTCF);
  
  void xsetCFArray(int paramInt, STCF paramSTCF);
  
  void insertCF(int paramInt, STCF$Enum paramSTCF$Enum);
  
  void addCF(STCF$Enum paramSTCF$Enum);
  
  STCF insertNewCF(int paramInt);
  
  STCF addNewCF();
  
  void removeCF(int paramInt);
  
  List<STTrueFalseBlank.Enum> getCameraList();
  
  STTrueFalseBlank.Enum[] getCameraArray();
  
  STTrueFalseBlank.Enum getCameraArray(int paramInt);
  
  List<STTrueFalseBlank> xgetCameraList();
  
  STTrueFalseBlank[] xgetCameraArray();
  
  STTrueFalseBlank xgetCameraArray(int paramInt);
  
  int sizeOfCameraArray();
  
  void setCameraArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setCameraArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetCameraArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetCameraArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertCamera(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addCamera(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewCamera(int paramInt);
  
  STTrueFalseBlank addNewCamera();
  
  void removeCamera(int paramInt);
  
  List<STTrueFalseBlank.Enum> getRecalcAlwaysList();
  
  STTrueFalseBlank.Enum[] getRecalcAlwaysArray();
  
  STTrueFalseBlank.Enum getRecalcAlwaysArray(int paramInt);
  
  List<STTrueFalseBlank> xgetRecalcAlwaysList();
  
  STTrueFalseBlank[] xgetRecalcAlwaysArray();
  
  STTrueFalseBlank xgetRecalcAlwaysArray(int paramInt);
  
  int sizeOfRecalcAlwaysArray();
  
  void setRecalcAlwaysArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setRecalcAlwaysArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetRecalcAlwaysArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetRecalcAlwaysArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertRecalcAlways(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addRecalcAlways(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewRecalcAlways(int paramInt);
  
  STTrueFalseBlank addNewRecalcAlways();
  
  void removeRecalcAlways(int paramInt);
  
  List<STTrueFalseBlank.Enum> getAutoScaleList();
  
  STTrueFalseBlank.Enum[] getAutoScaleArray();
  
  STTrueFalseBlank.Enum getAutoScaleArray(int paramInt);
  
  List<STTrueFalseBlank> xgetAutoScaleList();
  
  STTrueFalseBlank[] xgetAutoScaleArray();
  
  STTrueFalseBlank xgetAutoScaleArray(int paramInt);
  
  int sizeOfAutoScaleArray();
  
  void setAutoScaleArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setAutoScaleArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetAutoScaleArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetAutoScaleArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertAutoScale(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addAutoScale(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewAutoScale(int paramInt);
  
  STTrueFalseBlank addNewAutoScale();
  
  void removeAutoScale(int paramInt);
  
  List<STTrueFalseBlank.Enum> getDDEList();
  
  STTrueFalseBlank.Enum[] getDDEArray();
  
  STTrueFalseBlank.Enum getDDEArray(int paramInt);
  
  List<STTrueFalseBlank> xgetDDEList();
  
  STTrueFalseBlank[] xgetDDEArray();
  
  STTrueFalseBlank xgetDDEArray(int paramInt);
  
  int sizeOfDDEArray();
  
  void setDDEArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setDDEArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetDDEArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetDDEArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertDDE(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addDDE(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewDDE(int paramInt);
  
  STTrueFalseBlank addNewDDE();
  
  void removeDDE(int paramInt);
  
  List<STTrueFalseBlank.Enum> getUIObjList();
  
  STTrueFalseBlank.Enum[] getUIObjArray();
  
  STTrueFalseBlank.Enum getUIObjArray(int paramInt);
  
  List<STTrueFalseBlank> xgetUIObjList();
  
  STTrueFalseBlank[] xgetUIObjArray();
  
  STTrueFalseBlank xgetUIObjArray(int paramInt);
  
  int sizeOfUIObjArray();
  
  void setUIObjArray(STTrueFalseBlank.Enum[] paramArrayOfEnum);
  
  void setUIObjArray(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void xsetUIObjArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank);
  
  void xsetUIObjArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank);
  
  void insertUIObj(int paramInt, STTrueFalseBlank.Enum paramEnum);
  
  void addUIObj(STTrueFalseBlank.Enum paramEnum);
  
  STTrueFalseBlank insertNewUIObj(int paramInt);
  
  STTrueFalseBlank addNewUIObj();
  
  void removeUIObj(int paramInt);
  
  List<String> getScriptTextList();
  
  String[] getScriptTextArray();
  
  String getScriptTextArray(int paramInt);
  
  List<XmlString> xgetScriptTextList();
  
  XmlString[] xgetScriptTextArray();
  
  XmlString xgetScriptTextArray(int paramInt);
  
  int sizeOfScriptTextArray();
  
  void setScriptTextArray(String[] paramArrayOfString);
  
  void setScriptTextArray(int paramInt, String paramString);
  
  void xsetScriptTextArray(XmlString[] paramArrayOfXmlString);
  
  void xsetScriptTextArray(int paramInt, XmlString paramXmlString);
  
  void insertScriptText(int paramInt, String paramString);
  
  void addScriptText(String paramString);
  
  XmlString insertNewScriptText(int paramInt);
  
  XmlString addNewScriptText();
  
  void removeScriptText(int paramInt);
  
  List<String> getScriptExtendedList();
  
  String[] getScriptExtendedArray();
  
  String getScriptExtendedArray(int paramInt);
  
  List<XmlString> xgetScriptExtendedList();
  
  XmlString[] xgetScriptExtendedArray();
  
  XmlString xgetScriptExtendedArray(int paramInt);
  
  int sizeOfScriptExtendedArray();
  
  void setScriptExtendedArray(String[] paramArrayOfString);
  
  void setScriptExtendedArray(int paramInt, String paramString);
  
  void xsetScriptExtendedArray(XmlString[] paramArrayOfXmlString);
  
  void xsetScriptExtendedArray(int paramInt, XmlString paramXmlString);
  
  void insertScriptExtended(int paramInt, String paramString);
  
  void addScriptExtended(String paramString);
  
  XmlString insertNewScriptExtended(int paramInt);
  
  XmlString addNewScriptExtended();
  
  void removeScriptExtended(int paramInt);
  
  List<BigInteger> getScriptLanguageList();
  
  BigInteger[] getScriptLanguageArray();
  
  BigInteger getScriptLanguageArray(int paramInt);
  
  List<XmlNonNegativeInteger> xgetScriptLanguageList();
  
  XmlNonNegativeInteger[] xgetScriptLanguageArray();
  
  XmlNonNegativeInteger xgetScriptLanguageArray(int paramInt);
  
  int sizeOfScriptLanguageArray();
  
  void setScriptLanguageArray(BigInteger[] paramArrayOfBigInteger);
  
  void setScriptLanguageArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetScriptLanguageArray(XmlNonNegativeInteger[] paramArrayOfXmlNonNegativeInteger);
  
  void xsetScriptLanguageArray(int paramInt, XmlNonNegativeInteger paramXmlNonNegativeInteger);
  
  void insertScriptLanguage(int paramInt, BigInteger paramBigInteger);
  
  void addScriptLanguage(BigInteger paramBigInteger);
  
  XmlNonNegativeInteger insertNewScriptLanguage(int paramInt);
  
  XmlNonNegativeInteger addNewScriptLanguage();
  
  void removeScriptLanguage(int paramInt);
  
  List<BigInteger> getScriptLocationList();
  
  BigInteger[] getScriptLocationArray();
  
  BigInteger getScriptLocationArray(int paramInt);
  
  List<XmlNonNegativeInteger> xgetScriptLocationList();
  
  XmlNonNegativeInteger[] xgetScriptLocationArray();
  
  XmlNonNegativeInteger xgetScriptLocationArray(int paramInt);
  
  int sizeOfScriptLocationArray();
  
  void setScriptLocationArray(BigInteger[] paramArrayOfBigInteger);
  
  void setScriptLocationArray(int paramInt, BigInteger paramBigInteger);
  
  void xsetScriptLocationArray(XmlNonNegativeInteger[] paramArrayOfXmlNonNegativeInteger);
  
  void xsetScriptLocationArray(int paramInt, XmlNonNegativeInteger paramXmlNonNegativeInteger);
  
  void insertScriptLocation(int paramInt, BigInteger paramBigInteger);
  
  void addScriptLocation(BigInteger paramBigInteger);
  
  XmlNonNegativeInteger insertNewScriptLocation(int paramInt);
  
  XmlNonNegativeInteger addNewScriptLocation();
  
  void removeScriptLocation(int paramInt);
  
  List<String> getFmlaTxbxList();
  
  String[] getFmlaTxbxArray();
  
  String getFmlaTxbxArray(int paramInt);
  
  List<XmlString> xgetFmlaTxbxList();
  
  XmlString[] xgetFmlaTxbxArray();
  
  XmlString xgetFmlaTxbxArray(int paramInt);
  
  int sizeOfFmlaTxbxArray();
  
  void setFmlaTxbxArray(String[] paramArrayOfString);
  
  void setFmlaTxbxArray(int paramInt, String paramString);
  
  void xsetFmlaTxbxArray(XmlString[] paramArrayOfXmlString);
  
  void xsetFmlaTxbxArray(int paramInt, XmlString paramXmlString);
  
  void insertFmlaTxbx(int paramInt, String paramString);
  
  void addFmlaTxbx(String paramString);
  
  XmlString insertNewFmlaTxbx(int paramInt);
  
  XmlString addNewFmlaTxbx();
  
  void removeFmlaTxbx(int paramInt);
  
  STObjectType.Enum getObjectType();
  
  STObjectType xgetObjectType();
  
  void setObjectType(STObjectType.Enum paramEnum);
  
  void xsetObjectType(STObjectType paramSTObjectType);
  
  public static final class Factory {
    public static CTClientData newInstance() {
      return (CTClientData)POIXMLTypeLoader.newInstance(CTClientData.type, null);
    }
    
    public static CTClientData newInstance(XmlOptions param1XmlOptions) {
      return (CTClientData)POIXMLTypeLoader.newInstance(CTClientData.type, param1XmlOptions);
    }
    
    public static CTClientData parse(String param1String) throws XmlException {
      return (CTClientData)POIXMLTypeLoader.parse(param1String, CTClientData.type, null);
    }
    
    public static CTClientData parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTClientData)POIXMLTypeLoader.parse(param1String, CTClientData.type, param1XmlOptions);
    }
    
    public static CTClientData parse(File param1File) throws XmlException, IOException {
      return (CTClientData)POIXMLTypeLoader.parse(param1File, CTClientData.type, null);
    }
    
    public static CTClientData parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTClientData)POIXMLTypeLoader.parse(param1File, CTClientData.type, param1XmlOptions);
    }
    
    public static CTClientData parse(URL param1URL) throws XmlException, IOException {
      return (CTClientData)POIXMLTypeLoader.parse(param1URL, CTClientData.type, null);
    }
    
    public static CTClientData parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTClientData)POIXMLTypeLoader.parse(param1URL, CTClientData.type, param1XmlOptions);
    }
    
    public static CTClientData parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTClientData)POIXMLTypeLoader.parse(param1InputStream, CTClientData.type, null);
    }
    
    public static CTClientData parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTClientData)POIXMLTypeLoader.parse(param1InputStream, CTClientData.type, param1XmlOptions);
    }
    
    public static CTClientData parse(Reader param1Reader) throws XmlException, IOException {
      return (CTClientData)POIXMLTypeLoader.parse(param1Reader, CTClientData.type, null);
    }
    
    public static CTClientData parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTClientData)POIXMLTypeLoader.parse(param1Reader, CTClientData.type, param1XmlOptions);
    }
    
    public static CTClientData parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTClientData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTClientData.type, null);
    }
    
    public static CTClientData parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTClientData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTClientData.type, param1XmlOptions);
    }
    
    public static CTClientData parse(Node param1Node) throws XmlException {
      return (CTClientData)POIXMLTypeLoader.parse(param1Node, CTClientData.type, null);
    }
    
    public static CTClientData parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTClientData)POIXMLTypeLoader.parse(param1Node, CTClientData.type, param1XmlOptions);
    }
    
    public static CTClientData parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTClientData)POIXMLTypeLoader.parse(param1XMLInputStream, CTClientData.type, null);
    }
    
    public static CTClientData parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTClientData)POIXMLTypeLoader.parse(param1XMLInputStream, CTClientData.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTClientData.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTClientData.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\excel\CTClientData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */