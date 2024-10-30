/*      */ package org.apache.poi.xssf.usermodel;
/*      */ 
/*      */ import org.apache.poi.POIXMLException;
/*      */ import org.apache.poi.POIXMLTypeLoader;
/*      */ import org.apache.poi.ss.usermodel.BorderStyle;
/*      */ import org.apache.poi.ss.usermodel.CellStyle;
/*      */ import org.apache.poi.ss.usermodel.Color;
/*      */ import org.apache.poi.ss.usermodel.FillPatternType;
/*      */ import org.apache.poi.ss.usermodel.Font;
/*      */ import org.apache.poi.ss.usermodel.HorizontalAlignment;
/*      */ import org.apache.poi.ss.usermodel.IndexedColors;
/*      */ import org.apache.poi.ss.usermodel.VerticalAlignment;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.util.Removal;
/*      */ import org.apache.poi.xssf.model.StylesTable;
/*      */ import org.apache.poi.xssf.model.ThemesTable;
/*      */ import org.apache.poi.xssf.usermodel.extensions.XSSFCellAlignment;
/*      */ import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
/*      */ import org.apache.poi.xssf.usermodel.extensions.XSSFCellFill;
/*      */ import org.apache.xmlbeans.XmlException;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellAlignment;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class XSSFCellStyle
/*      */   implements CellStyle
/*      */ {
/*      */   private int _cellXfId;
/*      */   private final StylesTable _stylesSource;
/*      */   private CTXf _cellXf;
/*      */   private final CTXf _cellStyleXf;
/*      */   private XSSFFont _font;
/*      */   private XSSFCellAlignment _cellAlignment;
/*      */   private ThemesTable _theme;
/*      */   
/*      */   public XSSFCellStyle(int paramInt1, int paramInt2, StylesTable paramStylesTable, ThemesTable paramThemesTable) {
/*   76 */     this._cellXfId = paramInt1;
/*   77 */     this._stylesSource = paramStylesTable;
/*   78 */     this._cellXf = paramStylesTable.getCellXfAt(this._cellXfId);
/*   79 */     this._cellStyleXf = (paramInt2 == -1) ? null : paramStylesTable.getCellStyleXfAt(paramInt2);
/*   80 */     this._theme = paramThemesTable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public CTXf getCoreXf() {
/*   88 */     return this._cellXf;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public CTXf getStyleXf() {
/*   96 */     return this._cellStyleXf;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFCellStyle(StylesTable paramStylesTable) {
/*  103 */     this._stylesSource = paramStylesTable;
/*      */ 
/*      */     
/*  106 */     this._cellXf = CTXf.Factory.newInstance();
/*  107 */     this._cellStyleXf = null;
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
/*      */   public void verifyBelongsToStylesSource(StylesTable paramStylesTable) {
/*  120 */     if (this._stylesSource != paramStylesTable) {
/*  121 */       throw new IllegalArgumentException("This Style does not belong to the supplied Workbook Stlyes Source. Are you trying to assign a style from one workbook to the cell of a differnt workbook?");
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
/*      */   public void cloneStyleFrom(CellStyle paramCellStyle) {
/*  139 */     if (paramCellStyle instanceof XSSFCellStyle) {
/*  140 */       XSSFCellStyle xSSFCellStyle = (XSSFCellStyle)paramCellStyle;
/*      */ 
/*      */       
/*  143 */       if (xSSFCellStyle._stylesSource == this._stylesSource) {
/*      */         
/*  145 */         this._cellXf.set((XmlObject)xSSFCellStyle.getCoreXf());
/*  146 */         this._cellStyleXf.set((XmlObject)xSSFCellStyle.getStyleXf());
/*      */       } else {
/*      */ 
/*      */         
/*      */         try {
/*      */           
/*  152 */           if (this._cellXf.isSetAlignment())
/*  153 */             this._cellXf.unsetAlignment(); 
/*  154 */           if (this._cellXf.isSetExtLst()) {
/*  155 */             this._cellXf.unsetExtLst();
/*      */           }
/*      */           
/*  158 */           this._cellXf = CTXf.Factory.parse(xSSFCellStyle.getCoreXf().toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  163 */           CTFill cTFill = CTFill.Factory.parse(xSSFCellStyle.getCTFill().toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*      */ 
/*      */           
/*  166 */           addFill(cTFill);
/*      */ 
/*      */           
/*  169 */           CTBorder cTBorder = CTBorder.Factory.parse(xSSFCellStyle.getCTBorder().toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*      */ 
/*      */           
/*  172 */           addBorder(cTBorder);
/*      */ 
/*      */           
/*  175 */           this._stylesSource.replaceCellXfAt(this._cellXfId, this._cellXf);
/*  176 */         } catch (XmlException xmlException) {
/*  177 */           throw new POIXMLException(xmlException);
/*      */         } 
/*      */ 
/*      */         
/*  181 */         String str = xSSFCellStyle.getDataFormatString();
/*  182 */         setDataFormat((new XSSFDataFormat(this._stylesSource)).getFormat(str));
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         try {
/*  188 */           CTFont cTFont = CTFont.Factory.parse(xSSFCellStyle.getFont().getCTFont().toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*      */ 
/*      */           
/*  191 */           XSSFFont xSSFFont = new XSSFFont(cTFont);
/*  192 */           xSSFFont.registerTo(this._stylesSource);
/*  193 */           setFont(xSSFFont);
/*  194 */         } catch (XmlException xmlException) {
/*  195 */           throw new POIXMLException(xmlException);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  200 */       this._font = null;
/*  201 */       this._cellAlignment = null;
/*      */     } else {
/*  203 */       throw new IllegalArgumentException("Can only clone from one XSSFCellStyle to another, not between HSSFCellStyle and XSSFCellStyle");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void addFill(CTFill paramCTFill) {
/*  208 */     int i = this._stylesSource.putFill(new XSSFCellFill(paramCTFill));
/*      */     
/*  210 */     this._cellXf.setFillId(i);
/*  211 */     this._cellXf.setApplyFill(true);
/*      */   }
/*      */   
/*      */   private void addBorder(CTBorder paramCTBorder) {
/*  215 */     int i = this._stylesSource.putBorder(new XSSFCellBorder(paramCTBorder, this._theme));
/*      */     
/*  217 */     this._cellXf.setBorderId(i);
/*  218 */     this._cellXf.setApplyBorder(true);
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
/*      */   public short getAlignment() {
/*  236 */     return getAlignmentEnum().getCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HorizontalAlignment getAlignmentEnum() {
/*  246 */     CTCellAlignment cTCellAlignment = this._cellXf.getAlignment();
/*  247 */     if (cTCellAlignment != null && cTCellAlignment.isSetHorizontal()) {
/*  248 */       return HorizontalAlignment.forInt(cTCellAlignment.getHorizontal().intValue() - 1);
/*      */     }
/*  250 */     return HorizontalAlignment.GENERAL;
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
/*      */   public BorderStyle getBorderBottomEnum() {
/*  262 */     if (!this._cellXf.getApplyBorder()) return BorderStyle.NONE;
/*      */     
/*  264 */     int i = (int)this._cellXf.getBorderId();
/*  265 */     CTBorder cTBorder = this._stylesSource.getBorderAt(i).getCTBorder();
/*  266 */     STBorderStyle.Enum enum_ = cTBorder.isSetBottom() ? cTBorder.getBottom().getStyle() : null;
/*  267 */     if (enum_ == null) {
/*  268 */       return BorderStyle.NONE;
/*      */     }
/*  270 */     return BorderStyle.valueOf((short)(enum_.intValue() - 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBorderBottom() {
/*  280 */     return getBorderBottomEnum().getCode();
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
/*      */   public BorderStyle getBorderLeftEnum() {
/*  292 */     if (!this._cellXf.getApplyBorder()) return BorderStyle.NONE;
/*      */     
/*  294 */     int i = (int)this._cellXf.getBorderId();
/*  295 */     CTBorder cTBorder = this._stylesSource.getBorderAt(i).getCTBorder();
/*  296 */     STBorderStyle.Enum enum_ = cTBorder.isSetLeft() ? cTBorder.getLeft().getStyle() : null;
/*  297 */     if (enum_ == null) {
/*  298 */       return BorderStyle.NONE;
/*      */     }
/*  300 */     return BorderStyle.valueOf((short)(enum_.intValue() - 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBorderLeft() {
/*  311 */     return getBorderLeftEnum().getCode();
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
/*      */   public BorderStyle getBorderRightEnum() {
/*  323 */     if (!this._cellXf.getApplyBorder()) return BorderStyle.NONE;
/*      */     
/*  325 */     int i = (int)this._cellXf.getBorderId();
/*  326 */     CTBorder cTBorder = this._stylesSource.getBorderAt(i).getCTBorder();
/*  327 */     STBorderStyle.Enum enum_ = cTBorder.isSetRight() ? cTBorder.getRight().getStyle() : null;
/*  328 */     if (enum_ == null) {
/*  329 */       return BorderStyle.NONE;
/*      */     }
/*  331 */     return BorderStyle.valueOf((short)(enum_.intValue() - 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBorderRight() {
/*  341 */     return getBorderRightEnum().getCode();
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
/*      */   public BorderStyle getBorderTopEnum() {
/*  353 */     if (!this._cellXf.getApplyBorder()) return BorderStyle.NONE;
/*      */     
/*  355 */     int i = (int)this._cellXf.getBorderId();
/*  356 */     CTBorder cTBorder = this._stylesSource.getBorderAt(i).getCTBorder();
/*  357 */     STBorderStyle.Enum enum_ = cTBorder.isSetTop() ? cTBorder.getTop().getStyle() : null;
/*  358 */     if (enum_ == null) {
/*  359 */       return BorderStyle.NONE;
/*      */     }
/*  361 */     return BorderStyle.valueOf((short)(enum_.intValue() - 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getBorderTop() {
/*  371 */     return getBorderTopEnum().getCode();
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
/*      */   public short getBottomBorderColor() {
/*  383 */     XSSFColor xSSFColor = getBottomBorderXSSFColor();
/*  384 */     return (xSSFColor == null) ? IndexedColors.BLACK.getIndex() : xSSFColor.getIndexed();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFColor getBottomBorderXSSFColor() {
/*  393 */     if (!this._cellXf.getApplyBorder()) return null;
/*      */     
/*  395 */     int i = (int)this._cellXf.getBorderId();
/*  396 */     XSSFCellBorder xSSFCellBorder = this._stylesSource.getBorderAt(i);
/*      */     
/*  398 */     return xSSFCellBorder.getBorderColor(XSSFCellBorder.BorderSide.BOTTOM);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getDataFormat() {
/*  408 */     return (short)(int)this._cellXf.getNumFmtId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDataFormatString() {
/*  419 */     short s = getDataFormat();
/*  420 */     return (new XSSFDataFormat(this._stylesSource)).getFormat((short)s);
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
/*      */   public short getFillBackgroundColor() {
/*  434 */     XSSFColor xSSFColor = getFillBackgroundXSSFColor();
/*  435 */     return (xSSFColor == null) ? IndexedColors.AUTOMATIC.getIndex() : xSSFColor.getIndexed();
/*      */   }
/*      */ 
/*      */   
/*      */   public XSSFColor getFillBackgroundColorColor() {
/*  440 */     return getFillBackgroundXSSFColor();
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
/*      */   public XSSFColor getFillBackgroundXSSFColor() {
/*  454 */     if (this._cellXf.isSetApplyFill() && !this._cellXf.getApplyFill()) return null;
/*      */     
/*  456 */     int i = (int)this._cellXf.getFillId();
/*  457 */     XSSFCellFill xSSFCellFill = this._stylesSource.getFillAt(i);
/*      */     
/*  459 */     XSSFColor xSSFColor = xSSFCellFill.getFillBackgroundColor();
/*  460 */     if (xSSFColor != null && this._theme != null) {
/*  461 */       this._theme.inheritFromThemeAsRequired(xSSFColor);
/*      */     }
/*  463 */     return xSSFColor;
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
/*      */   public short getFillForegroundColor() {
/*  477 */     XSSFColor xSSFColor = getFillForegroundXSSFColor();
/*  478 */     return (xSSFColor == null) ? IndexedColors.AUTOMATIC.getIndex() : xSSFColor.getIndexed();
/*      */   }
/*      */ 
/*      */   
/*      */   public XSSFColor getFillForegroundColorColor() {
/*  483 */     return getFillForegroundXSSFColor();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFColor getFillForegroundXSSFColor() {
/*  493 */     if (this._cellXf.isSetApplyFill() && !this._cellXf.getApplyFill()) return null;
/*      */     
/*  495 */     int i = (int)this._cellXf.getFillId();
/*  496 */     XSSFCellFill xSSFCellFill = this._stylesSource.getFillAt(i);
/*      */     
/*  498 */     XSSFColor xSSFColor = xSSFCellFill.getFillForegroundColor();
/*  499 */     if (xSSFColor != null && this._theme != null) {
/*  500 */       this._theme.inheritFromThemeAsRequired(xSSFColor);
/*      */     }
/*  502 */     return xSSFColor;
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
/*      */   public short getFillPattern() {
/*  530 */     return getFillPatternEnum().getCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FillPatternType getFillPatternEnum() {
/*  541 */     if (this._cellXf.isSetApplyFill() && !this._cellXf.getApplyFill()) return FillPatternType.NO_FILL;
/*      */     
/*  543 */     int i = (int)this._cellXf.getFillId();
/*  544 */     XSSFCellFill xSSFCellFill = this._stylesSource.getFillAt(i);
/*      */     
/*  546 */     STPatternType.Enum enum_ = xSSFCellFill.getPatternType();
/*  547 */     if (enum_ == null) return FillPatternType.NO_FILL; 
/*  548 */     return FillPatternType.forInt(enum_.intValue() - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFFont getFont() {
/*  556 */     if (this._font == null) {
/*  557 */       this._font = this._stylesSource.getFontAt(getFontId());
/*      */     }
/*  559 */     return this._font;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getFontIndex() {
/*  570 */     return (short)getFontId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getHidden() {
/*  580 */     if (!this._cellXf.isSetProtection() || !this._cellXf.getProtection().isSetHidden()) {
/*  581 */       return false;
/*      */     }
/*  583 */     return this._cellXf.getProtection().getHidden();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getIndention() {
/*  593 */     CTCellAlignment cTCellAlignment = this._cellXf.getAlignment();
/*  594 */     return (short)(int)((cTCellAlignment == null) ? 0L : cTCellAlignment.getIndent());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getIndex() {
/*  604 */     return (short)this._cellXfId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int getUIndex() {
/*  615 */     return this._cellXfId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getLeftBorderColor() {
/*  626 */     XSSFColor xSSFColor = getLeftBorderXSSFColor();
/*  627 */     return (xSSFColor == null) ? IndexedColors.BLACK.getIndex() : xSSFColor.getIndexed();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFColor getLeftBorderXSSFColor() {
/*  637 */     if (!this._cellXf.getApplyBorder()) return null;
/*      */     
/*  639 */     int i = (int)this._cellXf.getBorderId();
/*  640 */     XSSFCellBorder xSSFCellBorder = this._stylesSource.getBorderAt(i);
/*      */     
/*  642 */     return xSSFCellBorder.getBorderColor(XSSFCellBorder.BorderSide.LEFT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getLocked() {
/*  652 */     if (!this._cellXf.isSetProtection() || !this._cellXf.getProtection().isSetLocked()) {
/*  653 */       return true;
/*      */     }
/*  655 */     return this._cellXf.getProtection().getLocked();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getRightBorderColor() {
/*  666 */     XSSFColor xSSFColor = getRightBorderXSSFColor();
/*  667 */     return (xSSFColor == null) ? IndexedColors.BLACK.getIndex() : xSSFColor.getIndexed();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFColor getRightBorderXSSFColor() {
/*  675 */     if (!this._cellXf.getApplyBorder()) return null;
/*      */     
/*  677 */     int i = (int)this._cellXf.getBorderId();
/*  678 */     XSSFCellBorder xSSFCellBorder = this._stylesSource.getBorderAt(i);
/*      */     
/*  680 */     return xSSFCellBorder.getBorderColor(XSSFCellBorder.BorderSide.RIGHT);
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
/*      */   public short getRotation() {
/*  699 */     CTCellAlignment cTCellAlignment = this._cellXf.getAlignment();
/*  700 */     return (short)(int)((cTCellAlignment == null) ? 0L : cTCellAlignment.getTextRotation());
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getShrinkToFit() {
/*  705 */     CTCellAlignment cTCellAlignment = this._cellXf.getAlignment();
/*  706 */     return (cTCellAlignment != null && cTCellAlignment.getShrinkToFit());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getTopBorderColor() {
/*  717 */     XSSFColor xSSFColor = getTopBorderXSSFColor();
/*  718 */     return (xSSFColor == null) ? IndexedColors.BLACK.getIndex() : xSSFColor.getIndexed();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFColor getTopBorderXSSFColor() {
/*  727 */     if (!this._cellXf.getApplyBorder()) return null;
/*      */     
/*  729 */     int i = (int)this._cellXf.getBorderId();
/*  730 */     XSSFCellBorder xSSFCellBorder = this._stylesSource.getBorderAt(i);
/*      */     
/*  732 */     return xSSFCellBorder.getBorderColor(XSSFCellBorder.BorderSide.TOP);
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
/*      */   public short getVerticalAlignment() {
/*  747 */     return getVerticalAlignmentEnum().getCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public VerticalAlignment getVerticalAlignmentEnum() {
/*  757 */     CTCellAlignment cTCellAlignment = this._cellXf.getAlignment();
/*  758 */     if (cTCellAlignment != null && cTCellAlignment.isSetVertical()) {
/*  759 */       return VerticalAlignment.forInt(cTCellAlignment.getVertical().intValue() - 1);
/*      */     }
/*  761 */     return VerticalAlignment.BOTTOM;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getWrapText() {
/*  771 */     CTCellAlignment cTCellAlignment = this._cellXf.getAlignment();
/*  772 */     return (cTCellAlignment != null && cTCellAlignment.getWrapText());
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
/*      */   @Removal(version = "3.17")
/*      */   public void setAlignment(short paramShort) {
/*  791 */     setAlignment(HorizontalAlignment.forInt(paramShort));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAlignment(HorizontalAlignment paramHorizontalAlignment) {
/*  801 */     getCellAlignment().setHorizontal(paramHorizontalAlignment);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Removal(version = "3.17")
/*      */   public void setBorderBottom(short paramShort) {
/*  813 */     setBorderBottom(BorderStyle.valueOf(paramShort));
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
/*      */   public void setBorderBottom(BorderStyle paramBorderStyle) {
/*  825 */     CTBorder cTBorder = getCTBorder();
/*  826 */     CTBorderPr cTBorderPr = cTBorder.isSetBottom() ? cTBorder.getBottom() : cTBorder.addNewBottom();
/*  827 */     if (paramBorderStyle == BorderStyle.NONE) { cTBorder.unsetBottom(); }
/*  828 */     else { cTBorderPr.setStyle(STBorderStyle.Enum.forInt(paramBorderStyle.getCode() + 1)); }
/*      */     
/*  830 */     int i = this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme));
/*      */     
/*  832 */     this._cellXf.setBorderId(i);
/*  833 */     this._cellXf.setApplyBorder(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Removal(version = "3.17")
/*      */   public void setBorderLeft(short paramShort) {
/*  844 */     setBorderLeft(BorderStyle.valueOf(paramShort));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBorderLeft(BorderStyle paramBorderStyle) {
/*  855 */     CTBorder cTBorder = getCTBorder();
/*  856 */     CTBorderPr cTBorderPr = cTBorder.isSetLeft() ? cTBorder.getLeft() : cTBorder.addNewLeft();
/*  857 */     if (paramBorderStyle == BorderStyle.NONE) { cTBorder.unsetLeft(); }
/*  858 */     else { cTBorderPr.setStyle(STBorderStyle.Enum.forInt(paramBorderStyle.getCode() + 1)); }
/*      */     
/*  860 */     int i = this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme));
/*      */     
/*  862 */     this._cellXf.setBorderId(i);
/*  863 */     this._cellXf.setApplyBorder(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Removal(version = "3.17")
/*      */   public void setBorderRight(short paramShort) {
/*  875 */     setBorderRight(BorderStyle.valueOf(paramShort));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBorderRight(BorderStyle paramBorderStyle) {
/*  886 */     CTBorder cTBorder = getCTBorder();
/*  887 */     CTBorderPr cTBorderPr = cTBorder.isSetRight() ? cTBorder.getRight() : cTBorder.addNewRight();
/*  888 */     if (paramBorderStyle == BorderStyle.NONE) { cTBorder.unsetRight(); }
/*  889 */     else { cTBorderPr.setStyle(STBorderStyle.Enum.forInt(paramBorderStyle.getCode() + 1)); }
/*      */     
/*  891 */     int i = this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme));
/*      */     
/*  893 */     this._cellXf.setBorderId(i);
/*  894 */     this._cellXf.setApplyBorder(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Removal(version = "3.17")
/*      */   public void setBorderTop(short paramShort) {
/*  906 */     setBorderTop(BorderStyle.valueOf(paramShort));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBorderTop(BorderStyle paramBorderStyle) {
/*  917 */     CTBorder cTBorder = getCTBorder();
/*  918 */     CTBorderPr cTBorderPr = cTBorder.isSetTop() ? cTBorder.getTop() : cTBorder.addNewTop();
/*  919 */     if (paramBorderStyle == BorderStyle.NONE) { cTBorder.unsetTop(); }
/*  920 */     else { cTBorderPr.setStyle(STBorderStyle.Enum.forInt(paramBorderStyle.getCode() + 1)); }
/*      */     
/*  922 */     int i = this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme));
/*      */     
/*  924 */     this._cellXf.setBorderId(i);
/*  925 */     this._cellXf.setApplyBorder(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBottomBorderColor(short paramShort) {
/*  935 */     XSSFColor xSSFColor = new XSSFColor();
/*  936 */     xSSFColor.setIndexed(paramShort);
/*  937 */     setBottomBorderColor(xSSFColor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBottomBorderColor(XSSFColor paramXSSFColor) {
/*  946 */     CTBorder cTBorder = getCTBorder();
/*  947 */     if (paramXSSFColor == null && !cTBorder.isSetBottom())
/*      */       return; 
/*  949 */     CTBorderPr cTBorderPr = cTBorder.isSetBottom() ? cTBorder.getBottom() : cTBorder.addNewBottom();
/*  950 */     if (paramXSSFColor != null) { cTBorderPr.setColor(paramXSSFColor.getCTColor()); }
/*  951 */     else { cTBorderPr.unsetColor(); }
/*      */     
/*  953 */     int i = this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme));
/*      */     
/*  955 */     this._cellXf.setBorderId(i);
/*  956 */     this._cellXf.setApplyBorder(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDataFormat(short paramShort) {
/*  967 */     setDataFormat(paramShort & 0xFFFF);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDataFormat(int paramInt) {
/*  975 */     this._cellXf.setApplyNumberFormat(true);
/*  976 */     this._cellXf.setNumFmtId(paramInt);
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
/*      */   public void setFillBackgroundColor(XSSFColor paramXSSFColor) {
/* 1005 */     CTFill cTFill = getCTFill();
/* 1006 */     CTPatternFill cTPatternFill = cTFill.getPatternFill();
/* 1007 */     if (paramXSSFColor == null) {
/* 1008 */       if (cTPatternFill != null && cTPatternFill.isSetBgColor()) cTPatternFill.unsetBgColor(); 
/*      */     } else {
/* 1010 */       if (cTPatternFill == null) cTPatternFill = cTFill.addNewPatternFill(); 
/* 1011 */       cTPatternFill.setBgColor(paramXSSFColor.getCTColor());
/*      */     } 
/*      */     
/* 1014 */     addFill(cTFill);
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
/*      */   public void setFillBackgroundColor(short paramShort) {
/* 1045 */     XSSFColor xSSFColor = new XSSFColor();
/* 1046 */     xSSFColor.setIndexed(paramShort);
/* 1047 */     setFillBackgroundColor(xSSFColor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFillForegroundColor(XSSFColor paramXSSFColor) {
/* 1058 */     CTFill cTFill = getCTFill();
/*      */     
/* 1060 */     CTPatternFill cTPatternFill = cTFill.getPatternFill();
/* 1061 */     if (paramXSSFColor == null) {
/* 1062 */       if (cTPatternFill != null && cTPatternFill.isSetFgColor()) cTPatternFill.unsetFgColor(); 
/*      */     } else {
/* 1064 */       if (cTPatternFill == null) cTPatternFill = cTFill.addNewPatternFill(); 
/* 1065 */       cTPatternFill.setFgColor(paramXSSFColor.getCTColor());
/*      */     } 
/*      */     
/* 1068 */     addFill(cTFill);
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
/*      */   public void setFillForegroundColor(short paramShort) {
/* 1080 */     XSSFColor xSSFColor = new XSSFColor();
/* 1081 */     xSSFColor.setIndexed(paramShort);
/* 1082 */     setFillForegroundColor(xSSFColor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CTFill getCTFill() {
/*      */     CTFill cTFill;
/* 1091 */     if (!this._cellXf.isSetApplyFill() || this._cellXf.getApplyFill()) {
/* 1092 */       int i = (int)this._cellXf.getFillId();
/* 1093 */       XSSFCellFill xSSFCellFill = this._stylesSource.getFillAt(i);
/*      */       
/* 1095 */       cTFill = (CTFill)xSSFCellFill.getCTFill().copy();
/*      */     } else {
/* 1097 */       cTFill = CTFill.Factory.newInstance();
/*      */     } 
/* 1099 */     return cTFill;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CTBorder getCTBorder() {
/*      */     CTBorder cTBorder;
/* 1107 */     if (this._cellXf.getApplyBorder()) {
/* 1108 */       int i = (int)this._cellXf.getBorderId();
/* 1109 */       XSSFCellBorder xSSFCellBorder = this._stylesSource.getBorderAt(i);
/*      */       
/* 1111 */       cTBorder = (CTBorder)xSSFCellBorder.getCTBorder().copy();
/*      */     } else {
/* 1113 */       cTBorder = CTBorder.Factory.newInstance();
/*      */     } 
/* 1115 */     return cTBorder;
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
/*      */   
/*      */   @Removal(version = "3.17")
/*      */   public void setFillPattern(short paramShort) {
/* 1148 */     setFillPattern(FillPatternType.forInt(paramShort));
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
/*      */   public void setFillPattern(FillPatternType paramFillPatternType) {
/* 1162 */     CTFill cTFill = getCTFill();
/* 1163 */     CTPatternFill cTPatternFill = cTFill.isSetPatternFill() ? cTFill.getPatternFill() : cTFill.addNewPatternFill();
/* 1164 */     if (paramFillPatternType == FillPatternType.NO_FILL && cTPatternFill.isSetPatternType()) {
/* 1165 */       cTPatternFill.unsetPatternType();
/*      */     } else {
/* 1167 */       cTPatternFill.setPatternType(STPatternType.Enum.forInt(paramFillPatternType.getCode() + 1));
/*      */     } 
/*      */     
/* 1170 */     addFill(cTFill);
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
/*      */   public void setFont(Font paramFont) {
/* 1182 */     if (paramFont != null) {
/* 1183 */       long l = paramFont.getIndex();
/* 1184 */       this._cellXf.setFontId(l);
/* 1185 */       this._cellXf.setApplyFont(true);
/*      */     } else {
/* 1187 */       this._cellXf.setApplyFont(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHidden(boolean paramBoolean) {
/* 1198 */     if (!this._cellXf.isSetProtection()) {
/* 1199 */       this._cellXf.addNewProtection();
/*      */     }
/* 1201 */     this._cellXf.getProtection().setHidden(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setIndention(short paramShort) {
/* 1211 */     getCellAlignment().setIndent(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLeftBorderColor(short paramShort) {
/* 1222 */     XSSFColor xSSFColor = new XSSFColor();
/* 1223 */     xSSFColor.setIndexed(paramShort);
/* 1224 */     setLeftBorderColor(xSSFColor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLeftBorderColor(XSSFColor paramXSSFColor) {
/* 1233 */     CTBorder cTBorder = getCTBorder();
/* 1234 */     if (paramXSSFColor == null && !cTBorder.isSetLeft())
/*      */       return; 
/* 1236 */     CTBorderPr cTBorderPr = cTBorder.isSetLeft() ? cTBorder.getLeft() : cTBorder.addNewLeft();
/* 1237 */     if (paramXSSFColor != null) { cTBorderPr.setColor(paramXSSFColor.getCTColor()); }
/* 1238 */     else { cTBorderPr.unsetColor(); }
/*      */     
/* 1240 */     int i = this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme));
/*      */     
/* 1242 */     this._cellXf.setBorderId(i);
/* 1243 */     this._cellXf.setApplyBorder(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLocked(boolean paramBoolean) {
/* 1253 */     if (!this._cellXf.isSetProtection()) {
/* 1254 */       this._cellXf.addNewProtection();
/*      */     }
/* 1256 */     this._cellXf.getProtection().setLocked(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRightBorderColor(short paramShort) {
/* 1267 */     XSSFColor xSSFColor = new XSSFColor();
/* 1268 */     xSSFColor.setIndexed(paramShort);
/* 1269 */     setRightBorderColor(xSSFColor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRightBorderColor(XSSFColor paramXSSFColor) {
/* 1278 */     CTBorder cTBorder = getCTBorder();
/* 1279 */     if (paramXSSFColor == null && !cTBorder.isSetRight())
/*      */       return; 
/* 1281 */     CTBorderPr cTBorderPr = cTBorder.isSetRight() ? cTBorder.getRight() : cTBorder.addNewRight();
/* 1282 */     if (paramXSSFColor != null) { cTBorderPr.setColor(paramXSSFColor.getCTColor()); }
/* 1283 */     else { cTBorderPr.unsetColor(); }
/*      */     
/* 1285 */     int i = this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme));
/*      */     
/* 1287 */     this._cellXf.setBorderId(i);
/* 1288 */     this._cellXf.setApplyBorder(true);
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
/*      */   public void setRotation(short paramShort) {
/* 1312 */     getCellAlignment().setTextRotation(paramShort);
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
/*      */   public void setTopBorderColor(short paramShort) {
/* 1324 */     XSSFColor xSSFColor = new XSSFColor();
/* 1325 */     xSSFColor.setIndexed(paramShort);
/* 1326 */     setTopBorderColor(xSSFColor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTopBorderColor(XSSFColor paramXSSFColor) {
/* 1335 */     CTBorder cTBorder = getCTBorder();
/* 1336 */     if (paramXSSFColor == null && !cTBorder.isSetTop())
/*      */       return; 
/* 1338 */     CTBorderPr cTBorderPr = cTBorder.isSetTop() ? cTBorder.getTop() : cTBorder.addNewTop();
/* 1339 */     if (paramXSSFColor != null) { cTBorderPr.setColor(paramXSSFColor.getCTColor()); }
/* 1340 */     else { cTBorderPr.unsetColor(); }
/*      */     
/* 1342 */     int i = this._stylesSource.putBorder(new XSSFCellBorder(cTBorder, this._theme));
/*      */     
/* 1344 */     this._cellXf.setBorderId(i);
/* 1345 */     this._cellXf.setApplyBorder(true);
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
/*      */   @Removal(version = "3.17")
/*      */   public void setVerticalAlignment(short paramShort) {
/* 1362 */     setVerticalAlignment(VerticalAlignment.forInt(paramShort));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVerticalAlignment(VerticalAlignment paramVerticalAlignment) {
/* 1371 */     getCellAlignment().setVertical(paramVerticalAlignment);
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
/*      */   public void setWrapText(boolean paramBoolean) {
/* 1385 */     getCellAlignment().setWrapText(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFColor getBorderColor(XSSFCellBorder.BorderSide paramBorderSide) {
/* 1395 */     switch (paramBorderSide) {
/*      */       case BOTTOM:
/* 1397 */         return getBottomBorderXSSFColor();
/*      */       case RIGHT:
/* 1399 */         return getRightBorderXSSFColor();
/*      */       case TOP:
/* 1401 */         return getTopBorderXSSFColor();
/*      */       case LEFT:
/* 1403 */         return getLeftBorderXSSFColor();
/*      */     } 
/* 1405 */     throw new IllegalArgumentException("Unknown border: " + paramBorderSide);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBorderColor(XSSFCellBorder.BorderSide paramBorderSide, XSSFColor paramXSSFColor) {
/* 1416 */     switch (paramBorderSide) {
/*      */       case BOTTOM:
/* 1418 */         setBottomBorderColor(paramXSSFColor);
/*      */         break;
/*      */       case RIGHT:
/* 1421 */         setRightBorderColor(paramXSSFColor);
/*      */         break;
/*      */       case TOP:
/* 1424 */         setTopBorderColor(paramXSSFColor);
/*      */         break;
/*      */       case LEFT:
/* 1427 */         setLeftBorderColor(paramXSSFColor);
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setShrinkToFit(boolean paramBoolean) {
/* 1434 */     getCellAlignment().setShrinkToFit(paramBoolean);
/*      */   }
/*      */   
/*      */   private int getFontId() {
/* 1438 */     if (this._cellXf.isSetFontId()) {
/* 1439 */       return (int)this._cellXf.getFontId();
/*      */     }
/* 1441 */     return (int)this._cellStyleXf.getFontId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected XSSFCellAlignment getCellAlignment() {
/* 1449 */     if (this._cellAlignment == null) {
/* 1450 */       this._cellAlignment = new XSSFCellAlignment(getCTCellAlignment());
/*      */     }
/* 1452 */     return this._cellAlignment;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CTCellAlignment getCTCellAlignment() {
/* 1461 */     if (this._cellXf.getAlignment() == null) {
/* 1462 */       this._cellXf.setAlignment(CTCellAlignment.Factory.newInstance());
/*      */     }
/* 1464 */     return this._cellXf.getAlignment();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1474 */     return this._cellXf.toString().hashCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/* 1485 */     if (paramObject == null || !(paramObject instanceof XSSFCellStyle)) return false;
/*      */     
/* 1487 */     XSSFCellStyle xSSFCellStyle = (XSSFCellStyle)paramObject;
/* 1488 */     return this._cellXf.toString().equals(xSSFCellStyle.getCoreXf().toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object clone() {
/* 1499 */     CTXf cTXf = (CTXf)this._cellXf.copy();
/*      */     
/* 1501 */     int i = this._stylesSource._getStyleXfsSize();
/* 1502 */     int j = this._stylesSource.putCellXf(cTXf);
/* 1503 */     return new XSSFCellStyle(j - 1, i - 1, this._stylesSource, this._theme);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFCellStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */