/*     */ package org.apache.poi.ss.usermodel;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.util.Removal;
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
/*     */ public interface Row
/*     */   extends Iterable<Cell>
/*     */ {
/*     */   public enum MissingCellPolicy
/*     */   {
/* 240 */     RETURN_NULL_AND_BLANK(1),
/* 241 */     RETURN_BLANK_AS_NULL(2),
/* 242 */     CREATE_NULL_AS_BLANK(3);
/*     */ 
/*     */     
/*     */     @Removal(version = "3.17")
/*     */     @Deprecated
/*     */     public final int id;
/*     */ 
/*     */ 
/*     */     
/*     */     MissingCellPolicy(int param1Int1) {
/* 252 */       this.id = param1Int1;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Removal(version = "3.17")
/*     */   @Deprecated
/* 263 */   public static final MissingCellPolicy RETURN_NULL_AND_BLANK = MissingCellPolicy.RETURN_NULL_AND_BLANK;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Removal(version = "3.17")
/*     */   @Deprecated
/* 271 */   public static final MissingCellPolicy RETURN_BLANK_AS_NULL = MissingCellPolicy.RETURN_BLANK_AS_NULL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Removal(version = "3.17")
/*     */   @Deprecated
/* 279 */   public static final MissingCellPolicy CREATE_NULL_AS_BLANK = MissingCellPolicy.CREATE_NULL_AS_BLANK;
/*     */   
/*     */   Cell createCell(int paramInt);
/*     */   
/*     */   Cell createCell(int paramInt1, int paramInt2);
/*     */   
/*     */   Cell createCell(int paramInt, CellType paramCellType);
/*     */   
/*     */   void removeCell(Cell paramCell);
/*     */   
/*     */   void setRowNum(int paramInt);
/*     */   
/*     */   int getRowNum();
/*     */   
/*     */   Cell getCell(int paramInt);
/*     */   
/*     */   Cell getCell(int paramInt, MissingCellPolicy paramMissingCellPolicy);
/*     */   
/*     */   short getFirstCellNum();
/*     */   
/*     */   short getLastCellNum();
/*     */   
/*     */   int getPhysicalNumberOfCells();
/*     */   
/*     */   void setHeight(short paramShort);
/*     */   
/*     */   void setZeroHeight(boolean paramBoolean);
/*     */   
/*     */   boolean getZeroHeight();
/*     */   
/*     */   void setHeightInPoints(float paramFloat);
/*     */   
/*     */   short getHeight();
/*     */   
/*     */   float getHeightInPoints();
/*     */   
/*     */   boolean isFormatted();
/*     */   
/*     */   CellStyle getRowStyle();
/*     */   
/*     */   void setRowStyle(CellStyle paramCellStyle);
/*     */   
/*     */   Iterator<Cell> cellIterator();
/*     */   
/*     */   Sheet getSheet();
/*     */   
/*     */   int getOutlineLevel();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Row.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */