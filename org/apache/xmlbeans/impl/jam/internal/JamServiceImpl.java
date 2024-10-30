/*    */ package org.apache.xmlbeans.impl.jam.internal;
/*    */ 
/*    */ import org.apache.xmlbeans.impl.jam.JClass;
/*    */ import org.apache.xmlbeans.impl.jam.JamClassIterator;
/*    */ import org.apache.xmlbeans.impl.jam.JamClassLoader;
/*    */ import org.apache.xmlbeans.impl.jam.JamService;
/*    */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
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
/*    */ public class JamServiceImpl
/*    */   implements JamService
/*    */ {
/*    */   private ElementContext mContext;
/*    */   private String[] mClassNames;
/*    */   
/*    */   public JamServiceImpl(ElementContext paramElementContext, String[] paramArrayOfString) {
/* 41 */     if (paramElementContext == null) throw new IllegalArgumentException("null jcl"); 
/* 42 */     if (paramArrayOfString == null) throw new IllegalArgumentException("null classes"); 
/* 43 */     this.mContext = paramElementContext;
/* 44 */     this.mClassNames = paramArrayOfString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JamClassLoader getClassLoader() {
/* 51 */     return this.mContext.getClassLoader();
/*    */   }
/*    */   
/*    */   public String[] getClassNames() {
/* 55 */     return this.mClassNames;
/*    */   }
/*    */   
/*    */   public JamClassIterator getClasses() {
/* 59 */     return new JamClassIterator(getClassLoader(), getClassNames());
/*    */   }
/*    */   
/*    */   public JClass[] getAllClasses() {
/* 63 */     JClass[] arrayOfJClass = new JClass[this.mClassNames.length];
/* 64 */     for (byte b = 0; b < arrayOfJClass.length; b++) {
/* 65 */       arrayOfJClass[b] = getClassLoader().loadClass(this.mClassNames[b]);
/*    */     }
/* 67 */     return arrayOfJClass;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setClassNames(String[] paramArrayOfString) {
/* 77 */     this.mClassNames = paramArrayOfString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\JamServiceImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */