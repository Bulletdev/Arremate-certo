/*    */ package org.apache.poi.xdgf.usermodel;
/*    */ 
/*    */ import com.microsoft.schemas.office.visio.x2012.main.SheetType;
/*    */ import com.microsoft.schemas.office.visio.x2012.main.StyleSheetType;
/*    */ import org.apache.poi.util.Internal;
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
/*    */ public class XDGFStyleSheet
/*    */   extends XDGFSheet
/*    */ {
/*    */   public XDGFStyleSheet(StyleSheetType paramStyleSheetType, XDGFDocument paramXDGFDocument) {
/* 27 */     super((SheetType)paramStyleSheetType, paramXDGFDocument);
/*    */   }
/*    */ 
/*    */   
/*    */   @Internal
/*    */   public StyleSheetType getXmlObject() {
/* 33 */     return (StyleSheetType)this._sheet;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFStyleSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */