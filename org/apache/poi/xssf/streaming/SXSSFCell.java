/*      */ package org.apache.poi.xssf.streaming;
/*      */ 
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import org.apache.poi.ss.SpreadsheetVersion;
/*      */ import org.apache.poi.ss.formula.FormulaParseException;
/*      */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*      */ import org.apache.poi.ss.usermodel.Cell;
/*      */ import org.apache.poi.ss.usermodel.CellStyle;
/*      */ import org.apache.poi.ss.usermodel.CellType;
/*      */ import org.apache.poi.ss.usermodel.Comment;
/*      */ import org.apache.poi.ss.usermodel.DateUtil;
/*      */ import org.apache.poi.ss.usermodel.FormulaError;
/*      */ import org.apache.poi.ss.usermodel.Hyperlink;
/*      */ import org.apache.poi.ss.usermodel.RichTextString;
/*      */ import org.apache.poi.ss.usermodel.Row;
/*      */ import org.apache.poi.ss.usermodel.Sheet;
/*      */ import org.apache.poi.ss.util.CellAddress;
/*      */ import org.apache.poi.ss.util.CellRangeAddress;
/*      */ import org.apache.poi.ss.util.CellReference;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.util.LocaleUtil;
/*      */ import org.apache.poi.util.NotImplemented;
/*      */ import org.apache.poi.util.POILogFactory;
/*      */ import org.apache.poi.util.POILogger;
/*      */ import org.apache.poi.util.Removal;
/*      */ import org.apache.poi.xssf.usermodel.XSSFHyperlink;
/*      */ import org.apache.poi.xssf.usermodel.XSSFRichTextString;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SXSSFCell
/*      */   implements Cell
/*      */ {
/*   54 */   private static final POILogger logger = POILogFactory.getLogger(SXSSFCell.class);
/*      */ 
/*      */   
/*      */   private final SXSSFRow _row;
/*      */   
/*      */   private Value _value;
/*      */   
/*      */   private CellStyle _style;
/*      */   
/*      */   private Property _firstProperty;
/*      */ 
/*      */   
/*      */   @Removal(version = "3.17")
/*      */   @Deprecated
/*      */   public SXSSFCell(SXSSFRow paramSXSSFRow, int paramInt) {
/*   69 */     this(paramSXSSFRow, CellType.forInt(paramInt));
/*      */   }
/*      */ 
/*      */   
/*      */   public SXSSFCell(SXSSFRow paramSXSSFRow, CellType paramCellType) {
/*   74 */     this._row = paramSXSSFRow;
/*   75 */     setType(paramCellType);
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
/*      */   public int getColumnIndex() {
/*   88 */     return this._row.getCellIndex(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRowIndex() {
/*   99 */     return this._row.getRowNum();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CellAddress getAddress() {
/*  107 */     return new CellAddress(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SXSSFSheet getSheet() {
/*  118 */     return this._row.getSheet();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Row getRow() {
/*  129 */     return this._row;
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
/*      */   public void setCellType(int paramInt) {
/*  148 */     ensureType(CellType.forInt(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellType(CellType paramCellType) {
/*  158 */     ensureType(paramCellType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCellType() {
/*  169 */     return getCellTypeEnum().getCode();
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
/*      */   @Internal(since = "POI 3.15 beta 3")
/*      */   public CellType getCellTypeEnum() {
/*  184 */     return this._value.getType();
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
/*      */   public int getCachedFormulaResultType() {
/*  196 */     return getCachedFormulaResultTypeEnum().getCode();
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
/*      */   @Internal(since = "POI 3.15 beta 3")
/*      */   public CellType getCachedFormulaResultTypeEnum() {
/*  212 */     if (this._value.getType() != CellType.FORMULA) {
/*  213 */       throw new IllegalStateException("Only formula cells have cached results");
/*      */     }
/*      */     
/*  216 */     return ((FormulaValue)this._value).getFormulaType();
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
/*      */   public void setCellValue(double paramDouble) {
/*  229 */     if (Double.isInfinite(paramDouble)) {
/*      */ 
/*      */       
/*  232 */       setCellErrorValue(FormulaError.DIV0.getCode());
/*  233 */     } else if (Double.isNaN(paramDouble)) {
/*  234 */       setCellErrorValue(FormulaError.NUM.getCode());
/*      */     } else {
/*  236 */       ensureTypeOrFormulaType(CellType.NUMERIC);
/*  237 */       if (this._value.getType() == CellType.FORMULA) {
/*  238 */         ((NumericFormulaValue)this._value).setPreEvaluatedValue(paramDouble);
/*      */       } else {
/*  240 */         ((NumericValue)this._value).setValue(paramDouble);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellValue(Date paramDate) {
/*  261 */     if (paramDate == null) {
/*  262 */       setCellType(CellType.BLANK);
/*      */       
/*      */       return;
/*      */     } 
/*  266 */     boolean bool = getSheet().getWorkbook().isDate1904();
/*  267 */     setCellValue(DateUtil.getExcelDate(paramDate, bool));
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
/*      */   public void setCellValue(Calendar paramCalendar) {
/*  288 */     if (paramCalendar == null) {
/*  289 */       setCellType(CellType.BLANK);
/*      */       
/*      */       return;
/*      */     } 
/*  293 */     boolean bool = getSheet().getWorkbook().isDate1904();
/*  294 */     setCellValue(DateUtil.getExcelDate(paramCalendar, bool));
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
/*      */   public void setCellValue(RichTextString paramRichTextString) {
/*  308 */     XSSFRichTextString xSSFRichTextString = (XSSFRichTextString)paramRichTextString;
/*      */     
/*  310 */     if (xSSFRichTextString != null && xSSFRichTextString.getString() != null) {
/*  311 */       ensureRichTextStringType();
/*      */       
/*  313 */       if (xSSFRichTextString.length() > SpreadsheetVersion.EXCEL2007.getMaxTextLength()) {
/*  314 */         throw new IllegalArgumentException("The maximum length of cell contents (text) is 32,767 characters");
/*      */       }
/*  316 */       if (xSSFRichTextString.hasFormatting()) {
/*  317 */         logger.log(5, new Object[] { "SXSSF doesn't support Shared Strings, rich text formatting information has be lost" });
/*      */       }
/*  319 */       ((RichTextValue)this._value).setValue((RichTextString)xSSFRichTextString);
/*      */     } else {
/*  321 */       setCellType(CellType.BLANK);
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
/*      */   public void setCellValue(String paramString) {
/*  336 */     if (paramString != null)
/*  337 */     { ensureTypeOrFormulaType(CellType.STRING);
/*      */       
/*  339 */       if (paramString.length() > SpreadsheetVersion.EXCEL2007.getMaxTextLength()) {
/*  340 */         throw new IllegalArgumentException("The maximum length of cell contents (text) is 32,767 characters");
/*      */       }
/*      */       
/*  343 */       if (this._value.getType() == CellType.FORMULA) {
/*  344 */         if (this._value instanceof NumericFormulaValue) {
/*  345 */           ((NumericFormulaValue)this._value).setPreEvaluatedValue(Double.parseDouble(paramString));
/*      */         } else {
/*  347 */           ((StringFormulaValue)this._value).setPreEvaluatedValue(paramString);
/*      */         } 
/*      */       } else {
/*  350 */         ((PlainStringValue)this._value).setValue(paramString);
/*      */       }  }
/*  352 */     else { setCellType(CellType.BLANK); }
/*      */   
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
/*      */   public void setCellFormula(String paramString) throws FormulaParseException {
/*  370 */     if (paramString == null) {
/*  371 */       setType(CellType.BLANK);
/*      */       
/*      */       return;
/*      */     } 
/*  375 */     ensureFormulaType(computeTypeFromFormula(paramString));
/*  376 */     ((FormulaValue)this._value).setValue(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCellFormula() {
/*  387 */     if (this._value.getType() != CellType.FORMULA)
/*  388 */       throw typeMismatch(CellType.FORMULA, this._value.getType(), false); 
/*  389 */     return ((FormulaValue)this._value).getValue();
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
/*      */   public double getNumericCellValue() {
/*      */     FormulaValue formulaValue;
/*  406 */     CellType cellType = getCellTypeEnum();
/*  407 */     switch (cellType) {
/*      */       
/*      */       case BLANK:
/*  410 */         return 0.0D;
/*      */       
/*      */       case FORMULA:
/*  413 */         formulaValue = (FormulaValue)this._value;
/*  414 */         if (formulaValue.getFormulaType() != CellType.NUMERIC)
/*  415 */           throw typeMismatch(CellType.NUMERIC, CellType.FORMULA, false); 
/*  416 */         return ((NumericFormulaValue)this._value).getPreEvaluatedValue();
/*      */       
/*      */       case NUMERIC:
/*  419 */         return ((NumericValue)this._value).getValue();
/*      */     } 
/*  421 */     throw typeMismatch(CellType.NUMERIC, cellType, false);
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
/*      */   public Date getDateCellValue() {
/*  438 */     CellType cellType = getCellTypeEnum();
/*  439 */     if (cellType == CellType.BLANK)
/*      */     {
/*  441 */       return null;
/*      */     }
/*      */     
/*  444 */     double d = getNumericCellValue();
/*  445 */     boolean bool = getSheet().getWorkbook().isDate1904();
/*  446 */     return DateUtil.getJavaDate(d, bool);
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
/*      */   public RichTextString getRichStringCellValue() {
/*  460 */     CellType cellType = getCellTypeEnum();
/*  461 */     if (getCellTypeEnum() != CellType.STRING) {
/*  462 */       throw typeMismatch(CellType.STRING, cellType, false);
/*      */     }
/*  464 */     StringValue stringValue = (StringValue)this._value;
/*  465 */     if (stringValue.isRichText()) {
/*  466 */       return ((RichTextValue)this._value).getValue();
/*      */     }
/*  468 */     String str = getStringCellValue();
/*  469 */     return getSheet().getWorkbook().getCreationHelper().createRichTextString(str);
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
/*      */   public String getStringCellValue() {
/*      */     FormulaValue formulaValue;
/*  485 */     CellType cellType = getCellTypeEnum();
/*  486 */     switch (cellType) {
/*      */       
/*      */       case BLANK:
/*  489 */         return "";
/*      */       
/*      */       case FORMULA:
/*  492 */         formulaValue = (FormulaValue)this._value;
/*  493 */         if (formulaValue.getFormulaType() != CellType.STRING)
/*  494 */           throw typeMismatch(CellType.STRING, CellType.FORMULA, false); 
/*  495 */         return ((StringFormulaValue)this._value).getPreEvaluatedValue();
/*      */ 
/*      */       
/*      */       case STRING:
/*  499 */         if (((StringValue)this._value).isRichText()) {
/*  500 */           return ((RichTextValue)this._value).getValue().getString();
/*      */         }
/*  502 */         return ((PlainStringValue)this._value).getValue();
/*      */     } 
/*      */     
/*  505 */     throw typeMismatch(CellType.STRING, cellType, false);
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
/*      */   public void setCellValue(boolean paramBoolean) {
/*  519 */     ensureTypeOrFormulaType(CellType.BOOLEAN);
/*  520 */     if (this._value.getType() == CellType.FORMULA) {
/*  521 */       ((BooleanFormulaValue)this._value).setPreEvaluatedValue(paramBoolean);
/*      */     } else {
/*  523 */       ((BooleanValue)this._value).setValue(paramBoolean);
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
/*      */   public void setCellErrorValue(byte paramByte) {
/*  538 */     ensureType(CellType.ERROR);
/*  539 */     if (this._value.getType() == CellType.FORMULA) {
/*  540 */       ((ErrorFormulaValue)this._value).setPreEvaluatedValue(paramByte);
/*      */     } else {
/*  542 */       ((ErrorValue)this._value).setValue(paramByte);
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
/*      */   public boolean getBooleanCellValue() {
/*      */     FormulaValue formulaValue;
/*  557 */     CellType cellType = getCellTypeEnum();
/*  558 */     switch (cellType) {
/*      */       
/*      */       case BLANK:
/*  561 */         return false;
/*      */       
/*      */       case FORMULA:
/*  564 */         formulaValue = (FormulaValue)this._value;
/*  565 */         if (formulaValue.getFormulaType() != CellType.BOOLEAN)
/*  566 */           throw typeMismatch(CellType.BOOLEAN, CellType.FORMULA, false); 
/*  567 */         return ((BooleanFormulaValue)this._value).getPreEvaluatedValue();
/*      */ 
/*      */       
/*      */       case BOOLEAN:
/*  571 */         return ((BooleanValue)this._value).getValue();
/*      */     } 
/*      */     
/*  574 */     throw typeMismatch(CellType.BOOLEAN, cellType, false);
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
/*      */   public byte getErrorCellValue() {
/*      */     FormulaValue formulaValue;
/*  592 */     CellType cellType = getCellTypeEnum();
/*  593 */     switch (cellType) {
/*      */       
/*      */       case BLANK:
/*  596 */         return 0;
/*      */       
/*      */       case FORMULA:
/*  599 */         formulaValue = (FormulaValue)this._value;
/*  600 */         if (formulaValue.getFormulaType() != CellType.ERROR)
/*  601 */           throw typeMismatch(CellType.ERROR, CellType.FORMULA, false); 
/*  602 */         return ((ErrorFormulaValue)this._value).getPreEvaluatedValue();
/*      */ 
/*      */       
/*      */       case ERROR:
/*  606 */         return ((ErrorValue)this._value).getValue();
/*      */     } 
/*      */     
/*  609 */     throw typeMismatch(CellType.ERROR, cellType, false);
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
/*      */   public void setCellStyle(CellStyle paramCellStyle) {
/*  627 */     this._style = paramCellStyle;
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
/*      */   public CellStyle getCellStyle() {
/*  640 */     if (this._style == null) {
/*  641 */       SXSSFWorkbook sXSSFWorkbook = (SXSSFWorkbook)getRow().getSheet().getWorkbook();
/*  642 */       return sXSSFWorkbook.getCellStyleAt(0);
/*      */     } 
/*  644 */     return this._style;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAsActiveCell() {
/*  654 */     getSheet().setActiveCell(getAddress());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCellComment(Comment paramComment) {
/*  665 */     setProperty(1, paramComment);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Comment getCellComment() {
/*  676 */     return (Comment)getPropertyValue(1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeCellComment() {
/*  685 */     removeProperty(1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Hyperlink getHyperlink() {
/*  694 */     return (Hyperlink)getPropertyValue(2);
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
/*      */   public void setHyperlink(Hyperlink paramHyperlink) {
/*  706 */     if (paramHyperlink == null) {
/*  707 */       removeHyperlink();
/*      */       
/*      */       return;
/*      */     } 
/*  711 */     setProperty(2, paramHyperlink);
/*      */     
/*  713 */     XSSFHyperlink xSSFHyperlink = (XSSFHyperlink)paramHyperlink;
/*      */     
/*  715 */     CellReference cellReference = new CellReference(getRowIndex(), getColumnIndex());
/*  716 */     xSSFHyperlink.getCTHyperlink().setRef(cellReference.formatAsString());
/*      */ 
/*      */     
/*  719 */     (getSheet())._sh.addHyperlink(xSSFHyperlink);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeHyperlink() {
/*  728 */     removeProperty(2);
/*      */     
/*  730 */     (getSheet())._sh.removeHyperlink(getRowIndex(), getColumnIndex());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public CellRangeAddress getArrayFormulaRange() {
/*  742 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public boolean isPartOfArrayFormulaGroup() {
/*  752 */     return false;
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
/*      */   public String toString() {
/*  766 */     switch (getCellTypeEnum()) {
/*      */       case BLANK:
/*  768 */         return "";
/*      */       case BOOLEAN:
/*  770 */         return getBooleanCellValue() ? "TRUE" : "FALSE";
/*      */       case ERROR:
/*  772 */         return ErrorEval.getText(getErrorCellValue());
/*      */       case FORMULA:
/*  774 */         return getCellFormula();
/*      */       case NUMERIC:
/*  776 */         if (DateUtil.isCellDateFormatted(this)) {
/*  777 */           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
/*  778 */           simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
/*  779 */           return simpleDateFormat.format(getDateCellValue());
/*      */         } 
/*  781 */         return getNumericCellValue() + "";
/*      */       case STRING:
/*  783 */         return getRichStringCellValue().toString();
/*      */     } 
/*  785 */     return "Unknown Cell Type: " + getCellTypeEnum();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void removeProperty(int paramInt) {
/*  791 */     Property property1 = this._firstProperty;
/*  792 */     Property property2 = null;
/*  793 */     while (property1 != null && property1.getType() != paramInt) {
/*      */       
/*  795 */       property2 = property1;
/*  796 */       property1 = property1._next;
/*      */     } 
/*  798 */     if (property1 != null)
/*      */     {
/*  800 */       if (property2 != null) {
/*      */         
/*  802 */         property2._next = property1._next;
/*      */       }
/*      */       else {
/*      */         
/*  806 */         this._firstProperty = property1._next;
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   void setProperty(int paramInt, Object paramObject) {
/*  812 */     Property property1 = this._firstProperty;
/*  813 */     Property property2 = null;
/*  814 */     while (property1 != null && property1.getType() != paramInt) {
/*      */       
/*  816 */       property2 = property1;
/*  817 */       property1 = property1._next;
/*      */     } 
/*  819 */     if (property1 != null) {
/*      */       
/*  821 */       property1.setValue(paramObject);
/*      */     }
/*      */     else {
/*      */       
/*  825 */       switch (paramInt) {
/*      */ 
/*      */         
/*      */         case 1:
/*  829 */           property1 = new CommentProperty(paramObject);
/*      */           break;
/*      */ 
/*      */         
/*      */         case 2:
/*  834 */           property1 = new HyperlinkProperty(paramObject);
/*      */           break;
/*      */ 
/*      */         
/*      */         default:
/*  839 */           throw new IllegalArgumentException("Invalid type: " + paramInt);
/*      */       } 
/*      */       
/*  842 */       if (property2 != null) {
/*      */         
/*  844 */         property2._next = property1;
/*      */       }
/*      */       else {
/*      */         
/*  848 */         this._firstProperty = property1;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   Object getPropertyValue(int paramInt) {
/*  854 */     return getPropertyValue(paramInt, null);
/*      */   }
/*      */   
/*      */   Object getPropertyValue(int paramInt, String paramString) {
/*  858 */     Property property = this._firstProperty;
/*  859 */     for (; property != null && property.getType() != paramInt; property = property._next);
/*  860 */     return (property == null) ? paramString : property.getValue();
/*      */   }
/*      */   
/*      */   void ensurePlainStringType() {
/*  864 */     if (this._value.getType() != CellType.STRING || ((StringValue)this._value).isRichText())
/*      */     {
/*  866 */       this._value = new PlainStringValue(); } 
/*      */   }
/*      */   
/*      */   void ensureRichTextStringType() {
/*  870 */     if (this._value.getType() != CellType.STRING || !((StringValue)this._value).isRichText())
/*      */     {
/*  872 */       this._value = new RichTextValue(); } 
/*      */   }
/*      */   
/*      */   void ensureType(CellType paramCellType) {
/*  876 */     if (this._value.getType() != paramCellType)
/*  877 */       setType(paramCellType); 
/*      */   }
/*      */   
/*      */   void ensureFormulaType(CellType paramCellType) {
/*  881 */     if (this._value.getType() != CellType.FORMULA || ((FormulaValue)this._value).getFormulaType() != paramCellType)
/*      */     {
/*  883 */       setFormulaType(paramCellType);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void ensureTypeOrFormulaType(CellType paramCellType) {
/*  890 */     if (this._value.getType() == paramCellType) {
/*      */       
/*  892 */       if (paramCellType == CellType.STRING && ((StringValue)this._value).isRichText())
/*  893 */         setType(CellType.STRING); 
/*      */       return;
/*      */     } 
/*  896 */     if (this._value.getType() == CellType.FORMULA) {
/*      */       
/*  898 */       if (((FormulaValue)this._value).getFormulaType() == paramCellType)
/*      */         return; 
/*  900 */       setFormulaType(paramCellType);
/*      */       return;
/*      */     } 
/*  903 */     setType(paramCellType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setType(CellType paramCellType) {
/*      */     PlainStringValue plainStringValue;
/*      */     BooleanValue booleanValue;
/*  914 */     switch (paramCellType) {
/*      */ 
/*      */       
/*      */       case NUMERIC:
/*  918 */         this._value = new NumericValue();
/*      */         return;
/*      */ 
/*      */       
/*      */       case STRING:
/*  923 */         plainStringValue = new PlainStringValue();
/*  924 */         if (this._value != null) {
/*      */           
/*  926 */           String str = convertCellValueToString();
/*  927 */           plainStringValue.setValue(str);
/*      */         } 
/*  929 */         this._value = plainStringValue;
/*      */         return;
/*      */ 
/*      */       
/*      */       case FORMULA:
/*  934 */         this._value = new NumericFormulaValue();
/*      */         return;
/*      */ 
/*      */       
/*      */       case BLANK:
/*  939 */         this._value = new BlankValue();
/*      */         return;
/*      */ 
/*      */       
/*      */       case BOOLEAN:
/*  944 */         booleanValue = new BooleanValue();
/*  945 */         if (this._value != null) {
/*      */           
/*  947 */           boolean bool = convertCellValueToBoolean();
/*  948 */           booleanValue.setValue(bool);
/*      */         } 
/*  950 */         this._value = booleanValue;
/*      */         return;
/*      */ 
/*      */       
/*      */       case ERROR:
/*  955 */         this._value = new ErrorValue();
/*      */         return;
/*      */     } 
/*      */ 
/*      */     
/*  960 */     throw new IllegalArgumentException("Illegal type " + paramCellType);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void setFormulaType(CellType paramCellType) {
/*  966 */     Value value = this._value;
/*  967 */     switch (paramCellType) {
/*      */ 
/*      */       
/*      */       case NUMERIC:
/*  971 */         this._value = new NumericFormulaValue();
/*      */         break;
/*      */ 
/*      */       
/*      */       case STRING:
/*  976 */         this._value = new StringFormulaValue();
/*      */         break;
/*      */ 
/*      */       
/*      */       case BOOLEAN:
/*  981 */         this._value = new BooleanFormulaValue();
/*      */         break;
/*      */ 
/*      */       
/*      */       case ERROR:
/*  986 */         this._value = new ErrorFormulaValue();
/*      */         break;
/*      */ 
/*      */       
/*      */       default:
/*  991 */         throw new IllegalArgumentException("Illegal type " + paramCellType);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  996 */     if (value instanceof FormulaValue) {
/*  997 */       ((FormulaValue)this._value)._value = ((FormulaValue)value)._value;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   CellType computeTypeFromFormula(String paramString) {
/* 1005 */     return CellType.NUMERIC;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static RuntimeException typeMismatch(CellType paramCellType1, CellType paramCellType2, boolean paramBoolean) {
/* 1012 */     String str = "Cannot get a " + paramCellType1 + " value from a " + paramCellType2 + " " + (paramBoolean ? "formula " : "") + "cell";
/*      */     
/* 1014 */     return new IllegalStateException(str);
/*      */   }
/*      */   private boolean convertCellValueToBoolean() {
/*      */     String str;
/* 1018 */     CellType cellType = getCellTypeEnum();
/*      */     
/* 1020 */     if (cellType == CellType.FORMULA) {
/* 1021 */       cellType = getCachedFormulaResultTypeEnum();
/*      */     }
/*      */     
/* 1024 */     switch (cellType) {
/*      */       case BOOLEAN:
/* 1026 */         return getBooleanCellValue();
/*      */       
/*      */       case STRING:
/* 1029 */         str = getStringCellValue();
/* 1030 */         return Boolean.parseBoolean(str);
/*      */       case NUMERIC:
/* 1032 */         return (getNumericCellValue() != 0.0D);
/*      */       case BLANK:
/*      */       case ERROR:
/* 1035 */         return false;
/* 1036 */     }  throw new RuntimeException("Unexpected cell type (" + cellType + ")");
/*      */   }
/*      */ 
/*      */   
/*      */   private String convertCellValueToString() {
/* 1041 */     CellType cellType = getCellTypeEnum();
/* 1042 */     return convertCellValueToString(cellType);
/*      */   } private String convertCellValueToString(CellType paramCellType) {
/*      */     byte b;
/* 1045 */     switch (paramCellType) {
/*      */       case BLANK:
/* 1047 */         return "";
/*      */       case BOOLEAN:
/* 1049 */         return getBooleanCellValue() ? "TRUE" : "FALSE";
/*      */       case STRING:
/* 1051 */         return getStringCellValue();
/*      */       case NUMERIC:
/* 1053 */         return Double.toString(getNumericCellValue());
/*      */       case ERROR:
/* 1055 */         b = getErrorCellValue();
/* 1056 */         return FormulaError.forInt(b).getString();
/*      */       case FORMULA:
/* 1058 */         if (this._value != null) {
/* 1059 */           FormulaValue formulaValue = (FormulaValue)this._value;
/* 1060 */           if (formulaValue.getFormulaType() != CellType.FORMULA) {
/* 1061 */             return convertCellValueToString(formulaValue.getFormulaType());
/*      */           }
/*      */         } 
/* 1064 */         return "";
/*      */     } 
/* 1066 */     throw new IllegalStateException("Unexpected cell type (" + paramCellType + ")");
/*      */   }
/*      */ 
/*      */   
/*      */   static abstract class Property
/*      */   {
/*      */     static final int COMMENT = 1;
/*      */     
/*      */     static final int HYPERLINK = 2;
/*      */     
/*      */     Object _value;
/*      */     Property _next;
/*      */     
/*      */     public Property(Object param1Object) {
/* 1080 */       this._value = param1Object;
/*      */     }
/*      */     abstract int getType();
/*      */     
/*      */     void setValue(Object param1Object) {
/* 1085 */       this._value = param1Object;
/*      */     }
/*      */     
/*      */     Object getValue() {
/* 1089 */       return this._value;
/*      */     }
/*      */   }
/*      */   
/*      */   static class CommentProperty
/*      */     extends Property {
/*      */     public CommentProperty(Object param1Object) {
/* 1096 */       super(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getType() {
/* 1101 */       return 1;
/*      */     }
/*      */   }
/*      */   
/*      */   static class HyperlinkProperty
/*      */     extends Property {
/*      */     public HyperlinkProperty(Object param1Object) {
/* 1108 */       super(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getType() {
/* 1113 */       return 2;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static class NumericValue
/*      */     implements Value
/*      */   {
/*      */     double _value;
/*      */ 
/*      */     
/*      */     public CellType getType() {
/* 1125 */       return CellType.NUMERIC;
/*      */     }
/*      */     
/*      */     void setValue(double param1Double) {
/* 1129 */       this._value = param1Double;
/*      */     }
/*      */     
/*      */     double getValue() {
/* 1133 */       return this._value;
/*      */     }
/*      */   }
/*      */   
/*      */   static abstract class StringValue
/*      */     implements Value {
/*      */     public CellType getType() {
/* 1140 */       return CellType.STRING;
/*      */     }
/*      */     
/*      */     abstract boolean isRichText();
/*      */   }
/*      */   
/*      */   static class PlainStringValue extends StringValue {
/*      */     String _value;
/*      */     
/*      */     void setValue(String param1String) {
/* 1150 */       this._value = param1String;
/*      */     }
/*      */     
/*      */     String getValue() {
/* 1154 */       return this._value;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean isRichText() {
/* 1159 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   static class RichTextValue
/*      */     extends StringValue {
/*      */     RichTextString _value;
/*      */     
/*      */     public CellType getType() {
/* 1168 */       return CellType.STRING;
/*      */     }
/*      */     
/*      */     void setValue(RichTextString param1RichTextString) {
/* 1172 */       this._value = param1RichTextString;
/*      */     }
/*      */     
/*      */     RichTextString getValue() {
/* 1176 */       return this._value;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean isRichText() {
/* 1181 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */   static abstract class FormulaValue implements Value {
/*      */     String _value;
/*      */     
/*      */     public CellType getType() {
/* 1189 */       return CellType.FORMULA;
/*      */     }
/*      */     
/*      */     void setValue(String param1String) {
/* 1193 */       this._value = param1String;
/*      */     }
/*      */     
/*      */     String getValue() {
/* 1197 */       return this._value;
/*      */     }
/*      */     
/*      */     abstract CellType getFormulaType();
/*      */   }
/*      */   
/*      */   static class NumericFormulaValue extends FormulaValue {
/*      */     double _preEvaluatedValue;
/*      */     
/*      */     CellType getFormulaType() {
/* 1207 */       return CellType.NUMERIC;
/*      */     }
/*      */     
/*      */     void setPreEvaluatedValue(double param1Double) {
/* 1211 */       this._preEvaluatedValue = param1Double;
/*      */     }
/*      */     
/*      */     double getPreEvaluatedValue() {
/* 1215 */       return this._preEvaluatedValue;
/*      */     }
/*      */   }
/*      */   
/*      */   static class StringFormulaValue
/*      */     extends FormulaValue {
/*      */     String _preEvaluatedValue;
/*      */     
/*      */     CellType getFormulaType() {
/* 1224 */       return CellType.STRING;
/*      */     }
/*      */     
/*      */     void setPreEvaluatedValue(String param1String) {
/* 1228 */       this._preEvaluatedValue = param1String;
/*      */     }
/*      */     
/*      */     String getPreEvaluatedValue() {
/* 1232 */       return this._preEvaluatedValue;
/*      */     }
/*      */   }
/*      */   
/*      */   static class BooleanFormulaValue
/*      */     extends FormulaValue {
/*      */     boolean _preEvaluatedValue;
/*      */     
/*      */     CellType getFormulaType() {
/* 1241 */       return CellType.BOOLEAN;
/*      */     }
/*      */     
/*      */     void setPreEvaluatedValue(boolean param1Boolean) {
/* 1245 */       this._preEvaluatedValue = param1Boolean;
/*      */     }
/*      */     
/*      */     boolean getPreEvaluatedValue() {
/* 1249 */       return this._preEvaluatedValue;
/*      */     }
/*      */   }
/*      */   
/*      */   static class ErrorFormulaValue
/*      */     extends FormulaValue {
/*      */     byte _preEvaluatedValue;
/*      */     
/*      */     CellType getFormulaType() {
/* 1258 */       return CellType.ERROR;
/*      */     }
/*      */     
/*      */     void setPreEvaluatedValue(byte param1Byte) {
/* 1262 */       this._preEvaluatedValue = param1Byte;
/*      */     }
/*      */     
/*      */     byte getPreEvaluatedValue() {
/* 1266 */       return this._preEvaluatedValue;
/*      */     }
/*      */   }
/*      */   
/*      */   static class BlankValue
/*      */     implements Value {
/*      */     public CellType getType() {
/* 1273 */       return CellType.BLANK;
/*      */     }
/*      */   }
/*      */   
/*      */   static class BooleanValue implements Value {
/*      */     boolean _value;
/*      */     
/*      */     public CellType getType() {
/* 1281 */       return CellType.BOOLEAN;
/*      */     }
/*      */     
/*      */     void setValue(boolean param1Boolean) {
/* 1285 */       this._value = param1Boolean;
/*      */     }
/*      */     
/*      */     boolean getValue() {
/* 1289 */       return this._value;
/*      */     }
/*      */   }
/*      */   
/*      */   static class ErrorValue implements Value {
/*      */     byte _value;
/*      */     
/*      */     public CellType getType() {
/* 1297 */       return CellType.ERROR;
/*      */     }
/*      */     
/*      */     void setValue(byte param1Byte) {
/* 1301 */       this._value = param1Byte;
/*      */     }
/*      */     
/*      */     byte getValue() {
/* 1305 */       return this._value;
/*      */     }
/*      */   }
/*      */   
/*      */   static interface Value {
/*      */     CellType getType();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\streaming\SXSSFCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */