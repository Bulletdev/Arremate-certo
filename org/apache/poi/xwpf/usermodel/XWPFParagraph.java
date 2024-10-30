/*      */ package org.apache.poi.xwpf.usermodel;
/*      */ 
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import org.apache.poi.POIXMLDocumentPart;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.wp.usermodel.Paragraph;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
/*      */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment;
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
/*      */ 
/*      */ 
/*      */ public class XWPFParagraph
/*      */   implements Paragraph, IBodyElement, IRunBody, ISDTContents
/*      */ {
/*      */   private final CTP paragraph;
/*      */   protected IBody part;
/*      */   protected XWPFDocument document;
/*      */   protected List<XWPFRun> runs;
/*      */   protected List<IRunElement> iruns;
/*   78 */   private StringBuffer footnoteText = new StringBuffer();
/*      */   
/*      */   public XWPFParagraph(CTP paramCTP, IBody paramIBody) {
/*   81 */     this.paragraph = paramCTP;
/*   82 */     this.part = paramIBody;
/*      */     
/*   84 */     this.document = paramIBody.getXWPFDocument();
/*      */     
/*   86 */     if (this.document == null) {
/*   87 */       throw new NullPointerException();
/*      */     }
/*      */ 
/*      */     
/*   91 */     this.runs = new ArrayList<XWPFRun>();
/*   92 */     this.iruns = new ArrayList<IRunElement>();
/*   93 */     buildRunsInOrderFromXml((XmlObject)this.paragraph);
/*      */ 
/*      */     
/*   96 */     for (XWPFRun xWPFRun : this.runs) {
/*   97 */       CTR cTR = xWPFRun.getCTR();
/*      */ 
/*      */ 
/*      */       
/*  101 */       XmlCursor xmlCursor = cTR.newCursor();
/*  102 */       xmlCursor.selectPath("child::*");
/*  103 */       while (xmlCursor.toNextSelection()) {
/*  104 */         XmlObject xmlObject = xmlCursor.getObject();
/*  105 */         if (xmlObject instanceof CTFtnEdnRef) {
/*  106 */           CTFtnEdnRef cTFtnEdnRef = (CTFtnEdnRef)xmlObject;
/*  107 */           this.footnoteText.append(" [").append(cTFtnEdnRef.getId()).append(": ");
/*  108 */           XWPFFootnote xWPFFootnote = cTFtnEdnRef.getDomNode().getLocalName().equals("footnoteReference") ? this.document.getFootnoteByID(cTFtnEdnRef.getId().intValue()) : this.document.getEndnoteByID(cTFtnEdnRef.getId().intValue());
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  113 */           boolean bool = true;
/*  114 */           for (XWPFParagraph xWPFParagraph : xWPFFootnote.getParagraphs()) {
/*  115 */             if (!bool) {
/*  116 */               this.footnoteText.append("\n");
/*  117 */               bool = false;
/*      */             } 
/*  119 */             this.footnoteText.append(xWPFParagraph.getText());
/*      */           } 
/*      */           
/*  122 */           this.footnoteText.append("] ");
/*      */         } 
/*      */       } 
/*  125 */       xmlCursor.dispose();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void buildRunsInOrderFromXml(XmlObject paramXmlObject) {
/*  136 */     XmlCursor xmlCursor = paramXmlObject.newCursor();
/*  137 */     xmlCursor.selectPath("child::*");
/*  138 */     while (xmlCursor.toNextSelection()) {
/*  139 */       XmlObject xmlObject = xmlCursor.getObject();
/*  140 */       if (xmlObject instanceof CTR) {
/*  141 */         XWPFRun xWPFRun = new XWPFRun((CTR)xmlObject, this);
/*  142 */         this.runs.add(xWPFRun);
/*  143 */         this.iruns.add(xWPFRun);
/*      */       } 
/*  145 */       if (xmlObject instanceof CTHyperlink) {
/*  146 */         CTHyperlink cTHyperlink = (CTHyperlink)xmlObject;
/*  147 */         for (CTR cTR : cTHyperlink.getRArray()) {
/*  148 */           XWPFHyperlinkRun xWPFHyperlinkRun = new XWPFHyperlinkRun(cTHyperlink, cTR, this);
/*  149 */           this.runs.add(xWPFHyperlinkRun);
/*  150 */           this.iruns.add(xWPFHyperlinkRun);
/*      */         } 
/*      */       } 
/*  153 */       if (xmlObject instanceof CTSimpleField) {
/*  154 */         CTSimpleField cTSimpleField = (CTSimpleField)xmlObject;
/*  155 */         for (CTR cTR : cTSimpleField.getRArray()) {
/*  156 */           XWPFFieldRun xWPFFieldRun = new XWPFFieldRun(cTSimpleField, cTR, this);
/*  157 */           this.runs.add(xWPFFieldRun);
/*  158 */           this.iruns.add(xWPFFieldRun);
/*      */         } 
/*      */       } 
/*  161 */       if (xmlObject instanceof CTSdtBlock) {
/*  162 */         XWPFSDT xWPFSDT = new XWPFSDT((CTSdtBlock)xmlObject, this.part);
/*  163 */         this.iruns.add(xWPFSDT);
/*      */       } 
/*  165 */       if (xmlObject instanceof CTSdtRun) {
/*  166 */         XWPFSDT xWPFSDT = new XWPFSDT((CTSdtRun)xmlObject, this.part);
/*  167 */         this.iruns.add(xWPFSDT);
/*      */       } 
/*  169 */       if (xmlObject instanceof CTRunTrackChange) {
/*  170 */         for (CTR cTR : ((CTRunTrackChange)xmlObject).getRArray()) {
/*  171 */           XWPFRun xWPFRun = new XWPFRun(cTR, this);
/*  172 */           this.runs.add(xWPFRun);
/*  173 */           this.iruns.add(xWPFRun);
/*      */         } 
/*      */       }
/*  176 */       if (xmlObject instanceof org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun)
/*      */       {
/*      */         
/*  179 */         buildRunsInOrderFromXml(xmlObject);
/*      */       }
/*      */     } 
/*  182 */     xmlCursor.dispose();
/*      */   }
/*      */   
/*      */   @Internal
/*      */   public CTP getCTP() {
/*  187 */     return this.paragraph;
/*      */   }
/*      */   
/*      */   public List<XWPFRun> getRuns() {
/*  191 */     return Collections.unmodifiableList(this.runs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<IRunElement> getIRuns() {
/*  200 */     return Collections.unmodifiableList(this.iruns);
/*      */   }
/*      */   
/*      */   public boolean isEmpty() {
/*  204 */     return !this.paragraph.getDomNode().hasChildNodes();
/*      */   }
/*      */   
/*      */   public XWPFDocument getDocument() {
/*  208 */     return this.document;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getText() {
/*  216 */     StringBuffer stringBuffer = new StringBuffer();
/*  217 */     for (IRunElement iRunElement : this.iruns) {
/*  218 */       if (iRunElement instanceof XWPFRun) {
/*  219 */         XWPFRun xWPFRun = (XWPFRun)iRunElement;
/*      */         
/*  221 */         if (!xWPFRun.getCTR().isSetRsidDel())
/*  222 */           stringBuffer.append(xWPFRun.toString());  continue;
/*      */       } 
/*  224 */       if (iRunElement instanceof XWPFSDT) {
/*  225 */         stringBuffer.append(((XWPFSDT)iRunElement).getContent().getText()); continue;
/*      */       } 
/*  227 */       stringBuffer.append(iRunElement.toString());
/*      */     } 
/*      */     
/*  230 */     stringBuffer.append(this.footnoteText);
/*  231 */     return stringBuffer.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStyleID() {
/*  241 */     if (this.paragraph.getPPr() != null && 
/*  242 */       this.paragraph.getPPr().getPStyle() != null && 
/*  243 */       this.paragraph.getPPr().getPStyle().getVal() != null) {
/*  244 */       return this.paragraph.getPPr().getPStyle().getVal();
/*      */     }
/*      */     
/*  247 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigInteger getNumID() {
/*  258 */     if (this.paragraph.getPPr() != null && 
/*  259 */       this.paragraph.getPPr().getNumPr() != null && 
/*  260 */       this.paragraph.getPPr().getNumPr().getNumId() != null) {
/*  261 */       return this.paragraph.getPPr().getNumPr().getNumId().getVal();
/*      */     }
/*      */     
/*  264 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNumID(BigInteger paramBigInteger) {
/*  273 */     if (this.paragraph.getPPr() == null)
/*  274 */       this.paragraph.addNewPPr(); 
/*  275 */     if (this.paragraph.getPPr().getNumPr() == null)
/*  276 */       this.paragraph.getPPr().addNewNumPr(); 
/*  277 */     if (this.paragraph.getPPr().getNumPr().getNumId() == null) {
/*  278 */       this.paragraph.getPPr().getNumPr().addNewNumId();
/*      */     }
/*  280 */     this.paragraph.getPPr().getNumPr().getNumId().setVal(paramBigInteger);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigInteger getNumIlvl() {
/*  290 */     if (this.paragraph.getPPr() != null && 
/*  291 */       this.paragraph.getPPr().getNumPr() != null && 
/*  292 */       this.paragraph.getPPr().getNumPr().getIlvl() != null) {
/*  293 */       return this.paragraph.getPPr().getNumPr().getIlvl().getVal();
/*      */     }
/*      */     
/*  296 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNumFmt() {
/*  305 */     BigInteger bigInteger = getNumID();
/*  306 */     XWPFNumbering xWPFNumbering = this.document.getNumbering();
/*  307 */     if (bigInteger != null && xWPFNumbering != null) {
/*  308 */       XWPFNum xWPFNum = xWPFNumbering.getNum(bigInteger);
/*  309 */       if (xWPFNum != null) {
/*  310 */         BigInteger bigInteger1 = getNumIlvl();
/*  311 */         BigInteger bigInteger2 = xWPFNum.getCTNum().getAbstractNumId().getVal();
/*  312 */         CTAbstractNum cTAbstractNum = xWPFNumbering.getAbstractNum(bigInteger2).getAbstractNum();
/*  313 */         CTLvl cTLvl = null;
/*  314 */         for (byte b = 0; b < cTAbstractNum.sizeOfLvlArray(); b++) {
/*  315 */           CTLvl cTLvl1 = cTAbstractNum.getLvlArray(b);
/*  316 */           if (cTLvl1.getIlvl().equals(bigInteger1)) {
/*  317 */             cTLvl = cTLvl1;
/*      */             break;
/*      */           } 
/*      */         } 
/*  321 */         if (cTLvl != null && cTLvl.getNumFmt() != null && cTLvl.getNumFmt().getVal() != null)
/*      */         {
/*  323 */           return cTLvl.getNumFmt().getVal().toString(); } 
/*      */       } 
/*      */     } 
/*  326 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNumLevelText() {
/*  335 */     BigInteger bigInteger = getNumID();
/*  336 */     XWPFNumbering xWPFNumbering = this.document.getNumbering();
/*  337 */     if (bigInteger != null && xWPFNumbering != null) {
/*  338 */       XWPFNum xWPFNum = xWPFNumbering.getNum(bigInteger);
/*  339 */       if (xWPFNum != null) {
/*  340 */         BigInteger bigInteger1 = getNumIlvl();
/*  341 */         CTNum cTNum = xWPFNum.getCTNum();
/*  342 */         if (cTNum == null) {
/*  343 */           return null;
/*      */         }
/*  345 */         CTDecimalNumber cTDecimalNumber = cTNum.getAbstractNumId();
/*  346 */         if (cTDecimalNumber == null) {
/*  347 */           return null;
/*      */         }
/*  349 */         BigInteger bigInteger2 = cTDecimalNumber.getVal();
/*  350 */         if (bigInteger2 == null) {
/*  351 */           return null;
/*      */         }
/*  353 */         XWPFAbstractNum xWPFAbstractNum = xWPFNumbering.getAbstractNum(bigInteger2);
/*      */         
/*  355 */         if (xWPFAbstractNum == null) {
/*  356 */           return null;
/*      */         }
/*  358 */         CTAbstractNum cTAbstractNum = xWPFAbstractNum.getCTAbstractNum();
/*      */         
/*  360 */         if (cTAbstractNum == null) {
/*  361 */           return null;
/*      */         }
/*  363 */         CTLvl cTLvl = null;
/*  364 */         for (byte b = 0; b < cTAbstractNum.sizeOfLvlArray(); b++) {
/*  365 */           CTLvl cTLvl1 = cTAbstractNum.getLvlArray(b);
/*  366 */           if (cTLvl1 != null && cTLvl1.getIlvl() != null && cTLvl1.getIlvl().equals(bigInteger1)) {
/*  367 */             cTLvl = cTLvl1;
/*      */             break;
/*      */           } 
/*      */         } 
/*  371 */         if (cTLvl != null && cTLvl.getLvlText() != null && cTLvl.getLvlText().getVal() != null)
/*      */         {
/*  373 */           return cTLvl.getLvlText().getVal().toString(); } 
/*      */       } 
/*      */     } 
/*  376 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigInteger getNumStartOverride() {
/*  385 */     BigInteger bigInteger = getNumID();
/*  386 */     XWPFNumbering xWPFNumbering = this.document.getNumbering();
/*  387 */     if (bigInteger != null && xWPFNumbering != null) {
/*  388 */       XWPFNum xWPFNum = xWPFNumbering.getNum(bigInteger);
/*      */       
/*  390 */       if (xWPFNum != null) {
/*  391 */         CTNum cTNum = xWPFNum.getCTNum();
/*  392 */         if (cTNum == null) {
/*  393 */           return null;
/*      */         }
/*  395 */         BigInteger bigInteger1 = getNumIlvl();
/*  396 */         CTNumLvl cTNumLvl = null;
/*  397 */         for (byte b = 0; b < cTNum.sizeOfLvlOverrideArray(); b++) {
/*  398 */           CTNumLvl cTNumLvl1 = cTNum.getLvlOverrideArray(b);
/*  399 */           if (cTNumLvl1 != null && cTNumLvl1.getIlvl() != null && cTNumLvl1.getIlvl().equals(bigInteger1)) {
/*      */             
/*  401 */             cTNumLvl = cTNumLvl1;
/*      */             break;
/*      */           } 
/*      */         } 
/*  405 */         if (cTNumLvl != null && cTNumLvl.getStartOverride() != null) {
/*  406 */           return cTNumLvl.getStartOverride().getVal();
/*      */         }
/*      */       } 
/*      */     } 
/*  410 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getParagraphText() {
/*  418 */     StringBuffer stringBuffer = new StringBuffer();
/*  419 */     for (XWPFRun xWPFRun : this.runs) {
/*  420 */       stringBuffer.append(xWPFRun.toString());
/*      */     }
/*  422 */     return stringBuffer.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPictureText() {
/*  429 */     StringBuffer stringBuffer = new StringBuffer();
/*  430 */     for (XWPFRun xWPFRun : this.runs) {
/*  431 */       stringBuffer.append(xWPFRun.getPictureText());
/*      */     }
/*  433 */     return stringBuffer.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFootnoteText() {
/*  442 */     return this.footnoteText.toString();
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
/*      */   public ParagraphAlignment getAlignment() {
/*  460 */     CTPPr cTPPr = getCTPPr();
/*  461 */     return (cTPPr == null || !cTPPr.isSetJc()) ? ParagraphAlignment.LEFT : ParagraphAlignment.valueOf(cTPPr.getJc().getVal().intValue());
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
/*      */   public void setAlignment(ParagraphAlignment paramParagraphAlignment) {
/*  480 */     CTPPr cTPPr = getCTPPr();
/*  481 */     CTJc cTJc = cTPPr.isSetJc() ? cTPPr.getJc() : cTPPr.addNewJc();
/*  482 */     STJc.Enum enum_ = STJc.Enum.forInt(paramParagraphAlignment.getValue());
/*  483 */     cTJc.setVal(enum_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFontAlignment() {
/*  490 */     return getAlignment().getValue();
/*      */   }
/*      */   
/*      */   public void setFontAlignment(int paramInt) {
/*  494 */     ParagraphAlignment paragraphAlignment = ParagraphAlignment.valueOf(paramInt);
/*  495 */     setAlignment(paragraphAlignment);
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
/*      */   public TextAlignment getVerticalAlignment() {
/*  517 */     CTPPr cTPPr = getCTPPr();
/*  518 */     return (cTPPr == null || !cTPPr.isSetTextAlignment()) ? TextAlignment.AUTO : TextAlignment.valueOf(cTPPr.getTextAlignment().getVal().intValue());
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
/*      */   public void setVerticalAlignment(TextAlignment paramTextAlignment) {
/*  543 */     CTPPr cTPPr = getCTPPr();
/*  544 */     CTTextAlignment cTTextAlignment = cTPPr.isSetTextAlignment() ? cTPPr.getTextAlignment() : cTPPr.addNewTextAlignment();
/*      */     
/*  546 */     STTextAlignment.Enum enum_ = STTextAlignment.Enum.forInt(paramTextAlignment.getValue());
/*      */     
/*  548 */     cTTextAlignment.setVal(enum_);
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
/*      */   public Borders getBorderTop() {
/*  560 */     CTPBdr cTPBdr = getCTPBrd(false);
/*  561 */     CTBorder cTBorder = null;
/*  562 */     if (cTPBdr != null) {
/*  563 */       cTBorder = cTPBdr.getTop();
/*      */     }
/*  565 */     STBorder.Enum enum_ = (cTBorder != null) ? cTBorder.getVal() : STBorder.NONE;
/*  566 */     return Borders.valueOf(enum_.intValue());
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
/*      */ 
/*      */   
/*      */   public void setBorderTop(Borders paramBorders) {
/*  597 */     CTPBdr cTPBdr = getCTPBrd(true);
/*  598 */     if (cTPBdr == null) {
/*  599 */       throw new RuntimeException("invalid paragraph state");
/*      */     }
/*      */     
/*  602 */     CTBorder cTBorder = cTPBdr.isSetTop() ? cTPBdr.getTop() : cTPBdr.addNewTop();
/*  603 */     if (paramBorders.getValue() == Borders.NONE.getValue()) {
/*  604 */       cTPBdr.unsetTop();
/*      */     } else {
/*  606 */       cTBorder.setVal(STBorder.Enum.forInt(paramBorders.getValue()));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Borders getBorderBottom() {
/*  618 */     CTPBdr cTPBdr = getCTPBrd(false);
/*  619 */     CTBorder cTBorder = null;
/*  620 */     if (cTPBdr != null) {
/*  621 */       cTBorder = cTPBdr.getBottom();
/*      */     }
/*  623 */     STBorder.Enum enum_ = (cTBorder != null) ? cTBorder.getVal() : STBorder.NONE;
/*  624 */     return Borders.valueOf(enum_.intValue());
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
/*      */ 
/*      */   
/*      */   public void setBorderBottom(Borders paramBorders) {
/*  655 */     CTPBdr cTPBdr = getCTPBrd(true);
/*  656 */     CTBorder cTBorder = cTPBdr.isSetBottom() ? cTPBdr.getBottom() : cTPBdr.addNewBottom();
/*  657 */     if (paramBorders.getValue() == Borders.NONE.getValue()) {
/*  658 */       cTPBdr.unsetBottom();
/*      */     } else {
/*  660 */       cTBorder.setVal(STBorder.Enum.forInt(paramBorders.getValue()));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Borders getBorderLeft() {
/*  672 */     CTPBdr cTPBdr = getCTPBrd(false);
/*  673 */     CTBorder cTBorder = null;
/*  674 */     if (cTPBdr != null) {
/*  675 */       cTBorder = cTPBdr.getLeft();
/*      */     }
/*  677 */     STBorder.Enum enum_ = (cTBorder != null) ? cTBorder.getVal() : STBorder.NONE;
/*  678 */     return Borders.valueOf(enum_.intValue());
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
/*      */   public void setBorderLeft(Borders paramBorders) {
/*  704 */     CTPBdr cTPBdr = getCTPBrd(true);
/*  705 */     CTBorder cTBorder = cTPBdr.isSetLeft() ? cTPBdr.getLeft() : cTPBdr.addNewLeft();
/*  706 */     if (paramBorders.getValue() == Borders.NONE.getValue()) {
/*  707 */       cTPBdr.unsetLeft();
/*      */     } else {
/*  709 */       cTBorder.setVal(STBorder.Enum.forInt(paramBorders.getValue()));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Borders getBorderRight() {
/*  721 */     CTPBdr cTPBdr = getCTPBrd(false);
/*  722 */     CTBorder cTBorder = null;
/*  723 */     if (cTPBdr != null) {
/*  724 */       cTBorder = cTPBdr.getRight();
/*      */     }
/*  726 */     STBorder.Enum enum_ = (cTBorder != null) ? cTBorder.getVal() : STBorder.NONE;
/*  727 */     return Borders.valueOf(enum_.intValue());
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
/*      */   public void setBorderRight(Borders paramBorders) {
/*  753 */     CTPBdr cTPBdr = getCTPBrd(true);
/*  754 */     CTBorder cTBorder = cTPBdr.isSetRight() ? cTPBdr.getRight() : cTPBdr.addNewRight();
/*  755 */     if (paramBorders.getValue() == Borders.NONE.getValue()) {
/*  756 */       cTPBdr.unsetRight();
/*      */     } else {
/*  758 */       cTBorder.setVal(STBorder.Enum.forInt(paramBorders.getValue()));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Borders getBorderBetween() {
/*  770 */     CTPBdr cTPBdr = getCTPBrd(false);
/*  771 */     CTBorder cTBorder = null;
/*  772 */     if (cTPBdr != null) {
/*  773 */       cTBorder = cTPBdr.getBetween();
/*      */     }
/*  775 */     STBorder.Enum enum_ = (cTBorder != null) ? cTBorder.getVal() : STBorder.NONE;
/*  776 */     return Borders.valueOf(enum_.intValue());
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
/*      */   
/*      */   public void setBorderBetween(Borders paramBorders) {
/*  806 */     CTPBdr cTPBdr = getCTPBrd(true);
/*  807 */     CTBorder cTBorder = cTPBdr.isSetBetween() ? cTPBdr.getBetween() : cTPBdr.addNewBetween();
/*  808 */     if (paramBorders.getValue() == Borders.NONE.getValue()) {
/*  809 */       cTPBdr.unsetBetween();
/*      */     } else {
/*  811 */       cTBorder.setVal(STBorder.Enum.forInt(paramBorders.getValue()));
/*      */     } 
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
/*      */   public boolean isPageBreak() {
/*  830 */     CTPPr cTPPr = getCTPPr();
/*  831 */     CTOnOff cTOnOff = cTPPr.isSetPageBreakBefore() ? cTPPr.getPageBreakBefore() : null;
/*      */     
/*  833 */     if (cTOnOff != null && cTOnOff.getVal().intValue() == 1)
/*      */     {
/*  835 */       return true;
/*      */     }
/*  837 */     return false;
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
/*      */   public void setPageBreak(boolean paramBoolean) {
/*  857 */     CTPPr cTPPr = getCTPPr();
/*  858 */     CTOnOff cTOnOff = cTPPr.isSetPageBreakBefore() ? cTPPr.getPageBreakBefore() : cTPPr.addNewPageBreakBefore();
/*      */     
/*  860 */     if (paramBoolean) {
/*  861 */       cTOnOff.setVal(STOnOff.TRUE);
/*      */     } else {
/*  863 */       cTOnOff.setVal(STOnOff.FALSE);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSpacingAfter() {
/*  873 */     CTSpacing cTSpacing = getCTSpacing(false);
/*  874 */     return (cTSpacing != null && cTSpacing.isSetAfter()) ? cTSpacing.getAfter().intValue() : -1;
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
/*      */   public void setSpacingAfter(int paramInt) {
/*  890 */     CTSpacing cTSpacing = getCTSpacing(true);
/*  891 */     if (cTSpacing != null) {
/*  892 */       BigInteger bigInteger = new BigInteger("" + paramInt);
/*  893 */       cTSpacing.setAfter(bigInteger);
/*      */     } 
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
/*      */   public int getSpacingAfterLines() {
/*  906 */     CTSpacing cTSpacing = getCTSpacing(false);
/*  907 */     return (cTSpacing != null && cTSpacing.isSetAfterLines()) ? cTSpacing.getAfterLines().intValue() : -1;
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
/*      */   public void setSpacingAfterLines(int paramInt) {
/*  928 */     CTSpacing cTSpacing = getCTSpacing(true);
/*  929 */     BigInteger bigInteger = new BigInteger("" + paramInt);
/*  930 */     cTSpacing.setAfterLines(bigInteger);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSpacingBefore() {
/*  941 */     CTSpacing cTSpacing = getCTSpacing(false);
/*  942 */     return (cTSpacing != null && cTSpacing.isSetBefore()) ? cTSpacing.getBefore().intValue() : -1;
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
/*      */   public void setSpacingBefore(int paramInt) {
/*  956 */     CTSpacing cTSpacing = getCTSpacing(true);
/*  957 */     BigInteger bigInteger = new BigInteger("" + paramInt);
/*  958 */     cTSpacing.setBefore(bigInteger);
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
/*      */   public int getSpacingBeforeLines() {
/*  970 */     CTSpacing cTSpacing = getCTSpacing(false);
/*  971 */     return (cTSpacing != null && cTSpacing.isSetBeforeLines()) ? cTSpacing.getBeforeLines().intValue() : -1;
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
/*      */   public void setSpacingBeforeLines(int paramInt) {
/*  987 */     CTSpacing cTSpacing = getCTSpacing(true);
/*  988 */     BigInteger bigInteger = new BigInteger("" + paramInt);
/*  989 */     cTSpacing.setBeforeLines(bigInteger);
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
/*      */   public LineSpacingRule getSpacingLineRule() {
/* 1002 */     CTSpacing cTSpacing = getCTSpacing(false);
/* 1003 */     return (cTSpacing != null && cTSpacing.isSetLineRule()) ? LineSpacingRule.valueOf(cTSpacing.getLineRule().intValue()) : LineSpacingRule.AUTO;
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
/*      */   public void setSpacingLineRule(LineSpacingRule paramLineSpacingRule) {
/* 1016 */     CTSpacing cTSpacing = getCTSpacing(true);
/* 1017 */     cTSpacing.setLineRule(STLineSpacingRule.Enum.forInt(paramLineSpacingRule.getValue()));
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
/*      */   public int getIndentationLeft() {
/* 1034 */     CTInd cTInd = getCTInd(false);
/* 1035 */     return (cTInd != null && cTInd.isSetLeft()) ? cTInd.getLeft().intValue() : -1;
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
/*      */   public void setIndentationLeft(int paramInt) {
/* 1053 */     CTInd cTInd = getCTInd(true);
/* 1054 */     BigInteger bigInteger = new BigInteger("" + paramInt);
/* 1055 */     cTInd.setLeft(bigInteger);
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
/*      */   public int getIndentationRight() {
/* 1073 */     CTInd cTInd = getCTInd(false);
/* 1074 */     return (cTInd != null && cTInd.isSetRight()) ? cTInd.getRight().intValue() : -1;
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
/*      */   public void setIndentationRight(int paramInt) {
/* 1092 */     CTInd cTInd = getCTInd(true);
/* 1093 */     BigInteger bigInteger = new BigInteger("" + paramInt);
/* 1094 */     cTInd.setRight(bigInteger);
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
/*      */   public int getIndentationHanging() {
/* 1111 */     CTInd cTInd = getCTInd(false);
/* 1112 */     return (cTInd != null && cTInd.isSetHanging()) ? cTInd.getHanging().intValue() : -1;
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
/*      */   public void setIndentationHanging(int paramInt) {
/* 1130 */     CTInd cTInd = getCTInd(true);
/* 1131 */     BigInteger bigInteger = new BigInteger("" + paramInt);
/* 1132 */     cTInd.setHanging(bigInteger);
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
/*      */   public int getIndentationFirstLine() {
/* 1151 */     CTInd cTInd = getCTInd(false);
/* 1152 */     return (cTInd != null && cTInd.isSetFirstLine()) ? cTInd.getFirstLine().intValue() : -1;
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
/*      */   public void setIndentationFirstLine(int paramInt) {
/* 1171 */     CTInd cTInd = getCTInd(true);
/* 1172 */     BigInteger bigInteger = new BigInteger("" + paramInt);
/* 1173 */     cTInd.setFirstLine(bigInteger);
/*      */   }
/*      */   
/*      */   public int getIndentFromLeft() {
/* 1177 */     return getIndentationLeft();
/*      */   }
/*      */   
/*      */   public void setIndentFromLeft(int paramInt) {
/* 1181 */     setIndentationLeft(paramInt);
/*      */   }
/*      */   
/*      */   public int getIndentFromRight() {
/* 1185 */     return getIndentationRight();
/*      */   }
/*      */   
/*      */   public void setIndentFromRight(int paramInt) {
/* 1189 */     setIndentationRight(paramInt);
/*      */   }
/*      */   
/*      */   public int getFirstLineIndent() {
/* 1193 */     return getIndentationFirstLine();
/*      */   }
/*      */   
/*      */   public void setFirstLineIndent(int paramInt) {
/* 1197 */     setIndentationFirstLine(paramInt);
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
/*      */   public boolean isWordWrapped() {
/* 1209 */     CTOnOff cTOnOff = getCTPPr().isSetWordWrap() ? getCTPPr().getWordWrap() : null;
/*      */     
/* 1211 */     if (cTOnOff != null) {
/* 1212 */       return (cTOnOff.getVal() == STOnOff.ON || cTOnOff.getVal() == STOnOff.TRUE || cTOnOff.getVal() == STOnOff.X_1);
/*      */     }
/*      */ 
/*      */     
/* 1216 */     return false;
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
/*      */   public void setWordWrapped(boolean paramBoolean) {
/* 1228 */     CTOnOff cTOnOff = getCTPPr().isSetWordWrap() ? getCTPPr().getWordWrap() : getCTPPr().addNewWordWrap();
/*      */     
/* 1230 */     if (paramBoolean) {
/* 1231 */       cTOnOff.setVal(STOnOff.TRUE);
/*      */     } else {
/* 1233 */       cTOnOff.unsetVal();
/*      */     } 
/*      */   }
/*      */   public boolean isWordWrap() {
/* 1237 */     return isWordWrapped();
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   public void setWordWrap(boolean paramBoolean) {
/* 1242 */     setWordWrapped(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStyle() {
/* 1249 */     CTPPr cTPPr = getCTPPr();
/* 1250 */     CTString cTString = cTPPr.isSetPStyle() ? cTPPr.getPStyle() : null;
/* 1251 */     return (cTString != null) ? cTString.getVal() : null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStyle(String paramString) {
/* 1261 */     CTPPr cTPPr = getCTPPr();
/* 1262 */     CTString cTString = (cTPPr.getPStyle() != null) ? cTPPr.getPStyle() : cTPPr.addNewPStyle();
/* 1263 */     cTString.setVal(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CTPBdr getCTPBrd(boolean paramBoolean) {
/* 1271 */     CTPPr cTPPr = getCTPPr();
/* 1272 */     CTPBdr cTPBdr = cTPPr.isSetPBdr() ? cTPPr.getPBdr() : null;
/* 1273 */     if (paramBoolean && cTPBdr == null)
/* 1274 */       cTPBdr = cTPPr.addNewPBdr(); 
/* 1275 */     return cTPBdr;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CTSpacing getCTSpacing(boolean paramBoolean) {
/* 1283 */     CTPPr cTPPr = getCTPPr();
/* 1284 */     CTSpacing cTSpacing = (cTPPr.getSpacing() == null) ? null : cTPPr.getSpacing();
/* 1285 */     if (paramBoolean && cTSpacing == null)
/* 1286 */       cTSpacing = cTPPr.addNewSpacing(); 
/* 1287 */     return cTSpacing;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CTInd getCTInd(boolean paramBoolean) {
/* 1295 */     CTPPr cTPPr = getCTPPr();
/* 1296 */     CTInd cTInd = (cTPPr.getInd() == null) ? null : cTPPr.getInd();
/* 1297 */     if (paramBoolean && cTInd == null)
/* 1298 */       cTInd = cTPPr.addNewInd(); 
/* 1299 */     return cTInd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CTPPr getCTPPr() {
/* 1307 */     return (this.paragraph.getPPr() == null) ? this.paragraph.addNewPPr() : this.paragraph.getPPr();
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
/*      */   protected void addRun(CTR paramCTR) {
/* 1321 */     int i = this.paragraph.sizeOfRArray();
/* 1322 */     this.paragraph.addNewR();
/* 1323 */     this.paragraph.setRArray(i, paramCTR);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFRun createRun() {
/* 1332 */     XWPFRun xWPFRun = new XWPFRun(this.paragraph.addNewR(), this);
/* 1333 */     this.runs.add(xWPFRun);
/* 1334 */     this.iruns.add(xWPFRun);
/* 1335 */     return xWPFRun;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFRun insertNewRun(int paramInt) {
/* 1346 */     if (paramInt >= 0 && paramInt <= this.runs.size()) {
/*      */ 
/*      */ 
/*      */       
/* 1350 */       byte b1 = 0;
/* 1351 */       for (byte b2 = 0; b2 < paramInt; b2++) {
/* 1352 */         XWPFRun xWPFRun1 = this.runs.get(b2);
/* 1353 */         if (!(xWPFRun1 instanceof XWPFHyperlinkRun) && !(xWPFRun1 instanceof XWPFFieldRun))
/*      */         {
/* 1355 */           b1++;
/*      */         }
/*      */       } 
/*      */       
/* 1359 */       CTR cTR = this.paragraph.insertNewR(b1);
/* 1360 */       XWPFRun xWPFRun = new XWPFRun(cTR, this);
/*      */ 
/*      */ 
/*      */       
/* 1364 */       int i = this.iruns.size();
/* 1365 */       if (paramInt < this.runs.size()) {
/* 1366 */         XWPFRun xWPFRun1 = this.runs.get(paramInt);
/* 1367 */         int j = this.iruns.indexOf(xWPFRun1);
/* 1368 */         if (j != -1) {
/* 1369 */           i = j;
/*      */         }
/*      */       } 
/* 1372 */       this.iruns.add(i, xWPFRun);
/*      */ 
/*      */       
/* 1375 */       this.runs.add(paramInt, xWPFRun);
/*      */       
/* 1377 */       return xWPFRun;
/*      */     } 
/*      */     
/* 1380 */     return null;
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
/*      */   public TextSegement searchText(String paramString, PositionInParagraph paramPositionInParagraph) {
/* 1393 */     int i = paramPositionInParagraph.getRun();
/* 1394 */     int j = paramPositionInParagraph.getText();
/* 1395 */     int k = paramPositionInParagraph.getChar();
/* 1396 */     int m = 0; byte b = 0;
/* 1397 */     boolean bool = false;
/*      */     
/* 1399 */     CTR[] arrayOfCTR = this.paragraph.getRArray();
/* 1400 */     for (int n = i; n < arrayOfCTR.length; n++) {
/* 1401 */       byte b1 = 0; int i1 = 0; byte b2 = 0; int i2 = 0;
/* 1402 */       CTR cTR = arrayOfCTR[n];
/* 1403 */       XmlCursor xmlCursor = cTR.newCursor();
/* 1404 */       xmlCursor.selectPath("./*");
/*      */     } 
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
/* 1453 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getText(TextSegement paramTextSegement) {
/* 1462 */     int i = paramTextSegement.getBeginRun();
/* 1463 */     int j = paramTextSegement.getBeginText();
/* 1464 */     int k = paramTextSegement.getBeginChar();
/* 1465 */     int m = paramTextSegement.getEndRun();
/* 1466 */     int n = paramTextSegement.getEndText();
/* 1467 */     int i1 = paramTextSegement.getEndChar();
/* 1468 */     StringBuilder stringBuilder = new StringBuilder();
/* 1469 */     CTR[] arrayOfCTR = this.paragraph.getRArray();
/* 1470 */     for (int i2 = i; i2 <= m; i2++) {
/* 1471 */       CTText[] arrayOfCTText = arrayOfCTR[i2].getTArray();
/* 1472 */       int i3 = 0, i4 = arrayOfCTText.length - 1;
/* 1473 */       if (i2 == i)
/* 1474 */         i3 = j; 
/* 1475 */       if (i2 == m)
/* 1476 */         i4 = n; 
/* 1477 */       for (int i5 = i3; i5 <= i4; i5++) {
/* 1478 */         String str = arrayOfCTText[i5].getStringValue();
/* 1479 */         int i6 = 0, i7 = str.length() - 1;
/* 1480 */         if (i5 == j && i2 == i)
/* 1481 */           i6 = k; 
/* 1482 */         if (i5 == n && i2 == m) {
/* 1483 */           i7 = i1;
/*      */         }
/* 1485 */         stringBuilder.append(str.substring(i6, i7 + 1));
/*      */       } 
/*      */     } 
/* 1488 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean removeRun(int paramInt) {
/* 1498 */     if (paramInt >= 0 && paramInt < this.runs.size()) {
/*      */       
/* 1500 */       XWPFRun xWPFRun = this.runs.get(paramInt);
/* 1501 */       if (xWPFRun instanceof XWPFHyperlinkRun || xWPFRun instanceof XWPFFieldRun)
/*      */       {
/*      */ 
/*      */         
/* 1505 */         throw new IllegalArgumentException("Removing Field or Hyperlink runs not yet supported");
/*      */       }
/* 1507 */       this.runs.remove(paramInt);
/* 1508 */       this.iruns.remove(xWPFRun);
/*      */ 
/*      */       
/* 1511 */       byte b1 = 0;
/* 1512 */       for (byte b2 = 0; b2 < paramInt; b2++) {
/* 1513 */         XWPFRun xWPFRun1 = this.runs.get(b2);
/* 1514 */         if (!(xWPFRun1 instanceof XWPFHyperlinkRun) && !(xWPFRun1 instanceof XWPFFieldRun))
/* 1515 */           b1++; 
/*      */       } 
/* 1517 */       getCTP().removeR(b1);
/* 1518 */       return true;
/*      */     } 
/* 1520 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BodyElementType getElementType() {
/* 1529 */     return BodyElementType.PARAGRAPH;
/*      */   }
/*      */   
/*      */   public IBody getBody() {
/* 1533 */     return this.part;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public POIXMLDocumentPart getPart() {
/* 1542 */     if (this.part != null) {
/* 1543 */       return this.part.getPart();
/*      */     }
/* 1545 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BodyType getPartType() {
/* 1554 */     return this.part.getPartType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addRun(XWPFRun paramXWPFRun) {
/* 1563 */     if (!this.runs.contains(paramXWPFRun)) {
/* 1564 */       this.runs.add(paramXWPFRun);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XWPFRun getRun(CTR paramCTR) {
/* 1574 */     for (byte b = 0; b < getRuns().size(); b++) {
/* 1575 */       if (((XWPFRun)getRuns().get(b)).getCTR() == paramCTR) {
/* 1576 */         return getRuns().get(b);
/*      */       }
/*      */     } 
/* 1579 */     return null;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFParagraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */