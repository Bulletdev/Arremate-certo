/*    */ package org.apache.xmlbeans.impl.jam.internal;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*    */ import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
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
/*    */ public class CachedClassBuilder
/*    */   extends JamClassBuilder
/*    */ {
/* 38 */   private Map mQcname2jclass = null;
/* 39 */   private List mClassNames = new ArrayList();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MClass build(String paramString1, String paramString2) {
/* 50 */     if (this.mQcname2jclass == null) return null; 
/* 51 */     if (paramString1.trim().length() > 0) {
/* 52 */       paramString2 = paramString1 + '.' + paramString2;
/*    */     }
/* 54 */     return (MClass)this.mQcname2jclass.get(paramString2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MClass createClassToBuild(String paramString1, String paramString2, String[] paramArrayOfString) {
/*    */     String str;
/* 64 */     if (paramString1.trim().length() > 0) {
/* 65 */       str = paramString1 + '.' + paramString2;
/*    */     } else {
/* 67 */       str = paramString2;
/*    */     } 
/*    */     
/* 70 */     if (this.mQcname2jclass != null) {
/* 71 */       MClass mClass1 = (MClass)this.mQcname2jclass.get(str);
/* 72 */       if (mClass1 != null) return mClass1; 
/*    */     } else {
/* 74 */       this.mQcname2jclass = new HashMap();
/*    */     } 
/* 76 */     MClass mClass = super.createClassToBuild(paramString1, paramString2, paramArrayOfString);
/* 77 */     this.mQcname2jclass.put(str, mClass);
/* 78 */     this.mClassNames.add(str);
/* 79 */     return mClass;
/*    */   }
/*    */   
/*    */   public String[] getClassNames() {
/* 83 */     String[] arrayOfString = new String[this.mClassNames.size()];
/* 84 */     this.mClassNames.toArray((Object[])arrayOfString);
/* 85 */     return arrayOfString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\CachedClassBuilder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */