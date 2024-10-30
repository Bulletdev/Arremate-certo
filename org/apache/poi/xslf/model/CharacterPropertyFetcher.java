/*    */ package org.apache.poi.xslf.model;
/*    */ 
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
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
/*    */ public abstract class CharacterPropertyFetcher<T>
/*    */   extends ParagraphPropertyFetcher<T>
/*    */ {
/*    */   public CharacterPropertyFetcher(int paramInt) {
/* 27 */     super(paramInt);
/*    */   }
/*    */   
/*    */   public boolean fetch(CTTextParagraphProperties paramCTTextParagraphProperties) {
/* 31 */     if (paramCTTextParagraphProperties != null && paramCTTextParagraphProperties.isSetDefRPr()) {
/* 32 */       return fetch(paramCTTextParagraphProperties.getDefRPr());
/*    */     }
/*    */     
/* 35 */     return false;
/*    */   }
/*    */   
/*    */   public abstract boolean fetch(CTTextCharacterProperties paramCTTextCharacterProperties);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xslf\model\CharacterPropertyFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */