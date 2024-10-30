/*      */ package org.apache.poi.xwpf.usermodel;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.StringReader;
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.List;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.poi.POIXMLException;
/*      */ import org.apache.poi.POIXMLTypeLoader;
/*      */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*      */ import org.apache.poi.util.DocumentHelper;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.wp.usermodel.CharacterRun;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlException;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlString;
/*      */ import org.apache.xmlbeans.XmlToken;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.picture.CTPictureNonVisual;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
/*      */ import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedTwipsMeasure;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrClear;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrType;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalAlignRun;
/*      */ import org.w3c.dom.Document;
/*      */ import org.w3c.dom.NodeList;
/*      */ import org.xml.sax.InputSource;
/*      */ import org.xml.sax.SAXException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class XWPFRun
/*      */   implements CharacterRun, IRunElement, ISDTContents
/*      */ {
/*      */   private CTR run;
/*      */   private String pictureText;
/*      */   private IRunBody parent;
/*      */   private List<XWPFPicture> pictures;
/*      */   
/*      */   public XWPFRun(CTR paramCTR, IRunBody paramIRunBody) {
/*  102 */     this.run = paramCTR;
/*  103 */     this.parent = paramIRunBody;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  109 */     for (CTDrawing cTDrawing : paramCTR.getDrawingArray()) {
/*  110 */       for (CTAnchor cTAnchor : cTDrawing.getAnchorArray()) {
/*  111 */         if (cTAnchor.getDocPr() != null) {
/*  112 */           getDocument().getDrawingIdManager().reserve(cTAnchor.getDocPr().getId());
/*      */         }
/*      */       } 
/*  115 */       for (CTInline cTInline : cTDrawing.getInlineArray()) {
/*  116 */         if (cTInline.getDocPr() != null) {
/*  117 */           getDocument().getDrawingIdManager().reserve(cTInline.getDocPr().getId());
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  123 */     StringBuilder stringBuilder = new StringBuilder();
/*  124 */     ArrayList arrayList = new ArrayList();
/*  125 */     arrayList.addAll(Arrays.asList(paramCTR.getPictArray()));
/*  126 */     arrayList.addAll(Arrays.asList(paramCTR.getDrawingArray()));
/*  127 */     for (XmlObject xmlObject : arrayList) {
/*  128 */       XmlObject[] arrayOfXmlObject = xmlObject.selectPath("declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main' .//w:t");
/*  129 */       for (XmlObject xmlObject1 : arrayOfXmlObject) {
/*  130 */         NodeList nodeList = xmlObject1.getDomNode().getChildNodes();
/*  131 */         for (byte b = 0; b < nodeList.getLength(); b++) {
/*  132 */           if (nodeList.item(b) instanceof org.w3c.dom.Text) {
/*  133 */             if (stringBuilder.length() > 0)
/*  134 */               stringBuilder.append("\n"); 
/*  135 */             stringBuilder.append(nodeList.item(b).getNodeValue());
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  140 */     this.pictureText = stringBuilder.toString();
/*      */ 
/*      */ 
/*      */     
/*  144 */     this.pictures = new ArrayList<XWPFPicture>();
/*  145 */     for (XmlObject xmlObject : arrayList) {
/*  146 */       for (CTPicture cTPicture : getCTPictures(xmlObject)) {
/*  147 */         XWPFPicture xWPFPicture = new XWPFPicture(cTPicture, this);
/*  148 */         this.pictures.add(xWPFPicture);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFRun(CTR paramCTR, XWPFParagraph paramXWPFParagraph) {
/*  157 */     this(paramCTR, paramXWPFParagraph);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static void preserveSpaces(XmlString paramXmlString) {
/*  166 */     String str = paramXmlString.getStringValue();
/*  167 */     if (str != null && (str.startsWith(" ") || str.endsWith(" "))) {
/*  168 */       XmlCursor xmlCursor = paramXmlString.newCursor();
/*  169 */       xmlCursor.toNextToken();
/*  170 */       xmlCursor.insertAttributeWithValue(new b("http://www.w3.org/XML/1998/namespace", "space"), "preserve");
/*  171 */       xmlCursor.dispose();
/*      */     } 
/*      */   }
/*      */   
/*      */   private List<CTPicture> getCTPictures(XmlObject paramXmlObject) {
/*  176 */     ArrayList<CTPicture> arrayList = new ArrayList();
/*  177 */     XmlObject[] arrayOfXmlObject = paramXmlObject.selectPath("declare namespace pic='" + CTPicture.type.getName().getNamespaceURI() + "' .//pic:pic");
/*  178 */     for (XmlObject xmlObject : arrayOfXmlObject) {
/*  179 */       CTPicture cTPicture; if (xmlObject instanceof org.apache.xmlbeans.impl.values.XmlAnyTypeImpl) {
/*      */         
/*      */         try {
/*  182 */           cTPicture = CTPicture.Factory.parse(xmlObject.toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  183 */         } catch (XmlException xmlException) {
/*  184 */           throw new POIXMLException(xmlException);
/*      */         } 
/*      */       }
/*  187 */       if (cTPicture instanceof CTPicture) {
/*  188 */         arrayList.add(cTPicture);
/*      */       }
/*      */     } 
/*  191 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public CTR getCTR() {
/*  201 */     return this.run;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IRunBody getParent() {
/*  210 */     return this.parent;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFParagraph getParagraph() {
/*  219 */     if (this.parent instanceof XWPFParagraph)
/*  220 */       return (XWPFParagraph)this.parent; 
/*  221 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFDocument getDocument() {
/*  229 */     if (this.parent != null) {
/*  230 */       return this.parent.getDocument();
/*      */     }
/*  232 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isCTOnOff(CTOnOff paramCTOnOff) {
/*  239 */     if (!paramCTOnOff.isSetVal())
/*  240 */       return true; 
/*  241 */     STOnOff.Enum enum_ = paramCTOnOff.getVal();
/*  242 */     return (STOnOff.TRUE == enum_ || STOnOff.X_1 == enum_ || STOnOff.ON == enum_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBold() {
/*  256 */     CTRPr cTRPr = this.run.getRPr();
/*  257 */     if (cTRPr == null || !cTRPr.isSetB()) {
/*  258 */       return false;
/*      */     }
/*  260 */     return isCTOnOff(cTRPr.getB());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBold(boolean paramBoolean) {
/*  288 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  289 */     CTOnOff cTOnOff = cTRPr.isSetB() ? cTRPr.getB() : cTRPr.addNewB();
/*  290 */     cTOnOff.setVal(paramBoolean ? STOnOff.TRUE : STOnOff.FALSE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getColor() {
/*  297 */     String str = null;
/*  298 */     if (this.run.isSetRPr()) {
/*  299 */       CTRPr cTRPr = this.run.getRPr();
/*  300 */       if (cTRPr.isSetColor()) {
/*  301 */         CTColor cTColor = cTRPr.getColor();
/*  302 */         str = cTColor.xgetVal().getStringValue();
/*      */       } 
/*      */     } 
/*  305 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setColor(String paramString) {
/*  314 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  315 */     CTColor cTColor = cTRPr.isSetColor() ? cTRPr.getColor() : cTRPr.addNewColor();
/*  316 */     cTColor.setVal(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getText(int paramInt) {
/*  325 */     return (this.run.sizeOfTArray() == 0) ? null : this.run.getTArray(paramInt).getStringValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPictureText() {
/*  333 */     return this.pictureText;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setText(String paramString) {
/*  342 */     setText(paramString, this.run.sizeOfTArray());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setText(String paramString, int paramInt) {
/*  352 */     if (paramInt > this.run.sizeOfTArray())
/*  353 */       throw new ArrayIndexOutOfBoundsException("Value too large for the parameter position in XWPFRun.setText(String value,int pos)"); 
/*  354 */     CTText cTText = (paramInt < this.run.sizeOfTArray() && paramInt >= 0) ? this.run.getTArray(paramInt) : this.run.addNewT();
/*  355 */     cTText.setStringValue(paramString);
/*  356 */     preserveSpaces((XmlString)cTText);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isItalic() {
/*  366 */     CTRPr cTRPr = this.run.getRPr();
/*  367 */     if (cTRPr == null || !cTRPr.isSetI())
/*  368 */       return false; 
/*  369 */     return isCTOnOff(cTRPr.getI());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setItalic(boolean paramBoolean) {
/*  398 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  399 */     CTOnOff cTOnOff = cTRPr.isSetI() ? cTRPr.getI() : cTRPr.addNewI();
/*  400 */     cTOnOff.setVal(paramBoolean ? STOnOff.TRUE : STOnOff.FALSE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public UnderlinePatterns getUnderline() {
/*  411 */     CTRPr cTRPr = this.run.getRPr();
/*  412 */     return (cTRPr != null && cTRPr.isSetU() && cTRPr.getU().getVal() != null) ? UnderlinePatterns.valueOf(cTRPr.getU().getVal().intValue()) : UnderlinePatterns.NONE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUnderline(UnderlinePatterns paramUnderlinePatterns) {
/*  433 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  434 */     CTUnderline cTUnderline = (cTRPr.getU() == null) ? cTRPr.addNewU() : cTRPr.getU();
/*  435 */     cTUnderline.setVal(STUnderline.Enum.forInt(paramUnderlinePatterns.getValue()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isStrikeThrough() {
/*  445 */     CTRPr cTRPr = this.run.getRPr();
/*  446 */     if (cTRPr == null || !cTRPr.isSetStrike())
/*  447 */       return false; 
/*  448 */     return isCTOnOff(cTRPr.getStrike());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStrikeThrough(boolean paramBoolean) {
/*  476 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  477 */     CTOnOff cTOnOff = cTRPr.isSetStrike() ? cTRPr.getStrike() : cTRPr.addNewStrike();
/*  478 */     cTOnOff.setVal(paramBoolean ? STOnOff.TRUE : STOnOff.FALSE);
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   public boolean isStrike() {
/*  483 */     return isStrikeThrough();
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   public void setStrike(boolean paramBoolean) {
/*  488 */     setStrikeThrough(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDoubleStrikeThrough() {
/*  498 */     CTRPr cTRPr = this.run.getRPr();
/*  499 */     if (cTRPr == null || !cTRPr.isSetDstrike())
/*  500 */       return false; 
/*  501 */     return isCTOnOff(cTRPr.getDstrike());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDoubleStrikethrough(boolean paramBoolean) {
/*  511 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  512 */     CTOnOff cTOnOff = cTRPr.isSetDstrike() ? cTRPr.getDstrike() : cTRPr.addNewDstrike();
/*  513 */     cTOnOff.setVal(paramBoolean ? STOnOff.TRUE : STOnOff.FALSE);
/*      */   }
/*      */   
/*      */   public boolean isSmallCaps() {
/*  517 */     CTRPr cTRPr = this.run.getRPr();
/*  518 */     if (cTRPr == null || !cTRPr.isSetSmallCaps())
/*  519 */       return false; 
/*  520 */     return isCTOnOff(cTRPr.getSmallCaps());
/*      */   }
/*      */   
/*      */   public void setSmallCaps(boolean paramBoolean) {
/*  524 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  525 */     CTOnOff cTOnOff = cTRPr.isSetSmallCaps() ? cTRPr.getSmallCaps() : cTRPr.addNewSmallCaps();
/*  526 */     cTOnOff.setVal(paramBoolean ? STOnOff.TRUE : STOnOff.FALSE);
/*      */   }
/*      */   
/*      */   public boolean isCapitalized() {
/*  530 */     CTRPr cTRPr = this.run.getRPr();
/*  531 */     if (cTRPr == null || !cTRPr.isSetCaps())
/*  532 */       return false; 
/*  533 */     return isCTOnOff(cTRPr.getCaps());
/*      */   }
/*      */   
/*      */   public void setCapitalized(boolean paramBoolean) {
/*  537 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  538 */     CTOnOff cTOnOff = cTRPr.isSetCaps() ? cTRPr.getCaps() : cTRPr.addNewCaps();
/*  539 */     cTOnOff.setVal(paramBoolean ? STOnOff.TRUE : STOnOff.FALSE);
/*      */   }
/*      */   
/*      */   public boolean isShadowed() {
/*  543 */     CTRPr cTRPr = this.run.getRPr();
/*  544 */     if (cTRPr == null || !cTRPr.isSetShadow())
/*  545 */       return false; 
/*  546 */     return isCTOnOff(cTRPr.getShadow());
/*      */   }
/*      */   
/*      */   public void setShadow(boolean paramBoolean) {
/*  550 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  551 */     CTOnOff cTOnOff = cTRPr.isSetShadow() ? cTRPr.getShadow() : cTRPr.addNewShadow();
/*  552 */     cTOnOff.setVal(paramBoolean ? STOnOff.TRUE : STOnOff.FALSE);
/*      */   }
/*      */   
/*      */   public boolean isImprinted() {
/*  556 */     CTRPr cTRPr = this.run.getRPr();
/*  557 */     if (cTRPr == null || !cTRPr.isSetImprint())
/*  558 */       return false; 
/*  559 */     return isCTOnOff(cTRPr.getImprint());
/*      */   }
/*      */   
/*      */   public void setImprinted(boolean paramBoolean) {
/*  563 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  564 */     CTOnOff cTOnOff = cTRPr.isSetImprint() ? cTRPr.getImprint() : cTRPr.addNewImprint();
/*  565 */     cTOnOff.setVal(paramBoolean ? STOnOff.TRUE : STOnOff.FALSE);
/*      */   }
/*      */   
/*      */   public boolean isEmbossed() {
/*  569 */     CTRPr cTRPr = this.run.getRPr();
/*  570 */     if (cTRPr == null || !cTRPr.isSetEmboss())
/*  571 */       return false; 
/*  572 */     return isCTOnOff(cTRPr.getEmboss());
/*      */   }
/*      */   
/*      */   public void setEmbossed(boolean paramBoolean) {
/*  576 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  577 */     CTOnOff cTOnOff = cTRPr.isSetEmboss() ? cTRPr.getEmboss() : cTRPr.addNewEmboss();
/*  578 */     cTOnOff.setVal(paramBoolean ? STOnOff.TRUE : STOnOff.FALSE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VerticalAlign getSubscript() {
/*  591 */     CTRPr cTRPr = this.run.getRPr();
/*  592 */     return (cTRPr != null && cTRPr.isSetVertAlign()) ? VerticalAlign.valueOf(cTRPr.getVertAlign().getVal().intValue()) : VerticalAlign.BASELINE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSubscript(VerticalAlign paramVerticalAlign) {
/*  612 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  613 */     CTVerticalAlignRun cTVerticalAlignRun = cTRPr.isSetVertAlign() ? cTRPr.getVertAlign() : cTRPr.addNewVertAlign();
/*  614 */     cTVerticalAlignRun.setVal(STVerticalAlignRun.Enum.forInt(paramVerticalAlign.getValue()));
/*      */   }
/*      */   
/*      */   public int getKerning() {
/*  618 */     CTRPr cTRPr = this.run.getRPr();
/*  619 */     if (cTRPr == null || !cTRPr.isSetKern())
/*  620 */       return 0; 
/*  621 */     return cTRPr.getKern().getVal().intValue();
/*      */   }
/*      */   
/*      */   public void setKerning(int paramInt) {
/*  625 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  626 */     CTHpsMeasure cTHpsMeasure = cTRPr.isSetKern() ? cTRPr.getKern() : cTRPr.addNewKern();
/*  627 */     cTHpsMeasure.setVal(BigInteger.valueOf(paramInt));
/*      */   }
/*      */   
/*      */   public boolean isHighlighted() {
/*  631 */     CTRPr cTRPr = this.run.getRPr();
/*  632 */     if (cTRPr == null || !cTRPr.isSetHighlight())
/*  633 */       return false; 
/*  634 */     if (cTRPr.getHighlight().getVal() == STHighlightColor.NONE)
/*  635 */       return false; 
/*  636 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCharacterSpacing() {
/*  642 */     CTRPr cTRPr = this.run.getRPr();
/*  643 */     if (cTRPr == null || !cTRPr.isSetSpacing())
/*  644 */       return 0; 
/*  645 */     return cTRPr.getSpacing().getVal().intValue();
/*      */   }
/*      */   
/*      */   public void setCharacterSpacing(int paramInt) {
/*  649 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  650 */     CTSignedTwipsMeasure cTSignedTwipsMeasure = cTRPr.isSetSpacing() ? cTRPr.getSpacing() : cTRPr.addNewSpacing();
/*  651 */     cTSignedTwipsMeasure.setVal(BigInteger.valueOf(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFontFamily() {
/*  662 */     return getFontFamily(null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFontFamily(String paramString) {
/*  676 */     setFontFamily(paramString, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFontName() {
/*  683 */     return getFontFamily();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFontFamily(FontCharRange paramFontCharRange) {
/*  694 */     CTRPr cTRPr = this.run.getRPr();
/*  695 */     if (cTRPr == null || !cTRPr.isSetRFonts()) return null;
/*      */     
/*  697 */     CTFonts cTFonts = cTRPr.getRFonts();
/*  698 */     switch ((paramFontCharRange == null) ? FontCharRange.ascii : paramFontCharRange)
/*      */     
/*      */     { default:
/*  701 */         return cTFonts.getAscii();
/*      */       case cs:
/*  703 */         return cTFonts.getCs();
/*      */       case eastAsia:
/*  705 */         return cTFonts.getEastAsia();
/*      */       case hAnsi:
/*  707 */         break; }  return cTFonts.getHAnsi();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFontFamily(String paramString, FontCharRange paramFontCharRange) {
/*  721 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  722 */     CTFonts cTFonts = cTRPr.isSetRFonts() ? cTRPr.getRFonts() : cTRPr.addNewRFonts();
/*      */     
/*  724 */     if (paramFontCharRange == null) {
/*  725 */       cTFonts.setAscii(paramString);
/*  726 */       if (!cTFonts.isSetHAnsi()) {
/*  727 */         cTFonts.setHAnsi(paramString);
/*      */       }
/*  729 */       if (!cTFonts.isSetCs()) {
/*  730 */         cTFonts.setCs(paramString);
/*      */       }
/*  732 */       if (!cTFonts.isSetEastAsia()) {
/*  733 */         cTFonts.setEastAsia(paramString);
/*      */       }
/*      */     } else {
/*  736 */       switch (paramFontCharRange) {
/*      */         case ascii:
/*  738 */           cTFonts.setAscii(paramString);
/*      */           break;
/*      */         case cs:
/*  741 */           cTFonts.setCs(paramString);
/*      */           break;
/*      */         case eastAsia:
/*  744 */           cTFonts.setEastAsia(paramString);
/*      */           break;
/*      */         case hAnsi:
/*  747 */           cTFonts.setHAnsi(paramString);
/*      */           break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFontSize() {
/*  760 */     CTRPr cTRPr = this.run.getRPr();
/*  761 */     return (cTRPr != null && cTRPr.isSetSz()) ? cTRPr.getSz().getVal().divide(new BigInteger("2")).intValue() : -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFontSize(int paramInt) {
/*  777 */     BigInteger bigInteger = new BigInteger("" + paramInt);
/*  778 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  779 */     CTHpsMeasure cTHpsMeasure = cTRPr.isSetSz() ? cTRPr.getSz() : cTRPr.addNewSz();
/*  780 */     cTHpsMeasure.setVal(bigInteger.multiply(new BigInteger("2")));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTextPosition() {
/*  792 */     CTRPr cTRPr = this.run.getRPr();
/*  793 */     return (cTRPr != null && cTRPr.isSetPosition()) ? cTRPr.getPosition().getVal().intValue() : -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTextPosition(int paramInt) {
/*  820 */     BigInteger bigInteger = new BigInteger("" + paramInt);
/*  821 */     CTRPr cTRPr = this.run.isSetRPr() ? this.run.getRPr() : this.run.addNewRPr();
/*  822 */     CTSignedHpsMeasure cTSignedHpsMeasure = cTRPr.isSetPosition() ? cTRPr.getPosition() : cTRPr.addNewPosition();
/*  823 */     cTSignedHpsMeasure.setVal(bigInteger);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeBreak() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addBreak() {
/*  843 */     this.run.addNewBr();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addBreak(BreakType paramBreakType) {
/*  861 */     CTBr cTBr = this.run.addNewBr();
/*  862 */     cTBr.setType(STBrType.Enum.forInt(paramBreakType.getValue()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addBreak(BreakClear paramBreakClear) {
/*  879 */     CTBr cTBr = this.run.addNewBr();
/*  880 */     cTBr.setType(STBrType.Enum.forInt(BreakType.TEXT_WRAPPING.getValue()));
/*  881 */     cTBr.setClear(STBrClear.Enum.forInt(paramBreakClear.getValue()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addTab() {
/*  889 */     this.run.addNewTab();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeTab() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addCarriageReturn() {
/*  909 */     this.run.addNewCr();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeCarriageReturn() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFPicture addPicture(InputStream paramInputStream, int paramInt1, String paramString, int paramInt2, int paramInt3) throws InvalidFormatException, IOException {
/*      */     XWPFPictureData xWPFPictureData;
/*  941 */     if (this.parent.getPart() instanceof XWPFHeaderFooter) {
/*  942 */       XWPFHeaderFooter xWPFHeaderFooter = (XWPFHeaderFooter)this.parent.getPart();
/*  943 */       String str = xWPFHeaderFooter.addPictureData(paramInputStream, paramInt1);
/*  944 */       xWPFPictureData = (XWPFPictureData)xWPFHeaderFooter.getRelationById(str);
/*      */     } else {
/*      */       
/*  947 */       XWPFDocument xWPFDocument = this.parent.getDocument();
/*  948 */       String str = xWPFDocument.addPictureData(paramInputStream, paramInt1);
/*  949 */       xWPFPictureData = (XWPFPictureData)xWPFDocument.getRelationById(str);
/*      */     } 
/*      */ 
/*      */     
/*      */     try {
/*  954 */       CTDrawing cTDrawing = this.run.addNewDrawing();
/*  955 */       CTInline cTInline = cTDrawing.addNewInline();
/*      */ 
/*      */ 
/*      */       
/*  959 */       String str = "<a:graphic xmlns:a=\"" + CTGraphicalObject.type.getName().getNamespaceURI() + "\">" + "<a:graphicData uri=\"" + CTPicture.type.getName().getNamespaceURI() + "\">" + "<pic:pic xmlns:pic=\"" + CTPicture.type.getName().getNamespaceURI() + "\" />" + "</a:graphicData>" + "</a:graphic>";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  965 */       InputSource inputSource = new InputSource(new StringReader(str));
/*  966 */       Document document = DocumentHelper.readDocument(inputSource);
/*  967 */       cTInline.set((XmlObject)XmlToken.Factory.parse(document.getDocumentElement(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
/*      */ 
/*      */       
/*  970 */       cTInline.setDistT(0L);
/*  971 */       cTInline.setDistR(0L);
/*  972 */       cTInline.setDistB(0L);
/*  973 */       cTInline.setDistL(0L);
/*      */       
/*  975 */       CTNonVisualDrawingProps cTNonVisualDrawingProps1 = cTInline.addNewDocPr();
/*  976 */       long l = getParent().getDocument().getDrawingIdManager().reserveNew();
/*  977 */       cTNonVisualDrawingProps1.setId(l);
/*      */       
/*  979 */       cTNonVisualDrawingProps1.setName("Drawing " + l);
/*  980 */       cTNonVisualDrawingProps1.setDescr(paramString);
/*      */       
/*  982 */       CTPositiveSize2D cTPositiveSize2D1 = cTInline.addNewExtent();
/*  983 */       cTPositiveSize2D1.setCx(paramInt2);
/*  984 */       cTPositiveSize2D1.setCy(paramInt3);
/*      */ 
/*      */       
/*  987 */       CTGraphicalObject cTGraphicalObject = cTInline.getGraphic();
/*  988 */       CTGraphicalObjectData cTGraphicalObjectData = cTGraphicalObject.getGraphicData();
/*  989 */       CTPicture cTPicture = getCTPictures((XmlObject)cTGraphicalObjectData).get(0);
/*      */ 
/*      */       
/*  992 */       CTPictureNonVisual cTPictureNonVisual = cTPicture.addNewNvPicPr();
/*      */       
/*  994 */       CTNonVisualDrawingProps cTNonVisualDrawingProps2 = cTPictureNonVisual.addNewCNvPr();
/*      */       
/*  996 */       cTNonVisualDrawingProps2.setId(0L);
/*      */       
/*  998 */       cTNonVisualDrawingProps2.setName("Picture " + l);
/*  999 */       cTNonVisualDrawingProps2.setDescr(paramString);
/*      */       
/* 1001 */       CTNonVisualPictureProperties cTNonVisualPictureProperties = cTPictureNonVisual.addNewCNvPicPr();
/* 1002 */       cTNonVisualPictureProperties.addNewPicLocks().setNoChangeAspect(true);
/*      */       
/* 1004 */       CTBlipFillProperties cTBlipFillProperties = cTPicture.addNewBlipFill();
/* 1005 */       CTBlip cTBlip = cTBlipFillProperties.addNewBlip();
/* 1006 */       cTBlip.setEmbed(this.parent.getDocument().getRelationId(xWPFPictureData));
/* 1007 */       cTBlipFillProperties.addNewStretch().addNewFillRect();
/*      */       
/* 1009 */       CTShapeProperties cTShapeProperties = cTPicture.addNewSpPr();
/* 1010 */       CTTransform2D cTTransform2D = cTShapeProperties.addNewXfrm();
/*      */       
/* 1012 */       CTPoint2D cTPoint2D = cTTransform2D.addNewOff();
/* 1013 */       cTPoint2D.setX(0L);
/* 1014 */       cTPoint2D.setY(0L);
/*      */       
/* 1016 */       CTPositiveSize2D cTPositiveSize2D2 = cTTransform2D.addNewExt();
/* 1017 */       cTPositiveSize2D2.setCx(paramInt2);
/* 1018 */       cTPositiveSize2D2.setCy(paramInt3);
/*      */       
/* 1020 */       CTPresetGeometry2D cTPresetGeometry2D = cTShapeProperties.addNewPrstGeom();
/* 1021 */       cTPresetGeometry2D.setPrst(STShapeType.RECT);
/* 1022 */       cTPresetGeometry2D.addNewAvLst();
/*      */ 
/*      */       
/* 1025 */       XWPFPicture xWPFPicture = new XWPFPicture(cTPicture, this);
/* 1026 */       this.pictures.add(xWPFPicture);
/* 1027 */       return xWPFPicture;
/* 1028 */     } catch (XmlException xmlException) {
/* 1029 */       throw new IllegalStateException(xmlException);
/* 1030 */     } catch (SAXException sAXException) {
/* 1031 */       throw new IllegalStateException(sAXException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XWPFPicture> getEmbeddedPictures() {
/* 1041 */     return this.pictures;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1048 */     return text();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String text() {
/* 1056 */     StringBuffer stringBuffer = new StringBuffer();
/*      */ 
/*      */ 
/*      */     
/* 1060 */     XmlCursor xmlCursor = this.run.newCursor();
/* 1061 */     xmlCursor.selectPath("./*");
/* 1062 */     while (xmlCursor.toNextSelection()) {
/* 1063 */       XmlObject xmlObject = xmlCursor.getObject();
/* 1064 */       if (xmlObject instanceof CTText) {
/* 1065 */         String str = xmlObject.getDomNode().getNodeName();
/*      */ 
/*      */ 
/*      */         
/* 1069 */         if (!"w:instrText".equals(str)) {
/* 1070 */           stringBuffer.append(((CTText)xmlObject).getStringValue());
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 1075 */       if (xmlObject instanceof CTFldChar) {
/* 1076 */         CTFldChar cTFldChar = (CTFldChar)xmlObject;
/* 1077 */         if (cTFldChar.getFldCharType() == STFldCharType.BEGIN && 
/* 1078 */           cTFldChar.getFfData() != null) {
/* 1079 */           for (CTFFCheckBox cTFFCheckBox : cTFldChar.getFfData().getCheckBoxList()) {
/* 1080 */             if (cTFFCheckBox.getDefault().getVal() == STOnOff.X_1) {
/* 1081 */               stringBuffer.append("|X|"); continue;
/*      */             } 
/* 1083 */             stringBuffer.append("|_|");
/*      */           } 
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1090 */       if (xmlObject instanceof org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab) {
/* 1091 */         stringBuffer.append("\t");
/*      */       }
/* 1093 */       if (xmlObject instanceof CTBr) {
/* 1094 */         stringBuffer.append("\n");
/*      */       }
/* 1096 */       if (xmlObject instanceof org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1102 */         String str = xmlObject.getDomNode().getNodeName();
/* 1103 */         if ("w:tab".equals(str) || "tab".equals(str)) {
/* 1104 */           stringBuffer.append("\t");
/*      */         }
/* 1106 */         if ("w:br".equals(str) || "br".equals(str)) {
/* 1107 */           stringBuffer.append("\n");
/*      */         }
/* 1109 */         if ("w:cr".equals(str) || "cr".equals(str)) {
/* 1110 */           stringBuffer.append("\n");
/*      */         }
/*      */       } 
/* 1113 */       if (xmlObject instanceof CTFtnEdnRef) {
/* 1114 */         CTFtnEdnRef cTFtnEdnRef = (CTFtnEdnRef)xmlObject;
/* 1115 */         String str = cTFtnEdnRef.getDomNode().getLocalName().equals("footnoteReference") ? ("[footnoteRef:" + cTFtnEdnRef.getId().intValue() + "]") : ("[endnoteRef:" + cTFtnEdnRef.getId().intValue() + "]");
/*      */         
/* 1117 */         stringBuffer.append(str);
/*      */       } 
/*      */     } 
/*      */     
/* 1121 */     xmlCursor.dispose();
/*      */ 
/*      */     
/* 1124 */     if (this.pictureText != null && this.pictureText.length() > 0) {
/* 1125 */       stringBuffer.append("\n").append(this.pictureText);
/*      */     }
/*      */     
/* 1128 */     return stringBuffer.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public enum FontCharRange
/*      */   {
/* 1135 */     ascii,
/* 1136 */     cs,
/* 1137 */     eastAsia,
/* 1138 */     hAnsi;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFRun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */