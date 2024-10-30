/*    */ package org.apache.xmlbeans.impl.jam.provider;
/*    */ 
/*    */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
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
/*    */ public class CompositeJamClassBuilder
/*    */   extends JamClassBuilder
/*    */ {
/*    */   private JamClassBuilder[] mBuilders;
/*    */   
/*    */   public CompositeJamClassBuilder(JamClassBuilder[] paramArrayOfJamClassBuilder) {
/* 37 */     if (paramArrayOfJamClassBuilder == null) throw new IllegalArgumentException("null builders"); 
/* 38 */     this.mBuilders = paramArrayOfJamClassBuilder;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void init(ElementContext paramElementContext) {
/* 45 */     for (byte b = 0; b < this.mBuilders.length; ) { this.mBuilders[b].init(paramElementContext); b++; }
/*    */   
/*    */   }
/*    */   public MClass build(String paramString1, String paramString2) {
/* 49 */     MClass mClass = null;
/* 50 */     for (byte b = 0; b < this.mBuilders.length; b++) {
/* 51 */       mClass = this.mBuilders[b].build(paramString1, paramString2);
/* 52 */       if (mClass != null) return mClass; 
/*    */     } 
/* 54 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\provider\CompositeJamClassBuilder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */