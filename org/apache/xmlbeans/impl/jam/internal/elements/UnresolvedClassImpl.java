/*    */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*    */ 
/*    */ import org.apache.xmlbeans.impl.jam.JClass;
/*    */ import org.apache.xmlbeans.impl.jam.JPackage;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class UnresolvedClassImpl
/*    */   extends BuiltinClassImpl
/*    */ {
/*    */   private String mPackageName;
/*    */   
/*    */   public UnresolvedClassImpl(String paramString1, String paramString2, ElementContext paramElementContext) {
/* 40 */     super(paramElementContext);
/* 41 */     if (paramString1 == null) throw new IllegalArgumentException("null pkg"); 
/* 42 */     this.mPackageName = paramString1;
/* 43 */     reallySetSimpleName(paramString2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getQualifiedName() {
/* 50 */     return ((this.mPackageName.length() > 0) ? (this.mPackageName + '.') : "") + this.mSimpleName;
/*    */   }
/*    */   
/*    */   public String getFieldDescriptor() {
/* 54 */     return getQualifiedName();
/*    */   } public JPackage getContainingPackage() {
/* 56 */     return null;
/*    */   } public boolean isAssignableFrom(JClass paramJClass) {
/* 58 */     return false;
/*    */   } public boolean isUnresolvedType() {
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\UnresolvedClassImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */