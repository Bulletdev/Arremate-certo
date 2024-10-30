/*    */ package org.apache.http.impl;
/*    */ 
/*    */ import java.nio.charset.Charset;
/*    */ import java.nio.charset.CharsetDecoder;
/*    */ import java.nio.charset.CharsetEncoder;
/*    */ import java.nio.charset.CodingErrorAction;
/*    */ import org.apache.http.config.ConnectionConfig;
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
/*    */ 
/*    */ public final class ConnSupport
/*    */ {
/*    */   public static CharsetDecoder createDecoder(ConnectionConfig paramConnectionConfig) {
/* 44 */     if (paramConnectionConfig == null) {
/* 45 */       return null;
/*    */     }
/* 47 */     Charset charset = paramConnectionConfig.getCharset();
/* 48 */     CodingErrorAction codingErrorAction1 = paramConnectionConfig.getMalformedInputAction();
/* 49 */     CodingErrorAction codingErrorAction2 = paramConnectionConfig.getUnmappableInputAction();
/* 50 */     if (charset != null) {
/* 51 */       return charset.newDecoder().onMalformedInput((codingErrorAction1 != null) ? codingErrorAction1 : CodingErrorAction.REPORT).onUnmappableCharacter((codingErrorAction2 != null) ? codingErrorAction2 : CodingErrorAction.REPORT);
/*    */     }
/*    */ 
/*    */     
/* 55 */     return null;
/*    */   }
/*    */   
/*    */   public static CharsetEncoder createEncoder(ConnectionConfig paramConnectionConfig) {
/* 59 */     if (paramConnectionConfig == null) {
/* 60 */       return null;
/*    */     }
/* 62 */     Charset charset = paramConnectionConfig.getCharset();
/* 63 */     if (charset != null) {
/* 64 */       CodingErrorAction codingErrorAction1 = paramConnectionConfig.getMalformedInputAction();
/* 65 */       CodingErrorAction codingErrorAction2 = paramConnectionConfig.getUnmappableInputAction();
/* 66 */       return charset.newEncoder().onMalformedInput((codingErrorAction1 != null) ? codingErrorAction1 : CodingErrorAction.REPORT).onUnmappableCharacter((codingErrorAction2 != null) ? codingErrorAction2 : CodingErrorAction.REPORT);
/*    */     } 
/*    */ 
/*    */     
/* 70 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\ConnSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */