/*    */ package org.apache.poi.ss.formula.function;
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
/*    */ public final class FunctionMetadata
/*    */ {
/*    */   private static final short FUNCTION_MAX_PARAMS = 30;
/*    */   private final int _index;
/*    */   private final String _name;
/*    */   private final int _minParams;
/*    */   private final int _maxParams;
/*    */   private final byte _returnClassCode;
/*    */   private final byte[] _parameterClassCodes;
/*    */   
/*    */   FunctionMetadata(int paramInt1, String paramString, int paramInt2, int paramInt3, byte paramByte, byte[] paramArrayOfbyte) {
/* 45 */     this._index = paramInt1;
/* 46 */     this._name = paramString;
/* 47 */     this._minParams = paramInt2;
/* 48 */     this._maxParams = paramInt3;
/* 49 */     this._returnClassCode = paramByte;
/* 50 */     this._parameterClassCodes = paramArrayOfbyte;
/*    */   }
/*    */   public int getIndex() {
/* 53 */     return this._index;
/*    */   }
/*    */   public String getName() {
/* 56 */     return this._name;
/*    */   }
/*    */   public int getMinParams() {
/* 59 */     return this._minParams;
/*    */   }
/*    */   public int getMaxParams() {
/* 62 */     return this._maxParams;
/*    */   }
/*    */   public boolean hasFixedArgsLength() {
/* 65 */     return (this._minParams == this._maxParams);
/*    */   }
/*    */   public byte getReturnClassCode() {
/* 68 */     return this._returnClassCode;
/*    */   }
/*    */   public byte[] getParameterClassCodes() {
/* 71 */     return (byte[])this._parameterClassCodes.clone();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hasUnlimitedVarags() {
/* 81 */     return (30 == this._maxParams);
/*    */   }
/*    */   public String toString() {
/* 84 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 85 */     stringBuffer.append(getClass().getName()).append(" [");
/* 86 */     stringBuffer.append(this._index).append(" ").append(this._name);
/* 87 */     stringBuffer.append("]");
/* 88 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\function\FunctionMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */