/*     */ package org.apache.poi.hssf.record.cont;
/*     */ 
/*     */ import org.apache.poi.util.DelayableLittleEndianOutput;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ public final class ContinuableRecordOutput
/*     */   implements LittleEndianOutput
/*     */ {
/*     */   private final LittleEndianOutput _out;
/*     */   private UnknownLengthRecordOutput _ulrOutput;
/*     */   private int _totalPreviousRecordsSize;
/*     */   
/*     */   public ContinuableRecordOutput(LittleEndianOutput paramLittleEndianOutput, int paramInt) {
/*  37 */     this._ulrOutput = new UnknownLengthRecordOutput(paramLittleEndianOutput, paramInt);
/*  38 */     this._out = paramLittleEndianOutput;
/*  39 */     this._totalPreviousRecordsSize = 0;
/*     */   }
/*     */   
/*     */   public static ContinuableRecordOutput createForCountingOnly() {
/*  43 */     return new ContinuableRecordOutput(NOPOutput, -777);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalSize() {
/*  50 */     return this._totalPreviousRecordsSize + this._ulrOutput.getTotalSize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void terminate() {
/*  56 */     this._ulrOutput.terminate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAvailableSpace() {
/*  62 */     return this._ulrOutput.getAvailableSpace();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeContinue() {
/*  70 */     this._ulrOutput.terminate();
/*  71 */     this._totalPreviousRecordsSize += this._ulrOutput.getTotalSize();
/*  72 */     this._ulrOutput = new UnknownLengthRecordOutput(this._out, 60);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeContinueIfRequired(int paramInt) {
/*  80 */     if (this._ulrOutput.getAvailableSpace() < paramInt) {
/*  81 */       writeContinue();
/*     */     }
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
/*     */ 
/*     */   
/*     */   public void writeStringData(String paramString) {
/* 103 */     boolean bool = StringUtil.hasMultibyte(paramString);
/*     */     
/* 105 */     byte b = 2;
/* 106 */     int i = 0;
/* 107 */     if (bool) {
/* 108 */       i |= 0x1;
/* 109 */       b++;
/*     */     } 
/* 111 */     writeContinueIfRequired(b);
/* 112 */     writeByte(i);
/* 113 */     writeCharacterData(paramString, bool);
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
/*     */   public void writeString(String paramString, int paramInt1, int paramInt2) {
/* 142 */     boolean bool = StringUtil.hasMultibyte(paramString);
/*     */     
/* 144 */     byte b = 4;
/* 145 */     int i = 0;
/* 146 */     if (bool) {
/* 147 */       i |= 0x1;
/* 148 */       b++;
/*     */     } 
/* 150 */     if (paramInt1 > 0) {
/* 151 */       i |= 0x8;
/* 152 */       b += 2;
/*     */     } 
/* 154 */     if (paramInt2 > 0) {
/* 155 */       i |= 0x4;
/* 156 */       b += 4;
/*     */     } 
/* 158 */     writeContinueIfRequired(b);
/* 159 */     writeShort(paramString.length());
/* 160 */     writeByte(i);
/* 161 */     if (paramInt1 > 0) {
/* 162 */       writeShort(paramInt1);
/*     */     }
/* 164 */     if (paramInt2 > 0) {
/* 165 */       writeInt(paramInt2);
/*     */     }
/* 167 */     writeCharacterData(paramString, bool);
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeCharacterData(String paramString, boolean paramBoolean) {
/* 172 */     int i = paramString.length();
/* 173 */     byte b = 0;
/* 174 */     if (paramBoolean) {
/*     */       while (true) {
/* 176 */         int j = Math.min(i - b, this._ulrOutput.getAvailableSpace() / 2);
/* 177 */         for (; j > 0; j--) {
/* 178 */           this._ulrOutput.writeShort(paramString.charAt(b++));
/*     */         }
/* 180 */         if (b >= i) {
/*     */           break;
/*     */         }
/* 183 */         writeContinue();
/* 184 */         writeByte(1);
/*     */       } 
/*     */     } else {
/*     */       while (true) {
/* 188 */         int j = Math.min(i - b, this._ulrOutput.getAvailableSpace() / 1);
/* 189 */         for (; j > 0; j--) {
/* 190 */           this._ulrOutput.writeByte(paramString.charAt(b++));
/*     */         }
/* 192 */         if (b >= i) {
/*     */           break;
/*     */         }
/* 195 */         writeContinue();
/* 196 */         writeByte(0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) {
/* 202 */     writeContinueIfRequired(paramArrayOfbyte.length);
/* 203 */     this._ulrOutput.write(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 208 */     byte b = 0;
/*     */     while (true) {
/* 210 */       int i = Math.min(paramInt2 - b, this._ulrOutput.getAvailableSpace() / 1);
/* 211 */       for (; i > 0; i--) {
/* 212 */         this._ulrOutput.writeByte(paramArrayOfbyte[paramInt1 + b++]);
/*     */       }
/* 214 */       if (b >= paramInt2) {
/*     */         break;
/*     */       }
/* 217 */       writeContinue();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void writeByte(int paramInt) {
/* 222 */     writeContinueIfRequired(1);
/* 223 */     this._ulrOutput.writeByte(paramInt);
/*     */   }
/*     */   public void writeDouble(double paramDouble) {
/* 226 */     writeContinueIfRequired(8);
/* 227 */     this._ulrOutput.writeDouble(paramDouble);
/*     */   }
/*     */   public void writeInt(int paramInt) {
/* 230 */     writeContinueIfRequired(4);
/* 231 */     this._ulrOutput.writeInt(paramInt);
/*     */   }
/*     */   public void writeLong(long paramLong) {
/* 234 */     writeContinueIfRequired(8);
/* 235 */     this._ulrOutput.writeLong(paramLong);
/*     */   }
/*     */   public void writeShort(int paramInt) {
/* 238 */     writeContinueIfRequired(2);
/* 239 */     this._ulrOutput.writeShort(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 245 */   private static final LittleEndianOutput NOPOutput = (LittleEndianOutput)new DelayableLittleEndianOutput()
/*     */     {
/*     */       public LittleEndianOutput createDelayedOutput(int param1Int) {
/* 248 */         return (LittleEndianOutput)this;
/*     */       }
/*     */       
/*     */       public void write(byte[] param1ArrayOfbyte) {}
/*     */       
/*     */       public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {}
/*     */       
/*     */       public void writeByte(int param1Int) {}
/*     */       
/*     */       public void writeDouble(double param1Double) {}
/*     */       
/*     */       public void writeInt(int param1Int) {}
/*     */       
/*     */       public void writeLong(long param1Long) {}
/*     */       
/*     */       public void writeShort(int param1Int) {}
/*     */     };
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cont\ContinuableRecordOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */