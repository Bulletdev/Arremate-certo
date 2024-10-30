/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
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
/*     */ public class MutableProperty
/*     */   extends Property
/*     */ {
/*     */   public MutableProperty() {}
/*     */   
/*     */   public MutableProperty(Property paramProperty) {
/*  51 */     setID(paramProperty.getID());
/*  52 */     setType(paramProperty.getType());
/*  53 */     setValue(paramProperty.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setID(long paramLong) {
/*  64 */     this.id = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(long paramLong) {
/*  76 */     this.type = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(Object paramObject) {
/*  88 */     this.value = paramObject;
/*     */   }
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
/*     */   public int write(OutputStream paramOutputStream, int paramInt) throws IOException, WritingNotSupportedException {
/* 107 */     int i = 0;
/* 108 */     long l = getType();
/*     */ 
/*     */     
/* 111 */     if (paramInt == 1200 && l == 30L) {
/* 112 */       l = 31L;
/*     */     }
/* 114 */     i += TypeWriter.writeUIntToStream(paramOutputStream, l);
/* 115 */     i += VariantSupport.write(paramOutputStream, l, getValue(), paramInt);
/* 116 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\MutableProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */