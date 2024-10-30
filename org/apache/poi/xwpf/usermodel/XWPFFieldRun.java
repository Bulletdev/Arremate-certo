/*    */ package org.apache.poi.xwpf.usermodel;
/*    */ 
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
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
/*    */ public class XWPFFieldRun
/*    */   extends XWPFRun
/*    */ {
/*    */   private CTSimpleField field;
/*    */   
/*    */   public XWPFFieldRun(CTSimpleField paramCTSimpleField, CTR paramCTR, IRunBody paramIRunBody) {
/* 32 */     super(paramCTR, paramIRunBody);
/* 33 */     this.field = paramCTSimpleField;
/*    */   }
/*    */   
/*    */   @Internal
/*    */   public CTSimpleField getCTField() {
/* 38 */     return this.field;
/*    */   }
/*    */   
/*    */   public String getFieldInstruction() {
/* 42 */     return this.field.getInstr();
/*    */   }
/*    */   
/*    */   public void setFieldInstruction(String paramString) {
/* 46 */     this.field.setInstr(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFFieldRun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */