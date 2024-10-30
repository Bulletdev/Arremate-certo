/*    */ package org.apache.poi.hpsf;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.poi.util.LittleEndian;
/*    */ import org.apache.poi.util.POILogFactory;
/*    */ import org.apache.poi.util.POILogger;
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
/*    */ @Internal
/*    */ class ClipboardData
/*    */ {
/* 30 */   private static final POILogger logger = POILogFactory.getLogger(ClipboardData.class);
/*    */   
/*    */   private int _format;
/*    */   
/*    */   private byte[] _value;
/*    */ 
/*    */   
/*    */   ClipboardData(byte[] paramArrayOfbyte, int paramInt) {
/* 38 */     int i = LittleEndian.getInt(paramArrayOfbyte, paramInt);
/*    */     
/* 40 */     if (i < 4) {
/*    */       
/* 42 */       logger.log(5, new Object[] { "ClipboardData at offset ", Integer.valueOf(paramInt), " size less than 4 bytes (doesn't even have format field!). Setting to format == 0 and hope for the best" });
/*    */ 
/*    */ 
/*    */       
/* 46 */       this._format = 0;
/* 47 */       this._value = new byte[0];
/*    */       
/*    */       return;
/*    */     } 
/* 51 */     this._format = LittleEndian.getInt(paramArrayOfbyte, paramInt + 4);
/* 52 */     this._value = LittleEndian.getByteArray(paramArrayOfbyte, paramInt + 8, i - 4);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   int getSize() {
/* 58 */     return 8 + this._value.length;
/*    */   }
/*    */ 
/*    */   
/*    */   byte[] getValue() {
/* 63 */     return this._value;
/*    */   }
/*    */ 
/*    */   
/*    */   byte[] toByteArray() {
/* 68 */     byte[] arrayOfByte = new byte[getSize()];
/* 69 */     LittleEndian.putInt(arrayOfByte, 0, 4 + this._value.length);
/*    */     
/* 71 */     LittleEndian.putInt(arrayOfByte, 4, this._format);
/* 72 */     System.arraycopy(this._value, 0, arrayOfByte, 8, this._value.length);
/*    */     
/* 74 */     return arrayOfByte;
/*    */   }
/*    */ 
/*    */   
/*    */   int write(OutputStream paramOutputStream) throws IOException {
/* 79 */     LittleEndian.putInt(4 + this._value.length, paramOutputStream);
/* 80 */     LittleEndian.putInt(this._format, paramOutputStream);
/* 81 */     paramOutputStream.write(this._value);
/* 82 */     return 8 + this._value.length;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\ClipboardData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */