/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ public final class EscherArrayProperty
/*     */   extends EscherComplexProperty
/*     */   implements Iterable<byte[]>
/*     */ {
/*     */   private static final int FIXED_SIZE = 6;
/*     */   private boolean sizeIncludesHeaderSize = true;
/*     */   private boolean emptyComplexPart = false;
/*     */   
/*     */   public EscherArrayProperty(short paramShort, byte[] paramArrayOfbyte) {
/*  49 */     super(paramShort, checkComplexData(paramArrayOfbyte));
/*  50 */     this.emptyComplexPart = (paramArrayOfbyte.length == 0);
/*     */   }
/*     */   
/*     */   public EscherArrayProperty(short paramShort, boolean paramBoolean, byte[] paramArrayOfbyte) {
/*  54 */     super(paramShort, paramBoolean, checkComplexData(paramArrayOfbyte));
/*     */   }
/*     */   
/*     */   private static byte[] checkComplexData(byte[] paramArrayOfbyte) {
/*  58 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/*  59 */       return new byte[6];
/*     */     }
/*     */     
/*  62 */     return paramArrayOfbyte;
/*     */   }
/*     */   
/*     */   public int getNumberOfElementsInArray() {
/*  66 */     return this.emptyComplexPart ? 0 : LittleEndian.getUShort(this._complexData, 0);
/*     */   }
/*     */   
/*     */   public void setNumberOfElementsInArray(int paramInt) {
/*  70 */     int i = paramInt * getActualSizeOfElements(getSizeOfElements()) + 6;
/*  71 */     if (i != this._complexData.length) {
/*  72 */       byte[] arrayOfByte = new byte[i];
/*  73 */       System.arraycopy(this._complexData, 0, arrayOfByte, 0, this._complexData.length);
/*  74 */       this._complexData = arrayOfByte;
/*     */     } 
/*  76 */     LittleEndian.putShort(this._complexData, 0, (short)paramInt);
/*     */   }
/*     */   
/*     */   public int getNumberOfElementsInMemory() {
/*  80 */     return this.emptyComplexPart ? 0 : LittleEndian.getUShort(this._complexData, 2);
/*     */   }
/*     */   
/*     */   public void setNumberOfElementsInMemory(int paramInt) {
/*  84 */     int i = paramInt * getActualSizeOfElements(getSizeOfElements()) + 6;
/*  85 */     if (i != this._complexData.length) {
/*  86 */       byte[] arrayOfByte = new byte[i];
/*  87 */       System.arraycopy(this._complexData, 0, arrayOfByte, 0, i);
/*  88 */       this._complexData = arrayOfByte;
/*     */     } 
/*  90 */     LittleEndian.putShort(this._complexData, 2, (short)paramInt);
/*     */   }
/*     */   
/*     */   public short getSizeOfElements() {
/*  94 */     return this.emptyComplexPart ? 0 : LittleEndian.getShort(this._complexData, 4);
/*     */   }
/*     */   
/*     */   public void setSizeOfElements(int paramInt) {
/*  98 */     LittleEndian.putShort(this._complexData, 4, (short)paramInt);
/*     */     
/* 100 */     int i = getNumberOfElementsInArray() * getActualSizeOfElements(getSizeOfElements()) + 6;
/* 101 */     if (i != this._complexData.length) {
/*     */       
/* 103 */       byte[] arrayOfByte = new byte[i];
/* 104 */       System.arraycopy(this._complexData, 0, arrayOfByte, 0, 6);
/* 105 */       this._complexData = arrayOfByte;
/*     */     } 
/*     */   }
/*     */   
/*     */   public byte[] getElement(int paramInt) {
/* 110 */     int i = getActualSizeOfElements(getSizeOfElements());
/* 111 */     byte[] arrayOfByte = new byte[i];
/* 112 */     System.arraycopy(this._complexData, 6 + paramInt * i, arrayOfByte, 0, arrayOfByte.length);
/* 113 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   public void setElement(int paramInt, byte[] paramArrayOfbyte) {
/* 117 */     int i = getActualSizeOfElements(getSizeOfElements());
/* 118 */     System.arraycopy(paramArrayOfbyte, 0, this._complexData, 6 + paramInt * i, i);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuffer stringBuffer = new StringBuffer();
/* 124 */     stringBuffer.append("    {EscherArrayProperty:\n");
/* 125 */     stringBuffer.append("     Num Elements: " + getNumberOfElementsInArray() + '\n');
/* 126 */     stringBuffer.append("     Num Elements In Memory: " + getNumberOfElementsInMemory() + '\n');
/* 127 */     stringBuffer.append("     Size of elements: " + getSizeOfElements() + '\n');
/* 128 */     for (byte b = 0; b < getNumberOfElementsInArray(); b++) {
/* 129 */       stringBuffer.append("     Element " + b + ": " + HexDump.toHex(getElement(b)) + '\n');
/*     */     }
/* 131 */     stringBuffer.append("}\n");
/*     */     
/* 133 */     return "propNum: " + getPropertyNumber() + ", propName: " + EscherProperties.getPropertyName(getPropertyNumber()) + ", complex: " + isComplex() + ", blipId: " + isBlipId() + ", data: " + '\n' + stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toXml(String paramString) {
/* 142 */     StringBuilder stringBuilder = new StringBuilder();
/* 143 */     stringBuilder.append(paramString).append("<").append(getClass().getSimpleName()).append(" id=\"0x").append(HexDump.toHex(getId())).append("\" name=\"").append(getName()).append("\" blipId=\"").append(isBlipId()).append("\">\n");
/*     */ 
/*     */     
/* 146 */     for (byte b = 0; b < getNumberOfElementsInArray(); b++) {
/* 147 */       stringBuilder.append("\t").append(paramString).append("<Element>").append(HexDump.toHex(getElement(b))).append("</Element>\n");
/*     */     }
/* 149 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 150 */     return stringBuilder.toString();
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
/*     */   public int setArrayData(byte[] paramArrayOfbyte, int paramInt) {
/* 164 */     if (this.emptyComplexPart) {
/* 165 */       this._complexData = new byte[0];
/*     */     } else {
/* 167 */       short s1 = LittleEndian.getShort(paramArrayOfbyte, paramInt);
/*     */       
/* 169 */       short s2 = LittleEndian.getShort(paramArrayOfbyte, paramInt + 4);
/*     */       
/* 171 */       int i = getActualSizeOfElements(s2) * s1;
/* 172 */       if (i == this._complexData.length) {
/*     */         
/* 174 */         this._complexData = new byte[i + 6];
/* 175 */         this.sizeIncludesHeaderSize = false;
/*     */       } 
/* 177 */       System.arraycopy(paramArrayOfbyte, paramInt, this._complexData, 0, this._complexData.length);
/*     */     } 
/* 179 */     return this._complexData.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int serializeSimplePart(byte[] paramArrayOfbyte, int paramInt) {
/* 190 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getId());
/* 191 */     int i = this._complexData.length;
/* 192 */     if (!this.sizeIncludesHeaderSize) {
/* 193 */       i -= 6;
/*     */     }
/* 195 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 2, i);
/* 196 */     return 6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getActualSizeOfElements(short paramShort) {
/* 204 */     if (paramShort < 0) {
/* 205 */       return (short)(-paramShort >> 2);
/*     */     }
/* 207 */     return paramShort;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<byte[]> iterator() {
/* 212 */     return new Iterator<byte[]>() {
/* 213 */         int idx = 0;
/*     */         
/*     */         public boolean hasNext() {
/* 216 */           return (this.idx < EscherArrayProperty.this.getNumberOfElementsInArray());
/*     */         }
/*     */ 
/*     */         
/*     */         public byte[] next() {
/* 221 */           if (!hasNext()) throw new NoSuchElementException(); 
/* 222 */           return EscherArrayProperty.this.getElement(this.idx++);
/*     */         }
/*     */ 
/*     */         
/*     */         public void remove() {
/* 227 */           throw new UnsupportedOperationException("not yet implemented");
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherArrayProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */