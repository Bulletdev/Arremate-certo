package com.microsoft.schemas.vml;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTCallout;
import com.microsoft.schemas.office.office.CTClipPath;
import com.microsoft.schemas.office.office.CTExtrusion;
import com.microsoft.schemas.office.office.CTInk;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.office.office.CTSkew;
import com.microsoft.schemas.office.office.STBWMode;
import com.microsoft.schemas.office.office.STConnectorType;
import com.microsoft.schemas.office.office.STHrAlign;
import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.office.office.STTrueFalseBlank;
import com.microsoft.schemas.office.powerpoint.CTEmpty;
import com.microsoft.schemas.office.powerpoint.CTRel;
import com.microsoft.schemas.office.word.CTAnchorLock;
import com.microsoft.schemas.office.word.CTBorder;
import com.microsoft.schemas.office.word.CTWrap;
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
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTShape extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTShape.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshape5cb5type");
  
  List<CTPath> getPathList();
  
  CTPath[] getPathArray();
  
  CTPath getPathArray(int paramInt);
  
  int sizeOfPathArray();
  
  void setPathArray(CTPath[] paramArrayOfCTPath);
  
  void setPathArray(int paramInt, CTPath paramCTPath);
  
  CTPath insertNewPath(int paramInt);
  
  CTPath addNewPath();
  
  void removePath(int paramInt);
  
  List<CTFormulas> getFormulasList();
  
  CTFormulas[] getFormulasArray();
  
  CTFormulas getFormulasArray(int paramInt);
  
  int sizeOfFormulasArray();
  
  void setFormulasArray(CTFormulas[] paramArrayOfCTFormulas);
  
  void setFormulasArray(int paramInt, CTFormulas paramCTFormulas);
  
  CTFormulas insertNewFormulas(int paramInt);
  
  CTFormulas addNewFormulas();
  
  void removeFormulas(int paramInt);
  
  List<CTHandles> getHandlesList();
  
  CTHandles[] getHandlesArray();
  
  CTHandles getHandlesArray(int paramInt);
  
  int sizeOfHandlesArray();
  
  void setHandlesArray(CTHandles[] paramArrayOfCTHandles);
  
  void setHandlesArray(int paramInt, CTHandles paramCTHandles);
  
  CTHandles insertNewHandles(int paramInt);
  
  CTHandles addNewHandles();
  
  void removeHandles(int paramInt);
  
  List<CTFill> getFillList();
  
  CTFill[] getFillArray();
  
  CTFill getFillArray(int paramInt);
  
  int sizeOfFillArray();
  
  void setFillArray(CTFill[] paramArrayOfCTFill);
  
  void setFillArray(int paramInt, CTFill paramCTFill);
  
  CTFill insertNewFill(int paramInt);
  
  CTFill addNewFill();
  
  void removeFill(int paramInt);
  
  List<CTStroke> getStrokeList();
  
  CTStroke[] getStrokeArray();
  
  CTStroke getStrokeArray(int paramInt);
  
  int sizeOfStrokeArray();
  
  void setStrokeArray(CTStroke[] paramArrayOfCTStroke);
  
  void setStrokeArray(int paramInt, CTStroke paramCTStroke);
  
  CTStroke insertNewStroke(int paramInt);
  
  CTStroke addNewStroke();
  
  void removeStroke(int paramInt);
  
  List<CTShadow> getShadowList();
  
  CTShadow[] getShadowArray();
  
  CTShadow getShadowArray(int paramInt);
  
  int sizeOfShadowArray();
  
  void setShadowArray(CTShadow[] paramArrayOfCTShadow);
  
  void setShadowArray(int paramInt, CTShadow paramCTShadow);
  
  CTShadow insertNewShadow(int paramInt);
  
  CTShadow addNewShadow();
  
  void removeShadow(int paramInt);
  
  List<CTTextbox> getTextboxList();
  
  CTTextbox[] getTextboxArray();
  
  CTTextbox getTextboxArray(int paramInt);
  
  int sizeOfTextboxArray();
  
  void setTextboxArray(CTTextbox[] paramArrayOfCTTextbox);
  
  void setTextboxArray(int paramInt, CTTextbox paramCTTextbox);
  
  CTTextbox insertNewTextbox(int paramInt);
  
  CTTextbox addNewTextbox();
  
  void removeTextbox(int paramInt);
  
  List<CTTextPath> getTextpathList();
  
  CTTextPath[] getTextpathArray();
  
  CTTextPath getTextpathArray(int paramInt);
  
  int sizeOfTextpathArray();
  
  void setTextpathArray(CTTextPath[] paramArrayOfCTTextPath);
  
  void setTextpathArray(int paramInt, CTTextPath paramCTTextPath);
  
  CTTextPath insertNewTextpath(int paramInt);
  
  CTTextPath addNewTextpath();
  
  void removeTextpath(int paramInt);
  
  List<CTImageData> getImagedataList();
  
  CTImageData[] getImagedataArray();
  
  CTImageData getImagedataArray(int paramInt);
  
  int sizeOfImagedataArray();
  
  void setImagedataArray(CTImageData[] paramArrayOfCTImageData);
  
  void setImagedataArray(int paramInt, CTImageData paramCTImageData);
  
  CTImageData insertNewImagedata(int paramInt);
  
  CTImageData addNewImagedata();
  
  void removeImagedata(int paramInt);
  
  List<CTSkew> getSkewList();
  
  CTSkew[] getSkewArray();
  
  CTSkew getSkewArray(int paramInt);
  
  int sizeOfSkewArray();
  
  void setSkewArray(CTSkew[] paramArrayOfCTSkew);
  
  void setSkewArray(int paramInt, CTSkew paramCTSkew);
  
  CTSkew insertNewSkew(int paramInt);
  
  CTSkew addNewSkew();
  
  void removeSkew(int paramInt);
  
  List<CTExtrusion> getExtrusionList();
  
  CTExtrusion[] getExtrusionArray();
  
  CTExtrusion getExtrusionArray(int paramInt);
  
  int sizeOfExtrusionArray();
  
  void setExtrusionArray(CTExtrusion[] paramArrayOfCTExtrusion);
  
  void setExtrusionArray(int paramInt, CTExtrusion paramCTExtrusion);
  
  CTExtrusion insertNewExtrusion(int paramInt);
  
  CTExtrusion addNewExtrusion();
  
  void removeExtrusion(int paramInt);
  
  List<CTCallout> getCalloutList();
  
  CTCallout[] getCalloutArray();
  
  CTCallout getCalloutArray(int paramInt);
  
  int sizeOfCalloutArray();
  
  void setCalloutArray(CTCallout[] paramArrayOfCTCallout);
  
  void setCalloutArray(int paramInt, CTCallout paramCTCallout);
  
  CTCallout insertNewCallout(int paramInt);
  
  CTCallout addNewCallout();
  
  void removeCallout(int paramInt);
  
  List<CTLock> getLockList();
  
  CTLock[] getLockArray();
  
  CTLock getLockArray(int paramInt);
  
  int sizeOfLockArray();
  
  void setLockArray(CTLock[] paramArrayOfCTLock);
  
  void setLockArray(int paramInt, CTLock paramCTLock);
  
  CTLock insertNewLock(int paramInt);
  
  CTLock addNewLock();
  
  void removeLock(int paramInt);
  
  List<CTClipPath> getClippathList();
  
  CTClipPath[] getClippathArray();
  
  CTClipPath getClippathArray(int paramInt);
  
  int sizeOfClippathArray();
  
  void setClippathArray(CTClipPath[] paramArrayOfCTClipPath);
  
  void setClippathArray(int paramInt, CTClipPath paramCTClipPath);
  
  CTClipPath insertNewClippath(int paramInt);
  
  CTClipPath addNewClippath();
  
  void removeClippath(int paramInt);
  
  List<CTSignatureLine> getSignaturelineList();
  
  CTSignatureLine[] getSignaturelineArray();
  
  CTSignatureLine getSignaturelineArray(int paramInt);
  
  int sizeOfSignaturelineArray();
  
  void setSignaturelineArray(CTSignatureLine[] paramArrayOfCTSignatureLine);
  
  void setSignaturelineArray(int paramInt, CTSignatureLine paramCTSignatureLine);
  
  CTSignatureLine insertNewSignatureline(int paramInt);
  
  CTSignatureLine addNewSignatureline();
  
  void removeSignatureline(int paramInt);
  
  List<CTWrap> getWrapList();
  
  CTWrap[] getWrapArray();
  
  CTWrap getWrapArray(int paramInt);
  
  int sizeOfWrapArray();
  
  void setWrapArray(CTWrap[] paramArrayOfCTWrap);
  
  void setWrapArray(int paramInt, CTWrap paramCTWrap);
  
  CTWrap insertNewWrap(int paramInt);
  
  CTWrap addNewWrap();
  
  void removeWrap(int paramInt);
  
  List<CTAnchorLock> getAnchorlockList();
  
  CTAnchorLock[] getAnchorlockArray();
  
  CTAnchorLock getAnchorlockArray(int paramInt);
  
  int sizeOfAnchorlockArray();
  
  void setAnchorlockArray(CTAnchorLock[] paramArrayOfCTAnchorLock);
  
  void setAnchorlockArray(int paramInt, CTAnchorLock paramCTAnchorLock);
  
  CTAnchorLock insertNewAnchorlock(int paramInt);
  
  CTAnchorLock addNewAnchorlock();
  
  void removeAnchorlock(int paramInt);
  
  List<CTBorder> getBordertopList();
  
  CTBorder[] getBordertopArray();
  
  CTBorder getBordertopArray(int paramInt);
  
  int sizeOfBordertopArray();
  
  void setBordertopArray(CTBorder[] paramArrayOfCTBorder);
  
  void setBordertopArray(int paramInt, CTBorder paramCTBorder);
  
  CTBorder insertNewBordertop(int paramInt);
  
  CTBorder addNewBordertop();
  
  void removeBordertop(int paramInt);
  
  List<CTBorder> getBorderbottomList();
  
  CTBorder[] getBorderbottomArray();
  
  CTBorder getBorderbottomArray(int paramInt);
  
  int sizeOfBorderbottomArray();
  
  void setBorderbottomArray(CTBorder[] paramArrayOfCTBorder);
  
  void setBorderbottomArray(int paramInt, CTBorder paramCTBorder);
  
  CTBorder insertNewBorderbottom(int paramInt);
  
  CTBorder addNewBorderbottom();
  
  void removeBorderbottom(int paramInt);
  
  List<CTBorder> getBorderleftList();
  
  CTBorder[] getBorderleftArray();
  
  CTBorder getBorderleftArray(int paramInt);
  
  int sizeOfBorderleftArray();
  
  void setBorderleftArray(CTBorder[] paramArrayOfCTBorder);
  
  void setBorderleftArray(int paramInt, CTBorder paramCTBorder);
  
  CTBorder insertNewBorderleft(int paramInt);
  
  CTBorder addNewBorderleft();
  
  void removeBorderleft(int paramInt);
  
  List<CTBorder> getBorderrightList();
  
  CTBorder[] getBorderrightArray();
  
  CTBorder getBorderrightArray(int paramInt);
  
  int sizeOfBorderrightArray();
  
  void setBorderrightArray(CTBorder[] paramArrayOfCTBorder);
  
  void setBorderrightArray(int paramInt, CTBorder paramCTBorder);
  
  CTBorder insertNewBorderright(int paramInt);
  
  CTBorder addNewBorderright();
  
  void removeBorderright(int paramInt);
  
  List<CTClientData> getClientDataList();
  
  CTClientData[] getClientDataArray();
  
  CTClientData getClientDataArray(int paramInt);
  
  int sizeOfClientDataArray();
  
  void setClientDataArray(CTClientData[] paramArrayOfCTClientData);
  
  void setClientDataArray(int paramInt, CTClientData paramCTClientData);
  
  CTClientData insertNewClientData(int paramInt);
  
  CTClientData addNewClientData();
  
  void removeClientData(int paramInt);
  
  List<CTRel> getTextdataList();
  
  CTRel[] getTextdataArray();
  
  CTRel getTextdataArray(int paramInt);
  
  int sizeOfTextdataArray();
  
  void setTextdataArray(CTRel[] paramArrayOfCTRel);
  
  void setTextdataArray(int paramInt, CTRel paramCTRel);
  
  CTRel insertNewTextdata(int paramInt);
  
  CTRel addNewTextdata();
  
  void removeTextdata(int paramInt);
  
  List<CTInk> getInkList();
  
  CTInk[] getInkArray();
  
  CTInk getInkArray(int paramInt);
  
  int sizeOfInkArray();
  
  void setInkArray(CTInk[] paramArrayOfCTInk);
  
  void setInkArray(int paramInt, CTInk paramCTInk);
  
  CTInk insertNewInk(int paramInt);
  
  CTInk addNewInk();
  
  void removeInk(int paramInt);
  
  List<CTEmpty> getIscommentList();
  
  CTEmpty[] getIscommentArray();
  
  CTEmpty getIscommentArray(int paramInt);
  
  int sizeOfIscommentArray();
  
  void setIscommentArray(CTEmpty[] paramArrayOfCTEmpty);
  
  void setIscommentArray(int paramInt, CTEmpty paramCTEmpty);
  
  CTEmpty insertNewIscomment(int paramInt);
  
  CTEmpty addNewIscomment();
  
  void removeIscomment(int paramInt);
  
  String getId();
  
  XmlString xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(XmlString paramXmlString);
  
  void unsetId();
  
  String getStyle();
  
  XmlString xgetStyle();
  
  boolean isSetStyle();
  
  void setStyle(String paramString);
  
  void xsetStyle(XmlString paramXmlString);
  
  void unsetStyle();
  
  String getHref();
  
  XmlString xgetHref();
  
  boolean isSetHref();
  
  void setHref(String paramString);
  
  void xsetHref(XmlString paramXmlString);
  
  void unsetHref();
  
  String getTarget();
  
  XmlString xgetTarget();
  
  boolean isSetTarget();
  
  void setTarget(String paramString);
  
  void xsetTarget(XmlString paramXmlString);
  
  void unsetTarget();
  
  String getClass1();
  
  XmlString xgetClass1();
  
  boolean isSetClass1();
  
  void setClass1(String paramString);
  
  void xsetClass1(XmlString paramXmlString);
  
  void unsetClass1();
  
  String getTitle();
  
  XmlString xgetTitle();
  
  boolean isSetTitle();
  
  void setTitle(String paramString);
  
  void xsetTitle(XmlString paramXmlString);
  
  void unsetTitle();
  
  String getAlt();
  
  XmlString xgetAlt();
  
  boolean isSetAlt();
  
  void setAlt(String paramString);
  
  void xsetAlt(XmlString paramXmlString);
  
  void unsetAlt();
  
  String getCoordsize();
  
  XmlString xgetCoordsize();
  
  boolean isSetCoordsize();
  
  void setCoordsize(String paramString);
  
  void xsetCoordsize(XmlString paramXmlString);
  
  void unsetCoordsize();
  
  String getCoordorigin();
  
  XmlString xgetCoordorigin();
  
  boolean isSetCoordorigin();
  
  void setCoordorigin(String paramString);
  
  void xsetCoordorigin(XmlString paramXmlString);
  
  void unsetCoordorigin();
  
  String getWrapcoords();
  
  XmlString xgetWrapcoords();
  
  boolean isSetWrapcoords();
  
  void setWrapcoords(String paramString);
  
  void xsetWrapcoords(XmlString paramXmlString);
  
  void unsetWrapcoords();
  
  STTrueFalse.Enum getPrint();
  
  STTrueFalse xgetPrint();
  
  boolean isSetPrint();
  
  void setPrint(STTrueFalse.Enum paramEnum);
  
  void xsetPrint(STTrueFalse paramSTTrueFalse);
  
  void unsetPrint();
  
  String getSpid();
  
  XmlString xgetSpid();
  
  boolean isSetSpid();
  
  void setSpid(String paramString);
  
  void xsetSpid(XmlString paramXmlString);
  
  void unsetSpid();
  
  STTrueFalse.Enum getOned();
  
  STTrueFalse xgetOned();
  
  boolean isSetOned();
  
  void setOned(STTrueFalse.Enum paramEnum);
  
  void xsetOned(STTrueFalse paramSTTrueFalse);
  
  void unsetOned();
  
  BigInteger getRegroupid();
  
  XmlInteger xgetRegroupid();
  
  boolean isSetRegroupid();
  
  void setRegroupid(BigInteger paramBigInteger);
  
  void xsetRegroupid(XmlInteger paramXmlInteger);
  
  void unsetRegroupid();
  
  STTrueFalse.Enum getDoubleclicknotify();
  
  STTrueFalse xgetDoubleclicknotify();
  
  boolean isSetDoubleclicknotify();
  
  void setDoubleclicknotify(STTrueFalse.Enum paramEnum);
  
  void xsetDoubleclicknotify(STTrueFalse paramSTTrueFalse);
  
  void unsetDoubleclicknotify();
  
  STTrueFalse.Enum getButton();
  
  STTrueFalse xgetButton();
  
  boolean isSetButton();
  
  void setButton(STTrueFalse.Enum paramEnum);
  
  void xsetButton(STTrueFalse paramSTTrueFalse);
  
  void unsetButton();
  
  STTrueFalse.Enum getUserhidden();
  
  STTrueFalse xgetUserhidden();
  
  boolean isSetUserhidden();
  
  void setUserhidden(STTrueFalse.Enum paramEnum);
  
  void xsetUserhidden(STTrueFalse paramSTTrueFalse);
  
  void unsetUserhidden();
  
  STTrueFalse.Enum getBullet();
  
  STTrueFalse xgetBullet();
  
  boolean isSetBullet();
  
  void setBullet(STTrueFalse.Enum paramEnum);
  
  void xsetBullet(STTrueFalse paramSTTrueFalse);
  
  void unsetBullet();
  
  STTrueFalse.Enum getHr();
  
  STTrueFalse xgetHr();
  
  boolean isSetHr();
  
  void setHr(STTrueFalse.Enum paramEnum);
  
  void xsetHr(STTrueFalse paramSTTrueFalse);
  
  void unsetHr();
  
  STTrueFalse.Enum getHrstd();
  
  STTrueFalse xgetHrstd();
  
  boolean isSetHrstd();
  
  void setHrstd(STTrueFalse.Enum paramEnum);
  
  void xsetHrstd(STTrueFalse paramSTTrueFalse);
  
  void unsetHrstd();
  
  STTrueFalse.Enum getHrnoshade();
  
  STTrueFalse xgetHrnoshade();
  
  boolean isSetHrnoshade();
  
  void setHrnoshade(STTrueFalse.Enum paramEnum);
  
  void xsetHrnoshade(STTrueFalse paramSTTrueFalse);
  
  void unsetHrnoshade();
  
  float getHrpct();
  
  XmlFloat xgetHrpct();
  
  boolean isSetHrpct();
  
  void setHrpct(float paramFloat);
  
  void xsetHrpct(XmlFloat paramXmlFloat);
  
  void unsetHrpct();
  
  STHrAlign.Enum getHralign();
  
  STHrAlign xgetHralign();
  
  boolean isSetHralign();
  
  void setHralign(STHrAlign.Enum paramEnum);
  
  void xsetHralign(STHrAlign paramSTHrAlign);
  
  void unsetHralign();
  
  STTrueFalse.Enum getAllowincell();
  
  STTrueFalse xgetAllowincell();
  
  boolean isSetAllowincell();
  
  void setAllowincell(STTrueFalse.Enum paramEnum);
  
  void xsetAllowincell(STTrueFalse paramSTTrueFalse);
  
  void unsetAllowincell();
  
  STTrueFalse.Enum getAllowoverlap();
  
  STTrueFalse xgetAllowoverlap();
  
  boolean isSetAllowoverlap();
  
  void setAllowoverlap(STTrueFalse.Enum paramEnum);
  
  void xsetAllowoverlap(STTrueFalse paramSTTrueFalse);
  
  void unsetAllowoverlap();
  
  STTrueFalse.Enum getUserdrawn();
  
  STTrueFalse xgetUserdrawn();
  
  boolean isSetUserdrawn();
  
  void setUserdrawn(STTrueFalse.Enum paramEnum);
  
  void xsetUserdrawn(STTrueFalse paramSTTrueFalse);
  
  void unsetUserdrawn();
  
  String getBordertopcolor();
  
  XmlString xgetBordertopcolor();
  
  boolean isSetBordertopcolor();
  
  void setBordertopcolor(String paramString);
  
  void xsetBordertopcolor(XmlString paramXmlString);
  
  void unsetBordertopcolor();
  
  String getBorderleftcolor();
  
  XmlString xgetBorderleftcolor();
  
  boolean isSetBorderleftcolor();
  
  void setBorderleftcolor(String paramString);
  
  void xsetBorderleftcolor(XmlString paramXmlString);
  
  void unsetBorderleftcolor();
  
  String getBorderbottomcolor();
  
  XmlString xgetBorderbottomcolor();
  
  boolean isSetBorderbottomcolor();
  
  void setBorderbottomcolor(String paramString);
  
  void xsetBorderbottomcolor(XmlString paramXmlString);
  
  void unsetBorderbottomcolor();
  
  String getBorderrightcolor();
  
  XmlString xgetBorderrightcolor();
  
  boolean isSetBorderrightcolor();
  
  void setBorderrightcolor(String paramString);
  
  void xsetBorderrightcolor(XmlString paramXmlString);
  
  void unsetBorderrightcolor();
  
  BigInteger getDgmlayout();
  
  XmlInteger xgetDgmlayout();
  
  boolean isSetDgmlayout();
  
  void setDgmlayout(BigInteger paramBigInteger);
  
  void xsetDgmlayout(XmlInteger paramXmlInteger);
  
  void unsetDgmlayout();
  
  BigInteger getDgmnodekind();
  
  XmlInteger xgetDgmnodekind();
  
  boolean isSetDgmnodekind();
  
  void setDgmnodekind(BigInteger paramBigInteger);
  
  void xsetDgmnodekind(XmlInteger paramXmlInteger);
  
  void unsetDgmnodekind();
  
  BigInteger getDgmlayoutmru();
  
  XmlInteger xgetDgmlayoutmru();
  
  boolean isSetDgmlayoutmru();
  
  void setDgmlayoutmru(BigInteger paramBigInteger);
  
  void xsetDgmlayoutmru(XmlInteger paramXmlInteger);
  
  void unsetDgmlayoutmru();
  
  STInsetMode.Enum getInsetmode();
  
  STInsetMode xgetInsetmode();
  
  boolean isSetInsetmode();
  
  void setInsetmode(STInsetMode.Enum paramEnum);
  
  void xsetInsetmode(STInsetMode paramSTInsetMode);
  
  void unsetInsetmode();
  
  String getChromakey();
  
  STColorType xgetChromakey();
  
  boolean isSetChromakey();
  
  void setChromakey(String paramString);
  
  void xsetChromakey(STColorType paramSTColorType);
  
  void unsetChromakey();
  
  STTrueFalse.Enum getFilled();
  
  STTrueFalse xgetFilled();
  
  boolean isSetFilled();
  
  void setFilled(STTrueFalse.Enum paramEnum);
  
  void xsetFilled(STTrueFalse paramSTTrueFalse);
  
  void unsetFilled();
  
  String getFillcolor();
  
  STColorType xgetFillcolor();
  
  boolean isSetFillcolor();
  
  void setFillcolor(String paramString);
  
  void xsetFillcolor(STColorType paramSTColorType);
  
  void unsetFillcolor();
  
  String getOpacity();
  
  XmlString xgetOpacity();
  
  boolean isSetOpacity();
  
  void setOpacity(String paramString);
  
  void xsetOpacity(XmlString paramXmlString);
  
  void unsetOpacity();
  
  STTrueFalse.Enum getStroked();
  
  STTrueFalse xgetStroked();
  
  boolean isSetStroked();
  
  void setStroked(STTrueFalse.Enum paramEnum);
  
  void xsetStroked(STTrueFalse paramSTTrueFalse);
  
  void unsetStroked();
  
  String getStrokecolor();
  
  STColorType xgetStrokecolor();
  
  boolean isSetStrokecolor();
  
  void setStrokecolor(String paramString);
  
  void xsetStrokecolor(STColorType paramSTColorType);
  
  void unsetStrokecolor();
  
  String getStrokeweight();
  
  XmlString xgetStrokeweight();
  
  boolean isSetStrokeweight();
  
  void setStrokeweight(String paramString);
  
  void xsetStrokeweight(XmlString paramXmlString);
  
  void unsetStrokeweight();
  
  STTrueFalse.Enum getInsetpen();
  
  STTrueFalse xgetInsetpen();
  
  boolean isSetInsetpen();
  
  void setInsetpen(STTrueFalse.Enum paramEnum);
  
  void xsetInsetpen(STTrueFalse paramSTTrueFalse);
  
  void unsetInsetpen();
  
  float getSpt();
  
  XmlFloat xgetSpt();
  
  boolean isSetSpt();
  
  void setSpt(float paramFloat);
  
  void xsetSpt(XmlFloat paramXmlFloat);
  
  void unsetSpt();
  
  STConnectorType.Enum getConnectortype();
  
  STConnectorType xgetConnectortype();
  
  boolean isSetConnectortype();
  
  void setConnectortype(STConnectorType.Enum paramEnum);
  
  void xsetConnectortype(STConnectorType paramSTConnectorType);
  
  void unsetConnectortype();
  
  STBWMode.Enum getBwmode();
  
  STBWMode xgetBwmode();
  
  boolean isSetBwmode();
  
  void setBwmode(STBWMode.Enum paramEnum);
  
  void xsetBwmode(STBWMode paramSTBWMode);
  
  void unsetBwmode();
  
  STBWMode.Enum getBwpure();
  
  STBWMode xgetBwpure();
  
  boolean isSetBwpure();
  
  void setBwpure(STBWMode.Enum paramEnum);
  
  void xsetBwpure(STBWMode paramSTBWMode);
  
  void unsetBwpure();
  
  STBWMode.Enum getBwnormal();
  
  STBWMode xgetBwnormal();
  
  boolean isSetBwnormal();
  
  void setBwnormal(STBWMode.Enum paramEnum);
  
  void xsetBwnormal(STBWMode paramSTBWMode);
  
  void unsetBwnormal();
  
  STTrueFalse.Enum getForcedash();
  
  STTrueFalse xgetForcedash();
  
  boolean isSetForcedash();
  
  void setForcedash(STTrueFalse.Enum paramEnum);
  
  void xsetForcedash(STTrueFalse paramSTTrueFalse);
  
  void unsetForcedash();
  
  STTrueFalse.Enum getOleicon();
  
  STTrueFalse xgetOleicon();
  
  boolean isSetOleicon();
  
  void setOleicon(STTrueFalse.Enum paramEnum);
  
  void xsetOleicon(STTrueFalse paramSTTrueFalse);
  
  void unsetOleicon();
  
  STTrueFalseBlank.Enum getOle();
  
  STTrueFalseBlank xgetOle();
  
  boolean isSetOle();
  
  void setOle(STTrueFalseBlank.Enum paramEnum);
  
  void xsetOle(STTrueFalseBlank paramSTTrueFalseBlank);
  
  void unsetOle();
  
  STTrueFalse.Enum getPreferrelative();
  
  STTrueFalse xgetPreferrelative();
  
  boolean isSetPreferrelative();
  
  void setPreferrelative(STTrueFalse.Enum paramEnum);
  
  void xsetPreferrelative(STTrueFalse paramSTTrueFalse);
  
  void unsetPreferrelative();
  
  STTrueFalse.Enum getCliptowrap();
  
  STTrueFalse xgetCliptowrap();
  
  boolean isSetCliptowrap();
  
  void setCliptowrap(STTrueFalse.Enum paramEnum);
  
  void xsetCliptowrap(STTrueFalse paramSTTrueFalse);
  
  void unsetCliptowrap();
  
  STTrueFalse.Enum getClip();
  
  STTrueFalse xgetClip();
  
  boolean isSetClip();
  
  void setClip(STTrueFalse.Enum paramEnum);
  
  void xsetClip(STTrueFalse paramSTTrueFalse);
  
  void unsetClip();
  
  String getType();
  
  XmlString xgetType();
  
  boolean isSetType();
  
  void setType(String paramString);
  
  void xsetType(XmlString paramXmlString);
  
  void unsetType();
  
  String getAdj();
  
  XmlString xgetAdj();
  
  boolean isSetAdj();
  
  void setAdj(String paramString);
  
  void xsetAdj(XmlString paramXmlString);
  
  void unsetAdj();
  
  String getPath2();
  
  XmlString xgetPath2();
  
  boolean isSetPath2();
  
  void setPath2(String paramString);
  
  void xsetPath2(XmlString paramXmlString);
  
  void unsetPath2();
  
  byte[] getGfxdata();
  
  XmlBase64Binary xgetGfxdata();
  
  boolean isSetGfxdata();
  
  void setGfxdata(byte[] paramArrayOfbyte);
  
  void xsetGfxdata(XmlBase64Binary paramXmlBase64Binary);
  
  void unsetGfxdata();
  
  String getEquationxml();
  
  XmlString xgetEquationxml();
  
  boolean isSetEquationxml();
  
  void setEquationxml(String paramString);
  
  void xsetEquationxml(XmlString paramXmlString);
  
  void unsetEquationxml();
  
  public static final class Factory {
    public static CTShape newInstance() {
      return (CTShape)POIXMLTypeLoader.newInstance(CTShape.type, null);
    }
    
    public static CTShape newInstance(XmlOptions param1XmlOptions) {
      return (CTShape)POIXMLTypeLoader.newInstance(CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(String param1String) throws XmlException {
      return (CTShape)POIXMLTypeLoader.parse(param1String, CTShape.type, null);
    }
    
    public static CTShape parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShape)POIXMLTypeLoader.parse(param1String, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(File param1File) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1File, CTShape.type, null);
    }
    
    public static CTShape parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1File, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(URL param1URL) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1URL, CTShape.type, null);
    }
    
    public static CTShape parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1URL, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1InputStream, CTShape.type, null);
    }
    
    public static CTShape parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1InputStream, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(Reader param1Reader) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1Reader, CTShape.type, null);
    }
    
    public static CTShape parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTShape)POIXMLTypeLoader.parse(param1Reader, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTShape)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShape.type, null);
    }
    
    public static CTShape parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShape)POIXMLTypeLoader.parse(param1XMLStreamReader, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(Node param1Node) throws XmlException {
      return (CTShape)POIXMLTypeLoader.parse(param1Node, CTShape.type, null);
    }
    
    public static CTShape parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTShape)POIXMLTypeLoader.parse(param1Node, CTShape.type, param1XmlOptions);
    }
    
    public static CTShape parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTShape)POIXMLTypeLoader.parse(param1XMLInputStream, CTShape.type, null);
    }
    
    public static CTShape parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTShape)POIXMLTypeLoader.parse(param1XMLInputStream, CTShape.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShape.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTShape.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\CTShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */