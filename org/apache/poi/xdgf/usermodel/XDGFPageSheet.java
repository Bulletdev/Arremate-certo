/*    */ package org.apache.poi.xdgf.usermodel;
/*    */ 
/*    */ import com.microsoft.schemas.office.visio.x2012.main.PageSheetType;
/*    */ import com.microsoft.schemas.office.visio.x2012.main.SheetType;
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
/*    */ public class XDGFPageSheet
/*    */   extends XDGFSheet
/*    */ {
/*    */   PageSheetType _pageSheet;
/*    */   
/*    */   public XDGFPageSheet(PageSheetType paramPageSheetType, XDGFDocument paramXDGFDocument) {
/* 27 */     super((SheetType)paramPageSheetType, paramXDGFDocument);
/* 28 */     this._pageSheet = paramPageSheetType;
/*    */   }
/*    */ 
/*    */   
/*    */   PageSheetType getXmlObject() {
/* 33 */     return this._pageSheet;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFPageSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */