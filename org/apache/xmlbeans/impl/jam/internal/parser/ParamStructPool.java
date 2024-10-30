/*    */ package org.apache.xmlbeans.impl.jam.internal.parser;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
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
/*    */ public class ParamStructPool
/*    */ {
/*    */   private static final boolean VERBOSE = true;
/* 39 */   private List mList = new ArrayList();
/* 40 */   private int mLength = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParametersOn(MInvokable paramMInvokable) {
/* 46 */     for (byte b = 0; b < this.mLength; b++) {
/* 47 */       ParamStruct paramStruct = this.mList.get(b);
/* 48 */       paramStruct.createParameter(paramMInvokable);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void add(String paramString1, String paramString2) {
/* 53 */     this.mLength++;
/* 54 */     if (this.mLength >= this.mList.size()) {
/* 55 */       this.mList.add(new ParamStruct(paramString1, paramString2));
/*    */     } else {
/* 57 */       ((ParamStruct)this.mList.get(this.mLength)).init(paramString1, paramString2);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void clear() {
/* 62 */     this.mLength = 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\parser\ParamStructPool.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */