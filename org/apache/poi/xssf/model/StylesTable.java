/*     */ package org.apache.poi.xssf.model;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLFactory;
/*     */ import org.apache.poi.POIXMLRelation;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.usermodel.FontFamily;
/*     */ import org.apache.poi.ss.usermodel.FontScheme;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCellStyle;
/*     */ import org.apache.poi.xssf.usermodel.XSSFFactory;
/*     */ import org.apache.poi.xssf.usermodel.XSSFFont;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRelation;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
/*     */ import org.apache.poi.xssf.usermodel.extensions.XSSFCellFill;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFills;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.StyleSheetDocument;
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
/*     */ public class StylesTable
/*     */   extends POIXMLDocumentPart
/*     */ {
/*  71 */   private final SortedMap<Short, String> numberFormats = new TreeMap<Short, String>();
/*  72 */   private final List<XSSFFont> fonts = new ArrayList<XSSFFont>();
/*  73 */   private final List<XSSFCellFill> fills = new ArrayList<XSSFCellFill>();
/*  74 */   private final List<XSSFCellBorder> borders = new ArrayList<XSSFCellBorder>();
/*  75 */   private final List<CTXf> styleXfs = new ArrayList<CTXf>();
/*  76 */   private final List<CTXf> xfs = new ArrayList<CTXf>();
/*     */   
/*  78 */   private final List<CTDxf> dxfs = new ArrayList<CTDxf>();
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int FIRST_CUSTOM_STYLE_ID = 165;
/*     */ 
/*     */   
/*  85 */   private static final int MAXIMUM_STYLE_ID = SpreadsheetVersion.EXCEL2007.getMaxCellStyles();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final short FIRST_USER_DEFINED_NUMBER_FORMAT_ID = 164;
/*     */ 
/*     */ 
/*     */   
/*  94 */   private int MAXIMUM_NUMBER_OF_DATA_FORMATS = 250;
/*     */ 
/*     */   
/*     */   private StyleSheetDocument doc;
/*     */   
/*     */   private XSSFWorkbook workbook;
/*     */   
/*     */   private ThemesTable theme;
/*     */ 
/*     */   
/*     */   public void setMaxNumberOfDataFormats(int paramInt) {
/* 105 */     if (paramInt < getNumDataFormats()) {
/* 106 */       if (paramInt < 0) {
/* 107 */         throw new IllegalArgumentException("Maximum Number of Data Formats must be greater than or equal to 0");
/*     */       }
/* 109 */       throw new IllegalStateException("Cannot set the maximum number of data formats less than the current quantity.Data formats must be explicitly removed (via StylesTable.removeNumberFormat) before the limit can be decreased.");
/*     */     } 
/*     */ 
/*     */     
/* 113 */     this.MAXIMUM_NUMBER_OF_DATA_FORMATS = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxNumberOfDataFormats() {
/* 123 */     return this.MAXIMUM_NUMBER_OF_DATA_FORMATS;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StylesTable() {
/* 135 */     this.doc = StyleSheetDocument.Factory.newInstance();
/* 136 */     this.doc.addNewStyleSheet();
/*     */     
/* 138 */     initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StylesTable(PackagePart paramPackagePart) throws IOException {
/* 145 */     super(paramPackagePart);
/* 146 */     readFrom(paramPackagePart.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public StylesTable(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/* 154 */     this(paramPackagePart);
/*     */   }
/*     */   
/*     */   public void setWorkbook(XSSFWorkbook paramXSSFWorkbook) {
/* 158 */     this.workbook = paramXSSFWorkbook;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ThemesTable getTheme() {
/* 168 */     return this.theme;
/*     */   }
/*     */   
/*     */   public void setTheme(ThemesTable paramThemesTable) {
/* 172 */     this.theme = paramThemesTable;
/*     */ 
/*     */ 
/*     */     
/* 176 */     for (XSSFFont xSSFFont : this.fonts) {
/* 177 */       xSSFFont.setThemesTable(paramThemesTable);
/*     */     }
/* 179 */     for (XSSFCellBorder xSSFCellBorder : this.borders) {
/* 180 */       xSSFCellBorder.setThemesTable(paramThemesTable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureThemesTable() {
/* 190 */     if (this.theme != null)
/*     */       return; 
/* 192 */     this.theme = (ThemesTable)this.workbook.createRelationship((POIXMLRelation)XSSFRelation.THEME, (POIXMLFactory)XSSFFactory.getInstance());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void readFrom(InputStream paramInputStream) throws IOException {
/*     */     try {
/* 203 */       this.doc = StyleSheetDocument.Factory.parse(paramInputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */       
/* 205 */       CTStylesheet cTStylesheet = this.doc.getStyleSheet();
/*     */ 
/*     */       
/* 208 */       CTNumFmts cTNumFmts = cTStylesheet.getNumFmts();
/* 209 */       if (cTNumFmts != null) {
/* 210 */         for (CTNumFmt cTNumFmt : cTNumFmts.getNumFmtArray()) {
/* 211 */           short s = (short)(int)cTNumFmt.getNumFmtId();
/* 212 */           this.numberFormats.put(Short.valueOf(s), cTNumFmt.getFormatCode());
/*     */         } 
/*     */       }
/*     */       
/* 216 */       CTFonts cTFonts = cTStylesheet.getFonts();
/* 217 */       if (cTFonts != null) {
/* 218 */         byte b = 0;
/* 219 */         for (CTFont cTFont : cTFonts.getFontArray()) {
/*     */           
/* 221 */           XSSFFont xSSFFont = new XSSFFont(cTFont, b);
/* 222 */           this.fonts.add(xSSFFont);
/* 223 */           b++;
/*     */         } 
/*     */       } 
/* 226 */       CTFills cTFills = cTStylesheet.getFills();
/* 227 */       if (cTFills != null) {
/* 228 */         for (CTFill cTFill : cTFills.getFillArray()) {
/* 229 */           this.fills.add(new XSSFCellFill(cTFill));
/*     */         }
/*     */       }
/*     */       
/* 233 */       CTBorders cTBorders = cTStylesheet.getBorders();
/* 234 */       if (cTBorders != null) {
/* 235 */         for (CTBorder cTBorder : cTBorders.getBorderArray()) {
/* 236 */           this.borders.add(new XSSFCellBorder(cTBorder));
/*     */         }
/*     */       }
/*     */       
/* 240 */       CTCellXfs cTCellXfs = cTStylesheet.getCellXfs();
/* 241 */       if (cTCellXfs != null) this.xfs.addAll(Arrays.asList(cTCellXfs.getXfArray()));
/*     */       
/* 243 */       CTCellStyleXfs cTCellStyleXfs = cTStylesheet.getCellStyleXfs();
/* 244 */       if (cTCellStyleXfs != null) this.styleXfs.addAll(Arrays.asList(cTCellStyleXfs.getXfArray()));
/*     */       
/* 246 */       CTDxfs cTDxfs = cTStylesheet.getDxfs();
/* 247 */       if (cTDxfs != null) this.dxfs.addAll(Arrays.asList(cTDxfs.getDxfArray()));
/*     */     
/* 249 */     } catch (XmlException xmlException) {
/* 250 */       throw new IOException(xmlException.getLocalizedMessage());
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNumberFormatAt(int paramInt) {
/* 266 */     return getNumberFormatAt((short)paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNumberFormatAt(short paramShort) {
/* 276 */     return this.numberFormats.get(Short.valueOf(paramShort));
/*     */   }
/*     */ 
/*     */   
/*     */   private short getNumberFormatId(String paramString) {
/* 281 */     for (Map.Entry<Short, String> entry : this.numberFormats.entrySet()) {
/* 282 */       if (((String)entry.getValue()).equals(paramString)) {
/* 283 */         return ((Short)entry.getKey()).shortValue();
/*     */       }
/*     */     } 
/* 286 */     throw new IllegalStateException("Number format not in style table: " + paramString);
/*     */   }
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
/*     */   public int putNumberFormat(String paramString) {
/*     */     short s;
/* 301 */     if (this.numberFormats.containsValue(paramString)) {
/*     */       try {
/* 303 */         return getNumberFormatId(paramString);
/* 304 */       } catch (IllegalStateException illegalStateException) {
/* 305 */         throw new IllegalStateException("Found the format, but couldn't figure out where - should never happen!");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 310 */     if (this.numberFormats.size() >= this.MAXIMUM_NUMBER_OF_DATA_FORMATS) {
/* 311 */       throw new IllegalStateException("The maximum number of Data Formats was exceeded. You can define up to " + this.MAXIMUM_NUMBER_OF_DATA_FORMATS + " formats in a .xlsx Workbook.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 317 */     if (this.numberFormats.isEmpty()) {
/* 318 */       s = 164;
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 325 */       short s1 = (short)(((Short)this.numberFormats.lastKey()).shortValue() + 1);
/* 326 */       if (s1 < 0) {
/* 327 */         throw new IllegalStateException("Cowardly avoiding creating a number format with a negative id.This is probably due to arithmetic overflow.");
/*     */       }
/*     */ 
/*     */       
/* 331 */       s = (short)Math.max(s1, 164);
/*     */     } 
/*     */     
/* 334 */     this.numberFormats.put(Short.valueOf(s), paramString);
/* 335 */     return s;
/*     */   }
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
/*     */   public void putNumberFormat(short paramShort, String paramString) {
/* 349 */     this.numberFormats.put(Short.valueOf(paramShort), paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeNumberFormat(short paramShort) {
/* 360 */     String str = this.numberFormats.remove(Short.valueOf(paramShort));
/* 361 */     boolean bool = (str != null) ? true : false;
/* 362 */     if (bool) {
/* 363 */       for (CTXf cTXf : this.xfs) {
/* 364 */         if (cTXf.isSetNumFmtId() && cTXf.getNumFmtId() == paramShort) {
/* 365 */           cTXf.unsetApplyNumberFormat();
/* 366 */           cTXf.unsetNumFmtId();
/*     */         } 
/*     */       } 
/*     */     }
/* 370 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeNumberFormat(String paramString) {
/* 381 */     short s = getNumberFormatId(paramString);
/* 382 */     return removeNumberFormat(s);
/*     */   }
/*     */   
/*     */   public XSSFFont getFontAt(int paramInt) {
/* 386 */     return this.fonts.get(paramInt);
/*     */   }
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
/*     */   public int putFont(XSSFFont paramXSSFFont, boolean paramBoolean) {
/* 400 */     int i = -1;
/* 401 */     if (!paramBoolean) {
/* 402 */       i = this.fonts.indexOf(paramXSSFFont);
/*     */     }
/*     */     
/* 405 */     if (i != -1) {
/* 406 */       return i;
/*     */     }
/*     */     
/* 409 */     i = this.fonts.size();
/* 410 */     this.fonts.add(paramXSSFFont);
/* 411 */     return i;
/*     */   }
/*     */   public int putFont(XSSFFont paramXSSFFont) {
/* 414 */     return putFont(paramXSSFFont, false);
/*     */   }
/*     */   
/*     */   public XSSFCellStyle getStyleAt(int paramInt) {
/* 418 */     int i = 0;
/*     */ 
/*     */     
/* 421 */     if (((CTXf)this.xfs.get(paramInt)).getXfId() > 0L) {
/* 422 */       i = (int)((CTXf)this.xfs.get(paramInt)).getXfId();
/*     */     }
/*     */     
/* 425 */     return new XSSFCellStyle(paramInt, i, this, this.theme);
/*     */   }
/*     */   public int putStyle(XSSFCellStyle paramXSSFCellStyle) {
/* 428 */     CTXf cTXf = paramXSSFCellStyle.getCoreXf();
/*     */     
/* 430 */     if (!this.xfs.contains(cTXf)) {
/* 431 */       this.xfs.add(cTXf);
/*     */     }
/* 433 */     return this.xfs.indexOf(cTXf);
/*     */   }
/*     */   
/*     */   public XSSFCellBorder getBorderAt(int paramInt) {
/* 437 */     return this.borders.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int putBorder(XSSFCellBorder paramXSSFCellBorder) {
/* 448 */     int i = this.borders.indexOf(paramXSSFCellBorder);
/* 449 */     if (i != -1) {
/* 450 */       return i;
/*     */     }
/* 452 */     this.borders.add(paramXSSFCellBorder);
/* 453 */     paramXSSFCellBorder.setThemesTable(this.theme);
/* 454 */     return this.borders.size() - 1;
/*     */   }
/*     */   
/*     */   public XSSFCellFill getFillAt(int paramInt) {
/* 458 */     return this.fills.get(paramInt);
/*     */   }
/*     */   
/*     */   public List<XSSFCellBorder> getBorders() {
/* 462 */     return Collections.unmodifiableList(this.borders);
/*     */   }
/*     */   
/*     */   public List<XSSFCellFill> getFills() {
/* 466 */     return Collections.unmodifiableList(this.fills);
/*     */   }
/*     */   
/*     */   public List<XSSFFont> getFonts() {
/* 470 */     return Collections.unmodifiableList(this.fonts);
/*     */   }
/*     */   
/*     */   public Map<Short, String> getNumberFormats() {
/* 474 */     return Collections.unmodifiableMap(this.numberFormats);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int putFill(XSSFCellFill paramXSSFCellFill) {
/* 485 */     int i = this.fills.indexOf(paramXSSFCellFill);
/* 486 */     if (i != -1) {
/* 487 */       return i;
/*     */     }
/* 489 */     this.fills.add(paramXSSFCellFill);
/* 490 */     return this.fills.size() - 1;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTXf getCellXfAt(int paramInt) {
/* 495 */     return this.xfs.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public int putCellXf(CTXf paramCTXf) {
/* 507 */     this.xfs.add(paramCTXf);
/* 508 */     return this.xfs.size();
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public void replaceCellXfAt(int paramInt, CTXf paramCTXf) {
/* 513 */     this.xfs.set(paramInt, paramCTXf);
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTXf getCellStyleXfAt(int paramInt) {
/*     */     try {
/* 519 */       return this.styleXfs.get(paramInt);
/*     */     }
/* 521 */     catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/* 522 */       return null;
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
/*     */   @Internal
/*     */   public int putCellStyleXf(CTXf paramCTXf) {
/* 535 */     this.styleXfs.add(paramCTXf);
/*     */     
/* 537 */     return this.styleXfs.size();
/*     */   }
/*     */   
/*     */   @Internal
/*     */   protected void replaceCellStyleXfAt(int paramInt, CTXf paramCTXf) {
/* 542 */     this.styleXfs.set(paramInt, paramCTXf);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumCellStyles() {
/* 551 */     return this.xfs.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumDataFormats() {
/* 558 */     return this.numberFormats.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public int _getNumberFormatSize() {
/* 567 */     return getNumDataFormats();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   int _getXfsSize() {
/* 575 */     return this.xfs.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public int _getStyleXfsSize() {
/* 582 */     return this.styleXfs.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTStylesheet getCTStylesheet() {
/* 590 */     return this.doc.getStyleSheet();
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public int _getDXfsSize() {
/* 595 */     return this.dxfs.size();
/*     */   }
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
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 609 */     CTStylesheet cTStylesheet = this.doc.getStyleSheet();
/*     */ 
/*     */     
/* 612 */     CTNumFmts cTNumFmts = CTNumFmts.Factory.newInstance();
/* 613 */     cTNumFmts.setCount(this.numberFormats.size());
/* 614 */     for (Map.Entry<Short, String> entry : this.numberFormats.entrySet()) {
/* 615 */       CTNumFmt cTNumFmt = cTNumFmts.addNewNumFmt();
/* 616 */       cTNumFmt.setNumFmtId(((Short)entry.getKey()).shortValue());
/* 617 */       cTNumFmt.setFormatCode((String)entry.getValue());
/*     */     } 
/* 619 */     cTStylesheet.setNumFmts(cTNumFmts);
/*     */ 
/*     */ 
/*     */     
/* 623 */     CTFonts cTFonts = cTStylesheet.getFonts();
/* 624 */     if (cTFonts == null) {
/* 625 */       cTFonts = CTFonts.Factory.newInstance();
/*     */     }
/* 627 */     cTFonts.setCount(this.fonts.size());
/* 628 */     CTFont[] arrayOfCTFont = new CTFont[this.fonts.size()];
/* 629 */     byte b = 0;
/* 630 */     for (XSSFFont xSSFFont : this.fonts) arrayOfCTFont[b++] = xSSFFont.getCTFont(); 
/* 631 */     cTFonts.setFontArray(arrayOfCTFont);
/* 632 */     cTStylesheet.setFonts(cTFonts);
/*     */ 
/*     */     
/* 635 */     CTFills cTFills = cTStylesheet.getFills();
/* 636 */     if (cTFills == null) {
/* 637 */       cTFills = CTFills.Factory.newInstance();
/*     */     }
/* 639 */     cTFills.setCount(this.fills.size());
/* 640 */     CTFill[] arrayOfCTFill = new CTFill[this.fills.size()];
/* 641 */     b = 0;
/* 642 */     for (XSSFCellFill xSSFCellFill : this.fills) arrayOfCTFill[b++] = xSSFCellFill.getCTFill(); 
/* 643 */     cTFills.setFillArray(arrayOfCTFill);
/* 644 */     cTStylesheet.setFills(cTFills);
/*     */ 
/*     */     
/* 647 */     CTBorders cTBorders = cTStylesheet.getBorders();
/* 648 */     if (cTBorders == null) {
/* 649 */       cTBorders = CTBorders.Factory.newInstance();
/*     */     }
/* 651 */     cTBorders.setCount(this.borders.size());
/* 652 */     CTBorder[] arrayOfCTBorder = new CTBorder[this.borders.size()];
/* 653 */     b = 0;
/* 654 */     for (XSSFCellBorder xSSFCellBorder : this.borders) arrayOfCTBorder[b++] = xSSFCellBorder.getCTBorder(); 
/* 655 */     cTBorders.setBorderArray(arrayOfCTBorder);
/* 656 */     cTStylesheet.setBorders(cTBorders);
/*     */ 
/*     */     
/* 659 */     if (this.xfs.size() > 0) {
/* 660 */       CTCellXfs cTCellXfs = cTStylesheet.getCellXfs();
/* 661 */       if (cTCellXfs == null) {
/* 662 */         cTCellXfs = CTCellXfs.Factory.newInstance();
/*     */       }
/* 664 */       cTCellXfs.setCount(this.xfs.size());
/* 665 */       cTCellXfs.setXfArray(this.xfs.<CTXf>toArray(new CTXf[this.xfs.size()]));
/*     */ 
/*     */       
/* 668 */       cTStylesheet.setCellXfs(cTCellXfs);
/*     */     } 
/*     */ 
/*     */     
/* 672 */     if (this.styleXfs.size() > 0) {
/* 673 */       CTCellStyleXfs cTCellStyleXfs = cTStylesheet.getCellStyleXfs();
/* 674 */       if (cTCellStyleXfs == null) {
/* 675 */         cTCellStyleXfs = CTCellStyleXfs.Factory.newInstance();
/*     */       }
/* 677 */       cTCellStyleXfs.setCount(this.styleXfs.size());
/* 678 */       cTCellStyleXfs.setXfArray(this.styleXfs.<CTXf>toArray(new CTXf[this.styleXfs.size()]));
/*     */ 
/*     */       
/* 681 */       cTStylesheet.setCellStyleXfs(cTCellStyleXfs);
/*     */     } 
/*     */ 
/*     */     
/* 685 */     if (this.dxfs.size() > 0) {
/* 686 */       CTDxfs cTDxfs = cTStylesheet.getDxfs();
/* 687 */       if (cTDxfs == null) {
/* 688 */         cTDxfs = CTDxfs.Factory.newInstance();
/*     */       }
/* 690 */       cTDxfs.setCount(this.dxfs.size());
/* 691 */       cTDxfs.setDxfArray(this.dxfs.<CTDxf>toArray(new CTDxf[this.dxfs.size()]));
/* 692 */       cTStylesheet.setDxfs(cTDxfs);
/*     */     } 
/*     */ 
/*     */     
/* 696 */     this.doc.save(paramOutputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 701 */     PackagePart packagePart = getPackagePart();
/* 702 */     OutputStream outputStream = packagePart.getOutputStream();
/* 703 */     writeTo(outputStream);
/* 704 */     outputStream.close();
/*     */   }
/*     */ 
/*     */   
/*     */   private void initialize() {
/* 709 */     XSSFFont xSSFFont = createDefaultFont();
/* 710 */     this.fonts.add(xSSFFont);
/*     */     
/* 712 */     CTFill[] arrayOfCTFill = createDefaultFills();
/* 713 */     this.fills.add(new XSSFCellFill(arrayOfCTFill[0]));
/* 714 */     this.fills.add(new XSSFCellFill(arrayOfCTFill[1]));
/*     */     
/* 716 */     CTBorder cTBorder = createDefaultBorder();
/* 717 */     this.borders.add(new XSSFCellBorder(cTBorder));
/*     */     
/* 719 */     CTXf cTXf1 = createDefaultXf();
/* 720 */     this.styleXfs.add(cTXf1);
/* 721 */     CTXf cTXf2 = createDefaultXf();
/* 722 */     cTXf2.setXfId(0L);
/* 723 */     this.xfs.add(cTXf2);
/*     */   }
/*     */   
/*     */   private static CTXf createDefaultXf() {
/* 727 */     CTXf cTXf = CTXf.Factory.newInstance();
/* 728 */     cTXf.setNumFmtId(0L);
/* 729 */     cTXf.setFontId(0L);
/* 730 */     cTXf.setFillId(0L);
/* 731 */     cTXf.setBorderId(0L);
/* 732 */     return cTXf;
/*     */   }
/*     */   private static CTBorder createDefaultBorder() {
/* 735 */     CTBorder cTBorder = CTBorder.Factory.newInstance();
/* 736 */     cTBorder.addNewBottom();
/* 737 */     cTBorder.addNewTop();
/* 738 */     cTBorder.addNewLeft();
/* 739 */     cTBorder.addNewRight();
/* 740 */     cTBorder.addNewDiagonal();
/* 741 */     return cTBorder;
/*     */   }
/*     */ 
/*     */   
/*     */   private static CTFill[] createDefaultFills() {
/* 746 */     CTFill[] arrayOfCTFill = { CTFill.Factory.newInstance(), CTFill.Factory.newInstance() };
/* 747 */     arrayOfCTFill[0].addNewPatternFill().setPatternType(STPatternType.NONE);
/* 748 */     arrayOfCTFill[1].addNewPatternFill().setPatternType(STPatternType.DARK_GRAY);
/* 749 */     return arrayOfCTFill;
/*     */   }
/*     */   
/*     */   private static XSSFFont createDefaultFont() {
/* 753 */     CTFont cTFont = CTFont.Factory.newInstance();
/* 754 */     XSSFFont xSSFFont = new XSSFFont(cTFont, 0);
/* 755 */     xSSFFont.setFontHeightInPoints((short)11);
/* 756 */     xSSFFont.setColor(XSSFFont.DEFAULT_FONT_COLOR);
/* 757 */     xSSFFont.setFontName("Calibri");
/* 758 */     xSSFFont.setFamily(FontFamily.SWISS);
/* 759 */     xSSFFont.setScheme(FontScheme.MINOR);
/* 760 */     return xSSFFont;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTDxf getDxfAt(int paramInt) {
/* 765 */     return this.dxfs.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public int putDxf(CTDxf paramCTDxf) {
/* 777 */     this.dxfs.add(paramCTDxf);
/* 778 */     return this.dxfs.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFCellStyle createCellStyle() {
/* 788 */     if (getNumCellStyles() > MAXIMUM_STYLE_ID) {
/* 789 */       throw new IllegalStateException("The maximum number of Cell Styles was exceeded. You can define up to " + MAXIMUM_STYLE_ID + " style in a .xlsx Workbook");
/*     */     }
/*     */ 
/*     */     
/* 793 */     int i = this.styleXfs.size();
/* 794 */     CTXf cTXf = CTXf.Factory.newInstance();
/* 795 */     cTXf.setNumFmtId(0L);
/* 796 */     cTXf.setFontId(0L);
/* 797 */     cTXf.setFillId(0L);
/* 798 */     cTXf.setBorderId(0L);
/* 799 */     cTXf.setXfId(0L);
/* 800 */     int j = putCellXf(cTXf);
/* 801 */     return new XSSFCellStyle(j - 1, i - 1, this, this.theme);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFFont findFont(short paramShort1, short paramShort2, short paramShort3, String paramString, boolean paramBoolean1, boolean paramBoolean2, short paramShort4, byte paramByte) {
/* 809 */     for (XSSFFont xSSFFont : this.fonts) {
/* 810 */       if (xSSFFont.getBoldweight() == paramShort1 && xSSFFont.getColor() == paramShort2 && xSSFFont.getFontHeight() == paramShort3 && xSSFFont.getFontName().equals(paramString) && xSSFFont.getItalic() == paramBoolean1 && xSSFFont.getStrikeout() == paramBoolean2 && xSSFFont.getTypeOffset() == paramShort4 && xSSFFont.getUnderline() == paramByte)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 819 */         return xSSFFont;
/*     */       }
/*     */     } 
/* 822 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFFont findFont(boolean paramBoolean1, short paramShort1, short paramShort2, String paramString, boolean paramBoolean2, boolean paramBoolean3, short paramShort3, byte paramByte) {
/* 829 */     for (XSSFFont xSSFFont : this.fonts) {
/* 830 */       if (xSSFFont.getBold() == paramBoolean1 && xSSFFont.getColor() == paramShort1 && xSSFFont.getFontHeight() == paramShort2 && xSSFFont.getFontName().equals(paramString) && xSSFFont.getItalic() == paramBoolean2 && xSSFFont.getStrikeout() == paramBoolean3 && xSSFFont.getTypeOffset() == paramShort3 && xSSFFont.getUnderline() == paramByte)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 839 */         return xSSFFont;
/*     */       }
/*     */     } 
/* 842 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\model\StylesTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */