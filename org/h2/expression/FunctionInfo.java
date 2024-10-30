/*    */ package org.h2.expression;
/*    */ 
/*    */ class FunctionInfo {
/*    */   String name;
/*    */   int type;
/*    */   int dataType;
/*    */   int parameterCount;
/*    */   boolean nullIfParameterIsNull;
/*    */   boolean deterministic;
/*    */   boolean bufferResultSetToLocalTemp = true;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\FunctionInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */