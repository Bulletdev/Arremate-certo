/*     */ package com.sun.jna.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XAttrUtil
/*     */ {
/*     */   public static List<String> listXAttr(String paramString) {
/*  38 */     long l1 = XAttr.INSTANCE.listxattr(paramString, null, 0L, 0);
/*     */     
/*  40 */     if (l1 < 0L) {
/*  41 */       return null;
/*     */     }
/*  43 */     if (l1 == 0L) {
/*  44 */       return new ArrayList<String>(0);
/*     */     }
/*  46 */     Memory memory = new Memory(l1);
/*  47 */     long l2 = XAttr.INSTANCE.listxattr(paramString, (Pointer)memory, l1, 0);
/*     */     
/*  49 */     if (l2 < 0L) {
/*  50 */       return null;
/*     */     }
/*  52 */     return decodeStringSequence(memory.getByteBuffer(0L, l2));
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getXAttr(String paramString1, String paramString2) {
/*  57 */     long l1 = XAttr.INSTANCE.getxattr(paramString1, paramString2, null, 0L, 0, 0);
/*     */     
/*  59 */     if (l1 < 0L) {
/*  60 */       return null;
/*     */     }
/*     */     
/*  63 */     if (l1 == 0L) {
/*  64 */       return "";
/*     */     }
/*     */     
/*  67 */     Memory memory = new Memory(l1);
/*  68 */     memory.clear();
/*  69 */     long l2 = XAttr.INSTANCE.getxattr(paramString1, paramString2, (Pointer)memory, l1, 0, 0);
/*     */     
/*  71 */     if (l2 < 0L) {
/*  72 */       return null;
/*     */     }
/*     */     
/*  75 */     return Native.toString(memory.getByteArray(0L, (int)l1), "UTF-8");
/*     */   }
/*     */   
/*     */   public static int setXAttr(String paramString1, String paramString2, String paramString3) {
/*  79 */     Memory memory = encodeString(paramString3);
/*  80 */     return XAttr.INSTANCE.setxattr(paramString1, paramString2, (Pointer)memory, memory.size(), 0, 0);
/*     */   }
/*     */   
/*     */   public static int removeXAttr(String paramString1, String paramString2) {
/*  84 */     return XAttr.INSTANCE.removexattr(paramString1, paramString2, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static Memory encodeString(String paramString) {
/*  89 */     byte[] arrayOfByte = paramString.getBytes(Charset.forName("UTF-8"));
/*  90 */     Memory memory = new Memory(arrayOfByte.length);
/*  91 */     memory.write(0L, arrayOfByte, 0, arrayOfByte.length);
/*  92 */     return memory;
/*     */   }
/*     */   
/*     */   protected static String decodeString(ByteBuffer paramByteBuffer) {
/*  96 */     return Charset.forName("UTF-8").decode(paramByteBuffer).toString();
/*     */   }
/*     */   
/*     */   protected static List<String> decodeStringSequence(ByteBuffer paramByteBuffer) {
/* 100 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/* 102 */     paramByteBuffer.mark();
/* 103 */     while (paramByteBuffer.hasRemaining()) {
/* 104 */       if (paramByteBuffer.get() == 0) {
/* 105 */         ByteBuffer byteBuffer = (ByteBuffer)paramByteBuffer.duplicate().limit(paramByteBuffer.position() - 1).reset();
/* 106 */         if (byteBuffer.hasRemaining()) {
/* 107 */           arrayList.add(decodeString(byteBuffer));
/*     */         }
/* 109 */         paramByteBuffer.mark();
/*     */       } 
/*     */     } 
/*     */     
/* 113 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\mac\XAttrUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */