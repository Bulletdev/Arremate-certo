/*    */ package org.apache.commons.codec.binary;
/*    */ 
/*    */ import java.io.OutputStream;
/*    */ import org.apache.commons.codec.CodecPolicy;
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
/*    */ public class Base16OutputStream
/*    */   extends BaseNCodecOutputStream
/*    */ {
/*    */   public Base16OutputStream(OutputStream paramOutputStream) {
/* 41 */     this(paramOutputStream, true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Base16OutputStream(OutputStream paramOutputStream, boolean paramBoolean) {
/* 52 */     this(paramOutputStream, paramBoolean, false);
/*    */   }
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
/*    */   public Base16OutputStream(OutputStream paramOutputStream, boolean paramBoolean1, boolean paramBoolean2) {
/* 65 */     this(paramOutputStream, paramBoolean1, paramBoolean2, CodecPolicy.LENIENT);
/*    */   }
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
/*    */   public Base16OutputStream(OutputStream paramOutputStream, boolean paramBoolean1, boolean paramBoolean2, CodecPolicy paramCodecPolicy) {
/* 79 */     super(paramOutputStream, new Base16(paramBoolean2, paramCodecPolicy), paramBoolean1);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\binary\Base16OutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */