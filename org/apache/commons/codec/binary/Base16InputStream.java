/*    */ package org.apache.commons.codec.binary;
/*    */ 
/*    */ import java.io.InputStream;
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
/*    */ public class Base16InputStream
/*    */   extends BaseNCodecInputStream
/*    */ {
/*    */   public Base16InputStream(InputStream paramInputStream) {
/* 41 */     this(paramInputStream, false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Base16InputStream(InputStream paramInputStream, boolean paramBoolean) {
/* 52 */     this(paramInputStream, paramBoolean, false);
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
/*    */   public Base16InputStream(InputStream paramInputStream, boolean paramBoolean1, boolean paramBoolean2) {
/* 65 */     this(paramInputStream, paramBoolean1, paramBoolean2, CodecPolicy.LENIENT);
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
/*    */   public Base16InputStream(InputStream paramInputStream, boolean paramBoolean1, boolean paramBoolean2, CodecPolicy paramCodecPolicy) {
/* 79 */     super(paramInputStream, new Base16(paramBoolean2, paramCodecPolicy), paramBoolean1);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\binary\Base16InputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */