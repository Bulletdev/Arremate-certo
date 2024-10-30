/*    */ package org.apache.poi.xdgf.usermodel.section;
/*    */ 
/*    */ import com.microsoft.schemas.office.visio.x2012.main.SectionType;
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
/*    */ public class GenericSection
/*    */   extends XDGFSection
/*    */ {
/*    */   public GenericSection(SectionType paramSectionType, XDGFSheet paramXDGFSheet) {
/* 27 */     super(paramSectionType, paramXDGFSheet);
/*    */   }
/*    */   
/*    */   public void setupMaster(XDGFSection paramXDGFSection) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\GenericSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */