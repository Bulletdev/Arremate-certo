/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
/*    */ import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
/*    */ import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;
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
/*    */ 
/*    */ 
/*    */ public class DrawingTextPlaceholder
/*    */   extends DrawingTextBody
/*    */ {
/*    */   private final CTPlaceholder placeholder;
/*    */   
/*    */   public DrawingTextPlaceholder(CTTextBody paramCTTextBody, CTPlaceholder paramCTPlaceholder) {
/* 33 */     super(paramCTTextBody);
/* 34 */     this.placeholder = paramCTPlaceholder;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getPlaceholderType() {
/* 41 */     return this.placeholder.getType().toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public STPlaceholderType.Enum getPlaceholderTypeEnum() {
/* 48 */     return this.placeholder.getType();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isPlaceholderCustom() {
/* 55 */     return this.placeholder.getHasCustomPrompt();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\DrawingTextPlaceholder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */