/*    */ package org.apache.xmlbeans.impl.jam.internal.parser;
/*    */ 
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MParameter;
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
/*    */ class ParamStruct
/*    */ {
/*    */   private String mName;
/*    */   private String mType;
/*    */   
/*    */   public ParamStruct(String paramString1, String paramString2) {
/* 36 */     init(paramString1, paramString2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void init(String paramString1, String paramString2) {
/* 43 */     this.mType = paramString1;
/* 44 */     this.mName = paramString2;
/*    */   }
/*    */   
/*    */   public MParameter createParameter(MInvokable paramMInvokable) {
/* 48 */     if (paramMInvokable == null) throw new IllegalArgumentException("null invokable"); 
/* 49 */     MParameter mParameter = paramMInvokable.addNewParameter();
/* 50 */     mParameter.setSimpleName(this.mName);
/* 51 */     mParameter.setUnqualifiedType(this.mType);
/* 52 */     return mParameter;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\parser\ParamStruct.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */