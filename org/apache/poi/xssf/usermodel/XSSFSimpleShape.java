/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.hssf.util.HSSFColor;
/*     */ import org.apache.poi.ss.usermodel.VerticalAlignment;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.Units;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextHorzOverflowType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextVertOverflowType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextWrappingType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnderlineValues;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFSimpleShape
/*     */   extends XSSFShape
/*     */   implements Iterable<XSSFTextParagraph>
/*     */ {
/*     */   private final List<XSSFTextParagraph> _paragraphs;
/*  48 */   private static CTShape prototype = null;
/*     */ 
/*     */   
/*     */   private CTShape ctShape;
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFSimpleShape(XSSFDrawing paramXSSFDrawing, CTShape paramCTShape) {
/*  56 */     this.drawing = paramXSSFDrawing;
/*  57 */     this.ctShape = paramCTShape;
/*     */     
/*  59 */     this._paragraphs = new ArrayList<XSSFTextParagraph>();
/*     */ 
/*     */ 
/*     */     
/*  63 */     CTTextBody cTTextBody = paramCTShape.getTxBody();
/*  64 */     if (cTTextBody != null) {
/*  65 */       for (byte b = 0; b < cTTextBody.sizeOfPArray(); b++) {
/*  66 */         this._paragraphs.add(new XSSFTextParagraph(cTTextBody.getPArray(b), paramCTShape));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static CTShape prototype() {
/*  75 */     if (prototype == null) {
/*  76 */       CTShape cTShape = CTShape.Factory.newInstance();
/*     */       
/*  78 */       CTShapeNonVisual cTShapeNonVisual = cTShape.addNewNvSpPr();
/*  79 */       CTNonVisualDrawingProps cTNonVisualDrawingProps = cTShapeNonVisual.addNewCNvPr();
/*  80 */       cTNonVisualDrawingProps.setId(1L);
/*  81 */       cTNonVisualDrawingProps.setName("Shape 1");
/*  82 */       cTShapeNonVisual.addNewCNvSpPr();
/*     */       
/*  84 */       CTShapeProperties cTShapeProperties = cTShape.addNewSpPr();
/*  85 */       CTTransform2D cTTransform2D = cTShapeProperties.addNewXfrm();
/*  86 */       CTPositiveSize2D cTPositiveSize2D = cTTransform2D.addNewExt();
/*  87 */       cTPositiveSize2D.setCx(0L);
/*  88 */       cTPositiveSize2D.setCy(0L);
/*  89 */       CTPoint2D cTPoint2D = cTTransform2D.addNewOff();
/*  90 */       cTPoint2D.setX(0L);
/*  91 */       cTPoint2D.setY(0L);
/*     */       
/*  93 */       CTPresetGeometry2D cTPresetGeometry2D = cTShapeProperties.addNewPrstGeom();
/*  94 */       cTPresetGeometry2D.setPrst(STShapeType.RECT);
/*  95 */       cTPresetGeometry2D.addNewAvLst();
/*     */       
/*  97 */       CTTextBody cTTextBody = cTShape.addNewTxBody();
/*  98 */       CTTextBodyProperties cTTextBodyProperties = cTTextBody.addNewBodyPr();
/*  99 */       cTTextBodyProperties.setAnchor(STTextAnchoringType.T);
/* 100 */       cTTextBodyProperties.setRtlCol(false);
/* 101 */       CTTextParagraph cTTextParagraph = cTTextBody.addNewP();
/* 102 */       cTTextParagraph.addNewPPr().setAlgn(STTextAlignType.L);
/* 103 */       CTTextCharacterProperties cTTextCharacterProperties = cTTextParagraph.addNewEndParaRPr();
/* 104 */       cTTextCharacterProperties.setLang("en-US");
/* 105 */       cTTextCharacterProperties.setSz(1100);
/* 106 */       CTSolidColorFillProperties cTSolidColorFillProperties = cTTextCharacterProperties.addNewSolidFill();
/* 107 */       cTSolidColorFillProperties.addNewSrgbClr().setVal(new byte[] { 0, 0, 0 });
/*     */       
/* 109 */       cTTextBody.addNewLstStyle();
/*     */       
/* 111 */       prototype = cTShape;
/*     */     } 
/* 113 */     return prototype;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTShape getCTShape() {
/* 118 */     return this.ctShape;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<XSSFTextParagraph> iterator() {
/* 123 */     return this._paragraphs.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/* 132 */     byte b = 9;
/* 133 */     StringBuilder stringBuilder = new StringBuilder();
/* 134 */     ArrayList<Integer> arrayList = new ArrayList(9);
/* 135 */     XSSFTextParagraph xSSFTextParagraph = null;
/*     */     
/*     */     int i;
/* 138 */     for (i = 0; i < 9; i++) {
/* 139 */       arrayList.add(Integer.valueOf(0));
/*     */     }
/*     */     
/* 142 */     for (i = 0; i < this._paragraphs.size(); i++) {
/* 143 */       if (stringBuilder.length() > 0) stringBuilder.append('\n'); 
/* 144 */       xSSFTextParagraph = this._paragraphs.get(i);
/*     */       
/* 146 */       if (xSSFTextParagraph.isBullet() && xSSFTextParagraph.getText().length() > 0) {
/*     */         
/* 148 */         int j = Math.min(xSSFTextParagraph.getLevel(), 8);
/*     */         
/* 150 */         if (xSSFTextParagraph.isBulletAutoNumber()) {
/* 151 */           i = processAutoNumGroup(i, j, arrayList, stringBuilder);
/*     */         } else {
/*     */           
/* 154 */           for (byte b1 = 0; b1 < j; b1++) {
/* 155 */             stringBuilder.append('\t');
/*     */           }
/* 157 */           String str = xSSFTextParagraph.getBulletCharacter();
/* 158 */           stringBuilder.append((str.length() > 0) ? (str + " ") : "- ");
/* 159 */           stringBuilder.append(xSSFTextParagraph.getText());
/*     */         } 
/*     */       } else {
/* 162 */         stringBuilder.append(xSSFTextParagraph.getText());
/*     */ 
/*     */         
/* 165 */         for (byte b1 = 0; b1 < 9; b1++) {
/* 166 */           arrayList.set(b1, Integer.valueOf(0));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 171 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int processAutoNumGroup(int paramInt1, int paramInt2, List<Integer> paramList, StringBuilder paramStringBuilder) {
/* 178 */     XSSFTextParagraph xSSFTextParagraph1 = null;
/* 179 */     XSSFTextParagraph xSSFTextParagraph2 = null;
/*     */ 
/*     */ 
/*     */     
/* 183 */     xSSFTextParagraph1 = this._paragraphs.get(paramInt1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 192 */     int i = xSSFTextParagraph1.getBulletAutoNumberStart();
/* 193 */     ListAutoNumber listAutoNumber = xSSFTextParagraph1.getBulletAutoNumberScheme();
/* 194 */     if (((Integer)paramList.get(paramInt2)).intValue() == 0) {
/* 195 */       paramList.set(paramInt2, Integer.valueOf((i == 0) ? 1 : i));
/*     */     }
/*     */     byte b;
/* 198 */     for (b = 0; b < paramInt2; b++) {
/* 199 */       paramStringBuilder.append('\t');
/*     */     }
/* 201 */     if (xSSFTextParagraph1.getText().length() > 0) {
/* 202 */       paramStringBuilder.append(getBulletPrefix(listAutoNumber, ((Integer)paramList.get(paramInt2)).intValue()));
/* 203 */       paramStringBuilder.append(xSSFTextParagraph1.getText());
/*     */     } 
/*     */     while (true) {
/* 206 */       xSSFTextParagraph2 = (paramInt1 + 1 == this._paragraphs.size()) ? null : this._paragraphs.get(paramInt1 + 1);
/* 207 */       if (xSSFTextParagraph2 == null || 
/* 208 */         !xSSFTextParagraph2.isBullet() || !xSSFTextParagraph1.isBulletAutoNumber())
/* 209 */         break;  if (xSSFTextParagraph2.getLevel() > paramInt2) {
/*     */         
/* 211 */         if (paramStringBuilder.length() > 0) paramStringBuilder.append('\n'); 
/* 212 */         paramInt1 = processAutoNumGroup(paramInt1 + 1, xSSFTextParagraph2.getLevel(), paramList, paramStringBuilder); continue;
/*     */       } 
/* 214 */       if (xSSFTextParagraph2.getLevel() < paramInt2) {
/*     */         break;
/*     */       }
/* 217 */       ListAutoNumber listAutoNumber1 = xSSFTextParagraph2.getBulletAutoNumberScheme();
/* 218 */       int j = xSSFTextParagraph2.getBulletAutoNumberStart();
/*     */       
/* 220 */       if (listAutoNumber1 == listAutoNumber && j == i) {
/*     */         
/* 222 */         paramInt1++;
/* 223 */         if (paramStringBuilder.length() > 0) paramStringBuilder.append('\n');
/*     */         
/* 225 */         for (b = 0; b < paramInt2; b++) {
/* 226 */           paramStringBuilder.append('\t');
/*     */         }
/*     */         
/* 229 */         if (xSSFTextParagraph2.getText().length() > 0) {
/*     */           
/* 231 */           paramList.set(paramInt2, Integer.valueOf(((Integer)paramList.get(paramInt2)).intValue() + 1));
/* 232 */           paramStringBuilder.append(getBulletPrefix(listAutoNumber1, ((Integer)paramList.get(paramInt2)).intValue()));
/* 233 */           paramStringBuilder.append(xSSFTextParagraph2.getText());
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/*     */       break;
/*     */     } 
/* 241 */     paramList.set(paramInt2, Integer.valueOf(0));
/*     */     
/* 243 */     return paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getBulletPrefix(ListAutoNumber paramListAutoNumber, int paramInt) {
/* 252 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 254 */     switch (paramListAutoNumber)
/*     */     { case NONE:
/*     */       case NORMAL:
/* 257 */         if (paramListAutoNumber == ListAutoNumber.ALPHA_LC_PARENT_BOTH) stringBuilder.append('('); 
/* 258 */         stringBuilder.append(valueToAlpha(paramInt).toLowerCase(Locale.ROOT));
/* 259 */         stringBuilder.append(')');
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 312 */         stringBuilder.append(" ");
/* 313 */         return stringBuilder.toString();case SHAPE: case null: if (paramListAutoNumber == ListAutoNumber.ALPHA_UC_PARENT_BOTH) stringBuilder.append('(');  stringBuilder.append(valueToAlpha(paramInt)); stringBuilder.append(')'); stringBuilder.append(" "); return stringBuilder.toString();case null: stringBuilder.append(valueToAlpha(paramInt).toLowerCase(Locale.ROOT)); stringBuilder.append('.'); stringBuilder.append(" "); return stringBuilder.toString();case null: stringBuilder.append(valueToAlpha(paramInt)); stringBuilder.append('.'); stringBuilder.append(" "); return stringBuilder.toString();case null: case null: if (paramListAutoNumber == ListAutoNumber.ARABIC_PARENT_BOTH) stringBuilder.append('(');  stringBuilder.append(paramInt); stringBuilder.append(')'); stringBuilder.append(" "); return stringBuilder.toString();case null: stringBuilder.append(paramInt); stringBuilder.append('.'); stringBuilder.append(" "); return stringBuilder.toString();case null: stringBuilder.append(paramInt); stringBuilder.append(" "); return stringBuilder.toString();case null: case null: if (paramListAutoNumber == ListAutoNumber.ROMAN_LC_PARENT_BOTH) stringBuilder.append('(');  stringBuilder.append(valueToRoman(paramInt).toLowerCase(Locale.ROOT)); stringBuilder.append(')'); stringBuilder.append(" "); return stringBuilder.toString();case null: case null: if (paramListAutoNumber == ListAutoNumber.ROMAN_UC_PARENT_BOTH) stringBuilder.append('(');  stringBuilder.append(valueToRoman(paramInt)); stringBuilder.append(')'); stringBuilder.append(" "); return stringBuilder.toString();case null: stringBuilder.append(valueToRoman(paramInt).toLowerCase(Locale.ROOT)); stringBuilder.append('.'); stringBuilder.append(" "); return stringBuilder.toString();case null: stringBuilder.append(valueToRoman(paramInt)); stringBuilder.append('.'); stringBuilder.append(" "); return stringBuilder.toString(); }  stringBuilder.append('•'); stringBuilder.append(" "); return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String valueToAlpha(int paramInt) {
/* 320 */     String str = "";
/*     */     
/* 322 */     while (paramInt > 0) {
/* 323 */       int i = (paramInt - 1) % 26;
/* 324 */       str = (char)(65 + i) + str;
/* 325 */       paramInt = (paramInt - i) / 26;
/*     */     } 
/* 327 */     return str;
/*     */   }
/*     */   
/* 330 */   private static String[] _romanChars = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
/* 331 */   private static int[] _romanAlphaValues = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String valueToRoman(int paramInt) {
/* 337 */     StringBuilder stringBuilder = new StringBuilder();
/* 338 */     for (byte b = 0; paramInt > 0 && b < _romanChars.length; b++) {
/* 339 */       while (_romanAlphaValues[b] <= paramInt) {
/* 340 */         stringBuilder.append(_romanChars[b]);
/* 341 */         paramInt -= _romanAlphaValues[b];
/*     */       } 
/*     */     } 
/* 344 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearText() {
/* 351 */     this._paragraphs.clear();
/* 352 */     CTTextBody cTTextBody = this.ctShape.getTxBody();
/* 353 */     cTTextBody.setPArray(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(String paramString) {
/* 361 */     clearText();
/*     */     
/* 363 */     addNewTextParagraph().addNewTextRun().setText(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(XSSFRichTextString paramXSSFRichTextString) {
/* 372 */     XSSFWorkbook xSSFWorkbook = (XSSFWorkbook)getDrawing().getParent().getParent();
/* 373 */     paramXSSFRichTextString.setStylesTableReference(xSSFWorkbook.getStylesSource());
/*     */     
/* 375 */     CTTextParagraph cTTextParagraph = CTTextParagraph.Factory.newInstance();
/* 376 */     if (paramXSSFRichTextString.numFormattingRuns() == 0) {
/* 377 */       CTRegularTextRun cTRegularTextRun = cTTextParagraph.addNewR();
/* 378 */       CTTextCharacterProperties cTTextCharacterProperties = cTRegularTextRun.addNewRPr();
/* 379 */       cTTextCharacterProperties.setLang("en-US");
/* 380 */       cTTextCharacterProperties.setSz(1100);
/* 381 */       cTRegularTextRun.setT(paramXSSFRichTextString.getString());
/*     */     } else {
/*     */       
/* 384 */       for (byte b = 0; b < paramXSSFRichTextString.getCTRst().sizeOfRArray(); b++) {
/* 385 */         CTRElt cTRElt = paramXSSFRichTextString.getCTRst().getRArray(b);
/* 386 */         CTRPrElt cTRPrElt = cTRElt.getRPr();
/* 387 */         if (cTRPrElt == null) cTRPrElt = cTRElt.addNewRPr();
/*     */         
/* 389 */         CTRegularTextRun cTRegularTextRun = cTTextParagraph.addNewR();
/* 390 */         CTTextCharacterProperties cTTextCharacterProperties = cTRegularTextRun.addNewRPr();
/* 391 */         cTTextCharacterProperties.setLang("en-US");
/*     */         
/* 393 */         applyAttributes(cTRPrElt, cTTextCharacterProperties);
/*     */         
/* 395 */         cTRegularTextRun.setT(cTRElt.getT());
/*     */       } 
/*     */     } 
/*     */     
/* 399 */     clearText();
/* 400 */     this.ctShape.getTxBody().setPArray(new CTTextParagraph[] { cTTextParagraph });
/* 401 */     this._paragraphs.add(new XSSFTextParagraph(this.ctShape.getTxBody().getPArray(0), this.ctShape));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XSSFTextParagraph> getTextParagraphs() {
/* 410 */     return this._paragraphs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFTextParagraph addNewTextParagraph() {
/* 419 */     CTTextBody cTTextBody = this.ctShape.getTxBody();
/* 420 */     CTTextParagraph cTTextParagraph = cTTextBody.addNewP();
/* 421 */     XSSFTextParagraph xSSFTextParagraph = new XSSFTextParagraph(cTTextParagraph, this.ctShape);
/* 422 */     this._paragraphs.add(xSSFTextParagraph);
/* 423 */     return xSSFTextParagraph;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFTextParagraph addNewTextParagraph(String paramString) {
/* 432 */     XSSFTextParagraph xSSFTextParagraph = addNewTextParagraph();
/* 433 */     xSSFTextParagraph.addNewTextRun().setText(paramString);
/* 434 */     return xSSFTextParagraph;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFTextParagraph addNewTextParagraph(XSSFRichTextString paramXSSFRichTextString) {
/* 443 */     CTTextBody cTTextBody = this.ctShape.getTxBody();
/* 444 */     CTTextParagraph cTTextParagraph = cTTextBody.addNewP();
/*     */     
/* 446 */     if (paramXSSFRichTextString.numFormattingRuns() == 0) {
/* 447 */       CTRegularTextRun cTRegularTextRun = cTTextParagraph.addNewR();
/* 448 */       CTTextCharacterProperties cTTextCharacterProperties = cTRegularTextRun.addNewRPr();
/* 449 */       cTTextCharacterProperties.setLang("en-US");
/* 450 */       cTTextCharacterProperties.setSz(1100);
/* 451 */       cTRegularTextRun.setT(paramXSSFRichTextString.getString());
/*     */     } else {
/*     */       
/* 454 */       for (byte b = 0; b < paramXSSFRichTextString.getCTRst().sizeOfRArray(); b++) {
/* 455 */         CTRElt cTRElt = paramXSSFRichTextString.getCTRst().getRArray(b);
/* 456 */         CTRPrElt cTRPrElt = cTRElt.getRPr();
/* 457 */         if (cTRPrElt == null) cTRPrElt = cTRElt.addNewRPr();
/*     */         
/* 459 */         CTRegularTextRun cTRegularTextRun = cTTextParagraph.addNewR();
/* 460 */         CTTextCharacterProperties cTTextCharacterProperties = cTRegularTextRun.addNewRPr();
/* 461 */         cTTextCharacterProperties.setLang("en-US");
/*     */         
/* 463 */         applyAttributes(cTRPrElt, cTTextCharacterProperties);
/*     */         
/* 465 */         cTRegularTextRun.setT(cTRElt.getT());
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 470 */     XSSFTextParagraph xSSFTextParagraph = new XSSFTextParagraph(cTTextParagraph, this.ctShape);
/* 471 */     this._paragraphs.add(xSSFTextParagraph);
/*     */     
/* 473 */     return xSSFTextParagraph;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextHorizontalOverflow(TextHorizontalOverflow paramTextHorizontalOverflow) {
/* 483 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 484 */     if (cTTextBodyProperties != null) {
/* 485 */       if (paramTextHorizontalOverflow == null) {
/* 486 */         if (cTTextBodyProperties.isSetHorzOverflow()) cTTextBodyProperties.unsetHorzOverflow(); 
/*     */       } else {
/* 488 */         cTTextBodyProperties.setHorzOverflow(STTextHorzOverflowType.Enum.forInt(paramTextHorizontalOverflow.ordinal() + 1));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextHorizontalOverflow getTextHorizontalOverflow() {
/* 499 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 500 */     if (cTTextBodyProperties != null && 
/* 501 */       cTTextBodyProperties.isSetHorzOverflow()) {
/* 502 */       return TextHorizontalOverflow.values()[cTTextBodyProperties.getHorzOverflow().intValue() - 1];
/*     */     }
/*     */     
/* 505 */     return TextHorizontalOverflow.OVERFLOW;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextVerticalOverflow(TextVerticalOverflow paramTextVerticalOverflow) {
/* 515 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 516 */     if (cTTextBodyProperties != null) {
/* 517 */       if (paramTextVerticalOverflow == null) {
/* 518 */         if (cTTextBodyProperties.isSetVertOverflow()) cTTextBodyProperties.unsetVertOverflow(); 
/*     */       } else {
/* 520 */         cTTextBodyProperties.setVertOverflow(STTextVertOverflowType.Enum.forInt(paramTextVerticalOverflow.ordinal() + 1));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextVerticalOverflow getTextVerticalOverflow() {
/* 531 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 532 */     if (cTTextBodyProperties != null && 
/* 533 */       cTTextBodyProperties.isSetVertOverflow()) {
/* 534 */       return TextVerticalOverflow.values()[cTTextBodyProperties.getVertOverflow().intValue() - 1];
/*     */     }
/*     */     
/* 537 */     return TextVerticalOverflow.OVERFLOW;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVerticalAlignment(VerticalAlignment paramVerticalAlignment) {
/* 547 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 548 */     if (cTTextBodyProperties != null) {
/* 549 */       if (paramVerticalAlignment == null) {
/* 550 */         if (cTTextBodyProperties.isSetAnchor()) cTTextBodyProperties.unsetAnchor(); 
/*     */       } else {
/* 552 */         cTTextBodyProperties.setAnchor(STTextAnchoringType.Enum.forInt(paramVerticalAlignment.ordinal() + 1));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VerticalAlignment getVerticalAlignment() {
/* 563 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 564 */     if (cTTextBodyProperties != null && 
/* 565 */       cTTextBodyProperties.isSetAnchor()) {
/* 566 */       return VerticalAlignment.values()[cTTextBodyProperties.getAnchor().intValue() - 1];
/*     */     }
/*     */     
/* 569 */     return VerticalAlignment.TOP;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextDirection(TextDirection paramTextDirection) {
/* 579 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 580 */     if (cTTextBodyProperties != null) {
/* 581 */       if (paramTextDirection == null) {
/* 582 */         if (cTTextBodyProperties.isSetVert()) cTTextBodyProperties.unsetVert(); 
/*     */       } else {
/* 584 */         cTTextBodyProperties.setVert(STTextVerticalType.Enum.forInt(paramTextDirection.ordinal() + 1));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextDirection getTextDirection() {
/* 595 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 596 */     if (cTTextBodyProperties != null) {
/* 597 */       STTextVerticalType.Enum enum_ = cTTextBodyProperties.getVert();
/* 598 */       if (enum_ != null) {
/* 599 */         return TextDirection.values()[enum_.intValue() - 1];
/*     */       }
/*     */     } 
/* 602 */     return TextDirection.HORIZONTAL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getBottomInset() {
/* 613 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 614 */     if (cTTextBodyProperties != null && 
/* 615 */       cTTextBodyProperties.isSetBIns()) {
/* 616 */       return Units.toPoints(cTTextBodyProperties.getBIns());
/*     */     }
/*     */ 
/*     */     
/* 620 */     return 3.6D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getLeftInset() {
/* 631 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 632 */     if (cTTextBodyProperties != null && 
/* 633 */       cTTextBodyProperties.isSetLIns()) {
/* 634 */       return Units.toPoints(cTTextBodyProperties.getLIns());
/*     */     }
/*     */ 
/*     */     
/* 638 */     return 3.6D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getRightInset() {
/* 649 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 650 */     if (cTTextBodyProperties != null && 
/* 651 */       cTTextBodyProperties.isSetRIns()) {
/* 652 */       return Units.toPoints(cTTextBodyProperties.getRIns());
/*     */     }
/*     */ 
/*     */     
/* 656 */     return 3.6D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getTopInset() {
/* 666 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 667 */     if (cTTextBodyProperties != null && 
/* 668 */       cTTextBodyProperties.isSetTIns()) {
/* 669 */       return Units.toPoints(cTTextBodyProperties.getTIns());
/*     */     }
/*     */ 
/*     */     
/* 673 */     return 3.6D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBottomInset(double paramDouble) {
/* 683 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 684 */     if (cTTextBodyProperties != null) {
/* 685 */       if (paramDouble == -1.0D)
/* 686 */       { if (cTTextBodyProperties.isSetBIns()) cTTextBodyProperties.unsetBIns();  }
/* 687 */       else { cTTextBodyProperties.setBIns(Units.toEMU(paramDouble)); }
/*     */     
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeftInset(double paramDouble) {
/* 698 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 699 */     if (cTTextBodyProperties != null) {
/* 700 */       if (paramDouble == -1.0D)
/* 701 */       { if (cTTextBodyProperties.isSetLIns()) cTTextBodyProperties.unsetLIns();  }
/* 702 */       else { cTTextBodyProperties.setLIns(Units.toEMU(paramDouble)); }
/*     */     
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRightInset(double paramDouble) {
/* 713 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 714 */     if (cTTextBodyProperties != null) {
/* 715 */       if (paramDouble == -1.0D)
/* 716 */       { if (cTTextBodyProperties.isSetRIns()) cTTextBodyProperties.unsetRIns();  }
/* 717 */       else { cTTextBodyProperties.setRIns(Units.toEMU(paramDouble)); }
/*     */     
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTopInset(double paramDouble) {
/* 728 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 729 */     if (cTTextBodyProperties != null) {
/* 730 */       if (paramDouble == -1.0D)
/* 731 */       { if (cTTextBodyProperties.isSetTIns()) cTTextBodyProperties.unsetTIns();  }
/* 732 */       else { cTTextBodyProperties.setTIns(Units.toEMU(paramDouble)); }
/*     */     
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getWordWrap() {
/* 741 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 742 */     if (cTTextBodyProperties != null && 
/* 743 */       cTTextBodyProperties.isSetWrap()) {
/* 744 */       return (cTTextBodyProperties.getWrap() == STTextWrappingType.SQUARE);
/*     */     }
/*     */     
/* 747 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWordWrap(boolean paramBoolean) {
/* 755 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 756 */     if (cTTextBodyProperties != null) {
/* 757 */       cTTextBodyProperties.setWrap(paramBoolean ? STTextWrappingType.SQUARE : STTextWrappingType.NONE);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextAutofit(TextAutofit paramTextAutofit) {
/* 769 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 770 */     if (cTTextBodyProperties != null) {
/* 771 */       if (cTTextBodyProperties.isSetSpAutoFit()) cTTextBodyProperties.unsetSpAutoFit(); 
/* 772 */       if (cTTextBodyProperties.isSetNoAutofit()) cTTextBodyProperties.unsetNoAutofit(); 
/* 773 */       if (cTTextBodyProperties.isSetNormAutofit()) cTTextBodyProperties.unsetNormAutofit();
/*     */       
/* 775 */       switch (paramTextAutofit) { case NONE:
/* 776 */           cTTextBodyProperties.addNewNoAutofit(); break;
/* 777 */         case NORMAL: cTTextBodyProperties.addNewNormAutofit(); break;
/* 778 */         case SHAPE: cTTextBodyProperties.addNewSpAutoFit();
/*     */           break; }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextAutofit getTextAutofit() {
/* 788 */     CTTextBodyProperties cTTextBodyProperties = this.ctShape.getTxBody().getBodyPr();
/* 789 */     if (cTTextBodyProperties != null) {
/* 790 */       if (cTTextBodyProperties.isSetNoAutofit()) return TextAutofit.NONE; 
/* 791 */       if (cTTextBodyProperties.isSetNormAutofit()) return TextAutofit.NORMAL; 
/* 792 */       if (cTTextBodyProperties.isSetSpAutoFit()) return TextAutofit.SHAPE; 
/*     */     } 
/* 794 */     return TextAutofit.NORMAL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getShapeType() {
/* 804 */     return this.ctShape.getSpPr().getPrstGeom().getPrst().intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShapeType(int paramInt) {
/* 814 */     this.ctShape.getSpPr().getPrstGeom().setPrst(STShapeType.Enum.forInt(paramInt));
/*     */   }
/*     */   
/*     */   protected CTShapeProperties getShapeProperties() {
/* 818 */     return this.ctShape.getSpPr();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void applyAttributes(CTRPrElt paramCTRPrElt, CTTextCharacterProperties paramCTTextCharacterProperties) {
/* 827 */     if (paramCTRPrElt.sizeOfBArray() > 0) paramCTTextCharacterProperties.setB(paramCTRPrElt.getBArray(0).getVal()); 
/* 828 */     if (paramCTRPrElt.sizeOfUArray() > 0) {
/* 829 */       STUnderlineValues.Enum enum_ = paramCTRPrElt.getUArray(0).getVal();
/* 830 */       if (enum_ == STUnderlineValues.SINGLE) { paramCTTextCharacterProperties.setU(STTextUnderlineType.SNG); }
/* 831 */       else if (enum_ == STUnderlineValues.DOUBLE) { paramCTTextCharacterProperties.setU(STTextUnderlineType.DBL); }
/* 832 */       else if (enum_ == STUnderlineValues.NONE) { paramCTTextCharacterProperties.setU(STTextUnderlineType.NONE); }
/*     */     
/* 834 */     }  if (paramCTRPrElt.sizeOfIArray() > 0) paramCTTextCharacterProperties.setI(paramCTRPrElt.getIArray(0).getVal());
/*     */     
/* 836 */     if (paramCTRPrElt.sizeOfRFontArray() > 0) {
/* 837 */       CTTextFont cTTextFont = paramCTTextCharacterProperties.isSetLatin() ? paramCTTextCharacterProperties.getLatin() : paramCTTextCharacterProperties.addNewLatin();
/* 838 */       cTTextFont.setTypeface(paramCTRPrElt.getRFontArray(0).getVal());
/*     */     } 
/*     */     
/* 841 */     if (paramCTRPrElt.sizeOfSzArray() > 0) {
/* 842 */       int i = (int)(paramCTRPrElt.getSzArray(0).getVal() * 100.0D);
/* 843 */       paramCTTextCharacterProperties.setSz(i);
/*     */     } 
/*     */     
/* 846 */     if (paramCTRPrElt.sizeOfColorArray() > 0) {
/* 847 */       CTSolidColorFillProperties cTSolidColorFillProperties = paramCTTextCharacterProperties.isSetSolidFill() ? paramCTTextCharacterProperties.getSolidFill() : paramCTTextCharacterProperties.addNewSolidFill();
/* 848 */       CTColor cTColor = paramCTRPrElt.getColorArray(0);
/* 849 */       if (cTColor.isSetRgb()) {
/* 850 */         CTSRgbColor cTSRgbColor = cTSolidColorFillProperties.isSetSrgbClr() ? cTSolidColorFillProperties.getSrgbClr() : cTSolidColorFillProperties.addNewSrgbClr();
/* 851 */         cTSRgbColor.setVal(cTColor.getRgb());
/*     */       }
/* 853 */       else if (cTColor.isSetIndexed()) {
/* 854 */         HSSFColor hSSFColor = (HSSFColor)HSSFColor.getIndexHash().get(Integer.valueOf((int)cTColor.getIndexed()));
/* 855 */         if (hSSFColor != null) {
/* 856 */           byte[] arrayOfByte = new byte[3];
/* 857 */           arrayOfByte[0] = (byte)hSSFColor.getTriplet()[0];
/* 858 */           arrayOfByte[1] = (byte)hSSFColor.getTriplet()[1];
/* 859 */           arrayOfByte[2] = (byte)hSSFColor.getTriplet()[2];
/* 860 */           CTSRgbColor cTSRgbColor = cTSolidColorFillProperties.isSetSrgbClr() ? cTSolidColorFillProperties.getSrgbClr() : cTSolidColorFillProperties.addNewSrgbClr();
/* 861 */           cTSRgbColor.setVal(arrayOfByte);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFSimpleShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */