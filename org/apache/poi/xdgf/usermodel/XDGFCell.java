/*     */ package org.apache.poi.xdgf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.CellType;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.util.Internal;
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
/*     */ public class XDGFCell
/*     */ {
/*     */   CellType _cell;
/*     */   
/*     */   public static Boolean maybeGetBoolean(Map<String, XDGFCell> paramMap, String paramString) {
/*  43 */     XDGFCell xDGFCell = paramMap.get(paramString);
/*  44 */     if (xDGFCell == null) {
/*  45 */       return null;
/*     */     }
/*  47 */     if (xDGFCell.getValue().equals("0"))
/*  48 */       return Boolean.valueOf(false); 
/*  49 */     if (xDGFCell.getValue().equals("1")) {
/*  50 */       return Boolean.valueOf(true);
/*     */     }
/*  52 */     throw new POIXMLException("Invalid boolean value for '" + xDGFCell.getName() + "'");
/*     */   }
/*     */ 
/*     */   
/*     */   public static Double maybeGetDouble(Map<String, XDGFCell> paramMap, String paramString) {
/*  57 */     XDGFCell xDGFCell = paramMap.get(paramString);
/*  58 */     if (xDGFCell != null)
/*  59 */       return parseDoubleValue(xDGFCell._cell); 
/*  60 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Integer maybeGetInteger(Map<String, XDGFCell> paramMap, String paramString) {
/*  65 */     XDGFCell xDGFCell = paramMap.get(paramString);
/*  66 */     if (xDGFCell != null)
/*  67 */       return parseIntegerValue(xDGFCell._cell); 
/*  68 */     return null;
/*     */   }
/*     */   
/*     */   public static String maybeGetString(Map<String, XDGFCell> paramMap, String paramString) {
/*  72 */     XDGFCell xDGFCell = paramMap.get(paramString);
/*  73 */     if (xDGFCell != null) {
/*  74 */       String str = xDGFCell._cell.getV();
/*  75 */       if (str.equals("Themed"))
/*  76 */         return null; 
/*  77 */       return str;
/*     */     } 
/*  79 */     return null;
/*     */   }
/*     */   
/*     */   public static Double parseDoubleValue(CellType paramCellType) {
/*     */     try {
/*  84 */       return Double.valueOf(Double.parseDouble(paramCellType.getV()));
/*  85 */     } catch (NumberFormatException numberFormatException) {
/*  86 */       if (paramCellType.getV().equals("Themed"))
/*  87 */         return null; 
/*  88 */       throw new POIXMLException("Invalid float value for '" + paramCellType.getN() + "': " + numberFormatException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Integer parseIntegerValue(CellType paramCellType) {
/*     */     try {
/*  95 */       return Integer.valueOf(Integer.parseInt(paramCellType.getV()));
/*  96 */     } catch (NumberFormatException numberFormatException) {
/*  97 */       if (paramCellType.getV().equals("Themed"))
/*  98 */         return null; 
/*  99 */       throw new POIXMLException("Invalid integer value for '" + paramCellType.getN() + "': " + numberFormatException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Double parseVLength(CellType paramCellType) {
/*     */     try {
/* 110 */       return Double.valueOf(Double.parseDouble(paramCellType.getV()));
/* 111 */     } catch (NumberFormatException numberFormatException) {
/* 112 */       if (paramCellType.getV().equals("Themed"))
/* 113 */         return null; 
/* 114 */       throw new POIXMLException("Invalid float value for '" + paramCellType.getN() + "': " + numberFormatException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XDGFCell(CellType paramCellType) {
/* 122 */     this._cell = paramCellType;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   protected CellType getXmlObject() {
/* 127 */     return this._cell;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 134 */     return this._cell.getN();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValue() {
/* 141 */     return this._cell.getV();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormula() {
/* 151 */     return this._cell.getF();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getError() {
/* 160 */     return this._cell.getE();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */