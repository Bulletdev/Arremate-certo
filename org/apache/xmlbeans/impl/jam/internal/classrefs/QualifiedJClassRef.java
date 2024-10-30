/*    */ package org.apache.xmlbeans.impl.jam.internal.classrefs;
/*    */ 
/*    */ import org.apache.xmlbeans.impl.jam.JClass;
/*    */ import org.apache.xmlbeans.impl.jam.JamClassLoader;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QualifiedJClassRef
/*    */   implements JClassRef
/*    */ {
/*    */   private String mQualifiedClassname;
/*    */   private JamClassLoader mClassLoader;
/*    */   
/*    */   public static JClassRef create(JClass paramJClass) {
/* 44 */     if (paramJClass == null) throw new IllegalArgumentException("null clazz"); 
/* 45 */     return new QualifiedJClassRef(paramJClass.getFieldDescriptor(), paramJClass.getClassLoader());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static JClassRef create(String paramString, JClassRefContext paramJClassRefContext) {
/* 54 */     if (paramString == null) throw new IllegalArgumentException("null qcname"); 
/* 55 */     if (paramJClassRefContext == null) throw new IllegalArgumentException("null ctx"); 
/* 56 */     return create(paramString, paramJClassRefContext.getClassLoader());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static JClassRef create(String paramString, JamClassLoader paramJamClassLoader) {
/* 63 */     if (paramString == null) throw new IllegalArgumentException("null qcname"); 
/* 64 */     if (paramJamClassLoader == null) throw new IllegalArgumentException("null classloader"); 
/* 65 */     return new QualifiedJClassRef(paramString, paramJamClassLoader);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private QualifiedJClassRef(String paramString, JamClassLoader paramJamClassLoader) {
/* 72 */     this.mClassLoader = paramJamClassLoader;
/* 73 */     this.mQualifiedClassname = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JClass getRefClass() {
/* 80 */     return this.mClassLoader.loadClass(this.mQualifiedClassname);
/*    */   }
/*    */   
/*    */   public String getQualifiedName() {
/* 84 */     return this.mQualifiedClassname;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 91 */     return "(QualifiedJClassRef '" + this.mQualifiedClassname + "')";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\classrefs\QualifiedJClassRef.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */