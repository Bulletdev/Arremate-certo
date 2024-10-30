/*    */ package org.apache.poi.xdgf.usermodel.section;
/*    */ 
/*    */ import com.microsoft.schemas.office.visio.x2012.main.CellType;
/*    */ import com.microsoft.schemas.office.visio.x2012.main.RowType;
/*    */ import com.microsoft.schemas.office.visio.x2012.main.SectionType;
/*    */ import java.awt.Color;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFCell;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFSheet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CharacterSection
/*    */   extends XDGFSection
/*    */ {
/* 33 */   Double _fontSize = null;
/* 34 */   Color _fontColor = null;
/*    */   
/* 36 */   Map<String, XDGFCell> _characterCells = new HashMap<String, XDGFCell>();
/*    */   
/*    */   public CharacterSection(SectionType paramSectionType, XDGFSheet paramXDGFSheet) {
/* 39 */     super(paramSectionType, paramXDGFSheet);
/*    */ 
/*    */     
/* 42 */     RowType rowType = paramSectionType.getRowArray(0);
/*    */     
/* 44 */     for (CellType cellType : rowType.getCellArray()) {
/* 45 */       this._characterCells.put(cellType.getN(), new XDGFCell(cellType));
/*    */     }
/*    */     
/* 48 */     this._fontSize = XDGFCell.maybeGetDouble(this._characterCells, "Size");
/*    */     
/* 50 */     String str = XDGFCell.maybeGetString(this._characterCells, "Color");
/* 51 */     if (str != null)
/* 52 */       this._fontColor = Color.decode(str); 
/*    */   }
/*    */   
/*    */   public Double getFontSize() {
/* 56 */     return this._fontSize;
/*    */   }
/*    */   
/*    */   public Color getFontColor() {
/* 60 */     return this._fontColor;
/*    */   }
/*    */   
/*    */   public void setupMaster(XDGFSection paramXDGFSection) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\CharacterSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */