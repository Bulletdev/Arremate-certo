/*     */ package org.apache.poi.xssf.usermodel.helpers;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.ss.formula.FormulaParseException;
/*     */ import org.apache.poi.ss.formula.FormulaParser;
/*     */ import org.apache.poi.ss.formula.FormulaParsingWorkbook;
/*     */ import org.apache.poi.ss.formula.FormulaRenderer;
/*     */ import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
/*     */ import org.apache.poi.ss.formula.FormulaShifter;
/*     */ import org.apache.poi.ss.formula.FormulaType;
/*     */ import org.apache.poi.ss.formula.ptg.AreaPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.Hyperlink;
/*     */ import org.apache.poi.ss.usermodel.Name;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.usermodel.Workbook;
/*     */ import org.apache.poi.ss.usermodel.helpers.RowShifter;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCell;
/*     */ import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
/*     */ import org.apache.poi.xssf.usermodel.XSSFHyperlink;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRow;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
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
/*     */ public final class XSSFRowShifter
/*     */   extends RowShifter
/*     */ {
/*  61 */   private static final POILogger logger = POILogFactory.getLogger(XSSFRowShifter.class);
/*     */   
/*     */   public XSSFRowShifter(XSSFSheet paramXSSFSheet) {
/*  64 */     super((Sheet)paramXSSFSheet);
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
/*     */   public List<CellRangeAddress> shiftMerged(int paramInt1, int paramInt2, int paramInt3) {
/*  77 */     return shiftMergedRegions(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateNamedRanges(FormulaShifter paramFormulaShifter) {
/*  84 */     Workbook workbook = this.sheet.getWorkbook();
/*  85 */     XSSFEvaluationWorkbook xSSFEvaluationWorkbook = XSSFEvaluationWorkbook.create((XSSFWorkbook)workbook);
/*  86 */     for (Name name : workbook.getAllNames()) {
/*  87 */       String str = name.getRefersToFormula();
/*  88 */       int i = name.getSheetIndex();
/*  89 */       byte b = -1;
/*     */       
/*  91 */       Ptg[] arrayOfPtg = FormulaParser.parse(str, (FormulaParsingWorkbook)xSSFEvaluationWorkbook, FormulaType.NAMEDRANGE, i, -1);
/*  92 */       if (paramFormulaShifter.adjustFormula(arrayOfPtg, i)) {
/*  93 */         String str1 = FormulaRenderer.toFormulaString((FormulaRenderingWorkbook)xSSFEvaluationWorkbook, arrayOfPtg);
/*  94 */         name.setRefersToFormula(str1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateFormulas(FormulaShifter paramFormulaShifter) {
/* 104 */     updateSheetFormulas(this.sheet, paramFormulaShifter);
/*     */ 
/*     */     
/* 107 */     Workbook workbook = this.sheet.getWorkbook();
/* 108 */     for (Sheet sheet : workbook) {
/* 109 */       if (this.sheet == sheet)
/* 110 */         continue;  updateSheetFormulas(sheet, paramFormulaShifter);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void updateSheetFormulas(Sheet paramSheet, FormulaShifter paramFormulaShifter) {
/* 115 */     for (Row row : paramSheet) {
/* 116 */       XSSFRow xSSFRow = (XSSFRow)row;
/* 117 */       updateRowFormulas((Row)xSSFRow, paramFormulaShifter);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public void updateRowFormulas(Row paramRow, FormulaShifter paramFormulaShifter) {
/* 129 */     XSSFSheet xSSFSheet = (XSSFSheet)paramRow.getSheet();
/* 130 */     for (Cell cell : paramRow) {
/* 131 */       XSSFCell xSSFCell = (XSSFCell)cell;
/*     */       
/* 133 */       CTCell cTCell = xSSFCell.getCTCell();
/* 134 */       if (cTCell.isSetF()) {
/* 135 */         CTCellFormula cTCellFormula = cTCell.getF();
/* 136 */         String str = cTCellFormula.getStringValue();
/* 137 */         if (str.length() > 0) {
/* 138 */           String str1 = shiftFormula(paramRow, str, paramFormulaShifter);
/* 139 */           if (str1 != null) {
/* 140 */             cTCellFormula.setStringValue(str1);
/* 141 */             if (cTCellFormula.getT() == STCellFormulaType.SHARED) {
/* 142 */               int i = (int)cTCellFormula.getSi();
/* 143 */               CTCellFormula cTCellFormula1 = xSSFSheet.getSharedFormula(i);
/* 144 */               cTCellFormula1.setStringValue(str1);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 150 */         if (cTCellFormula.isSetRef()) {
/* 151 */           String str1 = cTCellFormula.getRef();
/* 152 */           String str2 = shiftFormula(paramRow, str1, paramFormulaShifter);
/* 153 */           if (str2 != null) cTCellFormula.setRef(str2);
/*     */         
/*     */         } 
/*     */       } 
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
/*     */   private static String shiftFormula(Row paramRow, String paramString, FormulaShifter paramFormulaShifter) {
/* 170 */     Sheet sheet = paramRow.getSheet();
/* 171 */     Workbook workbook = sheet.getWorkbook();
/* 172 */     int i = workbook.getSheetIndex(sheet);
/* 173 */     int j = paramRow.getRowNum();
/* 174 */     XSSFEvaluationWorkbook xSSFEvaluationWorkbook = XSSFEvaluationWorkbook.create((XSSFWorkbook)workbook);
/*     */     
/*     */     try {
/* 177 */       Ptg[] arrayOfPtg = FormulaParser.parse(paramString, (FormulaParsingWorkbook)xSSFEvaluationWorkbook, FormulaType.CELL, i, j);
/* 178 */       String str = null;
/* 179 */       if (paramFormulaShifter.adjustFormula(arrayOfPtg, i)) {
/* 180 */         str = FormulaRenderer.toFormulaString((FormulaRenderingWorkbook)xSSFEvaluationWorkbook, arrayOfPtg);
/*     */       }
/* 182 */       return str;
/* 183 */     } catch (FormulaParseException formulaParseException) {
/*     */       
/* 185 */       logger.log(5, new Object[] { "Error shifting formula on row ", Integer.valueOf(paramRow.getRowNum()), formulaParseException });
/* 186 */       return paramString;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateConditionalFormatting(FormulaShifter paramFormulaShifter) {
/* 191 */     XSSFSheet xSSFSheet = (XSSFSheet)this.sheet;
/* 192 */     XSSFWorkbook xSSFWorkbook = xSSFSheet.getWorkbook();
/* 193 */     int i = xSSFWorkbook.getSheetIndex(this.sheet);
/* 194 */     byte b = -1;
/*     */     
/* 196 */     XSSFEvaluationWorkbook xSSFEvaluationWorkbook = XSSFEvaluationWorkbook.create(xSSFWorkbook);
/* 197 */     CTWorksheet cTWorksheet = xSSFSheet.getCTWorksheet();
/* 198 */     CTConditionalFormatting[] arrayOfCTConditionalFormatting = cTWorksheet.getConditionalFormattingArray();
/*     */     
/* 200 */     int j = arrayOfCTConditionalFormatting.length - 1; while (true) { CTConditionalFormatting cTConditionalFormatting; if (j >= 0)
/* 201 */       { cTConditionalFormatting = arrayOfCTConditionalFormatting[j];
/*     */         
/* 203 */         ArrayList<CellRangeAddress> arrayList1 = new ArrayList();
/* 204 */         for (Object object : cTConditionalFormatting.getSqref()) {
/* 205 */           String[] arrayOfString = object.toString().split(" ");
/* 206 */           for (String str : arrayOfString) {
/* 207 */             arrayList1.add(CellRangeAddress.valueOf(str));
/*     */           }
/*     */         } 
/*     */         
/* 211 */         boolean bool1 = false;
/* 212 */         ArrayList<CellRangeAddress> arrayList2 = new ArrayList();
/* 213 */         for (CellRangeAddress cellRangeAddress1 : arrayList1) {
/* 214 */           CellRangeAddress cellRangeAddress2 = shiftRange(paramFormulaShifter, cellRangeAddress1, i);
/* 215 */           if (cellRangeAddress2 == null) {
/* 216 */             bool1 = true;
/*     */             continue;
/*     */           } 
/* 219 */           arrayList2.add(cellRangeAddress2);
/* 220 */           if (cellRangeAddress2 != cellRangeAddress1) {
/* 221 */             bool1 = true;
/*     */           }
/*     */         } 
/*     */         
/* 225 */         if (bool1)
/* 226 */         { int m = arrayList2.size();
/* 227 */           if (m == 0)
/* 228 */           { cTWorksheet.removeConditionalFormatting(j); }
/*     */           else
/*     */           
/* 231 */           { ArrayList<String> arrayList = new ArrayList();
/* 232 */             for (CellRangeAddress cellRangeAddress : arrayList2) arrayList.add(cellRangeAddress.formatAsString()); 
/* 233 */             cTConditionalFormatting.setSqref(arrayList);
/*     */ 
/*     */             
/* 236 */             CTCfRule[] arrayOfCTCfRule1 = cTConditionalFormatting.getCfRuleArray(); int n = arrayOfCTCfRule1.length; boolean bool2 = false; }  continue; }  } else { break; }  CTCfRule[] arrayOfCTCfRule = cTConditionalFormatting.getCfRuleArray(); int k = arrayOfCTCfRule.length; boolean bool = false;
/*     */       j--; }
/*     */   
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateHyperlinks(FormulaShifter paramFormulaShifter) {
/* 258 */     int i = this.sheet.getWorkbook().getSheetIndex(this.sheet);
/* 259 */     List list = this.sheet.getHyperlinkList();
/*     */     
/* 261 */     for (Hyperlink hyperlink : list) {
/* 262 */       XSSFHyperlink xSSFHyperlink = (XSSFHyperlink)hyperlink;
/* 263 */       String str = xSSFHyperlink.getCellRef();
/* 264 */       CellRangeAddress cellRangeAddress1 = CellRangeAddress.valueOf(str);
/* 265 */       CellRangeAddress cellRangeAddress2 = shiftRange(paramFormulaShifter, cellRangeAddress1, i);
/* 266 */       if (cellRangeAddress2 != null && cellRangeAddress2 != cellRangeAddress1)
/*     */       {
/*     */ 
/*     */         
/* 270 */         xSSFHyperlink.setCellReference(cellRangeAddress2.formatAsString());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static CellRangeAddress shiftRange(FormulaShifter paramFormulaShifter, CellRangeAddress paramCellRangeAddress, int paramInt) {
/* 277 */     AreaPtg areaPtg = new AreaPtg(paramCellRangeAddress.getFirstRow(), paramCellRangeAddress.getLastRow(), paramCellRangeAddress.getFirstColumn(), paramCellRangeAddress.getLastColumn(), false, false, false, false);
/* 278 */     Ptg[] arrayOfPtg = { (Ptg)areaPtg };
/*     */     
/* 280 */     if (!paramFormulaShifter.adjustFormula(arrayOfPtg, paramInt)) {
/* 281 */       return paramCellRangeAddress;
/*     */     }
/* 283 */     Ptg ptg = arrayOfPtg[0];
/* 284 */     if (ptg instanceof AreaPtg) {
/* 285 */       AreaPtg areaPtg1 = (AreaPtg)ptg;
/* 286 */       return new CellRangeAddress(areaPtg1.getFirstRow(), areaPtg1.getLastRow(), areaPtg1.getFirstColumn(), areaPtg1.getLastColumn());
/*     */     } 
/* 288 */     if (ptg instanceof org.apache.poi.ss.formula.ptg.AreaErrPtg) {
/* 289 */       return null;
/*     */     }
/* 291 */     throw new IllegalStateException("Unexpected shifted ptg class (" + ptg.getClass().getName() + ")");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\helpers\XSSFRowShifter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */