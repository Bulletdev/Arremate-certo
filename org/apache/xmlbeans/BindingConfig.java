/*    */ package org.apache.xmlbeans;
/*    */ 
/*    */ import javax.xml.namespace.b;
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
/*    */ 
/*    */ public class BindingConfig
/*    */ {
/* 28 */   private static final InterfaceExtension[] EMPTY_INTERFACE_EXT_ARRAY = new InterfaceExtension[0];
/* 29 */   private static final PrePostExtension[] EMPTY_PREPOST_EXT_ARRAY = new PrePostExtension[0];
/* 30 */   private static final UserType[] EMPTY_USER_TYPE_ARRY = new UserType[0];
/*    */   
/*    */   public static final int QNAME_TYPE = 1;
/*    */   
/*    */   public static final int QNAME_DOCUMENT_TYPE = 2;
/*    */   
/*    */   public static final int QNAME_ACCESSOR_ELEMENT = 3;
/*    */   public static final int QNAME_ACCESSOR_ATTRIBUTE = 4;
/*    */   
/*    */   public String lookupPackageForNamespace(String paramString) {
/* 40 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public String lookupPrefixForNamespace(String paramString) {
/* 45 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public String lookupSuffixForNamespace(String paramString) {
/* 50 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String lookupJavanameForQName(b paramb) {
/* 56 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String lookupJavanameForQName(b paramb, int paramInt) {
/* 65 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public InterfaceExtension[] getInterfaceExtensions() {
/* 70 */     return EMPTY_INTERFACE_EXT_ARRAY;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public InterfaceExtension[] getInterfaceExtensions(String paramString) {
/* 76 */     return EMPTY_INTERFACE_EXT_ARRAY;
/*    */   }
/*    */ 
/*    */   
/*    */   public PrePostExtension[] getPrePostExtensions() {
/* 81 */     return EMPTY_PREPOST_EXT_ARRAY;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PrePostExtension getPrePostExtension(String paramString) {
/* 87 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public UserType[] getUserTypes() {
/* 92 */     return EMPTY_USER_TYPE_ARRY;
/*    */   }
/*    */ 
/*    */   
/*    */   public UserType lookupUserTypeForQName(b paramb) {
/* 97 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\BindingConfig.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */