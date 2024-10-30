/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlNCName;
/*    */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*    */ import org.apache.xmlbeans.impl.common.XMLChar;
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
/*    */ public class XmlNCNameImpl
/*    */   extends JavaStringHolderEx
/*    */   implements XmlNCName
/*    */ {
/*    */   public XmlNCNameImpl() {
/* 27 */     super(XmlNCName.type, false);
/*    */   } public XmlNCNameImpl(SchemaType paramSchemaType, boolean paramBoolean) {
/* 29 */     super(paramSchemaType, paramBoolean);
/*    */   }
/*    */   
/*    */   public static void validateLexical(String paramString, ValidationContext paramValidationContext) {
/* 33 */     if (!XMLChar.isValidNCName(paramString)) {
/*    */       
/* 35 */       paramValidationContext.invalid("NCName", new Object[] { paramString });
/*    */       return;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\XmlNCNameImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */